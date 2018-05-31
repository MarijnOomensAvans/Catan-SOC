package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDal {
	
	Connection conn;
	
	
	public PersonDal() {
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
		String idstring = Integer.toString(playerid);
		Statement stmt = null;
		String query = "SELECT kleur FROM speler WHERE idspeler =" + idstring+ " AND idspel ="+ gameid;
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
		String idstring = Integer.toString(playerid);
		Statement stmt = null;
		String query = "SELECT volgnr FROM speler WHERE idspeler =" + idstring+ " AND idspel ="+ gameid;
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

	public String getOtherPlayerName(int playerid) {
		String result ="";
		Statement stmt = null;
		String query = "SELECT username FROM speler WHERE idspeler ="+ playerid;
		try
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
			{
				result =rs.getString(1);
				
			}
			stmt.close();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return result;
		
	}

	public ArrayList<Integer> getOtherid(int gameid, int playerid) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Statement stmt = null;
		String query = "SELECT idspeler FROM speler WHERE idspel =" + gameid+ " AND idspeler NOT IN("+ playerid+")";
		try
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
			{
				result.add(rs.getInt(1));
				
			}
			stmt.close();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	
<<<<<<< HEAD
	public void updateCard(String cardId, int playerid) {
		
		Statement stmt = null;
		String query = "UPDATE spelergrondstofkaart SET idspeler = "+playerid+ " WHERE idgrondstofkaart = "+cardId;
=======
	public void updateCard(int otherplayerid, String id) {
		Statement stmt = null;
		String query = "UPDATE spelergronstofkaart SET spelerid ="+ otherplayerid+ "WHERE idgrondstofkaart ='" + id+ "'";
>>>>>>> c5a5a63007f24129eb7f61521eed4b104ed1a93e
		try
		{
			stmt = conn.createStatement();
			stmt.executeQuery(query);
			
<<<<<<< HEAD
			stmt.close();
=======
>>>>>>> c5a5a63007f24129eb7f61521eed4b104ed1a93e
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
<<<<<<< HEAD
=======
	
>>>>>>> c5a5a63007f24129eb7f61521eed4b104ed1a93e
	}


}
