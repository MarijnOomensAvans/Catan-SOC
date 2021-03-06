package Model;

import java.util.ArrayList;

import DAL.PersonDAL;
import DAL.TradeDAL;

public class TradeOtherPlayers {
	
	private PersonDAL pd;
	private TradeDAL td;
	
	public TradeOtherPlayers(PersonDAL pd) {
		this.pd = pd;

	}

	public String getOherPlayerName(int playerid) {
		String names =pd.getOtherPlayerName(playerid);
		return names;
	}

	public boolean getResponses(int playerid) {
		boolean responses = td.getResponses(playerid);
		return responses;
	}

	public ArrayList<Integer> getOtherid(int gameid,int playerid) {
		ArrayList<Integer> id= pd.getOtherid(gameid, playerid);
		return id;
	}

	public ArrayList<Integer> getTradeResponses(int playerid) {
		ArrayList<Integer> response = td.getTradeResponses(playerid);
		return response;
	}

	

}
