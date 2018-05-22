package View;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import Model.LobbyInvite;

@SuppressWarnings("serial")
public class LobbyContentPane extends JPanel{
	
	private LobbyPanel lobby;
	private LobbyFrame frame;
	private JButton playButton;

	public LobbyContentPane(LobbyFrame frame) {
		playButton = new JButton("Start");
		closeLobbyScreen();
		this.frame = frame;
		this.lobby = new LobbyPanel(this, playButton);
		add(lobby);
	}
	public ArrayList<String> getUsernames(){
		return frame.getUsernames();	
	}
	
	public ArrayList<LobbyInvite> getInvites(){
		return frame.getInvites();
	}
	
	public void closeLobbyScreen() {
		playButton.addActionListener(e -> {
			frame.closeLobby();
		});
	}
	
	public void inviteResponse(int gameID, boolean response) {
		frame.inviteResponse(gameID, response);
	}
	
	public void mouseEnterGameInfo(int gameID) {
		frame.mouseEnterGameInfo(gameID);
	}
	
	public void mouseExitGameInfo(int gameID) {
		frame.mouseExitGameInfo(gameID);
	}
}
