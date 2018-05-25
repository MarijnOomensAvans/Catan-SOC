package Controller;

import DAL.MainDAL;
import DAL.PersonDal;
import Model.DevelopmentCard;
import Model.MaterialCard;
import Model.Player;

public class PlayerController {
	
	private BankController bc;
	@SuppressWarnings("unused")
	private MainDAL md;
	private PersonDal pd;
	
	public PlayerController(MainDAL md, BankController bc, int personid) {
		this.md = md;
		this.bc = bc;
		pd = new PersonDal();
		Player player1 =new Player(this, pd, personid, 1);
		player1.addMaterialCard("W");
	}

	public MaterialCard getMaterialCard(String kind) {
		MaterialCard card =bc.getMaterialCard(kind);
		return card;
	}

	public void giveMaterialCardBack(MaterialCard materialCard) {
		bc.giveMaterialCardBack(materialCard);
		
	}

	public DevelopmentCard getDevelopmentCard() {
		DevelopmentCard devcard =bc.getDevelopmentCard();
		return devcard;
	}

}
