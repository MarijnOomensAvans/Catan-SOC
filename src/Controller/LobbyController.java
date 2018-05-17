package Controller;

import java.util.ArrayList;

import DAL.LobbyDAL;
import Model.LobbyGameInfo;
import Model.LobbyModel;
import View.LobbyFrame;

public class LobbyController {
	
	private LobbyModel lobbyModel;
	private LobbyDAL lobbyDAL;
	private LobbyFrame frame;

	public LobbyController() {
		lobbyDAL = new LobbyDAL();
		lobbyModel = new LobbyModel(lobbyDAL);
		frame = new LobbyFrame(this);
		testDAL();
	}
	
	public ArrayList<String> getUsernames() {
		return lobbyModel.getUsernames();
	}
	
	public void startLogin() {
		new LoginController();
	}
	
	public void closeLobbyScreen() {
		frame.dispose();
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
