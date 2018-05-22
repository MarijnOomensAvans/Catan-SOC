package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class SetupGamePane extends JPanel {

	private final int WIDTH = 1400;
	private final int HEIGHT = 900;
	
	private DrawingPanel hexagonPanel;
	private SetupChangePanel changePanel;
	
	public SetupGamePane() {
		
		changePanel = new SetupChangePanel();
		hexagonPanel = new DrawingPanel();

		hexagonPanel.setBounds(0, 0, 500, 500);
		
		add(changePanel);
		add(hexagonPanel);
		
	}
}
