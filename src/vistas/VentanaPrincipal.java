package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BaseDatos.db;
import Image.Supermercado;

public class VentanaPrincipal extends JFrame{

	public VentanaPrincipal()
	{
		JPanel principal = new JPanel();
		JPanel botonera = new JPanel();
		JButton buscar = new JButton( "Buscar" );
		JButton comprar = new JButton( "Comprar" );
		JButton reponer = new JButton( "Reponer" );
		JButton informes = new JButton( "Informes" );
		
		Supermercado ima = new Supermercado();
		principal.add(ima);
		principal.repaint();
		
		principal.setLayout( null );
		principal.setBackground( Color.pink );
		add( principal, BorderLayout.CENTER );
		botonera.add( buscar );
		botonera.add( comprar );
		botonera.add( reponer );
		botonera.add( informes );
		add( botonera, BorderLayout.SOUTH );
		setTitle("Bienvenido al supermercado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
		
		buscar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaBuscar ventanabuscar= new VentanaBuscar();
				ventanabuscar.setVisible(true);
			}
		});
		
		comprar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaProductos ventanacomprar= new VentanaProductos();
				ventanacomprar.setVisible(true);
			}
		});
		reponer.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaReponer ventanareponer= new VentanaReponer();
				ventanareponer.setVisible(true);
			}
		});
		
		informes.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInformes ventanainformes= new VentanaInformes();
				ventanainformes.setVisible(true);
			}
		});
		
	}

	private void iniciarComponentes() {
		// TODO Auto-generated method stub
		
	}

	
}
