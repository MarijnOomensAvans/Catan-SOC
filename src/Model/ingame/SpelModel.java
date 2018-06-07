package Model.ingame;

import java.util.ArrayList;
import java.util.Observable;

import Controller.LoginController;
import DAL.GameManagerDAL;
import DAL.SpelDAL;

public class SpelModel extends Observable {

	private SpelDAL spelDal;
	private GameManagerDAL gameManagerDal;
	private int gameid;

	public SpelModel(int gameid) {
		this.gameid = gameid;
		spelDal = new SpelDAL();
		gameManagerDal = new GameManagerDAL();
	}

	public ArrayList<PlayerStats> getPlayerStats(int id) {
		return spelDal.getPlayerStats(id);

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
	
	public String getLongestRoute(int gameid) {
		return spelDal.getLongestRouteUsername(gameid);
	}
	
	public String getBiggestArmy(int gameid) {
		return spelDal.getBiggestArmyUsername(gameid);
	}

	public boolean getFirstTurn() {
		return gameManagerDal.getFirstTurn(gameid);
	}

	public int getFirstTurnRound() {
		// Check welke ronde
		// gameManagerDal.getFirstTurnRound(int gameid);
		return 0;
	}

	public boolean firstTurnConditions() {
		int round = getFirstTurnRound();
		if (round == 1) {
			// Check of 1e ronde condities voldaan zijn
			return true;
		}
		if (round == 2) {
			// Check of 2e ronde condities voldaan zijn
			return true;
		}

		return false;
	}

}
