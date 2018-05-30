package View.inGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import Controller.BoardController;
import Controller.ChatController;
import View.board.BoardColours;
import View.setupGame.DrawingPanel;
import View.chat.ChatContentPane;
import View.chat.Chatoutputgui;

@SuppressWarnings("serial")
public class IngameView extends JPanel{
	
	private final int WIDTH = 1500;
	private final int HEIGHT = 900; 
	
	private ChatController chatController;
	private Chatoutputgui chatOutput;
	//plek maken voor chat

	public IngameView(BoardController bc, int gameID,DrawingPanel inGameBoard) {
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(new BorderLayout());

		chatOutput = new Chatoutputgui(chatController, 45);
		chatController = new ChatController(gameID, chatOutput);
		
		ChatContentPane chatPanel = new ChatContentPane(chatController, chatOutput, 45);
		JPanel leftPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		JPanel bottomPanel = new JPanel();	
		
		JPanel boardPanel = new JPanel();
		
		boardPanel.add(inGameBoard);
		
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(boardPanel, BorderLayout.CENTER);
		
		centerPanel.setPreferredSize(new Dimension(900, 700));
		leftPanel.setPreferredSize(new Dimension(300, 700));
		rightPanel.setPreferredSize(new Dimension(300, 700));
		bottomPanel.setPreferredSize(new Dimension(1500, 200));
		
		leftPanel.setBackground(Color.black);
		rightPanel.setBackground(Color.orange);
		bottomPanel.setBackground(Color.green);
		boardPanel.setBackground(BoardColours.SEA.getRGB());
		
		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(chatPanel, BorderLayout.CENTER);
		
		this.add(leftPanel, BorderLayout.LINE_START);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(rightPanel, BorderLayout.LINE_END);
		this.add(bottomPanel, BorderLayout.PAGE_END);
		
		
	}
}
