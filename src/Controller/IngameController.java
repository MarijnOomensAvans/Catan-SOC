package Controller;

import java.util.ArrayList;

import Model.SpelModel;
import Model.ingame.PlayerStats;
import View.developmentCards.DevelopmentContentPane;
import View.developmentCards.DevelopmentGui;

public class IngameController {

	private SpelModel spelModel;
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
		// TODO Auto-generated method stub

	}

	public void openDevcard() {
		DevelopmentContentPane dcp = new DevelopmentContentPane(playerController, playerid);
		new DevelopmentGui(playerController, dcp, gameid, playerid);
	}
}
