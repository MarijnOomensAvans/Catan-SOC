package Controller;


import java.util.Observable;

import Model.ChatModel;
import View.ChatGui;


public class ChatController extends Observable {
	
	private ChatGui chatview;
	private ChatModel chatmodel;
	
	public ChatController() {

		this.chatmodel =new ChatModel();
		this.chatview = new ChatGui(this, 1);
		
	}
	
	public void SendMessage(int playerid , String message) {
		chatmodel.SendMessage(playerid, message);
		this.setChanged();
		this.notifyObservers();
	}
	
	public String getLatestMessage() {
		String message =chatmodel.getLatestMessage();
		return message;
	}
	
	
}



