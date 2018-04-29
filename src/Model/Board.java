package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {
	private HashMap<Integer, Collection> axisgrid = new HashMap<Integer, Collection>();
	private int loopnumb = 0;
	private Location[] locationlist = new Location[6];

	public Board() {
		generateBoard();
	}

	public void generateBoard() {
		for (int x = 1; x < 12; x++, loopnumb++) {
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
				case 7:
					switch (y) {
					case 5:
						placetile(x, y);
						break;
					case 8:
						placetile(x, y);
						break;
					}
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
				case 9:
					switch (y) {
					case 6:
						placetile(x, y);
						break;
					case 9:
						placetile(x, y);
						break;
					}
				case 10:
					switch (y) {
					case 8:
						placetile(x, y);
						break;
					}
				}
			}
		}
	}

	public void placetile(int x, int y) {
		Tile tile = new Tile(x, y);
		Location location;
		axisgrid.put(loopnumb, tile);
		for (int i = 0; i < 6; i++) {
			loopnumb++;
			if (locationlist[i] != null) {
				if (!(locationlist[i].getX() == x + 1 && locationlist[i].getY() == y + 1)) {
					axisgrid.put(loopnumb, location = new Location(x + 1, y + 1));
					locationlist[i] = location;
					i++;
				} else {
					i++;
				}
				if (!(locationlist[i].getX() == x + 1 && locationlist[i].getY() == y)) {
					axisgrid.put(loopnumb, location = new Location(x + 1, y));
					locationlist[i] = location;
					i++;
				} else {
					i++;
				}
				if (!(locationlist[i].getX() == x && locationlist[i].getY() == y + 1)) {
					axisgrid.put(loopnumb, location = new Location(x, y + 1));
					locationlist[i] = location;
					i++;
				} else {
					i++;
				}
				if (!(locationlist[i].getX() == x && locationlist[i].getY() == y - 1)) {
					axisgrid.put(loopnumb, location = new Location(x, y - 1));
					locationlist[i] = location;
					i++;
				} else {
					i++;
				}
				if (!(locationlist[i].getX() == x - 1 && locationlist[i].getY() == y)) {
					axisgrid.put(loopnumb, location = new Location(x - 1, y));
					locationlist[i] = location;
					i++;
				} else {
					i++;
				}
				if (!(locationlist[i].getX() == x - 1 && locationlist[i].getY() == y - 1)) {
					axisgrid.put(loopnumb, location = new Location(x - 1, y - 1));
					locationlist[i] = location;
					i++;
				} else {
					i++;
				}
			} else {
				axisgrid.put(loopnumb, location = new Location(x + 1, y +1));
				locationlist[i] = location;
				axisgrid.put(loopnumb += 1, location = new Location(x + 1, y));
				locationlist[i+1] = location;
				axisgrid.put(loopnumb += 1, location = new Location(x, y + 1));
				locationlist[i+2] = location;
				axisgrid.put(loopnumb += 1, location = new Location(x - 1, y + 1));
				locationlist[i+3] = location;
				axisgrid.put(loopnumb +=1, location = new Location(x + 1, y - 1));
				locationlist[i+4] = location;
				axisgrid.put(loopnumb +=1, location = new Location(x - 1, y - 1));
				locationlist[i+5] = location;
				break;
			}
		}
	}
}
