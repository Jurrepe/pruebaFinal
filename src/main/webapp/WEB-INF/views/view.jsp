<%@ include file="includes/header.jsp" %>
<a class="btn btn-default" href="/formacion">Volver</a>
<c:if test="${not empty curso}">
	<h1 class="titulo">Detalle del curso</h1>
	<h3 class="list-group-item"><Strong>Nombre:</Strong> ${curso.nombre}</h3>
	<h3 class="list-group-item"><Strong>Código:</Strong> ${curso.cod}</h3>
	
	
</c:if>
<c:if test="${empty curso}">
		
	<h2>Este no es el curso que estas buscando, prueba en otro curso</h2>
	
</c:if>
<%@ include file="includes/footer.jsp" %>