package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDAL {

	Connection conn;

	public PersonDAL() {
		conn = MainDAL.getConnection();
	}

	public String getName(int id) {
		String result = "";
		String idstring = Integer.toString(id);
		Statement stmt = null;
		String query = "SELECT username FROM speler WHERE idspeler =" + idstring;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				result = rs.getString(1);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String getColor(int playerid, int gameid) {
		String result = "";
		String idstring = Integer.toString(playerid);
		Statement stmt = null;
		String query = "SELECT kleur FROM speler WHERE idspeler =" + idstring + " AND idspel =" + gameid;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				result = rs.getString(1);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String getorder_number(int playerid, int gameid) {
		String result = "";
		Statement stmt = null;
		String query = "SELECT volgnr FROM speler WHERE idspeler =" + playerid + " AND idspel =" + gameid;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				result = rs.getString(1);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void addMaterialCard(int idgame, String idcard, int idplayer) {
		Statement stmt = null;
		String query = "UPDATE spelergrondstofkaart SET idspeler =" + idplayer + " WHERE idspel =" + idgame
				+ " AND idgrondstofkaart = '" + idcard + "'";
		try {
			stmt = conn.createStatement();

			@SuppressWarnings("unused")
			int i = stmt.executeUpdate(query);

			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	public ArrayList<Integer> getOtherid(int gameid, int playerid) {
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

	public String getOtherPlayerCard(int otherplayerid, String kind) {
		String cardid = "";
		Statement stmt = null;
		String query = "SELECT idgrondstofkaart FROM spelergrondstofkaart WHERE idspeler = " + otherplayerid
				+ " AND idgrondstofkaart LIKE '" + kind + "%' LIMIT 1";

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			cardid = rs.getString(1);
			stmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return cardid;
	}

	public void updateCard(String cardId, int playerId, int gameId) {

		Statement stmt = null;
		String query = "UPDATE spelergrondstofkaart SET idspeler = " + playerId + " WHERE idgrondstofkaart = '" + cardId
				+ "' AND idspel = " +gameId;

		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);

			stmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public void addDevelopmentCard(int idgame, String iddevcard, int idplayer, boolean cardPlayed) {
		Statement stmt = null;
		String query = "UPDATE spelerontwikkelingskaart SET idspeler =" + idplayer + " WHERE idspel = " + idgame
				+ " AND idontwikkelingskaart = '" + iddevcard + "'";
		try {
			stmt = conn.createStatement();
			@SuppressWarnings("unused")
			int i = stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void useDevelopmentCard(String iddevcard, int idplayer) {
		Statement stmt = null;
		String query = "UPDATE spelerontwikkelingskaart SET gespeeld = 1 WHERE idontwikkelingskaart LIKE '" + iddevcard
				+ "' AND idspeler = " + idplayer + " AND gespeeld = 0 LIMIT 1";
		try {
			stmt = conn.createStatement();
			@SuppressWarnings("unused")
			int i = stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public String getDevUsed(int idgame, String iddevcard, int idplayer) {
		String result = "";
		Statement stmt = null;
		String query = "SELECT gespeeld FROM spelerontwikkelingskaart WHERE idspeler =" + idplayer + " AND idspel ="
				+ idgame + " AND idontwikkelingskaart = '" + iddevcard + "'";
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

	public int amountDeveloperCards(int idplayer, boolean cardPlayed, String cardtype) {
		int amount = 0;
		Statement stmt = null;
		String query = "SELECT COUNT(idontwikkelingskaart) FROM spelerontwikkelingskaart WHERE gespeeld=" + cardPlayed
				+ " AND idspeler = '" + idplayer + "' AND idontwikkelingskaart LIKE '" + cardtype + "'";
		try {
			stmt = conn.createStatement();
			@SuppressWarnings("unused")
			ResultSet i = stmt.executeQuery(query);
			while (i.next()) {
				amount = i.getInt(1);
			}

			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return amount;
	}

	public int amountResourceCards(int idplayer, String cardtype) {
		int amount = 0;
		Statement stmt = null;
		String query = "SELECT COUNT(idgrondstofkaart) FROM spelergrondstofkaart WHERE idspeler = '" + idplayer
				+ "' AND idgrondstofkaart LIKE '" + cardtype + "'";
		try {
			stmt = conn.createStatement();
			ResultSet i = stmt.executeQuery(query);
			while (i.next()) {
				amount = i.getInt(1);
			}

			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return amount;
	}

	public String getMaterialCards(int playerid, int i) {
		ArrayList<String> results = new ArrayList<String>();
		String returnString = "";
		Statement stmt = null;
		String query = "SELECT idgrondstofkaart FROM spelergrondstofkaart WHERE idspeler = " + playerid + "";
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
		returnString = results.get(i);
		return returnString;

	}

	public int countMaterialCards(int playerid) {
		String cardid = "";
		Statement stmt = null;
		String query = "SELECT COUNT(idgrondstofkaart) FROM spelergrondstofkaart WHERE idspeler = " + playerid + "";

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			cardid = rs.getString(1);
			stmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		int returnInt = Integer.parseInt(cardid);
		return returnInt;
	}

	public String getBuilding(int spelerID, String pieceID) {
		String result = "";
		Statement stmt = null;
		String query = "SELECT idstuk FROM spelerstuk WHERE idspeler =" + spelerID + " AND idstuk LIKE '" + pieceID
				+ "%'";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				if (result.equals("")) {
					result = rs.getString(1);
				} else {
					result = result + "," + rs.getString(1);
				}
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	
	public String getAllBuildings(int spelerID) {
		String result = "";
		Statement stmt = null;
		String query = "SELECT idstuk FROM spelerstuk WHERE idspeler =" + spelerID + "";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				if (result.equals("")) {
					result = rs.getString(1);
				} else {
					result = result + "," + rs.getString(1);
				}
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public String getAllPlayers(int gameID) {
		String result = "";
		Statement stmt = null;
		String query = "SELECT idstuk FROM spelerstuk WHERE idspeler =" + gameID + "";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				if (result.equals("")) {
					result = rs.getString(1);
				} else {
					result = result + "," + rs.getString(1);
				}
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public String getCoords(int spelerID, String pieceID, String coord) {
		String result = "";
		Statement stmt = null;
		String query = "SELECT " + coord + " FROM spelerstuk WHERE idspeler =" + spelerID + " AND idstuk LIKE '"
				+ pieceID + "'";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				if (result.equals("")) {
					result = rs.getString(1);
				} else {
					result = result + "," + rs.getString(1);
				}
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public int getCoordX(int spelerID, String pieceID) {
		int result = 0;
		Statement stmt = null;
		String query = "SELECT x_van FROM spelerstuk WHERE idspeler =" + spelerID + " AND idstuk LIKE '"
				+ pieceID + "'";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				if (result == 0) {
					result = rs.getInt(1);
				} else {
					return result;
				}
			}
			stmt.close();
		} catch (SQLException e) { 
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public int getCoordY(int spelerID, String pieceID) {
		int result = 0;
		Statement stmt = null;
		String query = "SELECT y_van FROM spelerstuk WHERE idspeler =" + spelerID + " AND idstuk LIKE '"
				+ pieceID + "'";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				if (result == 0) {
					result = rs.getInt(1);
				} else {
					return result;
				}
			}
			stmt.close();
		} catch (SQLException e) { 
			System.out.println(e.getMessage());
		}
		return result;
	}

	public void setBuilding(String idstuk, int spelerID, int x, int y) {
		Statement stmt = null;
		String query = "INSERT INTO spelerstuk(idstuk,idspeler,x_van,y_van) VALUES('" + idstuk + "', '" + spelerID
				+ "' , '" + x + "' , '" + y + "')";
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void setStreet(String idstuk, int spelerID, int x, int y, int x2, int y2) {
		Statement stmt = null;
		String query = "INSERT INTO spelerstuk VALUES('" + idstuk + "', '" + spelerID + "' , '" + x + "' , '" + y
				+ "' , '" + x2 + "' , '" + y2 + "')";
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int countBuildings(int playerid) {
		String cardid = "";
		Statement stmt = null;
		String query = "SELECT COUNT(idstuk) FROM spelerstuk WHERE idspeler = " + playerid + "";

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			cardid = rs.getString(1);
			stmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		int returnInt = Integer.parseInt(cardid);
		return returnInt;
	}
	
	public String getPlayerId(int gameid) {
		String playerid = "";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT idspeler FROM speler " + "WHERE (idspel = " + gameid
					+ ")");
			while (rs.next()) {
				if(playerid.equals("")) {
				playerid = rs.getString(1);
				}else {
					playerid = playerid + "," + rs.getString(1);
				}
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return playerid;
	}

	public ArrayList<Integer> getIds(int gameID2) {
		ArrayList<Integer> ids = new ArrayList<Integer>();
		Statement stmt = null;
		String query = "SELECT idspeler FROM speler WHERE idspel = "+gameID2;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				ids.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return ids;
	}
	
	
	public int countPlayerPiece(int playerid) {
		int piececount = 0;

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(idstuk) FROM spelerstuk WHERE idspeler = '" + playerid +"';");
			while (rs.next()) {

				piececount = rs.getInt(1);

			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return piececount;
	}
	
	public String getPlayerPiece(int playerid,int resultnumber) {
		String piececount = "";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT idstuk FROM spelerstuk WHERE idspeler = '" + playerid +"';");
			while (rs.next()) {

				piececount = rs.getString(resultnumber);

			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return piececount;
	}

	public String hasVillage(int playerID, int x, int y) {
		String result = "";
		Statement stmt = null;
		String query = "SELECT idstuk FROM spelerstuk WHERE idspeler =" + playerID + " AND x_van = '"
				+ x + "' AND y_van = '" + y + "'";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
			result = rs.getString(1);
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
		
	}

	public boolean getRound(int gameID) {
		String i = null;
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT eersteronde FROM spel WHERE idspel = "+ gameID + "";
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			i = rs.getString(1);
		} catch (SQLException e) {
		
		}
		if(i.equals("1")) {
			return false;
		}
		else {
		return true;
		}
	}

}