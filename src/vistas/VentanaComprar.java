package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import productos.Producto;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;

import Gestor.GestorProductos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaComprar extends JFrame{
	private JTable table;
	private VentanaProductos ventanaPrincipal;

	public VentanaComprar(String nombre, VentanaProductos ventana)
	{
		ventanaPrincipal=ventana;
		JPanel principal = new JPanel();
		JPanel botonera = new JPanel();
		JButton comprar = new JButton( "Comprar" );
		botonera.add( comprar );
		principal.setLayout( null );
		principal.setBackground( Color.pink );
		getContentPane().add( principal, BorderLayout.CENTER );
		ArrayList<Producto> lista= GestorProductos.obtenerproductos(nombre);
		ArrayList<String> objetos = lista.get(0).getPropiedades();
		String[] columnas = new String[objetos.size()];
		for( int i=0; i<objetos.size(); i++)
		{
			columnas[i]= objetos.get(i);
		}
		String[][] datos = new String[lista.size()][];
		for( int i=0; i<lista.size(); i++)
		{
			ArrayList<String> objetosValores = lista.get(i).getValores();
			datos[i] = new String[objetosValores.size()];
			for (int j=0;j<objetosValores.size();j++)
			{
				datos[i][j]= objetosValores.get(j);
			}
		}
		table = new JTable(datos,columnas);
		table.setBounds(64, 112, 372, 189);
		getContentPane().add(new JScrollPane(table));
		comprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] filas= table.getSelectedRows();
				for (int i=0;i<table.getSelectedRowCount();i++)
				{
					int id= Integer.parseInt((String) table.getModel().getValueAt(filas[i], 0));
					GestorProductos.eliminarProducto(id);
				}
				ventanaPrincipal.actualizarProductos();
				CloseFrame();
			}
		});
		getContentPane().add( botonera, BorderLayout.SOUTH );
		
		
		setTitle("Informacion del producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
		
	}
	
	public void CloseFrame(){
	    super.dispose();
	}
}
