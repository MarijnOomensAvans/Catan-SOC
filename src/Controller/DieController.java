package Controller;

import java.util.ArrayList;

import DAL.PersonDAL;
import Model.Die;
import Model.MaterialCard;

public class DieController {
	private int gameID;
	private Die d1;
	private Die d2;
	private RobberController rb;
	private IngameController inGameController;
	private BoardController bc;
	private BankController bct;
	private PersonDAL pd;

	public DieController(int gameID, RobberController rb, IngameController inGameController, BoardController bc,
			BankController bct, PersonDAL pd) {
		this.pd = pd;
		this.bct = bct;
		this.bc = bc;
		this.inGameController = inGameController;
		this.gameID = gameID;
		this.rb = rb;
		d1 = new Die(1, gameID);
		d2 = new Die(2, gameID);

	}

	public int[] rollDice() {
		d1.rollDie();
		d2.rollDie();

		int diceResult[] = { d1.getStoredDie(), d2.getStoredDie() };
		int diceRes = d1.getStoredDie() + d2.getStoredDie();
		lookAtResult(diceRes);
		return diceResult;
	}

	public void lookAtResult(int diceResult) {
		if (diceResult == 7) {
			rb.robberThrown(gameID);
		} else if (diceResult == 2) {
			getCards1(1);
		} else if (diceResult == 3) {
			getCards1(2);
			getCards1(3);
		} else if (diceResult == 4) {
			getCards1(4);
			getCards1(5);
		} else if (diceResult == 5) {
			getCards1(6);
			getCards1(7);
		} else if (diceResult == 6) {
			getCards1(8);
			getCards1(9);
		} else if (diceResult == 8) {
			getCards1(10);
			getCards1(11);
		} else if (diceResult == 9) {
			getCards1(12);
			getCards1(13);
		} else if (diceResult == 10) {
			getCards1(14);
			getCards1(15);
		} else if (diceResult == 11) {
			getCards1(16);
			getCards1(17);
		} else if (diceResult == 12) {
			getCards1(18);
		}
	}

