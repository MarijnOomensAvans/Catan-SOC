package View;

import javax.swing.JFrame;

import Controller.BoardController;

public class InGameFrame extends JFrame{

	private InGamePanel pane;
	
	public InGameFrame(BoardController bc, int gameID) {
		pane = new InGamePanel(bc, gameID);
		
		setTitle("Catan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setContentPane(pane);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
