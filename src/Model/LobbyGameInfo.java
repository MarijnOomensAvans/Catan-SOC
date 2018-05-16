package Model;

import java.util.ArrayList;

public class LobbyGameInfo {
	
	private final int gameid;
	private ArrayList<String> players;
	
	public LobbyGameInfo(int gameid, ArrayList<String> players) {
		this.gameid = gameid;
		this.players = players;
	}

	public int getID() {
		return gameid;
	}
	
	public ArrayList<String> getPlayers() {
		return players;
	}
	
}
