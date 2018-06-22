package View.developmentCards;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.BankController;
import Controller.PlayerController;
import Controller.RobberController;
import DAL.PersonDAL;
import View.inGame.InGameFrame;
import View.setupGame.DrawingPanel;

@SuppressWarnings("serial")
public class DevelopmentContentPane extends JPanel{



private String bibliotheek;
private String kathedraal;
private String markt;
private String monopolie;
private String parlement;
private String ridder;
private String stratenbouw;
private String uitvinding;
private String universiteit;

private JButton usebib;
private JButton usekat;
private JButton usemarkt;
private JButton usemono;
private JButton usepar;
private JButton useridder;
private JButton usestrat;
private JButton useuit;
private JButton useuni;


private JTextField bibliotheekamount;
private JTextField kathedraalamount;
private JTextField marktamount;
private JTextField monopolieamount;
private JTextField parlementamount;
private JTextField ridderamount;
private JTextField stratenbouwamount;
private JTextField uitvindingamount;
private JTextField universiteitamount;

private BufferedImage myBufferedImage1;
private BufferedImage myBufferedImage2;
private BufferedImage myBufferedImage3;
private BufferedImage myBufferedImage4;
private BufferedImage myBufferedImage5;
private BufferedImage myBufferedImage6;
private BufferedImage myBufferedImage7;
private BufferedImage myBufferedImage8;
private BufferedImage myBufferedImage9;
		
