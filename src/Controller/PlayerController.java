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
	private int gameID;
	private String[] playerIDs;

	public PlayerController(int playerID, int gameID, BankController bc, PersonDAL pd) {
		this.bc = bc;
		this.db = pd;
		this.gameID = gameID;
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

	// ------------------------------------------------------------------------------------------------------------------------
	// Getamount for development cards
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

	// -------------------------------------------------------------------------------------------------------
	// Getamount for resource cards

	public int getAmountStone(int playerid) {
		return db.amountResourceCards(playerid, "b%");
	}

	public int getAmountOre(int playerid) {
		return db.amountResourceCards(playerid, "e%");
	}

	public int getAmountWood(int playerid) {
		return db.amountResourceCards(playerid, "h%");
	}

	public int getAmountWool(int playerid) {
		return db.amountResourceCards(playerid, "w%");
	}

	public int getAmountWheat(int playerid) {
		return db.amountResourceCards(playerid, "g%");
	}

	// ------------------------------------------------------------------------------------------------------

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

	public void tradeCards(int otherplayerid, ArrayList<Integer> offer) {
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

	public boolean emptySpace(String buildingType, String hlPoint) {
		String pieceID;
		int x;
		int y;
		int x2;
		int y2;
		boolean canBuild = false;
		if (buildingType.equals("Village")) {
			pieceID = "d0";
		} else if (buildingType.equals("City")) {
			pieceID = "c0";
		} else {
			pieceID = "r";
		}
		String[] allBuild = db.getBuilding(playerID, pieceID).split(",");
		String[] coords = hlPoint.split(",");
		x = Integer.parseInt(coords[0]);
		y = Integer.parseInt(coords[1]);
		for (int i = 0; i < (allBuild.length); i++) {
			String xs = "x_van";
			String ys = "y_van";
			String[] xcoords = db.getCoords(playerID, allBuild[(i)], xs).split(",");
			String[] ycoords = db.getCoords(playerID, allBuild[(i)], ys).split(",");
			if (!xcoords[0].equals("")) {
				x2 = Integer.parseInt(xcoords[0]);
				y2 = Integer.parseInt(ycoords[0]);
			} else {
				x2 = 0;
				y2 = 0;
			}
			if (x == x2 && y == y2) {
				break;
			} else {
				canBuild = true;
			}

		}
		return canBuild;

	}

	public void buildObject(String buildingType, String hlPoint) {
		String pieceID;
		if (buildingType.equals("Village")) {
			pieceID = "d0";
			String[] keys = db.getBuilding(playerID, pieceID).split(",");
			String[] coords = hlPoint.split(",");
			if (keys.length != 5) {
				switch (keys.length) {
				case 1:
					if (keys[0].equals("")) {
						db.setBuilding("d01", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					} else {
						db.setBuilding("d02", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					}
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
				case 1:
					if (keys[0].equals("")) {
						db.setBuilding("c01", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					} else {
						db.setBuilding("c02", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					}
					break;
				case 2:
					db.setBuilding("c03", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				case 3:
					db.setBuilding("c04", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					break;
				}
			}
		}

	}

	public void buildStreet(int x1, int x2, int y1, int y2) {
		String pieceID = "r";
		String[] keys = db.getBuilding(playerID, pieceID).split(",");
		if (keys.length != 15) {
			switch (keys.length) {
			case 1:
				if (keys[0].equals("")) {
					db.setStreet("r01", playerID, x1, y1, x2, y2);
				} else {
					db.setStreet("r02", playerID, x1, y1, x2, y2);
				}
				break;
			case 2:
				db.setStreet("r03", playerID, x1, y1, x2, y2);
				break;
			case 3:
				db.setStreet("r04", playerID, x1, y1, x2, y2);
				break;
			case 4:
				db.setStreet("r05", playerID, x1, y1, x2, y2);
				break;
			case 5:
				db.setStreet("r06", playerID, x1, y1, x2, y2);
				break;
			case 6:
				db.setStreet("r07", playerID, x1, y1, x2, y2);
				break;
			case 7:
				db.setStreet("r08", playerID, x1, y1, x2, y2);
				break;
			case 8:
				db.setStreet("r09", playerID, x1, y1, x2, y2);
				break;
			case 9:
				db.setStreet("r10", playerID, x1, y1, x2, y2);
				break;
			case 10:
				db.setStreet("r011", playerID, x1, y1, x2, y2);
				break;
			case 11:
				db.setStreet("r012", playerID, x1, y1, x2, y2);
				break;
			case 12:
				db.setStreet("r013", playerID, x1, y1, x2, y2);
				break;
			case 13:
				db.setStreet("r014", playerID, x1, y1, x2, y2);
				break;
			case 14:
				db.setStreet("r015", playerID, x1, y1, x2, y2);
				break;

			}
		}
	}

	public int countBuildings() {
		int count = 0;
		playerIDs = db.getPlayerId(gameID).split(",");
		for (int i = 0; i < 4; i++) {
			count = count + db.countBuildings(Integer.parseInt(playerIDs[i]));
		}
		return count;

	}

	public String getAllBuildings() {
		String buildings = "";
		for (int i = 0; i < 4; i++) {
			buildings = buildings + db.getAllBuildings(Integer.parseInt(playerIDs[i]));
		}
		return buildings;
	}

	public void updateHand() {
		player.updateHand();
	}


	
	public int getCoordX(String pieceID) {
		return db.getCoordX(this.playerID, pieceID);
		
	}
	
	public int getCoordY(String x) {
		return db.getCoordX(this.playerID, x);
		
	}
	
}
