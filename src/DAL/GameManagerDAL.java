package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GameManagerDAL {
	Connection conn = MainDAL.getConnection();

	public boolean getFirstTurn(int gameid) {
		String s = "eersteronde";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt
						.executeQuery("SELECT eersteronde FROM spel WHERE idspel = '" + gameid + "'");

				if (rs.next()) {
					if(rs.getInt(s) == 1) {
						return true;
					}
					else {
						return false;
					}
				} else {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}
	
	public String getPlayerFromTrackNumber(int gameid, int tracknumber) {
		String s = "username";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt
						.executeQuery("SELECT username FROM speler WHERE idspel = '" + gameid + "' && volgnr = '" + tracknumber + "'");

				if (rs.next()) {
					return rs.getString(s);
				} else {
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

	public int getPlayerIDTurn(int gameid) {
		int i= 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT beurt_idspeler FROM spel WHERE idspel = " + gameid);

			rs.next();
			i =rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return i;
	}

	public boolean getHasThrown(int gameid) {
	
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT gedobbeld FROM spel WHERE idspel = " + gameid);

			rs.next();
			return rs.getBoolean(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return false;
	}

}
