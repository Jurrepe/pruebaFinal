<%@ include file="../includes/header.jsp" %>

<div class="row">
	<div class="col-md-12 maincajon">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<span><a href="admin" class="btn btn-default">Volver</a></span>
			<c:if test="${not empty msg}">
				<p class="alert alert-success" role="alert">${msg}</p>
			</c:if>
			<h2>CRUD Cursos</h2>
			<form:form action="admin/curso/crear" modelAttribute="curso">
				<label>Id:</label>
				<form:input class="form-control" path="id" readonly="true"/><br>
				<label>Nombre:</label> <form:errors path="nombre" cssStyle="color:red;"/>
				<form:input class="form-control" path="nombre"/><br>
	
				<label>Código:</label> <form:errors path="cod" cssStyle="color:red;"/>
				<form:input class="form-control" path="cod"/><br>
				<c:choose>
					<c:when test="${curso.id == -1}">
						<form:button type="submit" class="btn btn-primary margin1">Crear</form:button>
					</c:when>
					<c:otherwise>
						<form:button type="submit" class="btn btn-primary margin1">Modificar</form:button>
						<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modal-eliminar"> Eliminar </button>
						
					</c:otherwise>
				</c:choose>
				
			</form:form>
		</div>
		<div class="col-md-3"></div>
	</div>
</div>

<!-- Modal Eliminar -->
<div id="modal-eliminar" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-body">
        <p>¿Desea eliminar el curso <b>${curso.nombre}</b>?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
        <span><a href="admin/curso/eliminar/${curso.id}" class="btn btn-danger">Si</a></span>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- End Modal Eliminar -->

<%@ include file="../includes/footer.jsp" %>