import java.awt.Color;
import java.io.File;

import javax.swing.JFrame;

public class DieGUI extends JFrame
{
	public void create()
	{
		DieContentPane myContent = new DieContentPane();

		this.setContentPane(myContent);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Dice");
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		myContent.setBackground(Color.GREEN);
	}
}
