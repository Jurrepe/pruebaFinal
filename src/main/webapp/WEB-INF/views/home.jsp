<%@ include file="includes/header.jsp" %>

<h1 class="titulo">
	Cursos de Ipartek
</h1>
       <div class="input-group center">
       <label for="buscadorCurso" class="input-group-addon">Buscar<span class="glyphicon glyphicon-search"></span></label>
         <input type="text" id="buscadorCurso" class="form-control" size= 55 placeholder="Buscar un curso" autofocus>
         
       </div>

<br><br>
<h3>Ultimos cursos</h3>
<ul class="list-group">
<c:forEach items="${cursos}" var="c">
	<li class="list-group-item">
		<a href="view/${c.id}">${c.nombre}</a> <span class="badge">${c.cod}</span> 
	</li>	
</c:forEach>
</ul>
<%@ include file="includes/footer.jsp" %>