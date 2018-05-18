package Model;

import DAL.ChatDAL;
import DAL.MainDAL;
import DAL.PersonDAL;

public class Chat {
	
	private int playerid;
	
	public Chat(int playerid) {
		this.playerid = playerid;
	}
	
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
	
	public String getchatText() {
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
	public String getUserName(int playerid) 
	{
		String name = "";
		MainDAL db = new MainDAL();
		{ 
			if ((db.loadDataBaseDriver("com.mysql.jdbc.Driver"))
				&& (db.makeConnection()))
			{
			PersonDAL pd = new PersonDAL();
			 name = pd.getName(playerid);
			
			}
		}
		return name;
	}
}



