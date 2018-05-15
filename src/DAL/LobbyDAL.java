package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.LobbyGameInfo;

public class LobbyDAL {

	public LobbyDAL() {
		System.out.println("LobbyDAL gestart");
	}

	public ArrayList<String> getAllAccounts() {

		ArrayList<String> accounts = new ArrayList<String>();
		try {
			Connection conn = MainDAL.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT username FROM account");

			while (rs.next()) {
				accounts.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	public ArrayList<LobbyGameInfo> getAllActiveGames(String username) {
		ArrayList<LobbyGameInfo> games = new ArrayList<LobbyGameInfo>();
		try {
			Connection conn = MainDAL.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
						"SELECT sp.idspel, sb.username"
						+ " FROM account AS a"
						+ " JOIN speler AS s ON a.username = s.username"
						+ " JOIN spel AS sp ON sp.idspel = s.idspel"
						+ " JOIN speler AS sb ON sp.beurt_idspeler = sb.idspeler"
						+ " WHERE s.username = '" + username + "'"
					);
			while (rs.next()) {
				int id = rs.getInt(1);
				String userTurn = rs.getString(2);
				games.add(new LobbyGameInfo(id, userTurn));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return games;
	}

}
