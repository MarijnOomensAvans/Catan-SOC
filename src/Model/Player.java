package Model;


import java.util.ArrayList;


import Controller.PlayerController;
import DAL.PersonDAL;

public class Player {
	
	private int player_id;
	private int game_id;
	private String username;
	private String color;
	private int order_number;

	private PlayerController conn;
	private PersonDAL pd;
	private int points = 0;
	private int knightmight = 0;
	
	private ArrayList<MaterialCard> hand = new ArrayList<MaterialCard>();
	private ArrayList<DevelopmentCard> handdev = new ArrayList<DevelopmentCard>();
	private String idDevCard;

	public Player(PlayerController controller, PersonDAL pd, int playerid, int gameid) {
		conn = controller;
		this.pd = pd;
		this.player_id = playerid;
		this.game_id = gameid;
		setName();
		setColor();
		setOrder_number();
		addDevelopmentCard();
		addDevelopmentCard();
		addDevelopmentCard();
		
		printallPlayerDevCards();
		removeDevCard("o12r", gameid, playerid);
		
		
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
	public void addDevelopmentCard() {
		
		DevelopmentCard newDevCard = conn.getDevelopmentCard(idDevCard);
		handdev.add(newDevCard);
		String devcardid = newDevCard.getIdDevCard();
		pd.addDevelopmentCard(game_id, devcardid, player_id, false);
		
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
	public void removeDevCard(String idDevCard, int gameid, int playerid) {
		for(int i=0; i< handdev.size(); i++) {
			if(handdev.get(i).getIdDevCard().equals(idDevCard)) {
				System.out.println("hallo");
				System.out.println(pd.getDevUsed(gameid, idDevCard, playerid));
				pd.useDevelopmentCard(gameid, idDevCard, playerid, true);
				System.out.println(pd.getDevUsed(gameid, idDevCard, playerid));
				handdev.remove(handdev.get(i));
			}
		}
	}
	
	
	
	

	
	public void testpointDevCard() {
		for(int i=0; i< handdev.size(); i++) {
			if(handdev.get(i).getIdDevCard().substring(3).equals("g")) {
				System.out.println("1 Overwinningspunt");
				points++;
			}
		}
	}
	public void testKnightmight() {
		for(int i=0; i< handdev.size(); i++) {
			if(handdev.get(i).getIdDevCard().substring(3).equals("r")) {
				System.out.println("Bij het spelen van deze kaart moet je de struikrover verzetten en van één van de getroffen spelers een grondstoffenkaart trekken.");
				knightmight++;
			}
		}
	}
	public void testMonopoly() {
		for(int i=0; i< handdev.size(); i++) {
			if(handdev.get(i).getIdDevCard().substring(3).equals("m")) {
				System.out.println("Bij het kiezen van deze kaart kies je een grondstof. Alle spelers geven je van deze grondstof alle kaarten die ze bezitten.");
			}
		}
	}
	public void testStratenbouw() {
		for(int i=0; i< handdev.size(); i++) {
			if(handdev.get(i).getIdDevCard().substring(3).equals("s")) {
				System.out.println("Bij het spelen van deze kaart mag je direct twee starten bouwen.");
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
