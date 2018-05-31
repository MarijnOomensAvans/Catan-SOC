package Controller;

import DAL.MainDAL;
import DAL.PersonDal;
import Model.DevelopmentCard;
import Model.MaterialCard;

public class PlayerController {
	
	private BankController bc;
	@SuppressWarnings("unused")
	private MainDAL md;
	private PersonDal pd;
	

	public PlayerController(MainDAL md,PersonDal pd, BankController bc,int personid) {

		this.md = md;
		this.bc = bc;
		this.pd = pd;
		//Player player1 =new Player(this, pd, personid, 1);
		//player1.addMaterialCard("W");
	}

	public MaterialCard getMaterialCard(String kind, int playerid) {
		MaterialCard card =bc.getMaterialCard(kind,playerid);
		return card;
	}

	public void giveMaterialCardBack(MaterialCard materialCard) {
		bc.giveMaterialCardBack(materialCard);
		
	}

	public DevelopmentCard getDevelopmentCard() {
		DevelopmentCard devcard =bc.getDevelopmentCard();
		return devcard;
	}

	public void tradeCards(int otherplayerid) {
		
		
	}

}
