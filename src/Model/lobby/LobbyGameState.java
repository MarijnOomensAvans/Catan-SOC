package Model.lobby;

import java.util.ArrayList;

public class LobbyGameState {

	int gameid;
	ArrayList<String> players;
	ArrayList<String> status;
	
	public LobbyGameState(int gameid, ArrayList<String> players, ArrayList<String> status) {
		this.gameid = gameid;
		this.players = players;
		this.status = status;
	}
	
}
