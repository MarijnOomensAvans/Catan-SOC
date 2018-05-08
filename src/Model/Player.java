package Model;


import java.util.ArrayList;


import DAL.MainDAL;
import DAL.PersonDal;

public class Player {
	
	private int player_id;
	private int game_id;
	private String username;
	private String color;
	private int order_number;
	private int points = 0; 
	private ArrayList<Card> hand = new ArrayList<Card>();
	

	public Player(int id) {
		player_id = id;
		setName();
		setGame_id();
		setColor();
		setOrder_number();
	}
	
	public void setName() {
	MainDAL db = new MainDAL();
	{ 
	if ((db.loadDataBaseDriver("com.mysql.jdbc.Driver"))
			&& (db.makeConnection()))
	{
		PersonDal pd = new PersonDal();
		username = pd.getName(player_id);
	}
}
}
	
	public void setColor() {
		MainDAL db = new MainDAL();
		{ 
		if ((db.loadDataBaseDriver("com.mysql.jdbc.Driver"))
				&& (db.makeConnection()))
		{
			PersonDal pd = new PersonDal();
			color = pd.getColor(player_id);
		}
	}
	}
	public void setGame_id() {
		MainDAL db = new MainDAL();
		{ 
		if ((db.loadDataBaseDriver("com.mysql.jdbc.Driver"))
				&& (db.makeConnection()))
		{
			PersonDal pd = new PersonDal();
			game_id = pd.getgame_id(player_id);
		}
	}
	}

	public void setOrder_number() {
		MainDAL db = new MainDAL();{ 
		if ((db.loadDataBaseDriver("com.mysql.jdbc.Driver"))
				&& (db.makeConnection()))
		{
			PersonDal pd = new PersonDal();
			order_number = pd.getorder_number(player_id);
		}
	}
	}

	public void addCard(int kind) {
		Card card = new Card(kind);
		hand.add(card);
	}
	
	public void removeCard(int kind) {
		for(int i=0; i< hand.size(); i++) {
			if(hand.get(i).getKindOfMaterial() == kind) {
				hand.remove(hand.get(i));
				break;
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
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public void printCards() {
		for(int i=0; i< hand.size(); i++) {
			System.out.println("Kaart "+i +" "+ hand.get(i).getMaterial());
		}
	}
	
}
