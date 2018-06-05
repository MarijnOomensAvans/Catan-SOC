package View.inGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Controller.BoardController;
import Controller.ChatController;
import Controller.DieController;
import Controller.IngameController;
import Controller.PlayerController;
import DAL.GameManagerDAL;
import Model.ingame.PlayerStats;
import View.board.BoardColours;
import View.build.BuildFrame;
import View.chat.ChatContentPane;
import View.chat.Chatoutputgui;
import View.dice.DieContentPane;
import View.setupGame.DrawingPanel;


@SuppressWarnings("serial")
public class IngameView extends JPanel{
	
	GameManagerDAL gameManagerDAL = new GameManagerDAL();
	
	private final int WIDTH = 1500;
	private final int HEIGHT = 900; 
	
	private final int BUTTONWIDTH = 300;
	private final int BUTTONHEIGHT = 40;
	
	private int gameID;
	private ArrayList<PlayerStats> playerStats;
	
	private GridLayout gridLayout = new GridLayout(0, 1, 0, 15);
	
	private ChatController chatController;
	private Chatoutputgui chatOutput;
	private IngameController inGameController;
	
	private JPanel playerCardsPanel;
	
	private JButton throwDiceButton;
	
	private Border border;
	//plek maken voor chat

	public IngameView(BoardController bc, int gameID,DrawingPanel inGameBoard, int playerID, IngameController inGameController) {
		this.gameID = gameID;
		throwDiceButton = new JButton("Gooi Dobbelstenen");
		if(gameManagerDAL.getFirstTurn(gameID)) {
			throwDiceButton.setEnabled(false);
		}
		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(new BorderLayout());
		
		DieController dc = new DieController(gameID);
		DieContentPane diceViewPanel = new DieContentPane(dc, throwDiceButton);
		
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
		
		JPanel costAndDicePanel = new JPanel();
		
		JPanel playerTurnPanel = new JPanel();
		playerCardsPanel = new JPanel();
		JPanel gameTurnPanel = new JPanel();
		JPanel extraPointsPanel = new JPanel();
		JPanel ownPointsPanel = new JPanel();
		
		playerTurnPanel.setPreferredSize(new Dimension(300, 50));
		playerCardsPanel.setPreferredSize(new Dimension(300, 250));
		gameTurnPanel.setPreferredSize(new Dimension(300, 50));
		extraPointsPanel.setPreferredSize(new Dimension(300, 200));
		ownPointsPanel.setPreferredSize(new Dimension(300, 122));
		
//		playerTurnPanel.setBackground(Color.red);
//		playerCardsPanel.setBackground(Color.blue);
//		gameTurnPanel.setBackground(Color.gray);
//		extraPointsPanel.setBackground(Color.green);
//		ownPointsPanel.setBackground(Color.orange);
//		
		buttonPanel.setBorder(border);
		resourceCardPanel.setBorder(border);
		buildCostPanel.setBorder(border);
		diceViewPanel.setBorder(border);
		diceButtonPanel.setBorder(border);
		
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
		
		JLabel streetLabel = new JLabel("Straat: 1B-1H");
		JLabel villageLabel = new JLabel("Dorp: 1B-1H-1G-1W");
		JLabel cityLabel = new JLabel("Stad: 2G-3E");
		JLabel devCardLabel = new JLabel("Ontwikkelingskaart: 1W-1G-1E");
		
		JLabel turnLabel = new JLabel("Speler aan de beurt: "); //HIER MOET DE SPELER DIE AAN DE BEURT IS TOEGEVOEGD WORDEN
		JLabel playersAndCardsLabel = new JLabel("Spelers en kaarten: " );
		JLabel gameTurnLabel = new JLabel("Beurt: "); // HIER MOET DE HUIDIGE BEURT IN
		JLabel largestArmyLabel = new JLabel("Grootste riddermacht: ");
		JLabel longestRouteLabel = new JLabel("Langste handelsroute: ");
		JLabel ownPointLabel = new JLabel("Eigen punten: ");
		
		turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playersAndCardsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameTurnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		largestArmyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		longestRouteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ownPointLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		buildButton.setPreferredSize(new Dimension(BUTTONWIDTH, BUTTONHEIGHT));
		tradeButton.setPreferredSize(new Dimension(BUTTONWIDTH, BUTTONHEIGHT));
		devcardButton.setPreferredSize(new Dimension(BUTTONWIDTH, BUTTONHEIGHT));
		
		extraPointsPanel.setLayout(new GridLayout(0, 1));
		playerCardsPanel.setLayout(new GridLayout(0, 1));
		
		boardPanel.add(inGameBoard);
		
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(boardPanel, BorderLayout.CENTER);
		
		centerPanel.setPreferredSize(new Dimension(900, 700));
		leftPanel.setPreferredSize(new Dimension(300, 700));
		rightPanel.setPreferredSize(new Dimension(300, 700));
		bottomPanel.setPreferredSize(new Dimension(1500, 200));
		
		leftPanel.setBackground(Color.black);
		bottomPanel.setBackground(Color.green);
		rightPanel.setBackground(Color.BLACK);
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

		
		playerTurnPanel.add(turnLabel);
		playerCardsPanel.add(playersAndCardsLabel); 
		getCards();
		gameTurnPanel.add(gameTurnLabel);
		extraPointsPanel.add(largestArmyLabel);
		extraPointsPanel.add(longestRouteLabel);
		ownPointsPanel.add(ownPointLabel);
		
		rightPanel.add(playerTurnPanel);
		rightPanel.add(playerCardsPanel);
		rightPanel.add(gameTurnPanel);
		rightPanel.add(extraPointsPanel);
		rightPanel.add(ownPointsPanel);
		
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.add(buttonPanel, BorderLayout.WEST);
		bottomPanel.add(bottomInfoPanel, BorderLayout.CENTER);
		bottomPanel.add(diceViewPanel, BorderLayout.EAST);
		
		
		this.add(leftPanel, BorderLayout.LINE_START);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(rightPanel, BorderLayout.LINE_END);
		this.add(bottomPanel, BorderLayout.PAGE_END);
		
		
	}
	
//	public JLabel GetCardsOwnedByPlayer(String name, int resourceCards, int developmentCards, int playedKnights) {
//		JLabel cardsLabel = new JLabel(name + " " + "Grondstof:" + resourceCards + "-ontwikkelings" + developmentCards + "-Gespeelde ridders" + playedKnights );
//		cardsLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		return cardsLabel;
//	}
	
	public void getCards() {
		
		playerStats = inGameController.getPlayerStats(gameID);
		
		for(int i = 0; i < playerStats.size(); i++) {
			String name = playerStats.get(i).getUsername();
			JLabel cardsLabel = new JLabel(name);
			playerCardsPanel.add(cardsLabel);
		}
	}
	

}
