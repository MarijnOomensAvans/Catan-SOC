package View.gameState;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.mysql.fabric.xmlrpc.base.Array;

import Controller.LobbyController;

public class ReInvitePane extends JPanel{

	private final int WIDTH = 400;
	private final int HEIGHT = 50;
	
	private int amountOfDeclines = 0;
	
	private ArrayList<String> states;
	private ArrayList<String> names;
	
	private LobbyController lc;
	
	public ReInvitePane(LobbyController lc) {
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.lc = lc;
		
		
	
		
	}
	
	public void getStates() {
			for(int i =0; i < states.size(); i++) {
			if (states.get(i).equals("geweigerd")) {
				amountOfDeclines++;
				System.out.println(amountOfDeclines);
				System.out.println(names.get(i));
			}
		}
	}
	
	public void getNames() {
		
		for(int i = 0; i < lc.getHostedGames().size(); i++) {
			names = lc.getHostedGames().get(i).getPlayers();
			states = lc.getHostedGames().get(i).getStatus();
			
		}
		
	}
	
	public void getDeclines() {
		
		JComboBox<String> box = null;
		for(int i = 0; i < amountOfDeclines; i++) {
			for(int j = 0; j < names.size(); j++) {
				box = new JComboBox(names.toArray());
			}
			add(box);
			
		}
	}
	
}
