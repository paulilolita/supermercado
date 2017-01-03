package productos;

import java.util.ArrayList;

public abstract class Producto {

	private String nombre;
	private double precio;
	private int id;
		
	public String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	protected void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public ArrayList<String> getPropiedades()
	{
		ArrayList<String> propiedades = new ArrayList<String>();
		propiedades.add("Id");
		propiedades.add("Nombre");
		propiedades.add("Precio");

		
		return propiedades;
	}
	
	public ArrayList<String> getValores()
	{
		ArrayList<String> valores = new ArrayList<String>();
		valores.add(Integer.toString(this.id));
		valores.add(this.nombre);
		valores.add(Double.toString(this.precio));	
		
		return valores;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
