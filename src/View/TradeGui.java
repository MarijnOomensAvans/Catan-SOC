package View;

import java.awt.Dimension;

import javax.swing.JFrame;

import Controller.TradeController;

@SuppressWarnings("serial")
public class TradeGui extends JFrame {
	
	public TradeGui(TradeController tradeController, int playerid){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new TradeOfferPane(tradeController,playerid));
		setResizable(false);
		setVisible(true);
		setTitle("Handelsscherm");
		this.pack();
		setLocationRelativeTo(null);
	}
		

}
