package view;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Chatinput extends JPanel {
	
	private JTextField chatinput = new JTextField();
	private JButton sendbutton = new JButton("Stuur");
	
	public Chatinput(){
		chatinput.setColumns(30);
		add(chatinput);
		add(sendbutton);
	}

}
