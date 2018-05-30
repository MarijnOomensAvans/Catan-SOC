package View.chat;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ChatController;

@SuppressWarnings("serial")
public class Chatinputgui extends JPanel {

	private JTextField chatinput = new JTextField();
	private JButton sendbutton = new JButton("Stuur");

	public Chatinputgui(ChatController control, int playerid) {

		// this.setPreferredSize(new Dimension(500,35));
		// chatinput.setColumns(50);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = .8f;
		gc.weighty = .5f;
		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(2, 2, 2, 2);
		add(chatinput, gc);
		
		gc.gridx = 1;
		gc.weightx = .2f;
		add(sendbutton, gc);

		chatinput.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String message = ": " + chatinput.getText() + "\n";
				control.SendMessage(playerid, message);
				chatinput.setText("");
			}

		});
		sendbutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String message = ": " + chatinput.getText() + "\n";
				control.SendMessage(playerid, message);
				chatinput.setText("");
			}
		});
	}

}
