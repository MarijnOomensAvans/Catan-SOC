package Model;

import java.util.HashMap;

public class Board {
	private HashMap<Integer, Collection> axisgrid = new HashMap<Integer, Collection>();
	private int loopnumb = 0;
	private int looplet = 1000;

	public Board() {
		generateBoard();
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
		System.out.println("The ends");
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
			axisgrid.put(loopnumb, location = new Location(x + 1,y + 1));
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
	
	public void placeResource() {
		
	}
}