package Controller;

import java.util.ArrayList;

import DAL.BankDAL;
import Model.Bank;
import Model.DevelopmentCard;
import Model.MaterialCard;
import Model.Player;

public class BankController {

	private BankDAL bd;
	private Bank bank;
	@SuppressWarnings("unused")
	private Player player;
	private int gameid;
	private boolean outofcards;

	public BankController(int gameid) {
		bd = new BankDAL();
		bank = new Bank(bd, gameid);

		this.gameid = gameid;

	}

	public void getCards() {
		bank.getCards();
	}

	public void makeCards() {
		bank.addToDB();
	}
	
	public MaterialCard getMaterialCard(String kind, int playerid) {
		MaterialCard card = bank.getMaterialCard(kind);
		return card;
	}

	public void giveMaterialCardBack(MaterialCard materialCard, int playerid) {
		bank.giveMaterialCardBack(materialCard, playerid);

	}

	public DevelopmentCard getDevelopmentCard(int gameid) {
		DevelopmentCard devcard = bank.getDevelopmentCard(gameid);
		return devcard;
	}

	public void trade(int playerid, ArrayList<String> cardkinds) {
		bank.trade(playerid, cardkinds);
	}

	public void deleteCards(ArrayList<String> cardkindsOffer, int playerid) {
		for (int i = 0; i < cardkindsOffer.size(); i++) {
			String cardid = bank.getMaterialCardIdTrade(cardkindsOffer.get(i));
			boolean hasPlayerid = bank.hasPlayerid(cardid);
			if (hasPlayerid == true) {
				bd.deleteCards(cardid, gameid, playerid);
			}
		}
	}

	public MaterialCard checkMaterialCard(String ID) {
		return bank.checkMaterialCard(ID, gameid);
	}

	public boolean isOutofcards(int gameid) {
		if (bd.getidDevcards(gameid)) {
			outofcards = true;
		}
		else {
			outofcards = false;
		}
		return outofcards;
	}

	public void setOutofcards(boolean outofcards) {
		this.outofcards = outofcards;
	}
}