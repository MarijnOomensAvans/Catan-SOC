package Controller;

import DAL.PersonDal;
import DAL.TradeDAL;

import java.util.ArrayList;
import java.util.Observable;


import Model.Player;
import Model.TradeOffer;
import Model.TradeOtherPlayers;
import View.TradeResultPane;
import View.BankPane;
import View.TradeAcceptPane;
import View.TradeGui;
import View.TradeOfferPane;

public class TradeController extends Observable implements Runnable {

	private TradeDAL td;
	private PersonDal pd;
	private TradeOtherPlayers otherPlayers;
	private int playerid;
	private int gameid;
	private TradeGui gui;
	private Player player;
	private TradeAcceptPane tap;
	private TradeResultPane trp;
	private Thread t1;
	private PlayerController pc;

	private ArrayList<Integer> otherIds;
	private boolean runthread = false;
	
	public TradeController(int playerid, int gameid, PersonDal pd, Player player, PlayerController pc) {
		this.pd = pd;
		this.td = new TradeDAL();
		this.player = player;
		this.playerid = playerid;
		this.gameid = gameid;
		this.pc = pc;
		otherIds = pd.getOtherid(gameid, playerid);
		t1 = new Thread(this);
		t1.start();
		tap = new TradeAcceptPane(this, playerid);
		TradeOfferPane top = new TradeOfferPane(this, playerid, true);
		gui = new TradeGui(this, playerid, top);
		
		otherPlayers = new TradeOtherPlayers(pd, td);
		this.addObserver(tap);
	}

	public void createOffer(int idPlayer, int givesStone, int givesWool, int givesOre, int givesWheat, int givesWood,
			int asksStone, int asksWool, int asksOre, int asksWheat, int asksWood, boolean accepted) {
		new TradeOffer(td, idPlayer, givesStone, givesWool, givesOre, givesWheat, givesWood, asksStone, asksWool,
				asksOre, asksWheat, asksWood, accepted);
	}

	public void createOffer(int idPlayer, int givesStone, int givesWool, int givesOre, int givesWheat, int givesWood,
			int asksStone, int asksWool, int asksOre, int asksWheat, int asksWood) {
		new TradeOffer(td, idPlayer, givesStone, givesWool, givesOre, givesWheat, givesWood, asksStone, asksWool,
				asksOre, asksWheat, asksWood);
	}

	public String getOtherNames(int otherplayerid1) {
		String names = otherPlayers.getOherPlayerName(otherplayerid1);
		return names;

	}

	public void switchPane() {
		trp = new TradeResultPane(this, playerid, gameid);
		gui.setContentPane(trp);
		gui.validate();
		gui.repaint();
	}

	public void switchCounterOffer() {
		gui.setContentPane(new TradeOfferPane(this, playerid, false));
		gui.validate();
		gui.repaint();
	}

	public ArrayList<Integer> getOffer() {
		ArrayList<Integer> offer = td.getTradeOffer(1);
		return offer;
	}

	public boolean getResponses(int playerid) {
		boolean responses = otherPlayers.getResponses(playerid);
		return responses;
	}

	public ArrayList<Integer> getOtherid(int gameid, int playerid) {
		ArrayList<Integer> id = otherPlayers.getOtherid(gameid, playerid);
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
		while (runthread ==true) {
			try {			
				for(int i = 0; i<otherIds.size(); i++)
				{
					getLatestTradeOffer(otherIds.get(i));
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	private void getLatestTradeOffer(int playerid) {
		ArrayList<Integer> offer = td.getTradeResponses(playerid);
		if (offer.size() != 0 && trp != null) {
			if(playerid == otherIds.get(0))
			{
				trp.setResponse1();
			}
			
			else if(playerid == otherIds.get(1))
			{
				trp.setResponse2();
			}
			
			else if(playerid == otherIds.get(2))
			{
				trp.setResponse3();
			}
		}
		this.setChanged();
		this.notifyObservers(offer);
	}

	public String getUsername(int playerid) {
		String username =pd.getName(playerid);
		return username;
	}

	public void switchBankPane() {
		gui.setContentPane(new BankPane(this, playerid));
		gui.validate();
		gui.repaint();
		
	}

	public void setRunthread(boolean runthread) {
		this.runthread = runthread;
	}

	public void close() {
		gui.dispose();
		
	}

	public void tradeCards(int otherplayerid) {
		ArrayList<Integer> offer =td.getTradeOffer(otherplayerid);
		pc.tradeCards(otherplayerid,offer,player);
		
	}

	public void deleteOffers(int playerid, int otherplayerid1, int otherplayerid2, int otherplayerid3) {
		td.deleteOffers(playerid, otherplayerid1,otherplayerid2,otherplayerid3);
		
	}
}