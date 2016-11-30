package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import productos.Producto;

import java.awt.Font;
import java.util.ArrayList;

public class VentanaDatos extends JFrame{

	public VentanaDatos(Producto p)
	{
		JPanel principal = new JPanel();
		principal.setLayout( null );
		principal.setBackground( Color.pink );
		getContentPane().add( principal, BorderLayout.CENTER );
		
		ArrayList<String> propiedades = p.getPropiedades();
		int altura= 50;
		for (int i=0; i<propiedades.size(); i++)
		{
			JLabel precio = new JLabel(propiedades.get(i));
			precio.setFont(new Font("Tahoma", Font.BOLD, 17));
			precio.setForeground(Color.WHITE);
			precio.setBackground(Color.WHITE);
			precio.setSize(190, 25);
			precio.setLocation(59, 30*i + altura);
			principal.add( precio );
		}
		
		setTitle("Informacion del producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.setSize(300,300);
	}
}
