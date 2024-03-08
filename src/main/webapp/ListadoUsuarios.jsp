<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,es.curso.java.proyectofinal.entities.UsuariosProFinal"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>LISTADO USUARIOS</h1>
<%
	List<UsuariosProFinal> usuarios = (List<UsuariosProFinal>)request.getAttribute("atributoListadoUsuarios");
	System.out.println("Número de usuarios " + usuarios.size());
%>

<table>
	<tr>
		<th>Modificar
			<td>
                <a href="ServletGestionUsuarios?dni=this.dni">Modificar</a>
            </td>
		</th>
		<th>Nombre</th>
		<th>Apellidos</th>
		<th>DNI</th>
		<th>Sexo</th>
		<th>Email</th>
		<th>Teléfono</th>
		<th>Fecha de Nacimiento</th>
		<th>Roles</th>
	</tr>
	
	
	
<%
	for(UsuariosProFinal usuario : usuarios){
%>
	<tr>
		<td><a href="/ProyectoFinalRo/RegistroUsuarios.jsp?nombre=<%=usuario.getNombre()%>
				&apellidos=<%=usuario.getApellidos()%>
				&dni=<%= usuario.getDni()%>
				&sexo=<%= usuario.getSexo()%>
				&email=<%= usuario.getEmail()%>
				&telefono=<%= usuario.getTelefono()%>
				&fechaNacimiento=<%= usuario.getFechaNacimiento()%>
				&roles=<%= usuario.getRoles()%>"
				
				>Modificar</a></td>
		<td><%= usuario.getNombre()  %></td>
		<td><%= usuario.getApellidos()  %></td>
		<td><%= usuario.getDni()  %></td>
		<td><%= usuario.getSexo()  %></td> 
		<td><%= usuario.getEmail()  %></td>
		<td><%= usuario.getTelefono()  %></td>
		<td><%= usuario.getFechaNacimiento()  %>
		<td><%= usuario.getRoles()  %></td></td>
	</tr>
<%	} %>

</table>
<button onclick="">Nuevo Usuario</button>

</body>
</html>