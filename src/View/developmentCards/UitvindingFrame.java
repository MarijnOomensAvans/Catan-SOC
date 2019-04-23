
package View.developmentCards;
import javax.swing.JFrame;

import Controller.BankController;
import Controller.PlayerController;
import DAL.PersonDAL;
import View.inGame.InGameFrame;
import View.setupGame.DrawingPanel;

@SuppressWarnings("serial")

public class UitvindingFrame extends JFrame {
	public UitvindingFrame(PersonDAL pd, BankController bc, PlayerController playerController,int playerid, DrawingPanel dp, InGameFrame gameFrame){
		UitvindingContentPane ucp = new UitvindingContentPane(pd, bc, playerController,dp, playerid, this,gameFrame);

		
		setContentPane(ucp);
		setResizable(false);
		setVisible(true);
		setTitle("Uitvinding");
		this.pack();
		setLocationRelativeTo(null);
	}
	
}

