package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatDal {
	
	Connection conn;
	
	public ChatDal() {
		conn = MainDAL.getConnection();
	}
	
	public void SendMessage(int playerid, String message) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now(); 
		System.out.println(dtf.format(now));
		
		String idstring = Integer.toString(playerid);
		Statement stmt = null;
		String query = "INSERT INTO chatregel(tijdstip,idspeler,bericht) VALUES('" + dtf.format(now)+"', '"+idstring+"', '"+ message+"')";
		try
		{
			stmt = conn.createStatement();
			int i = stmt.executeUpdate(query);
			
			stmt.close();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	}


