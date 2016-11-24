package supermercado;

public abstract class Verdura extends Comida{

	private boolean hidratoFavorable;

	public boolean isHidratoFavorable() {
		return hidratoFavorable;
	}

	protected void setHidratoFavorable(boolean hidratoFavorable) {
		this.hidratoFavorable = hidratoFavorable;
	}
	
	
}
