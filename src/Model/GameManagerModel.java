package Model;


public class GameManagerModel {
	private int idgame;
	private int playerTurn;
	

	public GameManagerModel(int idgame) {
		this.idgame = idgame;
		
	}

	public int getIdgame() {
		return idgame;
	}

	public void setIdgame(int idgame) {
		this.idgame = idgame;
	}

	public int getPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
	}
	
	
}
