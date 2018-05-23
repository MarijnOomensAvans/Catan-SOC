package Model;


import java.util.ArrayList;


import Controller.PlayerController;
import DAL.PersonDal;

public class Player {
	
	private int player_id;
	private int game_id;
	private String username;
	private String color;
	private int order_number;

	private PlayerController conn;
	private PersonDal pd;
	private int points = 0;
	private int knightmight = 0;
	
	private ArrayList<MaterialCard> hand = new ArrayList<MaterialCard>();
	private ArrayList<DevelopmentCard> handdev = new ArrayList<DevelopmentCard>();

	public Player(PlayerController controller, PersonDal pd, int playerid, int gameid) {
		conn = controller;
		this.pd = pd;
		this.player_id = playerid;
		this.game_id = gameid;
		setName();
		setColor();
		setOrder_number();
		
	}
	
	public void setName() {
		username = pd.getName(player_id);
	}


	
	public void setColor() {
			color = pd.getColor(player_id, game_id);
	}
	
	

	public void setOrder_number() {
			order_number = pd.getorder_number(player_id,game_id);
	}

	public void addMaterialCard(String kind) {
		MaterialCard newCard = conn.getMaterialCard(kind);
		String cardid = newCard.getIdCard();
		pd.addMaterialCard(game_id, cardid, player_id);
		hand.add(newCard);
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
