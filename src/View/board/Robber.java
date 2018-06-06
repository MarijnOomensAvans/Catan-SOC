package View.board;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Controller.BoardController;
import View.setupGame.DrawingPanel;



@SuppressWarnings("serial")
public class Robber extends JPanel {
	
	private ImageIcon image1;
	private BoardController bc;
	private int gameID;
	private DrawingPanel dp;
	
	public Robber(BoardController bc, int gameID, DrawingPanel drawingPanel) {
		this.bc = bc;
		this.gameID = gameID;
		this.dp = drawingPanel;
		
		image1 = new ImageIcon("Therobber.png");
		repaint();
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		image1.paintIcon(dp, g, getXRobber(), getYRobber());
	}
	
	private int getXRobber() {
		int x =bc.getRobberXPosition(gameID);
		return x;
		
	}
	private int getYRobber() {
		int y = bc.getRobberYPosition(gameID);
		return y;
		
	}
}
