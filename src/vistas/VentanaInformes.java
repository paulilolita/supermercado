package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Image.Informe;
import Image.Supermercado;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInformes extends JFrame {
	public VentanaInformes()
	{
		JPanel principal = new JPanel();
		JPanel botonera = new JPanel();
		JButton informecliente = new JButton( "Informe por cliente" );
		informecliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaInformeCliente ventanacliente= new VentanaInformeCliente();
				ventanacliente.setVisible(true);
			}
		});
		JButton informefecha = new JButton( "Informe por fecha" );
		informefecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInformeFecha ventanafecha= new VentanaInformeFecha();
				ventanafecha.setVisible(true);
			}
		});
		JButton informeproducto = new JButton( "Informe por producto" );
		informeproducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Informe ima = new Informe();
		principal.add(ima);
		principal.repaint();
		principal.setLayout( null );
		principal.setBackground( Color.pink );
		getContentPane().add( principal, BorderLayout.CENTER );
		botonera.add( informecliente );
		botonera.add( informefecha );
		botonera.add( informeproducto);
		getContentPane().add( botonera, BorderLayout.SOUTH );
		setTitle("Elija el tipo de informe que desea visualizar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
	}

	

	

}
