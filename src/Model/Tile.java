package Model;

public class Tile extends Collection {
	Resourcetype resourcetype;
	
	private int x;
	private int y;
	private int numberchits;
	


	public Tile(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getGetalfische() {
		return numberchits;
	}
	
	
	public void setGetalfische(int numberchits) {
		this.numberchits = numberchits;
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
