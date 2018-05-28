package Model;

public class Tile extends Collection {
	
	private char resourcetype;
	
	private int x;
	private int y;
	private int chit;
	


	public Tile(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getChit() {
		return chit;
	}
	
	
	public char getResourcetype() {
		return resourcetype;
	}

	public void setResourcetype(char resourcetype) {
		this.resourcetype = resourcetype;
	}

	public void setChit(int numberchits) {
			this.chit = numberchits;
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
