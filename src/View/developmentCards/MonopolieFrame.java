package View.developmentCards;

import javax.swing.JFrame;

import Controller.BankController;
import Controller.PlayerController;
import DAL.PersonDAL;
import View.inGame.InGameFrame;
import View.setupGame.DrawingPanel;

@SuppressWarnings("serial")
public class MonopolieFrame extends JFrame{
	
	public MonopolieFrame(PersonDAL pd, BankController bc, PlayerController playerController,int playerid, DrawingPanel dp, InGameFrame gameFrame){
		MonopolieContentPane mcp = new MonopolieContentPane(pd, bc, playerController,dp, playerid, this,gameFrame);

		
		setContentPane(mcp);
		setResizable(false);
		setVisible(true);
		setTitle("Monopolie");
		this.pack();
		setLocationRelativeTo(null);
	}
	
}



