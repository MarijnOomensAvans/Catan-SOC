package Model;

import java.awt.Color;
import java.util.HashMap;
import java.util.Random;

import DAL.BoardDal;
import View.BoardColours;

public class Board {
	Random rand = new Random();
	BoardDal bdal = new BoardDal();
	//We made one hashmap with all Tiles and Location in it (under superclass collection). Every Collection objecht has an id which we use
	//to quickly identify different objects.
	private HashMap<Integer, Collection> axisgrid = new HashMap<Integer, Collection>();
	private int loopnumb = 0;
	private int looplet = 1000;
	private int boardType;
	private LobbyModel lobby = new LobbyModel();

	public void setBoardType(int idspel,int boardType) {
		this.boardType = boardType;
		bdal.setBoardType(idspel, boardType);
	}

	public void finishBoard(int idspel) {
		switch (this.boardType) {
		case 1:
			setStandardBoard(idspel);
			break;
		case 2:
			setRandomBoard(idspel);
			break;
		}
	}
	

	//The board is always generated in the same manner, since the positions of tiles and locations are predetermined.
	public void generateBoard() {
		for (int x = 1; x < 12; x++) {
			for (int y = 1; y < 12; y++) {
				switch (x) {
				case 2:
					switch (y) {
					case 4:
						placetile(x, y);
						break;
					}
					break;
				case 3:
					switch (y) {
					case 3:
						placetile(x, y);
						break;
					case 6:
						placetile(x, y);
						break;
					}
					break;
				case 4:
					switch (y) {
					case 2:
						placetile(x, y);
						break;
					case 5:
						placetile(x, y);
						break;
					case 8:
						placetile(x, y);
						break;
					}
					break;
				case 5:
					switch (y) {
					case 4:
						placetile(x, y);
						break;
					case 7:
						placetile(x, y);
						break;
					}
					break;
				case 6:
					switch (y) {
					case 3:
						placetile(x, y);
						break;
					case 6:
						placetile(x, y);
						break;
					case 9:
						placetile(x, y);
						break;
					}
					break;
				case 7:
					switch (y) {
					case 5:
						placetile(x, y);
						break;
					case 8:
						placetile(x, y);
						break;
					}
					break;
				case 8:
					switch (y) {
					case 4:
						placetile(x, y);
						break;
					case 7:
						placetile(x, y);
						break;
					case 10:
						placetile(x, y);
						break;
					}
					break;
				case 9:
					switch (y) {
					case 6:
						placetile(x, y);
						break;
					case 9:
						placetile(x, y);
						break;
					}
					break;
				case 10:
					switch (y) {
					case 8:
						placetile(x, y);
						break;
					}
					break;
				}
			}
		}
	}

	
	//Tiles are placed at a location in the grid (x and y coordinates). After the grid is placed, locations are initialised around the grid.
	//We check for overlapping locations with the booleans.
	private void placetile(int x, int y) {
		Tile tile = new Tile(x, y);
		boolean loc1 = true;
		boolean loc2 = true;
		boolean loc3 = true;
		boolean loc4 = true;
		boolean loc5 = true;
		boolean loc6 = true;
		Location location;
		axisgrid.put(looplet, tile);
		looplet++;
		for (int i = 0; i < axisgrid.size(); i++) {
			location = (Location) axisgrid.get(i);
			if (axisgrid.get(i) != null) {
				if (location.getX() == x + 1 && location.getY() == y + 1) {
					loc1 = false;
				}
				if (location.getX() == x + 1 && location.getY() == y) {
					loc2 = false;
				}
				if (location.getX() == x && location.getY() == y + 1) {
					loc3 = false;
				}
				if (location.getX() == x && location.getY() == y - 1) {
					loc4 = false;
				}
				if (location.getX() == x - 1 && location.getY() == y) {
					loc5 = false;
				}
				if (location.getX() == x - 1 && location.getY() == y - 1) {
					loc6 = false;
				}
			}
		}
		if (loc1 == true) {
			axisgrid.put(loopnumb, location = new Location(x + 1, y + 1));
			loopnumb++;
		}
		if (loc2 == true) {
			axisgrid.put(loopnumb, location = new Location(x + 1, y));
			loopnumb++;
		}
		if (loc3 == true) {
			axisgrid.put(loopnumb, location = new Location(x, y + 1));
			loopnumb++;
		}
		if (loc4 == true) {
			axisgrid.put(loopnumb, location = new Location(x, y - 1));
			loopnumb++;
		}
		if (loc5 == true) {
			axisgrid.put(loopnumb, location = new Location(x - 1, y));
			loopnumb++;
		}
		if (loc6 == true) {
			axisgrid.put(loopnumb, location = new Location(x - 1, y - 1));
			loopnumb++;
		}
	}

