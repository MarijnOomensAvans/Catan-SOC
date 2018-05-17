package View;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LobbyContentPane extends JPanel{
	
	private LobbyPanel lobby;
	private LobbyFrame frame;
	private JButton playButton;

	public LobbyContentPane(LobbyFrame frame) {
		playButton = new JButton("Start");
		closeLobbyScreen();
		this.frame = frame;
		this.lobby = new LobbyPanel(this, playButton);
		add(lobby);
	}
	public ArrayList<String> getUsernames(){
		return frame.getUsernames();	
	}
	
	public void closeLobbyScreen() {
		playButton.addActionListener(e -> {
			frame.closeLobby();
		});
	}
}
