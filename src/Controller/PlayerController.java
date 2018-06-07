package Controller;

import java.util.ArrayList;

import DAL.PersonDAL;
import Model.DevelopmentCard;
import Model.MaterialCard;
import Model.Player;

public class PlayerController {
	private Player player;
	private BankController bc;
	private PersonDAL db;
	private int playerID;

	public PlayerController(int playerID, int gameID, BankController bc, PersonDAL pd) {
		this.bc = bc;
		this.db = pd;
		this.playerID = playerID;
		player = new Player(this, db, playerID, gameID);
	}

	public Player getPlayer() {
		return player;
	}

	public MaterialCard getMaterialCard(String kind, int playerid) {
		MaterialCard card = bc.getMaterialCard(kind, playerid);
		return card;
	}

	public void giveMaterialCardBack(MaterialCard materialCard) {
		bc.giveMaterialCardBack(materialCard);

	}

	public DevelopmentCard getDevelopmentCard(String iddevcard, int gameid) {
		DevelopmentCard devcard = bc.getDevelopmentCard(iddevcard, gameid);
		return devcard;
	}

	public int getAmountRidder(int playerid) {
		int amountofRidder = db.amountDeveloperCards(playerid, false, "___r");
		return amountofRidder;
	}

	public int getAmountStratenbouw(int playerid) {
		int amountofStratenbouw = db.amountDeveloperCards(playerid, false, "___s");
		return amountofStratenbouw;
	}

	public int getAmountMonopolie(int playerid) {
		int amountofMonopolie = db.amountDeveloperCards(playerid, false, "___m");
		return amountofMonopolie;
	}

	public int getAmountUitvinding(int playerid) {
		int amountofUitvinding = db.amountDeveloperCards(playerid, false, "___u");
		return amountofUitvinding;
	}

	public int getAmountKathedraal(int playerid) {
		int amountofKathedraal = db.amountDeveloperCards(playerid, false, "__1g");
		return amountofKathedraal;

	}

	public int getAmountParlement(int playerid) {
		int amountofParlement = db.amountDeveloperCards(playerid, false, "__5g");
		return amountofParlement;
	}

	public int getAmountMarkt(int playerid) {
		int amountofMarkt = db.amountDeveloperCards(playerid, false, "__2g");
		return amountofMarkt;
	}

	public int getAmountBibliotheek(int playerid) {
		int amountofBibliotheek = db.amountDeveloperCards(playerid, false, "__3g");
		return amountofBibliotheek;
	}

	public int getAmountUniversiteit(int playerid) {
		int amountUniversiteit = db.amountDeveloperCards(playerid, false, "__4g");
		return amountUniversiteit;
	}

	public boolean hasStoneCards(int amount) {
		return player.hasStoneCard(amount);
	}

	public boolean hasOreCards(int amount) {
		return player.hasOreCard(amount);
	}

	public boolean hasWoodCards(int amount) {
		return player.hasWoodCard(amount);
	}

	public boolean hasWoolCards(int amount) {
		return player.hasWoolCard(amount);
	}

	public boolean hasWheatCards(int amount) {
		return player.hasWheatCard(amount);
	}
	

	public void tradeCards(int otherplayerid, ArrayList<Integer> offer, Player player) {
		player.updateCards(otherplayerid, offer);

	}
	public void useRidder(int playerid) {
		db.useDevelopmentCard("___r", playerid);
	}

	public void useMonopolie(int playerid) {
		db.useDevelopmentCard("___m", playerid);
		
	}

	public void useStratenbouw(int playerid) {
		db.useDevelopmentCard("___s", playerid);
	}
	public void useUitvinding(int playerid) {
		db.useDevelopmentCard("___u", playerid);
	}

	public String getMaterialCards(int i) {
		return db.getMaterialCards(playerID, i);
	}

	public int countMaterialCards() {
		return db.countMaterialCards(playerID);
	}

	public MaterialCard checkMaterialCard(String ID) {
		return bc.checkMaterialCard(ID);
	}

	public void buildObject(String buildingType, int idspel, String hlPoint) {
		String pieceID;
		if (buildingType.equals("Village")) {
			pieceID = "d0";
			String[] keys = db.getBuilding(playerID, pieceID).split(",");
			String[] coords = hlPoint.split(",");
			if (keys.length != 5) {
				switch (keys.length) {
				case 0:
					db.setBuilding("d01", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 1:
					db.setBuilding("d02", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 2:
					db.setBuilding("d03", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 3:
					db.setBuilding("d04", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 4:
					db.setBuilding("d05", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;

				}
			}
		} else if (buildingType.equals("City")) {
			 pieceID = "c0";
			String[] keys = db.getBuilding(playerID, pieceID).split(",");
			String[] coords = hlPoint.split(",");
			if (keys.length != 4) {
				switch (keys.length) {
				case 0:
					db.setBuilding("c01", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 1:
					db.setBuilding("c02", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 2:
					db.setBuilding("c03", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 3:
					db.setBuilding("c04", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;

				}
			}
		} else if (buildingType.equals("Street")) {
			 pieceID = "r";
			String[] keys = db.getBuilding(playerID, pieceID).split(",");
			String[] coords = hlPoint.split(",");
			if (keys.length != 5) {
				switch (keys.length) {
				case 1:
					db.setBuilding("r01", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 2:
					db.setBuilding("r02", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 3:
					db.setBuilding("r03", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 4:
					db.setBuilding("r04", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 5:
					db.setBuilding("r05", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 6:
					db.setBuilding("r06", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 7:
					db.setBuilding("r07", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 8:
					db.setBuilding("r08", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 9:
					db.setBuilding("r09", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 10:
					db.setBuilding("r010", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 11:
					db.setBuilding("r011", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 12:
					db.setBuilding("r012", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 13:
					db.setBuilding("r013", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 14:
					db.setBuilding("r014", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 15:
					db.setBuilding("r015", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;

				}
			}
		}

	}
}
