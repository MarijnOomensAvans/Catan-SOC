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
//		BankController bc = new BankController(md);
//		new PlayerController(md,bc,1);

		new TradeController(9, 220, pd);

	}
}


