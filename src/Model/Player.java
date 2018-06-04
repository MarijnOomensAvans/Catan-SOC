package Model;


import java.util.ArrayList;


import Controller.PlayerController;
<<<<<<< HEAD
import DAL.PersonDAL;
=======
import DAL.PersonDal;
>>>>>>> ruilen

public class Player {
	
	private int player_id;
	private int game_id;
	private String username;
	private String color;
	private int order_number;

	private PlayerController conn;
<<<<<<< HEAD
	private PersonDAL pd;
=======
	private PersonDal pd;
>>>>>>> ruilen
	private int points = 0;
	private int knightmight = 0;
	
	private ArrayList<MaterialCard> hand = new ArrayList<MaterialCard>();
	private ArrayList<DevelopmentCard> handdev = new ArrayList<DevelopmentCard>();
<<<<<<< HEAD
	private String idDevCard;

	public Player(PlayerController controller, PersonDAL pd, int playerid, int gameid) {
=======

	public Player(PlayerController controller, PersonDal pd, int playerid, int gameid) {
>>>>>>> ruilen
		conn = controller;
		this.pd = pd;
		this.player_id = playerid;
		this.game_id = gameid;
<<<<<<< HEAD
		setName();
		setColor();
		setOrder_number();
		addDevelopmentCard();
		addDevelopmentCard();
		addDevelopmentCard();
		
		printallPlayerDevCards();
		removeDevCard("o12r", gameid, playerid);
		
=======
		//setName();
		//setColor();
		//setOrder_number();

>>>>>>> ruilen
		
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
<<<<<<< HEAD
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
	
=======
		MaterialCard newCard = conn.getMaterialCard(kind, player_id);
		if(newCard != null)
		{
			String cardid = newCard.getIdCard();
			pd.addMaterialCard(game_id, cardid, player_id);
			hand.add(newCard);
		}
	}
>>>>>>> ruilen
	
	public void removeMatCard(String kind) {
		for(int i=0; i< hand.size(); i++) {
			if(hand.get(i).getKindOfMaterial() == kind) {
				conn.giveMaterialCardBack(hand.get(i));
				hand.remove(hand.get(i));
				break;
			}
		}
	}
<<<<<<< HEAD
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
=======

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
>>>>>>> ruilen
				knightmight++;
			}
		}
	}
