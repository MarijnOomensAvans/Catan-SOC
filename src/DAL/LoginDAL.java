package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAL {
	@SuppressWarnings("unused")
	private MainDAL mdal = new MainDAL();
	private Connection conn = MainDAL.getConnection();

	public boolean hasUsername(String username) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT username FROM account WHERE username LIKE binary '" + username + "'");
			rs.next();
			if(rs.getRow() == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void addAccount(String username, String password) {
		Statement stmt = null;
		try {
			 stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO account VALUES ('" + username +"', '" + password + "')");
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean userHasPassword(String username, String password) {
		Statement stmt = null;
		try {
			 stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM account WHERE username LIKE binary '" + username + "' && wachtwoord LIKE binary '" + password + "'");
			rs.next();
			if(rs.getRow() == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
