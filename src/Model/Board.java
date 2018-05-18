package Model;

import java.util.HashMap;
import java.util.Random;

import DAL.BoardDal;

public class Board {
	Random rand = new Random();
	BoardDal bdal = new BoardDal();
	private HashMap<Integer, Collection> axisgrid = new HashMap<Integer, Collection>();
	private int loopnumb = 0;
	private int looplet = 1000;
	private int boardType = 1; // This will normally be initliaised by the lobby

	public void setBoardType(int boardType) {
		this.boardType = boardType;
	}

	public Board() {
		generateBoard();
		switch (this.boardType) {
		case 1:
			setStandardBoard();
			break;
		case 2:
			setRandomBoard();
			break;
		case 3:
			setCustomBoard();
			break;
		}
	}

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

	public void placetile(int x, int y) {
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

	private void setCustomBoard() {
		// TODO Overleggen met de spelstart groep over hoe we de gekozen tiles doorgeven
		for (int i = 1000; i < 1019; i++) {
			// For now IDspel will be 1 until lobby integration is completet
			bdal.setTile(1, i, ((Tile) axisgrid.get(i)).getX(), ((Tile) axisgrid.get(i)).getY(),
					((Tile) axisgrid.get(i)).getResourcetype(), ((Tile) axisgrid.get(i)).getChit());
		}
	}

	private void setRandomBoard() {
		randomResource();
		randomChit();
		for (int i = 1000; i < 1019; i++) {
			// For now IDspel will be 1 until lobby integration is completet
			bdal.setTile(1, i, ((Tile) axisgrid.get(i)).getX(), ((Tile) axisgrid.get(i)).getY(),
					((Tile) axisgrid.get(i)).getResourcetype(), ((Tile) axisgrid.get(i)).getChit());
		}
	}
	
	private void setStandardBoard() {
		standardResource();
		standardChit();
		for (int i = 1000; i < 1019; i++) {
			// For now IDspel will be 1 until lobby integration is completet
			bdal.setTile(1, i, ((Tile) axisgrid.get(i)).getX(), ((Tile) axisgrid.get(i)).getY(),
					((Tile) axisgrid.get(i)).getResourcetype(), ((Tile) axisgrid.get(i)).getChit());
		}
	}

	// Chit placement
	// -----------------------------------------------------------------------------------------------------------------------

	private void randomChit() {
		((Tile) axisgrid.get(1009)).setChit(0);
		int location = 1000;
		while (true) {
			int number = rand.nextInt(12) + 2;
			int resourcecount = 0;
			if (location != 1009) {
				switch (number) {
				case 2:
					for (int i = 1000; i <= 1018; i++) {
						if (axisgrid.get(i) != null) {
							if (((Tile) axisgrid.get(i)).getChit() == 1) {
								resourcecount += 1;
							}
						}
					}
					if (resourcecount < 1) {
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
								resourcecount += 1;
							}
						}
					}
					if (resourcecount < 1) {
						placeChit(location, 2);
						location++;
						break;
					} else {
						if (resourcecount < 2) {
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
								resourcecount += 1;
							}
						}
					}
					if (resourcecount < 1) {
						placeChit(location, 4);
						location++;
						break;
					} else {
						if (resourcecount < 2) {
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
								resourcecount += 1;
							}
						}
					}
					if (resourcecount < 1) {
						placeChit(location, 6);
						location++;
						break;
					} else {
						if (resourcecount < 2) {
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
								resourcecount += 1;
							}
						}
					}
					if (resourcecount < 1) {
						placeChit(location, 8);
						location++;
						break;
					} else {
						if (resourcecount < 2) {
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
								resourcecount += 1;
							}
						}
					}
					if (resourcecount < 1) {
						placeChit(location, 10);
						location++;
						break;
					} else {
						if (resourcecount < 2) {
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
								resourcecount += 1;
							}
						}
					}
					if (resourcecount < 1) {
						placeChit(location, 12);
						location++;
						break;
					} else {
						if (resourcecount < 2) {
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
								resourcecount += 1;
							}
						}
					}
					if (resourcecount < 1) {
						placeChit(location, 14);
						location++;
						break;
					} else {
						if (resourcecount < 2) {
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
								resourcecount += 1;
							}
						}
					}
					if (resourcecount < 1) {
						placeChit(location, 16);
						location++;
						break;
					} else {
						if (resourcecount < 2) {
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
								resourcecount += 1;
							}
						}
					}
					if (resourcecount < 1) {
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

	public void placeResource(int position, char resource) {
		((Tile) axisgrid.get(position)).setResourcetype(resource);
	}

	public void placeChit(int position, int chit) {
		((Tile) axisgrid.get(position)).setChit(chit);
		;
	}
}