package View.gameState;

import javax.swing.JFrame;

public class GameStatusFrame extends JFrame{

	private GameStatePane pane;
	
	public GameStatusFrame() {
		
		pane = new GameStatePane();
		
		setTitle("Game States");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(pane);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
