package Image;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Zanahoria extends JPanel{
	
	public Zanahoria() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
		}
		 
		//Se crea un método cuyo parámetro debe ser un objeto Graphics
		 
		public void paint(Graphics grafico) {
		Dimension height = getSize();
		 
		//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
		 
		ImageIcon Img = new ImageIcon(getClass().getResource("/Image/zanahoria.jpg")); 
		 
		//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
		 
		grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
		 
		setOpaque(false);
		super.paintComponent(grafico);
		}

}
