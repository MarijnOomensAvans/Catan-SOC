package Model;

import java.util.Random;

public class Dice {
	private int dice = 1;
	private Random rand = new Random();
	
	public int getDice() {
		return dice;
	}
	
	public int getStoredDice() {
		int storedDice = 1;
		
		//TO DO: some db connectivity here
		
		return storedDice;
	}
	
	public void storeDice() {
		//TO DO: some db connectivity here
	}
	
	public void rollDice() {
		dice = rand.nextInt(6)+1;
	}
}
