package Controller;

import java.util.ArrayList;

import DAL.LobbyDAL;
import Model.LobbyGameInfo;
import Model.LobbyInvite;
import Model.LobbyModel;
import View.LobbyFrame;

public class LobbyController {
	
	private LobbyModel lobbyModel;
	private LobbyFrame frame;

	public LobbyController() {
		lobbyModel = new LobbyModel();
		frame = new LobbyFrame(this);
	}
	
	public ArrayList<String> getUsernames() {
		return lobbyModel.getUsernames();
	}
	
	public ArrayList<LobbyInvite> getInvites(){
		return lobbyModel.getInvites();
	}
	
	public void startLogin() {
		new LoginController();
	}
	
	public void closeLobbyScreen() {
		frame.dispose();
	}
<<<<<<< HEAD

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
//		ArrayList<LobbyInvite> invites = lobbyDAL.getAllInvites();
//		for(int i = 0; i < invites.size(); i++) {
//			System.out.println(invites.get(i).getGameID());
//			System.out.println(invites.get(i).getHost());
//		}
=======
	
	//Response to invite, true = accept, false = refuse
	public void inviteRespone(int gameID, boolean response) {
		System.out.println(response);
>>>>>>> 10dff355637d3d29ba57506960047f8114ce7edc
	}
	
}
