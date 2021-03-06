package Model;

import java.util.ArrayList;
import Controller.PlayerController;
import DAL.PersonDAL;

public class Player {

	private int player_id;
	private int game_id;

	private PlayerController conn;
	private PersonDAL pd;

	private ArrayList<MaterialCard> hand = new ArrayList<MaterialCard>();
	private ArrayList<DevelopmentCard> handdev = new ArrayList<DevelopmentCard>();

	public Player(PlayerController controller, PersonDAL pd, int playerid, int gameid) {
		conn = controller;
		this.pd = pd;
		this.player_id = playerid;
		this.game_id = gameid;
		updateHand();
	}

	public void updateHand() {
		for (int i = 0; i < conn.countMaterialCards(); i++) {
			MaterialCard newCard = conn.checkMaterialCard(conn.getMaterialCards(i));
			hand.add(newCard);
		}
	}

	public void addMaterialCard(String kind, int gameid) {
		MaterialCard newCard = conn.getMaterialCard(kind, gameid);
		String cardid = newCard.getIdCard();
		pd.addMaterialCard(game_id, cardid, player_id);
		hand.add(newCard);
	}

	public void addDevelopmentCard(String idDevCard, int gameid) {

		DevelopmentCard newDevCard = conn.getDevelopmentCard(gameid);
		handdev.add(newDevCard);
		String devcardid = newDevCard.getIdDevCard();
		pd.addDevelopmentCard(game_id, devcardid, player_id, false);

	}
	public void addDevelopmentCard2(int gameid) {

		DevelopmentCard newDevCard = conn.getDevelopmentCard(gameid);
		handdev.add(newDevCard);
		String devcardid = newDevCard.getIdDevCard();
		pd.addDevelopmentCard(game_id, devcardid, player_id, false);

	}

