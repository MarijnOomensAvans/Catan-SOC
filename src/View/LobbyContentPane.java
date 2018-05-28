package View;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.BoardController;
import Controller.ChatController;
import Controller.LobbyController;
import Model.LobbyGameInfo;
import Model.LobbyInvite;

@SuppressWarnings("serial")
public class LobbyContentPane extends JPanel {

	private BoardController bc;
	private LobbyPanel lobby;
	private LobbyController lc;
	private InvitePanel invitePanel;
	private JButton playButton;

	public LobbyContentPane(LobbyController controller, BoardController bc, ChatController cc,int playerid, Chatoutputgui cog) {
		this.bc = bc;
		playButton = new JButton("Start");
		this.lc = controller;
		this.lobby = new LobbyPanel(this, playButton);

		playButton.addActionListener(e -> {
			lc.openGameSetup();
		});
		
		add(lobby);
		add(new ChatContentPane(cc,cog,playerid));
	}

	public ArrayList<String> getUsernames() {
		return lc.getUsernames();
	}

	public void switchInviteScreen() {
		removeAll();
		add(invitePanel);
		revalidate();
		repaint();
	}

	public int getGameID() {
		return lc.getGameID();
	}

	public ArrayList<String> getPlayers(int gameID) {
		return lc.getPlayers(gameID);
	}

	public ArrayList<LobbyInvite> getInvites() {
		return lc.getInvites();
	}

	public void closeLobbyScreen() {
		playButton.addActionListener(e -> {
			lc.closeLobbyScreen();
		});
	}

	public boolean isRandomBoard(int gameID) {
		return lc.isRandomBoard(gameID);
	}

	public ArrayList<String> getUsersInGame(int gameID) {
		return lc.getUsersInGame(gameID);
	}

	public void inviteResponse(boolean response, int gameID) {
		lc.inviteResponse(response, gameID);
	}

	public ArrayList<LobbyGameInfo> getGames() {
		return lc.getGames();
	}

	public void openGame(int gameID) {
		lc.openGame(gameID);
	}

}
