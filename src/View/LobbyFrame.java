package View;

import javax.swing.JFrame;

import DAL.LobbyDAL;

public class LobbyFrame extends JFrame{
	private LobbyContentPane pane;
	private LobbyDAL lobbyDAL;
	
	public LobbyFrame() {
		pane = new LobbyContentPane();
		lobbyDAL = new LobbyDAL();
		setTitle("Lobby");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setContentPane(pane);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
