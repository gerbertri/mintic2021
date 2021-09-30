package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;

import com.mysql.cj.xdevapi.Statement;

public class conector {
	private static Connection con = null;
	private Iterable<usuario> usuario;
	
	public static void conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			//con = DriverManager.getConnection("jdbc:mysql://localhost:3307/tienda_virtual", "root", "abc123");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/tienda_virtual", "root", "1234");
			System.out.println("Conexion exitosa con la base de datos");
		} catch (ClassNotFoundException e) {
			System.out.println("Error en el controlador de conexión" + e);
		} catch (SQLException e) {
			System.out.println("No se puede conectar con la base de datos");
			e.printStackTrace();
		}
	}

	// Modulo usuarios

	public Boolean validarUsuario(String usuario, String contrasena) {
		conectar();

		Boolean valido = false;
		String consultaU = "SELECT contrasenaUsuario FROM tienda_virtual.usuarios WHERE usuario = '" + usuario + "'";
		try {
			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(consultaU);
			if (rs.next()) {
				String contrasenaI = rs.getString("contrasenaUsuario");
				if (contrasenaI.equals(contrasena)) {
					valido = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valido;
	}

	public usuario consultarUsuario(String cedulaI) {
		conectar();
		usuario usuario = new usuario();
		String consulta = "SELECT * FROM tienda_virtual.usuarios WHERE cedulaUsuario = '" + cedulaI + "'";
		try {
			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(consulta);
			if (rs.next()) {
				String id = rs.getString("idusuarios");
				usuario.setIdUsuario(id);
				String nombre = rs.getString("nombreUsuario");
				usuario.setNombreUsuario(nombre);
				String cedula = rs.getString("cedulaUsuario");
				usuario.setCedulaUsuario(cedula);
				String correo = rs.getString("correoUsuario");
				usuario.setCorreoUsuario(correo);
				String usuarioC = rs.getString("usuario");
				usuario.setUsuario(usuarioC);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}

	public usuario consultarUsuarioU(String usuario) {
		conectar();
		usuario usuarioU = new usuario();
		String consulta = "SELECT * FROM tienda_virtual.usuarios WHERE usuario = '" + usuario + "'";
		try {
			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(consulta);
			if (rs.next()) {
				String nombre = rs.getString("nombreUsuario");
				usuarioU.setNombreUsuario(nombre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarioU;
	}

	public void InsertarUsuario(String cedula, String nombre, String correo, String usuario, String contrasena) {
		conectar();

		String consulta = "INSERT INTO tienda_virtual.usuarios (cedulaUsuario,nombreUsuario,correoUsuario,usuario,contrasenaUsuario) VALUES ('"
				+ cedula + "' , '" + nombre + "' , '" + correo + "' , '" + usuario + "' , '" + contrasena + "')";
		try {
			java.sql.Statement stm = con.createStatement();
			stm.executeUpdate(consulta);
		} catch (SQLException e) {
			System.out.println("No se ha logrado la operacion");
			e.printStackTrace();
		}
	}

	public void ActualizarUsuario(String cedula, String nombre, String correo, String usuario, String contrasena) {
		conectar();
		usuario idActualiza = consultarUsuario(cedula);
		String id = idActualiza.getIdUsuario();
		String consulta = "UPDATE tienda_virtual.usuarios SET nombreUsuario = '" + nombre + "' , correoUsuario = '"
				+ correo + "' , usuario = '" + usuario + "' , contrasenaUsuario = '" + contrasena
				+ "' WHERE idusuarios = " + id;
		try {
			java.sql.Statement stm = con.createStatement();
			stm.executeUpdate(consulta);
		} catch (SQLException e) {
			System.out.println("No se ha logrado la operacion");
			e.printStackTrace();
		}
	}

	public void EliminaUsuario(String cedulaE) {
		conectar();
		usuario idElimina = consultarUsuario(cedulaE);
		String id = idElimina.getIdUsuario();
		String consulta = "DELETE FROM tienda_virtual.usuarios WHERE idusuarios = " + id;
		try {
			java.sql.Statement stm = con.createStatement();
			stm.executeUpdate(consulta);
		} catch (SQLException e) {
			System.out.println("No se ha logrado la operacion");
			e.printStackTrace();
		}
	}

	// Modulo clientes

	public cliente consultarCliente(String cedulaI) {
		conectar();
		cliente cliente = new cliente();
		String consulta = "SELECT * FROM tienda_virtual.clientes WHERE cedulaCliente = '" + cedulaI + "'";
		try {
			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(consulta);
			if (rs.next()) {
				String cedula = rs.getString("cedulaCliente");
				cliente.setCedulaCliente(cedula);
				String nombre = rs.getString("nombreCliente");
				cliente.setNombreCliente(nombre);
				String direccion = rs.getString("direccionCliente");
				cliente.setDireccionCliente(direccion);
				String telefono = rs.getString("telefonoCliente");
				cliente.setTelefonoCliente(telefono);
				String correo = rs.getString("correoCliente");
				cliente.setCorreoCliente(correo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
	}

	public void InsertarCliente(String cedula, String nombre, String direccion, String telefono, String correo) {
		conectar();
		String consulta = "INSERT INTO tienda_virtual.clientes (cedulaCliente,nombreCliente,direccionCliente,telefonoCliente,correoCliente) VALUES ('"
				+ cedula + "' , '" + nombre + "' , '" + direccion + "' , '" + telefono + "' , '" + correo + "')";
		try {
			java.sql.Statement stm = con.createStatement();
			stm.executeUpdate(consulta);
		} catch (SQLException e) {
			System.out.println("No se ha logrado la operacion");
			e.printStackTrace();
		}
	}

	public void ActualizarCliente(String cedula, String nombre, String direccion, String telefono, String correo) {
		conectar();
		String consulta = "UPDATE tienda_virtual.clientes SET nombreCliente = '" + nombre + "' , direccionCliente = '"
				+ direccion + "' , telefonoCliente = '" + telefono + "' , correoCliente = '" + correo
				+ "' WHERE cedulaCliente = " + cedula;
		try {
			java.sql.Statement stm = con.createStatement();
			stm.executeUpdate(consulta);
		} catch (SQLException e) {
			System.out.println("No se ha logrado la operacion");
			e.printStackTrace();
		}
	}

	public void EliminaCliente(String cedulaE) {
		conectar();
		String consulta = "DELETE FROM tienda_virtual.clientes WHERE cedulaCliente = " + cedulaE;
		try {
			java.sql.Statement stm = con.createStatement();
			stm.executeUpdate(consulta);
		} catch (SQLException e) {
			System.out.println("No se ha logrado la operacion");
			e.printStackTrace();
		}
	}

	// Modulo proveedores

	public proveedor consultarProveedor(String nit) {
		conectar();
		proveedor proveedor = new proveedor();
		String consulta = "SELECT * FROM tienda_virtual.proveedores WHERE nit = '" + nit + "'";
		try {
			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(consulta);
			if (rs.next()) {
				String nitP = rs.getString("nit");
				proveedor.setNit(nitP);
				String nombre = rs.getString("nombreProveedor");
				proveedor.setNombreProveedor(nombre);
				String direccion = rs.getString("direccionProveedor");
				proveedor.setDireccionProveedor(direccion);
				String telefono = rs.getString("telefonoProveedor");
				proveedor.setTelefonoProveedor(telefono);
				String ciudad = rs.getString("ciudadProveedor");
				proveedor.setCiudadProveedor(ciudad);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proveedor;
	}

	public void InsertarProveedor(String nit, String nombre, String direccion, String telefono, String ciudad) {
		conectar();
		String consulta = "INSERT INTO tienda_virtual.proveedores (nit,nombreProveedor,direccionProveedor,telefonoProveedor,ciudadProveedor) VALUES ('"
				+ nit + "' , '" + nombre + "' , '" + direccion + "' , '" + telefono + "' , '" + ciudad + "')";
		try {
			java.sql.Statement stm = con.createStatement();
			stm.executeUpdate(consulta);
		} catch (SQLException e) {
			System.out.println("No se ha logrado la operacion");
			e.printStackTrace();
		}
	}

	public void ActualizarProveedor(String nit, String nombre, String direccion, String telefono, String ciudad) {
		conectar();
		String consulta = "UPDATE tienda_virtual.proveedores SET nombreProveedor = '" + nombre
				+ "' , direccionProveedor = '" + direccion + "' , telefonoProveedor = '" + telefono
				+ "' , ciudadProveedor = '" + ciudad + "' WHERE nit = " + nit;
		try {
			java.sql.Statement stm = con.createStatement();
			stm.executeUpdate(consulta);
		} catch (SQLException e) {
			System.out.println("No se ha logrado la operacion");
			e.printStackTrace();
		}
	}

	public void EliminaProveedor(String nit) {
		conectar();
		String consulta = "DELETE FROM tienda_virtual.proveedores WHERE nit = " + nit;
		try {
			java.sql.Statement stm = con.createStatement();
			stm.executeUpdate(consulta);
		} catch (SQLException e) {
			System.out.println("No se ha logrado la operacion");
			e.printStackTrace();
		}
	}

	// Modulo productos
	public List<productos> leerProductos(String url) throws IOException {
		conectar();
		List<productos> productos = new ArrayList<productos>();
		CsvReader leerProductos;
		try {
			leerProductos = new CsvReader(url);
			leerProductos.readHeaders();
			while (leerProductos.readRecord()) {

				String productosobt = leerProductos.get(0);
				String[] producto = (productosobt.split(";"));
		
				String codigoProducto = producto[0];
				String nombreProducto = producto[1];
				String nitProveedor = producto[2];
				String precioCompra = producto[3];
				String iva = producto[4];
				String precioVenta = producto[5];
				
				productos.add(
						new productos(codigoProducto, nombreProducto, nitProveedor, precioCompra, iva, precioVenta));
			
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return productos;
	}
	
	
	public Boolean subirProductos(List<productos> productos) throws IOException, SQLException {
		Boolean valido = false;
		conectar();
		String eliminar = "DELETE FROM tienda_virtual.productos";
		java.sql.Statement stm = con.createStatement();
		stm.executeUpdate(eliminar);
		String query = "INSERT INTO tienda_virtual.productos(codigoProducto, nombreProducto, nitProveedor, precioCompra, iva, precioVenta) VALUES(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
			for(int i=0; i< productos.size(); i++) {
				ps.setString(1, productos.get(i).getCodigoProducto());
				ps.setString(2, productos.get(i).getNombreProducto());
				ps.setString(3, productos.get(i).getNitProveedor());
				ps.setString(4, productos.get(i).getPrecioCompra());
				ps.setString(5, productos.get(i).getIva());
				ps.setString(6, productos.get(i).getPrecioVenta());
				
				System.out.println("Se inserta" + (i+1) + productos.size());
				String prov = productos.get(i).getNitProveedor();
				String proveedor = "SELECT * FROM tienda_virtual.proveedores WHERE nit = " + prov ;
				java.sql.Statement stmc = con.createStatement();
				ResultSet rs = stmc.executeQuery(proveedor);
				if (rs.next()) {
				ps.executeUpdate();
				valido = true;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return valido;
		
	}
	
	// Modulo ventas
	
	public productos consultarProducto(String codigo) {
		conectar();
		productos producto = new productos();
		String consulta = "SELECT * FROM tienda_virtual.productos WHERE codigoProducto = '" + codigo + "'";
		try {
			java.sql.Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(consulta);
			if (rs.next()) {
				
				producto.setCodigoProducto(rs.getString("codigoProducto"));
				producto.setNombreProducto(rs.getString("nombreProducto"));
				producto.setNitProveedor(rs.getString("nitProveedor"));
				producto.setPrecioCompra(rs.getString("precioCompra"));
				producto.setIva(rs.getString("iva"));
				producto.setPrecioVenta(rs.getString("precioVenta"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return producto;
	}
	
}
