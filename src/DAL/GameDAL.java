package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controller.LoginController;
import Model.ingame.PlayerStats;
import Model.ingame.StreetModel;

public class GameDAL {

	Connection conn = MainDAL.getConnection();

	public ArrayList<PlayerStats> getPlayerStats(int gameid) {
		ArrayList<PlayerStats> stats = new ArrayList<PlayerStats>();
		ArrayList<String> usernames = getUsernames(gameid);
		ArrayList<StreetModel> allStreets = getStreetsInGame(gameid);
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
			ArrayList<StreetModel> playerStreets = new ArrayList<StreetModel>(); // The list of streets belonging to the
																					// player at the current index

			stats.get(i).setUsername(usernames.get(i));
			stats.get(i).setDevelopmentPoints(getDevelopmentPoints(getPlayerId(gameid, stats.get(i).getUsername())));

			if (stats.get(i).getUsername().equals(biggestArmyUsername)) {
				stats.get(i).setBiggestArmy(true);
			}

			if (stats.get(i).getUsername().equals(longestRouteUsername)) {
				stats.get(i).setTradeRoute(true);
			}

			for (int n = 0; n < allStreets.size(); n++) {
				if (stats.get(i).getPlayerId() == allStreets.get(n).getPlayerId()) {
					playerStreets.add(allStreets.get(n));
				}
			}

			stats.get(i).setStreets(playerStreets);
		}

		return stats;
	}

	public String getLongestRouteUsername(int gameid) {
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

	public void setLongestRoute(int gameid, String username) {
		int playerid = getPlayerId(gameid, username);
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE spel SET langste_hr_idspeler = " + playerid + " WHERE idspel = " + gameid);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private PlayerStats getStats(int playerid) {
		PlayerStats stats = null;
		int resourceCards = 0;
		int developmentCards = 0;
		int knightCards = 0;
		int villageCount = 0;
		int cityCount = 0;

		/* GET CARDS */
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT o.naam, so.gespeeld FROM speler s JOIN spelerontwikkelingskaart so "
							+ "ON s.idspeler = so.idspeler JOIN ontwikkelingskaart o "
							+ "ON o.idontwikkelingskaart = so.idontwikkelingskaart " + "WHERE s.idspeler = "
							+ playerid);
			while (rs.next()) {
				developmentCards++;

				if ((rs.getString(1).equals("ridder")) && (rs.getInt(2) == 1)) {
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

		/* GET BUILDING POINTS */
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT s.stuksoort, COUNT(s.stuksoort) FROM spelerstuk st JOIN stuk s ON st.idstuk = s.idstuk"
							+ " WHERE s.stuksoort NOT LIKE 'straat' AND st.idspeler = " + playerid
							+ " AND st.x_van IS NOT null AND st.y_van IS NOT NULL " + " GROUP BY s.stuksoort");
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

		stats = new PlayerStats(resourceCards, developmentCards, knightCards, villageCount, cityCount, developmentCards,
				playerid);
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
			stmt.executeUpdate("UPDATE spel SET grootste_rm_idspeler = " + playerid + " WHERE idspel = " + gameid);
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
			ResultSet rs = stmt.executeQuery("SELECT idspeler FROM speler " + "WHERE (idspel = " + gameid
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

	private int getDevelopmentPoints(int playerid) {
		int devPoints = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT COUNT(*) FROM spelerontwikkelingskaart so JOIN ontwikkelingskaart o "
							+ " ON so.idontwikkelingskaart = o.idontwikkelingskaart "
							+ " WHERE (o.naam LIKE ('kathedraal') OR o.naam LIKE ('bibliotheek') OR o.naam LIKE ('markt') OR o.naam LIKE ('universiteit') "
							+ " OR o.naam LIKE ('parlement')) AND so.idspeler = " + playerid);
			while (rs.next()) {
				devPoints = rs.getInt(1);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return devPoints;
	}

	public void setPlayerTurn(int gameid, String username) {
		if (!username.equals("") && username != null) {
			try {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate("UPDATE spel SET beurt_idspeler = " + this.getPlayerId(gameid, username)
						+ " WHERE idspel = " + gameid);
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE spel SET gedobbeld = " + 0 + " WHERE idspel = " + gameid);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean hasRolledDice(int gameid) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT gedobbeld FROM spel WHERE idspel = " + gameid);
			while (rs.next()) {
				if (rs.getInt(1) == 0) {
					return false;
				} else {
					return true;
				}
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public void shouldRefresh(int gameid) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE speler SET shouldrefresh = 1 WHERE idspel = " + gameid);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeShouldRefresh(int gameid, String username) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE speler SET shouldrefresh = 0 WHERE idspel = " + gameid + " AND username LIKE '"
					+ username + "'");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setPlayersCanceld(int gameid) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE speler SET speelstatus = 'uitgespeeld' WHERE idspel = " + gameid);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean hasShouldRefresh(int gameid, String username) {
		boolean value = false;

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT shouldrefresh FROM speler WHERE idspeler = " + getPlayerId(gameid, username));
			while (rs.next()) {
				if (rs.getInt(1) == 0) {
					return false;
				} else {
					return true;
				}
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return value;
	}

	public int hasBuilt(int gameid) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT count(*)  FROM spelerstuk ss JOIN speler s "
					+ "ON ss.idspeler = s.idspeler JOIN stuk st " + "ON st.idstuk = ss.idstuk WHERE s.username LIKE '"
					+ LoginController.getUsername() + "' AND s.idspel = " + gameid);
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int getBuildingCount(int gameid, int volgnr) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT count(*)  FROM spelerstuk ss JOIN speler s " + "ON ss.idspeler = s.idspeler JOIN stuk st "
							+ "ON st.idstuk = ss.idstuk WHERE s.volgnr = '" + volgnr + "' AND s.idspel = " + gameid);
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public void setFirstTurn(int gameid, boolean b) {
		int value = 0;
		if (b) {
			value = 1;
		}
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE spel SET eersteronde = " + value + " WHERE idspel = " + gameid);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private ArrayList<StreetModel> getStreetsInGame(int gameid) {
		ArrayList<StreetModel> allStreets = new ArrayList<StreetModel>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT st.idspeler, x_van, x_naar, y_van, y_naar FROM spelerstuk st\r\n"
					+ "		JOIN speler s ON st.idspeler = s.idspeler WHERE s.idspel = " + gameid
					+ " AND idstuk LIKE 'r%'");
			while (rs.next()) {
				allStreets.add(new StreetModel(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allStreets;
	}

	public void shouldRefresh(int gameID, int playerID) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE speler SET shouldrefresh = 1 WHERE idspel = " + gameID + " AND idspeler = " + playerID);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
