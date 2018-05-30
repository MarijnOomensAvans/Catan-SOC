package View.logIn;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.LoginController;

@SuppressWarnings("serial")
public class LoginContentPane extends JPanel {

	private LoginPanel loginPanel;
	private RegisterPanel registerPanel;
	private LoginFrame GUI;
	private JButton registerButton, loginButton;
	private JButton registerCompleetButton, cancelButton;

	public LoginContentPane(LoginFrame GUI, LoginController controller) {
		this.GUI = GUI;
		registerButton = new JButton("Registreer");
		loginButton = new JButton("Inloggen");
		registerCompleetButton = new JButton("Registreer");

		cancelButton = new JButton("Annuleer");

		loginPanel = new LoginPanel(registerButton, loginButton);
		registerPanel = new RegisterPanel(registerCompleetButton, cancelButton);

		loginButton.addActionListener(e -> {
			String username = loginPanel.getUsername();
			String password = loginPanel.getPassword();
			controller.buttonPressedLogin(username, password);
		});

		registerButton.addActionListener(e -> {
			controller.buttonPressedRegister();
			switchScreenRegister();
		});

		cancelButton.addActionListener(e -> {
			switchScreenInlog();
		});

		registerCompleetButton.addActionListener(e -> {
			String username = registerPanel.getUsername();
			String password = registerPanel.getPassword();
			String passwordVer = registerPanel.getPasswordVerification();
			controller.buttonPressedRegisterCompleet(username, password, passwordVer);
		});

		add(loginPanel);
	}

	//Switch the visible panel to register
	public void switchScreenRegister() {
		removeAll();
		repaint();
		add(registerPanel);
		GUI.pack();
	}
	
	//Switch the visible panel to login
	public void switchScreenInlog() {
		removeAll();
		repaint();
		add(loginPanel);
		GUI.pack();
	}

	
	//Display the relevant warning for logging in / registering
	public void setWarning(String warning) {
		loginPanel.setWarning(warning);
		registerPanel.setWarning(warning);
	}

}
