package View.developmentCards;
import javax.swing.JFrame;

import Controller.BankController;
import Controller.PlayerController;
import Controller.RobberController;
import View.setupGame.DrawingPanel;

@SuppressWarnings("serial")
public class DevelopmentGui extends JFrame {
	
	
	public DevelopmentGui(BankController bc,PlayerController playerController,int playerid, int gameid, DrawingPanel dp,RobberController rc){
		DevelopmentContentPane dcp = new DevelopmentContentPane(bc, playerController, gameid, dp, this,rc);

		
		setContentPane(dcp);
		setResizable(false);
		setVisible(true);
		setTitle("DevelopmentCards");
		this.pack();
		setLocationRelativeTo(null);
	}
	
	public void closeFrame() {
		this.dispose();
	}
	
}