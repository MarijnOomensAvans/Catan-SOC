package View.build;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class BuildFrame extends JFrame{
	private BuildContentPane buildcontentpane;
	
	public BuildFrame() {
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
