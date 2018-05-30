package Controller;

import DAL.ChatDAL;
import DAL.MainDAL;
import Model.ChatModel;
import View.chat.ChatGui;
import View.chat.Chatoutputgui;


public class ChatController implements Runnable {
	
	private int gameid;
	private ChatModel chatmodel;

	@SuppressWarnings("unused")
	private ChatDAL cd = new ChatDAL();
	private Thread t1;
	
	public ChatController(int gameid,Chatoutputgui cog) {
		this.chatmodel =new ChatModel(cd);
		this.gameid = gameid;
		t1 = new Thread(this);
		t1.start();
		chatmodel.addObserver(cog);
		
	}
	
	public void SendMessage(int playerid , String message) {
		chatmodel.SendMessage(playerid, message);

	}
	
	public String getLatestMessage(int gameid) {
		String message =chatmodel.getLatestMessage(gameid);
		return message;
	}


	
	public void run() {
		while(true) {
		try {
			getLatestMessage(gameid);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		}
	}
	
	
}



