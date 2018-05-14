package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	private JLabel nameLabel;

	public LobbyVenster(LobbyContentPane pane) {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		this.pane = pane;

		URL iconUrl = this.getClass().getResource("/Images/logoCatan.png");
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

		nameLabel = new JLabel("SO-C");

		topPanel.setPreferredSize(new Dimension(WIDTH, TOPPANELHEIGHT));
		leftPanel.setPreferredSize(new Dimension(SIDEPANELWIDTH, HEIGHT));
		rightPanel.setPreferredSize(new Dimension(SIDEPANELWIDTH, HEIGHT));
		ourNamePanel.setPreferredSize(new Dimension(WIDTH, NAMEHEIGHT));

		accountPanel.setBackground(Color.red);
		challengePanel.setBackground(Color.yellow);
		gamesPanel.setBackground(Color.pink);
		ourNamePanel.setBackground(Color.WHITE);

		setLayout(new BorderLayout());

		add(rightPanel, BorderLayout.EAST);
		add(leftPanel, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);

		leftPanel.setLayout(new GridLayout(2, 1));
		leftPanel.add(challengePanel);
		leftPanel.add(gamesPanel);

		rightPanel.setLayout(new GridLayout(1, 1));
		rightPanel.add(accountPanel);

		ourNamePanel.add(nameLabel);
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(topPanel, BorderLayout.NORTH);
		centerPanel.add(ourNamePanel, BorderLayout.SOUTH);

		topPanel.setLayout(new BorderLayout());
		topPanel.add(catanLabel, BorderLayout.NORTH);

		getUsernamesLabel();
	}

	public void getUsernamesLabel() {
		usernames = pane.getUsernames();
		
		for (int i = 0; i < usernames.size(); i++) {
			JLabel usernameLabel = new JLabel(usernames.get(i));
			accountPanel.add(usernameLabel);
		}
	}
}
