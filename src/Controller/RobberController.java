package Controller;

import DAL.RobberDAL;
import View.robber.RobberGui;
import View.setupGame.DrawingPanel;

public class RobberController {
	
	private RobberDAL rd;
	private DrawingPanel dp;
	private int playerID;
	private RobberGui gui;
	
	public RobberController(int playerID){
		this.playerID = playerID;
		rd = new RobberDAL();
	}
	
	public void robberThrown(int diceResult, int gameID) {
		rd.removeHalf(gameID);
		dp.setMayMoveRobber(true);

		
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

}
