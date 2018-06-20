package Controller;

import java.util.ArrayList;

import DAL.BankDAL;
import DAL.MainDAL;
import Model.Bank;
import Model.DevelopmentCard;
import Model.MaterialCard;
import Model.Player;

public class BankController {

	@SuppressWarnings("unused")
	private BankDAL bd;
	private Bank bank;
	@SuppressWarnings("unused")
	private Player player;
	private int gameid;

	public BankController(int gameid) {
		bd = new BankDAL();
		bank = new Bank(bd, gameid);

		this.gameid = gameid;

	}

	public void makeCards() {
		bank.getCards();
	}

	public MaterialCard getMaterialCard(String kind, int playerid) {
		MaterialCard card = bank.getMaterialCard(kind);
		return card;
	}

	public void giveMaterialCardBack(MaterialCard materialCard) {
		bank.giveMaterialCardBack(materialCard);

	}

	public DevelopmentCard getDevelopmentCard(int playerid) {
		DevelopmentCard devcard = bank.getDevelopmentCard();
		return devcard;
	}

	public void trade(int playerid, ArrayList<String> cardkinds) {
		bank.trade(playerid, cardkinds);
	}

	public void deleteCards(ArrayList<String> cardkindsOffer) {
		for (int i = 0; i < cardkindsOffer.size(); i++) {
			String cardid = bank.getMaterialCardIdTrade(cardkindsOffer.get(i));
			boolean hasPlayerid = bank.hasPlayerid(cardid);
			if (hasPlayerid == true) {
				bd.deleteCards(cardid, gameid);
			}
		}
	}

	public MaterialCard checkMaterialCard(String ID) {
		return bank.checkMaterialCard(ID, gameid);
	}
}