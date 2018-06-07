package Controller;

import Model.Die;

public class DieController 
{	
	private int gameID;
	private Die d1;
	private Die d2;
	private RobberController rb;
	
	public DieController(int gameID, RobberController rb)
	{
		this.gameID = gameID;
		this.rb = rb;
		d1 = new Die(1, gameID);
		d2 = new Die(2, gameID);
		
		//DieGUI dieGUI = new DieGUI(this);
		//dieGUI.create();	
	}
	
	public int[] rollDice() 
	{
		d1.rollDie();
		d2.rollDie();
		
		int diceResult[] = {d1.getStoredDie(), d2.getStoredDie()};
		int diceRes = d1.getStoredDie() + d2.getStoredDie();
		lookAtResult(diceRes);
		return diceResult;
	}
	
	
	public void lookAtResult(int diceResult) {
		if(diceResult == 7) {
			rb.robberThrown(diceResult,gameID);
		}
	}

	public Die getD1() {
		return d1;
	}

	public Die getD2() {
		return d2;
	}
	
}