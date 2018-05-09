package View;

import javax.swing.JFrame;

public class LobbyFrame extends JFrame{
	LobbyContentPane pane = new LobbyContentPane();
	
	public LobbyFrame() {
		setTitle("Lobby");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setContentPane(pane);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
