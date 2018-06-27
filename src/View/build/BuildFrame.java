package View.build;

import javax.swing.JFrame;

import Controller.BankController;
import Controller.IngameController;
import Controller.PlayerController;
import View.setupGame.DrawingPanel;

@SuppressWarnings("serial")
public class BuildFrame extends JFrame{
	private BuildContentPane buildcontentpane;
	
	public BuildFrame(PlayerController pc, DrawingPanel inGameBoard, IngameController igc, BankController bc, int playerid) {
		buildcontentpane = new BuildContentPane(this, pc, inGameBoard, bc, playerid);
		this.setTitle("Bouw");
		setResizable(false);
		this.setContentPane(buildcontentpane);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				try {
					igc.setBuildButton(true);
				} catch (ClassCastException exc) {

				}
			}
		});
		
	}
	
	public void closeFrame() {
		this.dispose();
	}
	
}
