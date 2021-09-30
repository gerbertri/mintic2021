<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilo.css">
<meta charset="utf-8">
<title>Ventas</title>
</head>
<body>
	<%@include file="administracion.jsp"%>
	<div id="Contenido">
		<section class="registro">
			<h2>Consultar cliente para registar venta</h2>
			<br>
			<p>Cedula:</p>
			<form action=./tv_servlet method="get">
				<input class="ingdatos" type="text" name="cedulaClienteVentas" required>
				<input type="submit" class="botonConsulta-ventas" id="botonConsultaVentas" value="Consultar">
			</form>
            <br>
