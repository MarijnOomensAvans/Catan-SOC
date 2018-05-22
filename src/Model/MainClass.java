package Model;

public class MainClass {

	public static void main(String[] args) {
		Player player1 = new Player();
		Bank bank = new Bank();
		player1.getUsername();
		player1.getGame_id();
		player1.getColor();
		player1.getOrder_number();
		System.out.println(player1.getPoints() + "punten");
//		bank.printallMatCards();
//		bank.printallDevCards();
		player1.getPoints();
		player1.adddevelopmentCard(2);
		player1.printallPlayerDevCards();
		player1.testpointDevCard();
		System.out.println(player1.getPoints() + "punten");
	}
}


