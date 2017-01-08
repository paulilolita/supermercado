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

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Gestor.GestorProductos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Vector;

import javax.swing.SpringLayout;

public class VentanaInformeFecha extends JFrame{

	private JTable table;
	private JScrollPane scroll;
	private ArrayList<String[]> registro;
	private int posicionNombre = 0;
	private int posicionApellido = 1;
	private int posicionEmail = 2;
	private int posicionTelefono=3;
	private int posicionFecha=4;
	private int posicionProducto=5;
	private int posicionPrecio=6;
	private JDatePickerImpl datePicker;
	private JDatePickerImpl datePicker_1;
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
		
		 UtilDateModel model = new UtilDateModel();
	        Properties prop = new Properties();
	        prop.put("text.today", "Hoy");
	        prop.put("text.month", "Mes");
	        prop.put("text.year", "Año");
	        JDatePanelImpl datePanel = new JDatePanelImpl(model, prop);
	        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	        SpringLayout springLayout = (SpringLayout) datePicker.getLayout();
	        springLayout.putConstraint(SpringLayout.SOUTH, datePicker.getJFormattedTextField(), 0, SpringLayout.SOUTH, datePicker);
	        datePicker.setBounds(205,34,119,23);
	        getContentPane().add(datePicker);
		
		JLabel lblNewLabel_1 = new JLabel("Hasta");
		lblNewLabel_1.setBounds(375, 37, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		 UtilDateModel model_1 = new UtilDateModel();
	        JDatePanelImpl datePanel_1 = new JDatePanelImpl(model_1, prop);
	        datePicker_1 = new JDatePickerImpl(datePanel_1, new DateLabelFormatter());
	        datePicker_1.setBounds(488,34,119,20);
	        getContentPane().add(datePicker_1);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date fechainicio = (Date) datePicker.getModel().getValue();
				Date fechafin = (Date) datePicker_1.getModel().getValue();
				actualizarTabla(fechainicio,fechafin);
				
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
		
		inicio.setSeconds(0);
		inicio.setMinutes(0);
		inicio.setHours(0);
		fin.setSeconds(59);
		fin.setMinutes(59);
		fin.setHours(23);
		
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
			
			fecha.setSeconds(0);
			fecha.setMinutes(0);
			fecha.setHours(12);
			
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
