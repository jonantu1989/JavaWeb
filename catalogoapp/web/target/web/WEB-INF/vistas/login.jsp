<%@ include file="includes/cabecera.jsp"%>

<h1>Login de usuarios: </h1>
	<form action="login" method="post">
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
		<a href="alta">ALTA</a>
		<a href="tienda">TIENDA</a>
		
			
	</form>
<%@ include file="includes/pie.jsp" %>