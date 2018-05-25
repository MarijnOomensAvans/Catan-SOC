package Controller;

import DAL.MainDAL;
import DAL.PersonDal;
import DAL.TradeDAL;
import Model.TradeOffer;
import View.TradeGui;

public class TradeController {
	
	private MainDAL md;
	private TradeDAL td;
	
	public TradeController(MainDAL md, int playerid) {
		this.md = md;
		this.td = new TradeDAL();
		new TradeGui(this, playerid);
	}
	
	public void createOffer(int idPlayer, int givesStone, int givesWool, int givesOre, int givesWheat,
			int givesWood, int asksStone, int asksWool, int asksOre, int asksWheat, int asksWood, 
			boolean accepted) {
		new TradeOffer(td, idPlayer, givesStone, givesWool,givesOre,givesWheat,
			 givesWood,asksStone, asksWool,  asksOre, asksWheat, asksWood, 
			accepted);
	}
	
	public void createOffer(int idPlayer, int givesStone, int givesWool, int givesOre, int givesWheat,
			int givesWood, int asksStone, int asksWool, int asksOre, int asksWheat, int asksWood) {
		new TradeOffer(td, idPlayer, givesStone, givesWool,givesOre,givesWheat,
			 givesWood,asksStone, asksWool,  asksOre, asksWheat, asksWood);
	}

	public void getOffer(){
		td.getTradeOffer(1);
	}
}
