package View;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ChatContentPane extends JPanel {
	
	Chatoutputgui out;
	
	public ChatContentPane() {
		setPreferredSize(new Dimension(500,400));
		setLayout(new BorderLayout());
		out = new Chatoutputgui(1);
		add(out);
		add(new Chatinputgui(1, out), BorderLayout.PAGE_END);
	}

}
