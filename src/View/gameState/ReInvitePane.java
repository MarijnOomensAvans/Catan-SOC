package View.gameState;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.LobbyController;
import Model.lobby.LobbyGameState;

@SuppressWarnings("serial")
public class ReInvitePane extends JPanel {
	
	private JFrame frame;

	private ArrayList<JComboBox<?>> inviteBoxes;
	private ArrayList<Integer> inviteVolgnr;

	private LobbyController lc;
	private int gameid;

	public ReInvitePane(LobbyController lc, int gameid, LobbyGameState game, JFrame frame) {

		this.frame = frame;
		this.lc = lc;
		this.gameid = gameid;
		inviteBoxes = new ArrayList<JComboBox<?>>();
		inviteVolgnr = new ArrayList<Integer>();

		
		for (int j = 0; j < game.getPlayers().size(); j++) {
			if (game.getStatusForPlayerIndex(j).equals("geweigerd")) {
				inviteBoxes.add(new JComboBox<>(lc.getUsernames().toArray()));
				inviteVolgnr.add(j + 1);
			}
		}
		drawInviteBoxes();
		add(createInviteButton());
	}
	
	public void drawInviteBoxes() {
		for(JComboBox<?> box : inviteBoxes) {
			add(box);
		}
	}

	// Add a dropbdown box for each declined invite
	public JButton createInviteButton() {
		JButton reInviteButton = new JButton();
		reInviteButton = new JButton("Invite");
		reInviteButton.setEnabled(true);
		reInviteButton.setBackground(Color.orange);
		reInviteButton.addActionListener(e -> {
			sendInvitationUpdates();
			frame.dispose();
		});
		return reInviteButton;
	}
	
	private void sendInvitationUpdates() {
		for(int i = 0; i < inviteBoxes.size(); i++) {
			String username = (String) inviteBoxes.get(i).getSelectedItem();
			int volgnr = inviteVolgnr.get(i);
			lc.updateInvitation(username, gameid, volgnr);
		}
	}

}
