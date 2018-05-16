package view;
import java.awt.Dimension;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class ChatGui extends JFrame {
	
	public ChatGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new ChatContentPane());
		setResizable(false);
		setVisible(true);
		pack();
		setLocationRelativeTo(null);

	}

}
