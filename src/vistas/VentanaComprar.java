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

import Image.Cebolla;
import Image.Entrecot;
import Image.Espaguetis;
import Image.Filete;
import Image.Kiwi;
import Image.Platano;
import Image.Supermercado;
import Image.Tortellini;
import Image.Vino;
import Image.Vinotinto;
import Image.Zanahoria;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public class VentanaComprar extends JFrame{
	
	public VentanaComprar()
	{
		JPanel principal = new JPanel();
		JPanel botonera = new JPanel();
		//JButton anterior = new JButton( "Anterior" );
		//JButton comprar = new JButton( "Comprar" );
		//JButton siguiente = new JButton( "Siguiente" );
		
		Zanahoria zanahoria = new Zanahoria();
		principal.add(zanahoria);
		principal.repaint();
		zanahoria.setSize(200, 200);
		zanahoria.setLocation(300, 0);
		Cebolla cebolla = new Cebolla();
		principal.add(cebolla);
		principal.repaint();
		cebolla.setSize(200, 200);
		Vino vino = new Vino();
		principal.add(vino);
		principal.repaint();
		vino.setSize(225, 200);
		vino.setLocation(575, 0);
		Vinotinto vinotinto = new Vinotinto();
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
		
		
		principal.setLayout( null );
		principal.setBackground( Color.pink );
		getContentPane().add( principal, BorderLayout.CENTER );
		
		JPanel cebollapanel = new JPanel();
		cebollapanel.setBackground(Color.PINK);
		cebollapanel.setForeground(Color.WHITE);
		cebollapanel.setBounds(0, 211, 200, 128);
		principal.add(cebollapanel);
		
		JButton cebollaboton = new JButton("Comprar");
		cebollaboton.setFont(new Font("Tahoma", Font.BOLD, 11));
		cebollapanel.add(cebollaboton);
		
		JPanel zanahoriapanel = new JPanel();
		zanahoriapanel.setBackground(Color.PINK);
		zanahoriapanel.setForeground(Color.WHITE);
		zanahoriapanel.setBounds(300, 211, 200, 128);
		principal.add(zanahoriapanel);
		
		JButton zanahoriaboton = new JButton("Comprar");
		zanahoriaboton.setFont(new Font("Tahoma", Font.BOLD, 11));
		zanahoriapanel.add(zanahoriaboton);
		
		JPanel vinopanel = new JPanel();
		vinopanel.setForeground(Color.WHITE);
		vinopanel.setBackground(Color.PINK);
		vinopanel.setBounds(575, 211, 219, 128);
		principal.add(vinopanel);
		
		JButton vinoboton = new JButton("Comprar");
		vinoboton.setFont(new Font("Tahoma", Font.BOLD, 11));
		vinopanel.add(vinoboton);
		
		JPanel vinotintopanel = new JPanel();
		vinotintopanel.setBackground(Color.PINK);
		vinotintopanel.setBounds(850, 211, 200, 128);
		principal.add(vinotintopanel);
		
		JButton vinotintoboton = new JButton("Comprar");
		vinotintoboton.setFont(new Font("Tahoma", Font.BOLD, 11));
		vinotintopanel.add(vinotintoboton);
		
		JPanel kiwipanel = new JPanel();
		kiwipanel.setBackground(Color.PINK);
		kiwipanel.setBounds(1150, 211, 200, 128);
		principal.add(kiwipanel);
		
		JButton kiwiboton = new JButton("Comprar");
		kiwiboton.setFont(new Font("Tahoma", Font.BOLD, 11));
		kiwipanel.add(kiwiboton);
		
		JPanel entrecotpanel = new JPanel();
		entrecotpanel.setBackground(Color.PINK);
		entrecotpanel.setBounds(0, 561, 200, 125);
		principal.add(entrecotpanel);
		
		JButton entrecotboton = new JButton("Comprar");
		entrecotboton.setFont(new Font("Tahoma", Font.BOLD, 11));
		entrecotpanel.add(entrecotboton);
		
		JPanel filetepanel = new JPanel();
		filetepanel.setBackground(Color.PINK);
		filetepanel.setBounds(300, 561, 200, 125);
		principal.add(filetepanel);
		
		JButton fileteboton = new JButton("Comprar");
		fileteboton.setFont(new Font("Tahoma", Font.BOLD, 11));
		filetepanel.add(fileteboton);
		
		JPanel espaguetispanel = new JPanel();
		espaguetispanel.setBackground(Color.PINK);
		espaguetispanel.setBounds(575, 561, 200, 125);
		principal.add(espaguetispanel);
		
		JButton espaguetisboton = new JButton("Comprar");
		espaguetisboton.setFont(new Font("Tahoma", Font.BOLD, 11));
		espaguetispanel.add(espaguetisboton);
		
		JPanel tortellinipanel = new JPanel();
		tortellinipanel.setBackground(Color.PINK);
		tortellinipanel.setBounds(850, 561, 200, 125);
		principal.add(tortellinipanel);
		
		JButton tortelliniboton = new JButton("Comprar");
		tortelliniboton.setFont(new Font("Tahoma", Font.BOLD, 11));
		tortellinipanel.add(tortelliniboton);
		
		JPanel platanopanel = new JPanel();
		platanopanel.setBackground(Color.PINK);
		platanopanel.setBounds(1150, 561, 200, 125);
		principal.add(platanopanel);
		
        
		JButton platanoboton = new JButton("Comprar");
		platanoboton.setFont(new Font("Tahoma", Font.BOLD, 11));
		platanopanel.add(platanoboton);
		
		productos.Platano p = new productos.Platano();
		p.setPrecio(10);
		p.setCantidad(2);
		
		productos.Tinto v = new productos.Tinto();
		v.setPrecio(2);
		v.setCantidad(34);
		v.setAno(2000);
		v.setLitros(100);
		
		
		
		platanoboton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaDatos ventanabuscar= new VentanaDatos(v);
				ventanabuscar.setVisible(true);
			}
		});
		getContentPane().add( botonera, BorderLayout.SOUTH );
		setTitle("Elija su producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
	}
}
