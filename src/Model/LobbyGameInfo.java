package Model;

import java.util.ArrayList;

public class LobbyGameInfo {
	
	private final int gameid;
	private String currentTurn;
	private ArrayList<String> players;
	
	public LobbyGameInfo(int gameid, ArrayList<String> players, String currentTurn) {
		this.gameid = gameid;
		this.players = players;
		this.currentTurn = currentTurn;
	}

	public int getID() {
		return gameid;
	}
	
	public ArrayList<String> getPlayers() {
		return players;
	}
	
	public String currentTurn() {
		return currentTurn;
	}
	
}
