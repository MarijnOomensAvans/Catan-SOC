package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankDAL {
	
	Connection conn;
	
	public BankDAL() {
		conn = MainDAL.getConnection();
	}
	
	
	public String getId(int id) {  // gets the card id from the database so the cards are connected to the database
		String result ="";
		Statement stmt = null;
		String query = "";
		if( id == 0) {
			query = "SELECT idgrondstofkaart FROM grondstofkaart LIMIT 1" ;
		}else {
		int limit  = id-1;
		query = "SELECT idgrondstofkaart FROM grondstofkaart LIMIT "+limit+",1" ;
		}
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


	public String getKindOfMaterial(int id) {/// give the character from the database so that the card knows what type it is
		String result ="";
		Statement stmt = null;
		int limit  = id-1;
		String query = "SELECT idgrondstofsoort FROM grondstofkaart LIMIT "+limit+",1" ;
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
	
	public String getDevId(int id) {
		String result ="";
		Statement stmt = null;
		String query = "";
		if( id == 0) {
			query = "SELECT idontwikkelingskaart FROM ontwikkelingskaart LIMIT 1" ;
		}else {
		int limit  = id-1;
		query = "SELECT idontwikkelingskaart FROM ontwikkelingskaart LIMIT "+limit+",1" ;
		}
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
	public String getDevName(int id) {
		String result ="";
		Statement stmt = null;
		String query = "";
		if( id == 0) {
			query = "SELECT naam FROM ontwikkelingskaart LIMIT 1" ;
		}else {
		int limit  = id-1;
		query = "SELECT naam FROM ontwikkelingskaart LIMIT "+limit+",1" ;
		}
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
	public void addDevCardstoDB(int gameid,String idDevCard) {
		Statement stmt = null;
		String query = "INSERT INTO spelerontwikkelingskaart(idspel, gespeeld, idontwikkelingskaart) VALUES ("+gameid+" ,"+ "0"+", '" +idDevCard+"')";
		
		try
		{
			stmt = conn.createStatement();
			 stmt.executeUpdate(query);
			
			stmt.close();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	


}
