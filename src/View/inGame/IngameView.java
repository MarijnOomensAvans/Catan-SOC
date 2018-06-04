package View.inGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.BoardController;
import Controller.ChatController;
import View.board.BoardColours;
import View.build.BuildFrame;
import View.chat.ChatContentPane;
import View.chat.Chatoutputgui;
import View.setupGame.DrawingPanel;

@SuppressWarnings("serial")
public class IngameView extends JPanel{
	
	private final int WIDTH = 1500;
	private final int HEIGHT = 900; 
	
	private final int BUTTONWIDTH = 300;
	private final int BUTTONHEIGHT = 40;
	
	private GridLayout gridLayout = new GridLayout(0, 1, 0, 15);
	
	private ChatController chatController;
	private Chatoutputgui chatOutput;
	//plek maken voor chat

	public IngameView(BoardController bc, int gameID,DrawingPanel inGameBoard, int playerID) {
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(new BorderLayout());
		chatController = new ChatController(gameID,playerID);
		chatOutput = chatController.getCog();
		ChatContentPane chatPanel = new ChatContentPane(chatController, chatOutput, playerID);
		JPanel leftPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		JPanel bottomPanel = new JPanel();	
		
		JPanel buttonPanel = new JPanel();
		JPanel bottomInfoPanel = new JPanel();
		JPanel resourceCardPanel = new JPanel();
		JPanel buildCostPanel = new JPanel();
		JPanel diceButtonPanel = new JPanel();
		JPanel diceViewPanel = new JPanel();
		
		JPanel boardPanel = new JPanel();
		
		JButton buildButton = new JButton("Bouwen");
		buildButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new BuildFrame();
				
			}
			
		});
		JButton tradeButton = new JButton("Handelen");
		JButton devcardButton = new JButton("Ontwikkelingskaarten");
		
		
		buildButton.setPreferredSize(new Dimension(BUTTONWIDTH, BUTTONHEIGHT));
		tradeButton.setPreferredSize(new Dimension(BUTTONWIDTH, BUTTONHEIGHT));
		devcardButton.setPreferredSize(new Dimension(BUTTONWIDTH, BUTTONHEIGHT));
		
		
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
		
		buttonPanel.setLayout(gridLayout);
		buttonPanel.add(buildButton);
		buttonPanel.add(tradeButton);
		buttonPanel.add(devcardButton);
		
		bottomInfoPanel.setLayout(new BorderLayout());
		bottomInfoPanel.add(resourceCardPanel, BorderLayout.WEST);
		bottomInfoPanel.add(buildCostPanel, BorderLayout.CENTER);
		bottomInfoPanel.add(diceButtonPanel, BorderLayout.EAST);
		
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.add(buttonPanel, BorderLayout.WEST);
		bottomPanel.add(bottomInfoPanel, BorderLayout.CENTER);
		bottomPanel.add(diceViewPanel, BorderLayout.EAST);
		
		
		this.add(leftPanel, BorderLayout.LINE_START);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(rightPanel, BorderLayout.LINE_END);
		this.add(bottomPanel, BorderLayout.PAGE_END);
		
		
	}
}
