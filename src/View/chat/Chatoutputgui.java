
package View.chat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import Controller.ChatController;

@SuppressWarnings("serial")
public class Chatoutputgui extends JPanel implements Observer {

	private JTextArea output;
	private JScrollPane scroll;

	public Chatoutputgui(ChatController control, int playerid) {
		output = new JTextArea(21, 37);
		scroll = new JScrollPane(output, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		DefaultCaret caret = (DefaultCaret) output.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		output.setLineWrap(true);
		output.setWrapStyleWord(true);
		output.setEditable(false);

		this.setLayout(new GridLayout(1, 1));
		add(scroll);
		this.setBackground(Color.BLACK);
	}
	
	public void logToChat(String log) {
		output.append(log);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if(arg != null) {
			for(int i = 0; i < ((ArrayList<String>) arg).size(); i++) {
				
				output.append(((ArrayList<String>) arg).get(i));
			}
		}
	}



}
