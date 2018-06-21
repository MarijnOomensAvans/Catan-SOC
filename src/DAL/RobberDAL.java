package DAL;

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

	public void removeHalf(int gameid) {
		ArrayList<Integer>playerIds = getPlayerids(gameid);
		Statement stmt = null;
		String query;
		Random rand = new Random();
		int random = 0;
		int half = 0;
		String cardId;

		try {
			for (int i = 0; i < playerIds.size(); i++) {
				if (getHandSize(playerIds.get(i)) > 7) {

					ArrayList<String> cards = getHand(playerIds.get(i));
					half = cards.size() / 2;
					for (int j = 0; j < half; j++) {
						random = rand.nextInt(cards.size());
						cardId = cards.get(random);
						query = "UPDATE spelergrondstofkaart SET idspeler = NULL WHERE idspeler = " + playerIds.get(i)
								+ " AND idgrondstofkaart = '" + cardId + "'";
						stmt = conn.createStatement();
						stmt.executeUpdate(query);
						cards.remove(random);
						stmt.close();
					}
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Integer> getPlayerids(int gameid) {
		ArrayList<Integer> playerids = new ArrayList<Integer>();
		Statement stmt = null;
		String query = "SELECT idspeler FROM speler WHERE idspel = " + gameid;

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				playerids.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return playerids;
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
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return results;
	}

	public void pickRandomCard(int playerId, int opponentId) {
		Statement stmt = null;
		String query;
		Random rand = new Random();
		int random = 0;
		String cardId;

		try {
			ArrayList<String> cards = getHand(opponentId);
				random = rand.nextInt(cards.size());
				cardId = cards.get(random);
				query = "UPDATE spelergrondstofkaart SET idspeler = " +playerId+ " WHERE idspeler = " + opponentId
						+ " AND idgrondstofkaart = '" + cardId + "'";
				stmt = conn.createStatement();
				stmt.executeUpdate(query);
				stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public ArrayList<Integer> getOtherPlayerid(int gameid, int playerid) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Statement stmt = null;
		String query = "SELECT idspeler FROM speler WHERE idspel =" + gameid + " AND idspeler NOT IN(" + playerid + ")";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				result.add(rs.getInt(1));

			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public String getOtherPlayerName(int playerid) {
		String result = "";
		Statement stmt = null;
		String query = "SELECT username FROM speler WHERE idspeler =" + playerid;
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

	public boolean robberHasPosition(int x, int y, int gameID) {
		boolean result = false;
		int tileID = 0;
		Statement stmt = null;
		String query = "SELECT struikrover_idtegel FROM spel WHERE idspel = " + gameID + ";";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
			tileID = rs.getInt(1);
			}
			stmt.close();
			if(tileID == coordinatesTileID(x,y,gameID)) {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	private int coordinatesTileID(int x, int y, int gameID) {
		int result = 0;
		Statement stmt = null;
		String query = "SELECT idtegel FROM tegel WHERE x = " + x + " AND y = " + y + " AND idspel = " + gameID + ";";
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

}
