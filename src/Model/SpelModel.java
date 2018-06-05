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
}
