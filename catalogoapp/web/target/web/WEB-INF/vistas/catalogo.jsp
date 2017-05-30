<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Catalogo</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>CATALOGO</h1>
<table border="1">
	<thead>
		<tr>
			
			<th>ID producto</th>
			<th>Nombre</th>
			<th>Descripcion</th>
			<th>Precio</th>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.productos}" var="producto">
			<tr>
				
				<td>${producto.id}</td>
				<td>${producto.nombre}</td>
				<td>${producto.descripcion}</td>
				<td>${producto.precio}</td>
				
				
				
				
				
			</tr>
			
		</c:forEach>
				
	</tbody>
</table>
<a href="login">Login</a>
</body>
</html>