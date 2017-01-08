package vistas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import Gestor.GestorProductos;

public class VentanaInformeProducto extends JFrame{
	private JTable table;
	private int posicionNombre = 0;
	private int posicionApellido = 1;
	private int posicionEmail = 2;
	private int posicionFecha=4;
	private int posicionProducto=5;
	private int posicionPrecio=6;
	private JComboBox comboBox;
	private ArrayList<String[]> registro;
	private ArrayList<String> productos;
	public VentanaInformeProducto()
	{
		
		registro= GestorProductos.leerRegistro();
		productos= new ArrayList<String>();
		String producto;
		String[] linea;
		for (int i=0;i<registro.size();i++)
		{
			linea=registro.get(i);
			producto=linea[posicionProducto];
			boolean encontrado=false;
			for (int j=0;j<productos.size();j++)
			{
				if (productos.get(j).compareTo(producto)==0)
				{
					encontrado=true;
					break;
				}
			}
			if (encontrado==false)
			{
				productos.add(producto);
			}
		}
		String[] nombres= new String[productos.size()];
		for (int m=0;m<productos.size();m++)
		{
			nombres[m]=productos.get(m);
		}
		getContentPane().setLayout(null);
		table = new JTable();
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 87, 1330, 632);
		getContentPane().add(scroll);
		
		comboBox = new JComboBox(nombres);
		comboBox.setSelectedIndex(-1);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == arg0.SELECTED) {
					String producto= productos.get(comboBox.getSelectedIndex());
					actualizarTabla(producto);
				}
			}
		});
		comboBox.setBounds(623, 26, 131, 38);
		getContentPane().add(comboBox);
		setTitle("Informe por producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
	}
	public void actualizarTabla(String producto)
	{
		String[] linea;
		Vector<Vector<String>> datostabla= new Vector<Vector<String>>();
		Vector<String> lineatabla;
		
		for (int j=0;j<registro.size();j++)
		{
			linea = registro.get(j);
			if (producto.compareTo(linea[posicionProducto])==0)
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
