<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.conector" %>
<%@ page import="modelo.productoVenta" %>
<%@ page import="javax.servlet.*" %>
<%!
	private productoVenta venta;
	public void boton1(){
		System.out.println("-------------!!!---------");
	}

		
		

	%>
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
			<h2>Consultar cliente para registrar venta</h2>
			<br>
			<p>Cedula:</p>
			<form action=./tv_servlet method="get"  class="ingresa-productos">
			
				<input class="ingdatos" type="text" name="cedulaClienteVentas" >
				<input type="submit" class="botonConsulta-ventas" id="botonConsultaVentas" name="botonConsultaVentas" value="Consultar">
				<br>
            	<br>
            </form>
            <form action=./tv_servlet method="get"  class="ingresa-productos">
         	
                <table class="tablaingresa-productos" width="100%" align="center" >
                    <tr>
                        <th>cod.Producto</th>
                        <th></th>
                        <th>Nombre Producto</th>
                        <th>Cantidad</th>
                        <th>Valor total</th>
                        
                    </tr>
                      
                    <tr >
                        <td align="middle"><input class="ventadatos" type="text" name="codigoProducto_1" value=""></td>
                        <td align="middle"><input type="submit" class="botonConsulta-producto" id="botonConsultaProducto_1" name="botonConsultaProducto_1" value="Consultar" ></td>
                        <td align="middle" ><% if (request.getAttribute("nombreProducto1")!=null){out.print(request.getAttribute("nombreProducto1"));}else{out.print("--");}%></td>
                        <td  width="10%" align="middle"><input class="ventadatos" type="number" name="cantidadProducto_1" value=<% if (request.getAttribute("cantidadProducto_1")!=null){out.print(request.getAttribute("cantidadProducto_1"));}else{out.print("--");}%>></td>
                        <td  width="20%" align="middle"><% if (request.getAttribute("totalValorProducto_1")!=null){out.print(request.getAttribute("totalValorProducto_1"));}else{out.print("--");}%></td>


                    </tr>
                     <tr >
                        <td align="middle"><input class="ventadatos" type="text" name="codigoProducto_2" value=""></td>
                        <td align="middle"><input type="submit" class="botonConsulta-producto" id="botonConsultaProducto_2" name="botonConsultaProducto_2" value="Consultar"></td>
                         <td align="middle"><% if (request.getAttribute("nombreProducto2")!=null){out.print(request.getAttribute("nombreProducto2"));}else{out.print("--");}%></td>
                        <td  width="10%" align="middle"><input class="ventadatos" type="number" name="cantidadProducto_2" value=<% if (request.getAttribute("cantidadProducto_2")!=null){out.print(request.getAttribute("cantidadProducto_2"));}else{out.print("--");}%>></td>
                        <td  width="20%" align="middle"><% if (request.getAttribute("totalValorProducto_2")!=null){out.print(request.getAttribute("totalValorProducto_2"));}else{out.print("--");}%></td>

                    </tr>
                     <tr >
                       	<td align="middle"><input class="ventadatos" type="text" name="codigoProducto_3" ></td>
                        <td align="middle"><input type="submit" class="botonConsulta-producto" id="botonConsultaProducto_3" name="botonConsultaProducto_3" value="Consultar"></td>
                        <td align="middle"><% if (request.getAttribute("nombreProducto3")!=null){out.print(request.getAttribute("nombreProducto3"));}else{out.print("--");}%></td>
                      	<td  width="10%" align="middle"><input class="ventadatos" type="number" name="cantidadProducto_3" value=<% if (request.getAttribute("cantidadProducto_3")!=null){out.print(request.getAttribute("cantidadProducto_3"));}else{out.print("--");}%>></td>
                        <td  width="20%" align="middle"><% if (request.getAttribute("totalValorProducto_3")!=null){out.print(request.getAttribute("totalValorProducto_3"));}else{out.print("--");}%></td>
                    </tr>

                    <tr>
                        <td  colspan="4" align="right"><h3>Total venta</h3></td>
                        <td align="middle" ><h5><% if (request.getAttribute("sumatoria")!=null){out.print(request.getAttribute("sumatoria"));}else{out.print("--");}%></h5></td>
                    </tr>
                    <tr>
                        <td  colspan="4" align="right"><h3>Total IVA</h3></td>
                        <td align="middle" ><h5><% if (request.getAttribute("sumatoriaIva")!=null){out.print(request.getAttribute("sumatoriaIva"));}else{out.print("--");}%></h5></td>
                    </tr>
                    <tr>
                        <td  colspan="4" align="right"><h3>Total con IVA</h3></td>
                        <td align="middle" ><h5><% if (request.getAttribute("sumatoriaTotal")!=null){out.print(request.getAttribute("sumatoriaTotal"));}else{out.print("--");}%></h5></td>
                       
                    </tr>
                    
                </table>
                <br>
           		 <input type="submit" class="botonConfirma-ventas" id="botonConfirmaVentas" name="botonConfirmaVentas" value="Calcular">
           		 <br><br><br>
           		 
              
              
              
              
            </form>
            <form action=./tv_servlet method="post">
            <input type="submit" class="botonFinaliza-ventas" id="botonFinalizaVentas" name="botonFinalizaVentas" value="Confirmar">
            <br><br>
            </form>
            
           
           
            
		</section>




	</div>


</body>
</html>
