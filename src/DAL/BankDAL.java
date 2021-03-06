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

	public String getId(int id) { // gets the card id from the database so the cards are connected to the database
		String result = "";
		Statement stmt = null;
		String query = "";
		if (id == 1) {
			query = "SELECT idgrondstofkaart FROM grondstofkaart LIMIT 1";
		} else {
			int limit = id - 1;
			query = "SELECT idgrondstofkaart FROM grondstofkaart LIMIT " + limit + ",1";
		}
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				result = rs.getString(1);
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public String getKindOfMaterial(int id) {// give the character from the database so that the card knows what type
												// it is
		String result = "";
		Statement stmt = null;
		int limit = id - 1;
		String query = "SELECT idgrondstofsoort FROM grondstofkaart LIMIT " + limit + ",1";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				result = rs.getString(1);
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return result;

	}

	public String getDevId(int id) {
		String result = "";
		Statement stmt = null;
		String query = "";
		if (id == 0) {
			query = "SELECT idontwikkelingskaart FROM ontwikkelingskaart LIMIT 1";
		} else {
			int limit = id - 1;
			query = "SELECT idontwikkelingskaart FROM ontwikkelingskaart LIMIT " + limit + ",1";
		}
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				result = rs.getString(1);
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public String getDevName(int id) {
		String result = "";
		Statement stmt = null;
		String query = "";
		if (id == 0) {
			query = "SELECT naam FROM ontwikkelingskaart LIMIT 1";
		} else {
			int limit = id - 1;
			query = "SELECT naam FROM ontwikkelingskaart LIMIT " + limit + ",1";
		}
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				result = rs.getString(1);
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public void addDevCardstoDB(int gameid, String idDevCard) {
		Statement stmt = null;
		String query = "INSERT INTO spelerontwikkelingskaart(idspel, gespeeld, idontwikkelingskaart) VALUES (" + gameid
				+ " ," + "0" + ", '" + idDevCard + "')";
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);

			stmt.close();
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
		}
	}

	public void addCardstoDB(int gameid, String idCard) {
		Statement stmt = null;
		String query = "INSERT spelergrondstofkaart(idspel,idgrondstofkaart) VALUES (" + gameid + " ,'" + idCard + "')";
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);

			stmt.close();
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
		}

	}

	public void trade(int playerid, String cardId, int gameid) {
		Statement stmt = null;
		String query = "UPDATE spelergrondstofkaart SET idspeler = " + playerid + " WHERE idgrondstofkaart = '" + cardId
				+ "' AND idspel = " +gameid;

		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);

			stmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	public void tradeBank(int playerid, String cardId, int gameid) {
		Statement stmt = null;
		String query = "UPDATE spelergrondstofkaart SET idspeler = '" + playerid + "' WHERE idgrondstofkaart = '" + cardId
				+ "' AND idspeler is null AND idspel = '" + gameid + "'";

		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);

			stmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public void deleteCards(String cardid, int gameid, int playerid) {
		Statement stmt = null;
		String query = "UPDATE spelergrondstofkaart SET idspeler = null WHERE idgrondstofkaart = '" + cardid + "' AND idspeler = '" + playerid + "' AND idspel = '" + gameid + "'";


		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);

			stmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public int getPlayerid(String cardid,int gameid) {
		int result = 0;
		Statement stmt = null;
		String query = "SELECT idspeler FROM spelergrondstofkaart WHERE idgrondstofkaart = '" + cardid + "'"+" AND idspel ="+ gameid;

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				result = rs.getInt(1);
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public String getDevPlayerid(String cardid, int gameid) {
		String result = "";
		Statement stmt = null;
		String query = "SELECT idspeler FROM spelerontwikkelingskaart WHERE idontwikkelingskaart = '" + cardid + "' AND idspel = '" + gameid + "'";

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			result = rs.getString(1);
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public String getavailableDevCard(String cardid, int gameid) {
		String result = "";
		Statement stmt = null;
		String query = "SELECT idspeler FROM spelerontwikkelingskaart WHERE idontwikkelingskaart = '" + cardid + "' AND idspel = '" + gameid + "' AND idspeler is null";

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			result = rs.getString(1);
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	
		
	}

	public boolean getidDevcards(int gameid) {
		boolean result = true;
		Statement stmt = null;
		String query = "SELECT idontwikkelingskaart, idspel FROM spelerontwikkelingskaart where idspel = '" + gameid + "' AND idspeler is null";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (!rs.next() ) {
				result = true;
			}
			else {
				result = false;
			}
			
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}


	public boolean hasMatCards(int gameid) {
	
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM spelergrondstofkaart WHERE idspel = " + gameid);
			while(rs.next()) {
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean hasDevCards(int gameid) {
	
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM spelerontwikkelingskaart WHERE idspel = " + gameid);
			while(rs.next()) {
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