		public DevelopmentContentPane(PersonDAL pd, BankController bc, PlayerController pc, int playerid, DrawingPanel dp, DevelopmentGui dgui,RobberController rb, InGameFrame gameFrame){
			
			
			this.setLayout(null);
			bibliotheek = "bibliotheek.jpg";
			kathedraal = "cathedraal.jpg";
			markt = "markt.jpg";
			monopolie = "monopolie.jpg";
			parlement = "parlement.jpg";
			ridder = "ridder.jpg";
			stratenbouw = "stratenbouw.jpg";
			uitvinding = "uitvinding.jpg";
			universiteit = "universiteit.jpg";

//			usebib = new JButton("Gebruik");
//			usekat = new JButton("Gebruik");
//			usemarkt = new JButton("Gebruik");
			usemono = new JButton("Gebruik");
			if(pc.getAmountMonopolie(playerid)== 0) {
				usemono.setBackground(Color.GRAY);
				usemono.setBorderPainted(false);
				usemono.setEnabled(false);
			}
//			usepar = new JButton("Gebruik");
			useridder = new JButton("Gebruik");
			if(pc.getAmountRidder(playerid)== 0) {
				useridder.setBackground(Color.GRAY);
				useridder.setBorderPainted(false);
				useridder.setEnabled(false);
			}
			usestrat = new JButton("Gebruik");
			if(pc.getAmountStratenbouw(playerid)== 0) {
				usestrat.setBackground(Color.GRAY);
				usestrat.setBorderPainted(false);
				usestrat.setEnabled(false);

			}
			useuit = new JButton("Gebruik");
			if(pc.getAmountUitvinding(playerid)== 0) {
				useuit.setBackground(Color.GRAY);
				useuit.setBorderPainted(false);
				useuit.setEnabled(false);
			}
//			useuni = new JButton("Gebruik");
			
			
			bibliotheekamount = new JTextField("" + pc.getAmountBibliotheek(playerid));
			kathedraalamount = new JTextField("" + pc.getAmountKathedraal(playerid));
			marktamount = new JTextField("" + pc.getAmountMarkt(playerid));
			monopolieamount = new JTextField("" + pc.getAmountMonopolie(playerid));
			parlementamount = new JTextField("" + pc.getAmountParlement(playerid));
			ridderamount = new JTextField("" + pc.getAmountRidder(playerid));
			stratenbouwamount = new JTextField("" + pc.getAmountStratenbouw(playerid));
			uitvindingamount = new JTextField("" + pc.getAmountUitvinding(playerid));
			universiteitamount = new JTextField("" + pc.getAmountUniversiteit(playerid));
			
			try {
				myBufferedImage1 = ImageIO.read(ClassLoader.getSystemResource(bibliotheek));
				myBufferedImage2 = ImageIO.read(ClassLoader.getSystemResource(kathedraal));
				myBufferedImage3 = ImageIO.read(ClassLoader.getSystemResource(markt));
				myBufferedImage4 = ImageIO.read(ClassLoader.getSystemResource(monopolie));
				myBufferedImage5 = ImageIO.read(ClassLoader.getSystemResource(parlement));
				myBufferedImage6 = ImageIO.read(ClassLoader.getSystemResource(ridder));
				myBufferedImage7 = ImageIO.read(ClassLoader.getSystemResource(stratenbouw));
				myBufferedImage8 = ImageIO.read(ClassLoader.getSystemResource(uitvinding));
				myBufferedImage9 = ImageIO.read(ClassLoader.getSystemResource(universiteit));
				
			}catch (IOException e) {
			System.out.println(e.getMessage());
			}
		this.repaint();
		
//		add(usebib);
//		usebib.setBounds(100,280, 100, 30);
		
		add(bibliotheekamount);
		bibliotheekamount.setBounds(130,280, 30, 30);
		
		
//		add(usekat);
//		usekat.setBounds(310,280, 100, 30);
		
		add(kathedraalamount);
		kathedraalamount.setBounds(340,280, 30, 30);
		
		
//		add(usemarkt);
//		usemarkt.setBounds(520,280, 100, 30);
//		
		add(marktamount);
		marktamount.setBounds(550,280,30,30);
		
		add(usemono);
		usemono.setBounds(730,280, 100, 30);
		
		add(monopolieamount);
		monopolieamount.setBounds(700,280,30,30);
		
//		add(usepar);
//		usepar.setBounds(940,280, 100, 30);
		
		add(parlementamount);
		parlementamount.setBounds(970,280,30,30);
	
		add(useridder);
		useridder.setBounds(100,560, 100, 30);
		
		add(ridderamount);
		ridderamount.setBounds(70, 560, 30,30);
		
		add(usestrat);
		usestrat.setBounds(310,560, 100, 30);
		
		add(stratenbouwamount);
		stratenbouwamount.setBounds(280,560,30,30);
		
		add(useuit);
		useuit.setBounds(520,560, 100, 30);
		
		add(uitvindingamount);
		uitvindingamount.setBounds(490,560,30,30);
		
//		add(useuni);
//		useuni.setBounds(730,560, 100, 30);
		
		add(universiteitamount);
		universiteitamount.setBounds(760,560, 30,30);
		
		usestrat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pc.getAmountStratenbouw(playerid)>= 1) {
				pc.useStratenbouw(playerid);
				dp.setBuildDev(true, "Street");
				dgui.dispose();
				}
			}
		});
		
		usemono.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pc.getAmountMonopolie(playerid)>= 1) {
//				pc.useMonopolie(playerid);
				dgui.dispose();
				new MonopolieFrame(pd, bc, pc, playerid, dp,gameFrame);
				}
			}
		});
		useridder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pc.getAmountRidder(playerid)>= 1) {
				pc.useRidder(playerid);
				rb.robberThrown(pc.getGameid());
				dgui.dispose();

				
				}
			}
		});
		useuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pc.getAmountUitvinding(playerid)>= 1) {
	
//				pc.useUitvinding(playerid);
				dgui.dispose();
				new UitvindingFrame(pd, bc, pc, playerid, dp,gameFrame);
				}
			}
				
		});
	
		bibliotheekamount.setEditable(false);
		kathedraalamount.setEditable(false);
		marktamount.setEditable(false);
		monopolieamount.setEditable(false);
		parlementamount.setEditable(false);
		ridderamount.setEditable(false);
		stratenbouwamount.setEditable(false);
		uitvindingamount.setEditable(false);
		universiteitamount.setEditable(false);
		
		setPreferredSize(new Dimension(1100,600));
		setVisible(true);
	}
		
		
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(myBufferedImage1, 45, 20, 205, 280, null);
		g.drawImage(myBufferedImage2, 255, 20, 205, 280, null);
		g.drawImage(myBufferedImage3, 465, 20, 205, 280, null);
		g.drawImage(myBufferedImage4, 675, 20, 205, 280, null);
		g.drawImage(myBufferedImage5, 885, 20, 205, 280, null);
		g.drawImage(myBufferedImage6, 45,  300, 205, 280, null);
		g.drawImage(myBufferedImage7, 255, 300, 205, 280, null);
		g.drawImage(myBufferedImage8, 465, 300, 205, 280, null);
		g.drawImage(myBufferedImage9, 675, 300, 205, 280, null);	}




	


	
}


