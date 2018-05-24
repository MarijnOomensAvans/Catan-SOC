package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
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
	
	private JButton plusstone;
	private JButton plusore;
	private JButton pluswood;
	private JButton pluswheat;
	private JButton pluswool;
	
	private JButton minusstone;
	private JButton minusore;
	private JButton minuswood;
	private JButton minuswheat;
	private JButton minuswool;
	
	public TradeContentPane() {
		this.setLayout(new GridLayout());
		stone = new File("./Images/baksteen.jpg");
		wool = new File("./Images/schaap.jpg");
		ore = new File("./Images/erts.jpg");
		wheat = new File("./Images/graan.jpg");
		wood = new File("./Images/hout.jpg");
		
		plusstone = new JButton("+");
		plusore = new JButton("+");
		pluswood = new JButton("+");
		pluswheat = new JButton("+");
		pluswool = new JButton("+");
		
		minusstone = new JButton("-");
		minusore = new JButton("-");
		minuswood = new JButton("-");
		minuswheat = new JButton("-");
		minuswool = new JButton("-");
		
		try {
				myBufferedImage1 = ImageIO.read(stone);
				myBufferedImage2 = ImageIO.read(wool);
				myBufferedImage3 = ImageIO.read(ore);
				myBufferedImage4 = ImageIO.read(wheat);
				myBufferedImage5 = ImageIO.read(wood);
			}catch (IOException e) {
			System.out.println(e.getMessage());
			}
		this.repaint();
		
		add(plusstone);
		plusstone.setBounds(50,210, 45, 30);
		
		
		setPreferredSize(new Dimension(600,600));
		setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(myBufferedImage1, 50, 100, 100, 100, null);
		g.drawImage(myBufferedImage2, 155, 100, 100, 100, null);
		g.drawImage(myBufferedImage3, 260, 100, 100, 100, null);
		g.drawImage(myBufferedImage4, 365, 100, 100, 100, null);
		g.drawImage(myBufferedImage5, 470, 100, 100, 100, null);
	}

}
