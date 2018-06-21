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
	
	public RobberController(int playerID, IngameController ingameController){
		this.igc = ingameController;
		this.playerID = playerID;
		rd = new RobberDAL();
	}
	
	public void robberThrown( int gameID) {
		rd.removeHalf(gameID);
		if(igc.getTurn(gameID).equals(igc.getPlayer(gameID))) {
		igc.setHasMovedRobber(false);
		igc.closeEndTurnButton();
		dp.setMayMoveRobber(true);
		}
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

	public void choose(int gameID) {
		gui =new RobberGui(gameID,rd, playerID,this);
		
	}

	public boolean robberHasPosition(int x, int y, int gameID) {
		return rd.robberHasPosition(x,y,gameID);
	}

}
