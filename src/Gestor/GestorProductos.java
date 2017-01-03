package Gestor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;






import java.util.Date;

import Usuarios.Usuario;
import Usuarios.UsuarioAbstracto;
import BaseDatos.db;
import productos.*;

public class GestorProductos {
	
	public static ArrayList<Producto> listaproductos= new ArrayList<Producto>();
	public static UsuarioAbstracto usuario;
    
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
	public static void escribirRegistro(Producto p)
	{
		String separador = ",";
		Usuario user = (Usuario) GestorProductos.usuario;
		String linea= user.getNombre();
		linea= linea + separador + user.getApellido();
		linea= linea + separador + user.getEmail();
		linea= linea + separador + user.getTelefono();
		Date fecha= new Date();
		linea=linea + separador + fecha.toString();
		
		ArrayList<String> valores=p.getValores();
		for (int i=1;i<valores.size();i++)
		{
			linea=linea + separador + valores.get(i);
		}
		try{
		    PrintWriter writer = new PrintWriter(new FileOutputStream(new File("Registro-Compras.txt"), true));
		    writer.println(linea);
		    //writer.append(linea);
		    writer.close();
		} catch (IOException e) {
		   System.out.println("Ha ocurrido un error al escribir en el registro");
		}
		
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
		escribirRegistro(listaproductos.get(posicion));
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
