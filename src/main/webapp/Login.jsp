<!DOCTYPE html>
<html lang="es-ES">

<head>
	<meta charset="utf-8">
	<title>Log-in</title>
</head>
 
<body>
	<h1>ENLACE AL SERVLET</h1>
	<h3>LOGIN</h3>
	<a href = "/ProyectoFinalRo/ServletLogin">Enlace al servlet</a> <br> <br>

	<form action="/ProyectoFinalRo/ServletLogin" method="post">
		Usuario: <input type=text name="usuario" id="usuario"> <br>
		Contrase�a: <input type="password" name="contrase�a" id="contrase�a"> <br>
		<input type="submit" value="Enviar datos">
	</form>
    
</body>

</html>