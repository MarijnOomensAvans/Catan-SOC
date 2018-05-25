package Model;

import java.util.ArrayList;

import DAL.PersonDal;
import DAL.TradeDAL;

public class TradeOtherPlayers {
	
	private PersonDal pd;
	private TradeDAL td;
	
	public TradeOtherPlayers(PersonDal pd, TradeDAL td) {
		this.pd = pd;
		this.td = td;

	}

	public ArrayList<String> getOherPlayerName(int gameid, int playerid) {
		ArrayList<String> names =pd.getOtherPlayerName(gameid,playerid);
		return names;
	}

	public ArrayList<Boolean> getResponses(int playerid) {
		ArrayList<Boolean> responses = td.getResponses(playerid);
		return responses;
	}

	

}
