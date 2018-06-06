package Controller;

import java.util.ArrayList;

import DAL.PersonDAL;
import Model.SpelModel;
import Model.ingame.PlayerStats;

public class IngameController {
	
	private SpelModel spelModel;
	private BankController bc;
	private int gameid;
	private PersonDAL pd;
	private PlayerController pc;
	private int playerID;
	
	public IngameController(int gameid, int playerID) {
		this.gameid = gameid;
		this.playerID = playerID;
		spelModel = new SpelModel();
		bc = new BankController(gameid);
		pd = new PersonDAL();
		this.pc = new PlayerController(playerID, gameid, bc, pd);
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
		new TradeController(playerID, gameid, pd, pc.getPlayer(), pc, bc);
		
	}

	public void openDevcard() {
		// TODO Auto-generated method stub
		
	}
}
