package View;
import java.awt.Dimension;

import javax.swing.JPanel;

import Controller.BoardController;

public class SetupGamePane extends JPanel {

	private final int WIDTH = 1400;
	private final int HEIGHT = 900;
	
	private DrawingPanel hexagonPanel;
	private SetupChangePanel changePanel;
	
	public SetupGamePane(BoardController bc) {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		changePanel = new SetupChangePanel();
		hexagonPanel = new DrawingPanel(bc);

		hexagonPanel.setBounds(0, 0, 500, 500);
		
		add(changePanel);
		add(hexagonPanel);
		
		
	}
}
