package View.gameState;

import javax.swing.JFrame;

import Controller.LobbyController;
import Model.lobby.LobbyGameState;

@SuppressWarnings("serial")
public class ReInviteFrame extends JFrame{

	private ReInvitePane pane;
	
	public ReInviteFrame(LobbyController lc, int id, LobbyGameState game) {
		
		pane = new ReInvitePane(lc, id, game, this);	
		setTitle("Reinvite");
		setContentPane(pane);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
