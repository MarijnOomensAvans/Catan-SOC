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
	private int size;
	private int difference;
	private boolean firstMessage = false;
	private boolean checkFirstTime =false;
	
	public ChatDAL() {
		conn = MainDAL.getConnection();
	}
	
	public void SendMessage(int playerid, String message) {
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
			checkFirstTime = true;
		}
	}

	public ArrayList<String> GetMessage() {
			ArrayList<String> results = new ArrayList<>();
			
			String result = "";
			Statement stmt = null;
			int counter =0;
			String sizequery = "SELECT COUNT(*) FROM CHATREGEL";

			try
			{
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sizequery);
				rs.next();
				counter = rs.getInt(1);
				//stmt.close();
				//stmt = conn.createStatement();
				
				if(checkFirstTime == false)
				{
					size = counter;
					checkFirstTime = true;
					return null;
				}
				
				if( counter > size) 
				{
					difference = counter - size;
					
					String query = "SELECT * FROM "
							+ "(SELECT c.tijdstip, s.username, c.bericht FROM chatregel AS c "
							+ "LEFT JOIN speler AS s ON s.idspeler = c.idspeler "
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
					
					size = counter;
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
//			if(firstMessage == false) 
//			{

//				if(counter > size)
//				{
//					size = counter;
//					firstMessage = true;
//					return result;
//				} return null;
				
//			}
			return null;
		
			
		}
		
	}

	

