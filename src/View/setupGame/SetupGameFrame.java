package View.setupGame;

import javax.swing.JButton;
import javax.swing.JFrame;

import Controller.BoardController;
import Controller.LobbyController;

@SuppressWarnings("serial")
public class SetupGameFrame extends JFrame {

	private SetupGamePane setupPane;
	private InvitePanel invitePane;

	public SetupGameFrame(LobbyController lc, BoardController bc, JButton inviteButton) {

		// Initialize the panels
		setupPane = new SetupGamePane(lc, bc, lc.getGameID(), inviteButton);
		invitePane = new InvitePanel(lc, this);
		this.setContentPane(setupPane);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	// Set the content pane to show invite panel
	public void openInvitePanel() {
		this.setContentPane(invitePane);
		updateFrame();
	}

	// Repaint and validate the frame
	public void updateFrame() {
		this.repaint();
		this.validate();
	}
	
	public DrawingPanel getInGameBoard() {
		return setupPane.getHexagonPanel();
	}
	

}
