package View.chat;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import Controller.ChatController;

@SuppressWarnings("serial")
public class ChatContentPane extends JPanel {
		
	public ChatContentPane(ChatController control, Chatoutputgui cog, int playerid) {
		setPreferredSize(new Dimension(500,400));
		setLayout(new BorderLayout());
		Chatoutputgui out = cog;
		add(out);
		add(new Chatinputgui(control,playerid), BorderLayout.PAGE_END);
	}

}
