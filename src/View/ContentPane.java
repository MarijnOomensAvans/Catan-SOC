package View;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.InlogController;

@SuppressWarnings("serial")
public class ContentPane extends JPanel {

	private InlogVenster inlogVenster;
	private RegisterVenster registerVenster;
	private MyFrame GUI;
	private JButton registerButton, loginButton;
	private JButton registerCompleetButton, cancelButton;

	public ContentPane(MyFrame GUI, InlogController controller) {
		this.GUI = GUI;
		registerButton = new JButton("Registreer");
		loginButton = new JButton("Inloggen");
		registerCompleetButton = new JButton("Registreer");

		cancelButton = new JButton("Annuleer");

		inlogVenster = new InlogVenster(registerButton, loginButton);
		registerVenster = new RegisterVenster(registerCompleetButton, cancelButton);

		loginButton.addActionListener(e -> {
			String username = inlogVenster.getUsername();
			String password = inlogVenster.getPassword();
			controller.buttonPressedLogin(username, password);
		});
		
		registerButton.addActionListener(e -> {
			controller.buttonPressedRegister();
			switchScreenRegister();
		});

		cancelButton.addActionListener(e -> {
			controller.buttonPressedCancel();
			switchScreenInlog();
		});
		
		registerCompleetButton.addActionListener(e -> {
			String username = registerVenster.getUsername();
			String password = registerVenster.getPassword();
			String passwordVer = registerVenster.getPasswordVerification();
			controller.buttonPressedRegisterCompleet(username, password, passwordVer);
		});

		add(inlogVenster);
	}

	public void switchScreenRegister() {
		removeAll();
		repaint();
		add(registerVenster);
		GUI.pack();
	}

	public void switchScreenInlog() {
		removeAll();
		repaint();
		add(inlogVenster);
		GUI.pack();
	}
	
	public void setWarning(String warning) {
		inlogVenster.setWarning(warning);
		registerVenster.setWarning(warning);
	}

}
