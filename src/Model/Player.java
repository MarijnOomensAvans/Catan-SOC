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
		//setName();
		//setColor();
		//setOrder_number();

		
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
		MaterialCard newCard = conn.getMaterialCard(kind, player_id);
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

	public boolean hasStoneCard(int amount) {
		int counter =0;
		if(hand.size()>0) {
			
		for(int i =0; i< hand.size(); i++) {
			if(hand.get(i).getKindOfMaterial().equals("B")) {
				counter++;
			};
		}
		}
		if(counter>= amount) {
			return true;
		}else {
			return false;
		}
	}
	public boolean hasWheatCard(int amount) {
		int counter =0;
		if(hand.size()>0) {
			
		for(int i =0; i< hand.size(); i++) {
			if(hand.get(i).getKindOfMaterial().equals("G")) {
				counter++;
			};
		}
		}
		if(counter>= amount) {
			return true;
		}else {
			return false;
		}
	}
	public boolean hasWoodCard(int amount) {
		int counter =0;
		if(hand.size()>0) {
			
		for(int i =0; i< hand.size(); i++) {
			if(hand.get(i).getKindOfMaterial().equals("H")) {
				counter++;
			};
		}
		}
		if(counter>= amount) {
			return true;
		}else {
			return false;
		}
	}
	public boolean hasWoolCard(int amount) {
		int counter =0;
		if(hand.size()>0) {
			
		for(int i =0; i< hand.size(); i++) {
			if(hand.get(i).getKindOfMaterial().equals("W")) {
				counter++;
			};
		}
		}
		if(counter>= amount) {
			return true;
		}else {
			return false;
		}
	}
	public boolean hasOreCard(int amount) {
		int counter =0;
		if(hand.size()>0) {
			
		for(int i =0; i< hand.size(); i++) {
			if(hand.get(i).getKindOfMaterial().equals("E")) {
				counter++;
			};
		}
		}
		if(counter>= amount) {
			return true;
		}else {
			return false;
		}
	}

	public void updateCards(int otherplayerid, ArrayList<Integer> offer) {
		for(int i =0; i <offer.size();i++) {
			if(i == 1) {
				if(offer.get(i) > 0) {

					for(int e =0; e< offer.get(i); e++) {
						if(hand.get(e).getKindOfMaterial().equals("B")) {
						String cardId = pd.getOtherPlayerCards(otherplayerid,"B");
						pd.updateCard(cardId, this.player_id);	//give this card to the player that initiated the trade
						}
					}
				}
			}
			if(i == 2) {
				if(offer.get(i) > 0) {
					for(int e =0; e< hand.size(); e++) {
						if(hand.get(e).getKindOfMaterial().equals("W")) {
							String cardId = "";	//get first card of this kind from opponent
							pd.updateCard(cardId, this.player_id);	//give this card to the player that initiated the trade

						}
					}
				}
			}
			if(i == 3) {
				if(offer.get(i) > 0) {
					for(int e =0; e< hand.size(); e++) {
						if(hand.get(e).getKindOfMaterial().equals("E")) {
							String cardId = "";	//get first card of this kind from opponent
							pd.updateCard(cardId, this.player_id);	//give this card to the player that initiated the trade

						}
					}
				}
			}
			if(i == 4) {
				if(offer.get(i) > 0) {
					for(int e =0; e< hand.size(); e++) {
						if(hand.get(e).getKindOfMaterial().equals("G")) {
							String cardId = "";	//get first card of this kind from opponent
							pd.updateCard(cardId, this.player_id);	//give this card to the player that initiated the trade

						}
					}
				}
			}
			if(i == 5) {
				if(offer.get(i) > 0) {
					for(int e =0; e< hand.size(); e++) {
						if(hand.get(e).getKindOfMaterial().equals("H")) {
							String cardId = "";	//get first card of this kind from opponent
							pd.updateCard(cardId, this.player_id);	//give this card to the player that initiated the trade

						}
					}
				}
			}
		}
		
	
		
	}
	
}
