package Model;

import java.util.Random;

public class Dice {
	int dice[] = {1, 1};
	Random rand = new Random();
	
	public int[] getDice() {
		return dice;
	}
	
	public int[] getStoredDice() {
		int storedDice[] = {1, 1};
		
		//TO DO: some db connectivity here
		
		return storedDice;
	}
	
	public void storeDice() {
		//TO DO: some db connectivity here
	}
	
	public void rollDice() {
		dice[0] = rand.nextInt(6)+1;
		dice[1] = rand.nextInt(6)+1;
	}
}
