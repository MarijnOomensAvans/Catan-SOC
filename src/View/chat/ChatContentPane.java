package View.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import Controller.ChatController;

@SuppressWarnings("serial")
public class ChatContentPane extends JPanel {
		
	public ChatContentPane(ChatController control, Chatoutputgui cog, int playerid) {
		this.setPreferredSize(new Dimension(300, 600));
		this.setLayout(new GridBagLayout());
		Chatoutputgui out = cog;
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weighty = 1;
		gc.weightx = 1;
		gc.fill = GridBagConstraints.BOTH;
		add(out, gc);
		
		gc.weighty = 0.00;
		gc.gridy = 1;
		add(new Chatinputgui(control,playerid), gc);
	}

}
