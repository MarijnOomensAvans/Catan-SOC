package Model;

import Controller.ChatController;



public class MainClass {

	public static void main(String[] args) {
		
		ChatController test =new ChatController();
		Thread t1 = new Thread(test);
		t1.start();
	}

}
