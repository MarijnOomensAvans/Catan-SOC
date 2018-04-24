package Model;

public class Location extends Collection{
	private int x;
	private int y;
	
	private boolean harbour;
	
	private Resourcetype resourceofharbour;
	
	public Location(int x,int y,boolean haven,char resourceofharbour) {
		this.x = x;
		this.y = x;
		this.harbour = haven;
		
		if(resourceofharbour != 0 && haven) {
			this.resourceofharbour = new Resourcetype(resourceofharbour);
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
		return harbour;
	}

	public void setHaven(boolean haven) {
		this.harbour = haven;
	}
	
}
