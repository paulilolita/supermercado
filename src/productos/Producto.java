package productos;

import java.util.ArrayList;

public abstract class Producto {

	private String nombre;
	private int precio;
	private int cantidad;
		
	public String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public ArrayList<String> getPropiedades()
	{
		ArrayList<String> propiedades = new ArrayList<String>();
		propiedades.add("Nombre: " + this.nombre);
		propiedades.add("Precio: " + this.precio);
		propiedades.add("Cantidad: " + this.cantidad);
		
		return propiedades;
	}

}
