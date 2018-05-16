package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAL.ChatDal;
import DAL.MainDAL;

@SuppressWarnings("serial")
public class Chatinput extends JPanel {
	
	private JTextField chatinput = new JTextField();
	private JButton sendbutton = new JButton("Stuur");
	
	public Chatinput(){
		chatinput.setColumns(30);
		sendbutton.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				SendMessage();
				
			}

			
		});
		
		
		add(chatinput);
		add(sendbutton);
	}

	private void SendMessage() {
		MainDAL db = new MainDAL();
		{ 
		if ((db.loadDataBaseDriver("com.mysql.jdbc.Driver"))
				&& (db.makeConnection()))
		{
			ChatDal cd = new ChatDal();
		
	}
}
	}
}