	private void setRandomBoard(int idspel) {
		randomResource();
		randomChit();
		for (int i = 1000; i < 1019; i++) {
			bdal.setTile(idspel, i, ((Tile) axisgrid.get(i)).getX(), ((Tile) axisgrid.get(i)).getY(),
					((Tile) axisgrid.get(i)).getResourcetype(), ((Tile) axisgrid.get(i)).getChit());
		}
	}
	
	private void setStandardBoard(int idspel) {
		standardResource();
		standardChit();
		for (int i = 1000; i < 1019; i++) {
			bdal.setTile(idspel, i, ((Tile) axisgrid.get(i)).getX(), ((Tile) axisgrid.get(i)).getY(),
					((Tile) axisgrid.get(i)).getResourcetype(), ((Tile) axisgrid.get(i)).getChit());
		}
	}

	// Chit placement
	// ------------------------------------------------------------------------------------------------------------------------
	//Chits are places randomly in an even manner (there's always a set amount of a specific chitnumber i.e only 2 8's).
	//Chits are placed with an id, this id corrosponds with the id set in the database (id 2 and 3 are both number 2).
	private void randomChit() {
		((Tile) axisgrid.get(1009)).setChit(0);
		int location = 1000;
		while (true) {
			int number = rand.nextInt(12) + 2;
			int chitcount = 0;
			if (location != 1009) {
				switch (number) {
				case 2:
					for (int i = 1000; i <= 1018; i++) {
						if (axisgrid.get(i) != null) {
							if (((Tile) axisgrid.get(i)).getChit() == 1) {
								chitcount += 1;
							}
						}
					}
					if (chitcount < 1) {
						placeChit(location, 1);
						location++;
						break;
					} else {
						break;
					}
				case 3:
					for (int i = 1000; i <= 1018; i++) {
						if (axisgrid.get(i) != null) {
							if (((Tile) axisgrid.get(i)).getChit() == 2 || ((Tile) axisgrid.get(i)).getChit() == 3) {
								chitcount += 1;
							}
						}
					}
					if (chitcount < 1) {
						placeChit(location, 2);
						location++;
						break;
					} else {
						if (chitcount < 2) {
							placeChit(location, 3);
							location++;
							break;
						} else {
							break;
						}
					}
				case 4:
					for (int i = 1000; i <= 1018; i++) {
						if (axisgrid.get(i) != null) {
							if (((Tile) axisgrid.get(i)).getChit() == 4 || ((Tile) axisgrid.get(i)).getChit() == 5) {
								chitcount += 1;
							}
						}
					}
					if (chitcount < 1) {
						placeChit(location, 4);
						location++;
						break;
					} else {
						if (chitcount < 2) {
							placeChit(location, 5);
							location++;
							break;
						} else {
							break;
						}
					}
				case 5:
					for (int i = 1000; i <= 1018; i++) {
						if (axisgrid.get(i) != null) {
							if (((Tile) axisgrid.get(i)).getChit() == 6 || ((Tile) axisgrid.get(i)).getChit() == 7) {
								chitcount += 1;
							}
						}
					}
					if (chitcount < 1) {
						placeChit(location, 6);
						location++;
						break;
					} else {
						if (chitcount < 2) {
							placeChit(location, 7);
							location++;
							break;
						} else {
							break;
						}
					}
				case 6:
					for (int i = 1000; i <= 1018; i++) {
						if (axisgrid.get(i) != null) {
							if (((Tile) axisgrid.get(i)).getChit() == 8 || ((Tile) axisgrid.get(i)).getChit() == 9) {
								chitcount += 1;
							}
						}
					}
					if (chitcount < 1) {
						placeChit(location, 8);
						location++;
						break;
					} else {
						if (chitcount < 2) {
							placeChit(location, 9);
							location++;
							break;
						} else {
							break;
						}
					}
				case 8:
					for (int i = 1000; i <= 1018; i++) {
						if (axisgrid.get(i) != null) {
							if (((Tile) axisgrid.get(i)).getChit() == 10 || ((Tile) axisgrid.get(i)).getChit() == 11) {
								chitcount += 1;
							}
						}
					}
					if (chitcount < 1) {
						placeChit(location, 10);
						location++;
						break;
					} else {
						if (chitcount < 2) {
							placeChit(location, 11);
							location++;
							break;
						} else {
							break;
						}
					}
				case 9:
					for (int i = 1000; i <= 1018; i++) {
						if (axisgrid.get(i) != null) {
							if (((Tile) axisgrid.get(i)).getChit() == 12 || ((Tile) axisgrid.get(i)).getChit() == 13) {
								chitcount += 1;
							}
						}
					}
					if (chitcount < 1) {
						placeChit(location, 12);
						location++;
						break;
					} else {
						if (chitcount < 2) {
							placeChit(location, 13);
							location++;
							break;
						} else {
							break;
						}
					}
				case 10:
					for (int i = 1000; i <= 1018; i++) {
						if (axisgrid.get(i) != null) {
							if (((Tile) axisgrid.get(i)).getChit() == 14 || ((Tile) axisgrid.get(i)).getChit() == 15) {
								chitcount += 1;
							}
						}
					}
					if (chitcount < 1) {
						placeChit(location, 14);
						location++;
						break;
					} else {
						if (chitcount < 2) {
							placeChit(location, 15);
							location++;
							break;
						} else {
							break;
						}
					}
				case 11:
					for (int i = 1000; i <= 1018; i++) {
						if (axisgrid.get(i) != null) {
							if (((Tile) axisgrid.get(i)).getChit() == 16 || ((Tile) axisgrid.get(i)).getChit() == 17) {
								chitcount += 1;
							}
						}
					}
					if (chitcount < 1) {
						placeChit(location, 16);
						location++;
						break;
					} else {
						if (chitcount < 2) {
							placeChit(location, 17);
							location++;
							break;
						} else {
							break;
						}
					}
				case 12:
					for (int i = 1000; i <= 1018; i++) {
						if (axisgrid.get(i) != null) {
							if (((Tile) axisgrid.get(i)).getChit() == 18) {
								chitcount += 1;
							}
						}
					}
					if (chitcount < 1) {
						placeChit(location, 18);
						location++;
						break;
					} else {
						break;
					}
				}
				if (location == 1019) {
					break;
				}
			} else {
				location++;
				continue;
			}
		}
	}

