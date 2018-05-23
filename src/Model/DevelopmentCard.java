package Model;

import DAL.BankDAL;

public class DevelopmentCard {
	
	private String kindName;
	private String iddevcard;
	private BankDAL bd;

	
	private int kind;
	
	public DevelopmentCard(BankDAL bd, int b) {
		this.bd = bd;
		setIddevcard(b);
		setKindName(b);
	}
	private void setKindName(int b) {
		this.kindName = bd.getDevName(b);
	}


	private void setIddevcard(int b) {
		this.iddevcard = bd.getDevId(b);
	}

	public int getKind() {
		return kind;
	}
	
	public String getKindName() {
		return kindName;
	}
	public String getIddevcard() {
		return iddevcard;
	}



}
