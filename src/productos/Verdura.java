package productos;

import java.util.ArrayList;

public abstract class Verdura extends Comida{

	private boolean hidratoFavorable;

	public boolean isHidratoFavorable() {
		return hidratoFavorable;
	}

	protected void setHidratoFavorable(boolean hidratoFavorable) {
		this.hidratoFavorable = hidratoFavorable;
	}
	public ArrayList<String> getPropiedades()
	{
		ArrayList<String> propiedades = super.getPropiedades();
		propiedades.add("¿Hidrato favorable? ");
		
		return propiedades;
	}
	public ArrayList<String> getValores()
	{
		ArrayList<String> valores = super.getValores();
		valores.add(Boolean.toString(this.hidratoFavorable));
		
		return valores;
	}
	
	
}
