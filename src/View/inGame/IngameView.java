package View.inGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Controller.BankController;
import Controller.BoardController;
import Controller.ChatController;
import Controller.DieController;
import Controller.IngameController;
import Controller.LoginController;
import Controller.PlayerController;
import Model.ingame.PlayerStats;
import View.board.BoardColours;
import View.build.BuildFrame;
import View.chat.ChatContentPane;
import View.chat.Chatoutputgui;
import View.dice.DieContentPane;
import View.setupGame.DrawingPanel;

@SuppressWarnings({ "serial", "unused" })
public class IngameView extends JPanel implements Observer {

	private final int WIDTH = 1500;
	private final int HEIGHT = 900;

	private final int BUTTONWIDTH = 300;
	private final int BUTTONHEIGHT = 40;

	private int playerID;
	private int gameID;
	private ArrayList<PlayerStats> playerStats;

	private GridLayout gridLayout = new GridLayout(0, 1, 0, 15);

	private ChatController chatController;
	private IngameController inGameController;
	private Chatoutputgui chatOutput;
	private DieController dieController;
	private BoardController bc;

	private DieContentPane dieContentPane;

	private JPanel playerCardsPanel;
	private JLabel intTurnLabel;

	private JButton throwDiceButton;
	private JButton endTurnButton;
	private JButton tradeButton;
	private JButton buildButton;
	private JButton devcardButton;
	private JButton refreshButton;
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

	private int playerStoneCount;
	private int playerOreCount;
	private int playerWoodCount;
	private int playerWoolCount;
	private int playerWheatCount;

	private JPanel leftPanel;
	private JPanel centerPanel;
	private JPanel rightPanel;
	private JPanel bottomPanel;
	private JPanel diceAndButtonPanel;
	private JPanel buttonPanel;
	private JPanel bottomInfoPanel;
	private JPanel resourceCardPanel;
	private JPanel buildCostPanel;
	private JPanel diceButtonPanel;
	private JPanel costAndDicePanel;
	private JPanel playerTurnPanel;
	private JPanel extraPointsPanel;
	private JPanel ownPointsPanel;
	private JPanel boardPanel;

	private JLabel nameLongestRoutelabel;
	private JLabel nameBiggestArmyLabel;
	private JLabel streetLabel;
	private JLabel villageLabel;
	private JLabel cityLabel;
	private JLabel devCardLabel;
	private JLabel turnLabel;
	private JLabel playerTurnStringLabel;
	private JLabel playersAndCardsLabel;
	private JLabel largestArmyLabel;
	private JLabel longestRouteLabel;
	private JLabel ownPointLabel;
	private JLabel ownPointsValueLabel;
	private InGameFrame frame;
	private BuildFrame buildFrame;
	private ArrayList<JLabel> points;

