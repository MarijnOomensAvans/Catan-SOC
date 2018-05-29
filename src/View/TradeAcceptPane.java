package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.TradeController;

@SuppressWarnings("serial")
public class TradeAcceptPane extends JPanel {
	
	private int stoneOfferCounter =0;
	private int oreOfferCounter =0;
	private int woodOfferCounter =0;
	private int wheatOfferCounter =0;
	private int woolOfferCounter =0;
	
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
	
	
	private JTextField stoneoffer;
	private JTextField oreoffer;
	private JTextField woodoffer;
	private JTextField wheatoffer;
	private JTextField wooloffer;
	
	
	private int stoneDemandCounter =0;
	private int oreDemandCounter =0;
	private int woodDemandCounter =0;
	private int wheatDemandCounter =0;
	private int woolDemandCounter =0;
	
	private JButton acceptButton;
	private JButton rejectButton;
	private JButton counterOffer;

	private JTextField stoneDemand;
	private JTextField oreDemand;
	private JTextField woodDemand;
	private JTextField wheatDemand;
	private JTextField woolDemand;
	
	private JLabel offer;
	private JLabel demand;
	
	public TradeAcceptPane(TradeController td, int playerid) {
		this.setLayout(null);
		stone = new File("./Images/baksteen.jpg");
		wool = new File("./Images/schaap.jpg");
		ore = new File("./Images/erts.jpg");
		wheat = new File("./Images/graan.jpg");
		wood = new File("./Images/hout.jpg");
		
		offer = new JLabel("Geeft");
		offer.setBounds(355,10,100,100);
		offer.setFont(new Font("Serif", Font.BOLD, 40));
		add(offer);
		
		demand = new JLabel("Vraagt");
		demand.setBounds(345, 215, 150,100);
		demand.setFont(new Font("Serif", Font.BOLD, 40));
		add(demand);
		

		stoneoffer = new JTextField(""+stoneOfferCounter);
		oreoffer = new JTextField(""+oreOfferCounter);
		woodoffer = new JTextField(""+woodOfferCounter);
		wooloffer = new JTextField(""+woolOfferCounter);
		wheatoffer = new JTextField(""+wheatOfferCounter);
		
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
		
		

		stoneDemand = new JTextField(""+stoneOfferCounter);
		oreDemand = new JTextField(""+oreDemandCounter);
		woodDemand = new JTextField(""+woodDemandCounter);
		woolDemand = new JTextField(""+woolDemandCounter);
		wheatDemand = new JTextField(""+wheatDemandCounter);
		
		add(stoneoffer);
		stoneoffer.setBounds(86,210, 25, 30);
		
		
		add(wooloffer);
		wooloffer.setBounds(232,210, 25, 30);
		
		add(oreoffer);
		oreoffer.setBounds(376,210, 25, 30);
		
		add(wheatoffer);
		wheatoffer.setBounds(521,210, 25, 30);
		
		add(woodoffer);
		woodoffer.setBounds(666,210, 25, 30);
		
		add(stoneDemand);
		stoneDemand.setBounds(86,410, 25, 30);
		
		add(woolDemand);
		woolDemand.setBounds(232,410, 25, 30);
		
		add(oreDemand);
		oreDemand.setBounds(376,410, 25, 30);
		
		add(wheatDemand);
		wheatDemand.setBounds(521,410, 25, 30);
		
		add(woodDemand);
		woodDemand.setBounds(666,410, 25, 30);
		
	
		
		stoneDemand.setEditable(false);
		oreDemand.setEditable(false);
		woodDemand.setEditable(false);
		woolDemand.setEditable(false);
		wheatDemand.setEditable(false);
		
		stoneDemand.setBackground(Color.WHITE);
		oreDemand.setBackground(Color.WHITE);
		woodDemand.setBackground(Color.WHITE);
		woolDemand.setBackground(Color.WHITE);
		wheatDemand.setBackground(Color.WHITE);
		
		add(stoneoffer);
		add(wooloffer);
		add(oreoffer);
		add(wheatoffer);
		add(woodoffer);
		
		acceptButton = new JButton("Accepteren");
		rejectButton = new JButton("Weigeren");
		counterOffer = new JButton("Tegenbod");
		
		acceptButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		acceptButton.setBounds(250,475,100,80);
		rejectButton.setBounds(350,475,100,80);
		counterOffer.setBounds(450,475,100,80);
		add(acceptButton);
		add(rejectButton);
		add(counterOffer);
		
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
		g.drawImage(myBufferedImage1, 50,  300, 100, 100, null);
		g.drawImage(myBufferedImage2, 195, 300, 100, 100, null);
		g.drawImage(myBufferedImage3, 340, 300, 100, 100, null);
		g.drawImage(myBufferedImage4, 485, 300, 100, 100, null);
		g.drawImage(myBufferedImage5, 630, 300, 100, 100, null);
	}

}


