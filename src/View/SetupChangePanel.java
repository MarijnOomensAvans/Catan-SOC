package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class SetupChangePanel extends JPanel{

	private final int WIDTH = 200;
	private final int HEIGHT = 500;
	
	private String [] types = {"Standaard", "Random", "Custom"};
	private JComboBox boardTypes;
	
	private JButton returnButton;
	private JButton runButton;
	
	public SetupChangePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		
		runButton = new JButton("Start");
		runButton.setBackground(Color.YELLOW);
		
		returnButton = new JButton("Return");
		
		boardTypes = new JComboBox(types);
		
		add(boardTypes, BorderLayout.NORTH);
		add(returnButton, BorderLayout.SOUTH);
		add(runButton, BorderLayout.SOUTH);
	}
}
