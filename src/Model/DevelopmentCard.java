package Model;

import DAL.BankDAL;

public class DevelopmentCard {
	
	private String kindName;
	private String iddevcard;
	
	private int kind;
	
	public DevelopmentCard(BankDAL bd, int kind) {
		this.kind = kind;
		setKindName();
	}
	
	public void setKindName() {
		//here the development cards get a kindname and an id that corresponds with the id in the database
		if(kind ==  0) {
			kindName = "Stratenbouw";
			iddevcard = "o06s";
		}
		else if(kind == 1) {
			kindName = "Stratenbouw";
			iddevcard = "o07s";
		}
		else if(kind==  2){
			kindName = "Monopolie";
			iddevcard = "o08m";
		}
		else if(kind==  3){
				kindName = "Monopolie";
				iddevcard = "o09m";
		}
		else if(kind==  4) {
			kindName = "Uitvinding";
			iddevcard = "o10u";
		}
		else if(kind==  5) {
			kindName = "Uitvinding";
			iddevcard = "o11u";
		}
		else if(kind==  6) {
			kindName = "Ridder";
			iddevcard = "o12r";
		}
		else if(kind==  7) {
			kindName = "Ridder";
			iddevcard = "o13r";
		}
		else if(kind==  8) {
			kindName = "Ridder";
			iddevcard = "o14r";
		}
		else if(kind==  9) {
			kindName = "Ridder";
			iddevcard = "o15r";
		}
		else if(kind==  10) {
			kindName = "Ridder";
			iddevcard = "o16r";
		}
		else if(kind==  11) {
			kindName = "Ridder";
			iddevcard = "o17r";
		}
		else if(kind==  12) {
			kindName = "Ridder";
			iddevcard = "o18r";
		}
		else if(kind==  13) {
			kindName = "Ridder";
			iddevcard = "o19r";
		}
		else if(kind==  14) {
			kindName = "Ridder";
			iddevcard = "o20r";
		}
		else if(kind==  15) {
			kindName = "Ridder";
			iddevcard = "o21r";
		}
		else if(kind==  16) {
			kindName = "Ridder";
			iddevcard = "o22r";
		}
		else if(kind==  17) {
			kindName = "Ridder";
			iddevcard = "o23r";
		}
		else if(kind==  18) {
			kindName = "Ridder";
			iddevcard = "o24r";
		}
		else if(kind== 19) {
			kindName = "Ridder";
			iddevcard = "o25r";
		}
		
		else if(kind==  20) {
			kindName = "Kathedraal";
			iddevcard = "o01g";
		}
		else if(kind== 21) {
			kindName = "Parlement";
			iddevcard = "o05g";
		}
		else if(kind==  22) {
			kindName = "Markt";
			iddevcard = "o02g";
		}
		else if(kind==  23) {
			kindName = "Bibliotheek";
			iddevcard = "o03g";
		}
		else if(kind==  24) {
			kindName = "Universiteit";
			iddevcard = "o04g";
		}
	}

	public int getKind() {
		return kind;
	}
	
	public String getKindName() {
		return kindName;
	}
	public String getIddevcard() {
		return iddevcard;
	}



}
