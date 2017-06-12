<%@ include file="../includes/header.jsp" %>
<h1>Migración</h1>
<c:if test="${not empty msg}">
		<p class="alert alert-success" role="alert">${msg}</p>
</c:if>
<p> Para migrar datos, colocarlo en la ubicacion: <span id="ejemploCodigo">c:/desarrollo/datos/cursos.csv</span> </p>
<p> Si todo esta listo pulse en el boton de migrar </p>

<a href="admin/curso/migrar" class="btn btn-warning">Migrar CSV</a>
<a href="admin" class="btn btn-default">Volver</a>


<%@ include file="../includes/footer.jsp" %>