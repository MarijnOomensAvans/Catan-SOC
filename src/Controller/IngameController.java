package Controller;

import java.util.ArrayList;

import DAL.PersonDAL;
import Model.ingame.PlayerStats;
import Model.ingame.SpelModel;
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
	private TradeController tc;
	private RobberController rb;
	private InGameFrame gameFrame;
	private DrawingPanel dp;
	private boolean hasMovedRobber;

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
		dp = new DrawingPanel(bc, gameid, rb);
		dp.setIngameController(this);
		dp.setPlayerController(pc);
		rb.setDrawingPanel(dp);
		dp.setSetUp(true);
		gameFrame = new InGameFrame(bc, gameid, dp, playerID, this, pc, chatController, dieController);
		spelModel.addObserver(gameFrame.getPane());
		tc = new TradeController(playerID, gameid, pd, pc.getPlayer(), pc, bct, this);
	}

	public PlayerController getPc() {
		return pc;
	}

	public ArrayList<PlayerStats> getPlayerStats(int gameId) {
		ArrayList<PlayerStats> playerStats = spelModel.getPlayerStats(gameId);

		for (int i = 0; i < playerStats.size(); i++) {
			if (playerStats.get(i).getUsername().equals(LoginController.getUsername())) {
				playerStats.get(i).setOre(pc.getAmountOre(playerStats.get(i).getPlayerId()));
				playerStats.get(i).setStone(pc.getAmountStone(playerStats.get(i).getPlayerId()));
				playerStats.get(i).setWool(pc.getAmountWool(playerStats.get(i).getPlayerId()));
				playerStats.get(i).setWheat(pc.getAmountWheat(playerStats.get(i).getPlayerId()));
				playerStats.get(i).setWood(pc.getAmountWood(playerStats.get(i).getPlayerId()));
			}
		}

		return playerStats;
	}

	public String getTurn(int id) {
		return spelModel.getTurn(id);
	}

	public void setbiggestArmy(int gameid, String username) {
		spelModel.setBiggestArmy(gameid, username);
	}

	public void openTrade() {
		tc.createGUI("top");
		// new TradeController(playerID, gameid, pd, pc.getPlayer(), pc, bct);
	}
	
	public void closeTradeWindows()
	{
		tc.setRunthread(false);
		tc.close();
	}

	public void openDevcard() {
		// DevelopmentContentPane dcp = new DevelopmentContentPane(pc, playerID, dp);
		new DevelopmentGui(pc, gameid, playerID, dp, rb);
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
		ids = pd.getIds(gameID2);
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

	public void setAllPlayersCanceled(int gameid) {
		spelModel.setAllPlayersCanceld(gameid);
	}

	public void setSecondRound(boolean b) {
		spelModel.setSecondRound(b);
	}

	public boolean isSecondRound() {
		return spelModel.isSecondRound();
	}

	public void setFirstTurn(boolean b) {
		spelModel.setFirstTurn(b);
	}

	public void setTradeButton(boolean enable) {
		gameFrame.setTradeButton(enable);
	}

	public boolean robberHasPosition(int x, int y, int gameID) {
		return rb.robberHasPosition(x,y,gameID);
	}
	
	public void setHasMovedRobber(boolean set) {
		this.hasMovedRobber = set;
	}

	public boolean hasMovedRobber() {
		return this.hasMovedRobber;
	}
}
