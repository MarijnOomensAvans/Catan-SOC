package Model;

import java.util.ArrayList;

import DAL.SpelDAL;
import Model.ingame.PlayerStats;

public class SpelModel {

	private SpelDAL spelDal;
	
	public SpelModel() {
		spelDal = new SpelDAL();
	}
	
	public ArrayList<PlayerStats> getPlayerStats(int id){
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
	
//	public void shouldRefresh(int gameID) {
//		spelDAL.shouldRefresh(gameID);
//	}
}
