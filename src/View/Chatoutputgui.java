
package View;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Controller.ChatController;



@SuppressWarnings("serial")
public class Chatoutputgui extends JPanel implements Observer {
	
	private JTextArea output;
	 JScrollPane scroll;

	
	public Chatoutputgui(ChatController control, int playerid) {
		output = new JTextArea();
		output.setPreferredSize(new Dimension(400,340));
		scroll = new JScrollPane(output,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
		output.setEditable(false);
		
		add(scroll);
	}
	

	@Override
	public void update(Observable o, Object arg) {
		output.append((String) arg);
	}

}
