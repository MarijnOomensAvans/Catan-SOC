package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatDAL {
	
	Connection conn;
	
	public ChatDAL() {
		conn = MainDAL.getConnection();
	}
	
	public void SendMessage(int playerid, String message) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now(); 
		System.out.println(dtf.format(now));
		Statement stmt = null;
		String query = "INSERT INTO chatregel(tijdstip,idspeler,bericht) VALUES('" + dtf.format(now)+"', "+playerid+", '"+ message+"')";
		try
		{
			stmt = conn.createStatement();
			@SuppressWarnings("unused")
			int i = stmt.executeUpdate(query);
			
			stmt.close();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	public String GetMessage() {
			String result ="";
			Statement stmt = null;
			
			String query = "SELECT c.tijdstip, s.username, c.bericht FROM chatregel AS c "
					+ "LEFT JOIN speler AS s ON s.idspeler = c.idspeler "
					+ "ORDER BY tijdstip DESC "
					+ "LIMIT 1";
			try
			{
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				rs.next();
				//{
					result = rs.getString(1);
					result = result.substring(11, result.length()-2);			//remove the date
					result += " " + rs.getString(2) + rs.getString(3);
				//}
				stmt.close();
			} catch (SQLException e)
			{
				System.out.println(e.getMessage());
			}
			return result;
		}
		
	}

	


