package Controller;

import java.util.ArrayList;

import DAL.LobbyDAL;
import Model.LobbyGameInfo;
import Model.LobbyModel;
import View.LobbyFrame;

public class LobbyController {
	
	private LobbyModel lobbyModel;
	private LobbyDAL lobbyDAL;

	public LobbyController() {
		lobbyDAL = new LobbyDAL();
		lobbyModel = new LobbyModel(lobbyDAL);
		new LobbyFrame(this);
		testDAL();
	}
	
	public ArrayList<String> getUsernames() {
		return lobbyModel.getUsernames();
	}
	
	public void startLogin() {
		new LoginController();
	}

	//DEBUG FUNCTION
	private void testDAL() {
		ArrayList<LobbyGameInfo> games = lobbyDAL.getAllActiveGames();
		for(int i = 0; i < games.size(); i++) {
			System.out.println(games.get(i).getID());
			for(int p = 0; p < games.get(i).getPlayers().size(); p++) {
				System.out.println(games.get(i).getPlayers().get(p));
			}
		}
	}
	
}
