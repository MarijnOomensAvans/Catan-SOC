package View.gameState;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GameStatePane extends JPanel{

	private final int WIDTH = 500;
	private final int HEIGHT = 1000;
	private final int PANELWIDTH = 480;
	private final int PANELHEIGHT = 995;
	private final int GAMEHEIGHT = 100;
	
	private JPanel games;
	
	
	private JScrollPane scroll;
	
	public GameStatePane() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		games = new JPanel();
		games.setPreferredSize(new Dimension(WIDTH-20, HEIGHT-5));
		games.setBackground(Color.DARK_GRAY);
		scroll = new JScrollPane(games, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		getGames();
		add(scroll);
	}
	
	public void getGames() {
		for(int i = 0; i < 5; i++) {			
			JPanel game = new JPanel();
			game.setPreferredSize(new Dimension(PANELWIDTH, GAMEHEIGHT));
			
			JPanel names = new JPanel();
			names.setLayout(new GridLayout(2, 2));
			
			game.add(names);
			games.add(game);
		}
	}
}
