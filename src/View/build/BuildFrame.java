package View.build;

import javax.swing.JFrame;

import Controller.PlayerController;
import Model.Player;
import View.setupGame.DrawingPanel;

@SuppressWarnings("serial")
public class BuildFrame extends JFrame{
	private BuildContentPane buildcontentpane;
	
	public BuildFrame(PlayerController pc, DrawingPanel inGameBoard) {
		buildcontentpane = new BuildContentPane(this, pc, inGameBoard);
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
