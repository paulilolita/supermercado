package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import productos.Blanco;
import productos.Cebolla;
import productos.Entrecot;
import productos.Espagueti;
import productos.Filete;
import productos.Kiwi;
import productos.Pasta;
import productos.Platano;
import productos.Producto;
import productos.Tinto;
import productos.Tortellini;
import productos.Vino;
import productos.Zanahoria;
import Gestor.GestorProductos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaReponer extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public VentanaReponer()
	{

	JPanel principal = new JPanel();
	principal.setLayout( null );
	principal.setBackground( Color.pink );
	getContentPane().add( principal, BorderLayout.CENTER );
	
	textField = new JTextField();
	textField.setBounds(10, 57, 86, 20);
	principal.add(textField);
	textField.setColumns(10);
	
	textField_1 = new JTextField();
	textField_1.setBounds(163, 57, 86, 20);
	principal.add(textField_1);
	textField_1.setColumns(10);
	
	textField_2 = new JTextField();
	textField_2.setBounds(317, 57, 86, 20);
	principal.add(textField_2);
	textField_2.setColumns(10);
	
	textField_3 = new JTextField();
	textField_3.setBounds(10, 158, 86, 20);
	principal.add(textField_3);
	textField_3.setColumns(10);
	
	textField_4 = new JTextField();
	textField_4.setBounds(163, 158, 86, 20);
	principal.add(textField_4);
	textField_4.setColumns(10);
	
	JButton btnNewButton = new JButton("Reponer");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String nombre= textField.getText();
		    int cantidad= Integer.parseInt(textField_1.getText());
			Producto nuevo ;
			for (int i=0;i<cantidad;i++)
			{
			switch(nombre)
			{
			case "Platano":
				nuevo= new Platano();
				GestorProductos.anadirPlatano((Platano) nuevo);
				break;
			case "Kiwi":
				nuevo= new Kiwi();
				GestorProductos.anadirKiwi((Kiwi) nuevo);
				break;
			case "Espagueti":
				nuevo= new Espagueti();
				((Pasta) nuevo).setOrigen(textField_4.getText());
				GestorProductos.anadirEspagueti((Espagueti) nuevo);
				break;
			case "Tortellini":
				nuevo= new Tortellini();
				((Pasta) nuevo).setOrigen(textField_4.getText());
				GestorProductos.anadirTortellini((Tortellini) nuevo);
				break;
			case "Blanco":
				nuevo= new Blanco();
				((Vino) nuevo).setAno(Integer.parseInt(textField_2.getText()));
				((Vino) nuevo).setLitros(Float.parseFloat(textField_3.getText()));
				GestorProductos.anadirBlanco((Blanco) nuevo);
				break;
			case "Tinto":
				nuevo=new Tinto();
				((Vino) nuevo).setAno(Integer.parseInt(textField_2.getText()));
				((Vino) nuevo).setLitros(Float.parseFloat(textField_3.getText()));
				GestorProductos.anadirTinto((Tinto) nuevo);
				break;
			case "Cebolla":
				nuevo= new Cebolla();
				GestorProductos.anadirCebolla((Cebolla) nuevo);
				break;
			case "Zanahoria":
				nuevo=  new Zanahoria();
				GestorProductos.anadirZanahoria((Zanahoria) nuevo);
				break;
			case "Filete":
				nuevo= new Filete();
				GestorProductos.anadirFilete((Filete) nuevo);
				break;
			case "Entrecot":
				nuevo=  new Entrecot();
				GestorProductos.anadirEntrecot((Entrecot) nuevo);
				break;
			}
			
			}
		}
	});
	btnNewButton.setBounds(314, 157, 89, 23);
	principal.add(btnNewButton);
	
	JLabel lblNombre = new JLabel("Nombre");
	lblNombre.setBounds(23, 32, 46, 14);
	principal.add(lblNombre);
	
	JLabel lblCantidad = new JLabel("Cantidad");
	lblCantidad.setBounds(180, 32, 46, 14);
	principal.add(lblCantidad);
	
	JLabel lblAo = new JLabel("A\u00F1o");
	lblAo.setBounds(340, 32, 46, 14);
	principal.add(lblAo);
	
	JLabel lblLitros = new JLabel("Litros");
	lblLitros.setBounds(23, 129, 46, 14);
	principal.add(lblLitros);
	
	JLabel lblOrigen = new JLabel("Origen");
	lblOrigen.setBounds(180, 129, 46, 14);
	principal.add(lblOrigen);
	
	setTitle("Reponga el producto");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	this.setSize(screenSize);
	
	}
}
