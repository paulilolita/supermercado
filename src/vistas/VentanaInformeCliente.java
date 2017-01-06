package vistas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Gestor.GestorProductos;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VentanaInformeCliente extends JFrame{
	private JTable table;
	
	int posicionNombre = 0;
	int posicionApellido = 1;
	int posicionEmail = 2;
	int posicionFecha=4;
	int posicionProducto=5;
	int posicionPrecio=6;
	
	public VentanaInformeCliente()
	{
		getContentPane().setLayout(null);
		ArrayList<String[]> registro= GestorProductos.leerRegistro();
		ArrayList<String> emails= new ArrayList<String>();
		String email;
		String[] linea;
		for (int i=0;i<registro.size();i++)
		{
			linea=registro.get(i);
			email=linea[posicionEmail];
			boolean encontrado=false;
			for (int j=0;j<emails.size();j++)
			{
				if (emails.get(j).compareTo(email)==0)
				{
					encontrado=true;
					break;
				}
			}
			if (encontrado==false)
			{
				emails.add(email);
			}
		}
		String[] nombres= new String[emails.size()];
		for (int i=0;i<emails.size();i++)
		{
			email=emails.get(i);
			for (int j=0;j<registro.size();j++)
			{
				linea = registro.get(j);
				if (email.compareTo(linea[posicionEmail])==0)
				{
					nombres[i]= linea[posicionNombre] + " " + linea[posicionApellido];
				}
			}
		}
		
		JComboBox comboBox = new JComboBox(nombres);
		comboBox.setSelectedIndex(-1);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == arg0.SELECTED) {
					String email= emails.get(comboBox.getSelectedIndex());
					actualizarTabla(email, registro);
				}
			}
		});
		comboBox.setBounds(539, 30, 191, 40);
		getContentPane().add(comboBox);
		
		table = new JTable();
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 87, 1330, 632);
		getContentPane().add(scroll);
		setTitle("Informe por cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
		
	}
	public void actualizarTabla(String email, ArrayList<String[]> registro)
	{
		String[] linea;
		Vector<Vector<String>> datostabla= new Vector<Vector<String>>();
		Vector<String> lineatabla;
		
		for (int j=0;j<registro.size();j++)
		{
			linea = registro.get(j);
			if (email.compareTo(linea[posicionEmail])==0)
			{
				lineatabla= new Vector<String>();
				lineatabla.add(linea[posicionNombre]);
				lineatabla.add(linea[posicionApellido]);
				lineatabla.add(linea[posicionFecha]);
				lineatabla.add(linea[posicionProducto]);
				lineatabla.add(linea[posicionPrecio]);
				datostabla.add(lineatabla);
			}
		}
		Vector<String> columnas= new Vector<String>();
		columnas.add("Nombre");
		columnas.add("Apellido");
		columnas.add("Fecha");
		columnas.add("Producto");
		columnas.add("Precio");
		DefaultTableModel model = new DefaultTableModel(datostabla, columnas);
		table.setModel(model);
	}
}
