package View;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.lang.Integer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


import Controller.TradeController;

@SuppressWarnings("serial")
public class TradeAcceptPane extends JPanel {
	
	private JLabel otherPlayer1;
	private JLabel otherPlayer2;
	private JLabel otherPlayer3;
	
	private int otherplayerid1;
	private int otherplayerid2;
	private int otherplayerid3;

	
	private ArrayList<Integer> player1counterbid;
	private ArrayList<Integer> player2counterbid;
	private ArrayList<Integer> player3counterbid;
	
	String[] columnames ={" ","Baksteen","Wol" ,"Erts", "Graan" ,"Hout"	};
	Object[][] data1 {"Vraagt", new Integer(5);
		
	};
	//private JTable table;
	
	private JButton AcceptPlayer1;
	private JButton AcceptPlayer2;
	private JButton AcceptPlayer3;
	
	private JTextField response1;
	private JTextField response2;
	private JTextField response3;
	
	private TradeController tc;
	
	public TradeAcceptPane(TradeController tc,int playerid, int gameid) {
		this.tc = tc;
		this.setLayout(null);
		otherPlayer1 =new JLabel();
		otherPlayer2 =new JLabel();
		otherPlayer3 =new JLabel();
		
		
		player1counterbid = new ArrayList<Integer>();
		player2counterbid = new ArrayList<Integer>();
		player3counterbid = new ArrayList<Integer>();
		
		///table = new JTable(columnames);
		
				
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
		
		response1.setEditable(false);
		response2.setEditable(false);
		response3.setEditable(false);
		
		getOtherPlayerid(gameid, playerid);
		getOtherPlayerNames();
		getResponses(otherplayerid1);
		getResponses(otherplayerid2);
		getResponses(otherplayerid3);
		
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
		
	}

	private void getOtherPlayerid(int gameid , int playerid) {
		ArrayList<Integer> ids =tc.getOtherid(gameid,playerid);
		otherplayerid1 =ids.get(0);
		otherplayerid2 =ids.get(1);
		otherplayerid3 =ids.get(2);
		
	}

	private void getOtherPlayerNames() {
		otherPlayer1.setText(tc.getOtherNames(otherplayerid1));
		otherPlayer2.setText(tc.getOtherNames(otherplayerid2));
		otherPlayer3.setText(tc.getOtherNames(otherplayerid3));
		
	}
	
	public void getResponses(int playerid) {
		boolean response=tc.getResponses(playerid);
			if(playerid == otherplayerid1) {
				if(response== true) {
					response1.setBackground(Color.GREEN);
					AcceptPlayer1.setEnabled(true);
				}
				else if(response == false){
					response1.setBackground(Color.RED);
				}else {
					AcceptPlayer1.setEnabled(true);
					response1.setBackground(Color.RED);
				}
			}
			else if(playerid == otherplayerid2) {
				if(response== true) {
					response2.setBackground(Color.GREEN);
					AcceptPlayer2.setEnabled(true);
				}
				else if(response == false){
					response2.setBackground(Color.RED);
				}else {
					AcceptPlayer2.setEnabled(true);
					response2.setBackground(Color.RED);
				}
			}
			else if(playerid == otherplayerid3) {
				if(response== true) {
					response3.setBackground(Color.GREEN);
					AcceptPlayer3.setEnabled(true);
				}
				else if(response == false){
					response3.setBackground(Color.RED);
				}else {
					AcceptPlayer3.setEnabled(true);
					response3.setBackground(Color.RED);
				}
			}
		}
	
	public void getTradeResponses(int playerid) {
		if(playerid == otherplayerid1) {
			player1counterbid =tc.getTradeResponses(playerid);
			
		}
		else if(playerid == otherplayerid2) {
			player2counterbid =tc.getTradeResponses(playerid);
		}
		else if(playerid == otherplayerid3) {
			player3counterbid =tc.getTradeResponses(playerid);
		}
	}
	}
	

