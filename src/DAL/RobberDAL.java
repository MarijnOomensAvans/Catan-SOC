/*package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class RobberDAL {

	Connection conn;

	public RobberDAL() {
		conn = MainDAL.getConnection();
	}

	public void removeHalf() {
		ArrayList<Integer>playerIds = getPlayerids();
		Statement stmt = null;
		String query = "query";
		Random rand = new Random();
		int random = 0;
		int half = 0;
		String cardId = "";

		try {
			for (int i = 0; i < playerIds.size(); i++) {
				if (getHandSize(playerIds.get(i)) > 7) {

					ArrayList<String> cards = getHand(playerIds.get(i));
					half = cards.size() / 2;
					for (int j = 0; j < half; j++) {
						random = rand.nextInt(cards.size());
						cardId = cards.get(random);
						query = "UPDATE spelergrondstofkaart SET idspeler = NULL WHERE idspeler = " + playerIds.get(i)
								+ " AND idgrondstofkaart = '" +cardId+ "'";
						stmt = conn.createStatement();
						stmt.executeUpdate(query);
						cards.remove(random);
					}
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Integer> getPlayerids(int gameid) {
		Statement stmt = null;
		String query = "SELECT idspeler FROM speler WHERE idspel = " + gameid;

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public int getHandSize(int playerId) {
		Statement stmt = null;
		String query = "SELECT COUNT(*) FROM spelergrondstofkaart WHERE idspeler = " + playerId;

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public ArrayList<String> getHand(int playerId) {
		ArrayList<String> results = new ArrayList<String>();
		Statement stmt = null;
		String query = "SELECT idgrondstofkaart FROM spelergrondstofkaart WHERE idspeler = " + playerId;

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				results.add(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return results;
	}

}
*/