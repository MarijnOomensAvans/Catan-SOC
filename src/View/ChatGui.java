package View;


import javax.swing.JFrame;

import Controller.ChatController;


@SuppressWarnings("serial")
public class ChatGui extends JFrame {
	
	public ChatGui(ChatController control,int playerid) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new ChatContentPane(control,playerid));
		setResizable(true);
		setVisible(true);
		pack();
		setLocationRelativeTo(null);

	}

}
