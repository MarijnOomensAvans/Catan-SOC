package Model;

<<<<<<< HEAD
=======

>>>>>>> ruilen
import DAL.BankDAL;

public class MaterialCard {
	
	private String idCard;
	private String KindOfMaterial;
	private BankDAL bd;
<<<<<<< HEAD

	public MaterialCard(BankDAL bd, int a) {
		this.bd = bd;
		setId(a);
		setKindOfMaterial(a);
	}
	
=======
	private String playerid;


	public MaterialCard(BankDAL bd, int a, int gameid) {
		this.bd = bd;
		setId(a);
		setKindOfMaterial(a);
		//addToDB(gameid);
	}
	
	private void addToDB(int gameid) {
		bd.addCardstoDB(gameid, idCard);
		
	}

>>>>>>> ruilen
	private void setKindOfMaterial(int a) {
		KindOfMaterial =bd.getKindOfMaterial(a);
		
	}

<<<<<<< HEAD
	
=======
	public String getPlayerid(String cardid) {
		setPlayerid(cardid);
		return playerid;
	}
	
	private void setPlayerid(String cardid) {
		playerid =bd.getPlayerid(cardid);
		
	}

>>>>>>> ruilen
	private void setId(int a) {
		idCard =bd.getId(a);
		
	}

	

	public String getKindOfMaterial() {
		return KindOfMaterial;
	}

	public String getIdCard() {
		return idCard;
	}



}
