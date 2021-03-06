package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainDAL {
	private static Connection conn;

	public MainDAL() {
		conn = null;
		loadDataBaseDriver("com.mysql.jdbc.Driver");
		makeConnection();
	}

	public boolean loadDataBaseDriver(String driverName) {
		try {
			// Load the JDBC driver
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// Could not find the database driver
			System.out.println("ClassNotFoundException : " + e.getMessage());
			return false;
		}
		return true;
	}

	public boolean makeConnection() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://databases.aii.avans.nl/1_soprj4_catan?user=42IN04SOc&password=cheeseburger");

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			return false;
		}
		return true;
	}

	public static Connection getConnection() {
		return conn;
	}
}