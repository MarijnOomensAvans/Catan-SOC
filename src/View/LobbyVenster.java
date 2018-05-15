package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class LobbyVenster extends JPanel {

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
	
	private JLabel accountLabel;
	private JLabel nameLabel;
	private JLabel challengeLabel;
	private JLabel gameLabel;

	private Border blackLine;

	private Font titleFont;
	private Font accountFont;

	public LobbyVenster(LobbyContentPane pane) {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		titleFont = new Font("TimesRoman", 15, 50);
		accountFont = new Font("TimesRoman", 15, 30);

		this.pane = pane;

		blackLine = BorderFactory.createLineBorder(Color.black, 2, true);

		URL iconUrl = this.getClass().getResource("/resources/logoCatan.png");
		ImageIcon imageIcon = new ImageIcon(iconUrl);
		JLabel catanLabel = new JLabel(imageIcon);

		topPanel = new JPanel();
		rightPanel = new JPanel();
		leftPanel = new JPanel();
		centerPanel = new JPanel();

		accountPanel = new JPanel();
		gamesPanel = new JPanel();
		challengePanel = new JPanel();
		ourNamePanel = new JPanel();
		accountLabelPanel = new JPanel();

		nameLabel = new JLabel("SO-C");
		accountLabel = new JLabel("Accounts");
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setFont(titleFont);
		
		gameLabel= new JLabel("Games");
		gameLabel.setFont(titleFont);
		gameLabel.setForeground(Color.white);
		
		challengeLabel = new JLabel("Challenges");
		challengeLabel.setFont(titleFont);
		challengeLabel.setForeground(Color.WHITE);

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
		centerPanel.add(ourNamePanel, BorderLayout.SOUTH);
		centerPanel.setBackground(Color.WHITE);

		topPanel.setLayout(new BorderLayout());
		topPanel.setBackground(Color.white);
		topPanel.add(catanLabel, BorderLayout.NORTH);
		

		accountPanel.setLayout(new BoxLayout(accountPanel, 1));
		accountPanel.setBackground(Color.WHITE);
		drawLabels();
	}

	public void drawLabels() {
		usernames = pane.getUsernames();

		for (int i = 0; i < usernames.size(); i++) {
			JLabel usernameLabel = new JLabel(usernames.get(i));
			usernameLabel.setFont(accountFont);
			accountPanel.add(usernameLabel);
		}
	}
}
