package Controller;

import DAL.MainDAL;
import DAL.PersonDAL;
import Model.DevelopmentCard;
import Model.MaterialCard;
import Model.Player;

public class PlayerController {
	private Player player;
	private BankController bc;
	@SuppressWarnings("unused")
	private MainDAL md;
	private PersonDAL pd;
	
	public PlayerController(MainDAL md, BankController bc,int personid) {
		this.md = md;
		this.bc = bc;
		pd = new PersonDAL();
		Player player1 =new Player(this, pd, 41, 770);

//		Player player2 =new Player(this, pd, 42, 770);
		
	}

	public MaterialCard getMaterialCard(String kind) {
		MaterialCard card =bc.getMaterialCard(kind);
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

	
}


