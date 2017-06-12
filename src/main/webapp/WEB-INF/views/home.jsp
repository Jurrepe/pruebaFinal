<%@ include file="includes/header.jsp" %>

<h1 class="titulo">
	Cursos de Ipartek
</h1>
       <div class="input-group center">
       <label for="buscadorCurso" class="input-group-addon">Buscar<span class="glyphicon glyphicon-search"></span></label>
         <input type="text" id="buscadorCurso" class="form-control" size= 55 placeholder="Buscar un curso" autofocus>
         
       </div>

<br><br>
<c:if test="${not empty cursos}">
	<h2>Ultimos cursos</h2>
	<ul class="list-group">
	<c:forEach items="${cursos}" var="c">
		<li class="list-group-item">
			<a href="view/${c.id}"><strong>${c.nombre}</strong></a> <span class="badge">${c.cod}</span> 
		</li>	
	</c:forEach>
	</ul>
</c:if>
<c:if test="${empty cursos}">
	<p class="errorLista">No hay ningún curso</p>
</c:if>
<%@ include file="includes/footer.jsp" %>