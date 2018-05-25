package View;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.BoardController;
import Controller.LobbyController;
import Model.LobbyGameInfo;
import Model.LobbyInvite;

@SuppressWarnings("serial")
public class LobbyContentPane extends JPanel {

	private BoardController bc;
	private LobbyPanel lobby;
	private SetupGamePane setupGame;
	private LobbyController lc;
	private InvitePanel invitePanel;
	private JButton playButton;
	private JButton inviteButton;

	public LobbyContentPane(LobbyController controller, BoardController bc) {
		this.bc = bc;
		inviteButton = new JButton("Invite");
		playButton = new JButton("Start");
		this.lc = controller;
		this.invitePanel = new InvitePanel(this);
		this.lobby = new LobbyPanel(this, playButton);


		playButton.addActionListener(e -> {
		switchLobbyScreen();
		});
		inviteButton.addActionListener(e -> {
		switchInviteScreen();
		});
		add(lobby);
	}
		

	public ArrayList<String> getUsernames() {
		return lc.getUsernames();
	}

	public void switchLobbyScreen() {
		lc.makeNewGameID();
		this.setupGame = new SetupGamePane(bc, lc.getGameID(), inviteButton);
		bc.generateBoard();
		bc.setBoardType(lc.getGameID(), 1);
		bc.finishBoard(lc.getGameID());
		removeAll();
		add(setupGame);
		revalidate();
		repaint();
		
	}
	
	public void switchInviteScreen() {
		removeAll();
		add(invitePanel);
		revalidate();
		repaint();
	}
	
	public int getGameID() {
		return lc.getGameID();
	}
	

	public ArrayList<String> getPlayers(int gameID){
		return lc.getPlayers(gameID);
	}
	
	public ArrayList<LobbyInvite> getInvites(){
		return lc.getInvites();
	}
	
	public void closeLobbyScreen() {
		playButton.addActionListener(e -> {
			lc.closeLobbyScreen();
		});
	}

	public boolean isRandomBoard(int gameID) {
		return lc.isRandomBoard(gameID);
	}

	public ArrayList<String> getUsersInGame(int gameID) {
		return lc.getUsersInGame(gameID);
	}
	
	public void inviteResponse(boolean response, int gameID) {
		lc.inviteResponse(response, gameID);
	}
	
	public ArrayList<LobbyGameInfo> getGames() {
		return lc.getGames();
	}

}
