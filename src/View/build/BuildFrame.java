package View.build;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class BuildFrame extends JFrame{
	private BuildContentPane buildcontentpane;
	
	public BuildFrame() {
		this.buildcontentpane = new BuildContentPane(this);
		this.setTitle("Bouw");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
