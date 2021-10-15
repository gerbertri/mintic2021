<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.conector" %>
<%@ page import="modelo.usuario" %>
<%@ page import="modelo.productoVenta" %>
<%@ page import="javax.servlet.*" %>

<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilo.css">
<meta charset="utf-8">
<title>Reporte Usuarios</title>
</head>
<body>
	<%@include file="administracion.jsp"%>
	
	<div id="Contenido">
	
	
		<section class="registro">
			<br>
			<h2>Listado de Usuarios</h2><br>
		
          
         	
                <table class="tablaReporte" >
                    <tr>
                        <th>Cedula</th>
                        <th>Nombre</th>
                        <th>Correo Electronico</th>
                        <th>Usuario</th>
                        <th>Password</th>
                        
                    </tr>
            		<% 
           			ArrayList<usuario> listaUsuarios=new ArrayList<usuario>();
           			
           			listaUsuarios=(ArrayList<usuario>)request.getAttribute("listaUsuarios");
            		for(usuario x:listaUsuarios){%>
            		<tr>
            			<td align="middle"><% out.print(x.getCedulaUsuario());%></td>
            			<td align="middle"><% out.print(x.getNombreUsuario());%></td>
                        <td align="middle" ><% out.print(x.getCorreoUsuario());%></td>
                        <td align="middle"><% out.print(x.getUsuario());%></td>
                        <td align="middle"><% out.print(x.getContrasenaUsuario());%></td>
                 	</tr>
            		<%}%>            
           </table>
           <br>
		</section>




	</div>


</body>
</html>