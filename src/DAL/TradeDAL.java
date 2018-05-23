package DAL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TradeDAL {
	
	Connection conn;
	
	public TradeDAL() {
		 conn = MainDAL.getConnection();
	}
	
	public void setTradeOffer(int idPlayer, int givesStone, int givesWool, int givesOre, int givesWheat,
			int givesWood, int asksStone, int asksWool, int asksOre, int asksWheat, int asksWood, 
			boolean accepted)
	{
		Statement stmt = null;
		String query = "INSERT INTO ruilaanbod(idspeler, geeft_baksteen	, geeft_wol, geeft_erts, geeft_graan, "
				+ "geeft_hout, vraagt_baksteen, vraagt_wol, vraagt_erts, vraagt_graan, vraagt_hout, "
				+ "geaccepteerd) "
				+ "VALUES("+idPlayer+", "+givesStone+", "+givesWool+", "+givesOre+", "+givesWheat+""
						+ ", "+givesWood+", "+asksStone+", "+asksWool+", "+asksOre+", "+asksWheat+""
						+ ", "+asksWood+", "+accepted+")	";
		try
		{
			stmt = conn.createStatement();

			@SuppressWarnings("unused")
			int i = stmt.executeUpdate(query);
			
			stmt.close();
			
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	

}
