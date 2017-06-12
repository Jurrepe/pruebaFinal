<%@ include file="../includes/header.jsp" %>
		
	<div class="row">
		<div class="col-md-12 maincajon">		
			<c:if test="${not empty msg}">
				<p class="alert alert-success" role="alert">${msg}</p>
			</c:if>
			<h1 class="titulo">Gestión de cursos</h1>
			<div class="input-group center">
		       <label for="buscadorAdminCurso" class="input-group-addon">Buscar<span class="glyphicon glyphicon-search"></span></label>
		       <input type="text" id="buscadorAdminCurso" class="form-control" size= 55 placeholder="Buscar un curso" autofocus>     
		    </div>
		    <br>
		    <a href="admin/curso/migracion" class="btn btn-info">Migrar CSV</a>
			<a href="admin/curso/edit" class="btn btn-default">Crear nuevo curso</a>
			<br><br>
			<c:choose>
					<c:when test="${total > 500}">
						<p>Mostrando los ultimos <strong>500</strong> cursos de un total de <strong>${total}</strong> cursos.</p>
					</c:when>
					<c:otherwise>
						<p>Mostrando <strong>${total}</strong> cursos.</p>
					</c:otherwise>
			</c:choose>
			<div class="col-md-12 tablaCursos">
				<h2>Listado cursos</h2>
				<table class="tablePlugin" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>Codigo curso</th>
							<th>Eliminar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cursos}" var="c">
						<tr>
							<td>${c.id}</td>
							<td><a href="admin/curso/edit/${c.id}">${c.nombre}</a><a href="admin/curso/edit/${c.id}"><img class="mini-img derecha" src="resources/img/pensil.png" title="Editar" alt="Boton de editar"></a></td>
							<td>${c.cod}</td> 
							<td><a href="admin/curso/eliminar/${c.id}"><img class="mini-img" src="resources/img/delete.png" title="Eliminar" alt="Boton de eliminar"></a></td>
						</tr>		
						</c:forEach>
					</tbody>	
				</table>
			</div>
		</div>
	</div>
		
<%@ include file="../includes/footer.jsp" %>