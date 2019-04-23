package View.lobby;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.BoardController;
import Controller.ChatController;
import Controller.LobbyController;
import Model.lobby.LobbyGameInfo;
import Model.lobby.LobbyInvite;
import View.chat.Chatoutputgui;
import View.setupGame.InvitePanel;

@SuppressWarnings("serial")
public class LobbyContentPane extends JPanel {
// creating intance variables
	@SuppressWarnings("unused")
	private BoardController bc;
	private LobbyPanel lobby;
	private LobbyController lc;
	private InvitePanel invitePanel;
	private JButton playButton;
	private JButton myGameButton;
// initialize 
	public LobbyContentPane(LobbyController controller, BoardController bc, ChatController cc,int playerid, Chatoutputgui cog) {
		this.bc = bc;
		playButton = new JButton("Nieuw spel");
		myGameButton = new JButton("Mijn spellen");
		this.lc = controller;
		this.lobby = new LobbyPanel(this, playButton, myGameButton);
// open the gamesetup pane
		playButton.addActionListener(e -> {
			lc.openGameSetup();
		});
		
		myGameButton.addActionListener(e ->{
			lc.openGameStateController();
		});
		
		add(lobby);
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
	public LobbyPanel getPanel() {
		return lobby;
	}

}
