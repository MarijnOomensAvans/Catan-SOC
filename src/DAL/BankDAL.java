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


	public String getKindOfMaterial(int id) {
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
	


}
