package DAL;

import java.sql.Connection;

public class ChatDal {
	
	Connection conn;
	
	public ChatDal() {
		conn = MainDAL.getConnection();
	}

}
