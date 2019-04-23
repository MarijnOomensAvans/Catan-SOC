package Model;

import DAL.BankDAL;

public class DevelopmentCard {
	
	private String kindName; 
	private String idDevCard;
	private BankDAL bd;
	
	
	public DevelopmentCard(BankDAL bd, int b, int gameid) {
		this.bd = bd;
		setIddevcard(b);
		setKindName(b);
		addDevCardToDB(gameid); //developmentcards get created and added to database
	}
	private void addDevCardToDB(int gameid) {
		bd.addDevCardstoDB(gameid, idDevCard);
	}
	private void setKindName(int b) {
		this.kindName = bd.getDevName(b);
	}


	private void setIddevcard(int b) {
		this.idDevCard = bd.getDevId(b);
	}
	
	public String getKindName() {
		return kindName;
	}
	public String getIdDevCard() {
		return idDevCard;
	}



}
