package Model;

import java.util.ArrayList;

import DAL.PersonDal;

public class TradeOtherPlayers {
	
	private PersonDal pd;
	
	public TradeOtherPlayers(PersonDal pd) {
		this.pd = pd;

	}

	public ArrayList<String> getOherPlayerName(int gameid, int playerid) {
		ArrayList<String> names =pd.getOtherPlayerName(gameid,playerid);
		return names;
	}

	

}
