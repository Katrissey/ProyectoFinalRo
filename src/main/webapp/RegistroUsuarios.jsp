<!DOCTYPE html>
<html lang="es-ES">
<head>
<meta charset="utf-8">
<title>Formulario de Registro/Modificación de Usuarios</title>
</head>
<body>
	<style>
        /* Estilos para los campos requeridos */
        .required-label::after {
            content: "*";
            color: red;
            margin-left: 5px;
        }
    </style>

	<form action="/ProyectoFinalRo/ServletGestionUsuarios" method="post">
		<label class="required-label" for="nombre">Nombre de Usuario: <input type="text" maxlength="40" id="nombre"></label> <br>
		<label class="required-label" for="apellidos">Apellidos: <input type="text" id="apellidos"></label> <br>
		<label class="required-label" for="dni">DNI: <input type="text" id="dni"></label> <br> <!-- poner asterisco en rojo de que es obligatorio-->
		<label for="sexo">Sexo: <input type="text" id="sexo"></label> <br>
		<label for="id">IdUsuario: <input type="text" placeholder="consultar base de datos" readonly></label> <br>
		<label class="required-label" for="contraseña">Contraseña: <input type="password" id="contraseña"></label> <br> <!-- obligar a caracteres que queramos -->
		<label class="required-label" for="email">Correo electrónico: <input type="email" class="form-control is-invalid" placeholder="correo@correo.com" id="email"></label> <br>
		<label class="required-label" for="telefono">Teléfono: <input type="tel" id="telefono"></label> <br>
		<label class="required-label" for="fechaNacimiento">Fecha de nacimiento: <input type="date" id="fechaNacimiento"></label> <br>
		<label class="required-label" for="roles">Roles: <input type="text" id="roles"></label> <br> <!-- hacer un selector/desplegable múltiple -->
		     
		
		<br> <input type="submit" value="Guardar">
	</form>
</body>
</html>