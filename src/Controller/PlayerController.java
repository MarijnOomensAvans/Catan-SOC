package Controller;

import java.util.ArrayList;

import DAL.PersonDAL;
import Model.DevelopmentCard;
import Model.MaterialCard;
import Model.Player;

public class PlayerController {
	private Player player;
	private BankController bc;
	private PersonDAL db;
	private int playerID;

	public PlayerController(int playerID, int gameID,BankController bc, PersonDAL pd ) {
		this.bc =bc;
		this.db = pd;
		this.playerID = playerID;
		player = new Player(this, db, playerID, gameID);
	}

	public Player getPlayer() {
		return player;
	}

	public MaterialCard getMaterialCard(String kind, int playerid) {
		MaterialCard card =bc.getMaterialCard(kind,playerid);
		return card;
	}

	public void giveMaterialCardBack(MaterialCard materialCard) {
		bc.giveMaterialCardBack(materialCard);
		
	}

	public DevelopmentCard getDevelopmentCard(String iddevcard, int gameid) {
		DevelopmentCard devcard =bc.getDevelopmentCard(iddevcard, gameid);
		return devcard;
	}
	public int getAmountRidder(int playerid) {
		int amountofRidder = db.amountDeveloperCards(playerid, false, "___r");
		return amountofRidder;
	}
	public int getAmountStratenbouw(int playerid) {
		int amountofStratenbouw = db.amountDeveloperCards(playerid, false, "___s");
		return amountofStratenbouw;
	}
	public int getAmountMonopolie(int playerid) {
		int amountofMonopolie = db.amountDeveloperCards(playerid, false, "___m");
		return amountofMonopolie;
	}
	public int getAmountUitvinding(int playerid) {
		int amountofUitvinding = db.amountDeveloperCards(playerid, false, "___u");
		return amountofUitvinding;
	}
	public int getAmountKathedraal(int playerid) {
		int amountofKathedraal = db.amountDeveloperCards(playerid, false, "__1g");
		return amountofKathedraal;
		
	}
	public int getAmountParlement(int playerid) {
		int amountofParlement = db.amountDeveloperCards(playerid, false, "__5g");
		return amountofParlement;
	}
	public int getAmountMarkt(int playerid) {
		int amountofMarkt = db.amountDeveloperCards(playerid, false, "__2g");
		return amountofMarkt;
	}
	public int getAmountBibliotheek(int playerid) {
		int amountofBibliotheek = db.amountDeveloperCards(playerid, false, "__3g");
		return amountofBibliotheek;
	}
	public int getAmountUniversiteit(int playerid) {
		int amountUniversiteit = db.amountDeveloperCards(playerid, false, "__4g");
		return amountUniversiteit;
	}
	
	public boolean hasStoneCards(int amount) {
		return player.hasStoneCard(amount);
	}
	
	public boolean hasOreCards(int amount) {
		return player.hasOreCard(amount);
	}
	
	public boolean hasWoodCards(int amount) {
		return player.hasWoodCard(amount);
	}
	
	public boolean hasWoolCards(int amount) {
		return player.hasWoolCard(amount);
	}
	
	public boolean hasWheatCards(int amount) {
		return player.hasWheatCard(amount);
	}


	public void tradeCards(int otherplayerid, ArrayList<Integer> offer, Player player) {
		player.updateCards(otherplayerid,offer);

		
	}

	public String getMaterialCards() {
		return db.getMaterialCards(playerID);
	}

}
