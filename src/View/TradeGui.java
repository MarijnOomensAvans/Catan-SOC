package View;


import javax.swing.JFrame;

import Controller.TradeController;

@SuppressWarnings("serial")
public class TradeGui extends JFrame {
	
	private TradeController tc;
	private int playerid;
	
	public TradeGui(TradeController tradeController, int playerid){
		this.playerid = playerid;
		this.tc = tradeController;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new TradeOfferPane(tradeController,playerid));
		setResizable(false);
		setVisible(true);
		this.pack();
		setLocationRelativeTo(null);
	}

		

}
