package Model;

public class GameInfo {
	
	private final int gameid;
	private String playerTurn;
	
	public GameInfo(int gameid, String playerTurn) {
		this.gameid = gameid;
		this.playerTurn = playerTurn;
		//Update mofo
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
