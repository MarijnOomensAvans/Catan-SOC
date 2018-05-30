package Controller;

import java.util.ArrayList;

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
	private MainDAL md;
	private ChatDAL cd;
	private Thread t1;
	private int gameid;
	
	public ChatController(int gameid) {
		this.gameid = gameid;
		md = new MainDAL();
		cd = new ChatDAL();
		t1 = new Thread(this);
		this.chatmodel =new ChatModel(cd);
		this.cog = new Chatoutputgui(this, 45);/// this is made here so that the model can get his observer
		this.chatview = new ChatGui(this, cog, 45);
		t1.start();

		chatmodel.addObserver(cog);
		
	}
	
	public void SendMessage(int playerid , String message) {
		chatmodel.SendMessage(playerid, message);

	}
	
	public ArrayList<String> getLatestMessage(int gameid) {
		ArrayList<String> message =chatmodel.getLatestMessage(gameid);
		return message;
	}


	
	public void run() {
		while(true) {
		try {			///tries to get a new message every second 
			getLatestMessage(gameid);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		}
	}
	
	
}



