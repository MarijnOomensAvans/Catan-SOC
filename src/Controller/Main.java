package Controller;

import DAL.MainDAL;
import View.SetupGamePane;

public class Main {

	public static void main(String[] args) {
<<<<<<< HEAD
		
=======

>>>>>>> 10dff355637d3d29ba57506960047f8114ce7edc
		boolean connected = false;
		MainDAL mainDAL = new MainDAL();

		while (connected == false) {
			if ((mainDAL.loadDataBaseDriver("com.mysql.jdbc.Driver")) && (mainDAL.makeConnection())) {
				connected = true;
				System.out.println("Connected");
			} else {
				System.out.println("Connection failed");
			}
		}

		new LoginController(); 
		//new LobbyController();
	}
}
