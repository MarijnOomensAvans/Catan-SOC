package View.lobby;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Controller.LoginController;
import Model.lobby.LobbyGameInfo;
import Model.lobby.LobbyInvite;

@SuppressWarnings("serial")
public class LobbyPanel extends JPanel implements Observer {

	private LobbyContentPane pane;
	private ArrayList<String> usernames;
	private ArrayList<LobbyInvite> invites;
	private ArrayList<LobbyGameInfo> games;

	private final int WIDTH = 1400;
	private final int HEIGHT = 900;
	private final int TOPPANELHEIGHT = 200;
	private final int SIDEPANELWIDTH = 320;
	private final int NAMEHEIGHT = 40;
	private final int INVITEWIDTH = 290;
	private final int INVITELABELWIDTH = 150;
	private final int PADDINGWIDTH = 40;
	private final int INVITEBUTTONWIDTH = 50;

	private JPanel topPanel;
	private JPanel rightPanel;
	private JPanel leftPanel;
	private JPanel centerPanel;

	private JPanel accountPanel;
	private JPanel gamesPanel;
	private JPanel challengePanel;
	private JPanel ourNamePanel;
	private JPanel accountLabelPanel;
	private JPanel buttonPanel;
	private JPanel blankPanel;
	private JPanel gameButtonPane;
	private JPanel showGamePanel;
	private LobbyGameInfoPanel infoPanel;

	private JLabel accountLabel;
	private JLabel nameLabel;
	private JLabel challengeLabel;
	private JLabel gameLabel;

	private Border blackLine;
	private Border buttonBorder;

	private Font titleFont;
	private Font gameInfoFont;
	private Font gameInfoNameFont;
	private Font accountFont;
	private Font buttonFont;

	private JScrollPane scrollGames;
	private JScrollPane scrollPlayers;
	private JScrollPane scrollInvite;
	
	private ArrayList<JComponent> invitePanels;
	private ArrayList<JComponent> gamePanels;

	@SuppressWarnings("unused")
	private JButton playButton;
	@SuppressWarnings("unused")
	private JButton myGameButton;

