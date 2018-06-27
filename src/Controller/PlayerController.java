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
	private DieController dc;

	public PlayerController(int playerID, int gameID, BankController bc, PersonDAL pd, DieController dieController) {
		this.bc = bc;
		this.db = pd;
		this.dc = dieController;
		this.gameID = gameID;
		this.playerID = playerID;
		player = new Player(this, db, playerID, gameID);
	}

	public Player getPlayer() {
		return player;
	}

	public int getGameid() {
		return this.gameID;
	}

	public MaterialCard getMaterialCard(String kind, int playerid) {
		MaterialCard card = bc.getMaterialCard(kind, playerid);
		return card;
	}

	public void giveMaterialCardBack(MaterialCard materialCard) {
		bc.giveMaterialCardBack(materialCard, playerID);

	}

	public DevelopmentCard getDevelopmentCard(int gameid) {
		DevelopmentCard devcard = bc.getDevelopmentCard(gameid);
		return devcard;
	}

	public void giveDevCardPlayer(int playerid, String devcardid, int gameid) {
		db.addDevelopmentCard(gameid, devcardid, playerid, false);
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
		String buildings = "";
		String buildingsxfrom = "";
		String buildingsyfrom = "";
		String buildingsxto = "";
		String buildingsyto = "";
		String[] firstCoords = hlPoint.split(",");
		String[] coords = hlPoint.split(",");
		String[] xcoordsto = null;
		String[] ycoordsto = null;

		int x = Integer.parseInt(coords[0]);
		int y = Integer.parseInt(coords[1]);
		int x2;
		int y2;
		int x3 = Integer.parseInt(firstCoords[0]);
		int y3 = Integer.parseInt(firstCoords[1]);
		int xto = 0;
		int yto = 0;
		boolean canBuild = true;
		if (buildingType.equals("Village")) {
			pieceID = "d0";
		} else if (buildingType.equals("City")) {
			pieceID = "c0";
		} else {
			pieceID = "r";
		}
		for (int z = 0; z < 4; z++) {
			buildings = "";
			if (buildings.equals("")) {
				buildings = db.getBuilding(Integer.parseInt(playerIDs[z]), pieceID);
			} else {
				buildings = buildings + "," + db.getBuilding(Integer.parseInt(playerIDs[z]), pieceID);
			}
			String[] allBuild = buildings.split(",");
			for (int i = 0; i < (allBuild.length); i++) {
				String xs = "x_van";
				String ys = "y_van";
				String xt = "x_naar";
				String yt = "y_naar";
				buildingsxfrom = db.getCoords(Integer.parseInt(playerIDs[z]), allBuild[(i)], xs);
				buildingsyfrom = db.getCoords(Integer.parseInt(playerIDs[z]), allBuild[(i)], ys);
				if (db.getType(Integer.parseInt(playerIDs[z]), x, y).equals("Street")) {
					buildingsxto = db.getCoords(Integer.parseInt(playerIDs[z]), allBuild[(i)], xt);
					buildingsyto = db.getCoords(Integer.parseInt(playerIDs[z]), allBuild[(i)], yt);
					xcoordsto = buildingsxto.split(",");
					ycoordsto = buildingsyto.split(",");
				}
				String[] xcoords = buildingsxfrom.split(",");
				String[] ycoords = buildingsyfrom.split(",");
				if (!xcoords[0].equals("")) {
					x2 = Integer.parseInt(xcoords[0]);
					y2 = Integer.parseInt(ycoords[0]);
					if (xcoordsto != null) {
						xto = Integer.parseInt(xcoordsto[0]);
						yto = Integer.parseInt(ycoordsto[0]);
					} else {
						xto = 0;
						yto = 0;
					}
				} else {
					x2 = 0;
					y2 = 0;
				}
				if (!buildingType.equals("Street") && x == x2 && y == y2) {
					canBuild = false;
				} else {
					if (x == x2 && y == y2 && x3 == xto && y3 == yto || x == xto && y == yto && x3 == x2 && y3 == y2) {
						canBuild = false;
					}
				}
			}
		}
		if (!buildingType.equals("Street")) {
			for (int o = 0; o < 4; o++) {
				if (db.hasVillage(Integer.parseInt(playerIDs[o]), (x + 1), (y + 1)).equals("")
						&& db.hasVillage(Integer.parseInt(playerIDs[o]), x, (y + 1)).equals("")
						&& db.hasVillage(Integer.parseInt(playerIDs[o]), (x + 1), y).equals("")
						&& db.hasVillage(Integer.parseInt(playerIDs[o]), (x - 1), (y - 1)).equals("")
						&& db.hasVillage(Integer.parseInt(playerIDs[o]), (x - 1), y).equals("")
						&& db.hasVillage(Integer.parseInt(playerIDs[o]), x, (y - 1)).equals("")) {
					if (db.getRound(gameID)) {
						if (!db.hasStreetFrom(playerID, (x + 1), (y + 1)).equals("")) {
							if (db.hasStreet(playerID, (x + 1), (y + 1)).equals("")) {
								if (db.hasStreetFrom(playerID, (x + 1), (y + 1)).equals("")) {
									System.out.println("3");
									canBuild = false;
								}
							}
						} else if (!db.hasStreetFrom(playerID, x, (y + 1)).equals("")) {
							if (db.hasStreet(playerID, (x + 1), (y + 1)).equals("")) {
								if (db.hasStreetFrom(playerID, (x + 1), (y + 1)).equals("")) {
									canBuild = false;
								}
							}
						} else if (!db.hasStreetFrom(playerID, (x + 1), y).equals("")) {
							if (db.hasStreet(playerID, (x + 1), (y + 1)).equals("")) {
								if (db.hasStreetFrom(playerID, (x + 1), (y + 1)).equals("")) {
									canBuild = false;
								}
							}
						} else if (!db.hasStreetFrom(playerID, (x - 1), (y - 1)).equals("")) {
							if (db.hasStreet(playerID, (x + 1), (y + 1)).equals("")) {
								if (db.hasStreetFrom(playerID, (x + 1), (y + 1)).equals("")) {
									canBuild = false;
								}
							}
						} else if (!db.hasStreetFrom(playerID, (x - 1), y).equals("")) {
							if (db.hasStreet(playerID, (x + 1), (y + 1)).equals("")) {
								if (db.hasStreetFrom(playerID, (x + 1), (y + 1)).equals("")) {
									canBuild = false;
								}
							}
						} else if (!db.hasStreetFrom(playerID, x, (y - 1)).equals("")) {
							if (db.hasStreet(playerID, (x + 1), (y + 1)).equals("")) {
								if (db.hasStreetFrom(playerID, (x + 1), (y + 1)).equals("")) {
									canBuild = false;
								}
							}
						}
						if (!db.hasStreet(playerID, (x + 1), (y + 1)).equals("")) {
							if (db.hasStreet(playerID, (x + 1), (y + 1)).equals("")) {
								if (db.hasStreetFrom(playerID, (x + 1), (y + 1)).equals("")) {
									canBuild = false;
								}
							}
						} else if (!db.hasStreet(playerID, x, (y + 1)).equals("")) {
							if (db.hasStreet(playerID, (x + 1), (y + 1)).equals("")) {
								if (db.hasStreetFrom(playerID, (x + 1), (y + 1)).equals("")) {
									canBuild = false;
								}
							}
						} else if (!db.hasStreet(playerID, (x + 1), y).equals("")) {
							if (db.hasStreet(playerID, (x + 1), (y + 1)).equals("")) {
								if (db.hasStreetFrom(playerID, (x + 1), (y + 1)).equals("")) {
									canBuild = false;
								}
							}
						} else if (!db.hasStreet(playerID, (x - 1), (y - 1)).equals("")) {
							if (db.hasStreet(playerID, (x + 1), (y + 1)).equals("")) {
								if (db.hasStreetFrom(playerID, (x + 1), (y + 1)).equals("")) {
									canBuild = false;
								}
							}
						} else if (!db.hasStreet(playerID, (x - 1), y).equals("")) {
							if (db.hasStreet(playerID, (x + 1), (y + 1)).equals("")) {
								if (db.hasStreetFrom(playerID, (x + 1), (y + 1)).equals("")) {
									canBuild = false;
								}
							}
						} else if (!db.hasStreet(playerID, x, (y - 1)).equals("")) {
							if (db.hasStreet(playerID, (x + 1), (y + 1)).equals("")) {
								if (db.hasStreetFrom(playerID, (x + 1), (y + 1)).equals("")) {
									canBuild = false;
								}
							}
						}
					}
				} else {
					canBuild = false;
				}
			}

		}
		return canBuild;
	}

	public boolean buildObject(String buildingType, String hlPoint) {
		String pieceID;
		String allBuildings = "";
		if (buildingType.equals("Village")) {
			pieceID = "d0";
			if (allBuildings.equals("")) {
				allBuildings = db.getBuilding(playerID, pieceID);
			} else {
				allBuildings = allBuildings + "," + db.getBuilding(playerID, pieceID);
			}
			String[] keys = allBuildings.split(",");
			String[] coords = hlPoint.split(",");
			if (keys.length != 5) {
				switch (keys.length) {
				case 1:
					if (keys[0].equals("") || !keys[0].equals("d01")) {
						db.setBuilding("d01", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					} else {
						db.setBuilding("d02", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
						dc.getResource(playerID);
					}
					return true;
				case 2:
					if (!keys[2].equals("d03")) {
						db.setBuilding("d03", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
						return true;
					}
				case 3:
					if (!keys[3].equals("d03")) {
						db.setBuilding("d04", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
						return true;
					}
				case 4:
					if (!keys[4].equals("d03")) {
						db.setBuilding("d05", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
						return true;
					}
				case 5:
					return false;
				}
			}
		} else if (buildingType.equals("City"))

		{
			pieceID = "c0";
			String[] keys = db.getBuilding(playerID, pieceID).split(",");
			String[] coords = hlPoint.split(",");
			if (keys.length != 4) {
				switch (keys.length) {
				case 1:
					if (keys[0].equals("")) {
						db.setBuilding("c01", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
						db.removeVillage(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), playerID);
					} else {
						db.setBuilding("c02", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
						db.removeVillage(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), playerID);
					}
					return true;
				case 2:
					db.setBuilding("c03", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					db.removeVillage(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), playerID);
					return true;
				case 3:
					db.setBuilding("c04", playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
					db.removeVillage(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), playerID);
					return true;
				case 4:
					return false;
				}

			}
		}
		return false;

	}

	public boolean buildStreet(int x1, int x2, int y1, int y2) {
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
				return true;
			case 2:
				db.setStreet("r03", playerID, x1, y1, x2, y2);
				return true;
			case 3:
				db.setStreet("r04", playerID, x1, y1, x2, y2);
				return true;
			case 4:
				db.setStreet("r05", playerID, x1, y1, x2, y2);
				return true;
			case 5:
				db.setStreet("r06", playerID, x1, y1, x2, y2);
				return true;
			case 6:
				db.setStreet("r07", playerID, x1, y1, x2, y2);
				return true;
			case 7:
				db.setStreet("r08", playerID, x1, y1, x2, y2);
				return true;
			case 8:
				db.setStreet("r09", playerID, x1, y1, x2, y2);
				return true;
			case 9:
				db.setStreet("r10", playerID, x1, y1, x2, y2);
				return true;
			case 10:
				db.setStreet("r011", playerID, x1, y1, x2, y2);
				return true;
			case 11:
				db.setStreet("r012", playerID, x1, y1, x2, y2);
				return true;
			case 12:
				db.setStreet("r013", playerID, x1, y1, x2, y2);
				return true;
			case 13:
				db.setStreet("r014", playerID, x1, y1, x2, y2);
				return true;
			case 14:
				db.setStreet("r015", playerID, x1, y1, x2, y2);
				return true;
			case 15:
				return false;

			}
		}
		return false;
	}

	public String getAllBuildings() {
		String buildings = "";
		playerIDs = db.getPlayerId(gameID).split(",");
		for (int i = 0; i < 4; i++) {
			if (buildings == "") {
				buildings = db.getAllBuildings(Integer.parseInt(playerIDs[i]));
			} else {
				buildings = buildings + "," + db.getAllBuildings(Integer.parseInt(playerIDs[i]));
			}
		}
		if (buildings != null) {
			if (buildings.length() > 0) {
				return buildings.substring(0, buildings.length());
			}
		}
		return buildings;
	}

	public void updateHand() {
		player.updateHand();
	}

	public int countPlayerPiece(int playerid) {
		return db.countPlayerPiece(playerid);
	}

	public String getPlayerPiece(int playerid, int resultnumber) {
		return db.getPlayerPiece(playerid, resultnumber);
	}

	public int getCoordX(String pieceID, int playerid) {
		return db.getCoordX(Integer.parseInt(playerIDs[playerid]), pieceID);

	}

	public int getCoordXStreet(String pieceID, int playerid) {
		return db.getCoordXStreet(Integer.parseInt(playerIDs[playerid]), pieceID);

	}

	public int getCoordY(String x, int playerid) {
		return db.getCoordY(Integer.parseInt(playerIDs[playerid]), x);

	}

	public int getCoordYStreet(String x, int playerid) {
		return db.getCoordYStreet(Integer.parseInt(playerIDs[playerid]), x);

	}

	public boolean checkVillage(String test, String hlPoint) {
		String[] splitTest = test.split(",");
		String[] splithlPoint = hlPoint.split(",");
		String point1 = db.hasVillage(playerID, Integer.parseInt(splitTest[0]), Integer.parseInt(splitTest[1]));
		String point2 = db.hasVillage(playerID, Integer.parseInt(splithlPoint[0]), Integer.parseInt(splithlPoint[1]));
		if (!point1.equals("") || !point2.equals("")) {
			return true;
		} else {
			point1 = db.hasStreet(playerID, Integer.parseInt(splitTest[0]), Integer.parseInt(splitTest[1]));
			point2 = db.hasStreet(playerID, Integer.parseInt(splithlPoint[0]), Integer.parseInt(splithlPoint[1]));
			if (!point1.equals("") || !point2.equals("")) {
				return true;
			} else {
				point1 = db.hasStreetFrom(playerID, Integer.parseInt(splitTest[0]), Integer.parseInt(splitTest[1]));
				point2 = db.hasStreetFrom(playerID, Integer.parseInt(splithlPoint[0]),
						Integer.parseInt(splithlPoint[1]));
				System.out.println(point1 + point2);
				if (!point1.equals("") || !point2.equals("")) {
					System.out.println("YEYA!");
					return true;
				} else {
					return false;
				}
			}
		}
	}

	public boolean getRound() {
		return db.getRound(gameID);
	}

	public int getBuildCount(int x) {
		return Integer.parseInt(db.getBuildCount(Integer.parseInt(playerIDs[x])));
	}

	public boolean emptySpaceCity(String buildingType, String hlPoint) {
		String[] coords = hlPoint.split(",");
		if (!db.hasVillage(playerID, Integer.parseInt(coords[0]), Integer.parseInt(coords[1])).equals("")) {
			return true;
		} else {
			return false;
		}
	}

}
