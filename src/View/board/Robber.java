package View.board;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Robber extends JPanel {
	
	private File robber;
	private BufferedImage myBufferedImage1;
	
	public Robber() {
		
		this.setLayout(null);
		this.setPreferredSize(new Dimension(400, 300));
		
		robber = new File("./Images/Therobber.png");
		
		try {
			myBufferedImage1 = ImageIO.read(robber);
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(myBufferedImage1, 50, 100, 25, 60, null);
	}
}
