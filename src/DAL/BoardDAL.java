package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BoardDal {
	MainDAL db = new MainDAL();
	Connection conn;

	public void setTile(int idspel, int idtegel, int x, int y, char idgrondstofsoort, int idgetalfiche) {
		Statement stmt = null;
		if (idtegel != 1009) {
			String query = "INSERT INTO tegel VALUES('" + idspel + "', '" + idtegel + "' , '" + x + "' , '" + y
					+ "' , '" + idgrondstofsoort + "' ,  '" + idgetalfiche + "')";
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(query);
				stmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} else {
			String query = "INSERT INTO tegel(idspel,idtegel,x,y,idgrondstofsoort) VALUES('" + idspel + "', '" + idtegel
					+ "' , '" + x + "' , '" + y + "' , '" + idgrondstofsoort + "')";
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(query);
				stmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private boolean hasHarbour(int x, int y) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT haven FROM locatie WHERE x = '" + x + "' && y = '" + y + "'");
			if (rs.next()) {
				if(rs.getInt(1) == 1) {
					return true;
				}
				else {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public char getLocationHarbourResource(int x, int y) {
		String s = "idgrondstofsoort";
		if (hasHarbour(x, y)) {
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT idgrondstofsoort FROM locatie WHERE x = '" + x + "' && y = '" + y + "'");
				
				if (rs.next()) {
					return rs.getString(s).charAt(0);
				} else {
					return 0;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public char getResourceTile(int idspel, int x, int y) {
		String s = "idgrondstofsoort";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT idgrondstofsoort FROM tegel WHERE idspel = '" + idspel + "' && x = '" + x + "' && y = '" + y + "'");
			
			if(rs.next()) {
				return rs.getString(s).charAt(0);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}