	private void standardChit() {
		for (int i = 1000; i <= 1018; i++) {
			switch (i) {
			case 1000:
				placeChit(i, 12);
				break;
			case 1001:
				placeChit(i, 10);
				break;
			case 1002:
				placeChit(i, 18);
				break;
			case 1003:
				placeChit(i, 6);
				break;
			case 1004:
				placeChit(i, 16);
				break;
			case 1005:
				placeChit(i, 14);
				break;
			case 1006:
				placeChit(i, 2);
				break;
			case 1007:
				placeChit(i, 8);
				break;
			case 1008:
				placeChit(i, 9);
				break;
			case 1009:
				placeChit(i, 0);
				break;
			case 1010:
				placeChit(i, 1);
				break;
			case 1011:
				placeChit(i, 4);
				break;
			case 1012:
				placeChit(i, 5);
				break;
			case 1013:
				placeChit(i, 17);
				break;
			case 1014:
				placeChit(i, 3);
				break;
			case 1015:
				placeChit(i, 13);
				break;
			case 1016:
				placeChit(i, 7);
				break;
			case 1017:
				placeChit(i, 15);
				break;
			case 1018:
				placeChit(i, 11);
				break;
			}
		}
	}

	// Resource placement
	// -------------------------------------------------------------------------------------------------------------------
	//Resources are placed randomly in an even manner.
	private void randomResource() {
		((Tile) axisgrid.get(1009)).setResourcetype('X');
		int location = 1000;
		while (true) {
			int number = rand.nextInt(5) + 1;
			int resourcecount = 0;
			if (location != 1009) {
				switch (number) {
				case 1:
					for (int i = 1000; i <= 1018; i++) {
						if (axisgrid.get(i) != null) {
							if (((Tile) axisgrid.get(i)).getResourcetype() == 'W') {
								resourcecount += 1;
							}
						}
					}
					if (resourcecount < 4) {
						placeResource(location, 'W');
						location++;
						break;
					} else {
						break;
					}
				case 2:
					for (int i = 1000; i <= 1018; i++) {
						if (axisgrid.get(i) != null) {
							if (((Tile) axisgrid.get(i)).getResourcetype() == 'H') {
								resourcecount += 1;
							}
						}
					}
					if (resourcecount < 4) {
						placeResource(location, 'H');
						location++;
						break;
					} else {
						break;
					}
				case 3:
					for (int i = 1000; i <= 1018; i++) {
						if (axisgrid.get(i) != null) {
							if (((Tile) axisgrid.get(i)).getResourcetype() == 'B') {
								resourcecount += 1;
							}
						}
					}
					if (resourcecount < 3) {
						placeResource(location, 'B');
						location++;
						break;
					} else {
						break;
					}
				case 4:
					for (int i = 1000; i <= 1018; i++) {
						if (axisgrid.get(i) != null) {
							if (((Tile) axisgrid.get(i)).getResourcetype() == 'E') {
								resourcecount += 1;
							}
						}
					}
					if (resourcecount < 3) {
						((Tile) axisgrid.get(location)).setResourcetype('E');
						location++;
						break;
					} else {
						break;
					}
				case 5:
					for (int i = 1000; i <= 1018; i++) {
						if (axisgrid.get(i) != null) {
							if (((Tile) axisgrid.get(i)).getResourcetype() == 'G') {
								resourcecount += 1;
							}
						}
					}
					if (resourcecount < 4) {
						placeResource(location, 'G');
						location++;
						break;
					} else {
						break;
					}
				}
				if (location == 1019) {
					break;
				}
			} else {
				location++;
				continue;
			}
		}
	}

