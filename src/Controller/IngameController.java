package Controller;

import java.util.ArrayList;

import DAL.PersonDAL;
import Model.SpelModel;
import Model.ingame.PlayerStats;
import View.developmentCards.DevelopmentContentPane;
import View.developmentCards.DevelopmentGui;

public class IngameController {

	private SpelModel spelModel;
<<<<<<< HEAD
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
=======
	private PlayerController playerController;
	private BankController bankController;
	private int playerid;
	private int gameid;

	public IngameController(int gameid, int playerid) {
		this.gameid = gameid;
		this.playerid = playerid;
		spelModel = new SpelModel();
		playerController = new PlayerController(playerid, gameid);
		bankController = new BankController(gameid);

>>>>>>> 7dbd23a57c8f49caf38184148d0ba4ae9ce03dc6
	}

	public ArrayList<PlayerStats> getPlayerStats(int gameId) {
		return spelModel.getPlayerStats(gameId);

	}

	public String getTurn(int id) {
		return spelModel.getTurn(id);
	}

	public void setbiggestArmy(int gameid, String username) {
		spelModel.setBiggestArmy(gameid, username);
	}

	public void openTrade() {
<<<<<<< HEAD
		new TradeController(playerID, gameid, pd, pc.getPlayer(), pc, bc);
		
=======
		// TODO Auto-generated method stub

>>>>>>> 7dbd23a57c8f49caf38184148d0ba4ae9ce03dc6
	}

	public void openDevcard() {
		DevelopmentContentPane dcp = new DevelopmentContentPane(playerController, playerid);
		new DevelopmentGui(playerController, dcp, gameid, playerid);
	}
}
