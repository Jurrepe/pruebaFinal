<%@ include file="includes/header.jsp" %>

<c:if test="${not empty curso}">
	<h1>${curso.nombre}</h1>
	
	<span>Codigo: ${curso.cod}</span>
	
</c:if>
<c:if test="${empty curso}">
		
	<h2>Este no es el curso que estas buscando, prueba en otro curso</h2>
	
</c:if>
<%@ include file="includes/footer.jsp" %>