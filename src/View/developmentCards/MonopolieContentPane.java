package View.developmentCards;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import DAL.PersonDAL;

import Controller.BankController;
import Controller.PlayerController;
import Model.MaterialCard;
import View.inGame.InGameFrame;
import View.setupGame.DrawingPanel;

public class MonopolieContentPane extends JPanel {
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
	
	private JButton choosestone;
	private JButton chooseore;
	private JButton choosewood;
	private JButton choosewheat;
	private JButton choosewool;
	
	public MonopolieContentPane(PersonDAL pd, BankController bc, PlayerController pc, DrawingPanel dp, int playerid,
			MonopolieFrame mp, InGameFrame gameFrame) {
		this.setLayout(null);
		stone = "baksteen.jpg";
		wool = "schaap.jpg";
		ore = "erts.jpg";
		wheat = "graan.jpg";
		wood = "hout.jpg";
				
		choosestone = new JButton("steel baksteen");
		chooseore = new JButton("steel erts");
		choosewood = new JButton("steel hout");
		choosewheat = new JButton("steel graan");
		choosewool = new JButton("steel schaap");
		
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
		
		add(choosestone);
		choosestone.setBounds(100,280, 130, 30);
		
		add(choosewool);
		choosewool.setBounds(310, 280, 110, 30);
		
		add(chooseore);
		chooseore.setBounds(520, 280, 110, 30);
		
		add(choosewheat);
		choosewheat.setBounds(730, 280, 110, 30);
		
		add(choosewood);
		choosewood.setBounds(940, 280, 110, 30);
		
		choosestone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			pd.stealAllPlayerCards("B%", pc.getGameid(), playerid);
			gameFrame.updateGui();
			pc.updateHand();
			mp.dispose();
			}
			
		});
		
		choosewool.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			MaterialCard card = bc.getMaterialCard("W", playerid);
			String cardid = card.getIdCard();
			pd.addMaterialCard(pc.getGameid(), cardid, playerid);
			gameFrame.updateGui();
			pc.updateHand();
			
			}
		});
		chooseore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			MaterialCard card = bc.getMaterialCard("E", playerid);
			String cardid = card.getIdCard();
			pd.addMaterialCard(pc.getGameid(), cardid, playerid);
			gameFrame.updateGui();
			
			}
			
		});
		choosewheat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			MaterialCard card = bc.getMaterialCard("G", playerid);
			String cardid = card.getIdCard();
			pd.addMaterialCard(pc.getGameid(), cardid, playerid);
			gameFrame.updateGui();
			
			}
			
		});
		choosewood.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			MaterialCard card = bc.getMaterialCard("H", playerid);
			String cardid = card.getIdCard();
			pd.addMaterialCard(pc.getGameid(), cardid, playerid);
			gameFrame.updateGui();
				
			}
			
		});


		
		setPreferredSize(new Dimension(1100,600));
		setVisible(true);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(myBufferedImage1, 45, 20, 205, 280, null);
		g.drawImage(myBufferedImage2, 255, 20, 205, 280, null);
		g.drawImage(myBufferedImage3, 465, 20, 205, 280, null);
		g.drawImage(myBufferedImage4, 675, 20, 205, 280, null);
		g.drawImage(myBufferedImage5, 885, 20, 205, 280, null);
	}
		

}
	

