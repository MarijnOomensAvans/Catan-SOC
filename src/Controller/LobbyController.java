package Controller;

import java.util.ArrayList;

import DAL.LobbyDAL;
import Model.LobbyGameInfo;
import Model.LobbyInvite;
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
		System.out.println("---------- GAMES -----------");
		System.out.println("");
		ArrayList<LobbyGameInfo> games = lobbyDAL.getAllActiveGames();
		for(int i = 0; i < games.size(); i++) {
			System.out.println(games.get(i).getID());
			for(int p = 0; p < games.get(i).getPlayers().size(); p++) {
				System.out.println(games.get(i).getPlayers().get(p));
			}
		}
		System.out.println("");
		System.out.println("---------- INVITES -----------");
		System.out.println("");
		ArrayList<LobbyInvite> invites = lobbyDAL.getAllInvites();
		for(int i = 0; i < invites.size(); i++) {
			System.out.println(invites.get(i).getGameID());
			System.out.println(invites.get(i).getHost());
		}
	}
	
}
