package Gestor;

import static org.junit.Assert.*;

import org.junit.Test;

import Usuarios.Usuario;
import productos.Platano;

public class TestGestorProductos {
	@Test
	public void testCantidadProducto() {
		int cantidad=0;
		cantidad=cantidad + GestorProductos.cantidadTipoProducto("Platano");
		cantidad=cantidad + GestorProductos.cantidadTipoProducto("Kiwi");
		cantidad=cantidad + GestorProductos.cantidadTipoProducto("Zanahoria");
		cantidad=cantidad + GestorProductos.cantidadTipoProducto("Cebolla");
		cantidad=cantidad + GestorProductos.cantidadTipoProducto("Blanco");
		cantidad=cantidad + GestorProductos.cantidadTipoProducto("Tinto");
		cantidad=cantidad + GestorProductos.cantidadTipoProducto("Tortellini");
		cantidad=cantidad + GestorProductos.cantidadTipoProducto("Espagueti");
		cantidad=cantidad + GestorProductos.cantidadTipoProducto("Entrecot");
		cantidad=cantidad + GestorProductos.cantidadTipoProducto("Filete");
		assertTrue(cantidad==GestorProductos.listaproductos.size());
	}

	@Test
	public void testEliminarProducto() {
		Usuario user = new Usuario();
		user.setNombre("AlonsoTest");
		user.setApellido("GonzalezTest");
		user.setEmail("alonsogonzalez@gmail.comTest");
		user.setTelefono("674356490");
		GestorProductos.usuario=user;
		//Hay que crear un usuario para que no falle el registro
		GestorProductos.listaproductos.clear();
		Platano p= new Platano();
		GestorProductos.anadirPlatano(p);
		int cantidadantes= GestorProductos.listaproductos.size();
		GestorProductos.eliminarProducto(p.getId());
		//debería haberlo borrado
		int cantidaddespues1= GestorProductos.listaproductos.size();
		assertTrue(cantidadantes==(cantidaddespues1 + 1));
		
		//no debería haberlo borrado porque ya está borrado
		GestorProductos.eliminarProducto(p.getId());
		int cantidaddespues2= GestorProductos.listaproductos.size();
		assertTrue(cantidaddespues1 == cantidaddespues2);
	}
	
	@Test
	public void testAnadirPlatano() {
		GestorProductos.listaproductos.clear();
		int cantidadantes= GestorProductos.cantidadTipoProducto("Platano");
		Platano p= new Platano();
		GestorProductos.anadirPlatano(p);
		int cantidaddespues= GestorProductos.cantidadTipoProducto("Platano");
		assertTrue(cantidadantes==cantidaddespues - 1);
	}

}
