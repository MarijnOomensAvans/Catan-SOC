package Model;

public class MainClass {

	public static void main(String[] args) {
		Player player1 = new Player(1);
		Bank bank = new Bank();
		player1.getUsername();
		player1.getGame_id();
		player1.getColor();
		player1.getOrder_number();
		bank.printallMatCards();
	
	}
}


