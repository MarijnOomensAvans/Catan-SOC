package View;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ChatController;


@SuppressWarnings("serial")
public class Chatinputgui extends JPanel  {
	
	private JTextField chatinput = new JTextField();
	private JButton sendbutton = new JButton("Stuur");
	
	
	public Chatinputgui(ChatController control, int playerid){
		
		this.setPreferredSize(new Dimension(500,35));
		chatinput.setColumns(30);
		sendbutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String message = ": " + chatinput.getText();
				control.SendMessage(playerid, message);
				chatinput.setText("");
			}	
		});
				
		add(chatinput);
		add(sendbutton);
	}

}
