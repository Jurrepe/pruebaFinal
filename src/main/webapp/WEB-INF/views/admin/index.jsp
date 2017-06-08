<%@ include file="../includes/header.jsp" %>
		
	<div class="row">
		<div class="col-md-12 maincajon">		
			<c:if test="${not empty msg}">
				<p class="alert alert-success" role="alert">${msg}</p>
			</c:if>
			<a href="admin/curso/edit" class="btn btn-default">Crear nuevo curso</a>
			<div class="col-md-12 tablaCursos">
				<h2>Listado cursos</h2>
				<table class="tablePlugin" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>Codigo curso</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cursos}" var="c">
						<tr>
							<td>${c.id}</td>
							<td><a href="admin/curso/edit/${c.id}">${c.nombre}</a></td>
							<td>${c.cod}</td> 
						</tr>		
						</c:forEach>
					</tbody>	
				</table>
			</div>
		</div>
	</div>
		
<%@ include file="../includes/footer.jsp" %>