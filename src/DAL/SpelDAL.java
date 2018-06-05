package DAL;

import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import Model.ingame.PlayerStats;

public class SpelDAL {

	private Connection conn;
	
	public SpelDAL() {
		MainDAL.getConnection();
	}
	
	public ArrayList<PlayerStats> getPlayerStats(){
		ArrayList<PlayerStats> stats = new ArrayList<PlayerStats>();
		
		return stats;
		
	}
	
}
