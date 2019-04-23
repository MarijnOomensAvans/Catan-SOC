package Model;

import java.util.Random;
import DAL.DieDAL;

public class Die 
{
	private int id;
	private Random rand;
	private DieDAL dieDAL;
	
	public Die(int dieID, int gameID) 
	{
		this.id = dieID;
		rand = new Random();
		dieDAL = new DieDAL(gameID);
	}
	
	public void rollDie() 
	{
		int value = rand.nextInt(6)+1;	//random value of 1-6
		storeDie(value);
	}
	
	public void storeDie(int value) 
	{	//store rolled value in database
		dieDAL.SetDieValue(this.id, value);
	}
	
	public int getStoredDie() 
	{	//return last rolled value
		int storedDie;
		storedDie = dieDAL.getDie(this.id);
		return storedDie;
	}
}
