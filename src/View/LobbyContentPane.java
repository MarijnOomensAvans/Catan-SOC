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
// creating intance variables
	private BoardController bc;
	private LobbyPanel lobby;
	private LobbyController lc;
	private InvitePanel invitePanel;
	private JButton playButton;
// initialize 
	public LobbyContentPane(LobbyController controller, BoardController bc, ChatController cc,int playerid, Chatoutputgui cog) {
		this.bc = bc;
		playButton = new JButton("Start");
		this.lc = controller;
		this.lobby = new LobbyPanel(this, playButton);
// open the gamesetup pane
		playButton.addActionListener(e -> {
			lc.openGameSetup();
		});
		
		add(lobby);
		add(new ChatContentPane(cc,cog,playerid));
	}
// pass array usernames through  
	public ArrayList<String> getUsernames() {
		return lc.getUsernames();
	}
// open invite screen
	public void switchInviteScreen() {
		removeAll();
		add(invitePanel);
		revalidate();
		repaint();
	}
// pass gameID through
	public int getGameID() {
		return lc.getGameID();
	}
// pass arraylist players 
	public ArrayList<String> getPlayers(int gameID) {
		return lc.getPlayers(gameID);
	}
// pass arraylist with invites
	public ArrayList<LobbyInvite> getInvites() {
		return lc.getInvites();
	}
// close the lobby screen
	public void closeLobbyScreen() {
		playButton.addActionListener(e -> {
			lc.closeLobbyScreen();
		});
	}
// pass random forward through
	public boolean isRandomBoard(int gameID) {
		return lc.isRandomBoard(gameID);
	}
// pass arraylist users in a game
	public ArrayList<String> getUsersInGame(int gameID) {
		return lc.getUsersInGame(gameID);
	}
// pass invite response
	public void inviteResponse(boolean response, int gameID) {
		lc.inviteResponse(response, gameID);
	}
// pass arraylist with games
	public ArrayList<LobbyGameInfo> getGames() {
		return lc.getGames();
	}
// pass openGame through
	public void openGame(int gameID) {
		lc.openGame(gameID);
	}

}