	public IngameView(BoardController bc, int gameID, DrawingPanel inGameBoard, int playerID,
			IngameController inGameController, PlayerController pc, ChatController chatController,
			DieController dieController, InGameFrame frame, BankController bct) {
		this.playerID = playerID;
		this.chatController = chatController;
		this.gameID = gameID;
		this.inGameController = inGameController;
		this.dieController = dieController;
		this.frame = frame;
		this.bc = bc;
		points = new ArrayList<>();
		endTurnButton = new JButton("Beurt be�indigen");
		endTurnButton.setEnabled(false);
		endTurnButton.addActionListener(e -> {
			if (inGameController.isSecondRound() && inGameController.getFirstTurn()) {
				inGameController.setPlayerTurn(gameID, reversedPlayerTurn(gameID));
				if (inGameController.getTurn(gameID).equals(LoginController.getUsername())) {
					inGameController.setSecondRound(false);
					if (playerStats.get(0).getUsername().equals(LoginController.getUsername())) {
						inGameController.setFirstTurn(false);
					} else {
						inGameController.setPlayerTurn(gameID, reversedPlayerTurn(gameID));
					}
				}
			} else {
				inGameController.setPlayerTurn(gameID, nextPlayerTurn(gameID));
			}
			buildButton.setEnabled(false);
			tradeButton.setEnabled(false);
			devcardButton.setEnabled(false);
			endTurnButton.setEnabled(false);
			playerTurnUpdate();
			inGameController.setHasMovedRobber(true);
			inGameController.shouldRefresh(gameID);
			this.closeBuildWindow();
			this.closeTradeWindows(true);
			this.closeDevCardWindow();
		});

		playerStats = inGameController.getPlayerStats(gameID);

		throwDiceButton = new JButton("Gooi Dobbelstenen");
		if (!inGameController.getFirstTurn() && inGameController.getTurn(gameID).equals(LoginController.getUsername())
				&& !inGameController.hasRolledDice(gameID)) {
			throwDiceButton.setEnabled(true);
		} else {
			throwDiceButton.setEnabled(false);
		}
		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(new BorderLayout());

		dieContentPane = new DieContentPane(dieController, throwDiceButton);

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
		leftPanel = new JPanel();
		centerPanel = new JPanel();
		rightPanel = new JPanel();
		bottomPanel = new JPanel();

		diceAndButtonPanel = new JPanel();
		buttonPanel = new JPanel();
		bottomInfoPanel = new JPanel();
		resourceCardPanel = new JPanel();
		buildCostPanel = new JPanel();
		diceButtonPanel = new JPanel();

		costAndDicePanel = new JPanel();

		playerTurnPanel = new JPanel();
		playerCardsPanel = new JPanel();
		extraPointsPanel = new JPanel();
		ownPointsPanel = new JPanel();

		playerTurnPanel.setPreferredSize(new Dimension(300, 50));
		playerCardsPanel.setPreferredSize(new Dimension(300, 250));
		extraPointsPanel.setPreferredSize(new Dimension(300, 200));
		ownPointsPanel.setPreferredSize(new Dimension(300, 200));
		buttonPanel.setBorder(border);
		resourceCardsPanel.setBorder(border);
		buildCostPanel.setBorder(border);
		dieContentPane.setBorder(border);
		diceButtonPanel.setBorder(border);

		// Get the amount of all types of resources from db
		playerStoneCount = inGameController.getPc().getAmountStone(playerID);
		playerOreCount = inGameController.getPc().getAmountOre(playerID);
		playerWoodCount = inGameController.getPc().getAmountWood(playerID);
		playerWoolCount = inGameController.getPc().getAmountWool(playerID);
		playerWheatCount = inGameController.getPc().getAmountWheat(playerID);

		boardPanel = new JPanel();

		buildButton = new JButton("Bouwen");
		buildButton.setEnabled(false);
		buildButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buildButton.setEnabled(false);
				buildFrame = new BuildFrame(pc, inGameBoard, inGameController, bct, playerID);
			}

		});
		tradeButton = new JButton("Handelen");
		tradeButton.setEnabled(false);
		tradeButton.addActionListener(e -> {
			inGameController.openTrade();
			tradeButton.setEnabled(false);
		});

		devcardButton = new JButton("Ontwikkelingskaarten");
		devcardButton.setEnabled(false);
		devcardButton.addActionListener(e -> {
			devcardButton.setEnabled(false);
			inGameController.openDevcard();
		});
		
		refreshButton = new JButton("Vast? Ververs!");
		refreshButton.setPreferredSize(new Dimension(300, 100));
		refreshButton.addActionListener(e -> {
			inGameController.shouldRefresh(gameID, playerID);
		});
		if (allowedToEnd(gameID) && inGameController.hasRolledDice(gameID)) {
			endTurnButton.setEnabled(true);
		}

		streetLabel = new JLabel("Straat: 1B-1H");
		villageLabel = new JLabel("Dorp: 1B-1H-1G-1W");
		cityLabel = new JLabel("Stad: 2G-3E");
		devCardLabel = new JLabel("Ontwikkelingskaart: 1W-1G-1E");

		turnLabel = new JLabel("Speler aan de beurt: ");
		playerTurnStringLabel = new JLabel(inGameController.getTurn(gameID));
		playersAndCardsLabel = new JLabel("Spelers en kaarten: ");
		largestArmyLabel = new JLabel("Grootste riddermacht: ");
		nameBiggestArmyLabel = new JLabel(inGameController.getBiggestArmy(gameID));
		longestRouteLabel = new JLabel("Langste handelsroute: ");
		nameLongestRoutelabel = new JLabel(inGameController.getLongestRoute(gameID));
		ownPointLabel = new JLabel("Eigen punten: ");
		ownPointsValueLabel = ownPoints();

		turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playersAndCardsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		largestArmyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameBiggestArmyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		longestRouteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLongestRoutelabel.setHorizontalAlignment(SwingConstants.CENTER);
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

		resourceCardsPanel.setPreferredSize(new Dimension(400, 100));
		resourceCardsPanel.setLayout(new GridLayout(2, 5));

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

		stoneCount = new JLabel(playerStoneCount + "");
		oreCount = new JLabel(playerOreCount + "");
		woodCount = new JLabel(playerWoodCount + "");
		woolCount = new JLabel(playerWoolCount + "");
		wheatCount = new JLabel(playerWheatCount + "");

		Border paddingBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
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

		diceAndButtonPanel.add(dieContentPane, BorderLayout.CENTER);

		diceAndButtonPanel.add(endTurnButton, BorderLayout.EAST);

		playerTurnPanel.add(turnLabel);
		playerTurnPanel.add(playerTurnStringLabel);
		playerCardsPanel.add(playersAndCardsLabel);
		getCards();
		extraPointsPanel.add(largestArmyLabel);
		extraPointsPanel.add(nameBiggestArmyLabel);
		extraPointsPanel.add(longestRouteLabel);
		extraPointsPanel.add(nameLongestRoutelabel);
		ownPointsPanel.add(ownPointLabel);
		ownPointsPanel.add(ownPointsValueLabel);
		ownPointsPanel.add(refreshButton);

		rightPanel.add(playerTurnPanel);
		rightPanel.add(playerCardsPanel);
		rightPanel.add(extraPointsPanel);
		rightPanel.add(ownPointsPanel);

		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.add(buttonPanel, BorderLayout.WEST);
		bottomPanel.add(bottomInfoPanel, BorderLayout.CENTER);
		bottomPanel.add(diceAndButtonPanel, BorderLayout.EAST);

		this.add(leftPanel, BorderLayout.LINE_START);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(rightPanel, BorderLayout.LINE_END);
		this.add(bottomPanel, BorderLayout.PAGE_END);

		inGameController.shouldRefresh(gameID);

	}

	private void firstTurnCheck() {
		inGameController.firstTurnCheck();
	}

	public void getCards() {
		for (int i = 0; i < playerStats.size(); i++) {

			String name = playerStats.get(i).getUsername();
			int resourceCards = playerStats.get(i).getResourceCards();
			int developmentCards = playerStats.get(i).getDevelopmentCards();
			int knightCards = playerStats.get(i).getKnightCards();
			int publicPoints = playerStats.get(i).getPublicPoints();
			JLabel cardsLabel = new JLabel(name + " GK:" + resourceCards + " OK:" + developmentCards + " GR:"
					+ knightCards + " OV:" + publicPoints);

			cardsLabel.setHorizontalAlignment(SwingConstants.CENTER);
			points.add(cardsLabel);
			playerCardsPanel.add(cardsLabel);
		}
	}

	public String biggestArmyPlayer() {
		int biggest = 0;
		String nameBiggest = "";
		for (int i = 0; i < playerStats.size(); i++) {
			if (playerStats.get(i).getKnightCards() > biggest) {
				biggest = playerStats.get(i).getKnightCards();
				nameBiggest = playerStats.get(i).getUsername();
			}
		}
		if (biggest >= 3) {
			if (!nameBiggest.equals(nameBiggestArmyLabel.getText())) {
				inGameController.setbiggestArmy(gameID, nameBiggest);
			}
		} else {
			nameBiggest = "Niemand";
		}
		return nameBiggest;

	}

	public JLabel nextTurn(int id) {
		int turn = 1;
		intTurnLabel = new JLabel(turn + "");
		if (playerStats.get(0).getUsername().equals(inGameController.getTurn(id))) {
			turn++;
			intTurnLabel.setText(turn + "");
			repaint();
		}
		return intTurnLabel;
	}

	public JLabel ownPoints() {
		JLabel ownPoint = null;
		for (int i = 0; i < playerStats.size(); i++) {
			if (LoginController.getUsername().equals(playerStats.get(i).getUsername())) {
				ownPoint = new JLabel(playerStats.get(i).getPrivatePoints() + "");
			}
		}
		if(ownPoint != null) {
		return ownPoint;
		}
		else if(ownPoint == null) {
			return new JLabel("0");
		}
		return ownPoint;
	}

	public void winnerBox() {
		inGameController.logToChat(weGotAWinner() + " heeft gewonnen game be�indigd.");
		JOptionPane.showMessageDialog(null, weGotAWinner() + " heeft gewonnen", "Game be�indigd",
				JOptionPane.INFORMATION_MESSAGE);
		inGameController.setAllPlayersCanceled(gameID);

		frame.dispose();
		bc.openLobby();

	}

	public String weGotAWinner() {
		int tenPoints = 10;
		String winner = "";
		for (int i = 0; i < playerStats.size(); i++) {
			if (playerStats.get(i).getPrivatePoints() >= tenPoints) {
				winner = playerStats.get(i).getUsername();
			}
		}
		return winner;
	}

	public boolean allowedToEnd(int id) {
		boolean allowed = false;
		for (int i = 0; i < playerStats.size(); i++) {
			if (LoginController.getUsername().equals(inGameController.getTurn(id))) {
				allowed = true;
			}
		}
		return allowed;
	}

	public String nextPlayerTurn(int id) {
		String turnPlayer = "";
		if (playerStats.get(0).getUsername().equals(inGameController.getTurn(id))) {
			turnPlayer = playerStats.get(1).getUsername();
		} else if (playerStats.get(1).getUsername().equals(inGameController.getTurn(id))) {
			turnPlayer = playerStats.get(2).getUsername();
		} else if (playerStats.get(2).getUsername().equals(inGameController.getTurn(id))) {
			turnPlayer = playerStats.get(3).getUsername();
		} else if (playerStats.get(3).getUsername().equals(inGameController.getTurn(id))) {
			turnPlayer = playerStats.get(0).getUsername();
		}

		return turnPlayer;
	}

	public String reversedPlayerTurn(int id) {
		String turnPlayer = "";
		if (playerStats.get(0).getUsername().equals(inGameController.getTurn(id))) {
		} else if (playerStats.get(1).getUsername().equals(inGameController.getTurn(id))) {
			turnPlayer = playerStats.get(0).getUsername();
		} else if (playerStats.get(2).getUsername().equals(inGameController.getTurn(id))) {
			turnPlayer = playerStats.get(1).getUsername();
		} else if (playerStats.get(3).getUsername().equals(inGameController.getTurn(id))) {
			turnPlayer = playerStats.get(2).getUsername();
		}
		System.out.println("LOG: IngameView.java | turnplayer: " + turnPlayer);
		return turnPlayer;
	}

	/* UPDATE */
	public void uiUpdate() {
		dieContentPane.update();
		pointsLabelUpdate();
		playerTurnUpdate();
		throwDiceButtonUpdate();
		nextTurnButtonUpdate();
		resourceLabelsUpdate();
		biggestArmyUpdate();
		longestRouteUpdate();
		this.revalidate();
		this.repaint();
	}

	private void resourceLabelsUpdate() {
		for (int i = 0; i < playerStats.size(); i++) {
			if (playerStats.get(i).getUsername().equals(LoginController.getUsername())) {
				oreCount.setText(playerStats.get(i).getOre() + "");
				woodCount.setText(playerStats.get(i).getWood() + "");
				woolCount.setText(playerStats.get(i).getWool() + "");
				wheatCount.setText(playerStats.get(i).getWheat() + "");
				stoneCount.setText(playerStats.get(i).getStone() + "");
			}
		}
	}

	public void resourceLabelsUpdateDevCards() {
		playerStoneCount = inGameController.getPc().getAmountStone(playerID);
		playerOreCount = inGameController.getPc().getAmountOre(playerID);
		playerWoodCount = inGameController.getPc().getAmountWood(playerID);
		playerWoolCount = inGameController.getPc().getAmountWool(playerID);
		playerWheatCount = inGameController.getPc().getAmountWheat(playerID);

		oreCount.setText(playerOreCount + "");
		woodCount.setText(playerWoodCount + "");
		woolCount.setText(playerWoolCount + "");
		wheatCount.setText(playerWheatCount + "");
		stoneCount.setText(playerStoneCount + "");

	}

	public void playerTurnUpdate() {
		playerTurnStringLabel.setText(inGameController.getTurn(gameID));
	}

	public void longestRouteUpdate() {
		inGameController.updateLongestRoute();
		nameLongestRoutelabel.setText(inGameController.getLongestRoute(gameID));
	}

	public void biggestArmyUpdate() {
		nameBiggestArmyLabel.setText(biggestArmyPlayer());
	}

	public void pointsLabelUpdate() {

		for (int i = 0; i < playerStats.size(); i++) {

			String name = playerStats.get(i).getUsername();
			int resourceCards = playerStats.get(i).getResourceCards();
			int developmentCards = playerStats.get(i).getDevelopmentCards();
			int knightCards = playerStats.get(i).getKnightCards();
			int publicPoints = playerStats.get(i).getPublicPoints();
			points.get(i).setText(name + " GK:" + resourceCards + " OK:" + developmentCards + " GR:" + knightCards
					+ " OV:" + publicPoints);

			if (playerStats.get(i).getUsername().equals(LoginController.getUsername())) {
				ownPointsValueLabel.setText(playerStats.get(i).getPrivatePoints() + "");
			}
		}

	}

	public void nextTurnButtonUpdate() {

		int buildingCount = inGameController.getBuildingCount();
		int lastPlayerBuildingCount = inGameController.getBuildingCount(4);

		if (allowedToEnd(gameID)) {
			if (!inGameController.getFirstTurn()) {
				if (inGameController.hasRolledDice(gameID) && inGameController.hasMovedRobber()) {
					endTurnButton.setEnabled(true);
				}
			} else {
				if (((inGameController.getBuildingCount(4) >= 2) && inGameController.getBuildingCount() == 4)
						&& inGameController.getFirstTurn()) {
					inGameController.setSecondRound(true);
					endTurnButton.setEnabled(true);
				} else if ((inGameController.getBuildingCount(4) == 2) && inGameController.getBuildingCount() == 2) {
					if (inGameController.getTurn(gameID).equals(playerStats.get(3).getUsername())) {
						if (inGameController.getBuildingCount(4) == 4) {
							endTurnButton.setEnabled(true);
						}
					} else {
						endTurnButton.setEnabled(true);
					}
					inGameController.setSecondRound(true);
				} else if (buildingCount == 2 && lastPlayerBuildingCount < 2) {
					endTurnButton.setEnabled(true);
				} else if (buildingCount < 4 && lastPlayerBuildingCount == 4) {
					inGameController.setSecondRound(true);
				}
			}
		}
	}

	public void throwDiceButtonUpdate() {
		if (!inGameController.getFirstTurn()) {
			if (!inGameController.hasRolledDice(gameID) && allowedToEnd(gameID)) {
				dieContentPane.enableButton(true);
			}
		} else {
			dieContentPane.enableButton(false);
		}
	}

	public void setBuildButton(boolean enable) {
		buildButton.setEnabled(enable);
	}

	public void setTradeButton(boolean enable) {
		tradeButton.setEnabled(enable);
		this.revalidate();
	}

	public void setDevCardButton(boolean enable) {
		devcardButton.setEnabled(enable);
	}

	public void closeBuildWindow() {
		if (buildFrame != null) {
			buildFrame.closeFrame();
			buildFrame = null;
		}
	}

	public void closeTradeWindows(boolean thread) {
		inGameController.closeTradeWindows(thread);
	}

	public void closeDevCardWindow() {
		inGameController.closeDevCardWindow();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		playerStats = inGameController.getPlayerStats(gameID);
		uiUpdate(); // Update the ui
		firstTurnCheck(); // Ruleset for first turn
		for (int i = 0; i < playerStats.size(); i++) {
			if (playerStats.get(i).getPrivatePoints() >= 10) {
				winnerBox();
			}
		}

		if (inGameController.getFirstTurn()) {
			tradeButton.setEnabled(false);
			devcardButton.setEnabled(false);
		} else {
			if (inGameController.getTurn(gameID).equals(LoginController.getUsername())
					&& inGameController.hasRolledDice(gameID)) {
				buildButton.setEnabled(true);
				tradeButton.setEnabled(true);
				devcardButton.setEnabled(true);
			} else {
				buildButton.setEnabled(false);
				tradeButton.setEnabled(false);
				devcardButton.setEnabled(false);
			}
		}
	}

	public void closeEndTurnButton() {
		endTurnButton.setEnabled(false);

	}

	public void activateEndTurnButton() {
		endTurnButton.setEnabled(true);

	}

	public void disableBuildButton(boolean disable) {
		buildButton.setEnabled(disable);
		
	}

	public void disableDevButton() {
		devcardButton.setEnabled(false);
		
	}

}
