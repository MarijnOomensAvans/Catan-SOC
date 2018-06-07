package View.inGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Controller.BoardController;
import Controller.ChatController;
import Controller.DieController;
import Controller.IngameController;
import Controller.LoginController;
import Controller.PlayerController;
import DAL.GameManagerDAL;
import Model.ingame.PlayerStats;
import View.board.BoardColours;
import View.build.BuildFrame;
import View.chat.ChatContentPane;
import View.chat.Chatoutputgui;
import View.dice.DieContentPane;
import View.setupGame.DrawingPanel;
import View.developmentCards.DevelopmentGui;
import View.developmentCards.DevelopmentContentPane;

@SuppressWarnings("serial")
public class IngameView extends JPanel {

	GameManagerDAL gameManagerDAL = new GameManagerDAL();

	private final int WIDTH = 1500;
	private final int HEIGHT = 900;

	private final int BUTTONWIDTH = 300;
	private final int BUTTONHEIGHT = 40;

	private int gameID;
	private ArrayList<PlayerStats> playerStats;

	private GridLayout gridLayout = new GridLayout(0, 1, 0, 15);

	private ChatController chatController;
	private IngameController ingameController;
	private Chatoutputgui chatOutput;

	private JPanel playerCardsPanel;
	private JLabel intTurnLabel;

	private JButton throwDiceButton;
	private Border border;
	
	private ImageIcon stone;
	private ImageIcon ore;
	private ImageIcon wood;
	private ImageIcon wool;
	private ImageIcon wheat;
	
	private JLabel stoneLabel;
	private JLabel oreLabel;
	private JLabel woodLabel;
	private JLabel woolLabel;
	private JLabel wheatLabel;
	
	private JLabel stoneCount;
	private JLabel oreCount;
	private JLabel woodCount;
	private JLabel woolCount;
	private JLabel wheatCount;
	

