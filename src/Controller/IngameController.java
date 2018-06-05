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
}
