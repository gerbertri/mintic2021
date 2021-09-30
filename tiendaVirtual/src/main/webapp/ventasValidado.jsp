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
			<h2>Consultar cliente para registrar venta</h2>
			<br>
			<p>Cedula:</p>
			<form action=./tv_servlet method="get">
				<input class="ingdatos" type="text" name="cedulaClienteVentas" required>
				<input type="submit" class="botonConsulta-ventas" id="botonConsultaVentas" value="Consultar">
			</form>
            <br>
            
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
                        <td align="middle"><input class="ventadatos" type="text" name="codigoProducto_1"></td>
                        <td align="middle"><input type="submit" class="botonConsulta-producto" id="botonConsultaProducto_1" value="Consultar" ></td>
                        <td align="middle" ><% if (request.getAttribute("nombreProducto1")!=null){out.print(request.getAttribute("nombreProducto1"));}else{out.print("--");}%></td>
                        <td  width="10%" align="middle"><input class="ventadatos" type="text" name="cantidadProducto_1"></td>
                        <td  width="20%" align="middle">--</td>


                    </tr>
                     <tr >
                        <td align="middle"><input class="ventadatos" type="text" name="codigoProducto_2" ></td>
                        <td align="middle"><input type="submit" class="botonConsulta-producto" id="botonConsultaProducto_2" value="Consultar"></td>
                        <td align="middle"><% if (request.getAttribute("nombreProducto2")!=null){out.print(request.getAttribute("nombreProducto2"));}else{out.print("--");}%></td>
                        <td  width="10%" align="middle"><input class="ventadatos" type="text" name="cantidadProducto_2"> </td>
                        <td  width="20%" align="middle">-- </td>

                    </tr>
                     <tr >
                       <td align="middle"><input class="ventadatos" type="text" name="codigoProducto_3" ></td>
                        <td align="middle"><input type="submit" class="botonConsulta-producto" id="botonConsultaProducto_3" value="Consultar"></td>
                        <td align="middle"><% if (request.getAttribute("nombreProducto3")!=null){out.print(request.getAttribute("nombreProducto3"));}else{out.print("--");}%></td>
                        <td  width="10%" align="middle"><input class="ventadatos" type="text" name="cantidadProducto_3"> </td>
                        <td  width="20%" align="middle">-- </td>
                    </tr>

                    <tr>
                        <td  colspan="4" align="right"><h3>Total venta</h3></td>
                        <td align="middle" ><h5>Valor</h5></td>
                    </tr>
                    <tr>
                        <td  colspan="4" align="right"><h3>Total IVA</h3></td>
                        <td align="middle" ><h5>Valor</h5></td>
                    </tr>
                    <tr>
                        <td  colspan="4" align="right"><h3>Total con IVA</h3></td>
                        <td align="middle" ><h5>Valor</h5></td>
                    </tr>
                </table>
                <br>
                <input type="submit" class="botonConfirma-ventas" id="botonConfirmaVentas" value="Confirmar">
                <br>
                <br>
            </form>
		</section>




	</div>


</body>
</html>