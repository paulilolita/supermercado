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
import Gestor.GestorProductos;
import Image.Supermercado;
import Usuarios.UsuarioAbstracto;

public class VentanaPrincipal extends JFrame{

	public VentanaPrincipal()
	{
		JPanel principal = new JPanel();
		JPanel botonera = new JPanel();
		JButton comprar = new JButton( "Comprar" );
		JButton reponer = new JButton( "Reponer" );
		JButton informes = new JButton( "Informes" );
		UsuarioAbstracto user= GestorProductos.usuario;
		if (user.isAdmin()==true)
		{
			comprar.setEnabled(false);
			reponer.setEnabled(true);
			informes.setEnabled(true);
		}
		else
		{
			comprar.setEnabled(true);
			reponer.setEnabled(false);
			informes.setEnabled(false);
		}
		
		Supermercado ima = new Supermercado();
		principal.add(ima);
		principal.repaint();
		
		principal.setLayout( null );
		principal.setBackground( Color.pink );
		add( principal, BorderLayout.CENTER );
		botonera.add( comprar );
		botonera.add( reponer );
		botonera.add( informes );
		add( botonera, BorderLayout.SOUTH );
		setTitle("Bienvenido al supermercado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
		
		
		
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
