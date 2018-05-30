package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controller.LoginController;
import Model.lobby.LobbyGameInfo;
import Model.lobby.LobbyGameState;
import Model.lobby.LobbyInvite;

public class LobbyDAL {

	Connection conn = MainDAL.getConnection();

	public ArrayList<String> getAllAccounts() {

		ArrayList<String> accounts = new ArrayList<String>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT username FROM account");

			while (rs.next()) {
				accounts.add(rs.getString(1));
			}

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	public ArrayList<LobbyGameInfo> getAllActiveGames() {
		ArrayList<LobbyGameInfo> games = new ArrayList<LobbyGameInfo>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT s.idspel FROM spel s " + "JOIN speler sp "
					+ "ON s.idspel = sp.idspel " + "WHERE sp.username LIKE '" + LoginController.getUsername() + "' ");
			/*
			 * Get all users in game
			 */
			while (rs.next()) {
				int gameID = rs.getInt(1);
				ArrayList<String> players = getPlayers(gameID);
				String currentTurn = getPlayerTurn(gameID);
				games.add(new LobbyGameInfo(gameID, players, currentTurn));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return games;
	}

	public ArrayList<String> getUsersInGame(int gameID) {
		ArrayList<String> players = new ArrayList<String>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT sp.username FROM spel s " + "JOIN speler sp ON s.idspel = sp.idspel "
							+ "WHERE (sp.speelstatus LIKE 'geaccepteerd') " + "AND s.idspel = " + gameID);
			while (rs.next()) {
				players.add(rs.getString(1));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return players;
	}

	public ArrayList<LobbyInvite> getAllInvites() {
		ArrayList<LobbyInvite> invites = new ArrayList<LobbyInvite>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT s.idspel FROM spel s JOIN speler sp ON s.idspel = sp.idspel " + "WHERE sp.username LIKE '"
							+ LoginController.getUsername() + "' " + "AND sp.speelstatus LIKE 'uitgedaagde'");

			while (rs.next()) {
				int gameID = rs.getInt(1);
				String host = getHost(gameID);
				invites.add(new LobbyInvite(gameID, host));

			}

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return invites;
	}

