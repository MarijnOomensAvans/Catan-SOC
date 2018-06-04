package View.logIn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.PasswordView;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel {

	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private BufferedImage background;

	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel warningLabel;

	@SuppressWarnings("unused")
	private JButton loginButton;
	@SuppressWarnings("unused")
	private JButton registerButton;
	
	private Font font;
	private Font warningFont;

	private final int FIELDWIDTH = 90;
	private final int FIELDHEIGHT = 30;

	private final int BUTTONWIDTH = 110;
	private final int BUTTONHEIGHT = 30;

	private final int SIGNINPANELWIDTH = 100;
	private final int SIGHTINPANELHEIGHT = 70;

	public LoginPanel(JButton registerButton, JButton loginButton, int width, int height) {

		setPreferredSize(new Dimension(width, height));
		
		font = new Font("Arial", Font.BOLD, 21);
		warningFont = new Font("Arial", Font.BOLD, 18);

		usernameTextField = new JTextField();
		passwordTextField = new JTextField();

		usernameLabel = new JLabel("Gebruikersnaam:");
		passwordLabel = new JLabel("Wachtwoord:");

		warningLabel = new JLabel(" ");
		warningLabel.setForeground(Color.red);

		usernameTextField.setAlignmentX(CENTER_ALIGNMENT);
		passwordTextField.setAlignmentX(CENTER_ALIGNMENT);

		usernameTextField.setAlignmentY(CENTER_ALIGNMENT);
		passwordTextField.setAlignmentY(CENTER_ALIGNMENT);

		usernameTextField.setPreferredSize(new Dimension(FIELDWIDTH, FIELDHEIGHT));
		passwordTextField.setPreferredSize(new Dimension(FIELDWIDTH, FIELDHEIGHT));
		
		usernameLabel.setFont(font);
		passwordLabel.setFont(font);
		warningLabel.setFont(warningFont);
		
		this.setBackground(new Color(170, 150, 150, 200));
		this.setBorder(BorderFactory.createLineBorder(new Color(150, 50, 59, 240), 5));

		this.loginButton = loginButton;
		this.registerButton = registerButton;
		
		warningLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weighty = 0.5f;
		gc.weightx = .8;
		
		gc.insets = new Insets(5, 5, 5, 5);
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LAST_LINE_END;
		add(usernameLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		add(passwordLabel, gc);
		
		gc.insets = new Insets(5, 5, 5, 20);
		gc.gridx = 1;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.PAGE_END;
		add(usernameTextField, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.CENTER;
		add(passwordTextField, gc);
		
		gc.insets = new Insets(20, 20, 20, 20);
		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 0;
		gc.anchor = GridBagConstraints.CENTER;
		add(loginButton, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.anchor = GridBagConstraints.CENTER;
		add(registerButton, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridwidth = 2;
		gc.weighty = 0.2f;
		gc.insets = new Insets(0,0,0,0);
		gc.fill = GridBagConstraints.BOTH;
		add(warningLabel, gc);
	}

	public String getUsername() {
		return usernameTextField.getText();
	}

	public String getPassword() {
		return passwordTextField.getText();
	}

	// Display a warning
	public void setWarning(String warning) {
		warningLabel.setText(warning);
	}

}
