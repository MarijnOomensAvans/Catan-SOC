package View.developmentCards;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Controller.PlayerController;
import View.setupGame.DrawingPanel;

public class UitvindingContentPane extends JPanel {
	private BufferedImage myBufferedImage1;
	private BufferedImage myBufferedImage2;
	private BufferedImage myBufferedImage3;
	private BufferedImage myBufferedImage4;
	private BufferedImage myBufferedImage5;

	private String stone;
	private String ore;
	private String wood;
	private String wheat;
	private String wool;
	
	
	

	public UitvindingContentPane(PlayerController playerController, DrawingPanel dp,
			UitvindingFrame uitvindingFrame) {
		stone = "baksteen.jpg";
		wool = "schaap.jpg";
		ore = "erts.jpg";
		wheat = "graan.jpg";
		wood = "hout.jpg";
		
		try {
			myBufferedImage1 = ImageIO.read(ClassLoader.getSystemResourceAsStream(stone));
			myBufferedImage2 = ImageIO.read(ClassLoader.getSystemResourceAsStream(wool));
			myBufferedImage3 = ImageIO.read(ClassLoader.getSystemResourceAsStream(ore));
			myBufferedImage4 = ImageIO.read(ClassLoader.getSystemResourceAsStream(wheat));
			myBufferedImage5 = ImageIO.read(ClassLoader.getSystemResourceAsStream(wood));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		this.repaint();
		
		
		
		setPreferredSize(new Dimension(1100,600));
		setVisible(true);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(myBufferedImage1, 50, 100, 100, 100, null);
		g.drawImage(myBufferedImage2, 195, 100, 100, 100, null);
		g.drawImage(myBufferedImage3, 340, 100, 100, 100, null);
		g.drawImage(myBufferedImage4, 485, 100, 100, 100, null);
		g.drawImage(myBufferedImage5, 630, 100, 100, 100, null);
	}

}
