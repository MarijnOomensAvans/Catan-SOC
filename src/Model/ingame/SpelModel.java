package Model.ingame;

import java.util.ArrayList;
import java.util.Observable;

import Controller.IngameController;
import Controller.LoginController;
import DAL.GameManagerDAL;
import DAL.SpelDAL;

public class SpelModel extends Observable {

	private SpelDAL spelDal;
	private GameManagerDAL gameManagerDal;
	private int gameid;
	private IngameController ingameController;
	private boolean secondRound = false;

	public SpelModel(int gameid, IngameController ingameController) {
		this.ingameController = ingameController;
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
}
