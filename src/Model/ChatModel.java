package Model;



import java.util.Observable;

import DAL.ChatDAL;
import DAL.MainDAL;


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
		
		getLatestMessage();
	
}
	
	
	public String getLatestMessage() {
		String result = "";
		
		
			String messages = cd.GetMessage();
			result = messages;
		
		this.setChanged();
		this.notifyObservers(result);
		return result;
	}
	

	

}