	public LobbyPanel(LobbyContentPane pane, JButton playButton, JButton myGameButton) {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		titleFont = new Font("TimesRoman", 15, 50);
		gameInfoFont = new Font("TimesRoman", 15, 40);
		accountFont = new Font("TimesRoman", 15, 30);
		buttonFont = new Font("TimesRoman", 15, 30);
		gameInfoNameFont = new Font("TimesRoman", 15, 20);

		this.pane = pane;

		blackLine = BorderFactory.createLineBorder(Color.black, 2, true);
		buttonBorder = BorderFactory.createLineBorder(Color.black, 3, true);

		URL iconUrl = this.getClass().getResource("/images/logoCatan.png");
		ImageIcon imageIcon = new ImageIcon(iconUrl);
		JLabel catanLabel = new JLabel(imageIcon);

		this.playButton = playButton;
		playButton.setFont(buttonFont);
		playButton.setBorder(buttonBorder);
		playButton.setFocusPainted(false);
		playButton.setBackground(Color.ORANGE);
		playButton.setPreferredSize(new Dimension(200, 75));

		this.playButton = myGameButton;
		myGameButton.setFont(buttonFont);
		myGameButton.setBorder(buttonBorder);
		myGameButton.setFocusPainted(false);
		myGameButton.setBackground(Color.ORANGE);
		myGameButton.setPreferredSize(new Dimension(200, 75));

		topPanel = new JPanel();
		rightPanel = new JPanel();
		leftPanel = new JPanel();
		centerPanel = new JPanel();

		accountPanel = new JPanel();
		gamesPanel = new JPanel();
		challengePanel = new JPanel();
		ourNamePanel = new JPanel();
		accountLabelPanel = new JPanel();
		buttonPanel = new JPanel();
		blankPanel = new JPanel();
		gameButtonPane = new JPanel();
		infoPanel = new LobbyGameInfoPanel(gameInfoFont);
		showGamePanel = new JPanel();

		scrollGames = new JScrollPane(showGamePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollGames.getVerticalScrollBar().setUnitIncrement(5);
		scrollGames.setBackground(Color.DARK_GRAY);

		scrollPlayers = new JScrollPane(accountPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPlayers.getVerticalScrollBar().setUnitIncrement(5);
		scrollPlayers.setBackground(Color.DARK_GRAY);

		scrollInvite = new JScrollPane(challengePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollInvite.getVerticalScrollBar().setUnitIncrement(5);
		scrollInvite.setBackground(Color.DARK_GRAY);

		nameLabel = new JLabel("SO-C");
		accountLabel = new JLabel("Accounts");
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setFont(titleFont);

		gameLabel = new JLabel("Spellen");
		gameLabel.setFont(titleFont);
		gameLabel.setForeground(Color.white);

		challengeLabel = new JLabel("Uitdagingen");
		challengeLabel.setFont(titleFont);
		challengeLabel.setForeground(Color.WHITE);

		blankPanel.setBackground(Color.white);
		blankPanel.setPreferredSize(new Dimension(WIDTH - (SIDEPANELWIDTH * 2), 200));

		gameButtonPane.setBackground(Color.white);
		gameButtonPane.add(playButton);
		gameButtonPane.add(myGameButton);

		buttonPanel.setBackground(Color.red);
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(blankPanel, BorderLayout.NORTH);
		buttonPanel.add(gameButtonPane, BorderLayout.CENTER);

		topPanel.setPreferredSize(new Dimension(WIDTH, TOPPANELHEIGHT));
		leftPanel.setPreferredSize(new Dimension(SIDEPANELWIDTH, HEIGHT));
		rightPanel.setPreferredSize(new Dimension(SIDEPANELWIDTH, HEIGHT));
		ourNamePanel.setPreferredSize(new Dimension(WIDTH, NAMEHEIGHT));
		accountLabelPanel.setPreferredSize(new Dimension(SIDEPANELWIDTH, NAMEHEIGHT));

		challengePanel.setBackground(Color.DARK_GRAY);
		gamesPanel.setBackground(Color.DARK_GRAY);
		ourNamePanel.setBackground(Color.WHITE);
		rightPanel.setBackground(Color.DARK_GRAY);
		infoPanel.setBackground(Color.DARK_GRAY);

		challengePanel.setBorder(blackLine);
		gamesPanel.setBorder(blackLine);
		infoPanel.setBorder(blackLine);

		setLayout(new BorderLayout());

		add(rightPanel, BorderLayout.WEST);
		add(leftPanel, BorderLayout.EAST);
		add(centerPanel, BorderLayout.CENTER);

		challengePanel.add(challengeLabel);

		showGamePanel.setLayout(new BoxLayout(showGamePanel, SwingConstants.VERTICAL));
		gamesPanel.setLayout(new BorderLayout());
		gamesPanel.add(gameLabel, BorderLayout.NORTH);
		gamesPanel.add(scrollGames, BorderLayout.CENTER);

		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(scrollInvite, BorderLayout.NORTH);
		leftPanel.add(gamesPanel, BorderLayout.CENTER);

		challengePanel.setPreferredSize(new Dimension(SIDEPANELWIDTH, 400));
		gamesPanel.setPreferredSize(new Dimension(SIDEPANELWIDTH, 500));

		rightPanel.setLayout(new BorderLayout());
		rightPanel.setBorder(blackLine);
		rightPanel.add(accountLabel, BorderLayout.NORTH);
		rightPanel.add(scrollPlayers, BorderLayout.CENTER);

		ourNamePanel.add(nameLabel);
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(topPanel, BorderLayout.NORTH);
		centerPanel.add(buttonPanel, BorderLayout.CENTER);
		centerPanel.add(ourNamePanel, BorderLayout.SOUTH);
		centerPanel.setBackground(Color.WHITE);

		topPanel.setLayout(new BorderLayout());
		topPanel.setBackground(Color.white);
		topPanel.add(catanLabel, BorderLayout.NORTH);

		accountPanel.setLayout(new BoxLayout(accountPanel, 1));
		accountPanel.setBackground(new Color(200, 200, 200, 255));
		
		invitePanels = new ArrayList<JComponent>();
		gamePanels = new ArrayList<JComponent>();

		drawAccountLabels();
		drawInvites();
		drawGames();
	}

	// Display the accounts currently registered (current user is red)
	public void drawAccountLabels() {
		usernames = pane.getUsernames();

		for (int i = 0; i < usernames.size(); i++) {
			if (LoginController.getUsername().equals(usernames.get(i))) {
				JLabel usernameLabel = new JLabel(usernames.get(i));
				usernameLabel.setForeground(Color.red);
				usernameLabel.setFont(accountFont);
				accountPanel.add(usernameLabel);
			} else {
				JLabel usernameLabel = new JLabel(usernames.get(i));
				usernameLabel.setFont(accountFont);
				accountPanel.add(usernameLabel);
			}
		}
	}

	// Display the current games the user is in
	public void drawGames() {
		games = pane.getGames();

		for (int i = 0; i < games.size(); i++) {

			int gameID = games.get(i).getID();
			ArrayList<String> players = games.get(i).getPlayers();
			if (players.size() == 4) {
				JPanel row = new JPanel(new BorderLayout());
				JPanel namePanel = new JPanel();
				JPanel infoPanel = new JPanel();
				JLabel label = new JLabel("GameID:" + games.get(i).getID() + " (" + games.get(i).currentTurn() + ")");
				label.setFont(buttonFont);
				row.setPreferredSize(new Dimension(INVITEWIDTH, NAMEHEIGHT * 4));
				row.setMaximumSize(new Dimension(INVITEWIDTH, NAMEHEIGHT * 4));
				namePanel.add(label);
				namePanel.setBorder(blackLine);
				namePanel.setBackground(Color.orange);
				infoPanel.setLayout(new GridLayout(2, 2));

				for (int n = 0; n < players.size(); n++) {
					JLabel nameLabel = new JLabel((players.get(n)));
					nameLabel.setFont(gameInfoNameFont);
					nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
					nameLabel.setBorder(blackLine);
					infoPanel.add(nameLabel);

				}

				row.add(namePanel, BorderLayout.NORTH);
				row.add(infoPanel, BorderLayout.CENTER);
				row.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						pane.openGame(gameID);

					}
				});
				row.setBorder(blackLine);
				gamePanels.add(row);
				showGamePanel.add(row);
			}
		}
	}

