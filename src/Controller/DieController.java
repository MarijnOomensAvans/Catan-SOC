package Controller;

import Model.Die;
import View.DieGUI;

public class DieController 
{	
	private int gameID;
	private Die d1;
	private Die d2;
	
	public DieController(int gameID)
	{
		this.gameID = gameID;
		
		d1 = new Die(1, gameID);
		d2 = new Die(2, gameID);
		
		DieGUI dieGUI = new DieGUI(this);
		dieGUI.create();	
	}
	
	public int[] rollDice() 
	{
		d1.rollDie();
		d2.rollDie();
		
		int diceResult[] = {d1.getStoredDie(), d2.getStoredDie()};
		
		return diceResult;
	}
}