package Gestor;

import java.util.ArrayList;



import BaseDatos.db;
import productos.*;

public class GestorProductos {
	
	public static ArrayList<Producto> listaproductos= new ArrayList<Producto>();
    
	public static int cantidadTipoProducto(String nombre)
	{
		int contador;
		contador=0;
		for (int i=0; i< listaproductos.size(); i++)
		{
			if (listaproductos.get(i).getNombre().compareTo(nombre) == 0)
			{
				contador++;
			}
		}
		return contador;
	}
	public static ArrayList<Producto> obtenerproductos (String nombre)
	{
		ArrayList<Producto> resultado= new ArrayList<Producto>();
		for (int i=0; i < listaproductos.size();i++)
		{
			if (listaproductos.get(i).getNombre().compareTo(nombre)== 0)
			{
				resultado.add(listaproductos.get(i));
			}
		}
		return resultado;
	}
	public static boolean cargarProducto(Producto p)
    {
        return listaproductos.add(p);
    }
	public static void anadirCebolla (Cebolla c)
	{
		
		int id= db.anadirProducto(c.getNombre(), c.getPrecio(), null, c.isHidratoFavorable(), null, null);
		c.setId(id);
		listaproductos.add(c);
		
	}
	public static void anadirZanahoria (Zanahoria z)
	{
		
		int id=db.anadirProducto(z.getNombre(), z.getPrecio(), null, z.isHidratoFavorable(),null, null);
		z.setId(id);
		listaproductos.add(z);
		
	}
	public static void anadirEspagueti (Espagueti e)
	{
		
		int id=db.anadirProducto(e.getNombre(), e.getPrecio(), e.getOrigen(),null, null, null);
		e.setId(id);
		listaproductos.add(e);
		
	}
	public static void anadirTortellini (Tortellini t)
	{
		
		int id=db.anadirProducto(t.getNombre(), t.getPrecio(), t.getOrigen(),null , null, null);
		t.setId(id);
		listaproductos.add(t);
		
	}
	public static void anadirBlanco (Blanco b)
	{
		
		int id=db.anadirProducto(b.getNombre(), b.getPrecio(), null, null, b.getAno(), b.getLitros());
		b.setId(id);
		listaproductos.add(b);
		
	}
	public static void anadirTinto (Tinto t)
	{
		
		int id=db.anadirProducto(t.getNombre(), t.getPrecio(), null, null, t.getAno(), t.getLitros());
		t.setId(id);
		listaproductos.add(t);
		
	}
	public static void anadirPlatano (Platano p)
	{
		
		int id=db.anadirProducto(p.getNombre(), p.getPrecio(), null, null, null, null);
		p.setId(id);
		listaproductos.add(p);
		
	}
	public static void anadirKiwi (Kiwi k)
	{
		
		int id=db.anadirProducto(k.getNombre(), k.getPrecio(), null, null, null, null);
		k.setId(id);
		listaproductos.add(k);
		
	}
	public static void anadirFilete (Filete f)
	{
		
		int id=db.anadirProducto(f.getNombre(), f.getPrecio(), null, null, null, null);
		f.setId(id);
		listaproductos.add(f);
		
	}
	public static void anadirEntrecot (Entrecot e)
	{
		
		int id=db.anadirProducto(e.getNombre(), e.getPrecio(), null, null, null, null);
		e.setId(id);
		listaproductos.add(e);
		
	}
	public static void eliminarProducto (int id)
	{
		int posicion=-1;
		for (int i=0; i<listaproductos.size();i++)
		{
			if (listaproductos.get(i).getId() == id)
			{
				posicion= i;
				break;
			}
			
		}
		if (posicion>-1)
		{
			listaproductos.remove(posicion);
			db.eliminarProducto(id);
		}
		else
		{
			System.out.println("se ha intentado eliminar con id inexistente");
		}
	}
}
