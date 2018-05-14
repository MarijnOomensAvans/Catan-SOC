package Model;

public class LobbyGameInfo {
	
	private final int gameid;
	private String playerTurn;
	
	public LobbyGameInfo(int gameid, String playerTurn) {
		this.gameid = gameid;
		this.playerTurn = playerTurn;

	}
	
	public int getID() {
		return gameid;
	}
	
	public String getPlayerTurn() {
		return playerTurn;
	}
	
	public void setPlayerTurn(String playerTurn) {
		this.playerTurn = playerTurn;
	}
	
}
