package Controller;

import java.util.ArrayList;

import DAL.PersonDAL;

import Model.TradeOtherPlayers;

import Model.ingame.PlayerStats;
import Model.ingame.SpelModel;
import View.developmentCards.DevelopmentContentPane;
import View.developmentCards.DevelopmentGui;
import View.inGame.InGameFrame;
import View.setupGame.DrawingPanel;
import View.trade.TradeGui;
import View.trade.TradeOfferPane;

public class IngameController implements Runnable {

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
	private InGameFrame gameFrame;
	private TradeController tc;
	private Thread tradeThread;

	public IngameController(int gameid, int playerID, BoardController bc) {
		tradeThread = new Thread(this);
		this.gameid = gameid;
		this.playerID = playerID;
		this.bc = bc;
		this.rb = new RobberController();
		this.dieController = new DieController(gameid, rb, this);
		spelModel = new SpelModel(gameid);
		Thread thread = new Thread(new GameUpdateController(spelModel));
		thread.start();
		bct = new BankController(gameid);
		pd = new PersonDAL();
		chatController = new ChatController(gameid, playerID);
		this.pc = new PlayerController(playerID, gameid, bct, pd);
		DrawingPanel dp = new DrawingPanel(bc, gameid);
		rb.setDrawingPanel(dp);
		dp.setPlayerController(pc);
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

		tc =new TradeController(playerID, gameid, pd, pc.getPlayer(), pc, bct, new TradeGui(tc, playerID, new TradeOfferPane(tc, playerID, true), gameid));

	}

	public void openDevcard() {
		DevelopmentContentPane dcp = new DevelopmentContentPane(pc, playerID);
		new DevelopmentGui(pc, dcp, gameid, playerID);
	}

	public void setPlayerTurn(int gameid, String username) {
		spelModel.setPlayerTurn(gameid, username);
	}

	public void shouldRefresh() {
		spelModel.shouldRefresh();
	}

	public void update() {
		gameFrame.update();
	}
	
	public PlayerController getPc() {
		return pc;
	}
	public boolean hasRolledDice(int gameid) {
		return spelModel.hasRolledDice(gameid);
		
	}

	@Override
	public void run() {
		while (true) {
			try {
				ArrayList<Integer> otherIds = getOtherid(gameid,playerID);
				for(int i = 0; i<otherIds.size(); i++)
				{
					tc.getLatestTradeOffer(otherIds.get(i));
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
	public ArrayList<Integer> getOtherid(int gameid, int playerid) {
		TradeOtherPlayers otherplayers = new TradeOtherPlayers(pd);
		ArrayList<Integer> id = otherplayers.getOtherid(gameid, playerid);
		return id;
	}


	public void thrownDice() {
		gameFrame.nextTurnButtonUpdate();
		shouldRefresh();
	}

}
