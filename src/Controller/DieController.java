package Controller;

import Model.Die;

public class DieController 
{	
	private int gameID;
	private Die d1;
	private Die d2;
	private RobberController rb;
	private IngameController inGameController;
	
	public DieController(int gameID, RobberController rb, IngameController inGameController)
	{
		this.inGameController = inGameController;
		this.gameID = gameID;
		this.rb = rb;
		d1 = new Die(1, gameID);
		d2 = new Die(2, gameID);

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

	public int[] getCurrentValues() {
		int[] values = new int[2];
		values[0] = d1.getStoredDie();
		values[1] = d2.getStoredDie();
		
		return values;
		
	}

	public void thrownDice() {
		inGameController.thrownDice();
	}
	
}