	public IngameView(BoardController bc, int gameID, DrawingPanel inGameBoard, int playerID,
			IngameController inGameController, PlayerController pc) {
		this.ingameController = inGameController;
		playerStats = inGameController.getPlayerStats(gameID);
		this.gameID = gameID;
		throwDiceButton = new JButton("Gooi Dobbelstenen");
		if (gameManagerDAL.getFirstTurn(gameID) && gameManagerDAL.getPlayerIDTurn(gameID) == playerID
				&& gameManagerDAL.getHasThrown(gameID) == false) {
			throwDiceButton.setEnabled(true);
		} else {
			throwDiceButton.setEnabled(false);
		}
		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(new BorderLayout());

		DieController dc = new DieController(gameID);
		DieContentPane diceViewPanel = new DieContentPane(dc, throwDiceButton);

		chatController = new ChatController(gameID, playerID);
		chatOutput = chatController.getCog();
		ChatContentPane chatPanel = new ChatContentPane(chatController, chatOutput, playerID);
		JPanel leftPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		JPanel bottomPanel = new JPanel();

		JPanel diceAndButtonPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel bottomInfoPanel = new JPanel();
		JPanel resourceCardsPanel = new JPanel();
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
		
		buttonPanel.setBorder(border);
		resourceCardsPanel.setBorder(border);
		buildCostPanel.setBorder(border);
		diceViewPanel.setBorder(border);
		diceButtonPanel.setBorder(border);

		JPanel boardPanel = new JPanel();

		JButton buildButton = new JButton("Bouwen");
		buildButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new BuildFrame(pc, inGameBoard);

			}

		});
		JButton tradeButton = new JButton("Handelen");
		JButton devcardButton = new JButton("Ontwikkelingskaarten");
		JButton endTurnButton = new JButton("Beurt beŽindigen");
		
		tradeButton.addActionListener(e -> {
			inGameController.openTrade();
		});

		devcardButton.addActionListener(e -> {
			inGameController.openDevcard();
		});
		
		endTurnButton.addActionListener(e -> {
			
		});

		JLabel streetLabel = new JLabel("Straat: 1B-1H");
		JLabel villageLabel = new JLabel("Dorp: 1B-1H-1G-1W");
		JLabel cityLabel = new JLabel("Stad: 2G-3E");
		JLabel devCardLabel = new JLabel("Ontwikkelingskaart: 1W-1G-1E");

		JLabel turnLabel = new JLabel("Speler aan de beurt: "); // HIER MOET DE SPELER DIE AAN DE BEURT IS TOEGEVOEGD
																// WORDEN
		JLabel playerTurnStringLabel = new JLabel(inGameController.getTurn(gameID));
		JLabel playersAndCardsLabel = new JLabel("Spelers en kaarten: ");
		JLabel gameTurnLabel = new JLabel("Ronde: ");
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
		
		resourceCardsPanel.setPreferredSize(new Dimension(400,100));
		resourceCardsPanel.setLayout(new GridLayout(2,5));
		
		stone = new ImageIcon(ClassLoader.getSystemResource("baksteen.jpg"));
		ore = new ImageIcon(ClassLoader.getSystemResource("erts.jpg"));
		wood = new ImageIcon(ClassLoader.getSystemResource("hout.jpg"));
		wool = new ImageIcon(ClassLoader.getSystemResource("schaap.jpg"));
		wheat = new ImageIcon(ClassLoader.getSystemResource("graan.jpg"));
		
		stoneLabel = new JLabel(stone);
		oreLabel = new JLabel(ore);
		woodLabel = new JLabel(wood);
		woolLabel = new JLabel(wool);
		wheatLabel = new JLabel(wheat);
		
		resourceCardsPanel.add(stoneLabel);
		resourceCardsPanel.add(oreLabel);
		resourceCardsPanel.add(woodLabel);
		resourceCardsPanel.add(woolLabel);
		resourceCardsPanel.add(wheatLabel);
		
		stoneCount = new JLabel("2");
		oreCount = new JLabel("4");
		woodCount = new JLabel("1");
		woolCount = new JLabel("1");
		wheatCount = new JLabel("1");
		
		Border paddingBorder = BorderFactory.createEmptyBorder(30,30,30,30);
		stoneCount.setBorder(paddingBorder);
		oreCount.setBorder(paddingBorder);
		woodCount.setBorder(paddingBorder);
		woolCount.setBorder(paddingBorder);
		wheatCount.setBorder(paddingBorder);
		
		resourceCardsPanel.add(stoneCount);
		resourceCardsPanel.add(oreCount);
		resourceCardsPanel.add(woodCount);
		resourceCardsPanel.add(woolCount);
		resourceCardsPanel.add(wheatCount);
		
		
		
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
		bottomInfoPanel.add(resourceCardsPanel, BorderLayout.WEST);
		bottomInfoPanel.add(costAndDicePanel, BorderLayout.CENTER);
		
		diceAndButtonPanel.setLayout(new BorderLayout());
		diceAndButtonPanel.setPreferredSize(new Dimension(230, 100));
		diceAndButtonPanel.add(diceViewPanel, BorderLayout.CENTER);
		diceAndButtonPanel.add(endTurnButton, BorderLayout.EAST);

		playerTurnPanel.add(turnLabel);
		playerTurnPanel.add(playerTurnStringLabel);
		playerCardsPanel.add(playersAndCardsLabel);
		getCards();
		gameTurnPanel.add(gameTurnLabel);
		gameTurnPanel.add(nextTurn(gameID));
		extraPointsPanel.add(largestArmyLabel);
		extraPointsPanel.add(hasBiggestArmy());
		extraPointsPanel.add(longestRouteLabel);
		ownPointsPanel.add(ownPointLabel);
		ownPointsPanel.add(ownPoints());

		rightPanel.add(playerTurnPanel);
		rightPanel.add(playerCardsPanel);
		rightPanel.add(gameTurnPanel);
		rightPanel.add(extraPointsPanel);
		rightPanel.add(ownPointsPanel);

		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.add(buttonPanel, BorderLayout.WEST);
		bottomPanel.add(bottomInfoPanel, BorderLayout.CENTER);
		bottomPanel.add(diceAndButtonPanel, BorderLayout.EAST);

		hasBiggestArmy();

		this.add(leftPanel, BorderLayout.LINE_START);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(rightPanel, BorderLayout.LINE_END);
		this.add(bottomPanel, BorderLayout.PAGE_END);

	}

	public void getCards() {
		for (int i = 0; i < playerStats.size(); i++) {
			
			String name = playerStats.get(i).getUsername();
			int resourceCards = playerStats.get(i).getResourceCards();
			int developmentCards = playerStats.get(i).getDevelopmentCards();
			int knightCards = playerStats.get(i).getKnightCards();
			int publicPoints = playerStats.get(i).getPublicPoints();
			JLabel cardsLabel = new JLabel(name + " GK:" + resourceCards + " OK:" + developmentCards + " GR:" + knightCards + " OV:"+ publicPoints);

			cardsLabel.setHorizontalAlignment(SwingConstants.CENTER);
			playerCardsPanel.add(cardsLabel);
		}
	}

	public JLabel hasBiggestArmy() {
		int biggest = 0;
		String nameBiggest = "";
		for (int i = 0; i < playerStats.size(); i++) {
			if (playerStats.get(i).getKnightCards() > biggest) {
				biggest = playerStats.get(i).getKnightCards();
				nameBiggest = playerStats.get(i).getUsername();
				ingameController.setbiggestArmy(gameID, nameBiggest);
			}
		}
		JLabel biggestArmyLabel = new JLabel(nameBiggest);
		biggestArmyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		return biggestArmyLabel;

	}

	public JLabel nextTurn(int id) {
		int turn = 1;
		intTurnLabel = new JLabel(turn + "");
		if (playerStats.get(0).getUsername().equals(ingameController.getTurn(id))) {
			turn++;
			intTurnLabel.setText(turn + "");
			repaint();
		}
		return intTurnLabel;
	}

	
	public JLabel ownPoints() {
		JLabel ownPoint = null;
		for(int i =0; i< playerStats.size(); i++) {
			if(LoginController.getUsername().equals(playerStats.get(i).getUsername())) {
				ownPoint = new JLabel(playerStats.get(i).getPrivatePoints()+"");				
			}
		}
		return ownPoint;
	}


}
