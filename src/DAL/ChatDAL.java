package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class ChatDAL  {
	
	Connection conn;
	private int size;
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

	public String GetMessage() {
			String result ="";
			Statement stmt = null;
			int counter =0;
			String sizequery = "SELECT COUNT(*) FROM CHATREGEL";
			String query = "SELECT c.tijdstip, s.username, c.bericht FROM chatregel AS c "
					+ "LEFT JOIN speler AS s ON s.idspeler = c.idspeler "
					+ "ORDER BY tijdstip DESC "
					+ "LIMIT 1";
			try
			{
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sizequery);
				rs.next();
				counter = rs.getInt(1);
				stmt.close();
				stmt = conn.createStatement();
				ResultSet re = stmt.executeQuery(query);
				re.next();
				result = re.getString(1);
				result = result.substring(11, result.length()-2);//remove the date
				result += " " + re.getString(2) + re.getString(3);
				stmt.close();
			} catch (SQLException e)
			{
				System.out.println(e.getMessage());
			}
			if(firstMessage == false) {
				if(checkFirstTime == false) {
					size = counter;
					checkFirstTime = true;
					return null;
				}
				if(counter > size) {
					size = counter;
					firstMessage = true;
					return result;
				} return null;
				
			}
			if( counter > size) {
				size = counter;
				return result;
			
			}
				return null;
			
		}
		
	}

	


