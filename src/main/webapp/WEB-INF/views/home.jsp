<%@ include file="includes/header.jsp" %>

<h1>
	Prueba Final
</h1>
<a href="admin">Ir al centro de matrix</a> <br><br>
<form class="navbar-form navbar-left">
       <div class="input-group">
       <label for="buscadorCurso" class="input-group-addon">Buscar<span class="glyphicon glyphicon-search"></span></label>
         <input type="text" id="buscadorCurso" class="form-control" size= 55 placeholder="Buscar un curso">
         
       </div>
</form>
<br><br>
<h3>Ultimos cursos</h3>
<ul>
<c:forEach items="${cursos}" var="c">
	<li>
		${c.nombre} - ${c.cod} 
	</li>	
</c:forEach>
</ul>
<%@ include file="includes/footer.jsp" %>