	public void drawInvites() {
		invites = pane.getInvites();

		for (int i = 0; i < invites.size(); i++) {
			int gameID = invites.get(i).getGameID();
			String host = invites.get(i).getHost();
			JPanel row = new JPanel(new BorderLayout());
			row.setPreferredSize(new Dimension(INVITEWIDTH, NAMEHEIGHT));

			// Create the padding for the label
			JButton info = new JButton("(?)");
			info.setPreferredSize(new Dimension(PADDINGWIDTH, NAMEHEIGHT));
			info.setMargin(new Insets(0, 0, 0, 0));
			info.setBackground(new Color(0, 0, 0, 0));
			info.setFocusPainted(false);
			info.setFocusable(false);
			info.setOpaque(false);
			info.setBorder(null);
			info.addMouseListener(new Hover(gameID, host));

			// Create the label holding the hosts name
			JLabel label = new JLabel(invites.get(i).getHost());
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setPreferredSize(new Dimension(INVITELABELWIDTH, NAMEHEIGHT));

			JPanel namePanel = new JPanel(new BorderLayout());
			namePanel.add(info, BorderLayout.LINE_START);
			namePanel.add(label, BorderLayout.CENTER);

			// Create yes no buttons
			JButton acceptButton = new JButton("\u2713");
			acceptButton.setPreferredSize(new Dimension(INVITEBUTTONWIDTH, NAMEHEIGHT));
			acceptButton.addActionListener(e -> {
				pane.inviteResponse(true, gameID);
				updateInvites();
				challengePanel.repaint();
				challengePanel.validate();
			});

			JButton refuseButton = new JButton("X");
			refuseButton.setPreferredSize(new Dimension(INVITEBUTTONWIDTH, NAMEHEIGHT));
			refuseButton.addActionListener(e -> {
				pane.inviteResponse(false, gameID);
				updateInvites();
				drawInvites();
				challengePanel.repaint();
				challengePanel.validate();
			});

			acceptButton.setBackground(new Color(60, 180, 60, 255));
			refuseButton.setBackground(new Color(180, 60, 60, 255));
			refuseButton.setForeground(Color.orange);

			// Add all components
			row.add(namePanel, BorderLayout.LINE_START);
			row.add(acceptButton, BorderLayout.CENTER);
			row.add(refuseButton, BorderLayout.LINE_END);
			challengePanel.add(row);
			invitePanels.add(row);

		}
	}

	// Hover for game info
	public class Hover extends MouseAdapter {

		private int gameID;
		private String host;

		public Hover(int gameID, String host) {
			this.gameID = gameID;
			this.host = host;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			ArrayList<String> players = pane.getUsersInGame(gameID);
			boolean isRandom = pane.isRandomBoard(gameID);
			leftPanel.remove(gamesPanel);
			infoPanel.updateInfo(gameID, isRandom, host, players);
			leftPanel.add(infoPanel);
			leftPanel.repaint();
			leftPanel.validate();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			leftPanel.remove(infoPanel);
			leftPanel.add(gamesPanel);
			leftPanel.repaint();
			leftPanel.validate();
		}
	}
	
	private void updateInvites() {
		for(JComponent c : invitePanels) {
			challengePanel.remove(c);
		}
		invitePanels.clear();
		this.repaint();
		this.validate();
		drawInvites();
	}
	
	private void updateGames() {
		for(JComponent c : gamePanels) {
			showGamePanel.remove(c);
		}
		gamePanels.clear();
		this.validate();
		drawGames();
	}

	@Override
	public void update(Observable o, Object arg) {
		updateInvites();
		//updateGames();
	}
}
