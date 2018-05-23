package Controller;

import DAL.BankDAL;
import DAL.MainDAL;
import DAL.PersonDal;
import Model.Bank;
import Model.DevelopmentCard;
import Model.MaterialCard;
import Model.Player;

public class BankController {
	
	@SuppressWarnings("unused")
	private MainDAL md = new MainDAL();
	private BankDAL bd = new BankDAL();
	private Bank bank;
	@SuppressWarnings("unused")
	private Player player;
	
	public BankController(MainDAL md2) {
		bank = new Bank(bd);
		
	}

	public MaterialCard getMaterialCard(String kind) {
		MaterialCard card = bank.getMaterialCard(kind);
		return card;
	}

	public void giveMaterialCardBack(MaterialCard materialCard) {
		bank.giveMaterialCardBack(materialCard);
		
	}

	public DevelopmentCard getDevelopmentCard() {
		DevelopmentCard devcard =bank.getDevelopmentCard();
		return devcard;
	}

}
