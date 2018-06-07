package Model.ingame;

import java.util.ArrayList;
import java.util.Observable;

import Controller.LoginController;
import DAL.SpelDAL;

public class SpelModel extends Observable {

	private SpelDAL spelDal;
	private int gameid;

	public SpelModel(int gameid) {
		this.gameid = gameid;
		spelDal = new SpelDAL();
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

	public void shouldRefresh() {
		spelDal.shouldRefresh(gameid);
	}

	public boolean hasRolledDice(int gameid) {
		return spelDal.hasRolledDice(gameid);
	}

	public void update() {
		if (spelDal.hasShouldRefresh(gameid, LoginController.getUsername())) {
			System.out.println("REAL REFRESH");
			this.setChanged();
			this.notifyObservers();
			spelDal.removeShouldRefresh(gameid, LoginController.getUsername());
		}
	}

}
