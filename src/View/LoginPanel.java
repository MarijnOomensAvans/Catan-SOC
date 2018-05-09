package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


@SuppressWarnings("serial")
public class LoginPanel extends JPanel {

	private String warning;
	
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	
	private JLabel warningLabel;

	@SuppressWarnings("unused")
	private JButton loginButton;
	@SuppressWarnings("unused")
	private JButton registerButton;

	private final int WIDTH = 300;
	private final int HEIGHT = 170;

	private final int FIELDWIDTH = 90;
	private final int FIELDHEIGHT = 20;

	private final int BUTTONWIDTH = 110;
	private final int BUTTONHEIGHT = 30;
	
	private final int SIGNINPANELWIDTH = 100;
	private final int SIGHTINPANELHEIGHT = 70;

	public LoginPanel(JButton registerButton, JButton loginButton) {

		usernameTextField = new JTextField();
		passwordTextField = new JTextField();

		usernameLabel = new JLabel("Gebruikersnaam:");
		passwordLabel = new JLabel("Wachtwoord:");
		
		warningLabel = new JLabel();
		warningLabel.setForeground(Color.red);

		usernameTextField.setAlignmentX(CENTER_ALIGNMENT);
		passwordTextField.setAlignmentX(CENTER_ALIGNMENT);

		usernameTextField.setAlignmentY(CENTER_ALIGNMENT);
		passwordTextField.setAlignmentY(CENTER_ALIGNMENT);

		usernameTextField.setPreferredSize(new Dimension(FIELDWIDTH, FIELDHEIGHT));
		passwordTextField.setPreferredSize(new Dimension(FIELDWIDTH, FIELDHEIGHT));

		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		setLayout(new BorderLayout());

		this.loginButton = loginButton;
		this.registerButton = registerButton;

		loginButton.setPreferredSize(new Dimension(BUTTONWIDTH, BUTTONHEIGHT));
		registerButton.setPreferredSize(new Dimension(BUTTONWIDTH, BUTTONHEIGHT));

		JPanel warningPanel = new JPanel();
		
		JPanel signInPanel = new JPanel();
		JPanel usernameLabelPanel = new JPanel(); 
		JPanel usernamePanel = new JPanel(); 
		JPanel passwordLabelPanel = new JPanel();
		JPanel passwordPanel = new JPanel(); 
		JPanel labelPanel = new JPanel();
		JPanel textFieldPanel = new JPanel();

		JPanel buttonsPanel = new JPanel();
		JPanel registerPanel = new JPanel();
		JPanel logInPanel = new JPanel();
		
		usernameLabelPanel.add(usernameLabel);
		passwordLabelPanel.add(passwordLabel);
		
		warningPanel.add(warningLabel);
		
		usernamePanel.add(usernameTextField);
		passwordPanel.add(passwordTextField);
		

		labelPanel.setLayout(new GridLayout(2, 1, 10, 10));
		labelPanel.add(usernameLabelPanel, BorderLayout.NORTH);
		labelPanel.add(passwordLabelPanel, BorderLayout.SOUTH);
		
		textFieldPanel.add(usernamePanel);
		textFieldPanel.add(passwordPanel);

		registerPanel.add(registerButton);

		logInPanel.add(loginButton);

		signInPanel.setLayout(new GridLayout(1, 2));
		signInPanel.setPreferredSize(new Dimension(SIGNINPANELWIDTH, SIGHTINPANELHEIGHT));
		signInPanel.add(labelPanel);
		signInPanel.add(textFieldPanel);

		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, 1));
		buttonsPanel.add(logInPanel);
		buttonsPanel.add(registerPanel);

		add(warningPanel, BorderLayout.NORTH);
		add(signInPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);

	}

	public String getUsername() {
		return usernameTextField.getText();
	}

	public String getPassword() {
		return passwordTextField.getText();
	}
	
	public void setWarning(String warning) {
		warningLabel.setText(warning);
	}

	
	
}