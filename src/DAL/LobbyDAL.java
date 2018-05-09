package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LobbyDAL {

	public LobbyDAL() {
		
	}
	
	public ArrayList<String> getAllAccounts() {
		
		ArrayList<String> accounts = new ArrayList<String>();
		
		try {
			Connection conn = MainDAL.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT username FROM account");
			while(rs.next()) {
				accounts.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accounts;
	}
	
}
