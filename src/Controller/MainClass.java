package Controller;

import DAL.MainDAL;

public class MainClass {

	public static void main(String[] args) {
		
		boolean connected = false;
		MainDAL mainDAL = new MainDAL();

		new InlogController();
		
		while(connected == false) {
			if((mainDAL.loadDataBaseDriver("com.mysql.cj.jdbc.Driver")) && (mainDAL.makeConnection())) {
				connected = true;
				System.out.println("Connected");
			} else {
				System.out.println("Connection failed");
			}
		}

	}

}
