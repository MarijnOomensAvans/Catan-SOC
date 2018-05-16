package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controller.LoginController;
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
			
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	public ArrayList<LobbyGameInfo> getAllActiveGames() {
		ArrayList<LobbyGameInfo> games = new ArrayList<LobbyGameInfo>();
		try {
			Connection conn = MainDAL.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT s.idspel FROM spel s "
					+ "JOIN speler sp "
					+ "ON s.idspel = sp.idspel "
					+ "WHERE sp.username LIKE '" + LoginController.getUsername() + "'");
			/*
			 * Get all users in game
			 */
			while(rs.next()) {
				int gameID = rs.getInt(1);
				ArrayList<String> players = getUsersInGame(gameID);
				games.add(new LobbyGameInfo(gameID, players));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return games;
	}
	
	private ArrayList<String> getUsersInGame(int gameID){
		ArrayList<String> players = new ArrayList<String>();
		
		try {
			Connection conn = MainDAL.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT sp.username FROM spel s " + 
					"JOIN speler sp ON s.idspel = sp.idspel " + 
					"WHERE (sp.speelstatus LIKE 'geaccepteerd' OR sp.speelstatus LIKE 'uitdager') " + 
					"AND s.idspel = " + gameID);
			while(rs.next()) {
				players.add(rs.getString(1));
			}
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return players;
	}
	
	

}
