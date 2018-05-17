package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ChatContentPane extends JPanel {
	
	public ChatContentPane() {
		setPreferredSize(new Dimension(500,400));
		setLayout(new BorderLayout());
		add(new Chatoutput());
		add(new Chatinput(1), BorderLayout.PAGE_END);
	}

}
