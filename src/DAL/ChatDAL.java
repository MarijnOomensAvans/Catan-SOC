package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;



public class ChatDAL  {
	
	Connection conn;
	private int counter = 0;
	private int difference;
	private boolean firstMessage = false;
	
	public ChatDAL() {
		conn = MainDAL.getConnection();
	}
	
	public void SendMessage(int playerid, String message) { ///sends the message to the database
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now(); 
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
		if(firstMessage == false) {
			firstMessage = true;
		}
	}

	public ArrayList<String> GetMessage(int gameid) {
		ArrayList<String> results = new ArrayList<>();
		String result = "";
		Statement stmt = null;
		int size = 0;
		String sizequery = "SELECT COUNT(*) FROM CHATREGEL as c "
				+ "LEFT JOIN speler AS s ON s.idspeler = c.idspeler "
				+ "WHERE s.idspel ="+ gameid;
		try
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sizequery);
			rs.next();
			size = rs.getInt(1);
			
			if( size > counter) 
			{
				difference = size - counter;
				
				String query = "SELECT * FROM "
						+ "(SELECT c.tijdstip, s.username, c.bericht FROM chatregel AS c "
						+ "LEFT JOIN speler AS s ON s.idspeler = c.idspeler "
						+ "WHERE s.idspel ="+gameid+" "
						+ "ORDER BY tijdstip "
						+ "DESC LIMIT " +difference+ ") sub "
						+ "ORDER BY tijdstip ASC"; 

				rs = stmt.executeQuery(query);
				while(rs.next())
				{
					result = rs.getString(1);
					result = result.substring(11, result.length()-2);			//remove the date
					result += " " + rs.getString(2) + rs.getString(3);
					results.add(result);
				}
				stmt.close();
				
				counter = size;
				return results;
			}
			
			else
			{
				return null;
			}
					
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
//	
		return null;
		
	}
}
	


