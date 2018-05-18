package View;



import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import Model.Chat;



@SuppressWarnings("serial")
public class Chatoutputgui extends JPanel implements Observer {
	
	private JTextArea output;;
	private Chat chat;

	
	public Chatoutputgui(int playerid) {
		chat = new Chat(playerid);
		output = new JTextArea(30,37);
		chat.SendMessage(playerid, " joined the chatroom");
		output.setEditable(false);
		//output.setVisible(true);
		this.getLatestMessage();
		add(output);
	}
	
	public void getLatestMessage()
	{
		output.append(chat.getchatText() + "\n");
	}

	@Override
	public void update(Observable o, Object arg) {
		getLatestMessage();		
	}

}
