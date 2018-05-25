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
	
<<<<<<< HEAD
	public SetupGamePane(BoardController bc, JButton inviteButton) {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		changePanel = new SetupChangePanel(inviteButton);
		hexagonPanel = new DrawingPanel(bc);
=======
	public SetupGamePane(BoardController bc, int idspel) {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		changePanel = new SetupChangePanel();
		hexagonPanel = new DrawingPanel(bc, idspel);
>>>>>>> 1f4b524d2ecf734b632ee98643c15faa623b0c5f

		hexagonPanel.setBounds(0, 0, 500, 500);
		
		add(changePanel);
		add(hexagonPanel);
		
		
	}
}
