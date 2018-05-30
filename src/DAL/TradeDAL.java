package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class TradeDAL {
	
	Connection conn;
<<<<<<< HEAD
	private int counter;
	private boolean checkFirstTime = false;
=======
	@SuppressWarnings("unused")
	private int size;
>>>>>>> 64b4117ee8a1ad962f3f86cdc08a809913d7852e
	
	public TradeDAL() {
		 conn = MainDAL.getConnection();
	}
	
	public void setTradeOffer(int idPlayer, int givesStone, int givesWool, int givesOre, int givesWheat,
			int givesWood, int asksStone, int asksWool, int asksOre, int asksWheat, int asksWood, 
			boolean accepted)
	{	//with boolean
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
	
	public void setTradeOffer(int idPlayer, int givesStone, int givesWool, int givesOre, int givesWheat,
			int givesWood, int asksStone, int asksWool, int asksOre, int asksWheat, int asksWood)
	{	//without boolean
		Statement stmt = null;
		String query = "INSERT INTO ruilaanbod(idspeler, geeft_baksteen	, geeft_wol, geeft_erts, geeft_graan, "
				+ "geeft_hout, vraagt_baksteen, vraagt_wol, vraagt_erts, vraagt_graan, vraagt_hout) "
				+ "VALUES("+idPlayer+", "+givesStone+", "+givesWool+", "+givesOre+", "+givesWheat+""
						+ ", "+givesWood+", "+asksStone+", "+asksWool+", "+asksOre+", "+asksWheat+""
						+ ", "+asksWood+")	";
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
	
	public ArrayList<Integer> getTradeOffer(int playerid)
	{
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		Statement stmt = null;
		String query = "SELECT * FROM ruilaanbod WHERE idspeler =" + playerid;
		try
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
			{
				for(int i=1; i<=11; i++)
				{
					results.add(rs.getInt(i));
				}		
				results.add(rs.getInt(12));
			}
			
			stmt.close();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return results;
	}

	public boolean getResponses(int playerid) {
		boolean results = false;
		
		Statement stmt = null;
		String query = "SELECT geaccepteerd FROM ruilaanbod WHERE idspeler ="+ playerid;
		try
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
			{	
				results =rs.getBoolean(1);
			}
			
			stmt.close();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return results;
	}

	public ArrayList<Integer> getTradeResponses(int playerid) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		Statement stmt = null;
		String query = "SELECT geeft_baksteen, geeft_wol, geeft_erts, geeft_graan, geeft_hout, vraagt_baksteen, vraagt_wol, vraagt_erts, vraagt_graan, vraagt_hout FROM ruilaanbod WHERE idspeler =" + playerid;
		try
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
				for (int i = 1; i<=10;i++) {
				results.add(rs.getInt(i));
				}
			stmt.close();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return results;
	}

	public ArrayList<Integer> getLatestTradeOfferold(ArrayList<Integer> otherIds){
		ArrayList<Integer> results = new ArrayList<>();

		Statement stmt = null;
		int counter =0;
		String sizequery = "SELECT COUNT(*) FROM ruilaanbod";

		try
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sizequery);
			rs.next();
			counter = rs.getInt(1);
			
			if(counter > 0)
			{
				String query = "SELECT idspeler FROM ruilaanbod";
				
				rs = stmt.executeQuery(query);
				
				while (rs.next())
				{
					if(otherIds.contains(rs.getInt(1)))
					{
						results.add(rs.getInt(1));
						results.addAll(getTradeResponses(rs.getInt(1)));
						return results;
					}
				}
			
			}
		}catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public ArrayList<Integer> getLatestTradeOffer(int playerid){
		ArrayList<Integer> results = new ArrayList<>();
		results = getTradeResponses(playerid);
		return results;

		//Statement stmt = null;
//		int size = 0;
//		String sizequery = "SELECT COUNT(*) FROM ruilaanbod";

//		try
//		{
//			stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(sizequery);
//			rs.next();
//			size = rs.getInt(1);
			
//			if(checkFirstTime == false)
//			{
//				counter = size;
//				checkFirstTime = true;
//				return null;
//			}
			
//			if(size > counter)
//			{
//				int difference = size - counter;
//				String query = "SELECT idspeler FROM ruilaanbod WHERE LIMIT 1";
//				
//				ResultSet rs = stmt.executeQuery(query);
//				rs.next();
//				results = getTradeResponses(rs.getInt(1));
//				return results;
//				while (rs.next())
//				{
//				
//					if(otherIds.contains(rs.getInt(1)))
//					{
//						results = getTradeResponses(rs.getInt(1));
//						return results;
//					}
//				}
			
			
//		}catch (SQLException e)
//		{
//			System.out.println(e.getMessage());
//		}
	//	return null;
	}


	
	

}
