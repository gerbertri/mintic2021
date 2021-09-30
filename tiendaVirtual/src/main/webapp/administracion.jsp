<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MinTech</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>
	<header class="header">
		<img src="Imagenes/MINTECH.png" class="logo">
		<h1>MinTech</h1>

	</header>

	<div id="menu">
		<ul>
			<li id="item"><a href="#">Usuarios</a>
				<ul id="submenu">
					<li><a href="consultarUsuario.jsp">Consultar</a></li>
					<li><a href="crearUsuario.jsp">Crear</a></li>
					<li><a href="actualizarUsuario.jsp">Actualizar</a></li>
					<li><a href="borrarUsuario.jsp">Eliminar</a></li>
				</ul></li>

			<li id="item"><a href="#">Clientes</a>
				<ul id="submenu">
					<li><a href="consultarCliente.jsp">Consultar</a></li>
					<li><a href="crearCliente.jsp">Crear</a></li>
					<li><a href="actualizarCliente.jsp">Actualizar</a></li>
					<li><a href="borrarCliente.jsp">Eliminar</a></li>
				</ul></li>

			<li id="item"><a href="#">Provedores</a>
				<ul id="submenu">
					<li><a href="consultarProveedor.jsp">Consultar</a></li>
					<li><a href="crearProveedor.jsp">Crear</a></li>
					<li><a href="actualizarProveedor.jsp">Actualizar</a></li>
					<li><a href="borrarProveedor.jsp">Eliminar</a></li>
				</ul></li>

			<li id="item"><a href="#">Productos</a>
			<ul id="submenu">
				<li><a href="cargarProductos.jsp">Cargar</a></li>
			</ul></li>
			
			
			<li id="item"><a href="ventas.jsp">Ventas</a></li>
			<li id="item"><a href="#">Reportes</a></li>
		</ul>
	</div>
</body>
</html>

