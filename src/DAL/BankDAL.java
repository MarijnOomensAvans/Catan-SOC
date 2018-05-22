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
	
	
	public String getId(int id) {
		String result ="";
		Statement stmt = null;
		int limit  = id-1;
		String query = "SELECT idgrondstofkaart FROM grondstofkaart LIMIT "+limit+","+id ;
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


	public String getKindOfMaterial(int id) {
		String result ="";
		Statement stmt = null;
		int limit  = id-1;
		String query = "SELECT idgrondstofsoort FROM grondstofkaart LIMIT "+limit+","+id ;
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
