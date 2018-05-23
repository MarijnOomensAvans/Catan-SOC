package Model;

import Controller.ChatController;
import View.PlayFrame;



public class MainClass {

	public static void main(String[] args) {
		new PlayFrame();
		ChatController test =new ChatController();
		Thread t1 = new Thread(test);
		t1.start();
	}

}
