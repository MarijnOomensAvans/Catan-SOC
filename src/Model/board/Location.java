package Model.board;

public class Location extends Collection{
	//The locations are already hardcoded in the database, so we make them locally just to compare the coordinates.
	private int x;
	private int y;
	
	public Location(int x,int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
