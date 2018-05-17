package Model;

import DAL.ChatDal;
import DAL.MainDAL;
import DAL.PersonDal;

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
			ChatDal cd = new ChatDal();
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
			ChatDal cd = new ChatDal();
			String messages =cd.GetMessage();
			String username = getUserName(playerid);
			result = username + " "+messages;
			
		}
	}
		return result;
	}
	private String getUserName(int playerid) {
		String name = "";
		MainDAL db = new MainDAL();
		{ 
		if ((db.loadDataBaseDriver("com.mysql.jdbc.Driver"))
				&& (db.makeConnection()))
		{
			PersonDal pd = new PersonDal();
			 name =pd.getName(playerid);
			
		}
		}
		return name;
	}
}



