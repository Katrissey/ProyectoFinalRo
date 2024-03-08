package es.curso.java.proyectofinal.daos;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.curso.java.proyectofinal.entities.UsuariosProFinal;
import es.curso.java.proyectofinal.enums.UsuariosEnum;
import es.curso.java.proyectofinal.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class UsuariosDAOproFinal {
	
	private static final Logger logger = LogManager.getLogger(UsuariosDAOproFinal.class);
	private static EntityManager em;

	public UsuariosDAOproFinal() {
		em = JpaUtil.getEM("ConexionOracleHibernate");
	}
	
	public UsuariosDAOproFinal(String persitenceUnitName) {
		em = JpaUtil.getEM(persitenceUnitName);
	}
	
	
	public static void cargaInicial() {
		logger.debug("Empezando la carga inicial de datos");

		UsuariosEnum[] usuariosEnum = UsuariosEnum.values();
		try {
			em.getTransaction().begin();
			for (UsuariosEnum usuarioEnum : usuariosEnum) {
				UsuariosProFinal usuariopf = new UsuariosProFinal(usuarioEnum.getNombre(), 
						usuarioEnum.getApellidos(), usuarioEnum.getDni(),
						usuarioEnum.getSexo(), usuarioEnum.getContraseña(),
						usuarioEnum.getMail(), usuarioEnum.getTelefono(),
						usuarioEnum.getFechaNacimiento(), usuarioEnum.getRoles());
				em.persist(usuariopf);
				
				System.out.println (usuariopf);

			}
			em.getTransaction().commit();

		} catch (Exception e) {
			logger.error("Error al insertar usuarios " + e.getMessage());
			em.getTransaction().rollback();
		}
		

		logger.debug("Termina la carga inicial de datos");
	}

	public static List<UsuariosProFinal> listarUsuariosPF() {
		logger.debug("Listando usuarios");
		List<UsuariosProFinal> usuariosPF = em.createQuery("from UsuariosProFinal", UsuariosProFinal.class).getResultList();
//		usuariosPF.forEach(usuarioPf -> logger.trace(usuarioPf));
		for (UsuariosProFinal usuarioPf : usuariosPF) {
			logger.trace(usuarioPf);
			
		}

		logger.debug("Numero de usuarios" + usuariosPF.size());
		return usuariosPF;
	}

	public static UsuariosProFinal buscarPorId(Long id) {
		logger.debug("buscando usuario por Id " + id);
		UsuariosProFinal usuarioPf = em.find(UsuariosProFinal.class, id);

		logger.debug("Usuario encontrado " + usuarioPf);
		return usuarioPf;
	}

	public static UsuariosProFinal buscarPorDni(String dni) {
		logger.debug("buscando usuario por Dni " + dni);
		Query query = em.createQuery("from UsuariosProFinal upf where upf.dni=?1", UsuariosProFinal.class);
		query.setParameter(1, dni);

		UsuariosProFinal usuarioPf = null;
		try {
			usuarioPf = (UsuariosProFinal) query.getSingleResult();
		}catch(NoResultException nre) {
			logger.error("No se ha econtrado al usuario con Dni "+ dni);
		}
		
		return usuarioPf;

	}
	
	public List<UsuariosProFinal> getUsuariosPF (){
		List<UsuariosProFinal> usuariosPF;
		
		usuariosPF = em.createQuery("from UsuariosProFinal", UsuariosProFinal.class).getResultList();
		
		return usuariosPF;
	}
	
	public List<UsuariosProFinal> getUsuariosPorNombre (String name){
		List<UsuariosProFinal> usuariosPF;
		
		Query query = em.createQuery(
				"from UsuariosProFinal upf where upf.nombre=?1", UsuariosProFinal.class);
		
		
		query.setParameter(1, name);
		usuariosPF = query.getResultList();
		
		return usuariosPF;
	}
	
	public List<UsuariosProFinal> getUsuariosPorFechaNacimiento (Date fechaNacimiento){
		List<UsuariosProFinal> usuariosPF;
		
		Query query = em.createQuery(
				"from UsuariosProFinal upf where upf.fechaNacimiento>=?1", 
				UsuariosProFinal.class);
		
		query.setParameter(1, fechaNacimiento);
		usuariosPF = query.getResultList();
		
		return usuariosPF;
	}
	
	public void insertarUsuarioPf (UsuariosProFinal usuarioPf) {
		 em.getTransaction().begin();
		 try {
			 em.persist(usuarioPf);
			 
			 em.getTransaction().commit();
		 }catch(Exception e) {
			 em.getTransaction().rollback();
		 }
	     
	}
	
	public void insertarUsuariosPf (List<UsuariosProFinal> usuariosPf) {
		 em.getTransaction().begin();
		 try {
			 
			for (UsuariosProFinal usuarioPf : usuariosPf) {
				 em.persist(usuarioPf);
			}
			 
			em.getTransaction().commit();
		 }catch(Exception e) {
			 em.getTransaction().rollback();
		 }
	     
	}
	
	
	public void borrarUsuarioPorNombre (String nombre) {
		 em.getTransaction().begin();
		 try {
			List<UsuariosProFinal> usuariosPF = getUsuariosPorNombre(nombre);
            
            for (UsuariosProFinal usuarioPf : usuariosPF) {
            	em.remove(usuarioPf);
			}
            
            em.getTransaction().commit();
		 }catch(Exception e) {
			 em.getTransaction().rollback();
		 }
	     
	}
	
	public void modificarUsuarioPorDni (String dni, UsuariosProFinal usuarioModificado) {
		
		TypedQuery<UsuariosProFinal> query = em.createQuery(
				"from UsuariosProFinal where dni=?1",
				UsuariosProFinal.class);
		query.setParameter(1, dni);
		
		try {
			UsuariosProFinal usuarioPf = query.getSingleResult();
			em.getTransaction().begin();
			usuarioPf.setNombre(usuarioModificado.getNombre());
			usuarioPf.setApellidos(usuarioModificado.getApellidos());
			usuarioPf.setFechaNacimiento(usuarioModificado.getFechaNacimiento());

			em.merge(usuarioPf);
			
			em.getTransaction().commit();
		}catch (NoResultException nre) {
			System.out.println("Dni "+dni+ " no encontrado");
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
}
