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
		propiedades.add("A�o: " + this.ano);
		propiedades.add("Litros: " + this.litros);
		
		return propiedades;
	}
	
	

}
