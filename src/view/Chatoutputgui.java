package view;


import javax.swing.JPanel;
import javax.swing.JTextArea;

import Model.Chat;



@SuppressWarnings("serial")
public class Chatoutputgui extends JPanel {
	
	private JTextArea output = new JTextArea(30,37);
	private Chat c;

	
	public Chatoutputgui(int playerid) {
		c = new Chat(playerid);
		output.setEditable(false);
		output.setText(c.getchatText());
		add(output);
	}
	
	
}