	private String getHost(int gameID) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT sp.username FROM spel s " + "JOIN speler sp ON s.idspel = sp.idspel "
							+ "WHERE sp.speelstatus LIKE 'uitdager' " + "AND s.idspel = " + gameID);

			while (rs.next()) {
				return rs.getString(1);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "dbErr: host not found";
	}

	public void acceptInvite(int gameID) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE `bdjong1_db2`.`speler` SET `speelstatus`='geaccepteerd' " + "WHERE `idspel`= "
					+ gameID + " " + "AND username LIKE '" + LoginController.getUsername() + "'");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void rejectInvite(int gameID) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE `bdjong1_db2`.`speler` SET `speelstatus`='geweigerd' " + "WHERE `idspel`= "
					+ gameID + " " + "AND username LIKE '" + LoginController.getUsername() + "'");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getPlayers(int gameID) {
		ArrayList<String> players = new ArrayList<String>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT sp.username FROM speler sp\r\n"
					+ "WHERE (sp.speelstatus LIKE 'geaccepteerd' OR sp.speelstatus LIKE 'uitdager')\r\n"
					+ "AND sp.idspel = " + gameID);

			while (rs.next()) {
				players.add(rs.getString(1));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return players;
	}

	// Checks the highest game ID and increments the returned number with 1, then
	// puts that number in the database. Returns the number to the
	// LobbyModel.
	public int makeNewGameID() {
		int gameid = getHighestGameID() + 1;
		try {
			Statement stmt = conn.createStatement();

			stmt.executeUpdate("INSERT INTO spel(idspel) VALUES (" + gameid + ")");
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gameid;
	}

	// A private method to get the highest game id in the databes, this method is
	// only used in the makenNewGameID method
	private int getHighestGameID() {
		int highestGameId = 0;
		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT MAX(idspel) FROM spel");
			while (rs.next()) {
				highestGameId = rs.getInt(1);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return highestGameId;
	}

	public boolean isRandomBoard(int gameID) {
		int isRandom = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT israndomboard FROM spel" + " WHERE spel.idspel = " + gameID);
			rs.next();
			isRandom = rs.getInt(1);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (isRandom == 1) {
			return true;
		} else {
			return false;
		}
	}

	public String getPlayerTurn(int gameID) {
		String currentPlayer = "";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT sp.username FROM spel s " + "JOIN speler sp "
					+ "ON s.beurt_idspeler = sp.idspeler " + "WHERE s.idspel = " + gameID);
			rs.next();
			if(rs.getRow() == 1) {
				currentPlayer = rs.getString(1);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currentPlayer;
	}

	public int getFreePlayerid() {
		int playerid = 1;
		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT MAX(idspeler) FROM speler");
			rs.next();
			playerid = rs.getInt(1) + 1;
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return playerid;
	}

	public int createInvitation(String username, int gameid, int volgnr, String kleur, String speelstatus) {
		int playerid = 0;
		try {
			Statement stmt = conn.createStatement();
			playerid = getFreePlayerid();

			System.out.println(playerid);

			stmt.executeUpdate(
					"INSERT INTO speler (`idspeler`, `idspel`, `username`, `kleur`, `speelstatus`, `shouldrefresh`, `volgnr`) "
							+ "VALUES ( " + playerid + ", " + gameid + ", '" + username + "' , '" + kleur + "' , '"
							+ speelstatus + "', '0', '" + volgnr + "');");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return playerid;
	}

	public void updateInvitation(String username, int gameid, int volgnr) {
		try {
			Statement stmt = conn.createStatement();

			stmt.executeUpdate("UPDATE speler " + "SET `username`= '" + username
					+ "', `speelstatus`='uitgedaagde' WHERE idspel = " + gameid + "AND volgnr = " + volgnr);

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void initializeGame(int gameid) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(
					"INSERT INTO spel (`idspel`, `israndomboard`, `eersteronde`) VALUES (" + gameid + ", '0', '1')");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void initializePlayerTurn(int gameid, int playerid) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE 'spel' SET 'beurt_idspeler' = " + playerid + " WHERE 'idspel' = " + gameid);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setBoardTypeRandom(int gameid) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE spel SET israndomboard = " + 1 + " WHERE idspel = " + gameid);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<LobbyGameState> getHostedGames() {
		ArrayList<LobbyGameState> hostedGames = new ArrayList<LobbyGameState>();
		ArrayList<Integer> currentGames = new ArrayList<Integer>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT s.idspel, sp.speelstatus FROM spel s JOIN speler sp ON s.idspel = sp.idspel"
							+ " WHERE sp.username = '" 	+ LoginController.getUsername()
							+ "' AND speelstatus LIKE 'uitdager'");

			while (rs.next()) {
				currentGames.add(rs.getInt(1));
			}

			for (int i = 0; i < currentGames.size(); i++) {

				PlayerInfo playerInfo = getPlayerInfo(currentGames.get(i).intValue());

				for (int n = 0; n < playerInfo.playerStatus.size(); n++) {
					if (playerInfo.playerStatus.get(n).equals("uitgedaagde")
							|| playerInfo.playerStatus.get(n).equals("geweigerd")) {
						LobbyGameState game = new LobbyGameState(currentGames.get(i).intValue(), playerInfo.playerNames, playerInfo.playerStatus);
						hostedGames.add(game);
						break;
					}
				}
			}

			// Get players and player statuses

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hostedGames;
	}

	private PlayerInfo getPlayerInfo(int gameid) {

		PlayerInfo playerInfo = new PlayerInfo();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT sp.username, sp.speelstatus FROM speler sp WHERE sp.idspel = "
					+ gameid + " ORDER BY volgnr ASC");

			while (rs.next()) {
				playerInfo.playerNames.add(rs.getString(1));
				playerInfo.playerStatus.add(rs.getString(2));
			}

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return playerInfo;
	}

	private class PlayerInfo {
		public ArrayList<String> playerNames;
		public ArrayList<String> playerStatus;

		public PlayerInfo() {
			playerNames = new ArrayList<String>();
			playerStatus = new ArrayList<String>();
		}
	}

}
