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
<<<<<<< HEAD
//		bd.checkDevCards(777);
=======
		this.gameid = gameid;
>>>>>>> 0a2bdb7734fd5566d68384762faab7e64b7d9b15
		
	}
	
	public void makeCards() {
		bank.makeCards();
	}

	public MaterialCard getMaterialCard(String kind, int playerid) {
		MaterialCard card = bank.getMaterialCard(kind);
		return card;
	}

	public void giveMaterialCardBack(MaterialCard materialCard) {
		bank.giveMaterialCardBack(materialCard);
		
	}

	public DevelopmentCard getDevelopmentCard(String iddevcard, int playerid) {
		DevelopmentCard devcard =bank.getDevelopmentCard(iddevcard);
		return devcard;
	}


	public void trade(int playerid, ArrayList<String> cardkinds) {
		bank.trade(playerid,cardkinds);
		
	}

	public void deleteCards(int playerid2, ArrayList<String> cardkindsOffer) {
		for(int i=0; i< cardkindsOffer.size(); i++) {
			String cardid =bank.getMaterialCardIdTrade(cardkindsOffer.get(i));
			boolean hasPlayerid = bank.hasPlayerid(cardid);
			if(hasPlayerid == true) {
				bd.deleteCards(playerid2, cardid);
			}
		}
		
	}

	public MaterialCard checkMaterialCard(String ID) {
		return bank.checkMaterialCard(ID, gameid);
	}
}