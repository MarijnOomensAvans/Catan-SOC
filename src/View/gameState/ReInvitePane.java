package View.gameState;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import Controller.LobbyController;

public class ReInvitePane extends JPanel{

	private final int WIDTH = 400;
	private final int HEIGHT = 50;
	
	private int amountOfDeclines = 0;
	
	private ArrayList<String> names;
	
	public ReInvitePane(LobbyController lc) {
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		names = new ArrayList<String>();
		JComboBox<String> box = null;
		names.add("Mustafa");
		names.add("Bryan");
		for(int i = 0; i < amountOfDeclines; i++) {
			for(int j = 0; j < names.size(); j++) {
				box = new JComboBox(names.toArray());
			}
			add(box);
		
		}
	}
}
