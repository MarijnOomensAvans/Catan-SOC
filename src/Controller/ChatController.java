package Controller;

import DAL.ChatDAL;
import DAL.MainDAL;
import Model.ChatModel;
import View.ChatGui;
import View.Chatoutputgui;


public class ChatController implements Runnable {
	
	@SuppressWarnings("unused")
	private ChatGui chatview;
	private ChatModel chatmodel;
	private Chatoutputgui cog;
	@SuppressWarnings("unused")
	private MainDAL md = new MainDAL();
	private ChatDAL cd = new ChatDAL();
	private Thread t1;
	
	public ChatController() {
		this.cog = new Chatoutputgui(this, 1);
		this.chatmodel =new ChatModel(cd);
		this.chatview = new ChatGui(this, cog, 1);
		t1 = new Thread(this);
		t1.start();
		chatmodel.addObserver(cog);
		
	}
	
	public void SendMessage(int playerid , String message) {
		chatmodel.SendMessage(playerid, message);

	}
	
	public String getLatestMessage() {
		String message =chatmodel.getLatestMessage();
		return message;
	}


	
	public void run() {
		while(true) {
		try {
			getLatestMessage();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		}
	}
	
	
}



