package View;


import javax.swing.JFrame;

import Controller.TradeController;

@SuppressWarnings("serial")
public class TradeGui extends JFrame {
	
	
	
	public TradeGui(TradeController tradeController, int playerid,TradeOfferPane top){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
<<<<<<< HEAD
		setContentPane(top);
=======
		setContentPane(new TradeOfferPane(tradeController, playerid, true));
>>>>>>> 64b4117ee8a1ad962f3f86cdc08a809913d7852e
		setResizable(false);
		setVisible(true);
		setTitle("Handelsscherm");
		this.pack();
		setLocationRelativeTo(null);
	}

		

}
