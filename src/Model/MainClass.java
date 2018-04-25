package Model;

import DAL.MainDAL;

public class MainClass {

	public static void main(String[] args) {
		MainDAL db = new MainDAL();
		if ((db.loadDataBaseDriver("com.mysql.jdbc.Driver"))
				&& (db.makeConnection()))
		{
			db.getName(1);
		}
	}
	}


