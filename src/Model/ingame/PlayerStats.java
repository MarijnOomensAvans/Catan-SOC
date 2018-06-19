package Model.ingame;

public class PlayerStats {

	private String username;
	private int resourceCards, developmentCards, knightCards;
	private int villagePoints, cityPoints;
	private int developmentBuildingPoints;
	private boolean hasBiggestArmy;
	private boolean hasTradeRoute;
	private int wool = 0, wood = 0, ore = 0, stone = 0, wheat = 0;

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

	public int getWool() {
		return wool;
	}

	public void setWool(int wool) {
		this.wool = wool;
	}

	public int getWood() {
		return wood;
	}

	public void setWood(int wood) {
		this.wood = wood;
	}

	public int getOre() {
		return ore;
	}

	public void setOre(int ore) {
		this.ore = ore;
	}

	public int getStone() {
		return stone;
	}

	public void setStone(int stone) {
		this.stone = stone;
	}

	public int getWheat() {
		return wheat;
	}

	public void setWheat(int wheat) {
		this.wheat = wheat;
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
		if (hasBiggestArmy) {
			points += 2;
		}

		if (hasTradeRoute) {
			points += 2;
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

	public void setDevelopmentPoints(int developmentPoints) {
		this.developmentBuildingPoints = developmentPoints;
	}

}
