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
	
	public String getName(int id) ///gets your username from the database 
	{
		String result ="";
		
		Statement stmt = null;
		String query = "SELECT username FROM speler WHERE idspeler =" + id;
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

	public String getColor(int playerid)///gets the color you are from the database
	{
		String result ="";
		Statement stmt = null;
		String query = "SELECT kleur FROM speler WHERE idspeler =" + playerid;
		try
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
			{
				result = rs.getString(playerid);
			}
			stmt.close();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return result;
}
	public int getgame_id(int playerid)///gets the gameid from the database
	{
		String result ="";
		Statement stmt = null;
		String query = "SELECT idspel FROM speler WHERE idspeler =" + playerid;
		try
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
			{
				result = rs.getString(playerid);
			}
			stmt.close();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		int resultint =Integer.parseInt(result);
		return resultint;
}
	
	public int getorder_number(int playerid)///gets the order your in from the database
	{
		String result ="";
		Statement stmt = null;
		String query = "SELECT volgnr FROM speler WHERE idspeler =" + playerid;
		try
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
			{
				result = rs.getString(playerid);
			}
			stmt.close();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		int resultint =Integer.parseInt(result);
		return resultint;
}


}
