package Model;

import java.util.ArrayList;

import DAL.LobbyDAL;

public class LobbyModel {

	private LobbyDAL lobbyDAL;
	private ArrayList<String> usernames;
	
	public LobbyModel() {
		lobbyDAL = new LobbyDAL();
	}
	
	public ArrayList<String> getUsernames() {
		usernames = lobbyDAL.getAllAccounts();
		return usernames;
	}
	
	public ArrayList<LobbyInvite> getInvites(){
		return lobbyDAL.getAllInvites();
	}
}
