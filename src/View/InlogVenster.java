package View;

import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class InlogVenster extends JFrame {
	 
	public InlogVenster(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(300,300));
		pack();
		setVisible(true);
	}
		
}
