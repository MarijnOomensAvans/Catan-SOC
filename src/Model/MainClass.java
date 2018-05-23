package Model;


import Controller.BankController;
import DAL.MainDAL;


public class MainClass {

	public static void main(String[] args) {

		MainDAL md = new MainDAL();
		BankController conn = new BankController(md);

	}
}


