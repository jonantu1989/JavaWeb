<%@ include file="includes/cabecera.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Mantenimiento de productos</h2>

<table border="1">
	<thead>
		<tr>
			<th>Operaciones</th>
			<th>ID producto</th>
			<th>Nombre</th>
			<th>Descripcion</th>
			<th>Precio</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.productos}" var="producto">
			<tr>
				<td>
					<a href="?op=modificar&id=${producto.nombre}">Modificar</a>
					<a href="?op=borrar&id=${producto.nombre}">Borrar</a>
				</td>
				<td>${producto.id}</td>
				<td>${producto.nombre}</td>
				<td>${producto.descripcion}</td>
				<td>${producto.precio}</td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>

<a href="?op=alta">Alta</a>
<a href="?op=modificar">Modificar</a>
<a href="?op=borrar">Borrar</a>

<%@ include file="includes/pie.jsp"%>