package Model.ingame;

import java.util.ArrayList;
import java.util.Observable;

import Controller.IngameController;
import Controller.LoginController;
import DAL.GameManagerDAL;
import DAL.GameDAL;

public class GameModel extends Observable {

	private GameDAL spelDal;
	private GameManagerDAL gameManagerDal;
	private int gameid;
	private IngameController ingameController;
	private boolean secondRound = false;
	private String longestRoutePlayer;
	private ArrayList<StreetModel> visited;
	private ArrayList<PlayerStats> playerStats;

	public GameModel(int gameid, IngameController ingameController) {
		this.ingameController = ingameController;
		this.gameid = gameid;
		spelDal = new GameDAL();
		gameManagerDal = new GameManagerDAL();
		longestRoutePlayer = spelDal.getLongestRouteUsername(gameid);
	}

	public ArrayList<PlayerStats> getPlayerStats(int id) {
		this.playerStats = spelDal.getPlayerStats(id);
		return playerStats;

	}

	public String getTurn(int id) {
		return spelDal.getPlayerTurn(id);
	}

	public void setBiggestArmy(int gameid, String username) {
		spelDal.setBiggestArmy(gameid, username);
	}

	public void setPlayerTurn(int gameid, String username) {
		spelDal.setPlayerTurn(gameid, username);
	}

	public void shouldRefresh(int gameid) {
		spelDal.shouldRefresh(gameid);
	}

	public boolean hasRolledDice(int gameid) {
		return spelDal.hasRolledDice(gameid);
	}

	public void update() {

		if (spelDal.hasShouldRefresh(gameid, LoginController.getUsername())) {
			this.setChanged();
			this.notifyObservers();
			spelDal.removeShouldRefresh(gameid, LoginController.getUsername());
		}
	}

	public void updateLongestRoute() {
		String longestRoutePlayer = spelDal.getLongestRouteUsername(gameid);
		String newLongestRoutePlayer = longestRoutePlayer;
		int previousLength = 0;
		for(int i = 0; i < playerStats.size(); i++) {
			int thisLength = getTradeRouteLength(i);
			if(thisLength > previousLength) {
				previousLength = thisLength;
				newLongestRoutePlayer = playerStats.get(i).getUsername();
			}
		}
		
		if(!newLongestRoutePlayer.equals(longestRoutePlayer)) {
			spelDal.setLongestRoute(gameid, newLongestRoutePlayer);
		}
	}

	public String getLongestRoute(int gameid) {
		return spelDal.getLongestRouteUsername(gameid);
	}

	public String getBiggestArmy(int gameid) {
		return spelDal.getBiggestArmyUsername(gameid);
	}

	public boolean getFirstTurn() {
		return gameManagerDal.getFirstTurn(gameid);
	}

	public int getBuildingCount() {
		return spelDal.hasBuilt(gameid);
	}

	public int getBuildingCount(int volgnr) {
		return spelDal.getBuildingCount(gameid, volgnr);
	}

	public void firstTurnCheck() {

		if (getFirstTurn() && getTurn(gameid).equals(LoginController.getUsername())) {
			int builtCount = spelDal.hasBuilt(gameid);
			switch (builtCount) {
			case (0):
				System.out.println("1e dorp bouwen");
				ingameController.buildVillage();
				break;
			case (1):
				System.out.println("1e straat bouwen");
				ingameController.buildStreet();
				break;
			case (2):
				if (isSecondRound()) {
					System.out.println("2e dorp bouwen");
					ingameController.buildVillage();
					break;
				}
			case (3):
				if (isSecondRound()) {
					System.out.println("2e straat bouwen");
					ingameController.buildStreet();
					break;
				}
			}
		}
	}

	public boolean isSecondRound() {
		return secondRound;
	}

	public void setSecondRound(boolean secondRound) {
		this.secondRound = secondRound;
	}

	public void setAllPlayersCanceld(int gameid) {
		spelDal.setPlayersCanceld(gameid);
	}

	public void setFirstTurn(boolean b) {
		spelDal.setFirstTurn(gameid, b);
	}

	public String getPlayer(int gameid) {
		return spelDal.getPlayerTurn(gameid);
	}

	public int getTradeRouteLength(int playerIndex)
	{
		visited = new ArrayList<StreetModel>();
		int count = 0;
		for (StreetModel street : playerStats.get(playerIndex).getStreets())
		{
			visited.add(street);
			int count_from = getTradeRouteLength(street.getKeyX_from(), street.getKeyY_from(), playerIndex);
			int count_to = getTradeRouteLength(street.getKeyX_to(), street.getKeyY_to(), playerIndex);
			count = Math.max(count, 1 + count_from + count_to);
		}
		visited.clear();
		return count;
	}

	public int getTradeRouteLength(int x, int y, int playerIndex)
	{
		ArrayList<StreetModel> queue = new ArrayList<StreetModel>();
		for (StreetModel street : playerStats.get(playerIndex).getStreets())
		{
			if (!visited.contains(street) && isConnected(x, y, street))
			{
				visited.add(street);
				queue.add(street);
			}
		}
		int count = 0;
		for (int i = 0; i < queue.size(); i++)
		{
			StreetModel street = queue.get(i);
			int count_from = getTradeRouteLength(street.getKeyX_from(), street.getKeyY_from(), playerIndex);
			int count_to = getTradeRouteLength(street.getKeyX_to(), street.getKeyY_to(), playerIndex);
			count = Math.max(count, 1 + count_from + count_to);
		}
		return count;
	}

	private boolean isConnected(int x, int y, StreetModel stuk)
	{
		boolean connected = false;
		connected |= x == stuk.getKeyX_from() && y == stuk.getKeyY_from();
		connected |= x == stuk.getKeyX_to() && y == stuk.getKeyY_to();

		return connected;

	}
}
