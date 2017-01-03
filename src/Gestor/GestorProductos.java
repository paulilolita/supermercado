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
		listaproductos.add(c);
		db.anadirProducto(c.getNombre(), c.getPrecio(), null, c.isHidratoFavorable(), null, null);
		
	}
	public static void anadirZanahoria (Zanahoria z)
	{
		listaproductos.add(z);
		db.anadirProducto(z.getNombre(), z.getPrecio(), null, z.isHidratoFavorable(),null, null);
		
	}
	public static void anadirEspagueti (Espagueti e)
	{
		listaproductos.add(e);
		db.anadirProducto(e.getNombre(), e.getPrecio(), e.getOrigen(),null, null, null);
		
	}
	public static void anadirTortellini (Tortellini t)
	{
		listaproductos.add(t);
		db.anadirProducto(t.getNombre(), t.getPrecio(), t.getOrigen(),null , null, null);
		
	}
	public static void anadirBlanco (Blanco b)
	{
		listaproductos.add(b);
		db.anadirProducto(b.getNombre(), b.getPrecio(), null, null, b.getAno(), b.getLitros());
		
	}
	public static void anadirTinto (Tinto t)
	{
		listaproductos.add(t);
		db.anadirProducto(t.getNombre(), t.getPrecio(), null, null, t.getAno(), t.getLitros());
		
	}
	public static void anadirPlatano (Platano p)
	{
		listaproductos.add(p);
		db.anadirProducto(p.getNombre(), p.getPrecio(), null, null, null, null);
		
	}
	public static void anadirKiwi (Kiwi k)
	{
		listaproductos.add(k);
		db.anadirProducto(k.getNombre(), k.getPrecio(), null, null, null, null);
		
	}
	public static void anadirFilete (Filete f)
	{
		listaproductos.add(f);
		db.anadirProducto(f.getNombre(), f.getPrecio(), null, null, null, null);
		
	}
	public static void anadirEntrecot (Entrecot e)
	{
		listaproductos.add(e);
		db.anadirProducto(e.getNombre(), e.getPrecio(), null, null, null, null);
		
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
			System.out.println("producot eliminado");
		}
		else
		{
			System.out.println("se ha intentado eliminar con id inexistente");
		}
	}
}
