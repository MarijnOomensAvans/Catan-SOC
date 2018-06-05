package Controller;

import java.util.ArrayList;

import javax.swing.JButton;

import DAL.LobbyDAL;
import DAL.SpelDAL;
import Model.ingame.PlayerStats;
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
	private LobbyDAL lobbyDAL;
	private GameStateController gsc;
	private IngameController inGameController;

	public LobbyController() {
		lobbyDAL = new LobbyDAL();
		inGameController = new IngameController();
		lobbyModel = new LobbyModel(lobbyDAL);
		cc = new ChatController(getGameID(), 0);
		bc = new BoardController();
		frame = new LobbyFrame(this,bc,cc,cog,1);
		LobbyUpdateController updateController = new LobbyUpdateController();
		updateController.addObserver(frame.getPanel());
		
		/*TEST VERWIJDER DIT!!*/
		
		SpelDAL sd = new SpelDAL();
		ArrayList<PlayerStats> stats = sd.getPlayerStats(855);
		for(int i = 0; i < stats.size(); i++) {
			System.out.println(stats.get(i).getUsername());
		}
	}

	public ArrayList<String> getUsernames() {
		return lobbyModel.getUsernames();
	}
	
	public void openGameStateController() {
		gsc = new GameStateController(this);
		
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
		bc.generateBoard();
		DrawingPanel dp = new DrawingPanel(bc, gameID);
		int playerID = Integer.parseInt(lobbyDAL.getPlayerID(gameID));
		gameFrame = new InGameFrame(bc, gameID, dp, playerID, inGameController);
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
		
		inviteButton.addActionListener(e -> {
			setupFrame.openInvitePanel();
		});
	}

}
