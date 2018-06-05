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

		return stats;
	}

	private PlayerStats getStats(int playerid) {
		PlayerStats stats = null;
		String username = "TEST";
		int resourceCards = 0;
		int developmentCards = 0;
		int knightCards = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT o.naam, s.username FROM speler s JOIN spelerontwikkelingskaart so "
					+ "ON s.idspeler = so.idspeler JOIN ontwikkelingskaart o "
					+ "ON o.idontwikkelingskaart = so.idontwikkelingskaart " + "WHERE s.idspeler = " + playerid);
			while (rs.next()) {
				if (username.equals("")) {
					username = rs.getString(2);
				}
				developmentCards++;
				if (rs.getString(1).equals("ridder")) {
					knightCards++;
				}
			}

			Statement stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2
					.executeQuery("SELECT count(sgk.idspeler) FROM grondstofkaart gk JOIN spelergrondstofkaart sgk "
							+ "ON gk.idgrondstofkaart = sgk.idgrondstofkaart " + "WHERE sgk.idspeler = " + playerid);
			while (rs.next()) {
				resourceCards = rs.getInt(1);
			}
			stmt.close();
			stmt2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		stats = new PlayerStats(username, resourceCards, developmentCards, knightCards);
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


}
