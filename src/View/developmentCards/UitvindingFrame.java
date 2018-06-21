
package View.developmentCards;
import javax.swing.JFrame;

import Controller.PlayerController;
import Controller.RobberController;
import View.setupGame.DrawingPanel;

@SuppressWarnings("serial")

public class UitvindingFrame extends JFrame {
	public UitvindingFrame(PlayerController playerController,int playerid, DrawingPanel dp){
		UitvindingContentPane ucp = new UitvindingContentPane(playerController,dp, this);

		
		setContentPane(ucp);
		setResizable(false);
		setVisible(true);
		setTitle("Uitvinding");
		this.pack();
		setLocationRelativeTo(null);
	}
	
}

