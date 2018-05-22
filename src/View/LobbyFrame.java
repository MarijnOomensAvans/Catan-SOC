package View;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controller.LobbyController;
import Model.LobbyInvite;

@SuppressWarnings("serial")
public class LobbyFrame extends JFrame{
	private LobbyContentPane pane;
	private LobbyController controller;
	
	private JMenuBar lobbyMenuBar;
	private JMenu lobbyMenu;
	private JMenuItem logOut;
	
	public LobbyFrame(LobbyController controller) {
		this.controller = controller;
		pane = new LobbyContentPane(this);
		setTitle("Lobby");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		makeMenuBar();
		setContentPane(pane);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public ArrayList<String> getUsernames(){
		return controller.getUsernames();
	}

	
	public ArrayList<LobbyInvite> getInvites() {
		return controller.getInvites();
	}
	
	public void makeMenuBar() {

		lobbyMenuBar = new JMenuBar();
		lobbyMenu = new JMenu("Account");
		logOut = new JMenuItem("Uitloggen");
		
		lobbyMenuBar.add(lobbyMenu);
		lobbyMenu.add(logOut);
		
		logOut.addActionListener(e -> {
			dispose();
			controller.startLogin();
		});
		
		setJMenuBar(lobbyMenuBar);
		
		
	}
	
	public void inviteResponse(int gameID, boolean response) {
		controller.inviteRespone(gameID, response);
	}
	
	public void closeLobby() {
		controller.closeLobbyScreen();
	}
	
	public void switchScreen() {
		pane.switchLobbyScreen();
		pack();
	}
}
