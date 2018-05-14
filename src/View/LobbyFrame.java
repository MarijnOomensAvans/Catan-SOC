package View;

import java.util.ArrayList;

import javax.swing.JFrame;

import Controller.LobbyController;
import DAL.LobbyDAL;

public class LobbyFrame extends JFrame{
	private LobbyContentPane pane;
	private LobbyDAL lobbyDAL;
	private LobbyController controller;
	
	public LobbyFrame(LobbyController controller) {
		this.controller = controller;
		pane = new LobbyContentPane(this);
		lobbyDAL = new LobbyDAL();
		setTitle("Lobby");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setContentPane(pane);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public ArrayList<String> getUsernames(){
		return controller.getUsernames();
	}
}
