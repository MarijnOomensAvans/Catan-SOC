package Model;

public class DevelopmentCard {
	
	private String kindName;
	private int kind;
	
	public DevelopmentCard(int kind) {
		this.kind = kind;
	}
	
	public void setKindName() {
		if(kind==  0 || kind < 2 ) {
			kindName = "Stratenbouw";
		}
		else if(kind==  2 || kind < 4 ) {
			kindName = "Monopolie";
		}
		else if(kind==  4 || kind < 6 ) {
			kindName = "Uitvinding";
		}
		else if(kind==  6 || kind < 19 ) {
			kindName = "Ridder";
		}
		else if(kind==  19 ) {
			kindName = "Kathedraal";
		}
		else if(kind== 20 ) {
			kindName = "Parlement";
		}
		else if(kind==  21 ) {
			kindName = "Markt";
		}
		else if(kind==  22 ) {
			kindName = "Bibliotheek";
		}
		else if(kind==  23 ) {
			kindName = "Universiteit";
		}
	}

	public int getKind() {
		return kind;
	}
	
	public String getKindName() {
		return kindName;
	}



}
