package View;


import javax.swing.JFrame;

import Controller.TradeController;

@SuppressWarnings("serial")
public class TradeGui extends JFrame {
	
	
	
	public TradeGui(TradeController tradeController, int playerid,TradeAcceptPane tap){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(tap);
		setResizable(false);
		setVisible(true);
		setTitle("Handelsscherm");
		this.pack();
		setLocationRelativeTo(null);
	}

		

}
