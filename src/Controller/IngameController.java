package Controller;

import java.util.ArrayList;

import DAL.PersonDAL;
import Model.SpelModel;
import Model.ingame.PlayerStats;
import View.developmentCards.DevelopmentContentPane;
import View.developmentCards.DevelopmentGui;
import View.inGame.InGameFrame;
import View.setupGame.DrawingPanel;

public class IngameController {

	private SpelModel spelModel;
	private BankController bct;
	private int gameid;
	private PersonDAL pd;
	private PlayerController pc;
	private int playerID;
	private BoardController bc;
	private ChatController chatController;
	private DieController dieController;
	private RobberController rb;

	public IngameController(int gameid, int playerID, InGameFrame gameFrame, BoardController bc) {
		this.gameid = gameid;
		this.playerID = playerID;
		this.bc = bc;
		this.rb = new RobberController();
		this.dieController = new DieController(gameid,rb);
		spelModel = new SpelModel();
		bct = new BankController(gameid);
		pd = new PersonDAL();
		chatController = new ChatController(gameid, playerID);
		DrawingPanel dp = new DrawingPanel(bc, gameid);
		this.pc = new PlayerController(playerID, gameid, bct, pd);
		gameFrame = new InGameFrame(bc, gameid, dp, playerID, this, pc, chatController, dieController);
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

		new TradeController(playerID, gameid, pd, pc.getPlayer(), pc, bct);

		// TODO Auto-generated method stub

	}

	public void openDevcard() {
		DevelopmentContentPane dcp = new DevelopmentContentPane(pc, playerID);
		new DevelopmentGui(pc, dcp, gameid, playerID);
	}
}
