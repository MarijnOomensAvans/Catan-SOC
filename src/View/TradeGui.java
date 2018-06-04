package View;


import javax.swing.JFrame;

import Controller.TradeController;

@SuppressWarnings("serial")
public class TradeGui extends JFrame {
	
	
	
	public TradeGui(TradeController tradeController, int playerid,TradeOfferPane top, TradeAcceptPane tap,int gameid){
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setContentPane(tap);
		///setContentPane(top);
		setResizable(false);
		setVisible(true);
		setTitle("Handelsscherm");
		this.pack();
		setLocationRelativeTo(null);
		
	}

		

}
