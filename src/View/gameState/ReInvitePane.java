package View.gameState;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.mysql.fabric.xmlrpc.base.Array;

import Controller.LobbyController;
import Model.lobby.LobbyGameState;

public class ReInvitePane extends JPanel {


	private int amountOfDeclines = 0;

	private ArrayList<String> states;
	private ArrayList<String> names;

	private LobbyController lc;


	public ReInvitePane(LobbyController lc, int gameId) {

		this.lc = lc;

		for (int i = 0; i < lc.getHostedGames().size(); i++) {
			LobbyGameState lobbyGameState = lc.getHostedGames().get(i);
			if (lobbyGameState.getGameid() == gameId) {
				for (int j = 0; j < lobbyGameState.getPlayers().size(); j++) {
					if (lobbyGameState.getStatusForPLayerIndex(j).equals("geweigerd")) {
						amountOfDeclines++;
					}
				}
			}
		}
		getDeclines(amountOfDeclines, gameId);
		add(createInviteButton());
	}

	public void getDeclines(int amountOfDeclines, int id) {

		JComboBox<String> box = null;
		for (int i = 0; i < amountOfDeclines; i++) {
			for (int j = 0; j < lc.getUsernames().size(); j++) {
				box = new JComboBox(lc.getUsernames().toArray());					
					
			}

		}
		add(box);
	}
	
	public JButton createInviteButton() {
		JButton reInviteButton = new JButton();
		reInviteButton = new JButton("Invite");
		reInviteButton.setEnabled(true);
		reInviteButton.setBackground(Color.orange);
		return reInviteButton;
	}

	

}
