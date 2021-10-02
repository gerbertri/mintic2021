package co.edu.unbosque.tiendaVirtual;

import modelo.cliente;
import modelo.conector;
import modelo.productoVenta;
import modelo.proveedor;
import modelo.usuario;
import modelo.productos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class tv_servlet
 */
@WebServlet("/tv_servlet")
public class tv_servlet extends HttpServlet {

	private conector conexion;
	private productoVenta venta=new productoVenta();

	productos listaproducto[]=new productos[3];

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public tv_servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String labels[]= {"nombreProducto1","nombreProducto2","nombreProducto3"};

		String botonConsultaUsuario = request.getParameter("cedulaUsuario");
		String botonConsultaCliente = request.getParameter("cedulaCliente");
		String botonConsultaProveedor = request.getParameter("nit");
		String botonConsultaVentas = request.getParameter("cedulaClienteVentas");
		String botonConsltaVentasProducto_1=request.getParameter("codigoProducto_1");
		String botonConsltaVentasProducto_2=request.getParameter("codigoProducto_2");
		String botonConsltaVentasProducto_3=request.getParameter("codigoProducto_3");
		String botonConfirmaVentas_1=request.getParameter("cantidadProducto_1");
		String botonConfirmaVentas_2=request.getParameter("cantidadProducto_2");
		String botonConfirmaVentas_3=request.getParameter("cantidadProducto_3");
		
		// Modulo usuarios

		
			
		//Consulta Usuario
		
