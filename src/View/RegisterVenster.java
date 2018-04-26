package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class RegisterVenster extends JPanel{
	
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JTextField passwordVerificationTextField;
	
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel passwordLabelVerification;

	@SuppressWarnings("unused")
	private JButton registerButton;
	@SuppressWarnings("unused")
	private JButton cancelButton;
	
	
	private final int WIDTH = 300;
	private final int HEIGHT = 200;

	private final int FIELDWIDTH = 90;
	private final int FIELDHEIGHT = 20;

	private final int BUTTONWIDTH = 90;
	private final int BUTTONHEIGHT = 30;
	
	private final int SIGNINPANELWIDTH = 100;
	private final int SIGHTINPANELHEIGHT = 100;
	
	public RegisterVenster(JButton registerCompleetButton, JButton cancelButton) {
		
		usernameTextField = new JTextField();
		passwordTextField = new JTextField();
		passwordVerificationTextField = new JTextField();

		usernameLabel = new JLabel("Gebruikersnaam:");
		passwordLabel = new JLabel("Wachtwoord:");
		passwordLabelVerification = new JLabel("Verifieer wachtwoord:");

		usernameTextField.setAlignmentX(CENTER_ALIGNMENT);
		passwordTextField.setAlignmentX(CENTER_ALIGNMENT);
		passwordVerificationTextField.setAlignmentX(CENTER_ALIGNMENT);

		usernameTextField.setPreferredSize(new Dimension(FIELDWIDTH, FIELDHEIGHT));
		passwordTextField.setPreferredSize(new Dimension(FIELDWIDTH, FIELDHEIGHT));
		passwordVerificationTextField.setPreferredSize(new Dimension(FIELDWIDTH, FIELDHEIGHT));
		
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		setLayout(new BorderLayout());
		
		this.cancelButton = cancelButton;
		this.registerButton = registerCompleetButton;

		cancelButton.setPreferredSize(new Dimension(BUTTONWIDTH, BUTTONHEIGHT));
		registerCompleetButton.setPreferredSize(new Dimension(BUTTONWIDTH, BUTTONHEIGHT));

		JPanel signInPanel = new JPanel();
		JPanel usernameLabelPanel = new JPanel();
		JPanel usernamePanel = new JPanel();
		JPanel passwordLabelPanel = new JPanel();
		JPanel passwordPanel = new JPanel();
		JPanel passwordVerificationLabel = new JPanel();
		JPanel passwordVerificationPanel = new  JPanel();
		JPanel labelPanel = new JPanel();
		JPanel textFieldPanel = new JPanel();
		
		JPanel buttonPanel = new JPanel();
		JPanel registerPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();

		usernameLabelPanel.add(usernameLabel);
		passwordLabelPanel.add(passwordLabel);
		passwordVerificationLabel.add(passwordLabelVerification);

		usernamePanel.add(usernameTextField);
		passwordPanel.add(passwordTextField);
		passwordVerificationPanel.add(passwordVerificationTextField);
		
		labelPanel.setLayout(new GridLayout(3, 1, 10, 10));
		labelPanel.add(usernameLabelPanel, BorderLayout.NORTH);
		labelPanel.add(passwordLabelPanel, BorderLayout.CENTER);
		labelPanel.add(passwordVerificationLabel, BorderLayout.SOUTH);
		
		textFieldPanel.add(usernamePanel);
		textFieldPanel.add(passwordPanel);
		textFieldPanel.add(passwordVerificationPanel);
		
		registerPanel.add(registerCompleetButton);

		buttonPanel.add(cancelButton);
		
		signInPanel.setLayout(new GridLayout(1, 2));
		signInPanel.setPreferredSize(new Dimension(SIGNINPANELWIDTH, SIGHTINPANELHEIGHT));
		signInPanel.add(labelPanel);
		signInPanel.add(textFieldPanel);

		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, 1));
		buttonsPanel.add(registerPanel);
		buttonsPanel.add(buttonPanel);

		add(signInPanel, BorderLayout.NORTH);
		add(buttonsPanel, BorderLayout.SOUTH);
	}
}
