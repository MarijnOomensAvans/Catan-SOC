package Controller;

import java.util.ArrayList;

import DAL.PersonDAL;
import Model.Die;
import Model.MaterialCard;

public class DieController 
{	
	private int gameID;
	private Die d1;
	private Die d2;
	private RobberController rb;
	private IngameController inGameController;
	private BoardController bc;
	private BankController bct;
	private PersonDAL pd;
	
	public DieController(int gameID, RobberController rb, IngameController inGameController, BoardController bc,
			BankController bct, PersonDAL pd)
	{
		this.pd = pd;
		this.bct = bct;
		this.bc = bc;
		this.inGameController = inGameController;
		this.gameID = gameID;
		this.rb = rb;
		d1 = new Die(1, gameID);
		d2 = new Die(2, gameID);

	}
	
	public int[] rollDice() 
	{
		d1.rollDie();
		d2.rollDie();
		
		int diceResult[] = {d1.getStoredDie(), d2.getStoredDie()};
		int diceRes = d1.getStoredDie() + d2.getStoredDie();
		lookAtResult(diceRes);
		return diceResult;
	}
	
	
	public void lookAtResult(int diceResult) {
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ids = inGameController.getPlayerIds(gameID);
		if(diceResult == 7) {
			rb.robberThrown(diceResult,gameID);
		}else if(diceResult == 2) {
				int x =bc.getXTile(1, gameID);
				int y =bc.getYTile(1, gameID);
				char resource =bc.getTileResource(gameID, x, y);
				String source =Character.toString(resource);
						for(int i =0; i< ids.size(); i++) {
							if(bc.getBuildingplayer(x+1,y,ids.get(i)) != 0) {
								MaterialCard card =bct.getMaterialCard(source, ids.get(i));
								String cardid =card.getIdCard();
								pd.addMaterialCard(gameID, cardid, ids.get(i));
						}
							else if(bc.getBuildingplayer(x+1,y+1,ids.get(i)) != 0) {
								MaterialCard card =bct.getMaterialCard(source, ids.get(i));
								String cardid =card.getIdCard();
								pd.addMaterialCard(gameID, cardid, ids.get(i));
						}
							else if(bc.getBuildingplayer(x,y+1,ids.get(i)) != 0) {
								MaterialCard card =bct.getMaterialCard(source, ids.get(i));
								String cardid =card.getIdCard();
								pd.addMaterialCard(gameID, cardid, ids.get(i));
						}
							else if(bc.getBuildingplayer(x,y,ids.get(i)) != 0) {
								MaterialCard card =bct.getMaterialCard(source, ids.get(i));
								String cardid =card.getIdCard();
								pd.addMaterialCard(gameID, cardid, ids.get(i));
						}
							else if(bc.getBuildingplayer(x-1,y,ids.get(i)) != 0) {
								MaterialCard card =bct.getMaterialCard(source, ids.get(i));
								String cardid =card.getIdCard();
								pd.addMaterialCard(gameID, cardid, ids.get(i));
						}else if(bc.getBuildingplayer(x-1,y-1,ids.get(i)) != 0) {
							MaterialCard card =bct.getMaterialCard(source, ids.get(i));
							String cardid =card.getIdCard();
							pd.addMaterialCard(gameID, cardid, ids.get(i));
							
					}else if(bc.getBuildingplayer(x,y-1,ids.get(i)) != 0) {
						MaterialCard card =bct.getMaterialCard(source, ids.get(i));
						String cardid =card.getIdCard();
						pd.addMaterialCard(gameID, cardid, ids.get(i));
				}
					}
			}else if(diceResult == 3) {
				int x =bc.getXTile(2, gameID);
				int y =bc.getYTile(2, gameID);
				int x2 = bc.getXTile(3, gameID);
				int y2 = bc.getXTile(3, gameID);
				char resource =bc.getTileResource(gameID, x, y);
				char resource2 = bc.getTileResource(gameID, x2, y2);
				String source =Character.toString(resource);
				String source2 =Character.toString(resource2);
				for(int i =0; i< ids.size(); i++) {
					if(bc.getBuildingplayer(x+1,y,ids.get(i)) != 0) {
						MaterialCard card =bct.getMaterialCard(source, ids.get(i));
						String cardid =card.getIdCard();
						pd.addMaterialCard(gameID, cardid, ids.get(i));
				}
					else if(bc.getBuildingplayer(x+1,y+1,ids.get(i)) != 0) {
						MaterialCard card =bct.getMaterialCard(source, ids.get(i));
						String cardid =card.getIdCard();
						pd.addMaterialCard(gameID, cardid, ids.get(i));
				}
					else if(bc.getBuildingplayer(x,y+1,ids.get(i)) != 0) {
						MaterialCard card =bct.getMaterialCard(source, ids.get(i));
						String cardid =card.getIdCard();
						pd.addMaterialCard(gameID, cardid, ids.get(i));
				}
					else if(bc.getBuildingplayer(x,y,ids.get(i)) != 0) {
						MaterialCard card =bct.getMaterialCard(source, ids.get(i));
						String cardid =card.getIdCard();
						pd.addMaterialCard(gameID, cardid, ids.get(i));
				}
					else if(bc.getBuildingplayer(x-1,y,ids.get(i)) != 0) {
						MaterialCard card =bct.getMaterialCard(source, ids.get(i));
						String cardid =card.getIdCard();
						pd.addMaterialCard(gameID, cardid, ids.get(i));
				}else if(bc.getBuildingplayer(x-1,y-1,ids.get(i)) != 0) {
					MaterialCard card =bct.getMaterialCard(source, ids.get(i));
					String cardid =card.getIdCard();
					pd.addMaterialCard(gameID, cardid, ids.get(i));
					
			}else if(bc.getBuildingplayer(x,y-1,ids.get(i)) != 0) {
				MaterialCard card =bct.getMaterialCard(source, ids.get(i));
				String cardid =card.getIdCard();
				pd.addMaterialCard(gameID, cardid, ids.get(i));
		}
			
				if(bc.getBuildingplayer(x2+1,y2,ids.get(i)) != 0) {
					MaterialCard card =bct.getMaterialCard(source2, ids.get(i));
					String cardid =card.getIdCard();
					pd.addMaterialCard(gameID, cardid, ids.get(i));
			}
				else if(bc.getBuildingplayer(x2+1,y2+1,ids.get(i)) != 0) {
					MaterialCard card =bct.getMaterialCard(source2, ids.get(i));
					String cardid =card.getIdCard();
					pd.addMaterialCard(gameID, cardid, ids.get(i));
			}
				else if(bc.getBuildingplayer(x2,y2+1,ids.get(i)) != 0) {
					MaterialCard card =bct.getMaterialCard(source2, ids.get(i));
					String cardid =card.getIdCard();
					pd.addMaterialCard(gameID, cardid, ids.get(i));
			}
				else if(bc.getBuildingplayer(x2,y2,ids.get(i)) != 0) {
					MaterialCard card =bct.getMaterialCard(source2, ids.get(i));
					String cardid =card.getIdCard();
					pd.addMaterialCard(gameID, cardid, ids.get(i));
			}
				else if(bc.getBuildingplayer(x-2,y2,ids.get(i)) != 0) {
					MaterialCard card =bct.getMaterialCard(source2, ids.get(i));
					String cardid =card.getIdCard();
					pd.addMaterialCard(gameID, cardid, ids.get(i));
			}else if(bc.getBuildingplayer(x2-1,y2-1,ids.get(i)) != 0) {
				MaterialCard card =bct.getMaterialCard(source2, ids.get(i));
				String cardid =card.getIdCard();
				pd.addMaterialCard(gameID, cardid, ids.get(i));
				
		}else if(bc.getBuildingplayer(x2,y2-1,ids.get(i)) != 0) {
			MaterialCard card =bct.getMaterialCard(source2, ids.get(i));
			String cardid =card.getIdCard();
			pd.addMaterialCard(gameID, cardid, ids.get(i));
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


	
}