package View.gameState;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controller.LobbyController;
import Model.lobby.LobbyGameState;

@SuppressWarnings("serial")
public class ReInvitePane extends JPanel {

	private JFrame frame;

	private ArrayList<JComboBox<?>> inviteBoxes;
	private ArrayList<Integer> inviteVolgnr;
	private JLabel warningLabel = new JLabel("");
	private JPanel warningPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JPanel boxPanel = new JPanel();
	private LobbyGameState game;
	private LobbyController lc;
	private int gameid;

	public ReInvitePane(LobbyController lc, int gameid, LobbyGameState game, JFrame frame) {
		this.game = game;
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
		
		buttonPanel.setPreferredSize(new Dimension(0, 50));
		drawInviteBoxes();
		warningLabel.setHorizontalAlignment(SwingConstants.CENTER);
		warningLabel.setForeground(Color.red);
		warningPanel.add(warningLabel);
		buttonPanel.add(createInviteButton());
		setLayout(new BorderLayout());
		add(boxPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER );
		add(warningLabel, BorderLayout.SOUTH);
		
	}

	public void drawInviteBoxes() {
		for (JComboBox<?> box : inviteBoxes) {
			boxPanel.add(box);
		}
	}

	// Add a dropbdown box for each declined invite
	public JButton createInviteButton() {
		JButton reInviteButton = new JButton();
		reInviteButton = new JButton("Invite");
		reInviteButton.setEnabled(true);
		reInviteButton.setBackground(Color.orange);
		reInviteButton.addActionListener(e -> {
			
			if(checkNames()) {
				sendInvitationUpdates();
				frame.dispose();
			}else {
				warningLabel.setText("Dubbele namen");
			}
			
		});
		return reInviteButton;
	}

	private void sendInvitationUpdates() {
		for (int i = 0; i < inviteBoxes.size(); i++) {
			String username = (String) inviteBoxes.get(i).getSelectedItem();
			int volgnr = inviteVolgnr.get(i);
			lc.updateInvitation(username, gameid, volgnr);
		}
	}

	public ArrayList<String> getUsedNames() {
		ArrayList<String> names = new ArrayList<>();
		ArrayList<String> usedNames = new ArrayList<>();
		names = game.getPlayers();

		usedNames.add(names.get(0).toString());

		for (int i = 0; i < names.size(); i++) {
			if (game.getStatusForPlayerIndex(i).toString().equals("uitgedaagde")
					|| game.getStatusForPlayerIndex(i).toString().equals("geweigerd")) {
				usedNames.add(names.get(i).toString());
			}
		}
		for (int i = 0; i < usedNames.size(); i++) {
		}
		return usedNames;

	}

	public boolean checkNames() {
		ArrayList<String> usedNames = getUsedNames();

		boolean allowed = true;

		for (int i = 0; i < inviteBoxes.size(); i++) {
			for (int j = 0; j < usedNames.size(); j++) {
				if (inviteBoxes.get(i).getSelectedItem().toString().equals(usedNames.get(j).toString())) {
					allowed = false;
				}
			}
		}
		return allowed;
	}

}
