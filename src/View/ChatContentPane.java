package View;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import Controller.ChatController;

@SuppressWarnings("serial")
public class ChatContentPane extends JPanel {
		
	public ChatContentPane(ChatController control, int playerid) {
		setPreferredSize(new Dimension(500,400));
		setLayout(new BorderLayout());
		Chatoutputgui out = new Chatoutputgui(control,playerid);
		add(out);
		add(new Chatinputgui(control,playerid), BorderLayout.PAGE_END);
	}

}
