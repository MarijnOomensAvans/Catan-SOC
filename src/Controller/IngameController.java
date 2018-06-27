package Controller;

import java.util.ArrayList;

import DAL.PersonDAL;
import Model.ingame.PlayerStats;
import Model.ingame.GameModel;
import View.developmentCards.DevelopmentGui;
import View.inGame.InGameFrame;
import View.setupGame.DrawingPanel;

public class IngameController {

	private GameModel gameModel;
	private BankController bct;
	private int gameid;
	private PersonDAL pd;
	private PlayerController pc;
	private int playerID;
	@SuppressWarnings("unused")
	private BoardController bc;
	private ChatController chatController;
	private DieController dieController;
	private TradeController tc;
	private RobberController rb;
	private InGameFrame gameFrame;
	private DrawingPanel dp;
	private boolean hasMovedRobber;
	private DevelopmentGui devGUI;

	public IngameController(int gameid, int playerID, BoardController bc) {
		this.hasMovedRobber = true;
		this.gameid = gameid;
		this.playerID = playerID;
		this.bc = bc;
		this.rb = new RobberController(playerID,this,bc);
		gameModel = new GameModel(gameid, this);
		Thread thread = new Thread(new GameUpdateController(gameModel));
		thread.start();
		bct = new BankController(gameid);
		pd = new PersonDAL();
		this.dieController = new DieController(gameid, rb, this, bc, bct, pd);
		chatController = new ChatController(gameid, playerID);
		this.pc = new PlayerController(playerID, gameid, bct, pd,dieController);
		dp = new DrawingPanel(bc, gameid, rb);
		dp.setIngameController(this);
		dp.setPlayerController(pc);
		rb.setDrawingPanel(dp);
		dp.setSetUp(true);
		gameFrame = new InGameFrame(bc, gameid, dp, playerID, this, pc, chatController, dieController, bct);
		gameModel.addObserver(gameFrame.getPane());
		tc = new TradeController(playerID, gameid, pd, pc.getPlayer(), pc, bct, this);
	}
	
	public void closeEndTurnButton() {
		gameFrame.closeEndTurnButton();
	}
	
	public int getGameId() {
		return gameid;
	}
			

	public PlayerController getPc() {
		return pc;
	}

	public ArrayList<PlayerStats> getPlayerStats(int gameId) {
		ArrayList<PlayerStats> playerStats = gameModel.getPlayerStats(gameId);

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
	
	public String getPlayer(int gameid) {
		return gameModel.getPlayer(gameid);
	}

	public String getTurn(int id) {
		return gameModel.getTurn(id);
	}

	public void setbiggestArmy(int gameid, String username) {
		gameModel.setBiggestArmy(gameid, username);
	}

	public void openTrade() {
		tc.createGUI("top");
	}

	public void closeTradeWindows(boolean thread) {
		if(!thread)
		{
			tc.setRunthread(thread);
		}
		tc.close();
	}

	public void closeDevCardWindow() {
		if (devGUI != null) {
			devGUI.closeFrame();
			devGUI = null;
		}
	}

	public void openDevcard() {
		devGUI = new DevelopmentGui(pd, bct, pc, gameid, playerID, dp, rb, gameFrame, this);
	}

	public void setPlayerTurn(int gameid, String username) {
		gameModel.setPlayerTurn(gameid, username);
	}

	public void shouldRefresh(int gameID) {
		gameModel.shouldRefresh(gameID);
	}

	public void thrownDice() {
		gameFrame.nextTurnButtonUpdate();
		shouldRefresh(gameid);
	}

	public boolean hasRolledDice(int gameid) {
		return gameModel.hasRolledDice(gameid);
	}
	
	public void updateLongestRoute() {
		gameModel.updateLongestRoute();
	}

	public String getLongestRoute(int gameID) {
		return gameModel.getLongestRoute(gameid);
	}

	public String getBiggestArmy(int gameid) {
		return gameModel.getBiggestArmy(gameid);
	}

	public ArrayList<Integer> getPlayerIds(int gameID2) {
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ids = pd.getIds(gameID2);
		return ids;
	}

	public boolean getFirstTurn() {
		return gameModel.getFirstTurn();
	}

	public void firstTurnCheck() {
		gameModel.firstTurnCheck();
	}

	public void buildVillage() {
		dp.setBuild(true, "Village");
	}

	public void buildStreet() {
		dp.setBuild(true, "Street");
	}

	public int getBuildingCount() {
		return gameModel.getBuildingCount();
	}

	public int getBuildingCount(int volgnr) {
		return gameModel.getBuildingCount(volgnr);
	}

	public void setAllPlayersCanceled(int gameid) {
		gameModel.setAllPlayersCanceld(gameid);
	}

	public void setSecondRound(boolean b) {
		gameModel.setSecondRound(b);
	}

	public boolean isSecondRound() {
		return gameModel.isSecondRound();
	}

	public void setFirstTurn(boolean b) {
		gameModel.setFirstTurn(b);
	}

	public void setBuildButton(boolean enable) {
		gameFrame.setBuildButton(enable);
	}
	
	public void setTradeButton(boolean enable) {
		gameFrame.setTradeButton(enable);
	}

	public void setDevCardButton(boolean enable) {
		gameFrame.setDevCardButton(enable);
	}
	
	public boolean robberHasPosition(int x, int y, int gameID) {
		return rb.robberHasPosition(x, y, gameID);
	}


	public void setHasMovedRobber(boolean set) {
		this.hasMovedRobber = set;
	}

	public boolean hasMovedRobber() {
		return this.hasMovedRobber;

	}

	public void activateEndTurnButton() {
		gameFrame.activateEndTurnButton();
		
	}
	
	public void update() {
		pc.updateHand();
	}
	
	public void logToChat(String log) {
		chatController.logToChat(log);
	}
}
