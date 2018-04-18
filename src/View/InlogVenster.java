package View;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class InlogVenster extends JFrame {
	
	private JButton loginbutton;
	 
	public InlogVenster(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(300,300));
		loginbutton = new JButton("Inloggen");
		add(loginbutton);
		setResizable(false);
		pack();
		setVisible(true);
	}
		
}
