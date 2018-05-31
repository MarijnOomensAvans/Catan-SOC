package Controller;

import DAL.BankDAL;
import DAL.MainDAL;
import Model.Bank;
import Model.DevelopmentCard;
import Model.MaterialCard;
import Model.Player;

public class BankController {
	
	@SuppressWarnings("unused")
	private MainDAL md;
	private BankDAL bd;
	private Bank bank;
	@SuppressWarnings("unused")
	private Player player;
	
	public BankController(MainDAL md) {
		this.md = md;
		bd = new BankDAL();
		bank = new Bank(bd);
		
	}

	public MaterialCard getMaterialCard(String kind) {
		MaterialCard card = bank.getMaterialCard(kind);
		return card;
	}

	public void giveMaterialCardBack(MaterialCard materialCard) {
		bank.giveMaterialCardBack(materialCard);
		
	}

	public DevelopmentCard getDevelopmentCard(String iddevcard) {
		DevelopmentCard devcard =bank.getDevelopmentCard();
		return devcard;
	}
}