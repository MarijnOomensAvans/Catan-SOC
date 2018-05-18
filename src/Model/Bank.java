package Model;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
	
	private ArrayList<DevelopmentCard> devbank = new ArrayList <DevelopmentCard>();
	private ArrayList<MaterialCard> matbank = new ArrayList <MaterialCard>();
	
	public Bank() {
		makeMaterialCards();
		makeDevCards();
	}
	
	private void makeMaterialCards() {
		for(char i='A'; i<'F'; i++) {
			for(int a=0; a<20; a++) {
				matbank.add(new MaterialCard(i));
			}
		}
		
	}
	public MaterialCard getMaterialCard(int kind) {
		MaterialCard returncard = null;
		for(int i=0; i<matbank.size(); i++) {
			if(matbank.get(i).getKindOfMaterial() == kind) {
				returncard = matbank.get(i);
				break;
			}
		}
		return returncard;
	}
	
	public void giveMaterialCardBack(MaterialCard card) {
		matbank.add(card);
	}

	private void makeDevCards() {
		for(int i=0; i<24; i++) {
			devbank.add(new DevelopmentCard(i));
		}
	}
	public DevelopmentCard getDevelopmentCard() {
		Random random = new Random();
		int number =random.nextInt(devbank.size());
		return devbank.get(number);
	}
	
	public void printallMatCards() {
		for(int i=1; i<matbank.size(); i++) {
				System.out.println("Kaart "+ i +" van het soort " + matbank.get(i).getMaterial());
			
			
		}
	}
	public void printallDevCards() {
		for(int i=0; i<devbank.size(); i++) {
			System.out.println("Kaart " + i +" van het soort " + devbank.get(i).getKindName());
		}
	}
	}


