package View.gameState;

import javax.swing.JFrame;

import Controller.LobbyController;

@SuppressWarnings("serial")
public class GameStatusFrame extends JFrame{

	private GameStatePane pane;
	
	public GameStatusFrame(LobbyController lc) {
		
		pane = new GameStatePane(lc);
		
		setTitle("Game States");
		setContentPane(pane);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
