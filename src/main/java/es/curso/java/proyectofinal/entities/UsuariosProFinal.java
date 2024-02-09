package es.curso.java.proyectofinal.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table (name = "TB_USUARIOS_PRO_FINAL")
public class UsuariosProFinal implements Serializable {
	@Id
	@SequenceGenerator (name = "USUARIOGEN", sequenceName = "USUARIO_GEN", initialValue =1, allocationSize = 1)
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "USUARIOGEN")
	@Column (name = "ID", nullable = false, updatable = false)
	private long id;
	
	@Column (name = "NOMBRE_USUARIO", length = 40)
	private String nombre;
	
	@Column (name = "APELLIDOS", length = 80)
	private String apellidos;
	
	@Column (name = "DNI", length = 10, unique = true)
	private String dni;
	
	//@Column (name = "SEXO",  = "Hombre, Mujer, Otro")
	private String sexo;

	
	
	
	/*
	 * contraseña con restricciones
	 * email
	 * telefono
	 * fechaNacimiento
	 * role (administrador o usuario)
	 * 
	 */
	
@Override
public String toString() {
	return "UsuariosProFinal [id=" + id + ", " + (nombre != null ? "nombre=" + nombre + ", " : "")
			+ (apellidos != null ? "apellidos=" + apellidos + ", " : "") + (dni != null ? "dni=" + dni + ", " : "")
			+ (sexo != null ? "sexo=" + sexo : "") + "]";
}
	
}
