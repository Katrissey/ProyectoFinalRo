package es.curso.java.proyectofinal;

import es.curso.java.proyectofinal.daos.UsuariosDAOproFinal;

public class UsuariosMAINproFinal {

	public static void main(String[] args) {
		/* Al tener servlets para el login y para el ingreso y modificación de usuarios en la base de datos conectado a la parte web,
		 * emplearé este main tan sólo para ingresar los primeros usuarios en la base de datos a partir de los usuarios del Enum
		 *  y para hacer pruebas  de los DAOs.
		 */
		UsuariosDAOproFinal udpf = new UsuariosDAOproFinal ("ConexionOracleHibernate");
		
		udpf.cargaInicial();

	}

}
