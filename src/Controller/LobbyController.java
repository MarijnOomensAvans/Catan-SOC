package Controller;

import java.util.ArrayList;

import DAL.LobbyDAL;
import Model.LobbyModel;
import View.LobbyFrame;

public class LobbyController {
	
	private LobbyModel lobbyModel;
	private LobbyDAL lobbyDAL;

	public LobbyController() {
		lobbyDAL = new LobbyDAL();
		lobbyModel = new LobbyModel(lobbyDAL);
		new LobbyFrame(this);
	}
	
	public ArrayList<String> getUsernames() {
		return lobbyModel.getUsername();
	}

}
