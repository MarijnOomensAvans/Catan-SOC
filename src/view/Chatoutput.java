package view;


import javax.swing.JPanel;
import javax.swing.JTextArea;

import DAL.ChatDal;
import DAL.MainDAL;

@SuppressWarnings("serial")
public class Chatoutput extends JPanel {
	
	private JTextArea output = new JTextArea(30,37);
	
	public Chatoutput() {
		output.setEditable(false);
		add(output);
	}
	
	public void getchatText() {
		MainDAL db = new MainDAL();
		{ 
		if ((db.loadDataBaseDriver("com.mysql.jdbc.Driver"))
				&& (db.makeConnection()))
		{
			ChatDal cd = new ChatDal();
			String messages =cd.GetMessage();
			output.setText(messages);
		}
	}
	}
}
