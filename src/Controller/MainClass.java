package Controller;

import DAL.MainDAL;

public class MainClass {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MainDAL mainDAL = new MainDAL();
		new LoginController(); 
		//new LobbyController();
	}
}
