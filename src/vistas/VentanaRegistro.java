package vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import Usuarios.Administrador;
import Usuarios.Usuario;
import BaseDatos.db;
import Gestor.GestorProductos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VentanaRegistro extends JFrame{
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public VentanaRegistro()
	{
		JPanel principal = new JPanel();
		getContentPane().add(principal);
		principal.setLayout(null);
		principal.setBackground( Color.pink );
		
		JLabel lblNewLabel = new JLabel("Acceso como usuario");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
		lblNewLabel.setBounds(502, 68, 148, 39);
		principal.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Acceso como administrador");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(778, 84, 202, 23);
		principal.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(406, 130, 83, 20);
		principal.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(406, 179, 64, 20);
		principal.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(406, 232, 46, 14);
		principal.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Usuario");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(735, 130, 57, 29);
		principal.add(lblNewLabel_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(822, 176, 158, 29);
		principal.add(passwordField);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(735, 188, 77, 14);
		principal.add(lblContrasea);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefono.setBounds(406, 283, 64, 14);
		principal.add(lblTelefono);
		
		textField = new JTextField();
		textField.setBounds(499, 127, 162, 32);
		principal.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(499, 176, 162, 32);
		principal.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(499, 233, 162, 32);
		principal.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(499, 283, 162, 32);
		principal.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(818, 127, 162, 32);
		principal.add(textField_4);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre= textField.getText();
				String apellido= textField_1.getText();
				String email= textField_2.getText();
				String telefono= textField_3.getText();
				Usuario usuario= new Usuario();
				usuario.setNombre(nombre);
				usuario.setApellido(apellido);
				usuario.setEmail(email);
				usuario.setTelefono(telefono);
				GestorProductos.usuario=usuario;
				VentanaPrincipal miVentana= new VentanaPrincipal();
				miVentana.setVisible(true);
				CloseFrame();
			}
		});
		btnNewButton.setBounds(528, 368, 89, 23);
		principal.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Entrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = textField_4.getText();
				Administrador admin= db.cargarUsuario(nombre);
				String contrasena= passwordField.getText();
				if ( admin == null || admin.getContrasena().compareTo(contrasena) != 0)
				{
					JOptionPane.showMessageDialog(null, "Usuario o contraseña invalido");
				}
				else
				{
					GestorProductos.usuario=admin;
					VentanaPrincipal miVentana= new VentanaPrincipal();
					miVentana.setVisible(true);
					CloseFrame();
				}
			}
		});
		btnNewButton_1.setBounds(853, 238, 89, 23);
		principal.add(btnNewButton_1);
		
		setTitle("Registrese");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
	}
	public void CloseFrame(){
	    super.dispose();
	}
}