	private void standardResource() {
		standardChit();
		for (int i = 1000; i <= 1018; i++) {
			switch (i) {
			case 1000:
				placeResource(i, 'G');
				break;
			case 1001:
				placeResource(i, 'H');
				break;
			case 1002:
				placeResource(i, 'G');
				break;
			case 1003:
				placeResource(i, 'B');
				break;
			case 1004:
				placeResource(i, 'H');
				break;
			case 1005:
				placeResource(i, 'E');
				break;
			case 1006:
				placeResource(i, 'E');
				break;
			case 1007:
				placeResource(i, 'B');
				break;
			case 1008:
				placeResource(i, 'W');
				break;
			case 1009:
				placeResource(i, 'X');
				break;
			case 1010:
				placeResource(i, 'G');
				break;
			case 1011:
				placeResource(i, 'G');
				break;
			case 1012:
				placeResource(i, 'W');
				break;
			case 1013:
				placeResource(i, 'W');
				break;
			case 1014:
				placeResource(i, 'H');
				break;
			case 1015:
				placeResource(i, 'H');
				break;
			case 1016:
				placeResource(i, 'W');
				break;
			case 1017:
				placeResource(i, 'B');
				break;
			case 1018:
				placeResource(i, 'E');
				break;
			}
		}

	}
	
	//-----------------------------------------------------------------------------------------------------------------------

	private void placeResource(int position, char resource) {
		((Tile) axisgrid.get(position)).setResourcetype(resource);
	}

	private void placeChit(int position, int chit) {
		((Tile) axisgrid.get(position)).setChit(chit);
	}
	
	//--------------------------------------------------------------------------------------------------------------------------
	//Methods for returning resourcetypes from tiles and harbours
	public char getTileResource(int idspel,int x,int y) {
		return bdal.getResourceTile(idspel, x, y);
	}
	
	public char getHarbourResource(int x,int y) {
		return bdal.getLocationHarbourResource(x, y);
	}
	
	public Color getColour(int i) {
		i = (i + 1000);
		int x = ((Tile) axisgrid.get(i)).getX();
		int y = ((Tile) axisgrid.get(i)).getY();
		char returnColour = bdal.getResourceTile(lobby.getGameid(), x, y);
		switch(returnColour) {
		case 'H':
			return BoardColours.WOOD.getRGB();
		case 'G':
			return BoardColours.GRAIN.getRGB();
		case 'E':
			return BoardColours.ORE.getRGB();
		case 'B':
			return BoardColours.BRICK.getRGB();
		case 'W': 
			return BoardColours.WOOL.getRGB();
		case 'X':
			return BoardColours.DESERT.getRGB();
		}
		return null;
	}
}