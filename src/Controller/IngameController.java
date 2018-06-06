package Controller;

import java.util.ArrayList;

import Model.SpelModel;
import Model.ingame.PlayerStats;

public class IngameController {
	
	private SpelModel spelModel;
	
	public IngameController() {
	 spelModel = new SpelModel();

	}
	
	public ArrayList<PlayerStats> getPlayerStats(int gameId){
		return spelModel.getPlayerStats(gameId);
		
	}
	
	public String getTurn(int id) {
		return spelModel.getTurn(id);
	}
	
	public void setbiggestArmy(int gameid, String username) {
		spelModel.setBiggestArmy(gameid, username);
	}

	public void openTrade() {
		// TODO Auto-generated method stub
		
	}

	public void openDevcard() {
		// TODO Auto-generated method stub
		
	}
}
