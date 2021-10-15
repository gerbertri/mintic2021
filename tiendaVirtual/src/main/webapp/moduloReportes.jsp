<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modulo Reportes</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>
	<%@include file="administracion.jsp"%>
	<div id="Contenido">
		<section class="moduloRegistro">
			<form action=./tv_servlet method="get">
				
				<br><br>
					<input type="submit" class="botonReporte" value="Listado Usuarios" name="listadoUsuarios">
				
				<br><br>
				
					<input type="submit" class="botonReporte" value="Listado Clientes" name="listadoClientes">
				
				<br><br>
				
					<input type="submit" class="botonReporte" value="Ventas Clientes" name="listadoVentasClientes">
					
				<br><br>
			</form>
		</section>
	</div>
</body>
</html>