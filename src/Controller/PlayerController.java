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
	
<<<<<<< HEAD
	public PlayerController(MainDAL md, BankController bc, int personid) {
=======
	public PlayerController(MainDAL md,PersonDal pd, BankController bc,int personid) {
>>>>>>> e2420f1ab03af08306872bf1fc96d6cd570a0a6b
		this.md = md;
		this.bc = bc;
		this.pd = pd;
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
