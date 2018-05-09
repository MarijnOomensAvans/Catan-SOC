package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LobbyVenster extends JPanel{
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
	
	
	public LobbyVenster() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
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
		
		topPanel.setBackground(Color.blue);
		rightPanel.setBackground(Color.red);
		leftPanel.setBackground(Color.yellow);
		ourNamePanel.setBackground(Color.WHITE);
		
		setLayout(new BorderLayout());
		
		add(rightPanel, BorderLayout.WEST);
		add(leftPanel, BorderLayout.EAST);
		add(centerPanel, BorderLayout.CENTER);
		add(topPanel, BorderLayout.NORTH);
		
		ourNamePanel.add(nameLabel);
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(ourNamePanel, BorderLayout.SOUTH);
	}
}
