<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<form action="logincatalogo" method="get">
		<fieldset> <!-- Esto es un cuadro de texto para nombre -->
			<label for="nombre">Nombre</label>
			<input id="nombre" name="nombre" />
		</fieldset>
		<fieldset>
			<label for="pass">Contraseña</label>
			<input type="password" id="pass" name="pass" />
		</fieldset>
		<fieldset>
			<input type="submit" value="Login" />
		</fieldset>
			
	</form>
</body>
</html>