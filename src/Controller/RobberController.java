package Controller;

import DAL.RobberDAL;

public class RobberController {
	
	private RobberDAL rd;
	
	public RobberController(){
		rd = new RobberDAL();
	}
	
	public void robberThrown(int diceResult, int gameID) {
		rd.removeHalf(gameID);
	}

}
