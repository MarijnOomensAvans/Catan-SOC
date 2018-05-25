package View;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.BoardController;
import Model.LobbyGameInfo;
import Model.LobbyInvite;

@SuppressWarnings("serial")
public class LobbyContentPane extends JPanel {

	
	private LobbyPanel lobby;
	private SetupGamePane setupGame;
	private LobbyFrame frame;
	private JButton playButton;
	private BoardController cboard = new BoardController();

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
		cboard.generateBoard();
		cboard.setBoardType(frame.getGameID(), 1);
		cboard.finishBoard(frame.getGameID());
		removeAll();
		repaint();
		add(setupGame);
		frame.pack();
	}
	
	public int getGameID() {
		return frame.getGameID();
	}
	

	public ArrayList<String> getPlayers(int gameID){
		return frame.getPlayers(gameID);
	}
	
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
