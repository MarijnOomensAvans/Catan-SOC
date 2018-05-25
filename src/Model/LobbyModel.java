package Model;

import java.util.ArrayList;

import DAL.LobbyDAL;

public class LobbyModel {

	private LobbyDAL lobbyDAL;
	private ArrayList<String> usernames;

	private int gameid;

	public int getGameid() {
		return gameid;
	}

	public LobbyModel() {
		lobbyDAL = new LobbyDAL();
		System.out.println(lobbyDAL.getFreePlayerid());
	}

	public ArrayList<String> getUsernames() {
		usernames = lobbyDAL.getAllAccounts();
		return usernames;
	}

	public ArrayList<LobbyInvite> getInvites() {
		return lobbyDAL.getAllInvites();
	}

	public ArrayList<LobbyGameInfo> getGames() {
		return lobbyDAL.getAllActiveGames();
	}

	public ArrayList<String> getPlayers(int gameID) {
		return lobbyDAL.getPlayers(gameID);
	}

	public void makeNewGameID() {
		int gameid = lobbyDAL.makeNewGameID();
		this.gameid = gameid;
	}

	public boolean isRandomBoard(int gameID) {
		return lobbyDAL.isRandomBoard(gameID);
	}

	public ArrayList<String> getUsersInGame(int gameID) {
		return lobbyDAL.getUsersInGame(gameID);
	}

	public void inviteResponse(boolean response, int gameID) {
		if (response) {
			lobbyDAL.acceptInvite(gameID);
		} else {
			lobbyDAL.rejectInvite(gameID);
		}
	}

	public void createInvitation(String username, int gameid, int volgnr) {

		String kleur = "", speelstatus = "";

		switch (volgnr) {
		case (1):
			kleur = "rood";
			speelstatus = "uitdager";
			break;
		case (2):
			kleur = "wit";
			speelstatus = "uitgedaagde";
			break;
		case (3):
			kleur = "blauw";
			speelstatus = "uitgedaagde";
			break;
		case (4):
			kleur = "oranje";
			speelstatus = "uitgedaagde";
			break;
		}

		lobbyDAL.createInvitation(username, gameid, volgnr, kleur, speelstatus);
	}
	
	public void updateInvitation(String username, int gameid, int volgnr) {
		
	}

}
