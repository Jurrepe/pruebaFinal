<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/custom.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<title>Login Admin</title>
</head>
<body>
<div id="ventanaLogin">
	<form action="login" method="post">
	<img class="logo" src="resources/img/logo-ipartek.png" alt="Logo de la empresa Ipartek">
	<div class="input-group">
	  <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-user"></span></span>
	  <input type="text" class="form-control" name="usuario" placeholder="Usuario" aria-describedby="basic-addon1" autofocus>
	</div>
	
	<br>
	
	<div class="input-group">
	  <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-eye-open"></span></span>
	  <input type="password" class="form-control" name="clave" placeholder="Contraseña" aria-describedby="basic-addon1">
	</div>
	
	<br>
	
	<input class="btn btn-primary btn-lg" type="submit" value="validar">
	</form>
</div>
<video playsinline autoplay muted loop id="bgvid">
    <source src="resources/video/ocean.mp4" type="video/mp4">
</video>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
</body>
</html>