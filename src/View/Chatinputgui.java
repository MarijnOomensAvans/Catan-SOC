package View;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


import Model.Chat;


@SuppressWarnings("serial")
public class Chatinputgui extends JPanel  {
	
	private JTextField chatinput = new JTextField();
	private JButton sendbutton = new JButton("Stuur");
	private JButton getmsg = new JButton("Ophalen");		//testbutton
	private Chat chat;
	private Chatoutputgui out;
	
	public Chatinputgui(int playerid, Chatoutputgui out){
		chat = new Chat(playerid);
		this.out = out;
		this.setPreferredSize(new Dimension(500,35));
		chatinput.setColumns(30);
		sendbutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String message = ": " + chatinput.getText();
				chat.SendMessage(playerid, message);
				out.getLatestMessage();
				chatinput.setText("");
			}	
		});
		
		getmsg.addActionListener(new ActionListener() {		//testbutton
			public void actionPerformed(ActionEvent e) {
				out.getLatestMessage();
			}
		});
		
		add(chatinput);
		add(sendbutton);
		add(getmsg);		//testbutton
	}

}
