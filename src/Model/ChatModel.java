package Model;



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
	
	
	public String getLatestMessage(int gameid) {
		String result = "";
		
		
			String messages = cd.GetMessage(gameid);
			result = messages;
		
		this.setChanged();
		this.notifyObservers(result);
		return result;
	}
	

	

}
