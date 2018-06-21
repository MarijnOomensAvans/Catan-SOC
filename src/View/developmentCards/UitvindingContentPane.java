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
import View.setupGame.DrawingPanel;

public class UitvindingContentPane extends JPanel {
	private BufferedImage myBufferedImage1;
	private BufferedImage myBufferedImage2;
	private BufferedImage myBufferedImage3;
	private BufferedImage myBufferedImage4;
	private BufferedImage myBufferedImage5;
	private PersonDAL pd;
	private BankController bct;

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
	
	
	

	public UitvindingContentPane(BankController bc, PlayerController pc, DrawingPanel dp, int playerid,
			UitvindingFrame uitvindingFrame) {
	
		this.setLayout(null);
		stone = "baksteen.jpg";
		wool = "schaap.jpg";
		ore = "erts.jpg";
		wheat = "graan.jpg";
		wood = "hout.jpg";
		
		choosestone = new JButton("+1 baksteen");
		chooseore = new JButton("+1 erts");
		choosewood = new JButton("+1 hout");
		choosewheat = new JButton("+1 graan");
		choosewool = new JButton("+1 schaap");
		
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
		choosestone.setBounds(100,280, 110, 30);
		
		add(choosewool);
		choosewool.setBounds(310, 280, 110, 30);
		
		add(chooseore);
		chooseore.setBounds(520, 280, 110, 30);
		
		add(choosewheat);
		choosewheat.setBounds(730, 280, 110, 30);
		
		add(choosewood);
		choosewood.setBounds(940, 280, 110, 30);
		
//		choosestone.addActionListener(new ActionListener() {

//			@Override
//			public void actionPerformed(ActionEvent e) {
//			MaterialCard card = bct.getMaterialCard("baksteen", playerid);
//			String cardid = card.getIdCard();
//			pd.addMaterialCard(10, cardid, 24);
//			}
//		});
		
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
