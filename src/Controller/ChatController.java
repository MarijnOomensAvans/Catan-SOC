package Controller;


import java.util.Observable;

import Model.ChatModel;
import View.ChatGui;
import View.Chatoutputgui;


public class ChatController {
	
	private ChatGui chatview;
	private ChatModel chatmodel;
	private Chatoutputgui cog;
	
	public ChatController() {

		this.cog = new Chatoutputgui(this, 1);

		this.chatmodel =new ChatModel();
		chatmodel.addObserver(cog);
		this.chatview = new ChatGui(this, cog, 1);
		
	}
	
	public void SendMessage(int playerid , String message) {
		chatmodel.SendMessage(playerid, message);

	}
	
	public String getLatestMessage() {
		String message =chatmodel.getLatestMessage();
		return message;
	}
	
	
}



