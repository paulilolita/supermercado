package vistas;

import BaseDatos.db;
import Image.Supermercado;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VentanaRegistro miVentana = new VentanaRegistro();
		miVentana.setVisible( true );
		initBD();
		
	}
	private static void initBD()
	{
	
		db.initBD("Tienda.bd");
		db.crearTablaUsuarios();
		db.anadirUsuario();
		db.crearTablaProductos();
		db.cargarproductos();
	}

}
