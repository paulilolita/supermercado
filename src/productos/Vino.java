package productos;

import java.util.ArrayList;

public abstract class Vino extends Bebida{
	
	private int ano;
	private float litros;
	
	
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public float getLitros() {
		return litros;
	}
	public void setLitros(float litros) {
		this.litros = litros;
	}
	public ArrayList<String> getPropiedades()
	{
		ArrayList<String> propiedades = super.getPropiedades();
		propiedades.add("Año");
		propiedades.add("Litros");
		
		return propiedades;
	}
	public ArrayList<String> getValores()
	{
		ArrayList<String> valores = super.getValores();
		valores.add(Integer.toString(this.ano));
		valores.add(Float.toString(this.litros));
		
		return valores;
	}
	
	

}
