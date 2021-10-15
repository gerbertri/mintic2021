<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.conector" %>
<%@ page import="modelo.cliente" %>
<%@ page import="modelo.productoVenta" %>
<%@ page import="javax.servlet.*" %>

<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilo.css">
<meta charset="utf-8">
<title>Reporte Ventas Clientes</title>
</head>
<body>
	<%@include file="administracion.jsp"%>
	
	<div id="Contenido">
		<section class="registro">
		
          
         	
                <table class="tablaReporte" >
                    <tr>
                        <th>Cedula</th>
                        <th>Nombre</th>
                        <th>Valor Total Ventas</th>
                       
                    </tr>
            		<% 
           			ArrayList<cliente> listaUsuarios=new ArrayList<cliente>();
           			cliente cliente = new cliente();
           			listaUsuarios=(ArrayList<cliente>)request.getAttribute("listaUsuarios");
            		for(cliente x:listaUsuarios){%>
            		<tr>
            			<td align="middle"><% out.print(x.getCedulaCliente());%></td>
            			<td align="middle"><% out.print(x.getNombreCliente());%></td>
                        <td align="middle" ><% out.print(x.getCorreoCliente());%></td>
                       
                 	</tr>
            		<%}%>            
           </table>
		</section>




	</div>


</body>
</html>