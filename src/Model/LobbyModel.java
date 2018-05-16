package Model;

import java.util.ArrayList;

import javax.swing.JLabel;

import DAL.LobbyDAL;

public class LobbyModel {

	private LobbyDAL lobbyDAL;
	private ArrayList<String> usernames;
	
	public LobbyModel(LobbyDAL lobbyDAL) {
		this.lobbyDAL = lobbyDAL;
	}
	
	public ArrayList<String> getUsernames() {
		usernames = lobbyDAL.getAllAccounts();
		
		return usernames;
	}
}
