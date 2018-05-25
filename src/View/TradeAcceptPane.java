package View;


import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import Controller.TradeController;

@SuppressWarnings("serial")
public class TradeAcceptPane extends JPanel {
	
	private JLabel otherPlayer1;
	private JLabel otherPlayer2;
	private JLabel otherPlayer3;
	
	private JButton AcceptPlayer1;
	private JButton AcceptPlayer2;
	private JButton AcceptPlayer3;
	
	private JTextField response1;
	private JTextField response2;
	private JTextField response3;
	
	private TradeController tc;
	
	public TradeAcceptPane(TradeController tc,int playerid) {
		this.tc = tc;
		this.setLayout(null);
		otherPlayer1 =new JLabel();
		otherPlayer2 =new JLabel();
		otherPlayer3 =new JLabel();
		
		AcceptPlayer1 = new JButton("Acepteren");
		AcceptPlayer2 = new JButton("Acepteren");
		AcceptPlayer3 = new JButton("Acepteren");
		
		response1 = new JTextField();
		response2 = new JTextField();
		response3 = new JTextField();
		
		otherPlayer1.setBounds(100, 100, 50, 50);
		otherPlayer2.setBounds(100, 175, 50, 50);
		otherPlayer3.setBounds(100, 250, 50, 50);
		
		AcceptPlayer1.setBounds(150, 112, 100, 30);
		AcceptPlayer2.setBounds(150, 187, 100, 30);
		AcceptPlayer3.setBounds(150, 262, 100, 30);
		
		response1.setBounds(270, 112,50,30);
		response2.setBounds(270, 187,50,30);
		response3.setBounds(270, 262,50,30);
		
		AcceptPlayer1.setEnabled(false);
		AcceptPlayer2.setEnabled(false);
		AcceptPlayer3.setEnabled(false);
		
		getOtherPlayerNames();
		
		add(AcceptPlayer1);
		add(AcceptPlayer2);
		add(AcceptPlayer3);
		
		add(otherPlayer1);
		add(otherPlayer2);
		add(otherPlayer3);
		
		add(response1);
		add(response2);
		add(response3);
		
		setPreferredSize(new Dimension(800,600));
		setVisible(true);
		revalidate();
		repaint();
		getResponses();
	}

	private void getOtherPlayerNames() {
		ArrayList<String> names =tc.getOtherNames();
		for(int i =0; i<names.size();i++) {
			if(i == 0) {
				otherPlayer1.setText(names.get(i));
			}
			else if(i == 1) {
				otherPlayer2.setText(names.get(i));
			}
			else if(i == 2) {
				otherPlayer3.setText(names.get(i));
			}
		}
	}
	
	public void getResponses() {
		ArrayList<Boolean> responses=tc.getResponses();
		for(int i=0; i<responses.size();i++) {
			if(i == 0) {
				if(responses.get(i)== true) {
					response1.setBackground(Color.GREEN);
					AcceptPlayer1.setEnabled(true);
				}
				else if(responses.get(i)== null){
					AcceptPlayer1.setEnabled(true);
					response1.setBackground(Color.RED);
				}else {
					response1.setBackground(Color.RED);
				}
			}
			else if(i == 1) {
				if(responses.get(i)== true) {
					response2.setBackground(Color.GREEN);
					AcceptPlayer2.setEnabled(true);

				}
				else if(responses.get(i)== null){
					AcceptPlayer2.setEnabled(true);
					response3.setBackground(Color.RED);
				}else {
					response3.setBackground(Color.RED);
				}
				
			}
			else if(i == 2) {
				if(responses.get(i)== true) {
					response3.setBackground(Color.GREEN);
					AcceptPlayer3.setEnabled(true);

				}
				else if(responses.get(i)== null){
					AcceptPlayer3.setEnabled(true);
					response3.setBackground(Color.RED);
				}else {
					response3.setBackground(Color.RED);
				}
			}
		}
	}

}
