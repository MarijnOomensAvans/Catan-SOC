package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Player;

public class LoginDAL {
	
	Connection conn;
	
	public LoginDAL() {
		conn = MainDAL.getConnection();
	}
	
	public boolean hasUsername(String username) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT username FROM account WHERE username = '" + username + "'");
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
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO account VALUES ('" + username +"', '" + password + "')");
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean userHasPassword(String username, String password) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM account WHERE username = '" + username + "' && wachtwoord = '" + password + "'");
			rs.next();
			if(rs.getRow() == 0) {
				return false;
			} else {
				Player p = new Player();
				p.setName(username);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
