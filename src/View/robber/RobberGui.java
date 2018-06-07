package View.robber;

import javax.swing.JFrame;

import Controller.RobberController;
import DAL.RobberDAL;

@SuppressWarnings("serial")
public class RobberGui extends JFrame {
	
	public RobberGui(int gameID, RobberDAL rd, int playerID, RobberController robberController){
		setContentPane(new RobberPane(gameID,rd,playerID,robberController));
		setResizable(false);
		setVisible(true);
		setTitle("Kies speler om een kaart van te pakken");
		this.pack();
		setLocationRelativeTo(null);
	}
}
