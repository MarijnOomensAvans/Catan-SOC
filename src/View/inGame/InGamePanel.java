package View.inGame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import Controller.BoardController;
import Controller.LoginController;
import View.dice.DrawingPanel;

public class InGamePanel extends JPanel{
	
	private final int WIDTH = 1400;
	private final int HEIGHT = 900; 
	
	private BoardController controller;
	//plek maken voor chat
	private DrawingPanel board;

	public InGamePanel(BoardController bc, int gameID) {
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(new GridBagLayout());
		
		
		board = new DrawingPanel(bc, gameID);
		
		//chat initaliseren
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.weightx = 0.5f;
		c.weighty = 0.5f;
		
		c.gridx = 0;
		c.gridy = 0;
		
		//c.gridheight = 4;
		// chat toevoegen
		
		
		
	}
}
