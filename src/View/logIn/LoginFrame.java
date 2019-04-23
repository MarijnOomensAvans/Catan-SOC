package View.logIn;

import javax.swing.JFrame;

import Controller.LoginController;


@SuppressWarnings("serial")
public class LoginFrame extends JFrame{

	private LoginContentPane pane;
	
	public LoginFrame(LoginController controller) {
		pane = new LoginContentPane(this, controller);
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
	
	public void closeScreen() {
		dispose();
	}
}
