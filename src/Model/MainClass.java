package Model;


import Controller.BankController;
import Controller.PlayerController;
import DAL.MainDAL;


public class MainClass {

	public static void main(String[] args) {

		MainDAL md = new MainDAL();
		BankController conn = new BankController(md);
		PlayerController pc = new PlayerController(md,conn,2);

	}
}


