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
<<<<<<< HEAD

	public void switchLobbyScreen() {
		removeAll();
		repaint();
		add(setupGame);
		frame.pack();
=======
	
	public ArrayList<LobbyInvite> getInvites(){
		return frame.getInvites();
	}
	
	public void closeLobbyScreen() {
		playButton.addActionListener(e -> {
			frame.closeLobby();
		});
>>>>>>> 10dff355637d3d29ba57506960047f8114ce7edc
	}
	
	public void inviteResponse(int gameID, boolean response) {
		frame.inviteResponse(gameID, response);
	}
}
