package View;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextField;

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
	
	private JTextField stoneoffer;
	private JTextField oreoffer;
	private JTextField woodoffer;
	private JTextField wheatoffer;
	private JTextField wooloffer;
	
	public TradeContentPane() {
		this.setLayout(null);
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
		
		stoneoffer = new JTextField("0");
		oreoffer = new JTextField("0");
		woodoffer = new JTextField("0");
		wheatoffer = new JTextField("0");
		wooloffer = new JTextField("10");
		
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
		
		add(minusstone);
		minusstone.setBounds(40,210, 45, 30);
		
		add(stoneoffer);
		stoneoffer.setBounds(86,210, 25, 30);
		
		add(plusstone);
		plusstone.setBounds(111,210, 45, 30);
		
		add(minuswool);
		minuswool.setBounds(186,210, 45, 30);
		
		add(wooloffer);
		wooloffer.setBounds(232,210, 25, 30);
		
		add(pluswool);
		pluswool.setBounds(257,210, 45, 30);
		
		add(minusore);
		minusore.setBounds(330,210, 45, 30);
		
		add(oreoffer);
		oreoffer.setBounds(376,210, 25, 30);
		
		add(plusore);
		plusore.setBounds(402,210, 45, 30);
		
		add(minuswheat);
		minuswheat.setBounds(475,210, 45, 30);
		
		add(wheatoffer);
		wheatoffer.setBounds(521,210, 25, 30);
		
		add(pluswheat);
		pluswheat.setBounds(547,210, 45, 30);
		
		add(minuswood);
		minuswood.setBounds(620,210, 45, 30);
		
		add(woodoffer);
		woodoffer.setBounds(666,210, 25, 30);
		
		add(pluswood);
		pluswood.setBounds(692,210, 45, 30);
		
		stoneoffer.setEditable(false);
		oreoffer.setEditable(false);
		woodoffer.setEditable(false);
		wooloffer.setEditable(false);
		wheatoffer.setEditable(false);
		
		stoneoffer.setBackground(Color.WHITE);
		oreoffer.setBackground(Color.WHITE);
		woodoffer.setBackground(Color.WHITE);
		wooloffer.setBackground(Color.WHITE);
		wheatoffer.setBackground(Color.WHITE);
		
		setPreferredSize(new Dimension(800,600));
		setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(myBufferedImage1, 50, 100, 100, 100, null);
		g.drawImage(myBufferedImage2, 195, 100, 100, 100, null);
		g.drawImage(myBufferedImage3, 340, 100, 100, 100, null);
		g.drawImage(myBufferedImage4, 485, 100, 100, 100, null);
		g.drawImage(myBufferedImage5, 630, 100, 100, 100, null);
	}

}
