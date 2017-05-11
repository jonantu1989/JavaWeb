<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ipartek.ejemplos.jonantunano.tipos.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ejemplo JavaBeans</title>
</head>
<body>
	<jsp:useBean id="Usuario" scope="page" class="com.ipartek.ejemplos.jonantunano.tipos.Usuario"></jsp:useBean>
	<h1>El usuario es <jsp:getProperty property="nombre" name="usuario"/> y la password es 
	<jsp:setProperty property="pass" name="usuario"/></h1>
	
	<h1>El usuario es ${usuario.nombre} y la password es ${usuario.pass}</h1>
	
	<h1>El usuario es <%= Usuario.getNombre() %> y la password es <%= Usuario.getPass() %> </h1>
</body>
</html>