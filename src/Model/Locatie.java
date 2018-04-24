package Model;

public class Locatie {
	private int x;
	private int y;
	
	private boolean haven;
	
	Grondstofsoort grondstofhaven;
	
	public Locatie(int x,int y,boolean haven,char grondstofhaven) {
		this.x = x;
		this.y = x;
		this.haven = haven;
		
		if(grondstofhaven != 0 && haven) {
			this.grondstofhaven = new Grondstofsoort(grondstofhaven);
		}
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

	public boolean isHaven() {
		return haven;
	}

	public void setHaven(boolean haven) {
		this.haven = haven;
	}
	
}
