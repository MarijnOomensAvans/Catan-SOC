package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAL.MainDAL;

public class BoardDAL {
	Connection conn = MainDAL.getConnection();

	// ------------------------------------------------------------------------------------------------------------------------
	// This will put the tiles into the database.
	public void setTile(int idspel, int idtegel, int x, int y, char idgrondstofsoort, int idgetalfiche) {
		Statement stmt = null;
		if (idgrondstofsoort != 'X') {
			String query = "INSERT INTO tegel VALUES('" + idspel + "', '" + idtegel + "' , '" + x + "' , '" + y
					+ "' , '" + idgrondstofsoort + "' ,  '" + idgetalfiche + "')";
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(query);
				stmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} else { // if tile is desert
			String query = "INSERT INTO tegel(idspel,idtegel,x,y,idgrondstofsoort) VALUES('" + idspel + "', '" + idtegel
					+ "' , '" + x + "' , '" + y + "' , '" + idgrondstofsoort + "')";
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(query);
				stmt.close();
				this.setRobberTile(idspel, idtegel);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// ------------------------------------------------------------------------------------------------------------------------
	// This will update the tiles if a different boardtype is chosen.
	public void updateTile(int idspel, int idtegel, int x, int y, char idgrondstofsoort, int idgetalfiche) {
		Statement stmt = null;
		if (idgetalfiche != 0) {
			try {
				stmt = conn.createStatement();
				// Add + "', `idgetalfiche`='" + idgetalfiche + "' " + " later.
				stmt.executeUpdate("UPDATE `tegel` SET `idgrondstofsoort`='" + idgrondstofsoort + "', `idgetalfiche`='"
						+ idgetalfiche + "' " + " WHERE `idspel`= " + idspel + " AND `x` = " + x + " AND `y` = " + y
						+ " AND `idtegel` = " + idtegel);
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				stmt = conn.createStatement();
				// Add + "', `idgetalfiche`='" + idgetalfiche + "' " + " later.
				stmt.executeUpdate(
						"UPDATE `tegel` SET `idgrondstofsoort`='" + idgrondstofsoort + "'" + " WHERE `idspel`= "
								+ idspel + " AND `x` = " + x + " AND `y` = " + y + " AND `idtegel` = " + idtegel);
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// ------------------------------------------------------------------------------------------------------------------------
	// This removes the chits when a new board type is chosen.
	public void removeChits(int idspel, int x, int y) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE `tegel` SET `idgetalfiche`=NULL " + "WHERE `idspel`= " + idspel + " AND `x` = "
					+ x + " AND `y` = " + y);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ------------------------------------------------------------------------------------------------------------------------
	// Check for Harbour
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

	// ------------------------------------------------------------------------------------------------------------------------
	// Check for Harbour resource if it has a harbour.
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

	// ------------------------------------------------------------------------------------------------------------------------
	// Check for resource of tile.
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

	// ------------------------------------------------------------------------------------------------------------------------
	// Check for chit of tile
	public int getChit(int idspel, int x, int y) {
		String s = "idgetalfiche";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT idgetalfiche FROM tegel WHERE idspel = '" + idspel + "' && x = '"
					+ x + "' && y = '" + y + "'");

			if (rs.next()) {
				return rs.getInt(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// ------------------------------------------------------------------------------------------------------------------------
	// Check for boardtype of game.
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

	// ------------------------------------------------------------------------------------------------------------------------
	// Set robber position
	public void setRobberTile(int gameid, int tile) {
		Statement stmt = null;
		String query = "UPDATE spel SET struikrover_idtegel = '" + tile + "' WHERE idspel = '" + gameid + "' ";
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void setRobberPosition(int gameid, int x, int y) {
		Statement stmt = null;
		String query = "SELECT idtegel from tegel where idspel = " +gameid+ " AND x = " +x+ " AND y = " +y;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			int tile = rs.getInt(1);
			stmt.close();
			setRobberTile(gameid, tile);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public int getRobberPosition(int gameid) {
		int i = 0;
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT struikrover_idtegel FROM spel WHERE idspel = " + gameid;
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			i = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;

	}

	public int getRobberXPosition(int gameid, int position) {
		int i = 0;
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT x FROM Tegel WHERE idspel = " + gameid + " AND idtegel =" + position;
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			i = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public int getRobberYPosition(int gameid, int position) {
		int i = 0;
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT y FROM Tegel WHERE idspel = " + gameid + " AND idtegel =" + position;
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			i = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public int getXTile(int number,int gameid) {
		int i = 0;
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT x FROM Tegel WHERE idspel = " + gameid + " AND idgetalfiche =" + number;
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			i = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
		
	}
	public int getYTile(int number,int gameid) {
		int i = 0;
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT y FROM Tegel WHERE idspel = " + gameid + " AND idgetalfiche =" + number;
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			i = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
		
	}
	
	public int getStoneHarbourplayer() {
		int i = 0;
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT idspeler FROM spelerstuk WHERE x_van = 2 AND y_van = 2 AND idspeler is not null";
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			i = rs.getInt(1);
		} catch (SQLException e) {
		
		}
		return i;
	}

	public int getBuildingplayer(int x, int y, Integer idspeler) {
		int i = 0;
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT idspeler FROM spelerstuk WHERE x_van = " + x + " AND y_van =" + y+" AND idspeler = " + idspeler;
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			i = rs.getInt(1);
		} catch (SQLException e) {
		
		}
		return i;
		
	}

	public boolean isVillage(int idplayer, int x, int y) {
		String i = null;
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT idstuk FROM spelerstuk WHERE idspeler = "+ idplayer+ " AND idstuk LIKE 'd%' AND x_van ="+x+" AND y_van ="+y;
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			i = rs.getString(1);
		} catch (SQLException e) {
		
		}
		if(i!= null) {
			return true;
		}else {
		return false;
		}
	}

	public boolean isCity(int playerid, int x, int y) {
		String i = null;
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT idstuk FROM spelerstuk WHERE idspeler = "+playerid+ " AND idstuk LIKE 'c%' AND x_van ="+x+" AND y_van ="+y;
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			i = rs.getString(1);
		} catch (SQLException e) {
		
		}
		if(i!= null) {
			return true;
		}else {
		return false;
	}

	}

	public boolean hasRobber(int number,int gameID) {
		boolean hasRobber = false;
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT struikrover_idtegel FROM spel WHERE idspel = " + gameID;
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			if(rs.getInt(1) == getIDTileFromChit(number, gameID)) {
				hasRobber = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hasRobber;
	}
	
	private int getIDTileFromChit(int chitnumber,int gameID) {
		int i = 0;
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT idtegel FROM tegel WHERE idgetalfiche = " + chitnumber + " AND idspel = " + gameID;
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			i = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
}