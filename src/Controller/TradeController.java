package Controller;


import DAL.MainDAL;
import DAL.PersonDal;
import DAL.TradeDAL;

import java.util.ArrayList;

import DAL.PersonDal;
import Model.TradeOffer;
import Model.TradeOtherPlayers;
import View.TradeAcceptPane;
import View.TradeGui;

public class TradeController {
	

	private MainDAL md;
	private TradeDAL td;
	
	TradeOtherPlayers otherPlayers;
	private int playerid;
	private int gameid;
	private TradeGui gui;
	
	public TradeController(MainDAL md, int playerid, int gameid, PersonDal pd) {
		this.md = md;
		this.td = new TradeDAL();
		this.playerid= playerid;
		this.gameid = gameid;
		gui = new TradeGui(this, playerid);
		otherPlayers =new TradeOtherPlayers(pd);
	}
	
	public void createOffer(int idPlayer, int givesStone, int givesWool, int givesOre, int givesWheat,
			int givesWood, int asksStone, int asksWool, int asksOre, int asksWheat, int asksWood, 
			boolean accepted) {
		new TradeOffer(td, idPlayer, givesStone, givesWool,givesOre,givesWheat,
			 givesWood,asksStone, asksWool,  asksOre, asksWheat, asksWood, 
			accepted);
	}
	
	public void createOffer(int idPlayer, int givesStone, int givesWool, int givesOre, int givesWheat,
			int givesWood, int asksStone, int asksWool, int asksOre, int asksWheat, int asksWood) {
		new TradeOffer(td, idPlayer, givesStone, givesWool,givesOre,givesWheat,
			 givesWood,asksStone, asksWool,  asksOre, asksWheat, asksWood);
	}
	
	public ArrayList<String> getOtherNames(){
		ArrayList<String> names =otherPlayers.getOherPlayerName(gameid, playerid);
		return names;
		
	}

	public void switchPane() {
		gui.setContentPane(new TradeAcceptPane(this, playerid));
		gui.validate();
		gui.repaint();
		
	}

	public void getOffer(){
		td.getTradeOffer(1);
	}
}
