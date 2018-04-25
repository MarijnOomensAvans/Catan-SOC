package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainDAL {
	private Connection conn;

	public MainDAL()
	{
		conn = null;
	}

	public boolean loadDataBaseDriver(String driverName)
	{
		try
		{
			// Load the JDBC driver
			Class.forName(driverName);
		} catch (ClassNotFoundException e)
		{
			// Could not find the database driver
			System.out.println("ClassNotFoundException : " + e.getMessage());
			return false;
		}
		return true;
	}

	public boolean makeConnection()
	{
		try
		{
			conn = DriverManager
					.getConnection("jdbc:mysql://databases.aii.avans.nl/bdjong1_db2?user=bdjong1&password=Ab12345");
		
		} catch (SQLException ex)
		{
			// handle any errors
			
			return false;
		}
		return true;
	}
	
	public Connection getConnection() {
		return conn;
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
				result = rs.getString(id);
			}
			stmt.close();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return result;
	}

public String getColor(int id)
{
	String result ="";
	String idstring = Integer.toString(id);
	Statement stmt = null;
	String query = "SELECT kleur FROM speler WHERE idspeler =" + idstring;
	try
	{
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next())
		{
			result = rs.getString(id);
		}
		stmt.close();
	} catch (SQLException e)
	{
		System.out.println(e.getMessage());
	}
	return result;
}
}