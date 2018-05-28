package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class LobbyGameInfoPanel extends JPanel {

	private int gameID;
	private String boardType;
	private String host;
	private ArrayList<String> players;

	private final int LABELWIDTH = 280;
	private final int LABELHEIGHT = 50;
	private Font infoFont;

	private JLabel title;

	private JPanel infoPanel;
	private JLabel gameLabel;
	private JLabel hostLabel;
	private JLabel playersTitle;
	private JLabel[] playerLabels;

	public LobbyGameInfoPanel(Font titleFont) {
		super();
		this.setLayout(new BorderLayout());

		title = new JLabel("Game info");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(titleFont);
		title.setForeground(Color.white);

		infoFont = new Font("Times New Roman", Font.BOLD, 20);

		gameLabel = new JLabel();
		hostLabel = new JLabel();

		playersTitle = new JLabel("PLAYERS");
		playersTitle.setPreferredSize(new Dimension(LABELWIDTH, LABELHEIGHT - 10));
		playersTitle.setFont(infoFont);

		playerLabels = new JLabel[] { new JLabel(), new JLabel() };
		playerLabels[0].setPreferredSize(new Dimension(LABELWIDTH, LABELHEIGHT - 15));
		playerLabels[1].setPreferredSize(new Dimension(LABELWIDTH, LABELHEIGHT - 15));
		playerLabels[0].setFont(infoFont);
		playerLabels[1].setFont(infoFont);

		gameLabel.setFont(infoFont);
		hostLabel.setFont(infoFont);
		gameLabel.setPreferredSize(new Dimension(LABELWIDTH, LABELHEIGHT));
		gameLabel.setForeground(Color.DARK_GRAY);
		hostLabel.setForeground(Color.DARK_GRAY);
		hostLabel.setPreferredSize(new Dimension(LABELWIDTH, LABELHEIGHT));

		infoPanel = new JPanel();
		infoPanel.setBackground(Color.LIGHT_GRAY);
		infoPanel.setLayout(new FlowLayout());
		infoPanel.add(gameLabel);
		infoPanel.add(hostLabel);

		infoPanel.add(playersTitle);
		infoPanel.add(playerLabels[0]);
		infoPanel.add(playerLabels[1]);

		this.add(title, BorderLayout.NORTH);
		this.add(infoPanel, BorderLayout.CENTER);
	}

	public void updateInfo(int gameID, boolean isRandom, String host, ArrayList<String> players) {
		this.gameID = gameID;
		this.host = host;
		this.players = players;

		if (isRandom) {
			boardType = "random";
		} else {
			boardType = "standaard";
		}
		gameLabel.setText("GameID: " + gameID + " (" + boardType + ")");
		hostLabel.setText("Host: " + host);
		playerLabels[0].setText("");
		playerLabels[1].setText("");

		for (int i = 0; i < players.size(); i++) {
			playerLabels[i].setText(players.get(i));
		}

	}

}
