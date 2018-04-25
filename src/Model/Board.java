package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {
	private HashMap<Integer, Collection> axisgrid = new HashMap<Integer, Collection>();
	private int loopnumb = 0;

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
					case 4:
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
						placetile(x,y);
						break;
					case 7:
						placetile(x,y);
						break;
					}
				case 6:
					switch (y) {
					case 3:
						placetile(x,y);
						break;
					case 6:
						placetile(x,y);
						break;
					case 9:
						placetile(x,y);
						break;
					}
				case 7:
					switch (y) {
					case 5:
						placetile(x,y);
						break;
					case 8:
						placetile(x,y);
						break;
					}
				case 8:
					switch (y) {
					case 4:
						placetile(x,y);
						break;
					case 7:
						placetile(x,y);
						break;
					case 10:
						placetile(x,y);
						break;
					}
				case 9:
					switch (y) {
					case 6:
						placetile(x,y);
						break;
					case 9:
						placetile(x,y);
						break;
					}
				}
			}
		}
	}

	public void placetile(int x, int y) {
		Tile tile = new Tile(x, y);
		ArrayList<Location> locationlist = new ArrayList<Location>();
		axisgrid.put(loopnumb, tile);
		loopnumb++;
		for(Location location : locationlist) {
			if(!(location.getX() == x + 1 && location.getY() == y + 1)) {
				axisgrid.put(loopnumb, new Location(x + 1, y + 1));
			}
		}
		loopnumb++;
		for(Location location : locationlist) {
			if(!(location.getX() == x + 1 && location.getY() == y + 1)) {
				axisgrid.put(loopnumb, new Location(x + 1, y));
			}
		}
		loopnumb++;
		for(Location location : locationlist) {
			if(!(location.getX() == x + 1 && location.getY() == y + 1)) {
				axisgrid.put(loopnumb, new Location(x, y + 1));
			}
		}
		loopnumb++;
		for(Location location : locationlist) {
			if(!(location.getX() == x + 1 && location.getY() == y + 1)) {
				axisgrid.put(loopnumb, new Location(x, y - 1));
			}
		}
		loopnumb++;
		for(Location location : locationlist) {
			if(!(location.getX() == x + 1 && location.getY() == y + 1)) {
				axisgrid.put(loopnumb, new Location(x - 1, y));
			}
		}
		for(Location location : locationlist) {
			if(!(location.getX() == x + 1 && location.getY() == y + 1)) {
				axisgrid.put(loopnumb, new Location(x - 1, y - 1));
			}
		}
		loopnumb++;
	}

}