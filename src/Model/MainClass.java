package Model;

import Controller.NotMainController;
import View.DieGUI;

public class MainClass {

	public static void main(String[] args) {
		// Test
		//Dice die = new Dice();
		//NotMainController ctr = new NotMainController();
		
		DieGUI die = new DieGUI();
		die.create();
		
	}

}
