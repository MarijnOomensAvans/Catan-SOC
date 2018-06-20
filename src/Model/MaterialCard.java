package Model;

import DAL.BankDAL;

public class MaterialCard {
	
	private String idCard;
	private String KindOfMaterial;
	private BankDAL bd;
	private int playerid;
	private int gameid;

	public MaterialCard(BankDAL bd, int gameid) {
		this.gameid = gameid;
		this.bd = bd;
		
	}
	
	public void addToDB() {
		bd.addCardstoDB(gameid, idCard);
		
	}

	public void setKindOfMaterial(int a) {
		KindOfMaterial =bd.getKindOfMaterial(a);
		
	}

	public int getPlayerid(String cardid) {
		setPlayerid(cardid);
		return playerid;
	}
	
	public void setPlayerid(String cardid) {
		playerid = Integer.parseInt(bd.getPlayerid(cardid,gameid));
		
	}

	public void setId(int a) {
		idCard =bd.getId(a);
		
	}

	

	public String getKindOfMaterial() {
		return KindOfMaterial;
	}

	public String getIdCard() {
		return idCard;
	}
	
	public void setID(String ID) {
		idCard = ID;
	}

	public void setKindOfMaterialNew(char splitter) {
		String upperCase = "" + splitter;
		KindOfMaterial = upperCase.toUpperCase();
	}



}
