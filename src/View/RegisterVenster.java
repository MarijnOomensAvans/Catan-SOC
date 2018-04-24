package View;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class RegisterVenster extends JPanel{
	
	private JTextField username;
	private JTextField password;
	private JTextField passwordVerification;
	
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel passwordLabelVerification;

	private JButton registerButton;
	private JButton cancelButton;
	
	
	private final int WIDTH = 300;
	private final int HEIGHT = 200;

	private final int FIELDWIDTH = 90;
	private final int FIELDHEIGHT = 20;

	private final int BUTTONWIDTH = 90;
	private final int BUTTONHEIGHT = 30;
	
	public RegisterVenster(JButton registerCompleetButton, JButton cancelButton) {
		
		username = new JTextField();
		password = new JTextField();
		passwordVerification = new JTextField();

		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		passwordLabelVerification = new JLabel("Password:");

		username.setAlignmentX(CENTER_ALIGNMENT);
		password.setAlignmentX(CENTER_ALIGNMENT);
		passwordVerification.setAlignmentX(CENTER_ALIGNMENT);

		username.setPreferredSize(new Dimension(FIELDWIDTH, FIELDHEIGHT));
		password.setPreferredSize(new Dimension(FIELDWIDTH, FIELDHEIGHT));
		passwordVerification.setPreferredSize(new Dimension(FIELDWIDTH, FIELDHEIGHT));
		
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		setLayout(new BorderLayout());
		
		this.cancelButton = cancelButton;
		this.registerButton = registerCompleetButton;

		cancelButton.setPreferredSize(new Dimension(BUTTONWIDTH, BUTTONHEIGHT));
		registerCompleetButton.setPreferredSize(new Dimension(BUTTONWIDTH, BUTTONHEIGHT));

		JPanel buttonPanel = new JPanel();
		JPanel usernamePanel = new JPanel();
		JPanel passwordPanel = new JPanel();
		JPanel passwordVerificationPanel = new  JPanel();
		JPanel signInPanel = new JPanel();
		JPanel registerPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();

		usernamePanel.add(usernameLabel);
		usernamePanel.add(username);

		passwordPanel.add(passwordLabel);
		passwordPanel.add(password);
		
		passwordVerificationPanel.add(passwordLabelVerification);
		passwordVerificationPanel.add(passwordVerification);

		registerPanel.add(registerCompleetButton);

		buttonPanel.add(cancelButton);

		signInPanel.setLayout(new BoxLayout(signInPanel, 1));
		signInPanel.add(usernamePanel);
		signInPanel.add(passwordPanel);
		signInPanel.add(passwordVerificationPanel);

		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, 1));
		buttonsPanel.add(registerPanel);
		buttonsPanel.add(buttonPanel);

		add(signInPanel, BorderLayout.NORTH);
		add(buttonsPanel, BorderLayout.SOUTH);
	}
}
