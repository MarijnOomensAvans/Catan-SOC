package View;

import java.awt.Color;
import java.io.File;

import javax.swing.JFrame;

import Controller.NotMainController;

public class DieGUI extends JFrame
{
	
	private NotMainController con;
	
	public DieGUI(NotMainController controller) {
		con = controller;
	}
	
	public void create()
	{
		DieContentPane myContent = new DieContentPane(con);

		this.setContentPane(myContent);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Dice");
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		myContent.setBackground(Color.GREEN);
	}
}
