package Model.ingame;

public class PlayerStats {

	private String username;
	private int resourceCards, developmentCards, knightCards;
	
	public PlayerStats(int rc, int dc, int kc) {
		resourceCards = rc;
		developmentCards = dc;
		knightCards = kc;
	}
	
	public int getResourceCards() {
		return resourceCards;
	}
	
	public int getDevelopmentCards() {
		return developmentCards;
	}
	
	public int getKnightCards() {
		return knightCards;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
}