		if (botonConsultaUsuario != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/respuestaConsultaUsuario.jsp");
			

			usuario usuario = conexion.consultarUsuario(botonConsultaUsuario);
			String nombreUsuario = usuario.getNombreUsuario();
			String cedulaUsuario = usuario.getCedulaUsuario();
			String correoUsuario = usuario.getCorreoUsuario();
			String usuarioConsulta = usuario.getUsuario();

			if (nombreUsuario != null) {
				request.setAttribute("Nombre", nombreUsuario);
				request.setAttribute("Cedula", cedulaUsuario);
				request.setAttribute("Correo", correoUsuario);
				request.setAttribute("Usuario", usuarioConsulta);
				rd.forward(request, response);
			
			}else {

				JOptionPane optionPane = new JOptionPane("La cedula del usuario no existe",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("consultarUsuario.jsp");
			}
		}


		// Modulo clientes

		
		//Consulta Cliente
		
		if (botonConsultaCliente != null) {
			
		
			RequestDispatcher rd = request.getRequestDispatcher("/respuestaConsultaCliente.jsp");
			

			cliente cliente = conexion.consultarCliente(botonConsultaCliente);
			String nombreCliente = cliente.getNombreCliente();
			String cedulaCliente = cliente.getCedulaCliente();
			String correoCliente = cliente.getCorreoCliente();
			String telefonoCliente = cliente.getTelefonoCliente();
			String direccionCliente = cliente.getDireccionCliente();
			System.out.println("nombreCliente");
			if (nombreCliente != null) {			
				request.setAttribute("Nombre", nombreCliente);
				request.setAttribute("Cedula", cedulaCliente);
				request.setAttribute("Correo", correoCliente);
				request.setAttribute("Telefono", telefonoCliente);
				request.setAttribute("Direccion", direccionCliente);


				rd.forward(request, response);

			}
			else {

				JOptionPane optionPane = new JOptionPane("La cedula del cliente no existe",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("consultarCliente.jsp");
			}
		}


		// Modulo proveedores
		
		if (botonConsultaProveedor != null) {
			

			RequestDispatcher rd = request.getRequestDispatcher("/respuestaConsultaProveedor.jsp");

			proveedor proveedor = conexion.consultarProveedor(botonConsultaProveedor);
			String nombreProveedor = proveedor.getNombreProveedor();
			String nitProveedor = proveedor.getNit();
			String ciudadProveedor = proveedor.getCiudadProveedor();
			String telefonoProveedor = proveedor.getTelefonoProveedor();
			String direccionProveedor = proveedor.getDireccionProveedor();
			if (nombreProveedor != null) {

				request.setAttribute("Nombre", nombreProveedor);
				request.setAttribute("Nit", nitProveedor);
				request.setAttribute("Ciudad", ciudadProveedor);
				request.setAttribute("Telefono", telefonoProveedor);
				request.setAttribute("Direccion", direccionProveedor);


				rd.forward(request, response);

			}else {
				JOptionPane optionPane = new JOptionPane("El nit del proveedor no existe",
						JOptionPane.WARNING_MESSAGE);

				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("consultarProveedor.jsp");
			}
		}
		
		// Modulo Ventas//
		
			//Validacion cliente -- Mira si el cliente exite en la base de datos
		if(botonConsultaVentas != null && botonConsultaVentas.length()>=1) {
			RequestDispatcher rd = request.getRequestDispatcher("/ventasValidado.jsp");
			cliente cliente = conexion.consultarCliente(botonConsultaVentas);
			String nombreCliente = cliente.getNombreCliente();
			System.out.println("nombreCliente");
			if (nombreCliente != null) {
				request.setAttribute("display", "none");
				venta.agregarProductoVenta(null, 0);
				venta.agregarProductoVenta(null, 1);
				venta.agregarProductoVenta(null, 2);
	
				rd.forward(request, response);
	
			}
			else {
	
				JOptionPane optionPane = new JOptionPane("La cedula del cliente no existe",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("ventas.jsp");
			}
		}
		
		 // Consulta 1er producto
		
		if (botonConsltaVentasProducto_1!=null && botonConsltaVentasProducto_1.length()>=1) {
			
			RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/ventasValidado.jsp");
			productos producto=conexion.consultarProducto(botonConsltaVentasProducto_1);
			String nombreProducto=producto.getNombreProducto();
			if (nombreProducto != null) {
				venta.agregarProductoVenta(producto, 0);
				listaproducto=venta.retornarProductos();
				int i=0;
				for(productos x:listaproducto) {
				System.out.println(x);
					if (x != null) {request.setAttribute(labels[i], x.getNombreProducto());}
					i++;
				}
				rd.forward(request, response);
				
			}else {
	
				JOptionPane optionPane = new JOptionPane("El producto no existe1",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				listaproducto=venta.retornarProductos();
				int i=0;
				for(productos x:listaproducto) {
				System.out.println(x);
					if (x != null) {request.setAttribute(labels[i], x.getNombreProducto());}
					i++;
				}
				rd.forward(request, response);
				//response.sendRedirect("ventasValidado.jsp");
			}
			
			
			
		}
		
		// Consulta 2do producto
		
		if (botonConsltaVentasProducto_2!=null && botonConsltaVentasProducto_2.length()>=1) {
			
			RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/ventasValidado.jsp");
			productos producto2=conexion.consultarProducto(botonConsltaVentasProducto_2);
			String nombreProducto=producto2.getNombreProducto();
			if (nombreProducto != null) {
				venta.agregarProductoVenta(producto2, 1);
				listaproducto=venta.retornarProductos();
				int i=0;
				for(productos x:listaproducto) {
				System.out.println(x);
					if (x != null) {request.setAttribute(labels[i], x.getNombreProducto());}
					i++;
				}
				
				rd.forward(request, response);
				
				
			}else {
	
				JOptionPane optionPane = new JOptionPane("El producto no existe2",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				int i=0;
				for(productos x:listaproducto) {
				System.out.println(x);
					if (x != null) {request.setAttribute(labels[i], x.getNombreProducto());}
					i++;
				}
				rd.forward(request, response);
				//response.sendRedirect("ventasValidado.jsp");
			}
			
			
			
		}
		
		
		// Consulta 3er producto
		
		if (botonConsltaVentasProducto_3!=null && botonConsltaVentasProducto_3.length()>=1) {
			
			RequestDispatcher rd = request.getRequestDispatcher("/ventasValidado.jsp");
			productos producto3=conexion.consultarProducto(botonConsltaVentasProducto_3);
			String nombreProducto=producto3.getNombreProducto();
			if (nombreProducto != null) {
				venta.agregarProductoVenta(producto3, 2);
				//request.setAttribute("codigoProducto3", producto3.getCodigoProducto());
				listaproducto=venta.retornarProductos();
				int i=0;
				for(productos x:listaproducto) {
				System.out.println(x);
					if (x != null) {request.setAttribute(labels[i], x.getNombreProducto());}
					i++;
				}
				rd.forward(request, response);
				
			}else {
	
				JOptionPane optionPane = new JOptionPane("El producto no existe3",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				int i=0;
				for(productos x:listaproducto) {
				System.out.println(x);
					if (x != null) {request.setAttribute(labels[i], x.getNombreProducto());}
					i++;
				}
				rd.forward(request, response);
				//response.sendRedirect("ventasValidado.jsp");
			}
			
			
			
		}
		
		
		//Calculo de precio total tomando cantidades
		
		if(botonConfirmaVentas_1 != null && botonConfirmaVentas_1.length() >= 1) {
			
			System.out.println(botonConfirmaVentas_1+"**");
			System.out.println(botonConfirmaVentas_2+"**");
			System.out.println(botonConfirmaVentas_3+"**");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	
	
	
	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		conexion = new conector();

		String Usuario = request.getParameter("Usuario");
		String Contrasena = request.getParameter("Contrasena");

		// Modulo usuarios

		String CreaCedula = request.getParameter("CreaCedula");
		String Creanombre = request.getParameter("Creanombre");
		String CreaCorreo = request.getParameter("CreaCorreo");
		String CreaUsuario = request.getParameter("CreaUsuario");
		String CreaContrasena = request.getParameter("CreaContrasena");

		String ActualizaCedula = request.getParameter("ActualizaCedula");
		String Actualizanombre = request.getParameter("Actualizanombre");
		String ActualizaCorreo = request.getParameter("ActualizaCorreo");
		String ActualizaUsuario = request.getParameter("ActualizaUsuario");
		String ActualizaContrasena = request.getParameter("ActualizaContrasena");

		String cedulaBorrar = request.getParameter("cedulaBorrar");

		// Modulo clientes

		String CreaCedulaCliente = request.getParameter("CreaCedulaCliente");
		String CreanombreCliente = request.getParameter("CreanombreCliente");
		String CreaDireccionCliente = request.getParameter("CreaDirecciónCliente");
		String CreaTelefonoCliente = request.getParameter("CreaTelefonoCliente");
		String CreaCorreoCliente = request.getParameter("CreaCorreoCliente");

		String ActualizaCedulaCliente = request.getParameter("ActualizaCedulaCliente");
		String ActualizanombreCliente = request.getParameter("ActualizanombreCliente");
		String ActualizaDireccionCliente = request.getParameter("ActualizaDireccionCliente");
		String ActualizaTelefonoCliente = request.getParameter("ActualizaTelefonoCliente");
		String ActualizaCorreoCliente = request.getParameter("ActualizaCorreoCliente");

		String cedulaBorrarCliente = request.getParameter("cedulaBorrarCliente");

		// Modulo proveedores

		String CreaNitProveedor = request.getParameter("CreaNit");
		String CreanombreProveedor = request.getParameter("CreanombreProveedor");
		String CreaDireccionProveedor = request.getParameter("CreaDireccionProveedor");
		String CreaTelefonoProveedor = request.getParameter("CreaTelefonoProveedor");
		String CreaCiudadProveedor = request.getParameter("CreaCiudadProveedor");

		String ActualizaNit = request.getParameter("ActualizaNit");
		String ActualizanombreP = request.getParameter("ActualizanombreP");
		String ActualizaDireccionP = request.getParameter("ActualizaDireccionP");
		String ActualizaTelefonoP = request.getParameter("ActualizaTelefonoP");
		String ActualizaCiudadP = request.getParameter("ActualizaCiudadP");

		String nitBorrarP = request.getParameter("nitBorrar");

		Boolean validaUsuario = conexion.validarUsuario(Usuario, Contrasena);
		RequestDispatcher rd;

		if (validaUsuario) {
			rd = request.getRequestDispatcher("/administracion.jsp");
			rd.forward(request, response);
		}

		else if (!validaUsuario && Usuario != null) {
			JOptionPane optionPane = new JOptionPane("Verifique los datos de ingreso", JOptionPane.WARNING_MESSAGE);
			JDialog dialog = optionPane.createDialog("MinTech");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			response.sendRedirect("index.jsp");
		}

		// Modulo usuarios

		// Crea usuario

		//Consulta usuario
		/*
		else if (botonConsultaUsuario != null) {

			usuario usuario = conexion.consultarUsuario(botonConsultaUsuario);
			String nombreUsuario = usuario.getNombreUsuario();
			String cedulaUsuario = usuario.getCedulaUsuario();
			String correoUsuario = usuario.getCorreoUsuario();
			String usuarioConsulta = usuario.getUsuario();
			if (nombreUsuario != null) {
				JOptionPane optionPane = new JOptionPane("Nombre: " + nombreUsuario + "\n" + "Cedula: " + cedulaUsuario
						+ "\n" + "Correo: " + correoUsuario + "\n" + "Usuario: " + usuarioConsulta + "\n");
				JDialog dialog = optionPane.createDialog("Consulta");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("consultarUsuario.jsp");
			}
			else {
				JOptionPane optionPane = new JOptionPane("La cedula del usuario no existe",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("consultarUsuario.jsp");
			}
		}*/

		//Crea usuario
		
		else if (CreaUsuario != null && CreaContrasena != null && CreaCedula != null) {
			usuario cedula = conexion.consultarUsuario(CreaCedula);
			String cedulaCrear = cedula.getCedulaUsuario();
			usuario usuario = conexion.consultarUsuarioU(CreaUsuario);
			String usuarioCrear = usuario.getCedulaUsuario();
			if (cedulaCrear != null) {
				JOptionPane optionPane = new JOptionPane("La cedula ingresada ya existe en la base de datos",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("crearUsuario.jsp");
			} else if (usuarioCrear != null) {
				JOptionPane optionPane = new JOptionPane("El usuario ingresada ya existe en la base de datos",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("crearUsuario.jsp");
			} else {
				conexion.InsertarUsuario(CreaCedula, Creanombre, CreaCorreo, CreaUsuario, CreaContrasena);
				JOptionPane optionPane = new JOptionPane("Usuario creado exitosamente");
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("crearUsuario.jsp");
			}
		}

		else if (ActualizaCedula != null) {
			usuario cedula = conexion.consultarUsuario(ActualizaCedula);
			String actualizaCedula = cedula.getCedulaUsuario();
			if (actualizaCedula != null) {
				conexion.ActualizarUsuario(ActualizaCedula, Actualizanombre, ActualizaCorreo, ActualizaUsuario,
						ActualizaContrasena);
				JOptionPane optionPane = new JOptionPane(
						"El usuario " + ActualizaUsuario + " se actualizo exitosamente");
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("actualizarUsuario.jsp");
			} else {
				JOptionPane optionPane = new JOptionPane("La cedula del usuario que desea actualizar no existe",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("actualizarUsuario.jsp");
			}

		}
		
		//Eliminar usuario

		else if (cedulaBorrar != null) {
			usuario cedula = conexion.consultarUsuario(cedulaBorrar);
			String eliminaCedula = cedula.getCedulaUsuario();	
			if (eliminaCedula == null) {
				JOptionPane optionPane = new JOptionPane("La cedula del usuario que desea eliminar no existe",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("borrarUsuario.jsp");

			} else {
				if(cedulaBorrar.equals("123456")) {
					JOptionPane optionPane = new JOptionPane("El usuario administrador no se puede eliminar",
							JOptionPane.WARNING_MESSAGE);
					JDialog dialog = optionPane.createDialog("MinTech");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
					response.sendRedirect("borrarUsuario.jsp");
				}
				else {
				conexion.EliminaUsuario(cedulaBorrar);
				JOptionPane optionPane = new JOptionPane(
						"Se ha eliminado el usuario con numero de cedula " + cedulaBorrar);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("borrarUsuario.jsp");
				}
			}
		}


		// Modulo clientes
		// Consulta cliente

		
		//Modulo clientes
		//Consulta cliente
		/*
		else if (botonConsultaCliente != null) {

			cliente cliente = conexion.consultarCliente(botonConsultaCliente);
			String nombreCliente = cliente.getNombreCliente();
			String cedulaCliente = cliente.getCedulaCliente();
			String correoCliente = cliente.getCorreoCliente();
			String telefonoCliente = cliente.getTelefonoCliente();
			String direccionCliente = cliente.getDireccionCliente();
			if (nombreCliente != null) {
				JOptionPane optionPane = new JOptionPane("Nombre: " + nombreCliente + "\n" + "Cedula: " + cedulaCliente
						+ "\n" + "Correo: " + correoCliente + "\n" + "Teléfono: " + telefonoCliente + "\n" +  "Dirección: " + direccionCliente + "\n");
				JDialog dialog = optionPane.createDialog("Cliente");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("consultarCliente.jsp");
			}
			else {
				JOptionPane optionPane = new JOptionPane("La cedula del cliente no existe",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("consultarCliente.jsp");
			}
		}*/
		

		else if (CreaCedulaCliente != null) {
			cliente cedula = conexion.consultarCliente(CreaCedulaCliente);
			String cedulaCrearCliente = cedula.getCedulaCliente();
			if (cedulaCrearCliente != null) {
				JOptionPane optionPane = new JOptionPane("La cedula ingresada ya existe en la base de datos",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("crearCliente.jsp");
			} else {
				conexion.InsertarCliente(CreaCedulaCliente, CreanombreCliente, CreaDireccionCliente,
						CreaTelefonoCliente, CreaCorreoCliente);
				JOptionPane optionPane = new JOptionPane("Cliente creado exitosamente");
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("crearCliente.jsp");
			}
		}

		else if (ActualizaCedulaCliente != null) {
			cliente cedula = conexion.consultarCliente(ActualizaCedulaCliente);
			String actualizaCedula = cedula.getCedulaCliente();
			if (actualizaCedula != null) {
				conexion.ActualizarCliente(ActualizaCedulaCliente, ActualizanombreCliente, ActualizaDireccionCliente,
						ActualizaTelefonoCliente, ActualizaCorreoCliente);
				JOptionPane optionPane = new JOptionPane(
						"El cliente " + ActualizanombreCliente + " se actualizo exitosamente");
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("actualizarCliente.jsp");
			} else {
				JOptionPane optionPane = new JOptionPane("La cedula del cliente que desea actualizar no existe",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("actualizarCliente.jsp");
			}

		}

		else if (cedulaBorrarCliente != null) {
			cliente cedula = conexion.consultarCliente(cedulaBorrarCliente);
			String eliminaCedula = cedula.getCedulaCliente();
			if (eliminaCedula == null) {
				JOptionPane optionPane = new JOptionPane("La cedula del cliente que desea eliminar no existe",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("borrarCliente.jsp");
			} else {
				conexion.EliminaCliente(cedulaBorrarCliente);
				JOptionPane optionPane = new JOptionPane(
						"Se ha eliminado el cliente con numero de cedula " + cedulaBorrarCliente);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("borrarCliente.jsp");
			}
		}


		// Modulo proveedores

		
		//Modulo proveedores
		/*
		else if (botonConsultaProveedor != null) {

			proveedor proveedor = conexion.consultarProveedor(botonConsultaProveedor);
			String nombreProveedor = proveedor.getNombreProveedor();
			String nitProveedor = proveedor.getNit();
			String ciudadProveedor = proveedor.getCiudadProveedor();
			String telefonoProveedor = proveedor.getTelefonoProveedor();
			String direccionProveedor = proveedor.getDireccionProveedor();
			if (nombreProveedor != null) {
				JOptionPane optionPane = new JOptionPane("Nombre: " + nombreProveedor + "\n" + "Nit: " + nitProveedor
						+ "\n" + "Ciudad: " + ciudadProveedor + "\n" + "Teléfono: " + telefonoProveedor + "\n" +  "Dirección: " + direccionProveedor + "\n");
				JDialog dialog = optionPane.createDialog("Cliente");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("consultarProveedor.jsp");
			}
			else {
				JOptionPane optionPane = new JOptionPane("El nit del proveedor no existe",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("consultarProveedor.jsp");
			}
		}*/
		

		else if (CreaNitProveedor != null) {
			proveedor proveedor = conexion.consultarProveedor(CreaNitProveedor);
			String nitCrearCliente = proveedor.getNit();
			if (nitCrearCliente != null) {
				JOptionPane optionPane = new JOptionPane("El nit ingresado ya existe en la base de datos",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("crearProveedor.jsp");
			} else {
				conexion.InsertarProveedor(CreaNitProveedor, CreanombreProveedor, CreaDireccionProveedor,
						CreaTelefonoProveedor, CreaCiudadProveedor);
				JOptionPane optionPane = new JOptionPane("Proveedor creado exitosamente");
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("crearProveedor.jsp");
			}
		}

		else if (ActualizaNit != null) {
			proveedor proveedor = conexion.consultarProveedor(ActualizaNit);
			String actualizaNit = proveedor.getNit();
			if (actualizaNit != null) {
				conexion.ActualizarProveedor(ActualizaNit, ActualizanombreP, ActualizaDireccionP, ActualizaTelefonoP,
						ActualizaCiudadP);
				JOptionPane optionPane = new JOptionPane(
						"El proveedor " + ActualizanombreP + " se actualizo exitosamente");
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("actualizarProveedor.jsp");
			} else {
				JOptionPane optionPane = new JOptionPane("El nit del proveedor que desea actualizar no existe",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("actualizarProveedor.jsp");
			}

		}

		else if (nitBorrarP != null) {
			proveedor proveedor = conexion.consultarProveedor(nitBorrarP);
			String eliminaNit = proveedor.getNit();
			if (eliminaNit == null) {
				JOptionPane optionPane = new JOptionPane("El nit del proveedor que desea eliminar no existe",
						JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("borrarProveedor.jsp");
			} else {
				conexion.EliminaProveedor(nitBorrarP);
				JOptionPane optionPane = new JOptionPane(
						"Se ha eliminado el proveedor con numero de nit " + nitBorrarP);
				JDialog dialog = optionPane.createDialog("MinTech");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				response.sendRedirect("borrarProveedor.jsp");
			}
		}

	}

}
