package productos;

import java.util.ArrayList;

public abstract class Pasta extends Comida{
	
	private String origen;

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
	public ArrayList<String> getPropiedades()
	{
		ArrayList<String> propiedades = super.getPropiedades();
		propiedades.add("Origen: " + this.origen);
		
		return propiedades;
	}

}
