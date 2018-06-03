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
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.TradeController;

@SuppressWarnings("serial")
public class BankPane extends JPanel {
		
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

	private JTextField stoneDemand;
	private JTextField oreDemand;
	private JTextField woodDemand;
	private JTextField wheatDemand;
	private JTextField woolDemand;

	private JButton plusStoneDemand;
	private JButton plusOreDemand;
	private JButton plusWoodDemand;
	private JButton plusWheatDemand;
	private JButton plusWoolDemand;

	private JButton minusDemandStone;
	private JButton minusDemandOre;
	private JButton minusDemandWood;
	private JButton minusDemandWheat;
	private JButton minusDemandWool;
	
	private int allcounted;
	
	private JButton sendButton;
	
	private JLabel offer;
	private JLabel demand;
	
	private TradeController tc;
	
	public BankPane(TradeController tc, int playerid) {
		this.tc =tc;
		this.setLayout(null);
		stone = new File("./Images/baksteen.jpg");
		wool = new File("./Images/schaap.jpg");
		ore = new File("./Images/erts.jpg");
		wheat = new File("./Images/graan.jpg");
		wood = new File("./Images/hout.jpg");
		
		offer = new JLabel("Ruilen met de bank 4:1");
		offer.setBounds(205,10,400,100);
		offer.setFont(new Font("Serif", Font.BOLD, 40));
		add(offer);
		demand = new JLabel("Je wilt graag");
		demand.setBounds(275,215,400,100);
		demand.setFont(new Font("Serif", Font.BOLD, 40));
		add(demand);
		
		
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
				int amount = stoneOfferCounter+1;
				if(tc.hasStoneCard(amount)) {
				stoneOfferCounter++;
				stoneoffer.setText(""+stoneOfferCounter);
				}
			}
			
		});
		
		
		plusore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int amount = oreOfferCounter+1;
				if(tc.hasOreCard(amount)) {
				oreOfferCounter++;
				oreoffer.setText(""+oreOfferCounter);
				}
			}
			
		});
		
		pluswood.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int amount = woodOfferCounter+1;
				if(tc.hasWoodCard(amount)) {
				woodOfferCounter++;
				woodoffer.setText(""+ woodOfferCounter);
				}
			}
			
		});
		
		pluswheat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int amount = wheatOfferCounter+1;
				if(tc.hasWheatCard(amount)) {
				wheatOfferCounter++;
				wheatoffer.setText("" + wheatOfferCounter);
				}
			}
			
		});
		
		pluswool.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int amount = woolOfferCounter+1;
				if(tc.hasWoolCard(amount)) {
				woolOfferCounter++;
					wooloffer.setText("" + woolOfferCounter);
				}
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
		plusWoolDemand = new JButton("+");
		
		minusDemandStone = new JButton("-");
		minusDemandOre = new JButton("-");
		minusDemandWood = new JButton("-");
		minusDemandWheat = new JButton("-");
		minusDemandWool = new JButton("-");
		

		stoneDemand = new JTextField(""+stoneDemandCounter);
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
		
		add(plusWoolDemand);
		plusWoolDemand.setBounds(257,410, 45, 30);
		
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
		
		sendButton = new JButton("Versturen");

		sendButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> cardkinds = new ArrayList<String>();
				for(int i =0; i<=stoneOfferCounter;i++) {
					if(i> 0) {
						cardkinds.add("B");
					}
				}
				for(int i =0; i<oreOfferCounter;i++) {
					if(i> 0) {
						cardkinds.add("E");
					}
				}
				for(int i =0; i<=woodOfferCounter;i++) {
					if(i> 0) {
						cardkinds.add("H");
					}
				}
				for(int i =0; i<=wheatOfferCounter;i++) {
					if(i> 0) {
						cardkinds.add("G");
					}
				}
				for(int i =0; i<=woolOfferCounter;i++) {
					if(i> 0) {
						cardkinds.add("W");
					}
				}
				tc.tradeBank(playerid,cardkinds);
				
			}
			
		});
		plusStoneDemand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				allcounted =stoneOfferCounter + oreOfferCounter+ woodOfferCounter+ wheatOfferCounter+ woolOfferCounter;
				if(allcounted == stoneDemandCounter +4) {
				stoneDemandCounter++;
				stoneDemand.setText(""+stoneDemandCounter);
				}
			}
			
		});
		
		
		plusOreDemand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				allcounted =stoneOfferCounter + oreOfferCounter+ woodOfferCounter+ wheatOfferCounter+ woolOfferCounter;
				if(allcounted == oreDemandCounter +4) {
				oreDemandCounter++;
				oreDemand.setText(""+oreDemandCounter);
				}
			}
			
		});
		
		plusWoodDemand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				allcounted =stoneOfferCounter + oreOfferCounter+ woodOfferCounter+ wheatOfferCounter+ woolOfferCounter;
				if(allcounted == woodDemandCounter +4) {
				woodDemandCounter++;
				woodDemand.setText(""+ woodDemandCounter);
				}
			}
			
		});
		
		plusWheatDemand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				allcounted =stoneOfferCounter + oreOfferCounter+ woodOfferCounter+ wheatOfferCounter+ woolOfferCounter;
				if(allcounted == wheatDemandCounter +4) {
				wheatDemandCounter++;
				wheatDemand.setText("" + wheatDemandCounter);
				}
			}
			
		});
		
		plusWoolDemand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				allcounted =stoneOfferCounter + oreOfferCounter+ woodOfferCounter+ wheatOfferCounter+ woolOfferCounter;
				if(allcounted == woolDemandCounter +4) {
				woolDemandCounter++;
					woolDemand.setText("" + woolDemandCounter);
				}
			}
			
		});
		
		minusDemandStone.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (stoneDemandCounter > 0)
				{
					stoneDemandCounter--;
					stoneDemand.setText("" + stoneDemandCounter);
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
		
		
		sendButton.setBounds(350,475,100,80);
		add(sendButton);
		sendButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String>cardkindsDemand = new ArrayList<String>();
				ArrayList<String>cardkindsOffer = new ArrayList<String>();
				for(int i =0; i< stoneDemandCounter;i++) {
					if(stoneDemandCounter > 0) {
						cardkindsDemand.add("B");
					}
				}
				for(int i =0; i< oreDemandCounter;i++) {
					if(oreDemandCounter > 0) {
						cardkindsDemand.add("E");
					}
				}
				for(int i =0; i< woodDemandCounter;i++) {
					if(woodDemandCounter > 0) {
						cardkindsDemand.add("H");
					}
				}
				for(int i =0; i< wheatDemandCounter;i++) {
					if(wheatDemandCounter > 0) {
						cardkindsDemand.add("G");
					}
				}
				for(int i =0; i< woodDemandCounter;i++) {
					if(woodDemandCounter > 0) {
						cardkindsDemand.add("H");
					}
				}
				for(int i =0; i< stoneOfferCounter;i++) {
					if(stoneOfferCounter > 0) {
						cardkindsOffer.add("B");
					}
				}
				for(int i =0; i< oreOfferCounter;i++) {
					if(oreOfferCounter > 0) {
						cardkindsOffer.add("E");
					}
				}
				for(int i =0; i< woodOfferCounter;i++) {
					if(woodOfferCounter > 0) {
						cardkindsOffer.add("H");
					}
				}
				for(int i =0; i< wheatOfferCounter;i++) {
					if(wheatOfferCounter > 0) {
						cardkindsOffer.add("G");
					}
				}
				for(int i =0; i< woolOfferCounter;i++) {
					if(woolOfferCounter > 0) {
						cardkindsOffer.add("W");
					}
				}
				tc.tradeBank(playerid, cardkindsDemand);
				tc.deleteCards(playerid, cardkindsOffer);
				tc.close();
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
