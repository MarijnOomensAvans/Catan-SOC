package View;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GUI_Inlogscherm extends JFrame{

	private Inlogscherm pane;
	
	public GUI_Inlogscherm() {
		pane = new Inlogscherm(this);
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
}
