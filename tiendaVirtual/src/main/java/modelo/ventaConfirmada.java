package modelo;

public class ventaConfirmada {
	
	private String celudula_cliente;
	private String cedula_usuario;
	private String valor_venta;
	private String valor_iva;
	private String valor_totalVenta;
	public ventaConfirmada(String celudula_cliente, String cedula_usuario, String valor_venta, String valor_iva,
			String valor_totalVenta) {
		super();
		this.celudula_cliente = celudula_cliente;
		this.cedula_usuario = cedula_usuario;
		this.valor_venta = valor_venta;
		this.valor_iva = valor_iva;
		this.valor_totalVenta = valor_totalVenta;
	}
	
	public ventaConfirmada() {};
	
	public String getCeludula_cliente() {
		return celudula_cliente;
	}
	public void setCeludula_cliente(String celudula_cliente) {
		this.celudula_cliente = celudula_cliente;
	}
	public String getCedula_usuario() {
		return cedula_usuario;
	}
	public void setCedula_usuario(String cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}
	public String getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(String valor_venta) {
		this.valor_venta = valor_venta;
	}
	public String getValor_iva() {
		return valor_iva;
	}
	public void setValor_iva(String valor_iva) {
		this.valor_iva = valor_iva;
	}
	public String getValor_totalVenta() {
		return valor_totalVenta;
	}
	public void setValor_totalVenta(String valor_totalVenta) {
		this.valor_totalVenta = valor_totalVenta;
	}
	
	

}
