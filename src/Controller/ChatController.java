package Controller;

import java.util.ArrayList;

import DAL.ChatDAL;
import DAL.MainDAL;
import Model.ChatModel;
import View.chat.ChatGui;
import View.chat.Chatoutputgui;


public class ChatController implements Runnable {
	
	private int gameid;
	private ChatModel chatmodel;

	@SuppressWarnings("unused")
<<<<<<< HEAD
	private ChatDAL cd = new ChatDAL();
	private Thread t1;
	
	public ChatController(int gameid,Chatoutputgui cog) {
		this.chatmodel =new ChatModel(cd);
		this.gameid = gameid;
		t1 = new Thread(this);
		t1.start();
=======
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

>>>>>>> chat
		chatmodel.addObserver(cog);
		
	}
	
	public void SendMessage(int playerid , String message) {
		chatmodel.SendMessage(playerid, message);

	}
	
<<<<<<< HEAD
	public String getLatestMessage(int gameid) {
		String message =chatmodel.getLatestMessage(gameid);
=======
	public ArrayList<String> getLatestMessage(int gameid) {
		ArrayList<String> message =chatmodel.getLatestMessage(gameid);
>>>>>>> chat
		return message;
	}


	
	public void run() {
		while(true) {
<<<<<<< HEAD
		try {
=======
		try {			///tries to get a new message every second 
>>>>>>> chat
			getLatestMessage(gameid);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		}
	}
	
	
}



