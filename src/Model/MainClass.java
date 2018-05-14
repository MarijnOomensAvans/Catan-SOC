package Model;

import Controller.DieController;
import DAL.MainDAL;

public class MainClass {

	public static void main(String[] args) {
		//Temporary main class to initialise the "main" controller
		DieController con = new DieController(1);
		
		boolean connected = false;
		MainDAL mainDAL = new MainDAL();
		
		while(connected == false) {
			if((mainDAL.loadDataBaseDriver("com.mysql.cj.jdbc.Driver")) && (mainDAL.makeConnection())) {
				connected = true;
				System.out.println("Connected to Database :D");
			} else {
				System.out.println("Connection failed");
			}
		}
	}

}
