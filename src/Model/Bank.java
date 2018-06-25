package Model;

import java.util.ArrayList;
import java.util.Random;

import DAL.BankDAL;

public class Bank {

	private int gameID;
	private BankDAL bd;
	private ArrayList<DevelopmentCard> devbank = new ArrayList<DevelopmentCard>();
	private ArrayList<MaterialCard> matbank = new ArrayList<MaterialCard>();

	public Bank(BankDAL bd, int gameID) {
		this.bd = bd;
		this.gameID = gameID;
		getCards();
	}

	public void getCards() {
		makeMaterialCards(gameID);
		makeDevCards(gameID);
	}

	private void makeMaterialCards(int gameid) {
		MaterialCard mc;
		for (int a = 1; a < 96; a++) {
			matbank.add(mc = new MaterialCard(bd, gameid));
			mc.setId(a);
			mc.setKindOfMaterial(a);
			if(matbank.get(a - 1).getPlayerid(mc.getIdCard()) != 0) {
				mc.setPlayerid(mc.getIdCard());
			}
			
		}
	}

	public MaterialCard getMaterialCard(String kind) {
		MaterialCard returncard = null;
		for (int i = 0; i < matbank.size(); i++) {
			if (matbank.get(i).getKindOfMaterial().equals(kind)) {
				if (matbank.get(i).getPlayerid(matbank.get(i).getIdCard()) == 0) {
					returncard = matbank.get(i);
					break;
				}
			}
		}
		return returncard;
	}

	public MaterialCard checkMaterialCard(String ID, int gameID) {
		MaterialCard returncard = null;
		matbank.add(returncard = new MaterialCard(bd, gameID));
		returncard.setID(ID);
		char[] splitter = ID.toCharArray();
		returncard.setKindOfMaterialNew(splitter[0]);
		return returncard;
	}

	public void giveMaterialCardBack(MaterialCard card) {
		matbank.add(card);
		bd.deleteCards(card.getIdCard(), gameID);

	}

	private void makeDevCards(int gameid) {
		{
			for (int b = 0; b < 25; b++) {
				devbank.add(new DevelopmentCard(bd, b, gameid));
			}
		}
	}

	public String getMaterialCardId(String kind) {
		for (int i = 0; i < matbank.size(); i++) {
			if (matbank.get(i).getKindOfMaterial().equals(kind)) {
				String id = matbank.get(i).getIdCard();
				if (matbank.get(i).getPlayerid(id) != 0) {
					return id;
				}
			}
		}
		return null;
	}

	public String getMaterialCardIdTrade(String kind) {
		for (int i = 0; i < matbank.size(); i++) {
			if (matbank.get(i).getKindOfMaterial().equals(kind)) {
				String id = matbank.get(i).getIdCard();
				if (matbank.get(i).getPlayerid(id) != 0) {
					return id;
				}
			}
		}
		return null;
	}

	public DevelopmentCard getDevelopmentCard(int gameid) {
		DevelopmentCard returncard = null;
		Random random = new Random();
		int i = random.nextInt(devbank.size());
		String cardid = devbank.get(i).getIdDevCard();
		while (bd.getDevPlayerid(cardid, gameid) != null) {
			
			devbank.remove(i);
			i = random.nextInt(devbank.size());
			cardid = devbank.get(i).getIdDevCard();
			
			
		}
		returncard = devbank.get(i);
		System.out.println(returncard.getIdDevCard());
		return returncard;
	}

	public void printallDevCards() {
		for (int i = 0; i < devbank.size(); i++) {
			System.out.println("Kaart " + i + " van het soort " + devbank.get(i).getKindName());
		}
	}

	public void trade(int playerid, ArrayList<String> cardkinds) {
		for (int i = 0; i < cardkinds.size(); i++) {

			String cardid = getMaterialCardId(cardkinds.get(i));
			bd.trade(playerid, cardid, gameID);
		}

	}

	public boolean hasPlayerid(String cardid) {
		for (int i = 0; i < matbank.size(); i++) {
			if (matbank.get(i).getIdCard().equals(cardid)) {
				if (matbank.get(i).getPlayerid(cardid) != 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void addToDB() {
		for(int i = 0; i < matbank.size(); i++) {
			matbank.get(i).addToDB();
		}
	}
}
