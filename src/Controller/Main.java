package Controller;

import DAL.MainDAL;
import View.LobbyFrame;

public class Main {

	public static void main(String[] args) {
		new LobbyFrame();
		
		boolean connected = false;
		MainDAL mainDAL = new MainDAL();
		
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
