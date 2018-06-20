package View.logIn;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
//import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
	private ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("background.jpg"));
	private BufferedImage logo;

	public LoginContentPane(LoginFrame GUI, LoginController controller) {
		this.GUI = GUI;
		registerButton = new JButton("Registreer");
		loginButton = new JButton("Inloggen");
		registerCompleetButton = new JButton("Registreer");
		cancelButton = new JButton("Annuleer");
		try {
			logo = ImageIO.read(ClassLoader.getSystemResource("logoCatan.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		this.setPreferredSize(new Dimension(1280, 720));

		loginPanel = new LoginPanel(registerButton, loginButton, 380, 200);
		registerPanel = new RegisterPanel(registerCompleetButton, cancelButton, 380, 200);

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
			switchScreenLogin();
		});

		registerCompleetButton.addActionListener(e -> {
			String username = registerPanel.getUsername();
			String password = registerPanel.getPassword();
			String passwordVer = registerPanel.getPasswordVerification();
			if(controller.buttonPressedRegisterCompleet(username, password, passwordVer)) {
				switchScreenLogin();
			}
		});

		//try {
			//background = ImageIO.read(bgFile);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		this.setLayout(new GridBagLayout());
		
		add(loginPanel);
	}

	//Switch the visible panel to register
	public void switchScreenRegister() {
		remove(loginPanel);
		repaint();
		add(registerPanel);
		validate();
	}
	
	//Switch the visible panel to login
	public void switchScreenLogin() {
		remove(registerPanel);
		repaint();
		add(loginPanel);
		validate();
	}

	
	//Display the relevant warning for logging in / registering
	public void setWarning(String warning) {
		loginPanel.setWarning(warning);
		registerPanel.setWarning(warning);
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawImage(background,  0, 0, null);
		background.paintIcon(this, g, 0, 0);
		g.drawImage(logo, 300, 10, null);
	}

}
