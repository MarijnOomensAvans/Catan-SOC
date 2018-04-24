package Model;

public class Tegel {
	Grondstofsoort grondstofsoort;
	
	private int x;
	private int y;
	private int getalfische;
	


	public Tegel(int x,int y,char grondstof,int getalfische) {
		this.x = x;
		this.y = y;
		this.grondstofsoort = new Grondstofsoort(grondstof);
		this.getalfische = getalfische;
	}
	
	public int getGetalfische() {
		return getalfische;
	}
	
	
	public void setGetalfische(int getalfische) {
		this.getalfische = getalfische;
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
