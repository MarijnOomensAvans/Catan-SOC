package view;


import java.awt.Dimension;
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
	private Chat c;
	
	public Chatinputgui(int playerid){
		c = new Chat(playerid);
		this.setPreferredSize(new Dimension(500,35));
		chatinput.setColumns(30);
		sendbutton.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				String message = chatinput.getText();
				c.SendMessage(playerid,message);
				chatinput.setText("");
			}

			
		});
		add(chatinput);
		add(sendbutton);
	}



}
