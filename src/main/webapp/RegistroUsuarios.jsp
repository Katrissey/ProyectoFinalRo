<!DOCTYPE html>
<html lang="es-ES">
<head>
<meta charset="utf-8">
<title>Formulario de Registro de Usuarios</title>
</head>
<body>
	<form>
		Nombre de Usuario: <input type="text" maxlength="40"> <br>
		Apellidos: <input type="text"> <br>
		DNI: <input type="text"> <br> <!-- poner asterisco en rojo de que es obligatorio-->
		Sexo: <input type="text"> <br>
		IdUsuario: <input type="text" placeholder="consultar base de datos" readonly> <br> <!-- se puede enlazar con la base de datos pero, en principio, no lo pondremos, ya que se enlazará con la BD la página de buscar usuarios-->
		Contrase�a: <input type="password"> <br> <!-- obligar a caracteres que queramos -->
		Correo electr�nico: <input type="email"> <br>
		Tel�fono: <input type="tel"> <br>
		Fecha de nacimiento: <input type="date"> <br>
		Role: <input type="text"> <br> <!-- hacer un selector/desplegable múltiple -->
		     
		
		<br> <input type="submit" value="Guardar">
	</form>
</body>
</html>