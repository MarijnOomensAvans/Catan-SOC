package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InlogVenster extends JPanel {

	private JTextField username;
	private JTextField password;
	private JLabel usernameLabel;
	private JLabel passwordLabel;

	private JButton loginButton;
	private JButton registerButton;

	private final int WIDTH = 300;
	private final int HEIGHT = 150;

	private final int FIELDWIDTH = 90;
	private final int FIELDHEIGHT = 20;

	private final int BUTTONWIDTH = 90;
	private final int BUTTONHEIGHT = 30;

	public InlogVenster(JButton registerButton) {

		username = new JTextField();
		password = new JTextField();

		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");

		username.setAlignmentX(CENTER_ALIGNMENT);
		password.setAlignmentX(CENTER_ALIGNMENT);

		username.setPreferredSize(new Dimension(FIELDWIDTH, FIELDHEIGHT));
		password.setPreferredSize(new Dimension(FIELDWIDTH, FIELDHEIGHT));

		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		setLayout(new BorderLayout());

		loginButton = new JButton("Log in");
		registerButton = registerButton;

		loginButton.setPreferredSize(new Dimension(BUTTONWIDTH, BUTTONHEIGHT));
		registerButton.setPreferredSize(new Dimension(BUTTONWIDTH, BUTTONHEIGHT));

		JPanel buttonPanel = new JPanel();
		JPanel usernamePanel = new JPanel();
		JPanel passwordPanel = new JPanel();
		JPanel signInPanel = new JPanel();
		JPanel registerPanel = new JPanel();
		JPanel infoPanel = new JPanel();

		usernamePanel.add(usernameLabel);
		usernamePanel.add(username);

		passwordPanel.add(passwordLabel);
		passwordPanel.add(password);

		registerPanel.add(registerButton);

		buttonPanel.add(loginButton);

		signInPanel.setLayout(new BoxLayout(signInPanel, 1));
		signInPanel.add(usernamePanel);
		signInPanel.add(passwordPanel);

		infoPanel.setLayout(new BoxLayout(infoPanel, 1));
		infoPanel.add(buttonPanel);
		infoPanel.add(registerPanel);

		add(signInPanel, BorderLayout.NORTH);
		add(infoPanel, BorderLayout.CENTER);

	}

}
