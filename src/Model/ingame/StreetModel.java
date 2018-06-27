package Model.ingame;

public class StreetModel {
	
	int playerid;
	int x1, x2, y1, y2;
	
	public StreetModel(int playerid, int x1, int x2, int y1, int y2) {
		this.playerid = playerid;
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	public int getKeyX_from() {
		return x1;
	}

	public int getKeyX_to() {
		return x2;
	}

	public int getKeyY_from() {
		return y1;
	}

	public int getKeyY_to() {
		return y2;
	}

	public int getPlayerId() {
		return playerid;
	}

}
