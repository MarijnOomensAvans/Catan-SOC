package Controller;

import java.util.ArrayList;

import Model.DevelopmentCard;
import Model.MaterialCard;
import Model.Player;

public class PlayerController {
	private Player player;
	private BankController bc;
	

	public PlayerController(BankController bc,int personid) {
		this.bc = bc;
	}

	public MaterialCard getMaterialCard(String kind, int playerid) {
		MaterialCard card =bc.getMaterialCard(kind,playerid);
		return card;
	}

	public void giveMaterialCardBack(MaterialCard materialCard) {
		bc.giveMaterialCardBack(materialCard);
		
	}

	public DevelopmentCard getDevelopmentCard(String iddevcard) {
		DevelopmentCard devcard =bc.getDevelopmentCard(iddevcard);
		return devcard;
	}
	public boolean hasKnightCard(int amount) {
		boolean has = player.hasKnightCard(amount);
		return has;
	}
	public boolean hasStratenBouw(int amount) {
		boolean has = player.hasStratenBouw(amount);
		return has;
	}
	public boolean hasMonopolie(int amount) {
		boolean has = player.hasMonopolie(amount);
		return has;
	}
	public boolean hasUitvinding(int amount) {
		boolean has = player.hasUitvinding(amount);
		return has;
	}
	public boolean hasKathedraal(int amount) {
		boolean has = player.hasKathedraal(amount);
		return has;
		
	}
	public boolean hasParlement(int amount) {
		boolean has = player.hasParlement(amount);
		return has;
	}
	public boolean hasMarkt(int amount) {
		boolean has = player.hasMarkt(amount);
		return has;
	}
	public boolean hasBibliotheek(int amount) {
		boolean has = player.hasBibliotheek(amount);
		return has;
	}
	public boolean hasUniversiteit(int amount) {
		boolean has = player.hasUniversiteit(amount);
		return has;
	}



	public DevelopmentCard getDevelopmentCard() {
		DevelopmentCard devcard =bc.getDevelopmentCard();
		return devcard;
	}

	public void tradeCards(int otherplayerid, ArrayList<Integer> offer, Player player) {
		player.updateCards(otherplayerid,offer);

		
	}

}
