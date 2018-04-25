package Model;

import java.awt.Color;

import DAL.MainDAL;

public class Player {
	
	private int player_id;
	private int game_id;
	private String username;
	private String password;
	private String color;
	private int order_number;
	
	public Player(int id) {
		player_id = id;
		setName();
		setColor();
	}
	
	public void setName() {
	MainDAL db = new MainDAL();{ 
	if ((db.loadDataBaseDriver("com.mysql.jdbc.Driver"))
			&& (db.makeConnection()))
	{
		username = db.getName(player_id);
	}
}
}
	
	public void setColor() {
		MainDAL db = new MainDAL();{ 
		if ((db.loadDataBaseDriver("com.mysql.jdbc.Driver"))
				&& (db.makeConnection()))
		{
			color = db.getColor(player_id);
		}
	}
	}

	public void getColor() {
		System.out.println(color);
	}

	public void getUsername() {
		System.out.println(username);
	}
}
