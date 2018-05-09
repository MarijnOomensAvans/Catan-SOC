package Model;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
	
	private ArrayList<DevelopmentCard> devbank = new ArrayList <DevelopmentCard>();
	
	public Bank() {
		makeDevCards();
	}
	
	private void makeDevCards() {
		for(int i=0; i<25; i++) {
			devbank.add(new DevelopmentCard(i));
		}
	}
	public DevelopmentCard getCard() {
		Random random = new Random();
		int number =random.nextInt(devbank.size());
		return devbank.get(number);
	}

}
