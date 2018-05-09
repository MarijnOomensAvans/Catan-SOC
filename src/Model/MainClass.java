package Model;

public class MainClass {

	public static void main(String[] args) {
		Player player1 = new Player(1);
		player1.getUsername();
		player1.getGame_id();
		player1.getColor();
		player1.getOrder_number();
		player1.addMaterialCard(3);
		player1.addMaterialCard(3);
		player1.addMaterialCard(4);
		player1.printCards();
		player1.removeCard(3);
		player1.removeCard(3);
		player1.printCards();
	}
}


