package View.gameState;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controller.LobbyController;

public class GameStatePane extends JPanel{

	private final int WIDTH = 500;
	private final int HEIGHT = 1000;
	private final int PANELWIDTH = 480;
	private final int PANELHEIGHT = 995;
	private final int GAMEHEIGHT = 100;
	
	private JPanel games;
	private LobbyController lc;
	
	
	private JScrollPane scroll;
	
	public GameStatePane(LobbyController lc) {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.lc = lc;
		games = new JPanel();
		games.setPreferredSize(new Dimension(WIDTH-20, HEIGHT-5));
		games.setBackground(Color.DARK_GRAY);
		scroll = new JScrollPane(games, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		getGames();
		add(scroll);
	}
	
	public void getGames() {
		for(int i = 0; i < 5; i++) {			
			
			JButton reInviteButton = new JButton("Invite");
			reInviteButton.setEnabled(true);
			
			JPanel game = new JPanel();
			game.setLayout(new BorderLayout());
			game.setPreferredSize(new Dimension(PANELWIDTH, GAMEHEIGHT));
			
			reInviteButton.addActionListener(e -> {
				new ReInviteFrame(lc);
			});
			 
			JPanel buttonPanel = new JPanel();
			buttonPanel.setPreferredSize(new Dimension(100, HEIGHT));
			buttonPanel.setBackground(Color.yellow);
			
			JPanel names = new JPanel();
			names.setLayout(new GridLayout(2, 2));
			names.setBackground(Color.red);
			
			buttonPanel.add(reInviteButton);
			
			game.add(names, BorderLayout.LINE_START);
			game.add(buttonPanel, BorderLayout.LINE_END);
			
			games.add(game);
		}
	}
	
	public void checkDeclines() {
		int decline = 0;
		
	}
}
