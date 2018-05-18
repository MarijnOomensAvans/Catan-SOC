package Model;



import DAL.ChatDAL;
import DAL.MainDAL;


public class ChatModel {
	
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
