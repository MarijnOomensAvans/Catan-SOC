package View;

import javax.swing.JFrame;

import Controller.InlogController;


@SuppressWarnings("serial")
public class MyFrame extends JFrame{

	private ContentPane pane;
	
	public MyFrame(InlogController controller) {
		pane = new ContentPane(this, controller);
		setTitle("Inlogscherm");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(pane);
		validateScreen();
		setVisible(true);
	}
	
	public void validateScreen() {
		pack();
		setLocationRelativeTo(null);
	}
	
	public void switchScreenRegister() {
		pane.switchScreenRegister();
		pack();
	}
	
	public void setWarning(String warning) {
		pane.setWarning(warning);
	}
}
