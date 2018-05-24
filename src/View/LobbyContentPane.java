package View;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

<<<<<<< HEAD
import Controller.LobbyController;
=======
import Model.LobbyGameInfo;
>>>>>>> Lobby
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
		frame.makeNewGameID();
		removeAll();
		repaint();
		add(setupGame);
		frame.pack();
	}
	
<<<<<<< HEAD
	public int getGameID() {
		return frame.getGameID();
	}
	

=======
	public ArrayList<String> getPlayers(int gameID){
		return frame.getPlayers(gameID);
	}
	
>>>>>>> Lobby
	public ArrayList<LobbyInvite> getInvites(){
		return frame.getInvites();
	}
	
	public void closeLobbyScreen() {
		playButton.addActionListener(e -> {
			frame.closeLobby();
		});
	}

	public boolean isRandomBoard(int gameID) {
		return frame.isRandomBoard(gameID);
	}

	public ArrayList<String> getUsersInGame(int gameID) {
		return frame.getUsersInGame(gameID);
	}
	
	public void inviteResponse(boolean response, int gameID) {
		frame.inviteResponse(response, gameID);
	}
	
	public ArrayList<LobbyGameInfo> getGames() {
		return frame.getGames();
	}

}
