package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		String query = "INSERT INTO spelergrondstofkaart(idspel,idgrondstofkaart,idspeler) VALUES("+ idgame+", '"+idcard+"',"+idplayer+")";
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
