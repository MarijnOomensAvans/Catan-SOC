package Controller;



import DAL.PersonDal;
import DAL.TradeDAL;

import java.util.ArrayList;

import Model.Player;
import Model.TradeOffer;
import Model.TradeOtherPlayers;
import View.TradeResultPane;
import View.TradeGui;

public class TradeController implements Runnable {

	private TradeDAL td;
	private PersonDal pd;
	private TradeOtherPlayers otherPlayers;
	private int playerid;
	private int gameid;
	private TradeGui gui;
	private Player player;
	
	public TradeController(int playerid, int gameid, PersonDal pd, Player player) {
		this.pd = pd;
		this.td = new TradeDAL();
		this.player = player;
		this.playerid= playerid;
		this.gameid = gameid;
		gui = new TradeGui(this, playerid);
		otherPlayers =new TradeOtherPlayers(pd,td);
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
	
	public String getOtherNames(int otherplayerid1){
		String names =otherPlayers.getOherPlayerName(otherplayerid1);
		return names;
		
	}

	public void switchPane() {
		gui.setContentPane(new TradeResultPane(this, playerid, gameid));
		gui.validate();
		gui.repaint();
		
	}

	public ArrayList<Integer> getOffer(){
		ArrayList<Integer> offer =td.getTradeOffer(1);
		return offer;
	}

	public boolean getResponses(int playerid) {
		boolean responses=otherPlayers.getResponses(playerid);
		return responses;
	}

	public ArrayList<Integer> getOtherid(int gameid, int playerid) {
		ArrayList<Integer> id =otherPlayers.getOtherid(gameid, playerid);
		return id;
	}

	public ArrayList<Integer> getTradeResponses(int playerid) {
		ArrayList<Integer> response = otherPlayers.getTradeResponses(playerid);
		return response;
	}

	public boolean hasStoneCard(int amount) {
		boolean has = player.hasStoneCard(amount);
		return has;
	}

	public boolean hasOreCard(int amount) {
		boolean has = player.hasOreCard(amount);
		return has;
	}
	
	public boolean hasWoodCard(int amount) {
		boolean has = player.hasWoodCard(amount);
		return has;
	}
	public boolean hasWheatCard(int amount) {
		boolean has = player.hasWheatCard(amount);
		return has;
	}
	public boolean hasWoolCard(int amount) {
		boolean has = player.hasWoolCard(amount);
		return has;
	}

	@Override
	public void run() {
		while(true) {
		try {
			ArrayList<Integer> otherIds = pd.getOtherid(gameid, playerid);
			getLatestTradeOffer(otherIds);
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			
		}
		}
	}

	private void getLatestTradeOffer(ArrayList<Integer> otherIds) {
		td.getLatestTradeOffer(otherIds);
		
	}
}
