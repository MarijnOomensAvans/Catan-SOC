package Model;

import DAL.BankDAL;

public class MaterialCard {
	
	private String idCard;
	private String KindOfMaterial;
	private BankDAL bd;

	public MaterialCard(BankDAL bd, int a, int gameid) {
		this.bd = bd;
		setId(a);
		setKindOfMaterial(a);
		addToDB(gameid);
	}
	
	private void addToDB(int gameid) {
		bd.addCardstoDB(gameid, idCard);
		
	}

	private void setKindOfMaterial(int a) {
		KindOfMaterial =bd.getKindOfMaterial(a);
		
	}

	
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
