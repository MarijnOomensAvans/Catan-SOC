package Model;

import Controller.BankController;
import Controller.PlayerController;
import Controller.TradeController;
import DAL.MainDAL;
import DAL.PersonDal;

public class MainClass {

	public static void main(String[] args) {
		MainDAL md = new MainDAL();
		PersonDal pd = new PersonDal();
		BankController bc = new BankController(md);
		PlayerController player =new PlayerController(md,pd, bc,1);
		Player player1 = new Player(player, pd, 60, 804);
		player1.addMaterialCard("B");
		player1.addMaterialCard("B");
		player1.addMaterialCard("H");
		new TradeController(60, 804, pd, player1);

	}
}


