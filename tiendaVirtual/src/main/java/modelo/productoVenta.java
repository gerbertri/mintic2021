package modelo;

public class productoVenta {
	private productos producto;
	
	productos listaproducto[]=new productos[3];
	public void agregarProductoVenta(productos producto, int i) {
		
		listaproducto[i]=producto;
		
	}
	
	public productos[] retornarProductos() {
		
		return listaproducto;
	}
	
	
}
