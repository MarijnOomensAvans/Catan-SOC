package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BoardDal {
	MainDAL mdal = new MainDAL();
	Connection conn;

	public BoardDal() {
		conn = MainDAL.getConnection();
		if()
	}

	public void setTile(int idspel, int idtegel, int x, int y, char idgrondstofsoort, int idgetalfiche) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO tegel(idspel,idtegel,x,y,idgrondstofsoort,idgetalfiche) VALUES('" + idspel
				+ "', '" + idtegel + "', '" + x + "' '" + y + "', '" + idgrondstofsoort + "', '" + idgetalfiche + "',)");
			rs.next();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}