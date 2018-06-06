package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.ingame.PlayerStats;

public class SpelDAL {

	Connection conn = MainDAL.getConnection();

	public ArrayList<PlayerStats> getPlayerStats(int gameid) {
		ArrayList<PlayerStats> stats = new ArrayList<PlayerStats>();
		ArrayList<String> usernames = getUsernames(gameid);
		String biggestArmyUsername = getBiggestArmyUsername(gameid);
		String longestRouteUsername = getLongestRouteUsername(gameid);

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT s.idspeler FROM speler s WHERE s.idspel = " + gameid);
			while (rs.next()) {
				stats.add(getStats(rs.getInt(1)));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		usernames = getUsernames(gameid);

		for (int i = 0; i < 4; i++) {
			stats.get(i).setUsername(usernames.get(i));

			if (stats.get(i).getUsername().equals(biggestArmyUsername)) {
				stats.get(i).setBiggestArmy(true);
			}
			
			if(stats.get(i).getUsername().equals(longestRouteUsername)) {
				stats.get(i).setTradeRoute(true);
			}
		}

		return stats;
	}

	private String getLongestRouteUsername(int gameid) {
		String username = "Niemand";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT s.langste_hr_idspeler, sp.username FROM spel s JOIN speler sp ON s.langste_hr_idspeler = sp.idspeler WHERE s.idspel = "
							+ gameid);
			while (rs.next()) {
				username = rs.getString(2);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return username;
	}

	private PlayerStats getStats(int playerid) {
		PlayerStats stats = null;
		int resourceCards = 0;
		int developmentCards = 0;
		int knightCards = 0;
		int villageCount = 0;
		int cityCount = 0;
		boolean hasTradeRoute = false;
		boolean hasBiggestArmy = false;

		/* GET CARDS */
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT o.naam FROM speler s JOIN spelerontwikkelingskaart so "
					+ "ON s.idspeler = so.idspeler JOIN ontwikkelingskaart o "
					+ "ON o.idontwikkelingskaart = so.idontwikkelingskaart " + "WHERE s.idspeler = " + playerid);
			while (rs.next()) {
				developmentCards++;

				if (rs.getString(1).equals("ridder")) {
					knightCards++;
				}
			}
			stmt.close();
			Statement stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2
					.executeQuery("SELECT count(sgk.idspeler) FROM grondstofkaart gk JOIN spelergrondstofkaart sgk "
							+ "ON gk.idgrondstofkaart = sgk.idgrondstofkaart " + "WHERE sgk.idspeler = " + playerid);
			while (rs2.next()) {
				resourceCards = rs2.getInt(1);
			}
			stmt2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/* GET POINTS */
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT s.stuksoort, COUNT(s.stuksoort) FROM spelerstuk st JOIN stuk s ON st.idstuk = s.idstuk"
							+ " WHERE s.stuksoort NOT LIKE 'straat' AND st.idspeler = " + playerid
							+ " GROUP BY s.stuksoort");
			while (rs.next()) {
				if (rs.getString(1).equals("dorp")) {
					villageCount = rs.getInt(2);
				}
				if (rs.getString(1).equals("stad")) {
					cityCount = rs.getInt(2);
				}
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		stats = new PlayerStats(resourceCards, developmentCards, knightCards, villageCount, cityCount, developmentCards);
		return stats;
	}

	public String getPlayerTurn(int gameID) {
		String currentPlayer = "";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT sp.username FROM spel s " + "JOIN speler sp "
					+ "ON s.beurt_idspeler = sp.idspeler " + "WHERE s.idspel = " + gameID);
			rs.next();
			if (rs.getRow() == 1) {
				currentPlayer = rs.getString(1);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currentPlayer;
	}

	private ArrayList<String> getUsernames(int gameid) {
		ArrayList<String> usernames = new ArrayList<String>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT username FROM speler WHERE idspel = " + gameid + " ORDER BY volgnr ASC");
			while (rs.next()) {
				usernames.add(rs.getString(1));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usernames;
	}

	public void setBiggestArmy(int gameid, String username) {
		int playerid = getPlayerId(gameid, username);
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE spel SET grootste_rm_idspeler = " + +playerid + " WHERE idspel = " + gameid);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getBiggestArmyUsername(int gameid) {
		String username = "Niemand";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT s.grootste_rm_idspeler, sp.username FROM spel s JOIN speler sp ON s.grootste_rm_idspeler = sp.idspeler WHERE s.idspel = "
							+ gameid);
			while (rs.next()) {
				username = rs.getString(2);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return username;
	}

	public int getPlayerId(int gameid, String username) {
		int playerid = 0;

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT idspeler FROM speler " + "WHERE (gameid = " + gameid
					+ " AND username LIKE '" + username + "')");
			while (rs.next()) {
				playerid = rs.getInt(1);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return playerid;
	}

}
