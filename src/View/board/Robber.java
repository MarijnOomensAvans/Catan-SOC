package View.board;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;




@SuppressWarnings("serial")
public class Robber extends JPanel {
	
	private ImageIcon image1;
	private JLabel image;
	
	public Robber() {
		this.setPreferredSize(new Dimension(25,60));
		image1 = new ImageIcon(ClassLoader.getSystemResource("Therobber.png"));
		image = new JLabel(image1);
		this.setOpaque(false);
		add(image);
		repaint();
		validate();
	}

	
	

}
