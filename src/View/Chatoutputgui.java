package View;


import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import Model.Chat;



@SuppressWarnings("serial")
public class Chatoutputgui extends JPanel {
	
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

}
