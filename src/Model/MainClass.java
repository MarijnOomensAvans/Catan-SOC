package Model;

import Controller.BankController;
import Controller.PlayerController;

import DAL.MainDAL;

public class MainClass {

	public static void main(String[] args) {
		MainDAL md = new MainDAL();
		BankController bc = new BankController(md);
		new PlayerController(md,bc,1);

	}
}


