package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAL.ChatDal;
import DAL.MainDAL;
import DAL.PersonDal;

@SuppressWarnings("serial")
public class Chatinput extends JPanel {
	
	private JTextField chatinput = new JTextField();
	private JButton sendbutton = new JButton("Stuur");
	private int playerid;
	private String username;
	
	public Chatinput(int playerid){
		chatinput.setColumns(30);
		this.playerid = playerid;
		username =getUserName();
		sendbutton.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				String message = chatinput.getText();
				SendMessage(playerid,message);
				
			}

			
		});
		
		
		add(chatinput);
		add(sendbutton);
	}

	

	private String getUserName() {
		String name = "";
		MainDAL db = new MainDAL();
		{ 
		if ((db.loadDataBaseDriver("com.mysql.jdbc.Driver"))
				&& (db.makeConnection()))
		{
			PersonDal pd = new PersonDal();
			 name =pd.getName(playerid);
			
		}
		}
		return name;
	}



	private void SendMessage(int playerid, String message) {
		if(message.length() > 255) {
			
		}else {
		MainDAL db = new MainDAL();
		{ 
		if ((db.loadDataBaseDriver("com.mysql.jdbc.Driver"))
				&& (db.makeConnection()))
		{
			ChatDal cd = new ChatDal();
			cd.SendMessage(playerid, message);
		}
	}
}
	}
}
