
package View.developmentCards;
import javax.swing.JFrame;

import Controller.BankController;
import Controller.PlayerController;
import View.setupGame.DrawingPanel;

@SuppressWarnings("serial")

public class UitvindingFrame extends JFrame {
	public UitvindingFrame(BankController bc, PlayerController playerController,int playerid, DrawingPanel dp){
		UitvindingContentPane ucp = new UitvindingContentPane(bc, playerController,dp, playerid, this);

		
		setContentPane(ucp);
		setResizable(false);
		setVisible(true);
		setTitle("Uitvinding");
		this.pack();
		setLocationRelativeTo(null);
	}
	
}

