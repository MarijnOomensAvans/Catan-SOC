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
	public ArrayList<String> getLatestMessage(int gameid) {/// gets the latest messages
		ArrayList<String> results = new ArrayList<>();
		results = cd.GetMessage(gameid);
		this.setChanged();
		this.notifyObservers(results);
		return results;

	}
	

	

}
