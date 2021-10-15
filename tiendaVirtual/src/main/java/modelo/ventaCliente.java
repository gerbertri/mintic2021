package modelo;

public class ventaCliente {
		private String cedula;
		private String nombre;
		private String valorTotalVenta;
		public ventaCliente(String cedula, String nombre, String valorTotalVenta) {
			super();
			this.cedula = cedula;
			this.nombre = nombre;
			this.valorTotalVenta = valorTotalVenta;
		}
		
		public ventaCliente() {}
		
		public String getCedula() {
			return cedula;
		}
		public void setCedula(String cedula) {
			this.cedula = cedula;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getValorTotalVenta() {
			return valorTotalVenta;
		}
		public void setValorTotalVenta(String valorTotalVenta) {
			this.valorTotalVenta = valorTotalVenta;
		}
		
		
}
