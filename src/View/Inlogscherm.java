package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Inlogscherm extends JPanel implements ActionListener{

	private InlogVenster inlogVenster;
	private RegisterVenster registerVenster;
	private JButton registerButton;
	private JButton registerCompleetButton, cancelButton;
	private GUI_Inlogscherm GUI;

	public Inlogscherm(GUI_Inlogscherm GUI) {
		this.GUI = GUI;
		registerButton = new JButton("Register");
		registerButton.addActionListener(this);
		registerButton.setActionCommand("register");
		
		registerCompleetButton = new JButton("Register");
		registerCompleetButton.addActionListener(this);
		registerCompleetButton.setActionCommand("registerCompleet");
		
		cancelButton = new JButton("Annuleer");
		cancelButton.addActionListener(this);
		cancelButton.setActionCommand("annuleer");
		
		inlogVenster = new InlogVenster(registerButton);
		registerVenster = new RegisterVenster(registerCompleetButton, cancelButton);
		
		add(inlogVenster);
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getActionCommand() == "register") {
			removeAll();
			repaint();
			add(registerVenster);
			GUI.setTitle("Registerscherm");
			GUI.validateScreen();
		}
		if(arg0.getActionCommand()== "registerCompleet") {
			System.out.println("DONE");
		}
		if(arg0.getActionCommand()== "annuleer") {
			removeAll();
			repaint();
			add(inlogVenster);
			GUI.setTitle("Inlogscherm");
			GUI.validateScreen();
		}
		
	}
	
	

}
