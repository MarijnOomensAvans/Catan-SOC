package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Controller.LoginController;
import Model.LobbyInvite;

@SuppressWarnings("serial")
public class LobbyPanel extends JPanel {

	private LobbyContentPane pane;
	private ArrayList<String> usernames;
	private ArrayList<LobbyInvite> invites;

	private final int WIDTH = 1400;
	private final int HEIGHT = 900;
	private final int TOPPANELHEIGHT = 200;
	private final int SIDEPANELWIDTH = 300;
	private final int NAMEHEIGHT = 40;
	private final int INVITEWIDTH = 290;
	private final int INVITELABELWIDTH = 150;
	private final int PADDINGWIDTH = 40;
	private final int INVITEBUTTONWIDTH = 50;

	private JPanel topPanel;
	private JPanel rightPanel;
	private JPanel leftPanel;
	private JPanel centerPanel;
	private JPanel overlayPanel;

	private JPanel accountPanel;
	private JPanel gamesPanel;
	private JPanel challengePanel;
	private JPanel ourNamePanel;
	private JPanel accountLabelPanel;
	private JPanel buttonPanel;
	private JPanel blankPanel;
	private JPanel gameButtonPane;

	private JLabel accountLabel;
	private JLabel nameLabel;
	private JLabel challengeLabel;
	private JLabel gameLabel;


	private Border blackLine;
	private Border buttonBorder;

	private Font titleFont;
	private Font accountFont;
	private Font buttonFont;
	
	@SuppressWarnings("unused")
	private JButton playButton;

	public LobbyPanel(LobbyContentPane pane, JButton playButton) {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		titleFont = new Font("TimesRoman", 15, 50);
		accountFont = new Font("TimesRoman", 15, 30);
		buttonFont = new Font("TimesRoman", 15, 30);

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
		playButton.setPreferredSize(new Dimension(150, 75));
		
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
		blankPanel.setPreferredSize(new Dimension(WIDTH-(SIDEPANELWIDTH*2), 200));
		
		gameButtonPane.setBackground(Color.white);
		gameButtonPane.add(playButton);
		
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

		challengePanel.setBorder(blackLine);
		gamesPanel.setBorder(blackLine);

		setLayout(new BorderLayout());

		add(rightPanel, BorderLayout.WEST);
		add(leftPanel, BorderLayout.EAST);
		add(centerPanel, BorderLayout.CENTER);

		challengePanel.add(challengeLabel);

		gamesPanel.add(gameLabel);

		leftPanel.setLayout(new GridLayout(2, 1));
		leftPanel.add(challengePanel);
		leftPanel.add(gamesPanel);

		rightPanel.setLayout(new BorderLayout());
		rightPanel.setBorder(blackLine);
		rightPanel.add(accountLabel, BorderLayout.NORTH);
		rightPanel.add(accountPanel, BorderLayout.CENTER);

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
		
		drawAccountLabels();
		drawInvites();
		System.out.println(pane.getGameID());
	}

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
	
	public void drawInvites() {
		invites = pane.getInvites();
		
		for(int i = 0; i < invites.size(); i++) {
			int gameID = invites.get(i).getGameID();
			String host = invites.get(i).getHost();
			JPanel row = new JPanel(new BorderLayout());
			row.setPreferredSize(new Dimension(INVITEWIDTH, NAMEHEIGHT));
			
			//Create the padding for the label
			JButton info = new JButton("(?)");
			info.setPreferredSize(new Dimension(PADDINGWIDTH, NAMEHEIGHT));
			info.setMargin(new Insets(0, 0, 0, 0));
			info.setBackground(new Color(0, 0, 0, 0));
			info.setFocusPainted(false);
			info.setFocusable(false);
			info.setOpaque(false);
			info.setBorder(null);
			info.addMouseListener(new Hover(gameID, host));
			
			//Create the label holding the hosts name
			JLabel label = new JLabel(invites.get(i).getHost());
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setPreferredSize(new Dimension(INVITELABELWIDTH, NAMEHEIGHT));
			
			JPanel namePanel = new JPanel(new BorderLayout());
			namePanel.add(info, BorderLayout.LINE_START);
			namePanel.add(label, BorderLayout.CENTER);
			
			//Create yes no buttons
			JButton acceptButton = new JButton("\u2713");
			acceptButton.setPreferredSize(new Dimension(INVITEBUTTONWIDTH, NAMEHEIGHT));
			acceptButton.addActionListener(e -> {
				
			});
			
			JButton refuseButton = new JButton("X");
			refuseButton.setPreferredSize(new Dimension(INVITEBUTTONWIDTH, NAMEHEIGHT));
			refuseButton.addActionListener(e -> {
				
			});
			
			acceptButton.setBackground(new Color(60, 180, 60, 255));
			refuseButton.setBackground(new Color(180, 60, 60, 255));
			refuseButton.setForeground(Color.orange);
			
			//Add all components
			row.add(namePanel, BorderLayout.LINE_START);
			row.add(acceptButton, BorderLayout.CENTER);
			row.add(refuseButton, BorderLayout.LINE_END);
			challengePanel.add(row);
			
		}
	}
	
	public class Hover extends MouseAdapter{
		
		private int gameID;
		
		public Hover(int gameID, String host) {
			this.gameID = gameID;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			pane.mouseEnterGameInfo(gameID);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			pane.mouseExitGameInfo(gameID);
		}
	}
}
