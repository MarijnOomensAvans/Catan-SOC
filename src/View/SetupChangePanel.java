package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import Controller.BoardController;
import Controller.LobbyController;

@SuppressWarnings("serial")
public class SetupChangePanel extends JPanel implements ActionListener{
	
	private LobbyController lobby;
	private BoardController boardcontroller;

	private final int WIDTH = 200;
	private final int HEIGHT = 500;
	
	private String [] types = {"Standaard", "Random"};
	@SuppressWarnings("rawtypes")
	private JComboBox boardTypes;
	
	private JButton returnButton;
	private JButton runButton;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
		
		boardTypes.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String input = (String) boardTypes.getSelectedItem();
		if(input == "Standaard") {
			boardcontroller.setBoardType(lobby.getGameID(), 1);
			
		}
		else if (input == "Random"){
			boardcontroller.setBoardType(lobby.getGameID(), 1);
		}
		
	}
}
