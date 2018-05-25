package Model;

import DAL.TradeDAL;

public class TradeOffer {
	
	private TradeDAL td;
	
	private int idPlayer;
	private int givesStone;
	private int givesWool;
	private int givesOre;
	private int givesWheat;
	private int givesWood;
	private int asksStone;
	private int asksWool;
	private int asksOre;
	private int asksWheat;
	private int asksWood;
	private boolean accepted;
	
	public TradeOffer(TradeDAL td, int idPlayer, int givesStone, int givesWool, int givesOre, int givesWheat,
			int givesWood, int asksStone, int asksWool, int asksOre, int asksWheat, int asksWood, 
			boolean accepted)
	{
		this.td = td;
		td.setTradeOffer(idPlayer, givesStone, givesWool, givesOre, givesWheat, givesWood, 
				asksStone, asksWool, asksOre, asksWheat, asksWood, accepted);
		
//		this.idPlayer = idPlayer;
//		this.givesStone = givesStone;
//		this.givesWool = givesWool;
//		this.givesOre = givesOre;
//		this.givesWheat = givesWheat;
//		this.givesWood = givesWood;
//		this.asksStone = asksStone;
//		this.asksWool = asksWool;
//		this.asksOre = asksOre;
//		this.asksWheat = asksWheat;
//		this.asksWood = asksWood;
//		this.accepted = accepted;
	}
	
	public TradeOffer(TradeDAL td, int idPlayer, int givesStone, int givesWool, int givesOre, int givesWheat,
			int givesWood, int asksStone, int asksWool, int asksOre, int asksWheat, int asksWood)
	{
		this.td = td;
		td.setTradeOffer(idPlayer, givesStone, givesWool, givesOre, givesWheat, givesWood, 
				asksStone, asksWool, asksOre, asksWheat, asksWood);
	}
}
