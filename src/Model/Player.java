package Model;


import java.util.ArrayList;

import Controller.Controller;
import DAL.PersonDal;

public class Player {
	
	private int player_id;
	private int game_id;
	private String username;
	private String color;
	private int order_number;

	private Controller conn;
	private PersonDal pd;
	private int points = 0;
	private int knightmight = 0;
	
	private ArrayList<MaterialCard> hand = new ArrayList<MaterialCard>();
	private ArrayList<DevelopmentCard> handdev = new ArrayList<DevelopmentCard>();

	public Player(Controller controller, PersonDal pd) {
		conn = controller;
		this.pd = pd;
		
	}
	
	public void setName(String username) {
		this.username = username;
	}


	
	public void setColor() {
			color = pd.getColor(player_id);
	}
	
	
	public void setGame_id() {
			game_id = pd.getgame_id(player_id);
	}

	public void setOrder_number() {
			order_number = pd.getorder_number(player_id);
	}

	public void addMaterialCard(String kind) {
		hand.add(conn.getMaterialCard(kind));
	}
	
	public void removeMatCard(String kind) {
		for(int i=0; i< hand.size(); i++) {
			if(hand.get(i).getKindOfMaterial() == kind) {
				conn.giveMaterialCardBack(hand.get(i));
				hand.remove(hand.get(i));
				break;
			}
		}
	}

	public void adddevelopmentCard(int kind) {
		handdev.add(conn.getDevelopmentCard());
	
		}
	
	public void testpointDevCard() {
		for(int i=0; i< handdev.size(); i++) {
			if(handdev.get(i).getKind() >= 20) {
				System.out.println("hey hier krijg je een punt voor");
				points++;
			}
		}
}
	public void testKnightmight() {
		for(int i=0; i< handdev.size(); i++) {
			if(handdev.get(i).getKind() >= 6 && handdev.get(i).getKind() <=20) {
				System.out.println("hey hier krijg je een ridder punt voor");
				knightmight++;
			}
		}
	}
	public void removeDevCard(int kind) {
		for(int i=0; i< handdev.size(); i++) {
			if(handdev.get(i).getKind() == kind) {
				hand.remove(hand.get(i));
				break;
			}
		}
	}
	
	

	public void getGame_id() {
		System.out.println(game_id);
	}

	public void getColor() {
		System.out.println(color);
	}

	public void getUsername() {
		System.out.println(username);
	}
	
	public void getOrder_number() {
		System.out.println(order_number);
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	public void printallPlayerDevCards() {
		for(int i=0; i<handdev.size(); i++) {
			System.out.println("Kaart " + i +" van het soort " + handdev.get(i).getKindName());
	}
	}
	public int getKnightmight() {
			return knightmight;
	}
	
}
