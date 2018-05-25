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
<<<<<<< HEAD
		new TradeController(md, 1);
=======
		new TradeController(9,220,pd);
>>>>>>> e2420f1ab03af08306872bf1fc96d6cd570a0a6b

	}
}