	public void getCards1(int number) {
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ids = inGameController.getPlayerIds(gameID);
		int x = bc.getXTile(number, gameID);
		int y = bc.getYTile(number, gameID);
		char resource = bc.getTileResource(gameID, x, y);
		String source = Character.toString(resource);

		for (int i = 0; i < ids.size(); i++) {
			if (bc.getBuildingplayer(x + 1, y, ids.get(i)) != 0) {
				if (bc.isVillage(ids.get(i), x + 1, y)) {
					MaterialCard card = bct.getMaterialCard(source, ids.get(i));
					String cardid = card.getIdCard();
					pd.addMaterialCard(gameID, cardid, ids.get(i));
				}
				if (bc.isCity(ids.get(i), x + 1, y)) {
					MaterialCard card1 = bct.getMaterialCard(source, ids.get(i));
					String cardid1 = card1.getIdCard();
					pd.addMaterialCard(gameID, cardid1, ids.get(i));
					MaterialCard card2 = bct.getMaterialCard(source, ids.get(i));
					String cardid2 = card2.getIdCard();
					pd.addMaterialCard(gameID, cardid2, ids.get(i));
				}
			}
			if (bc.getBuildingplayer(x + 1, y + 1, ids.get(i)) != 0) {
				if (bc.isVillage(ids.get(i), x + 1, y + 1)) {
					MaterialCard card = bct.getMaterialCard(source, ids.get(i));
					String cardid = card.getIdCard();
					pd.addMaterialCard(gameID, cardid, ids.get(i));
				} else if (bc.isCity(ids.get(i), x + 1, y + 1)) {
					MaterialCard card1 = bct.getMaterialCard(source, ids.get(i));
					String cardid1 = card1.getIdCard();
					pd.addMaterialCard(gameID, cardid1, ids.get(i));
					MaterialCard card2 = bct.getMaterialCard(source, ids.get(i));
					String cardid2 = card2.getIdCard();
					pd.addMaterialCard(gameID, cardid2, ids.get(i));
				}
			}
			if (bc.getBuildingplayer(x, y + 1, ids.get(i)) != 0) {
				if (bc.isVillage(ids.get(i), x, y + 1)) {
					MaterialCard card = bct.getMaterialCard(source, ids.get(i));
					String cardid = card.getIdCard();
					pd.addMaterialCard(gameID, cardid, ids.get(i));
				} else if (bc.isCity(ids.get(i), x, y + 1)) {
					MaterialCard card1 = bct.getMaterialCard(source, ids.get(i));
					String cardid1 = card1.getIdCard();
					pd.addMaterialCard(gameID, cardid1, ids.get(i));
					MaterialCard card2 = bct.getMaterialCard(source, ids.get(i));
					String cardid2 = card2.getIdCard();
					pd.addMaterialCard(gameID, cardid2, ids.get(i));
				}
			}
			if (bc.getBuildingplayer(x - 1, y, ids.get(i)) != 0) {
				if (bc.isVillage(ids.get(i), x - 1, y)) {
					MaterialCard card = bct.getMaterialCard(source, ids.get(i));
					String cardid = card.getIdCard();
					pd.addMaterialCard(gameID, cardid, ids.get(i));
				}
				if (bc.isCity(ids.get(i), x - 1, y)) {
					MaterialCard card1 = bct.getMaterialCard(source, ids.get(i));
					String cardid1 = card1.getIdCard();
					pd.addMaterialCard(gameID, cardid1, ids.get(i));
					MaterialCard card2 = bct.getMaterialCard(source, ids.get(i));
					String cardid2 = card2.getIdCard();
					pd.addMaterialCard(gameID, cardid2, ids.get(i));
				}
			}
			if (bc.getBuildingplayer(x - 1, y - 1, ids.get(i)) != 0) {
				if (bc.isVillage(ids.get(i), x - 1, y - 1)) {
					MaterialCard card = bct.getMaterialCard(source, ids.get(i));
					String cardid = card.getIdCard();
					pd.addMaterialCard(gameID, cardid, ids.get(i));
				} else if (bc.isCity(ids.get(i), x - 1, y - 1)) {
					MaterialCard card1 = bct.getMaterialCard(source, ids.get(i));
					String cardid1 = card1.getIdCard();
					pd.addMaterialCard(gameID, cardid1, ids.get(i));
					MaterialCard card2 = bct.getMaterialCard(source, ids.get(i));
					String cardid2 = card2.getIdCard();
					pd.addMaterialCard(gameID, cardid2, ids.get(i));
				}
			}
			if (bc.getBuildingplayer(x, y - 1, ids.get(i)) != 0) {
				if (bc.isVillage(ids.get(i), x, y - 1)) {
					MaterialCard card = bct.getMaterialCard(source, ids.get(i));
					String cardid = card.getIdCard();
					pd.addMaterialCard(gameID, cardid, ids.get(i));
				} else if (bc.isCity(ids.get(i), x, y - 1)) {
					MaterialCard card1 = bct.getMaterialCard(source, ids.get(i));
					String cardid1 = card1.getIdCard();
					pd.addMaterialCard(gameID, cardid1, ids.get(i));
					MaterialCard card2 = bct.getMaterialCard(source, ids.get(i));
					String cardid2 = card2.getIdCard();
					pd.addMaterialCard(gameID, cardid2, ids.get(i));
				}
			}
		}

	}

	public int[] getCurrentValues() {
		int[] values = new int[2];
		values[0] = d1.getStoredDie();
		values[1] = d2.getStoredDie();

		return values;

	}

	public void throwDice() {
		inGameController.thrownDice();
	}

	public void getResource(int playerID) {
		int x = pd.getCoordX(playerID, "d02");
		int y = pd.getCoordY(playerID, "d02");
		MaterialCard card = null;

		if (pd.isTile(x + 1, y)) {
			char resource = bc.getTileResource(gameID, x + 1, y);
			String source = Character.toString(resource);
			card = bct.getMaterialCard(source, playerID);
		}
		if (pd.isTile(x, y + 1)) {
			char resource = bc.getTileResource(gameID, x, y + 1);
			String source = Character.toString(resource);
			card = bct.getMaterialCard(source, playerID);
		}
		if (pd.isTile(x + 1, y + 1)) {
			char resource = bc.getTileResource(gameID, x + 1, y + 1);
			String source = Character.toString(resource);
			card = bct.getMaterialCard(source, playerID);
		}
		if (pd.isTile(x - 1, y)) {
			char resource = bc.getTileResource(gameID, x - 1, y);
			String source = Character.toString(resource);
			card = bct.getMaterialCard(source, playerID);
		}
		if (pd.isTile(x, y - 1)) {
			char resource = bc.getTileResource(gameID, x, y - 1);
			String source = Character.toString(resource);
			card = bct.getMaterialCard(source, playerID);
		}
		if (pd.isTile(x - 1, y - 1)) {
			char resource = bc.getTileResource(gameID, x - 1, y - 1);
			String source = Character.toString(resource);
			card = bct.getMaterialCard(source, playerID);
		}

		if (card != null) {
			String cardid = card.getIdCard();
			pd.addMaterialCard(gameID, cardid, playerID);
		}
	}

}