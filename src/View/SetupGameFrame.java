package View;

import javax.swing.JButton;
import javax.swing.JFrame;

import Controller.BoardController;
import Controller.LobbyController;

public class SetupGameFrame extends JFrame {
	
	private SetupGamePane setupPane;
	private InvitePanel invitePane;
	
	
	public SetupGameFrame(LobbyController lc, BoardController bc, JButton inviteButton) {

		setupPane = new SetupGamePane(lc, bc, lc.getGameID(), inviteButton);
		invitePane = new InvitePanel(lc);
		this.setContentPane(setupPane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}


	public void openInvitePanel() {
		this.setContentPane(invitePane);
		updateFrame();
	}
	
	public void updateFrame() {
		this.repaint();
		this.validate();
	}

}
