package DAL;

import DAL.MainDAL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DieDAL 
{
	private int gameID;
	private Connection conn;
	
	public DieDAL(int gameID)
	{
		this.gameID = gameID;
		conn = null;
	}

	public void SetDieValue(int id, int value)
	{
		try {
			conn = MainDAL.getConnection();
			Statement stmt = conn.createStatement();
			
			if(id == 1)
			{	//store die 1
				stmt.executeUpdate("UPDATE spel SET laatste_worp_steen1 = " + value +  " where idspel = " + gameID);
			}
			else if(id == 2)
			{	//store die 2
				stmt.executeUpdate("UPDATE spel SET laatste_worp_steen2 = " + value +  " where idspel = " + gameID);
				setRolled(true);	//tell database both dice rolled
			}
			stmt.close();
			} catch(SQLException e) {
			System.out.println(e.getMessage());
			}
	}
	
	public void setRolled(boolean value)
	{
		try {
			conn = MainDAL.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE spel SET gedobbeld =  " + value + " where idspel = " + gameID);
			stmt.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
	}
	
	public int getDie(int id)
	{
		int value = 0;
		try {
			conn = MainDAL.getConnection();
			Statement stmt = conn.createStatement();
			
			if(id == 1)
			{	//get die 1
				ResultSet rs = stmt.executeQuery("SELECT laatste_worp_steen1 FROM spel WHERE idspel = " + gameID);
				rs.next();
				value = rs.getInt(1);
			}		
			else if(id == 2)
			{	//get die 2
				ResultSet rs = stmt.executeQuery("SELECT laatste_worp_steen2 FROM spel WHERE idspel = " + gameID);
				rs.next();
				value = rs.getInt(1);
			}
			stmt.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		return value;
	}
	
	
}
