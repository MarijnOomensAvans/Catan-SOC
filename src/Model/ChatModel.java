package Model;



import java.util.ArrayList;
import java.util.Observable;

import DAL.ChatDAL;


public class ChatModel extends Observable {
	
	private ChatDAL cd;

	
	public ChatModel( ChatDAL cd) {
		this.cd = cd;
	}
	
	public void SendMessage(int playerid, String message) {
		if(message.length() > 255) {
			
		}else {
			cd.SendMessage(playerid, message);
		}
	
}
	
	
	public ArrayList<String> getLatestMessage() {
		ArrayList<String> results = new ArrayList<>();
		//String result = "";
		
			results = cd.GetMessage();
			//result = messages;
		
<<<<<<< HEAD
		this.setChanged();		///notify's the output box that a new message has been recieved
		this.notifyObservers(result);
		return result;
=======
		this.setChanged();
		this.notifyObservers(results);
		return results;
>>>>>>> 0081a7f07b9b882ebab1ef5d02fa4dd8b88080d9
	}
	

	

}
