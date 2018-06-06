package View.developmentCards;
import javax.swing.JFrame;

import Controller.PlayerController;

@SuppressWarnings("serial")
public class DevelopmentGui extends JFrame {
	
	
	public DevelopmentGui(PlayerController playerController,DevelopmentContentPane dcp,int playerid, int gameid){
		

		
		setContentPane(dcp);
		setResizable(false);
		setVisible(true);
		setTitle("DevelopmentCards");
		this.pack();
		setLocationRelativeTo(null);
	}
}