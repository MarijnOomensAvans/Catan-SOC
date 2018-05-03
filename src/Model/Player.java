package Model;


import DAL.MainDAL;
import DAL.PersonDal;

public class Player {
	
	private int player_id;
	private int game_id;
	private String username;
	private String color;
	private int order_number;
	
	public Player(int id) {
		player_id = id;
		setName();
		setGame_id();
		setColor();
		setOrder_number();
	}
	
	public void setName() {
	PersonDal pd = new PersonDal();
	MainDAL db = new MainDAL();{ 
	if ((db.loadDataBaseDriver("com.mysql.jdbc.Driver"))
			&& (db.makeConnection()))
	{
		username = pd.getName(player_id);
	}
}
}
	
	public void setColor() {
		PersonDal pd = new PersonDal();
		MainDAL db = new MainDAL();{ 
		if ((db.loadDataBaseDriver("com.mysql.jdbc.Driver"))
				&& (db.makeConnection()))
		{
			color = pd.getColor(player_id);
		}
	}
	}
	public void setGame_id() {
		PersonDal pd = new PersonDal();
		MainDAL db = new MainDAL();{ 
		if ((db.loadDataBaseDriver("com.mysql.jdbc.Driver"))
				&& (db.makeConnection()))
		{
			game_id = pd.getgame_id(player_id);
		}
	}
	}

	public void setOrder_number() {
		PersonDal pd = new PersonDal();
		MainDAL db = new MainDAL();{ 
		if ((db.loadDataBaseDriver("com.mysql.jdbc.Driver"))
				&& (db.makeConnection()))
		{
			order_number = pd.getorder_number(player_id);
		}
	}
	}
	

	public void getGame_id() {
		System.out.println(game_id);
	}

	public void getColor() {
		System.out.println(color);
	}

	public void getUsername() {
		System.out.println(username);
	}
	
	public void getOrder_number() {
		System.out.println(order_number);
	}
}
