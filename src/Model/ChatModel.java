package Model;



import java.util.Observable;

import DAL.ChatDAL;
import DAL.MainDAL;


public class ChatModel extends Observable {
	
	public void SendMessage(int playerid, String message) {
		if(message.length() > 255) {
			
		}else {
		MainDAL db = new MainDAL();
		{ 
		if ((db.loadDataBaseDriver("com.mysql.jdbc.Driver"))
				&& (db.makeConnection()))
		{
			ChatDAL cd = new ChatDAL();
			cd.SendMessage(playerid, message);
			
		}
		this.setChanged();
		this.notifyObservers(message);
	}
}
	}
	
	public String getLatestMessage() {
		String result = "";
		MainDAL db = new MainDAL();
		{ 
		if ((db.loadDataBaseDriver("com.mysql.jdbc.Driver"))
				&& (db.makeConnection()))
		{
			ChatDAL cd = new ChatDAL();
			String messages = cd.GetMessage();
			result = messages;
		}
	}
		return result;
	}
	

	

}
