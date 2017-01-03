package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Gestor.GestorProductos;
import Image.Cebolla;
import Image.Entrecot;
import Image.Espaguetis;
import Image.Filete;
import Image.Kiwi;
import Image.Platano;
import Image.Supermercado;
import Image.Tortellini;
import Image.Blanco;
import Image.Tinto;
import Image.Zanahoria;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public class VentanaProductos extends JFrame{
	
	private JLabel cebollacantidad;
	private JLabel tortellinicantidad;
	private JLabel zanahoriacantidad;
	private JLabel blancocantidad;
	private JLabel kiwicantidad;
	private JLabel entrecotcantidad;
	private JLabel filetecantidad;
	private JLabel espagueticantidad;
	private JLabel tintocantidad;
	private JLabel platanocantidad;
	
	public VentanaProductos()
	{
		JPanel principal = new JPanel();
        //SE CARGAN TODAS LAS IMAGENES EN EL JFRAME
		
		Zanahoria zanahoria = new Zanahoria();
		principal.add(zanahoria);
		principal.repaint();
		zanahoria.setSize(200, 200);
		zanahoria.setLocation(300, 0);
		Cebolla cebolla = new Cebolla();
		principal.add(cebolla);
		principal.repaint();
		cebolla.setSize(200, 200);
		Blanco vino = new Blanco();
		principal.add(vino);
		principal.repaint();
		vino.setSize(225, 200);
		vino.setLocation(575, 0);
		Tinto vinotinto = new Tinto();
		principal.add(vinotinto);
		principal.repaint();
		vinotinto.setSize(200, 200);                                                                                                                                                                                                                                                                                                                               
		vinotinto.setLocation(850, 0);
		Kiwi kiwi = new Kiwi();
		principal.add(kiwi);
		principal.repaint();
		kiwi.setSize(200, 200);
		kiwi.setLocation(1150, 0);
		Entrecot entrecot = new Entrecot();
		principal.add(entrecot);
		principal.repaint();
		entrecot.setSize(200, 200);
		entrecot.setLocation(0, 350);
		Filete filete = new Filete();
		principal.add(filete);
		principal.repaint();
		filete.setSize(200, 200);
		filete.setLocation(300, 350);
		Espaguetis espaguetis = new Espaguetis();
		principal.add(espaguetis);
		principal.repaint();
		espaguetis.setSize(200, 200);
		espaguetis.setLocation(575, 350);
		Tortellini tortellini = new Tortellini();
		principal.add(tortellini);
		principal.repaint();
		tortellini.setSize(200, 200);
		tortellini.setLocation(850, 350);
		Platano platano = new Platano();
		principal.add(platano);
		principal.repaint();
		platano.setSize(200, 200);
		platano.setLocation(1150, 350);
		
		//SE CREAN LOS JPANEL, JLABEL Y JBUTTON CORRESPONDIENETES A CADA PRODCUTO
		principal.setLayout( null );
		principal.setBackground( Color.pink );
		getContentPane().add( principal, BorderLayout.CENTER );
		//CEBOLLA
		JPanel cebollapanel = new JPanel();
		cebollapanel.setBackground(Color.PINK);
		cebollapanel.setForeground(Color.WHITE);
		cebollapanel.setBounds(0, 211, 160, 170);
		principal.add(cebollapanel);
		
		
		JButton cebollaboton = new JButton("Comprar");
		cebollaboton.setFont(new Font("Tahoma", Font.BOLD, 11));
		cebollapanel.add(cebollaboton);
		productos.Cebolla auxcebolla = new productos.Cebolla();
		JLabel cebollanombre = new JLabel("Nombre: " + auxcebolla.getNombre()+ "    ");
		JLabel cebollaprecio = new JLabel("Precio: " + auxcebolla.getPrecio() + "          ");
		cebollacantidad = new JLabel("Cantidad: " + GestorProductos.cantidadTipoProducto(auxcebolla.getNombre()));
		cebollapanel.add(cebollanombre);
		cebollapanel.add(cebollaprecio);
		cebollapanel.add(cebollacantidad);
		
		//ZANAHORIA
		JPanel zanahoriapanel = new JPanel();
		zanahoriapanel.setBackground(Color.PINK);
		zanahoriapanel.setForeground(Color.WHITE);
		zanahoriapanel.setBounds(300, 211, 160, 150);
		principal.add(zanahoriapanel);
		
		JButton zanahoriaboton = new JButton("Comprar");
		zanahoriaboton.setFont(new Font("Tahoma", Font.BOLD, 11));
		zanahoriapanel.add(zanahoriaboton);
		productos.Zanahoria auxzanahoria = new productos.Zanahoria();
		JLabel zanahorianombre = new JLabel("Nombre: " + auxzanahoria.getNombre());
		JLabel zanahoriaprecio = new JLabel("Precio: " + auxzanahoria.getPrecio() + "       ");
		zanahoriacantidad = new JLabel("Cantidad: " + GestorProductos.cantidadTipoProducto(auxzanahoria.getNombre()));
		zanahoriapanel.add(zanahorianombre);
		zanahoriapanel.add(zanahoriaprecio);
		zanahoriapanel.add(zanahoriacantidad);
		//BLANCO
		JPanel blancopanel = new JPanel();
		blancopanel.setForeground(Color.WHITE);
		blancopanel.setBackground(Color.PINK);
		blancopanel.setBounds(575, 211, 150, 150);
		principal.add(blancopanel);
		
		JButton blancoboton = new JButton("Comprar");
		blancoboton.setFont(new Font("Tahoma", Font.BOLD, 11));
		blancopanel.add(blancoboton);
		productos.Blanco auxblanco = new productos.Blanco();
		JLabel blanconombre = new JLabel("Nombre: " + auxblanco.getNombre() + "      ");
		JLabel blancoprecio = new JLabel("Precio: " + auxblanco.getPrecio() + "        ");
		blancocantidad = new JLabel("Cantidad: " + GestorProductos.cantidadTipoProducto(auxblanco.getNombre()));
		blancopanel.add(blanconombre);
		blancopanel.add(blancoprecio);
		blancopanel.add(blancocantidad);
		//TINTO
		JPanel tintopanel = new JPanel();
		tintopanel.setBackground(Color.PINK);
		tintopanel.setBounds(850, 211, 150, 148);
		principal.add(tintopanel);
		
		JButton tintoboton = new JButton("Comprar");
		tintoboton.setFont(new Font("Tahoma", Font.BOLD, 11));
		tintopanel.add(tintoboton);
		productos.Tinto auxtinto = new productos.Tinto();
		JLabel tintonombre = new JLabel("Nombre: " + auxtinto.getNombre()+ "     ");
		JLabel tintoprecio = new JLabel("Precio: " + auxtinto.getPrecio()+ "    ");
		tintocantidad = new JLabel("Cantidad: " + GestorProductos.cantidadTipoProducto(auxtinto.getNombre()));
		tintopanel.add(tintonombre);
		tintopanel.add(tintoprecio);
		tintopanel.add(tintocantidad);
		//KIWI
		JPanel kiwipanel = new JPanel();
		kiwipanel.setBackground(Color.PINK);
		kiwipanel.setBounds(1150, 211, 150, 148);
		principal.add(kiwipanel);
		
		JButton kiwiboton = new JButton("Comprar");
		kiwiboton.setFont(new Font("Tahoma", Font.BOLD, 11));
		kiwipanel.add(kiwiboton);
		productos.Kiwi auxkiwi = new productos.Kiwi();
		JLabel kiwinombre = new JLabel("Nombre: " + auxkiwi.getNombre() + "       ");
		JLabel kiwiprecio = new JLabel("Precio: " + auxkiwi.getPrecio() + "    ");
		kiwicantidad = new JLabel("Cantidad: " + GestorProductos.cantidadTipoProducto(auxkiwi.getNombre()));
		kiwipanel.add(kiwinombre);
		kiwipanel.add(kiwiprecio);
		kiwipanel.add(kiwicantidad);
		//ENTRECOT
		JPanel entrecotpanel = new JPanel();
		entrecotpanel.setBackground(Color.PINK);
		entrecotpanel.setBounds(0, 561, 150, 145);
		principal.add(entrecotpanel);
		
		JButton entrecotboton = new JButton("Comprar");
		entrecotboton.setFont(new Font("Tahoma", Font.BOLD, 11));
		entrecotpanel.add(entrecotboton);
		productos.Entrecot auxentrecot = new productos.Entrecot();
		JLabel entrecotnombre = new JLabel("Nombre: " + auxentrecot.getNombre()+ "   ");
		JLabel entrecotprecio = new JLabel("Precio: " + auxentrecot.getPrecio() + "    ");
		entrecotcantidad = new JLabel("Cantidad: " + GestorProductos.cantidadTipoProducto(auxentrecot.getNombre()));
		entrecotpanel.add(entrecotnombre);
		entrecotpanel.add(entrecotprecio);
		entrecotpanel.add(entrecotcantidad);
		//FILETE
		JPanel filetepanel = new JPanel();
		filetepanel.setBackground(Color.PINK);
		filetepanel.setBounds(300, 561, 140, 140);
		principal.add(filetepanel);
		
		JButton fileteboton = new JButton("Comprar");
		fileteboton.setFont(new Font("Tahoma", Font.BOLD, 11));
		filetepanel.add(fileteboton);
		productos.Filete auxfilete = new productos.Filete();
		JLabel filetenombre = new JLabel("Nombre: " + auxfilete.getNombre() + "      ");
		JLabel fileteprecio = new JLabel("Precio: " + auxfilete.getPrecio()+ "   ");
		filetecantidad = new JLabel("Cantidad: " + GestorProductos.cantidadTipoProducto(auxfilete.getNombre()));
		filetepanel.add(filetenombre);
		filetepanel.add(fileteprecio);
		filetepanel.add(filetecantidad);
		//ESPAGUETI
		JPanel espaguetipanel = new JPanel();
		espaguetipanel.setBackground(Color.PINK);
		espaguetipanel.setBounds(575, 561, 140, 150);
		principal.add(espaguetipanel);
		
		JButton espaguetiboton = new JButton("Comprar");
		espaguetiboton.setFont(new Font("Tahoma", Font.BOLD, 11));
		espaguetipanel.add(espaguetiboton);
		productos.Espagueti auxespagueti = new productos.Espagueti();
		JLabel espaguetinombre = new JLabel("Nombre: " + auxespagueti.getNombre());
		JLabel espaguetiprecio = new JLabel("Precio: " + auxespagueti.getPrecio()+ "   ");
		espagueticantidad = new JLabel("Cantidad: " + GestorProductos.cantidadTipoProducto(auxespagueti.getNombre()));
		espaguetipanel.add(espaguetinombre);
		espaguetipanel.add(espaguetiprecio);
		espaguetipanel.add(espagueticantidad);
		//TORTELLINI
		JPanel tortellinipanel = new JPanel();
		tortellinipanel.setBackground(Color.PINK);
		tortellinipanel.setBounds(850, 561, 145, 145);
		principal.add(tortellinipanel);
		
		JButton tortelliniboton = new JButton("Comprar");
		tortelliniboton.setFont(new Font("Tahoma", Font.BOLD, 11));
		tortellinipanel.add(tortelliniboton);
		productos.Tortellini auxtortellini = new productos.Tortellini();
		JLabel tortellininombre = new JLabel("Nombre: " + auxtortellini.getNombre() + "  ");
		JLabel tortelliniprecio = new JLabel("Precio: " + auxtortellini.getPrecio() + "  ");
		tortellinicantidad = new JLabel("Cantidad: " + GestorProductos.cantidadTipoProducto(auxtortellini.getNombre()));
		tortellinipanel.add(tortellininombre);
		tortellinipanel.add(tortelliniprecio);
		tortellinipanel.add(tortellinicantidad);
		//PLATANO
		JPanel platanopanel = new JPanel();
		platanopanel.setBackground(Color.PINK);
		platanopanel.setBounds(1150, 561, 140, 140);
		principal.add(platanopanel);
		
        
		JButton platanoboton = new JButton("Comprar");
		platanoboton.setFont(new Font("Tahoma", Font.BOLD, 11));
		platanopanel.add(platanoboton);
		productos.Platano auxplatano = new productos.Platano();
		JLabel platanonombre = new JLabel("Nombre: " + auxplatano.getNombre() + "    ");
		JLabel platanoprecio = new JLabel("Precio: " + auxplatano.getPrecio() + "   ");
		platanocantidad = new JLabel("Cantidad: " + GestorProductos.cantidadTipoProducto(auxplatano.getNombre()));
		platanopanel.add(platanonombre);
		platanopanel.add(platanoprecio);
		platanopanel.add(platanocantidad);
		//ActionListener Cebolla
		cebollaboton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaComprar ventanacomprar= new VentanaComprar("Cebolla",obtenerVentana());
				ventanacomprar.setVisible(true);
			}
		});
		//ActionListener Zanahoria
		zanahoriaboton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaComprar ventanacomprar= new VentanaComprar("Zanahoria",obtenerVentana());
				ventanacomprar.setVisible(true);
			}
		});
		//Actionlistener blanco
		blancoboton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaComprar ventanacomprar= new VentanaComprar("Blanco",obtenerVentana());
				ventanacomprar.setVisible(true);
			}
		});
		//Actionlistener tinto
		tintoboton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaComprar ventanacomprar= new VentanaComprar("Tinto",obtenerVentana());
				ventanacomprar.setVisible(true);
			}
		});
		//Actionlistener kiwi
		kiwiboton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaComprar ventanacomprar= new VentanaComprar("Kiwi",obtenerVentana());
				ventanacomprar.setVisible(true);
			}
		});
		//ActionListener entrecot
		entrecotboton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaComprar ventanacomprar= new VentanaComprar("Entrecot",obtenerVentana());
				ventanacomprar.setVisible(true);
			}
		});
		//ActionListener filete
				fileteboton.addActionListener( new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						VentanaComprar ventanacomprar= new VentanaComprar("Filete",obtenerVentana());
						ventanacomprar.setVisible(true);
					}
				});
				//ActionListener espagueti
				espaguetiboton.addActionListener( new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						VentanaComprar ventanacomprar= new VentanaComprar("Espagueti",obtenerVentana());
						ventanacomprar.setVisible(true);
					}
				});
				//ActionListener tortellini
				tortelliniboton.addActionListener( new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						VentanaComprar ventanacomprar= new VentanaComprar("Tortellini",obtenerVentana());
						ventanacomprar.setVisible(true);
					}
				});
				//ActionListener platano
				platanoboton.addActionListener( new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						VentanaComprar ventanacomprar= new VentanaComprar("Platano", obtenerVentana());
						ventanacomprar.setVisible(true);
					}
				});
		
			
		
		setTitle("Elija su producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
	}
	private VentanaProductos obtenerVentana()
	{
		return this;
	}
	public void actualizarProductos()
	{
		productos.Cebolla auxcebolla = new productos.Cebolla();
		cebollacantidad.setText("Cantidad: " + GestorProductos.cantidadTipoProducto(auxcebolla.getNombre()));
		productos.Tortellini auxtortellini = new productos.Tortellini();
		tortellinicantidad.setText("Cantidad: " + GestorProductos.cantidadTipoProducto(auxtortellini.getNombre()));
		productos.Zanahoria auxzanahoria = new productos.Zanahoria();
		zanahoriacantidad.setText("Cantidad: " + GestorProductos.cantidadTipoProducto(auxzanahoria.getNombre()));
		productos.Espagueti auxespagueti = new productos.Espagueti();
		espagueticantidad.setText("Cantidad: " + GestorProductos.cantidadTipoProducto(auxespagueti.getNombre()));
		productos.Blanco auxblanco = new productos.Blanco();
		blancocantidad.setText("Cantidad: " + GestorProductos.cantidadTipoProducto(auxblanco.getNombre()));
		productos.Tinto auxtinto = new productos.Tinto();
	    tintocantidad.setText("Cantidad: " + GestorProductos.cantidadTipoProducto(auxtinto.getNombre()));
		productos.Entrecot auxentrecot = new productos.Entrecot();
		entrecotcantidad.setText("Cantidad: " + GestorProductos.cantidadTipoProducto(auxentrecot.getNombre()));
		productos.Filete auxfilete = new productos.Filete();
		filetecantidad.setText("Cantidad: " + GestorProductos.cantidadTipoProducto(auxfilete.getNombre()));
		productos.Kiwi auxkiwi = new productos.Kiwi();
		kiwicantidad.setText("Cantidad: " + GestorProductos.cantidadTipoProducto(auxkiwi.getNombre()));
		productos.Platano auxplatano = new productos.Platano();
		platanocantidad.setText("Cantidad: " + GestorProductos.cantidadTipoProducto(auxplatano.getNombre()));
	}
}
