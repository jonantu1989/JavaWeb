<%@ include file="includes/cabecera.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<h2>Formulario de productos</h2>
	
	<jsp:useBean id="productos" scope="request"
		class="com.ipartek.ejemplos.jonantunano.tipos.Productos" />

	<form action="tiendaform" method="post">
		<fieldset>
			<label for="id">ID</label> 
			
			<input id="id" name="id"
			  required="required" value="${productos.id}" 
			  
			    
		  	/>
		</fieldset>
		<fieldset>
			<label for="nombre">Nombre</label> <input type="text" id="nombre"
				name="nombre" />
		</fieldset>
		<fieldset>
			<label for="descripcion">Descripcion</label> <input type="text" id="descripcion"
				name="descripcion" />
		</fieldset>
		<fieldset>
			<label for="precio">Precio</label> <input type="text" id="precio"
				name="precio" />
		</fieldset>
		<fieldset>
			<input type="submit" value="${fn:toUpperCase(param.op)}" />
			<p class="errores">${productos.errores}</p>
			
			<input type="hidden" name="opform" value="${param.op}" />
		</fieldset>
	</form>
	
	<c:if test="${param.op == 'borrar'}">
		<script>
			document.forms[0].onsubmit = confirmarBorrado;
		</script>
	</c:if>
	
<%@ include file="includes/pie.jsp" %>