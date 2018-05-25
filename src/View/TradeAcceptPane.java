package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.prism.Graphics;

import Controller.TradeController;

@SuppressWarnings("serial")
public class TradeAcceptPane extends JPanel {
	
	private JLabel otherPlayer1;
	private JLabel otherPlayer2;
	private JLabel otherPlayer3;
	
	private JButton AcceptPlayer1;
	private JButton AcceptPlayer2;
	private JButton AcceptPlayer3;
	
	private TradeController tc;
	
	public TradeAcceptPane(TradeController tc,int playerid) {
		this.tc = tc;
		this.setLayout(null);
		otherPlayer1 =new JLabel();
		otherPlayer2 =new JLabel();
		otherPlayer3 =new JLabel();
		
		AcceptPlayer1 = new JButton();
		AcceptPlayer2 = new JButton();
		AcceptPlayer3 = new JButton();
		
		otherPlayer1.setBounds(100, 100, 50, 50);
		otherPlayer2.setBounds(100, 150, 50, 50);
		otherPlayer3.setBounds(100, 500, 50, 50);
		
		AcceptPlayer1.setBounds(150, 100, 50, 50);
		AcceptPlayer2.setBounds(150, 150, 50, 50);
		AcceptPlayer2.setBounds(150, 200, 50, 50);

		
		getOtherPlayerNames();
		
		add(AcceptPlayer1);
		add(AcceptPlayer2);
		add(AcceptPlayer3);
		
		add(otherPlayer1);
		add(otherPlayer2);
		add(otherPlayer3);
		setPreferredSize(new Dimension(800,600));
		setVisible(true);
		revalidate();
		repaint();
	}

	private void getOtherPlayerNames() {
		ArrayList<String> names =tc.getOtherNames();
		for(int i =0; i<names.size();i++) {
			if(i == 0) {
				otherPlayer1.setText(names.get(i));
			}
			else if(i == 1) {
				otherPlayer1.setText(names.get(i));
			}
			else if(i == 2) {
				otherPlayer1.setText(names.get(i));
			}
		}
	}
	
	public void paintComponent(Graphics g){
		
	}

}
