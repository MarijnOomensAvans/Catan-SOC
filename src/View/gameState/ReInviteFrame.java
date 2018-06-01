package View.gameState;

import javax.swing.JFrame;

import Controller.LobbyController;

public class ReInviteFrame extends JFrame{

	private ReInvitePane pane;
	
	public ReInviteFrame(LobbyController lc, int id) {
		
		pane = new ReInvitePane(lc, id);	
		setTitle("Reinvite");
		setContentPane(pane);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
