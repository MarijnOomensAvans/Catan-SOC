package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TradeContentPane extends JPanel {
	

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
	
	private int stoneDemandCounter =0;
	private int oreDemandCounter =0;
	private int woodDemandCounter =0;
	private int wheatDemandCounter =0;
	private int woolDemandCounter =0;


	private JButton plusStoneDemand;
	private JButton plusOreDemand;
	private JButton plusWoodDemand;
	private JButton plusWheatDemand;
	private JButton pluswoolDemand;

	private JButton minusDemandStone;
	private JButton minusDemandOre;
	private JButton minusDemandWood;
	private JButton minusDemandWheat;
	private JButton minusDemandWool;

	private JTextField stoneDemand;
	private JTextField oreDemand;
	private JTextField woodDemand;
	private JTextField wheatDemand;
	private JTextField woolDemand;
	
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
		
		plusstone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stoneOfferCounter++;
				stoneoffer.setText(""+stoneOfferCounter);
			}
			
		});
		
		
		plusore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				oreOfferCounter++;
				oreoffer.setText(""+oreOfferCounter);
				
			}
			
		});
		
		pluswood.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				woodOfferCounter++;
				woodoffer.setText(""+ woodOfferCounter);
				
			}
			
		});
		
		pluswheat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				wheatOfferCounter++;
				wheatoffer.setText("" + wheatOfferCounter);
				
			}
			
		});
		
		pluswool.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				woolOfferCounter++;
					wooloffer.setText("" + woolOfferCounter);
				
			}
			
		});
		
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
		
		minusstone.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (stoneOfferCounter > 0)
				{
					stoneOfferCounter--;
					stoneoffer.setText("" + stoneOfferCounter);
				}
			}
		});
		
		minusore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (oreOfferCounter > 0)
				{
					oreOfferCounter--;
					oreoffer.setText("" + oreOfferCounter);
				}
			}
		});
		
		minuswood.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (woodOfferCounter > 0)
				{
					woodOfferCounter--;
					woodoffer.setText("" + woodOfferCounter);
				}
			}
		});		
		
		minuswool.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (woolOfferCounter > 0)
				{
					woolOfferCounter--;
					wooloffer.setText("" + woolOfferCounter);
				}
			}
		});
		
		minuswheat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (wheatOfferCounter > 0)
				{
					wheatOfferCounter--;
					wheatoffer.setText("" + wheatOfferCounter);
				}
			}
		});
		
		plusStoneDemand = new JButton("+");
		plusOreDemand = new JButton("+");
		plusWoodDemand = new JButton("+");
		plusWheatDemand = new JButton("+");
		pluswool = new JButton("+");
		
		minusDemandStone = new JButton("-");
		minusDemandOre = new JButton("-");
		minusDemandWood = new JButton("-");
		minusDemandWheat = new JButton("-");
		minusDemandWool = new JButton("-");
		

		stoneDemand = new JTextField(""+stoneOfferCounter);
		oreDemand = new JTextField(""+oreDemandCounter);
		woodDemand = new JTextField(""+woodDemandCounter);
		woolDemand = new JTextField(""+woolDemandCounter);
		wheatDemand = new JTextField(""+wheatDemandCounter);
		

		
		add(minusDemandStone);
		minusDemandStone.setBounds(40,410, 45, 30);
		
		add(stoneDemand);
		stoneDemand.setBounds(86,410, 25, 30);
		
		add(plusStoneDemand);
		plusStoneDemand.setBounds(111,410, 45, 30);
		
		add(minusDemandWool);
		minusDemandWool.setBounds(186,410, 45, 30);
		
		add(woolDemand);
		woolDemand.setBounds(232,410, 25, 30);
		
		add(pluswool);
		pluswool.setBounds(257,410, 45, 30);
		
		add(minusDemandOre);
		minusDemandOre.setBounds(330,410, 45, 30);
		
		add(oreDemand);
		oreDemand.setBounds(376,410, 25, 30);
		
		add(plusOreDemand);
		plusOreDemand.setBounds(402,410, 45, 30);
		
		add(minusDemandWheat);
		minusDemandWheat.setBounds(475,410, 45, 30);
		
		add(wheatDemand);
		wheatDemand.setBounds(521,410, 25, 30);
		
		add(plusWheatDemand);
		plusWheatDemand.setBounds(547,410, 45, 30);
		
		add(minusDemandWood);
		minusDemandWood.setBounds(620,410, 45, 30);
		
		add(woodDemand);
		woodDemand.setBounds(666,410, 25, 30);
		
		add(plusWoodDemand);
		plusWoodDemand.setBounds(692,410, 45, 30);
		
		plusStoneDemand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stoneOfferCounter++;
				stoneDemand.setText(""+stoneOfferCounter);
			}
			
		});
		
		
		plusOreDemand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				oreDemandCounter++;
				oreDemand.setText(""+oreDemandCounter);
				
			}
			
		});
		
		plusWoodDemand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				woodDemandCounter++;
				woodDemand.setText(""+ woodDemandCounter);
				
			}
			
		});
		
		plusWheatDemand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				wheatDemandCounter++;
				wheatDemand.setText("" + wheatDemandCounter);
				
			}
			
		});
		
		pluswool.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				woolDemandCounter++;
					woolDemand.setText("" + woolDemandCounter);
				
			}
			
		});
		
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
		
		minusDemandStone.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (stoneOfferCounter > 0)
				{
					stoneOfferCounter--;
					stoneDemand.setText("" + stoneOfferCounter);
				}
			}
		});
		
		minusDemandOre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (oreDemandCounter > 0)
				{
					oreDemandCounter--;
					oreDemand.setText("" + oreDemandCounter);
				}
			}
		});
		
		minusDemandWood.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (woodDemandCounter > 0)
				{
					woodDemandCounter--;
					woodDemand.setText("" + woodDemandCounter);
				}
			}
		});		
		
		minusDemandWool.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (woolDemandCounter > 0)
				{
					woolDemandCounter--;
					woolDemand.setText("" + woolDemandCounter);
				}
			}
		});
		
		minusDemandWheat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (wheatDemandCounter > 0)
				{
					wheatDemandCounter--;
					wheatDemand.setText("" + wheatDemandCounter);
				}
			}
		});
		
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
