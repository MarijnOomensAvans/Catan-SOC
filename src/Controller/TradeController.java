package Controller;

import DAL.PersonDAL;
import DAL.TradeDAL;

import java.util.ArrayList;
import java.util.Observable;

import Model.Player;
import Model.TradeOffer;
import Model.TradeOtherPlayers;
import View.trade.BankPane;
import View.trade.TradeAcceptPane;
import View.trade.TradeGui;
import View.trade.TradeOfferPane;
import View.trade.TradeResultPane;

public class TradeController extends Observable implements Runnable {

	private TradeDAL td;
	private PersonDAL pd;
	private TradeOtherPlayers otherPlayers;
	private int playerid;
	private int gameid;
	private int noOffers;
	private TradeGui gui;
	@SuppressWarnings("unused")
	private Player player;
	private TradeOfferPane top;
	private TradeAcceptPane tap;
	private TradeResultPane trp;
	private BankPane bp;
	private Thread t1;
	private PlayerController pc;
	private BankController bc;
	private IngameController igc;

	private ArrayList<Integer> otherIds;
	private boolean runthread = true;

	public TradeController(int playerid, int gameid, PersonDAL pd, Player player, PlayerController pc,
			BankController bc, IngameController igc) {
		this.pd = pd;
		this.td = new TradeDAL();
		this.bc = bc;
		this.player = player;
		this.playerid = playerid;
		this.gameid = gameid;
		this.pc = pc;
		otherIds = pd.getOtherid(gameid, playerid);
		t1 = new Thread(this);
		t1.start();
		otherPlayers = new TradeOtherPlayers(pd);
		this.igc = igc;

	}

	public void createGUI(String pane) {
		if (pane == "top") {
			top = new TradeOfferPane(this, playerid, true);
			gui = new TradeGui(this, playerid, top, gameid);
		} else if (pane == "tap") {
			tap = new TradeAcceptPane(this, playerid);
			gui = new TradeGui(this, playerid, tap, gameid);
		}
	}

	public void removeTRP() {
		this.trp = null;
	}

	// public void removeTAP()
	// {
	// this.tap = null;
	// }

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
		boolean responses = td.getResponses(playerid);
		return responses;
	}

	public ArrayList<Integer> getOtherid(int gameid, int playerid) {
		ArrayList<Integer> id = pd.getOtherid(gameid, playerid);
		return id;
	}

	public ArrayList<Integer> getTradeResponses(int playerid) {
		ArrayList<Integer> response = td.getTradeResponses(playerid);
		return response;
	}

	public boolean hasStoneCard(int amount) {
		if(pc.getAmountStone(playerid) >= amount) {
			return true;
		} else {
			return false;
		}
		/*boolean has = player.hasStoneCard(amount);
		return has;*/
	}

	public boolean hasOreCard(int amount) {
		if(pc.getAmountOre(playerid) >= amount) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasWoodCard(int amount) {
		if(pc.getAmountWood(playerid) >= amount) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasWheatCard(int amount) {
		if(pc.getAmountWheat(playerid) >= amount) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasWoolCard(int amount) {
		if(pc.getAmountWool(playerid) >= amount) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void run() {
		while (runthread) {
			try {
				for (int i = 0; i < otherIds.size(); i++) {
					getLatestTradeOffer(otherIds.get(i));
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	private void getLatestTradeOffer(int playerid) {
		ArrayList<Integer> offer = td.getTradeResponses(playerid);
		if (trp != null) {
			if (offer.size() != 0) {
				if (playerid == otherIds.get(0)) {
					trp.setResponse1();
				} else if (playerid == otherIds.get(1)) {
					trp.setResponse2();
				} else if (playerid == otherIds.get(2)) {
					trp.setResponse3();
				}
			}
		} else if (tap == null) {
			if (offer.size() != 0) {
				createGUI("tap");
				this.addObserver(tap);
				this.setChanged();
				this.notifyObservers(offer);
			}
		} else if (tap != null) {
			if (offer.size() == 0) {
				noOffers++;
				if (noOffers == 3) {
					this.close();
					this.deleteObserver(tap);
				}
			} else {
				noOffers = 0;
			}
		}
	}

	public String getUsername(int playerid) {
		String username = pd.getName(playerid);
		return username;
	}

	public void switchBankPane() {
		bp = new BankPane(this, playerid);
		gui.setContentPane(bp);
		gui.validate();
		gui.repaint();
	}

	public void setRunthread(boolean runthread) {
		this.runthread = runthread;
	}

	public void close() {
		if (this.trp != null) {
			gui.dispose();
			this.trp = null;
			this.deleteOffers(playerid, otherIds.get(0), otherIds.get(1), otherIds.get(2));
		}
		else if (this.tap != null) {
			gui.dispose();
			this.tap = null;
		}
		else if (this.bp != null) {
			gui.dispose();
			this.bp = null;
		}
		else if (this.top != null) {
			gui.dispose();
			this.top = null;
		}
	}

	public TradeResultPane getTRP() {
		return trp;
	}

	public TradeOfferPane getTOP() {
		return top;
	}

	public BankPane getBP() {
		return bp;
	}

	public void tradeCards(int otherplayerid) {
		ArrayList<Integer> offer = td.getTradeOffer(otherplayerid);
		pc.tradeCards(otherplayerid, offer);

	}

	public void deleteOffers(int playerid, int otherplayerid1, int otherplayerid2, int otherplayerid3) {
		td.deleteOffers(playerid, otherplayerid1, otherplayerid2, otherplayerid3);

	}

	public void tradeBank(int playerid, ArrayList<String> cardkinds) {
		bc.trade(playerid, cardkinds);

	}

	public void deleteCards(ArrayList<String> cardkindsOffer, int playerid) {
		bc.deleteCards(cardkindsOffer, playerid);

	}

	public void setTradeButton(boolean enable) {
		igc.setTradeButton(enable);
	}

	public boolean hasCards(ArrayList<Integer> playercounterbid) {
		if (pc.getAmountStone(playerid) >= playercounterbid.get(6)) {
			if (pc.getAmountOre(playerid) >= playercounterbid.get(8)) {
				if (pc.getAmountWheat(playerid) >= playercounterbid.get(9)) {
					if (pc.getAmountWool(playerid) >= playercounterbid.get(7)) {
						if (pc.getAmountWood(playerid) >=playercounterbid.get(10)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
