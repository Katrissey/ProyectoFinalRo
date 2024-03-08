package es.curso.java.proyectofinal.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import es.curso.java.proyectofinal.daos.UsuariosDAOproFinal;
import es.curso.java.proyectofinal.entities.UsuariosProFinal;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;


/**
 * Servlet implementation class ServletGestionUsuarios
 */
public class ServletGestionUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<UsuariosProFinal> usuarios; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		usuarios = new ArrayList(); 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UsuariosDAOproFinal udpf = new UsuariosDAOproFinal ("ConexionOracleHibernate");
		
		//Realizo la carga iunicial de usuarios registrados a la base de datos, tomados de un archivo enum
		udpf.cargaInicial();
		
		//Recojo los datos de cada usuario nuevo registrado en el formulario
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String dni = request.getParameter("dni");
		String sexo = request.getParameter("sexo");
		String contrasenia = request.getParameter("contraseña");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String fechaNacimiento = request.getParameter("fechaNacimiento");
		String roles = request.getParameter("roles");
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		Date fechaNacimientoDate = null;
		try {
			fechaNacimientoDate = formato.parse(fechaNacimiento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int numTelefono = Integer.parseInt(telefono);
		
		//Tomo los datos del formulario para crear un objeto alumno con ellos y así poder después añadirlo a la lista de usuarios y a la base de datos
		UsuariosProFinal usuario = new UsuariosProFinal (nombre,apellidos,dni,sexo,contrasenia,email,numTelefono,fechaNacimientoDate,roles);
		
		//Añado al usuario registrado ahora creado, en la lista de usuarios
		usuarios.add(usuario);
		
		//Asimismo, añado dicho usuario a la base de datos
		udpf.insertarUsuarioPf (usuario);
		
		

		request.setAttribute("atributoListadoUsuarios", usuarios);
		RequestDispatcher rd = request.getRequestDispatcher("/listadoUsuarios.jsp"); 
		rd.forward(request, response);
		
		
	
		
	}

}
