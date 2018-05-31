package Controller;

import DAL.MainDAL;
import DAL.PersonDAL;
import Model.DevelopmentCard;
import Model.MaterialCard;
import Model.Player;

public class PlayerController {
	
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
	
}


