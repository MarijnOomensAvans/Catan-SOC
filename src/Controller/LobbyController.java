package Controller;

import java.util.ArrayList;

import DAL.LobbyDAL;
import Model.LobbyModel;
import View.LobbyFrame;

public class LobbyController {
	
	private LobbyModel lobbyModel;
	private LobbyDAL lobbyDAL;

	public LobbyController() {
		new LobbyFrame(this);
		lobbyDAL = new LobbyDAL();
		lobbyModel = new LobbyModel(lobbyDAL);
		
	}
	
	public ArrayList<String> getUsernames(){
		return lobbyModel.getUsername();
	}
	
}
