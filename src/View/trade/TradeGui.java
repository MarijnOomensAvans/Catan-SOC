package View.trade;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import Controller.TradeController;

@SuppressWarnings("serial")
public class TradeGui extends JFrame {

	public TradeGui(TradeController tradeController, int playerid, TradeOfferPane top, int gameid) {
		setContentPane(top);
		setResizable(false);
		setVisible(true);
		setTitle("Handelsscherm");
		this.pack();
		setLocationRelativeTo(null);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//				try {
//					if ((TradeAcceptPane) getContentPane() == tap) {
//						tradeController.createOffer(playerid, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false);
//						tradeController.close();
//					}
//				} catch (ClassCastException exc) {
//
//				}
				try {
					if ((TradeResultPane) getContentPane() == tradeController.getTrp()) {
						ArrayList<Integer> ids = tradeController.getOtherid(gameid, playerid);
						tradeController.deleteOffers(playerid, ids.get(0), ids.get(1), ids.get(2));
						tradeController.removeTRP();
					}
				} catch (ClassCastException exc) {

				}
			}
		});

	}

	public TradeGui(TradeController tradeController, int playerid, TradeAcceptPane tap, int gameid) {
		setContentPane(tap);
		setResizable(false);
		setVisible(true);
		setTitle("Handelsscherm");
		this.pack();
		setLocationRelativeTo(null);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				try {
					if ((TradeAcceptPane) getContentPane() == tap) {
						tradeController.createOffer(playerid, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false);
						tradeController.close();
					}
				} catch (ClassCastException exc) {

				}
				try {
					if ((TradeResultPane) getContentPane() == tradeController.getTrp()) {
						tradeController.removeTRP();
						ArrayList<Integer> ids = tradeController.getOtherid(gameid, playerid);
						tradeController.deleteOffers(playerid, ids.get(0), ids.get(1), ids.get(2));
					}
				} catch (ClassCastException exc) {

				}
			}
		});
	}
}
