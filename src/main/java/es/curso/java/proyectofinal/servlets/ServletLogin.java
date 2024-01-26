package es.curso.java.proyectofinal.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLogin
 */
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L; //Realmente no es necesario, eclipse lo crea por defecto al generar un servlet

    /**
     * Default constructor. 
     */
    public ServletLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	//es el código que te pone por defecto eclipse pero puedes emplearlo o no, no es necesario
		//puede servir de modelo para saber las estructuras de código que van aquí dentro.
	
		if (request.getParameter ("Usuario") != null) {
			String usuario = request.getParameter(("Usuario"));
			
		} else {
			response.getWriter().append("No ha introducido un usuario");
		}
		
		if (request.getParameter("Contraseña") != null) {
			String contraseña = request.getParameter("Contraseña");
			
		} else {
			response.getWriter().append ("No ha introducido una contraseña");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	//También lo escribe eclipse por defecto pero no tenemos por qué usarlo, podemos y debemos emplear nuestro propio código
	//que será el que verdaderamente realice lo que queremos.
		
		if (request.getParameter("Usuario") != null && request.getParameter ("Contraseña") != null) {
			String usuario = request.getParameter("Usuario");
			String contraseña = request.getParameter ("Contraseña");
			System.out.println ("Se ha enviado el usuario " + usuario + "\ny la contraseña " + contraseña);
			//Esto se ve por consola, es tan sólo una traza para nosotros, para comprobar que se ha guardado correctamente.
			response.getWriter().append("<h3>SE HA INSERTADO CORRECTAMENTE</h3>");
			
		} else {
			System.out.println ("No llega ningún dato");
			response.setContentType ("text/html");
			response.getWriter().append("<h2 style='color:red'>HA HABIDO UN ERROR</h2");
			
		}
	
	}

}
