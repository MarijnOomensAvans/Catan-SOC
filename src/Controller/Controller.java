package Controller;

import DAL.BankDAL;
import DAL.MainDAL;
import DAL.PersonDal;
import Model.Bank;
import Model.DevelopmentCard;
import Model.MaterialCard;
import Model.Player;

public class Controller {
	
	@SuppressWarnings("unused")
	private MainDAL md = new MainDAL();
	private BankDAL bd = new BankDAL();
	private PersonDal pd = new PersonDal();
	private Bank bank;
	@SuppressWarnings("unused")
	private Player player;
	
	public Controller() {
		bank = new Bank(bd);
		player = new Player(this, pd);
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
