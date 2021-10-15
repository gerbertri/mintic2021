<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.conector" %>
<%@ page import="modelo.ventaCliente" %>
<%@ page import="modelo.productoVenta" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="java.text.NumberFormat" %>
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
		
          		<br>
				<h2>Total Ventas por Cliente</h2><br>
         	
                <table class="tablaReporte" >
                    <tr>
                        <th>Cedula</th>
                        <th>Nombre</th>
                        <th>Valor Total Ventas</th>
                       
                    </tr>
            		<% 
           			ArrayList<ventaCliente> listaVentaClientes=new ArrayList<ventaCliente>();
           			NumberFormat moneda = NumberFormat.getCurrencyInstance();
        			
           			
           			listaVentaClientes=(ArrayList<ventaCliente>)request.getAttribute("listaVentaClientes");
            		for(ventaCliente x:listaVentaClientes){%>
            		<tr>
            			<td align="middle"><% out.print(x.getCedula());%></td>
            			<td align="middle"><% out.print(x.getNombre());%></td>
                        <td align="middle"><% out.print(moneda.format(Double.parseDouble(x.getValorTotalVenta())));%></td>
                       
                 	</tr>
            		<%}%>            
           </table>
           <br><hr><br>
           <p>
           <h2 class=totalReporte>Total Ventas : ${totalVentas}</h2> 
          
           </p>
           <br>
		</section>




	</div>


</body>
</html>