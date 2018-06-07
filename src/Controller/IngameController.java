package Controller;

import java.util.ArrayList;

import DAL.PersonDAL;
import Model.ingame.SpelModel;
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
	private InGameFrame gameFrame;
	private DrawingPanel dp;

	public IngameController(int gameid, int playerID, BoardController bc) {
		this.gameid = gameid;
		this.playerID = playerID;
		this.bc = bc;
		this.rb = new RobberController(playerID);
		spelModel = new SpelModel(gameid, this);
		Thread thread = new Thread(new GameUpdateController(spelModel));
		thread.start();
		bct = new BankController(gameid);
		pd = new PersonDAL();
		this.dieController = new DieController(gameid, rb, this, bc, bct, pd);
		chatController = new ChatController(gameid, playerID);
		this.pc = new PlayerController(playerID, gameid, bct, pd);
		dp = new DrawingPanel(bc, gameid,rb);
		dp.setIngameController(this);
		dp.setPlayerController(pc);
		rb.setDrawingPanel(dp);
		gameFrame = new InGameFrame(bc, gameid, dp, playerID, this, pc, chatController, dieController);
		spelModel.addObserver(gameFrame.getPane());
	}

	public PlayerController getPc() {
		return pc;
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
	}

	public void openDevcard() {
//		DevelopmentContentPane dcp = new DevelopmentContentPane(pc, playerID, dp);
		new DevelopmentGui(pc, gameid, playerID, dp);
	}

	public void setPlayerTurn(int gameid, String username) {
		spelModel.setPlayerTurn(gameid, username);
	}

	public void shouldRefresh(int gameID) {
		spelModel.shouldRefresh(gameID);
	}
	
	public void thrownDice() {
		gameFrame.nextTurnButtonUpdate();
		shouldRefresh(gameid);
	}

	
	public boolean hasRolledDice(int gameid) {
		return spelModel.hasRolledDice(gameid);
		
	}
	
	public String getLongestRoute(int gameID) {
		return spelModel.getLongestRoute(gameid);
	}
	
	public String getBiggestArmy(int gameid) {
		return spelModel.getBiggestArmy(gameid);
	}
	
	public ArrayList<Integer> getPlayerIds(int gameID2) {
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ids =pd.getIds(gameID2);
		return ids;
	}

	public boolean getFirstTurn() {
		return spelModel.getFirstTurn();
	}

	public void firstTurnCheck() {
		spelModel.firstTurnCheck();
	}
	
	public void buildVillage() {
		dp.setBuild(true, "Village");
	}
	
	public void buildStreet() {
		dp.setBuild(true, "Street");
	}
	
	public int getBuildingCount() {
		return spelModel.getBuildingCount();
	}
	
	public int getBuildingCount(int volgnr) {
		return spelModel.getBuildingCount(volgnr);
	}

	public void setSecondRound(boolean b) {
		spelModel.setSecondRound(b);
	}
}
