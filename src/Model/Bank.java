package Model;

import java.util.ArrayList;
import java.util.Random;

import DAL.BankDAL;

public class Bank {
	
	private BankDAL bd;
	private ArrayList<DevelopmentCard> devbank = new ArrayList <DevelopmentCard>();
	private ArrayList<MaterialCard> matbank = new ArrayList <MaterialCard>();
	
	public Bank(BankDAL bd) {
		this.bd = bd;
		makeMaterialCards();
		makeDevCards();
	}
	
	private void makeMaterialCards() {
			for(int a=1; a<96; a++) {
				matbank.add(new MaterialCard(bd,a));
			}
		
		
	}
	public MaterialCard getMaterialCard(String kind) {
		MaterialCard returncard = null;
		for(int i=0; i<matbank.size(); i++) {
			if(matbank.get(i).getKindOfMaterial().equals(kind)) {
				returncard = matbank.get(i);
				matbank.remove(returncard);
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
		for(int i=0; i<matbank.size(); i++) {
				System.out.println("Kaart "+ i +" van het soort " + matbank.get(i).getIdCard());
				System.out.println(matbank.get(i).getKindOfMaterial());
			
			
		}
	}
	public void printallDevCards() {
		for(int i=0; i<devbank.size(); i++) {
			System.out.println("Kaart " + i +" van het soort " + devbank.get(i).getKindName());
		}
	}
	}


