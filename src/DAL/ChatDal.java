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
			String query = "SELECT tijdstip,bericht FROM chatregel";
			try
			{
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				int counter =1;
				while (rs.next())
				{
					result = rs.getString(counter);
					counter++;
				}
				stmt.close();
			} catch (SQLException e)
			{
				System.out.println(e.getMessage());
			}
			return result;
			
		}
		
	}

	


