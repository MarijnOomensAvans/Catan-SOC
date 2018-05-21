package Model;



import java.util.Observable;

import DAL.ChatDAL;
import DAL.MainDAL;


public class ChatModel extends Observable {
	
	private MainDAL md;
	private ChatDAL cd;

	
	public ChatModel(MainDAL md, ChatDAL cd) {
		this.md = md;
		this.cd = cd;
	}
	
	public void SendMessage(int playerid, String message) {
		if(message.length() > 255) {
			
		}else {
		
		if ((md.loadDataBaseDriver("com.mysql.jdbc.Driver"))
				&& (md.makeConnection()))
		{
			cd.SendMessage(playerid, message);
			
		}
		
		getLatestMessage();
	}
}
	
	
	public String getLatestMessage() {
		String result = "";
		
		if ((md.loadDataBaseDriver("com.mysql.jdbc.Driver"))
				&& (md.makeConnection()))
		{
			String messages = cd.GetMessage();
			result = messages;
		}
		this.setChanged();
		this.notifyObservers(result);
		return result;
	}
	

	

}
