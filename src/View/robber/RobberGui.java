package View.robber;

import javax.swing.JFrame;

import Controller.BoardController;
import Controller.RobberController;
import DAL.RobberDAL;

@SuppressWarnings("serial")
public class RobberGui extends JFrame {
	
	public RobberGui(int gameID, RobberDAL rd, int playerID, RobberController robberController, int x, int y, BoardController bc){
		setContentPane(new RobberPane(gameID,rd,playerID,robberController,x,y,bc));
		setResizable(false);
		setVisible(true);
		setTitle("Kies een speler om een kaart van te pakken");
		this.pack();
		setLocationRelativeTo(null);
	}
}
