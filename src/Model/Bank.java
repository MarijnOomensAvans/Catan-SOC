package Model;


import java.util.ArrayList;
import java.util.Random;

import DAL.BankDAL;

public class Bank {
	
	private BankDAL bd;
	private ArrayList<DevelopmentCard> devbank = new ArrayList <DevelopmentCard>();
	private ArrayList<MaterialCard> matbank = new ArrayList <MaterialCard>();
	
	public Bank(BankDAL bd, int gameid) {
		this.bd = bd;
		makeMaterialCards(gameid);
		makeDevCards();
	}
	
	private void makeMaterialCards(int gameid) {
			for(int a=1; a<96; a++) {
				matbank.add(new MaterialCard(bd,a,gameid));
			}
		
		
	}
	public MaterialCard getMaterialCard(String kind) {
		MaterialCard returncard = null;
		for(int i=0; i<matbank.size(); i++) {
			if(matbank.get(i).getKindOfMaterial().equals(kind)) {
				if(matbank.get(i).getPlayerid(matbank.get(i).getIdCard())== null) {;
				returncard = matbank.get(i);
				break;}
			}
		}
		return returncard;
	}
	
	public void giveMaterialCardBack(MaterialCard card) {
		matbank.add(card);
		
	}
	public String getMaterialCardId(String kind) {
		for(int i=0; i<matbank.size(); i++) {
			if(matbank.get(i).getKindOfMaterial().equals(kind)) {
				String id =matbank.get(i).getIdCard();
				if(matbank.get(i).getPlayerid(id)== null) {
					return id;
				}
			}
	}
		return null;}
	
	public String getMaterialCardIdTrade(String kind) {
		for(int i=0; i<matbank.size(); i++) {
			if(matbank.get(i).getKindOfMaterial().equals(kind)) {
				String id =matbank.get(i).getIdCard();
				if(matbank.get(i).getPlayerid(id)!= null) {
					return id;
				}
			}
	}
		return null;}

	private void makeDevCards() {
		for(int b=0; b<25; b++) {
			devbank.add(new DevelopmentCard(bd, b));
		}
	}
	public DevelopmentCard getDevelopmentCard() {
		Random random = new Random();
		int number =random.nextInt(devbank.size());
		return devbank.get(number);
	}
	

	
	public void printallDevCards() {
		for(int i=0; i<devbank.size(); i++) {
			System.out.println("Kaart " + i +" van het soort " + devbank.get(i).getKindName());
		}
	}

	public void trade(int playerid, ArrayList<String> cardkinds) {
		for(int i=0; i<cardkinds.size(); i++) {
			
		String cardid =getMaterialCardId(cardkinds.get(i));
		bd.trade(playerid,cardid);
		}
		
	}

	public boolean hasPlayerid(String cardid) {
		for(int i =0; i< matbank.size(); i++) {
			if(matbank.get(i).getIdCard().equals(cardid)) {
				if(matbank.get(i).getPlayerid(cardid) != null) {
					return true;
				}
			}
		}
		return false;
	}
	}


