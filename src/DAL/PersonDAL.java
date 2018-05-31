package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonDAL {
	
	Connection conn;
	
	
	public PersonDAL() {
		 conn = MainDAL.getConnection();
	}
	
	public String getName(int id)
	{
		String result ="";
		String idstring = Integer.toString(id);
		Statement stmt = null;
		String query = "SELECT username FROM speler WHERE idspeler =" + idstring;
		try
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
			{
				result = rs.getString(1);
			}
			stmt.close();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return result;
	}

	public String getColor(int playerid, int gameid)
	{
		String result ="";
		Statement stmt = null;
		String query = "SELECT kleur FROM speler WHERE idspeler =" + playerid+ " AND idspel ="+ gameid;
		try
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
			{
				result = rs.getString(1);
			}
			stmt.close();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return result;
}
	
	public int getorder_number(int playerid, int gameid)
	{
		String result ="";
		Statement stmt = null;
		String query = "SELECT volgnr FROM speler WHERE idspeler =" + playerid+ " AND idspel ="+ gameid;
		try
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
			{
				result = rs.getString(1);
			}
			stmt.close();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		int resultint =Integer.parseInt(result);
		return resultint;
}
	
	public void addMaterialCard(int idgame,String idcard, int idplayer) {
		Statement stmt = null;
		String query = "UPDATE spelergrondstofkaart SET idspeler ="+ idplayer+ " WHERE idspel ="+ idgame+" AND idgrondstofkaart = '"+idcard+"'";
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
	public void addDevelopmentCard(int idgame, String iddevcard, int idplayer, boolean cardPlayed ) {
		Statement stmt = null;
		String query = "UPDATE spelerontwikkelingskaart SET idspeler ="+ idplayer+ " WHERE idspel ="+ idgame+" AND idontwikkelingskaart = '"+ iddevcard+ "'";
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
	public void useDevelopmentCard(int idgame, String iddevcard, int idplayer, boolean cardPlayed ) {
		Statement stmt = null;
		String query = "UPDATE spelerontwikkelingskaart SET gespeeld ="+ cardPlayed +" WHERE idspel ="+ idgame+" AND idontwikkelingskaart = '"+ iddevcard + "' AND idspeler = "+ idplayer +"";
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
	public String getDevUsed(int idgame, String iddevcard, int idplayer)
	{
		String result ="";
		Statement stmt = null;
		String query = "SELECT gespeeld FROM spelerontwikkelingskaart WHERE idspeler =" + idplayer+ " AND idspel ="+ idgame + " AND idontwikkelingskaart = '"+ iddevcard +"'";
		try
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
			{
				result = rs.getString(1);
			}
			stmt.close();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return result;
			
		
}
}



