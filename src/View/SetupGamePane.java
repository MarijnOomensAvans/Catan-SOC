package View;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.BoardController;

public class SetupGamePane extends JPanel {

	private final int WIDTH = 1400;
	private final int HEIGHT = 900;
	
	private DrawingPanel hexagonPanel;
	private SetupChangePanel changePanel;

	public SetupGamePane(BoardController bc, int idspel, JButton inviteButton) {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		changePanel = new SetupChangePanel(inviteButton);
		hexagonPanel = new DrawingPanel(bc, idspel);


		hexagonPanel.setBounds(0, 0, 500, 500);
		
		add(changePanel);
		add(hexagonPanel);
		
		
	}
}
