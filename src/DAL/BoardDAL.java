package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Controller.LoginController;

public class BoardDal {
	Connection conn = MainDAL.getConnection();

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

	public void updateTile(int idspel, int idtegel, int x, int y, char idgrondstofsoort, int idgetalfiche) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			// Add  + "', `idgetalfiche`='" + idgetalfiche + "' " + " later.
			stmt.executeUpdate("UPDATE `tegel` SET `idgrondstofsoort`='" + idgrondstofsoort + "' WHERE `idspel`= "
					+ idspel + " AND `x` = " + x + " AND `y` = " + y + " AND `idtegel` = " + idtegel);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public void removeChits(int idspel, int x, int y) {
//		Statement stmt = null;
//		try {
//			stmt = conn.createStatement();
//			stmt.executeUpdate("UPDATE `tegel` SET `idgetalfiche`=NULL " + "WHERE `idspel`= "
//					+ idspel + " AND `x` = " + x + " AND `y` = " + y);
//			stmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	private boolean hasHarbour(int x, int y) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT haven FROM locatie WHERE x = '" + x + "' && y = '" + y + "'");
			if (rs.next()) {
				if (rs.getInt(1) == 1) {
					return true;
				} else {
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
				ResultSet rs = stmt
						.executeQuery("SELECT idgrondstofsoort FROM locatie WHERE x = '" + x + "' && y = '" + y + "'");

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
			ResultSet rs = stmt.executeQuery("SELECT idgrondstofsoort FROM tegel WHERE idspel = '" + idspel
					+ "' && x = '" + x + "' && y = '" + y + "'");

			if (rs.next()) {
				return rs.getString(s).charAt(0);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getChit(int idspel, int x, int y) {
		String s = "idgetalfiche";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT idgetalfiche FROM tegel WHERE idspel = '" + idspel
					+ "' && x = '" + x + "' && y = '" + y + "'");

			if (rs.next()) {
				return rs.getInt(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void setBoardType(int idspel, int boardType) {
		Statement stmt = null;
		String query = "UPDATE spel SET israndomboard = '" + (boardType - 1) + "' WHERE idspel = '" + idspel + "' ";
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}