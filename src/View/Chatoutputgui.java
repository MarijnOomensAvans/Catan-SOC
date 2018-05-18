package View;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import Controller.ChatController;



@SuppressWarnings("serial")
public class Chatoutputgui extends JPanel implements Observer {
	
	private JTextArea output;;

	
	public Chatoutputgui(ChatController control, int playerid) {
		output = new JTextArea(30,37);
		control.SendMessage(playerid, " joined the chatroom");
		String message =control.getLatestMessage();
		output.append(message);
		output.setEditable(false);
		//output.setVisible(true);
		add(output);
	}
	

	@Override
	public void update(Observable o, Object arg) {
		output.append((String) arg);
	}

}
