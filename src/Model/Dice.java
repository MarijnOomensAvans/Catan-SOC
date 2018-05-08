package Model;
import java.util.Random;
import DAL.MainDAL;

public class Dice {
	private int dice = 1;
	private Random rand = new Random();
	private MainDAL dbConn = new MainDAL();
	
	public Dice() {
		try {
			//driver name to be added, currently unknown
			//dbConn.loadDataBaseDriver(driverName);
			
			//No connection without driver, to be added
			//dbConn.makeConnection();
			
			System.out.println("Database driver connection skipped, name unknown.");
			System.out.println("No database connection possible, no driver");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public int getDice() {
		return dice;
	}
	
	public int getStoredDice() {
		int storedDice = 1;
		
		//TO DO: some db connectivity here
		
		return storedDice;
	}
	
	public void storeDice() {
		//TO DO: some db connectivity here
	}
	
	public void rollDice() {
		dice = rand.nextInt(6)+1;
	}
}