	public void removeMatCard(String kind) {
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getKindOfMaterial().equals(kind)) {
				conn.giveMaterialCardBack(hand.get(i));
				hand.remove(hand.get(i));
				break;
			}
		}
	}

	public void removeDevCard(String idDevCard, int gameid, int playerid) {

		for(int i=0; i< handdev.size(); i++) {
			if(handdev.get(i).getIdDevCard().equals(idDevCard)) {
				pd.useDevelopmentCard(idDevCard, playerid);

				handdev.remove(handdev.get(i));
			}
		}
	}


	public boolean hasStoneCard(int amount) {
		int counter = 0;
		if (hand.size() > 0) {

			for (int i = 0; i < hand.size(); i++) {
				if (hand.get(i).getKindOfMaterial().equals("B")) {
					counter++;
				}
			}
		}
		if (counter >= amount) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasWheatCard(int amount) {
		int counter = 0;
		if (hand.size() > 0) {

			for (int i = 0; i < hand.size(); i++) {
				if (hand.get(i).getKindOfMaterial().equals("G")) {
					counter++;
				}
			}
		}
		if (counter >= amount) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasWoodCard(int amount) {
		int counter = 0;
		if (hand.size() > 0) {

			for (int i = 0; i < hand.size(); i++) {
				if (hand.get(i).getKindOfMaterial().equals("H")) {
					counter++;
				}
			}
		}
		if (counter >= amount) {
			return true;
		} else {
			return false;
		}

	}

	public boolean hasWoolCard(int amount) {
		int counter = 0;
		if (hand.size() > 0) {

			for (int i = 0; i < hand.size(); i++) {
				if (hand.get(i).getKindOfMaterial().equals("W")) {
					counter++;
				}
				;
			}
		}
		if (counter >= amount) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasOreCard(int amount) {
		int counter = 0;
		if (hand.size() > 0) {

			for (int i = 0; i < hand.size(); i++) {
				if (hand.get(i).getKindOfMaterial().equals("E")) {
					counter++;
				}
				;
			}
		}
		if (counter >= amount) {
			return true;
		} else {
			return false;
		}
	}

	public void updateCards(int otherplayerid, ArrayList<Integer> offer) {
		for (int i = 0; i < offer.size(); i++) {
			if (i == 1) {
				if (offer.get(i) > 0) {

					for (int e = 0; e < offer.get(i); e++) {
						//if (hand.get(e).getKindOfMaterial().equals("B")) {
							String cardId = pd.getOtherPlayerCard(otherplayerid, "B");
							pd.updateCard(cardId, this.player_id, this.game_id); // give this card to the player that initiated the
																	// trade
						//}
					}
				}
			}
			else if (i == 2) {
				if (offer.get(i) > 0) {
					for (int e = 0; e < offer.get(i); e++) {
						//if (hand.get(e).getKindOfMaterial().equals("W")) {
							String cardId = pd.getOtherPlayerCard(otherplayerid, "W"); // get first card of this kind
																						// from opponent
							pd.updateCard(cardId, this.player_id, this.game_id); // give this card to the player that initiated the
																	// trade

						//}
					}
				}
			}
			else if (i == 3) {
				if (offer.get(i) > 0) {
					for (int e = 0; e < offer.get(i); e++) {
						//if (hand.get(e).getKindOfMaterial().equals("E")) {
							String cardId = pd.getOtherPlayerCard(otherplayerid, "E");
							 // get first card of this kind from opponent
							pd.updateCard(cardId, this.player_id, this.game_id); // give this card to the player that initiated the
																	// trade

						//}
					}
				}
			}
			else if (i == 4) {
				if (offer.get(i) > 0) {
					for (int e = 0; e < offer.get(i); e++) {
						//if (hand.get(e).getKindOfMaterial().equals("G")) {
							String cardId = pd.getOtherPlayerCard(otherplayerid, "G");
							; // get first card of this kind from opponent
							pd.updateCard(cardId, this.player_id, this.game_id); // give this card to the player that initiated the
																	// trade

						//}
					}
				}
			}
			else if (i == 5) {
				if (offer.get(i) > 0) {
					for (int e = 0; e < offer.get(i); e++) {
						//if (hand.get(e).getKindOfMaterial().equals("H")) {
							String cardId = pd.getOtherPlayerCard(otherplayerid, "H");
							; // get first card of this kind from opponent
							pd.updateCard(cardId, this.player_id, this.game_id); // give this card to the player that initiated the
																	// trade

						//}
					}
				}
			}

			else if (i == 6) {
				if (offer.get(i) > 0) {

					for (int e = 0; e < offer.get(i); e++) {
					//	if (hand.get(e).getKindOfMaterial().equals("B")) {
							String cardId = pd.getOtherPlayerCard(this.player_id, "B");
							pd.updateCard(cardId, otherplayerid, this.game_id); // give this card to the player that initiated the
																	// trade
					//	}
					}
				}
			}
			else if (i == 7) {
				if (offer.get(i) > 0) {
					for (int e = 0; e < offer.get(i); e++) {
						//if (hand.get(e).getKindOfMaterial().equals("W")) {
							String cardId = pd.getOtherPlayerCard(this.player_id, "W"); // get first card of this kind
																						// from opponent
							pd.updateCard(cardId, otherplayerid, this.game_id); // give this card to the player that initiated the
																	// trade

						//}
					}
				}
			}
			else if (i == 8) {
				if (offer.get(i) > 0) {
					for (int e = 0; e < offer.get(i); e++) {
					//	if (hand.get(e).getKindOfMaterial().equals("E")) {
							String cardId = pd.getOtherPlayerCard(this.player_id, "E");
							 // get first card of this kind from opponent
							pd.updateCard(cardId, otherplayerid, this.game_id); // give this card to the player that initiated the
																	// trade

					//	}
					}
				}
			}
			else if (i == 9) {
				if (offer.get(i) > 0) {
					for (int e = 0; e < offer.get(i); e++) {
							String cardId = pd.getOtherPlayerCard(this.player_id, "G");
							 // get first card of this kind from opponent
							pd.updateCard(cardId, otherplayerid, this.game_id); // give this card to the player that initiated the
																	// trade

					}
				}
			}
			else if (i == 10) {
				if (offer.get(i) > 0) {
					for (int e = 0; e < offer.get(i); e++) {
							String cardId = pd.getOtherPlayerCard(this.player_id, "H");
							; // get first card of this kind from opponent
							pd.updateCard(cardId, otherplayerid, this.game_id); // give this card to the player that initiated the
																	// trade

					}
				}
			}

		}

	}

}
