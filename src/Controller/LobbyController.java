package Controller;

import java.util.ArrayList;

import Model.LobbyGameInfo;
import Model.LobbyInvite;
import Model.LobbyModel;
import View.Chatoutputgui;
import View.InGameFrame;
import View.LobbyFrame;

public class LobbyController {

	private BoardController bc;
	private LobbyModel lobbyModel;
	private LobbyFrame frame;
	private InGameFrame gameFrame;
	private ChatController cc;
	private Chatoutputgui cog;

	public LobbyController() {
		cog = new Chatoutputgui(cc, 1);
		cc = new ChatController(cog);
		bc = new BoardController();
		lobbyModel = new LobbyModel();
		frame = new LobbyFrame(this,bc,cc,cog,1);
	}

	public ArrayList<String> getUsernames() {
		return lobbyModel.getUsernames();
	}

	public ArrayList<LobbyInvite> getInvites() {
		return lobbyModel.getInvites();
	}
	
	public ArrayList<String> getPlayers(int gameID) {
		return lobbyModel.getPlayers(gameID);
	}
	
	public ArrayList<LobbyGameInfo> getGames() {
		return lobbyModel.getGames();
	}

	public void startLogin() {
		new LoginController();
	}

	public void closeLobbyScreen() {
		frame.dispose();
	}
	
	public void makeNewGameID() {
		lobbyModel.makeNewGameID();
	}
	
	public int getGameID() {
		return lobbyModel.getGameid();
	}

	public boolean isRandomBoard(int gameID) {
		return lobbyModel.isRandomBoard(gameID);
	}

	public ArrayList<String> getUsersInGame(int gameID) {
		return lobbyModel.getUsersInGame(gameID);
	}
	
	public void inviteResponse(boolean response, int gameID) {
		lobbyModel.inviteResponse(response, gameID);
	}
	
	public void openGame(int gameID) {
		frame.dispose();
		gameFrame = new InGameFrame(bc, gameID);
	}

}
