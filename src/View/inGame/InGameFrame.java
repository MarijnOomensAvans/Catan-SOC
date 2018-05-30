package View.inGame;

import javax.swing.JFrame;

import Controller.BoardController;
import View.setupGame.DrawingPanel;

@SuppressWarnings("serial")
public class InGameFrame extends JFrame{
// making intance variables
	private IngameView pane;
	
	public InGameFrame(BoardController bc, int gameID,DrawingPanel inGameBoard) {
//initialize contentpane 
		pane = new IngameView(bc, gameID,inGameBoard);
// create the frame		
		setTitle("Catan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setContentPane(pane);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
