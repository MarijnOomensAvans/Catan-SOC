package View;

import java.util.ArrayList;

import javax.swing.JPanel;

public class LobbyContentPane extends JPanel{
	
	private LobbyVenster lobby;
	private LobbyFrame frame;

	public LobbyContentPane(LobbyFrame frame) {
		this.frame = frame;
		this.lobby = new LobbyVenster(this);
		add(lobby);
	}
	public ArrayList<String> getUsernames(){
		return frame.getUsernames();
		
	}
}
