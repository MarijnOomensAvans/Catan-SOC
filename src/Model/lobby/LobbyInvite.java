package Model.lobby;

public class LobbyInvite {

	private int gameID;
	private String host;
	
	public LobbyInvite(int gameID, String host) {
		this.gameID = gameID;
		this.host = host;
	}
	
	public int getGameID() {
		return gameID;
	}
	
	public String getHost() {
		return host;
	}
	
}
