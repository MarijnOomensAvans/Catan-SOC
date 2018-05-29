package View.setupGame;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.BoardController;
import Controller.LobbyController;

@SuppressWarnings("serial")
public class SetupGamePane extends JPanel {

	private DrawingPanel hexagonPanel;
	private SetupChangePanel changePanel;

	public SetupGamePane(LobbyController lc, BoardController bc, int idspel, JButton inviteButton) {

		changePanel = new SetupChangePanel(lc, bc, inviteButton, idspel, this);
		hexagonPanel = new DrawingPanel(bc, idspel);

		hexagonPanel.setBounds(0, 0, 500, 500);

		add(changePanel);
		add(hexagonPanel);

	}

	// Repaint the panel after a change
	public void remake() {
		repaint();
	}
}
