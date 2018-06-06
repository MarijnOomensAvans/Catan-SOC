package View.trade;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.TradeController;

@SuppressWarnings("serial")
public class TradeAcceptPane extends JPanel implements Observer {

	private int stoneOfferCounter = 0;
	private int oreOfferCounter = 0;
	private int woodOfferCounter = 0;
	private int wheatOfferCounter = 0;
	private int woolOfferCounter = 0;

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

	private JTextField stoneoffer;
	private JTextField oreoffer;
	private JTextField woodoffer;
	private JTextField wheatoffer;
	private JTextField wooloffer;

	private int stoneDemandCounter = 0;
	private int oreDemandCounter = 0;
	private int woodDemandCounter = 0;
	private int wheatDemandCounter = 0;
	private int woolDemandCounter = 0;

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

	private TradeController tc;

	public TradeAcceptPane(TradeController tc, int playerid) {
		this.tc = tc;
		this.tc.setRunthread(true);
		this.setLayout(null);
		
			stone = "baksteen.jpg";
			wool = "schaap.jpg";
			ore = "erts.jpg";
			wheat = "graan.jpg";
			wood = "hout.jpg";
		

		offer = new JLabel();
		offer.setBounds(355, 10, 350, 100);
		offer.setFont(new Font("Serif", Font.BOLD, 40));
		add(offer);

		demand = new JLabel();
		demand.setBounds(345, 215, 350, 100);
		demand.setFont(new Font("Serif", Font.BOLD, 40));
		add(demand);

		stoneoffer = new JTextField("" + stoneOfferCounter);
		oreoffer = new JTextField("" + oreOfferCounter);
		woodoffer = new JTextField("" + woodOfferCounter);
		wooloffer = new JTextField("" + woolOfferCounter);
		wheatoffer = new JTextField("" + wheatOfferCounter);

		try {
			myBufferedImage1 = ImageIO.read(ClassLoader.getSystemResourceAsStream(stone));
			myBufferedImage2 = ImageIO.read(ClassLoader.getSystemResourceAsStream(ore));
			myBufferedImage3 = ImageIO.read(ClassLoader.getSystemResourceAsStream(wood));
			myBufferedImage4 = ImageIO.read(ClassLoader.getSystemResourceAsStream(wool));
			myBufferedImage5 = ImageIO.read(ClassLoader.getSystemResourceAsStream(wheat));
		} catch (IOException e) {
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

		stoneDemand = new JTextField("" + stoneDemandCounter);
		oreDemand = new JTextField("" + oreDemandCounter);
		woodDemand = new JTextField("" + woodDemandCounter);
		woolDemand = new JTextField("" + woolDemandCounter);
		wheatDemand = new JTextField("" + wheatDemandCounter);

		add(stoneoffer);
		stoneoffer.setBounds(86, 210, 25, 30);

		add(wooloffer);
		wooloffer.setBounds(232, 210, 25, 30);

		add(oreoffer);
		oreoffer.setBounds(376, 210, 25, 30);

		add(wheatoffer);
		wheatoffer.setBounds(521, 210, 25, 30);

		add(woodoffer);
		woodoffer.setBounds(666, 210, 25, 30);

		add(stoneDemand);
		stoneDemand.setBounds(86, 410, 25, 30);

		add(woolDemand);
		woolDemand.setBounds(232, 410, 25, 30);

		add(oreDemand);
		oreDemand.setBounds(376, 410, 25, 30);

		add(wheatDemand);
		wheatDemand.setBounds(521, 410, 25, 30);

		add(woodDemand);
		woodDemand.setBounds(666, 410, 25, 30);

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
				tc.setRunthread(false);
				tc.createOffer(playerid, stoneDemandCounter, woolDemandCounter, oreDemandCounter, wheatDemandCounter, woodDemandCounter, stoneOfferCounter, woolOfferCounter, oreOfferCounter, wheatOfferCounter, woodOfferCounter, true);
				tc.close();
			}

		});
		rejectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tc.setRunthread(false);
				tc.createOffer(playerid, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false);
				tc.close();
			}

		});
		counterOffer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tc.setRunthread(false);
				tc.switchCounterOffer();
			}

		});

		acceptButton.setBounds(250, 475, 100, 80);
		counterOffer.setBounds(350, 475, 100, 80);
		rejectButton.setBounds(450, 475, 100, 80);
		add(acceptButton);
		add(rejectButton);
		add(counterOffer);

		setPreferredSize(new Dimension(800, 600));
		setVisible(true);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(myBufferedImage1, 50, 100, 100, 100, null);
		g.drawImage(myBufferedImage2, 195, 100, 100, 100, null);
		g.drawImage(myBufferedImage3, 340, 100, 100, 100, null);
		g.drawImage(myBufferedImage4, 485, 100, 100, 100, null);
		g.drawImage(myBufferedImage5, 630, 100, 100, 100, null);
		g.drawImage(myBufferedImage1, 50, 300, 100, 100, null);
		g.drawImage(myBufferedImage2, 195, 300, 100, 100, null);
		g.drawImage(myBufferedImage3, 340, 300, 100, 100, null);
		g.drawImage(myBufferedImage4, 485, 300, 100, 100, null);
		g.drawImage(myBufferedImage5, 630, 300, 100, 100, null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object arg) {

		for (int i = 0; i < ((ArrayList<Integer>) arg).size(); i++) {
			if(i ==0) {
				int playerid = ((ArrayList<Integer>) arg).get(i);
				offer.setText(tc.getUsername(playerid)+ " geeft");
				offer.setBounds(305, 10, 350, 100);
				demand.setText(tc.getUsername(playerid)+ " vraagt");
				demand.setBounds(300, 215, 350, 100);
			}
			if (i == 1) {
				stoneOfferCounter =((ArrayList<Integer>) arg).get(i);
				stoneoffer.setText(""+stoneOfferCounter);
			} else if (i == 2) {
				woolOfferCounter =((ArrayList<Integer>) arg).get(i);
				wooloffer.setText(""+woolOfferCounter);
			} else if (i == 3) {
				oreOfferCounter =((ArrayList<Integer>) arg).get(i);
				oreoffer.setText(""+oreOfferCounter);
			} else if (i == 4) {
				wheatOfferCounter =((ArrayList<Integer>) arg).get(i);
				wheatoffer.setText(""+wheatOfferCounter);
			} else if (i == 5) {
				woodOfferCounter =((ArrayList<Integer>) arg).get(i);
				woodoffer.setText(""+woodOfferCounter);
			} else if (i == 6) {
				stoneDemandCounter =((ArrayList<Integer>) arg).get(i);
				stoneDemand.setText(""+stoneDemandCounter);
			} else if (i == 7) {
				woolDemandCounter =((ArrayList<Integer>) arg).get(i);
				woolDemand.setText(""+woolDemandCounter);
			} else if (i == 8) {
				oreDemandCounter =((ArrayList<Integer>) arg).get(i);
				oreDemand.setText(""+oreDemandCounter);
			} else if (i == 9) {
				wheatDemandCounter =((ArrayList<Integer>) arg).get(i);
				wheatDemand.setText(""+wheatDemandCounter);
			} else if (i == 10) {
				woodDemandCounter =((ArrayList<Integer>) arg).get(i);
				woodDemand.setText(""+woodDemandCounter);
			}
		}
		this.repaint();
		

	}

}
