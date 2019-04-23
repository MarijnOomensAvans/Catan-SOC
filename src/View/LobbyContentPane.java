package View;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import Model.LobbyInvite;

@SuppressWarnings("serial")
public class LobbyContentPane extends JPanel {

	private LobbyPanel lobby;
	private SetupGamePane setupGame;
	private LobbyFrame frame;
	private JButton playButton;

	public LobbyContentPane(LobbyFrame frame) {
		playButton = new JButton("Start");
		this.frame = frame;
		this.lobby = new LobbyPanel(this, playButton);
		this.setupGame = new SetupGamePane();
		playButton.addActionListener(e -> {
			
			switchLobbyScreen();
		});
		add(lobby);
	}

	public ArrayList<String> getUsernames() {
		return frame.getUsernames();
	}

	public void switchLobbyScreen() {
		removeAll();
		repaint();
		add(setupGame);
		frame.pack();
	}
	
	public ArrayList<LobbyInvite> getInvites(){
		return frame.getInvites();
	}
	
	public void closeLobbyScreen() {
		playButton.addActionListener(e -> {
			frame.closeLobby();
		});
	}
	public void mouseEnterGameInfo(int gameID) {
		frame.mouseEnterGameInfo(gameID);
	}
	
	public void mouseExitGameInfo(int gameID) {
		frame.mouseExitGameInfo(gameID);
	}
}
