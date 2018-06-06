package View.build;

import javax.swing.JFrame;

import Controller.PlayerController;
import Model.Player;

@SuppressWarnings("serial")
public class BuildFrame extends JFrame{
	private BuildContentPane buildcontentpane;
	
	public BuildFrame(PlayerController pc) {
		buildcontentpane = new BuildContentPane(this, pc);
		this.setTitle("Bouw");
		setResizable(false);
		this.setContentPane(buildcontentpane);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void closeFrame() {
		this.dispose();
	}
	
}
