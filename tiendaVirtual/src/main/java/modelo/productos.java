package modelo;

public class productos {

	 private String codigoProducto;
	 private String nombreProducto;
	 private String nitProveedor;
	 private String precioCompra;
	 private String iva;
	 private String precioVenta; 
	 
	public productos(String codigoProducto, String nombreProducto, String nitProveedor, String precioCompra, String iva,
			String precioVenta) {
		super();
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.nitProveedor = nitProveedor;
		this.precioCompra = precioCompra;
		this.iva = iva;
		this.precioVenta = precioVenta;
	}
	public productos() {}
	
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getNitProveedor() {
		return nitProveedor;
	}
	public void setNitProveedor(String nitProveedor) {
		this.nitProveedor = nitProveedor;
	}
	public String getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(String precioCompra) {
		this.precioCompra = precioCompra;
	}
	public String getIva() {
		return iva;
	}
	public void setIva(String iva) {
		this.iva = iva;
	}
	public String getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(String precioVenta) {
		this.precioVenta = precioVenta;
	}
	
}
