package View.build;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class BuildFrame extends JFrame{
	private BuildContentPane buildcontentpane;
	
	public BuildFrame() {
		this.buildcontentpane = new BuildContentPane(this, null); //TODO geef player mee als er een beurtensysteem in zit
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
