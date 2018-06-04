package View.inGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Controller.BoardController;
import Controller.ChatController;
import View.board.BoardColours;
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
	
	private Border border;
	//plek maken voor chat

	public IngameView(BoardController bc, int gameID,DrawingPanel inGameBoard, int playerID) {
		
		border = BorderFactory.createLineBorder(Color.BLACK, 1);
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
		JPanel costAndDicePanel = new JPanel();
		
		JPanel playerTurnPanel = new JPanel();
		JPanel playerCardsPanel = new JPanel();
		JPanel gameTurnPanel = new JPanel();
		JPanel extraPointsPanel = new JPanel();
		JPanel ownPointsPanel = new JPanel();
		
		playerTurnPanel.setPreferredSize(new Dimension(300, 100));
		playerCardsPanel.setPreferredSize(new Dimension(300, 400));
		gameTurnPanel.setPreferredSize(new Dimension(300, 50));
		
		buttonPanel.setBorder(border);
		resourceCardPanel.setBorder(border);
		buildCostPanel.setBorder(border);
		diceViewPanel.setBorder(border);
		diceButtonPanel.setBorder(border);
		
		JPanel boardPanel = new JPanel();
		
		JButton buildButton = new JButton();
		JButton tradeButton = new JButton();
		JButton devcardButton = new JButton();
		JButton throwDiceButton = new JButton("Gooi Dobbelstenen");
		
		JLabel streetLabel = new JLabel("Straat: 1B-1H");
		JLabel villageLabel = new JLabel("Dorp: 1B-1H-1G-1W");
		JLabel cityLabel = new JLabel("Stad: 2G-3E");
		JLabel devCardLabel = new JLabel("Ontwikkelingskaart: 1W-1G-1E");
		
		
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
		
		buildCostPanel.setPreferredSize(new Dimension(200, 100));
		buildCostPanel.setLayout(new GridLayout(0, 1));
		buildCostPanel.add(streetLabel);
		buildCostPanel.add(villageLabel);
		buildCostPanel.add(cityLabel);
		buildCostPanel.add(devCardLabel);
		
		diceButtonPanel.setLayout(new BorderLayout());
		diceButtonPanel.add(throwDiceButton, BorderLayout.CENTER);
		
		costAndDicePanel.setLayout(new BorderLayout());
		costAndDicePanel.add(buildCostPanel, BorderLayout.CENTER);
		costAndDicePanel.add(diceButtonPanel, BorderLayout.EAST);
		
		bottomInfoPanel.setLayout(new BorderLayout());
		bottomInfoPanel.add(resourceCardPanel, BorderLayout.WEST);
		bottomInfoPanel.add(costAndDicePanel, BorderLayout.CENTER);

		
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
