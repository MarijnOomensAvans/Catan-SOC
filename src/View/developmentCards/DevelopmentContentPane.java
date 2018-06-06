package View.developmentCards;
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

import Controller.PlayerController;

@SuppressWarnings("serial")
public class DevelopmentContentPane extends JPanel{



private File bibliotheek;
private File kathedraal;
private File markt;
private File monopolie;
private File parlement;
private File ridder;
private File stratenbouw;
private File uitvinding;
private File universiteit;

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
		
		public DevelopmentContentPane(PlayerController pc, int playerid){
			
			this.setLayout(null);
			bibliotheek = new File("./Images/bibliotheek.jpg");
			kathedraal = new File("./Images/cathedraal.jpg");
			markt = new File("./Images/markt.jpg");
			monopolie = new File("./Images/monopoly.jpg");
			parlement = new File("./Images/parlement.jpg");
			ridder = new File("./Images/ridder.jpg");
			stratenbouw = new File("./Images/stratenbouw.jpg");
			uitvinding = new File("./Images/uitvinding.jpg");
			universiteit = new File("./Images/universiteit.jpg");

			usebib = new JButton("Gebruik");
			usekat = new JButton("Gebruik");
			usemarkt = new JButton("Gebruik");
			usemono = new JButton("Gebruik");
			usepar = new JButton("Gebruik");
			useridder = new JButton("Gebruik");
			usestrat = new JButton("Gebruik");
			useuit = new JButton("Gebruik");
			useuni = new JButton("Gebruik");
			
			
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
				myBufferedImage1 = ImageIO.read(bibliotheek);
				myBufferedImage2 = ImageIO.read(kathedraal);
				myBufferedImage3 = ImageIO.read(markt);
				myBufferedImage4 = ImageIO.read(monopolie);
				myBufferedImage5 = ImageIO.read(parlement);
				myBufferedImage6 = ImageIO.read(ridder);
				myBufferedImage7 = ImageIO.read(stratenbouw);
				myBufferedImage8 = ImageIO.read(uitvinding);
				myBufferedImage9 = ImageIO.read(universiteit);
				
			}catch (IOException e) {
			System.out.println(e.getMessage());
			}
		this.repaint();
		
		add(usebib);
		usebib.setBounds(100,280, 100, 30);
		
		add(bibliotheekamount);
		bibliotheekamount.setBounds(70,280, 30, 30);
		
		
		add(usekat);
		usekat.setBounds(310,280, 100, 30);
		
		add(kathedraalamount);
		kathedraalamount.setBounds(280,280, 30, 30);
		
		
		add(usemarkt);
		usemarkt.setBounds(520,280, 100, 30);
		
		add(marktamount);
		marktamount.setBounds(490,280,30,30);
		
		add(usemono);
		usemono.setBounds(730,280, 100, 30);
		
		add(monopolieamount);
		monopolieamount.setBounds(700,280,30,30);
		
		add(usepar);
		usepar.setBounds(940,280, 100, 30);
		
		add(parlementamount);
		parlementamount.setBounds(910,280,30,30);
	
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
		
		add(useuni);
		useuni.setBounds(730,560, 100, 30);
		
		add(universiteitamount);
		universiteitamount.setBounds(700,560, 30,30);
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


