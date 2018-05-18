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
	
	//Response to invite, true = accept, false = refuse
	public void inviteRespone(int gameID, boolean response) {
		System.out.println(response);
	}
	
}
