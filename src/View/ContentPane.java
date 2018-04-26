package View;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.InlogController;

@SuppressWarnings("serial")
public class ContentPane extends JPanel {

	private InlogVenster inlogVenster;
	private RegisterVenster registerVenster;
	private MyFrame GUI;
	private JButton registerButton;
	private JButton registerCompleetButton, cancelButton;

	public ContentPane(MyFrame GUI, InlogController controller) {
		this.GUI = GUI;
		this.registerButton = new JButton("Register");
		registerButton.setActionCommand("register");
		registerCompleetButton = new JButton("Register");

		cancelButton = new JButton("Annuleer");

		inlogVenster = new InlogVenster(registerButton);
		registerVenster = new RegisterVenster(registerCompleetButton, cancelButton);

		registerButton.addActionListener(e -> {
			switchScreenRegister();
			controller.buttonPressed();
		});

		cancelButton.addActionListener(e -> {
			switchScreenInlog();
			controller.buttonPressed();
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

}
