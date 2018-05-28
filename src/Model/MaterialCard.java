package Model;

import DAL.BankDAL;

public class MaterialCard {
	
	private String idCard;
	private String KindOfMaterial;
	private BankDAL bd;
	private int playerid;

	public MaterialCard(BankDAL bd, int a) {
		this.bd = bd;
		setId(a);
		setKindOfMaterial(a);
	}
	
	private void setKindOfMaterial(int a) {
		KindOfMaterial =bd.getKindOfMaterial(a);
		
	}

	
	private void setId(int a) {
		idCard =bd.getId(a);
		
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}

	public String getKindOfMaterial() {
		return KindOfMaterial;
	}

	public String getIdCard() {
		return idCard;
	}



}
