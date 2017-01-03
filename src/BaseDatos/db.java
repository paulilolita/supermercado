package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Usuarios.Administrador;
import Gestor.GestorProductos;
import productos.*;

public class db {
	
	private static Connection connection = null;
	private static Statement statement = null;

	/** Inicializa una BD SQLITE y devuelve una conexión con ella. Debe llamarse a este 
	 * método antes que ningún otro, y debe devolver no null para poder seguir trabajando con la BD.
	 * @param nombreBD	Nombre de fichero de la base de datos
	 * @return	Conexión con la base de datos indicada. Si hay algún error, se devuelve null
	 */
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    connection = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
		    return connection;
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog( null, "Error de conexión!! No se ha podido conectar con " + nombreBD , "ERROR", JOptionPane.ERROR_MESSAGE );
			System.out.println( "Error de conexión!! No se ha podido conectar con " + nombreBD );
			return null;
		}
	}
	
	/** Cierra la conexión con la Base de Datos
	 */
	public static void close() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Devuelve la conexión si ha sido establecida previamente (#initBD()).
	 * @return	Conexión con la BD, null si no se ha establecido correctamente.
	 */
	public static Connection getConnection() {
		return connection;
	}
	
	/** Devuelve una sentencia para trabajar con la BD,
	 * si la conexión si ha sido establecida previamente (#initBD()).
	 * @return	Sentencia de trabajo con la BD, null si no se ha establecido correctamente.
	 */
	public static Statement getStatement() {
		return statement;
	}

	// ------------------------------------
	// PARTICULAR DEL CATALOGO MULTIMEDIA
	// ------------------------------------
	
	/** Crea una tabla de catálogo multimedia en una base de datos, si no existía ya.
	 * Debe haberse inicializado la conexión correctamente.
	 */
	public static void crearTablaProductos() {
		if (statement==null) return;
		try {
			statement.executeUpdate("create table productos " +
				"(id integer, nombre string, precio float, cantidad integer, origen string, hidratoFavorable boolean, ano integer, litros float, PRIMARY KEY (id))");
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	public static void crearTablaUsuarios() {
		if (statement==null) return;
		try {
			 statement.executeUpdate("create table usuarios (nombre string, contrasena string , PRIMARY KEY (nombre))");
					
				System.out.println("tabla usuarios creada");
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	public static void anadirUsuario() {
		if (statement==null) return;
		try {
			String sql = "insert into usuarios (nombre, contrasena) values ('administrador', 'admin')";
			PreparedStatement st = connection.prepareStatement(sql);
			st.execute();
			st.close();
					
				System.out.println("añadido usuario administrador");
		} catch (SQLException e) {
			// Si hay excepción es que el usuario ya existe
			// e.printStackTrace();  
		}
	}
	public static Administrador cargarUsuario(String nombre)
	{
		try {
            Administrador admin= new Administrador();
            String contrasena;
            PreparedStatement st = connection.prepareStatement("select * from usuarios where nombre = ?");
            st.setString(1, nombre);
            ResultSet resultado = st.executeQuery();
            contrasena= resultado.getString("contrasena");
            admin.setNombre(nombre);
            admin.setContrasena(contrasena);
            return admin;
		}
		catch(SQLException e)
		{
			return null;
		}
            
            
	}
	public static int anadirProducto( String nombre, double precio, String origen, Boolean hidratoFavorable, Integer ano, Float litros) {
		int id = -1;
		if (statement==null) return -1;
		try {
			String sql = "insert into productos (nombre, precio, origen, hidratoFavorable, ano, litros)" +
				" values (?,?,?, ?,?,?)";
			PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, nombre);
			st.setDouble(2, precio);
			if (origen != null) {
				   st.setString(3, origen);
				} else {
				   st.setNull(3, Types.VARCHAR);
				}
			if (hidratoFavorable != null) {
				   st.setBoolean(4, hidratoFavorable);
				} else {
				   st.setNull(4, Types.BOOLEAN);
				}
			if (ano != null) {
				   st.setInt(5, ano);
				} else {
				   st.setNull(5, Types.INTEGER);
				}
			if (litros != null) {
				   st.setFloat(6, litros);
				} else {
				   st.setNull(6, Types.FLOAT);
				}
			
			st.execute();
			 try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		                id = generatedKeys.getInt(1);
		            }
		            else {
		                throw new SQLException("No se ha podido obtener el ID del producto creado");
		            }
		        }
			
			st.close();
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
		return id;
	}
	public static void cargarproductos()
	{
		System.out.println("cargar productos bd");
		try {
			Statement stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery("select * from productos");
            Producto nuevo;
            while ( resultado.next() ) {
            	 String tipoproducto= resultado.getString("nombre");
				  switch(tipoproducto)
				  {
					case "Platano":
						nuevo= new Platano();
						break;
					case "Kiwi":
						nuevo= new Kiwi();
						break;
					case "Espagueti":
						nuevo= new Espagueti();
						((Pasta) nuevo).setOrigen(resultado.getString("origen"));
						break;
					case "Tortellini":
						nuevo= new Tortellini();
						((Pasta) nuevo).setOrigen(resultado.getString("origen"));
						break;
					case "Blanco":
						nuevo= new Blanco();
						((Vino) nuevo).setAno(resultado.getInt("ano"));
						((Vino) nuevo).setLitros(resultado.getFloat("litros"));
						break;
					case "Tinto":
						nuevo=new Tinto();
						((Vino) nuevo).setAno(resultado.getInt("ano"));
						((Vino) nuevo).setLitros(resultado.getFloat("litros"));
						break;
					case "Cebolla":
						nuevo= new Cebolla();
						break;
					case "Zanahoria":
						nuevo=  new Zanahoria();
						break;
					case "Filete":
						nuevo= new Filete();
						break;
					case "Entrecot":
						nuevo=  new Entrecot();
						break;
					default:
						nuevo=null;
						System.out.println("cuidado se ha intentado crear un producto de tipo desconocido: " + tipoproducto);
				  }
				  nuevo.setId(resultado.getInt("id"));
				  GestorProductos.cargarProducto(nuevo);
            }
            resultado.close();
            stmt.close();
			System.out.println("cerrado");
			
			System.out.println(GestorProductos.listaproductos.size());
		} catch (SQLException e) {
			System.out.println ("No se han podido obtener los productos: " + e.getMessage());  
		}
	}
	public static void eliminarProducto (int id)
	{
		if (connection==null) return;
		try {
			String sql = "delete from productos where id= ?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			st.close();
		}
		catch(SQLException e)
		{
			System.out.println("No se ha podido eliminar el producto");
		}
	}
}