<<<<<<< HEAD
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
=======
	public void removeDevCard(int kind) {
		for(int i=0; i< handdev.size(); i++) {
			if(handdev.get(i).getKind() == kind) {
				hand.remove(hand.get(i));
				break;
>>>>>>> ruilen
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
<<<<<<< HEAD
			
=======
>>>>>>> ruilen
	}
	}
	public int getKnightmight() {
			return knightmight;
	}
<<<<<<< HEAD
	public boolean hasKnightCard(int amount) {
		int counter =0;
		if(handdev.size()>0) {
			
		for(int i =0; i< handdev.size(); i++) {
			if(handdev.get(i).getIdDevCard().substring(3).equals("r")) {
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

	public boolean hasStratenBouw(int amount) {
		int counter =0;
		if(handdev.size()>0) {
			
		for(int i =0; i< handdev.size(); i++) {
			if(handdev.get(i).getIdDevCard().substring(3).equals("s")) {
=======

	public boolean hasStoneCard(int amount) {
		int counter =0;
		if(hand.size()>0) {
			
		for(int i =0; i< hand.size(); i++) {
			if(hand.get(i).getKindOfMaterial().equals("B")) {
>>>>>>> ruilen
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
<<<<<<< HEAD

	public boolean hasMonopolie(int amount) {
		int counter =0;
		if(handdev.size()>0) {
			
		for(int i =0; i< handdev.size(); i++) {
			if(handdev.get(i).getIdDevCard().substring(3).equals("m")) {
=======
	public boolean hasWheatCard(int amount) {
		int counter =0;
		if(hand.size()>0) {
			
		for(int i =0; i< hand.size(); i++) {
			if(hand.get(i).getKindOfMaterial().equals("G")) {
>>>>>>> ruilen
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
<<<<<<< HEAD
	public boolean hasUitvinding(int amount) {
		int counter =0;
		if(handdev.size()>0) {
			
		for(int i =0; i< handdev.size(); i++) {
			if(handdev.get(i).getIdDevCard().substring(3).equals("u")) {
=======
	public boolean hasWoodCard(int amount) {
		int counter =0;
		if(hand.size()>0) {
			
		for(int i =0; i< hand.size(); i++) {
			if(hand.get(i).getKindOfMaterial().equals("H")) {
>>>>>>> ruilen
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
<<<<<<< HEAD

	public boolean hasKathedraal(int amount) {
		int counter =0;
		if(handdev.size()>0) {
			
		for(int i =0; i< handdev.size(); i++) {
			if(handdev.get(i).getIdDevCard().substring(2).equals("1q")) {
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
	public boolean hasParlement(int amount) {
		int counter =0;
		if(handdev.size()>0) {
			
		for(int i =0; i< handdev.size(); i++) {
			if(handdev.get(i).getIdDevCard().substring(2).equals("5q")) {
=======
	public boolean hasWoolCard(int amount) {
		int counter =0;
		if(hand.size()>0) {
			
		for(int i =0; i< hand.size(); i++) {
			if(hand.get(i).getKindOfMaterial().equals("W")) {
>>>>>>> ruilen
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
<<<<<<< HEAD

	public boolean hasMarkt(int amount) {
		int counter =0;
		if(handdev.size()>0) {
			
		for(int i =0; i< handdev.size(); i++) {
			if(handdev.get(i).getIdDevCard().substring(2).equals("2q")) {
=======
	public boolean hasOreCard(int amount) {
		int counter =0;
		if(hand.size()>0) {
			
		for(int i =0; i< hand.size(); i++) {
			if(hand.get(i).getKindOfMaterial().equals("E")) {
>>>>>>> ruilen
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
<<<<<<< HEAD
	public boolean hasBibliotheek(int amount) {
		int counter =0;
		if(handdev.size()>0) {
			
		for(int i =0; i< handdev.size(); i++) {
			if(handdev.get(i).getIdDevCard().substring(2).equals("3q")) {
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

	public boolean hasUniversiteit(int amount) {
		int counter =0;
		if(handdev.size()>0) {
			
		for(int i =0; i< handdev.size(); i++) {
			if(handdev.get(i).getIdDevCard().substring(2).equals("4q")) {
				counter++;
			};
		}
		}
		if(counter>= amount) {
			return true;
		}else {
			return false;
		}
=======

	public void updateCards(int otherplayerid, ArrayList<Integer> offer) {
		for(int i =0; i <offer.size();i++) {
			if(i == 1) {
				if(offer.get(i) > 0) {

					for(int e =0; e< offer.get(i); e++) {
						if(hand.get(e).getKindOfMaterial().equals("B")) {
						String cardId = pd.getOtherPlayerCard(otherplayerid,"B");
						pd.updateCard(cardId, this.player_id);	//give this card to the player that initiated the trade
						}
					}
				}
			}
			if(i == 2) {
				if(offer.get(i) > 0) {
					for(int e =0; e< hand.size(); e++) {
						if(hand.get(e).getKindOfMaterial().equals("W")) {
							String cardId = pd.getOtherPlayerCard(otherplayerid,"W");	//get first card of this kind from opponent
							pd.updateCard(cardId, this.player_id);	//give this card to the player that initiated the trade

						}
					}
				}
			}
			if(i == 3) {
				if(offer.get(i) > 0) {
					for(int e =0; e< hand.size(); e++) {
						if(hand.get(e).getKindOfMaterial().equals("E")) {
							String cardId = pd.getOtherPlayerCard(otherplayerid,"E");;	//get first card of this kind from opponent
							pd.updateCard(cardId, this.player_id);	//give this card to the player that initiated the trade

						}
					}
				}
			}
			if(i == 4) {
				if(offer.get(i) > 0) {
					for(int e =0; e< hand.size(); e++) {
						if(hand.get(e).getKindOfMaterial().equals("G")) {
							String cardId = pd.getOtherPlayerCard(otherplayerid,"G");;	//get first card of this kind from opponent
							pd.updateCard(cardId, this.player_id);	//give this card to the player that initiated the trade

						}
					}
				}
			}
			if(i == 5) {
				if(offer.get(i) > 0) {
					for(int e =0; e< hand.size(); e++) {
						if(hand.get(e).getKindOfMaterial().equals("H")) {
							String cardId = pd.getOtherPlayerCard(otherplayerid,"H");;	//get first card of this kind from opponent
							pd.updateCard(cardId, this.player_id);	//give this card to the player that initiated the trade

						}
					}
				}
			}
			
			if(i == 6) {
				if(offer.get(i) > 0) {

					for(int e =0; e< offer.get(i); e++) {
						if(hand.get(e).getKindOfMaterial().equals("B")) {
						String cardId = pd.getOtherPlayerCard(this.player_id,"B");
						pd.updateCard(cardId, otherplayerid);	//give this card to the player that initiated the trade
						}
					}
				}
			}
			if(i == 7) {
				if(offer.get(i) > 0) {
					for(int e =0; e< hand.size(); e++) {
						if(hand.get(e).getKindOfMaterial().equals("W")) {
							String cardId = pd.getOtherPlayerCard(this.player_id,"W");	//get first card of this kind from opponent
							pd.updateCard(cardId, otherplayerid);	//give this card to the player that initiated the trade

						}
					}
				}
			}
			if(i == 8) {
				if(offer.get(i) > 0) {
					for(int e =0; e< hand.size(); e++) {
						if(hand.get(e).getKindOfMaterial().equals("E")) {
							String cardId = pd.getOtherPlayerCard(this.player_id,"E");;	//get first card of this kind from opponent
							pd.updateCard(cardId, otherplayerid);	//give this card to the player that initiated the trade

						}
					}
				}
			}
			if(i == 9) {
				if(offer.get(i) > 0) {
					for(int e =0; e< hand.size(); e++) {
						if(hand.get(e).getKindOfMaterial().equals("G")) {
							String cardId = pd.getOtherPlayerCard(this.player_id,"G");;	//get first card of this kind from opponent
							pd.updateCard(cardId, otherplayerid);	//give this card to the player that initiated the trade

						}
					}
				}
			}
			if(i == 10) {
				if(offer.get(i) > 0) {
					for(int e =0; e< hand.size(); e++) {
						if(hand.get(e).getKindOfMaterial().equals("H")) {
							String cardId = pd.getOtherPlayerCard(this.player_id,"H");;	//get first card of this kind from opponent
							pd.updateCard(cardId, otherplayerid);	//give this card to the player that initiated the trade

						}
					}
				}
			}
			
			
			
		}
		
	
		
>>>>>>> ruilen
	}
	
}
