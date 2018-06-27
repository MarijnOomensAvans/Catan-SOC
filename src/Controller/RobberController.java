package Controller;

import DAL.RobberDAL;
import View.robber.RobberGui;
import View.setupGame.DrawingPanel;

public class RobberController {
	
	private RobberDAL rd;
	private DrawingPanel dp;
	private int playerID;
	private RobberGui gui;
	private IngameController igc;
	private BoardController bc;
	
	public RobberController(int playerID, IngameController ingameController, BoardController bc){
		this.igc = ingameController;
		this.playerID = playerID;
		this.bc = bc;
		rd = new RobberDAL();
	}
	
	public void robberThrown( int gameID) {
		rd.removeHalf(gameID);
		if(igc.getTurn(gameID).equals(igc.getPlayer(gameID))) {
		igc.logToChat(igc.getTurn(gameID) + " heeft een 7 gegooid! Hij/zij mag nu de struikrover verplaatsen.");
		igc.setHasMovedRobber(false);
		igc.closeEndTurnButton();
		dp.setMayMoveRobber(true);
		}
	}
	
	public IngameController getInGameController( ) {
		return this.igc;
	}
	
	public void setDrawingPanel(DrawingPanel dp) {
		this.dp = dp;
	}
	
	public void close() {
		gui.dispose();
	}

	public RobberDAL getRd() {
		return rd;
	}

	public void choose(int gameID, int x, int y) {
		gui = new RobberGui(gameID,rd, playerID,this,x,y,bc);
		
	}
	
	public void setIngameControllerHasMovedRobber(boolean set) {
		igc.setHasMovedRobber(set);
	}

	public boolean robberHasPosition(int x, int y, int gameID) {
		return rd.robberHasPosition(x,y,gameID);
	}

}
