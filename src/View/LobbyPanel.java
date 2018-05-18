package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Controller.LoginController;

@SuppressWarnings("serial")
public class LobbyPanel extends JPanel {

	private LobbyContentPane pane;
	private ArrayList<String> usernames;

	private final int WIDTH = 1400;
	private final int HEIGHT = 900;
	private final int TOPPANELHEIGHT = 200;
	private final int SIDEPANELWIDTH = 300;
	private final int NAMEHEIGHT = 25;

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
		accountPanel.setBackground(Color.WHITE);
		drawAccountLabels();
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
}
