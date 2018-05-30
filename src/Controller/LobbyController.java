package Controller;

import java.util.ArrayList;

import javax.swing.JButton;

import Model.lobby.LobbyGameInfo;
import Model.lobby.LobbyGameState;
import Model.lobby.LobbyInvite;
import Model.lobby.LobbyModel;
import View.chat.Chatoutputgui;
import View.inGame.InGameFrame;
import View.lobby.LobbyFrame;
import View.setupGame.DrawingPanel;
import View.setupGame.SetupGameFrame;

public class LobbyController {

	private BoardController bc;
	private LobbyModel lobbyModel;
	private LobbyFrame frame;
	@SuppressWarnings("unused")
	private InGameFrame gameFrame;
	private SetupGameFrame setupFrame;
	private ChatController cc;
	private Chatoutputgui cog;

	private GameStateController gsc;

	private DrawingPanel inGameBoard;

	public LobbyController() {
		lobbyModel = new LobbyModel();
		cc = new ChatController(getGameID());
		bc = new BoardController();
		frame = new LobbyFrame(this,bc,cc,cog,1);
		gsc = new GameStateController(this);
	}

	public ArrayList<String> getUsernames() {
		return lobbyModel.getUsernames();
	}
	
	public ArrayList<LobbyGameState> getHostedGames(){
		return lobbyModel.getHostedGames();
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
		gameFrame = new InGameFrame(bc, gameID, inGameBoard);
	}
	
	public void createInvitation(String username, int gameid, int volgnr) {
		lobbyModel.createInvitation(username, gameid, volgnr);
	}
	
	public void updateInvitation(String username, int gameid, int volgnr) {
		lobbyModel.updateInvitation(username, gameid, volgnr);
	}
	
	public void openGameSetup() {
		JButton inviteButton = new JButton("Invite");

		makeNewGameID();
		bc.generateBoard();
		bc.setBoardType(getGameID(), 1);
		bc.finishBoard(getGameID());
		setupFrame = new SetupGameFrame(this, bc, inviteButton);
		inGameBoard = setupFrame.getInGameBoard();
		
		inviteButton.addActionListener(e -> {
			setupFrame.openInvitePanel();
		});
	}

}
