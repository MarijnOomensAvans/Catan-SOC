package View;

import javax.swing.JPanel;

public class LobbyContentPane extends JPanel{
	
	LobbyVenster lobby = new LobbyVenster();

	public LobbyContentPane() {
		add(lobby);
	}
}
