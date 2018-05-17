package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BoardDal {

	Connection conn;

	public BoardDal() {
		conn = MainDAL.getConnection();
	}

	public void setTile(int idspel, int idtegel, int x, int y, char idgrondstofsoort, int idgetalfiche) {
	//	String idstring = Integer.toString(playerid);
		Statement stmt = null;
		String query = "INSERT INTO chatregel(idspel,idtegel,x,y,idgrondstofsoort,idgetalfiche) VALUES('" + idspel + "', '" + idtegel
				+ "', '" + x + "' '" + y + "', '" + idgrondstofsoort + "', '" + idgetalfiche + "',)";
		try {
			stmt = conn.createStatement();
			int i = stmt.executeUpdate(query);

			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}