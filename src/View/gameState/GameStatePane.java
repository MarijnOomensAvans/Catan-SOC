package View.gameState;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Controller.LobbyController;
import Model.lobby.LobbyGameState;

@SuppressWarnings("serial")
public class GameStatePane extends JPanel {

	private final int WIDTH = 500;
	private final int HEIGHT = 600;
	private final int PANELWIDTH = 480;
	private final int GAMEHEIGHT = 100;

	private JPanel games;
	private LobbyController lc;

	private ArrayList<LobbyGameState> hostedGames;

	private JScrollPane scroll;

	public GameStatePane(LobbyController lc) {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setLayout(new BorderLayout());
		this.lc = lc;
		games = new JPanel();
		games.setBackground(Color.DARK_GRAY);
		games.setLayout(new GridLayout(0, 1, 0, 10));
		scroll = new JScrollPane(games, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		getGames();
		scroll.getVerticalScrollBar().setUnitIncrement(5);
		add(scroll, BorderLayout.CENTER);
	}

	public void getGames() {
		hostedGames = lc.getHostedGames();

		for (int i = 0; i < hostedGames.size(); i++) {
			ArrayList<String> usernames;
			usernames = hostedGames.get(i).getPlayers();

			ArrayList<String> states;
			states = hostedGames.get(i).getStatus();

			JPanel game = new JPanel();
			game.setLayout(new BorderLayout());
			game.setPreferredSize(new Dimension(PANELWIDTH, GAMEHEIGHT));

			JPanel buttonPanel = new JPanel();
			buttonPanel.setPreferredSize(new Dimension(100, HEIGHT));

			JPanel names = new JPanel();
			names.setLayout(new GridLayout(2, 2));
			for (int j = 0; j < usernames.size(); j++) {

				JPanel namePanel = new JPanel();

				JLabel name = new JLabel(usernames.get(j));
				name.setHorizontalAlignment(SwingConstants.HORIZONTAL);

				JLabel state = new JLabel(states.get(j));
				state.setHorizontalAlignment(SwingConstants.HORIZONTAL);

				namePanel.setLayout(new BorderLayout());
				namePanel.add(name, BorderLayout.NORTH);
				namePanel.add(state, BorderLayout.CENTER);
				stateColour(state);
				namePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));

				names.add(namePanel);
			}

			buttonPanel.setLayout(new BorderLayout());
			buttonPanel.add(createReinviteButton(hostedGames.get(i).getGameid(), hostedGames.get(i)), BorderLayout.CENTER);

			game.add(names, BorderLayout.CENTER);
			game.add(buttonPanel, BorderLayout.LINE_END);
			game.setPreferredSize(new Dimension(WIDTH - 25, 100));

			games.add(game);
		}
	}

	public void stateColour(JLabel state) {
		if (state.getText().equals("geaccepteerd") || state.getText().equals("uitdager")) {
			state.setForeground(Color.GREEN);
		} else if (state.getText().equals("geweigerd")) {
			state.setForeground(Color.red);
		} else {
			state.setForeground(Color.LIGHT_GRAY);
		}
	}

	public JButton createReinviteButton(int id, LobbyGameState game) {
		JButton reInviteButton = new JButton("Reinvite");
		reInviteButton.setEnabled(false);
		
		//Check if a user has declined an invite
		for(int i = 0; i < game.getStatus().size(); i++) {
			if(game.getStatus().get(i).equals("geweigerd")) {
				reInviteButton.setEnabled(true);
				break;
			}
		}
		reInviteButton.setBackground(Color.orange);
		reInviteButton.addActionListener(e -> {
			new ReInviteFrame(lc, id, game);
		});
		return reInviteButton;
	}

}
