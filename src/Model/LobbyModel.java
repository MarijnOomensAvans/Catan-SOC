package Model;

import java.util.ArrayList;

import javax.swing.JLabel;

import DAL.LobbyDAL;

public class LobbyModel {

	private LobbyDAL lobbyDAL;
	private ArrayList<String> usernames;
	
	public LobbyModel(LobbyDAL lobbyDAl) {
		this.lobbyDAL = lobbyDAl;
	}
	
	public ArrayList<String> getUsername() {
		return usernames = lobbyDAL.getAllAccounts();
	}
}
