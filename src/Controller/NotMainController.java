package Controller;

import Model.Dice;
import View.DieGUI;

public class NotMainController {
	
	//temporary main controller, the following code needs to be added to the master main controller
	
	private Dice d1 = new Dice();
	private Dice d2 = new Dice();
	
	public NotMainController(){
		DieGUI die = new DieGUI(this);
		die.create();	
	}
	
	public int[] castDice() {
		d1.rollDice();
		d2.rollDice();
		
		int diceResult[] = {d1.getDice(), d2.getDice()};
		
		return diceResult;
	}
}