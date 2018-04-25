package Controller;

import Model.Dice;
import View.DieGUI;

public class NotMainController {
	
	Dice d = new Dice();
	
	public NotMainController(){
		DieGUI die = new DieGUI(this);
		die.create();	
	}
	
	public int[] castDice() {
		d.rollDice();
		return d.getDice();
	}
}