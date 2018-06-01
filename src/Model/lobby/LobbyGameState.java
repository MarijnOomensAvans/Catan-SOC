package Model.lobby;

import java.util.ArrayList;

public class LobbyGameState {

	private int gameid;
	private ArrayList<String> players;
	private ArrayList<String> status;
	
	public LobbyGameState(int gameid, ArrayList<String> players, ArrayList<String> status) {
		this.gameid = gameid;
		this.players = players;
		this.status = status;
	}

	public int getGameid() {
		return gameid;
	}

	public ArrayList<String> getPlayers() {
		return players;
	}

	public ArrayList<String> getStatus() {
		return status;
	}
	
	public String getStatusForPLayerIndex(int id) {
		return status.get(id);
	}
	
}
