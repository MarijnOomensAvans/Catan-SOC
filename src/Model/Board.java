package Model;

import java.util.HashMap;
import java.util.Random;

public class Board {
	Random rand = new Random();
	private HashMap<Integer, Collection> axisgrid = new HashMap<Integer, Collection>();
	private int loopnumb = 0;
	private int looplet = 1000;
	private int boardType;

	public Board(int boardType) {
		this.boardType = boardType;
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
		System.out.println("Empty board generated");
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
	private void setCustomBoard() {
		// TODO Auto-generated method stub
		
	}
	
	
	private void setRandomBoard() {
		for(int i = 1000;i<=1019;i++) {
			randomResource(i);
		}
		
	}
	
	
	private void randomResource(int location) {
		int number = rand.nextInt(6) + 1;
		int resourcecount = 0;
		switch(number) {
		case 1:
			for(int i = 1000;i<=1019;i++) {
				if(axisgrid.get(i) != null) {
				if(((Tile) axisgrid.get(i)).getResourcetype() == 'X') {
					resourcecount += 1;
				}
				}
			}
			if(resourcecount<1) {
				placeResource(location,'X');
				break;
			}
			else {
				randomResource(location);
				break;
			}
		case 2:
			for(int i = 1000;i<=1019;i++) {
				if(axisgrid.get(i) != null) {
				if(((Tile) axisgrid.get(i)).getResourcetype() == 'W') {
					resourcecount += 1;
				}
				}
			}
			if(resourcecount<4) {
				placeResource(location,'W');
				break;
			}
			else {
				randomResource(location);
				break;
			}
		case 3:
			for(int i = 1000;i<=1019;i++) {
				if(axisgrid.get(i) != null) {
				if(((Tile) axisgrid.get(i)).getResourcetype() == 'T') {
					resourcecount += 1;
				}
				}
			}
			if(resourcecount<4) {
				placeResource(location,'T');
				break;
			}
			else {
				randomResource(location);
				break;
			}
		case 4:
			for(int i = 1000;i<=1019;i++) {
				if(axisgrid.get(i) != null) {
				if(((Tile) axisgrid.get(i)).getResourcetype() == 'B') {
					resourcecount += 1;
				}
				}
			}
			if(resourcecount<3) {
				placeResource(location,'B');
				break;
			}
			else {
				randomResource(location);
				break;
			}
		case 5:
			for(int i = 1000;i<=1019;i++) {
			if(axisgrid.get(i) != null) {
				if(((Tile) axisgrid.get(i)).getResourcetype() == 'O') {
					resourcecount += 1;
				}
			}
			}
			if(resourcecount<3) {
				((Tile) axisgrid.get(location)).setResourcetype('O');
				break;
			}
			else {
				randomResource(location);
				break;
			}
		case 6:
			for(int i = 1000;i<=1019;i++) {
				if(axisgrid.get(i) != null) {
				if(((Tile) axisgrid.get(i)).getResourcetype() == 'G') {
					resourcecount += 1;
				}
				}
			}
			if(resourcecount<4) {
				placeResource(location,'G');
				break;
			}
			else {
				randomResource(location);
				break;
			}
		}
	}




	private void setStandardBoard() {
		// TODO Auto-generated method stub
		
	}
	
	public void placeResource(int position,char resource) {
		((Tile) axisgrid.get(position)).setResourcetype(resource);
	}
}