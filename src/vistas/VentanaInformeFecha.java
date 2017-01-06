package vistas;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Gestor.GestorProductos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class VentanaInformeFecha extends JFrame{

	private JTable table;
	private JScrollPane scroll;
	private JTextField textField;
	private JTextField textField_1;
	private ArrayList<String[]> registro;
	int posicionNombre = 0;
	int posicionApellido = 1;
	int posicionEmail = 2;
	int posicionTelefono =3;
	int posicionFecha=4;
	int posicionProducto=5;
	int posicionPrecio=6;
	public VentanaInformeFecha()
	{
		registro= GestorProductos.leerRegistro();
		getContentPane().setLayout(null);
		table = new JTable();
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 87, 1330, 632);
		getContentPane().add(scroll);
		
		JLabel lblNewLabel = new JLabel("Desde");
		lblNewLabel.setBounds(127, 37, 56, 14);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(205, 34, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Hasta");
		lblNewLabel_1.setBounds(375, 37, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(488, 34, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String desde= textField.getText();
				String hasta= textField_1.getText();
				SimpleDateFormat formatter = new SimpleDateFormat(GestorProductos.formatoFechas);
				
				try {
					Date inicio = formatter.parse(desde);
					Date fin = formatter.parse(hasta);
					actualizarTabla(inicio,fin);
				} catch (ParseException e) {
				}
			}
		});
		btnBuscar.setBounds(661, 33, 89, 23);
		getContentPane().add(btnBuscar);
		setTitle("Informe por fecha");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
	}
	public void actualizarTabla(Date inicio, Date fin)
	{
		String[] linea;
		Vector<Vector<String>> datostabla= new Vector<Vector<String>>();
		Vector<String> lineatabla;
		
		for (int j=0;j<registro.size();j++)
		{
			linea = registro.get(j);
			String fechaString= linea[posicionFecha];
			SimpleDateFormat formatter = new SimpleDateFormat(GestorProductos.formatoFechas);
			Date fecha;
			try {
				fecha = formatter.parse(fechaString);
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "La fecha encontrada en el registro no se ha podido convertir en objeto de tipo fecha");
				continue;
			}
			
			if (fecha.compareTo(inicio)>=0 && fecha.compareTo(fin)<=0)
			{
				lineatabla= new Vector<String>();
				lineatabla.add(linea[posicionNombre]);
				lineatabla.add(linea[posicionApellido]);
				lineatabla.add(linea[posicionEmail]);
				lineatabla.add(linea[posicionTelefono]);
				lineatabla.add(linea[posicionFecha]);
				lineatabla.add(linea[posicionProducto]);
				lineatabla.add(linea[posicionPrecio]);
				datostabla.add(lineatabla);
			}
		}
		Vector<String> columnas= new Vector<String>();
		columnas.add("Nombre");
		columnas.add("Apellido");
		columnas.add("Email");
		columnas.add("Telefono");
		columnas.add("Fecha");
		columnas.add("Producto");
		columnas.add("Precio");
		DefaultTableModel model = new DefaultTableModel(datostabla, columnas);
		table.setModel(model);
	}
}
