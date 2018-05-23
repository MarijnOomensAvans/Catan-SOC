package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TradeContentPane extends JPanel {
	
	private BufferedImage myBufferedImage1;
	private BufferedImage myBufferedImage2;
	private BufferedImage myBufferedImage3;
	private BufferedImage myBufferedImage4;
	private BufferedImage myBufferedImage5;
	
	private File stone;
	private File ore;
	private File wood;
	private File wheat;
	private File wool;
	
	public TradeContentPane() {
		setLayout(new FlowLayout());
		stone = new File("./Images/baksteen.jpg");
		ore = new File("./Images/erts.jpg");
		wood = new File("./Images/hout.jpg");
		wheat = new File("./Images/graan.jpg");
		wool = new File("./Images/schaap.jpg");
			
		try {
				myBufferedImage1 = ImageIO.read(stone);
				myBufferedImage2 = ImageIO.read(ore);
				myBufferedImage3 = ImageIO.read(wood);
				myBufferedImage4 = ImageIO.read(wheat);
				myBufferedImage5 = ImageIO.read(wool);
			}catch (IOException e) {
			System.out.println(e.getMessage());
			}	
		this.repaint();
		
		setPreferredSize(new Dimension(600,600));
		setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(myBufferedImage1, 100, 200, 100, 100, null);
		g.drawImage(myBufferedImage2, 200, 200, 100, 100, null);
		g.drawImage(myBufferedImage3, 300, 200, 100, 100, null);
		g.drawImage(myBufferedImage4, 400, 200, 100, 100, null);
		g.drawImage(myBufferedImage5, 500, 200, 100, 100, null);
	}

}
