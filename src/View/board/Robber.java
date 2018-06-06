package View.board;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.BoardController;
<<<<<<< HEAD
import View.setupGame.DrawingPanel;
=======

>>>>>>> parent of bcf33cd... Revert "Merge branch 'GameSetup' of https://github.com/MarijnOomensAvans/Catan-SOC into GameSetup"



@SuppressWarnings("serial")
public class Robber extends JPanel {
	
	private ImageIcon image1;
<<<<<<< HEAD
	private BoardController bc;
	private int gameID;
	private DrawingPanel dp;
	private JLabel image;
	
	public Robber(BoardController bc, int gameID, DrawingPanel drawingPanel) {
		this.bc = bc;
		this.gameID = gameID;
		this.dp = drawingPanel;
		this.setPreferredSize(new Dimension(25,60));
		image1 = new ImageIcon(ClassLoader.getSystemResource("Therobber.png"));
		image = new JLabel(image1);
		image.setBounds(getXRobber(), getYRobber(), 25, 58);
=======
	private JLabel image;
	
	public Robber() {
		this.setPreferredSize(new Dimension(25,60));
		image1 = new ImageIcon(ClassLoader.getSystemResource("Therobber.png"));
		image = new JLabel(image1);
>>>>>>> parent of bcf33cd... Revert "Merge branch 'GameSetup' of https://github.com/MarijnOomensAvans/Catan-SOC into GameSetup"
		this.setBackground(null);
		add(image);
		repaint();
		validate();
		
<<<<<<< HEAD
	}

	
	private int getXRobber() {
		int x =bc.getRobberXPosition(gameID);
		return x;
		
	}
	private int getYRobber() {
		int y = bc.getRobberYPosition(gameID);
		return y;
		
=======
>>>>>>> parent of bcf33cd... Revert "Merge branch 'GameSetup' of https://github.com/MarijnOomensAvans/Catan-SOC into GameSetup"
	}

}
