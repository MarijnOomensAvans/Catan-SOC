package View.developmentCards;

import javax.swing.JFrame;

import Controller.BankController;
import Controller.IngameController;
import Controller.PlayerController;
import Controller.RobberController;
import DAL.PersonDAL;
import View.inGame.InGameFrame;
import View.setupGame.DrawingPanel;

@SuppressWarnings("serial")
public class DevelopmentGui extends JFrame {

	public DevelopmentGui(PersonDAL pd, BankController bc, PlayerController playerController, int playerid, int gameid,
			DrawingPanel dp, RobberController rc, InGameFrame gameFrame, IngameController igc) {
		DevelopmentContentPane dcp = new DevelopmentContentPane(pd, bc, playerController, gameid, dp, this, rc,
				gameFrame);

		setContentPane(dcp);
		setResizable(false);
		setVisible(true);
		setTitle("DevelopmentCards");
		this.pack();
		setLocationRelativeTo(null);

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				try {
					igc.setDevCardButton(true);
				} catch (ClassCastException exc) {

				}
			}
		});
	}

	public void closeFrame() {
		this.dispose();
	}

}