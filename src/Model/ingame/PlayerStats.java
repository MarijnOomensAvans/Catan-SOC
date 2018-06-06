package Model.ingame;

public class PlayerStats {

	private String username;
	private int resourceCards, developmentCards, knightCards;
	private int villagePoints, cityPoints;
	private int developmentBuildingPoints;
	private boolean hasBiggestArmy;
	private boolean hasTradeRoute;
	
	public PlayerStats(int rc, int dc, int kc, int vp, int cp, int dp) {
		hasBiggestArmy = false;
		hasTradeRoute = false;
		resourceCards = rc;
		developmentCards = dc;
		knightCards = kc;
		villagePoints = vp;
		cityPoints = cp;
		developmentBuildingPoints = dp;
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
	
	public int getPublicPoints() {
		int points = villagePoints + (cityPoints * 2);
		if(hasBiggestArmy) {
			points++;
		} 
		
		if(hasTradeRoute) {
			points++;
		}
		return points;
	}
	
	public int getPrivatePoints() {
		int points = getPublicPoints();
		points += getDevelopmentBuildingPoints();
		return points;
	}

	public void setBiggestArmy(boolean value) {
		this.hasBiggestArmy = value;
	}

	public void setTradeRoute(boolean value) {
		this.hasTradeRoute = value;
	}
	
	public int getDevelopmentBuildingPoints() {
		return developmentBuildingPoints;
	}
	
}
