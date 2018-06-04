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
		BankController bc = new BankController(md, 770);
		PlayerController player =new PlayerController(md,pd, bc,1);
		int playerid = 42;
		Player player1 = new Player(player, pd, playerid, 770);
		player1.addMaterialCard("B");
		player1.addMaterialCard("B");
		player1.addMaterialCard("H");
		new TradeController(playerid, 770, pd, player1,player,bc);
	}
}


