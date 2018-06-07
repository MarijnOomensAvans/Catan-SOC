package Controller;

import DAL.RobberDAL;
import View.setupGame.DrawingPanel;

public class RobberController {
	
	private RobberDAL rd;
	private DrawingPanel dp;
	
	public RobberController(){
		rd = new RobberDAL();
	}
	
	public void robberThrown(int diceResult, int gameID) {
		rd.removeHalf(gameID);
		dp.setMayMoveRobber(true);
		
	}
	
	public void setDrawingPanel(DrawingPanel dp) {
		this.dp = dp;
	}

}
