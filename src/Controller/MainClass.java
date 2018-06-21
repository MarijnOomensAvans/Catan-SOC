package Controller;

import DAL.MainDAL;
import DAL.RobberDAL;

public class MainClass {

	public static void main(String[] args) {
		new MainDAL();
		RobberDAL rb = new RobberDAL();
		System.out.println(rb.robberHasPosition(7, 5, 11));
	}

}
