package View.lobby;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import Controller.LobbyController;
import Controller.LoginController;
import View.setupGame.SetupGameFrame;

public class InvitePanel extends JPanel {
// creating intance variables
	private final int WIDTH = 1000;
	private final int HEIGHT = 50;

	private JComboBox box1;
	private JComboBox box2;
	private JComboBox box3;

	private JButton sendButton;

	private String[] boxValues;

	private Font buttonFont;

	private ArrayList<String> names;

	public InvitePanel(LobbyController lc, SetupGameFrame frame) {
// initialize everything
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(new Color(230, 230, 230, 255));
		setLayout(new GridBagLayout());

		names = lc.getUsernames();

		buttonFont = new Font("Times New Roman", Font.BOLD, 22);

		sendButton = new JButton("Verstuur uitnodigingen");
		sendButton.setBackground(Color.orange);
		sendButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		sendButton.setPreferredSize(new Dimension(250, 50));
		sendButton.setFont(buttonFont);

		boxValues = new String[3];
// initialize comboBoxes
		box1 = new JComboBox(names.toArray());
		box2 = new JComboBox(names.toArray());
		box3 = new JComboBox(names.toArray());

		box1.setSelectedIndex(-1);
		box2.setSelectedIndex(-1);
		box3.setSelectedIndex(-1);
// creating a gridbagcontraints
		GridBagConstraints gc = new GridBagConstraints();
// positioning the box
		gc.weightx = 0.5f;
		gc.weighty = 0.5f;

		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.PAGE_END;
		this.add(box1, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		this.add(box2, gc);

		gc.gridx = 2;
		gc.gridy = 0;
		this.add(box3, gc);

		gc.weighty = 1;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 3;
		gc.anchor = GridBagConstraints.CENTER;
		this.add(sendButton, gc);
// add itemlisteners add to array
		box1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					boxValues[0] = box1.getSelectedItem().toString();
				}

			}
		});
		box2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					boxValues[1] = box2.getSelectedItem().toString();
				}

			}
		});
		box3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					boxValues[2] = box3.getSelectedItem().toString();
				}

			}
		});
// add actionlistener searching for users
		sendButton.addActionListener(e -> {

			boolean boxIsEmpty = false;

			for (int i = 0; i < 3; i++) {
				if (boxValues[i] == null) {
					boxIsEmpty = true;
				}
			}

			if (!boxIsEmpty) {
				lc.createInvitation(LoginController.getUsername(), lc.getGameID(), 1);
				lc.createInvitation(boxValues[0], lc.getGameID(), 2);
				lc.createInvitation(boxValues[1], lc.getGameID(), 3);
				lc.createInvitation(boxValues[2], lc.getGameID(), 4);
				frame.dispose();
			}

		});
	}

}
