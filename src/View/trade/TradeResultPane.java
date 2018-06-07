package View.trade;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.lang.Integer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


import Controller.TradeController;

@SuppressWarnings("serial")
public class TradeResultPane extends JPanel {
	
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
		
	private JTable table1;
	private JTable table2;
	private JTable table3;
	
	private JButton AcceptPlayer1;
	private JButton AcceptPlayer2;
	private JButton AcceptPlayer3;
	private JButton rejectEverything;
	
	private JTextField response1;
	private JTextField response2;
	private JTextField response3;
	
	private TradeController tc;
	
	public TradeResultPane(TradeController tc,int playerid, int gameid) {
		this.tc = tc;
		this.setLayout(null);
		otherPlayer1 =new JLabel();
		otherPlayer2 =new JLabel();
		otherPlayer3 =new JLabel();
		
		player1counterbid = new ArrayList<Integer>();
		player2counterbid = new ArrayList<Integer>();
		player3counterbid = new ArrayList<Integer>();
		getOtherPlayerid(gameid, playerid);
		getOtherPlayerNames();
		getTradeResponses(otherplayerid1);
		getTradeResponses(otherplayerid2);
		getTradeResponses(otherplayerid3);
				
		AcceptPlayer1 = new JButton("Accepteren");
		AcceptPlayer2 = new JButton("Accepteren");
		AcceptPlayer3 = new JButton("Accepteren");
		rejectEverything = new JButton("Alles weigeren");
		
		otherPlayer1.setBounds(100, 100, 50, 50);
		otherPlayer2.setBounds(100, 175, 50, 50);
		otherPlayer3.setBounds(100, 250, 50, 50);
		
		AcceptPlayer1.setBounds(150, 112, 100, 30);
		AcceptPlayer2.setBounds(150, 187, 100, 30);
		AcceptPlayer3.setBounds(150, 262, 100, 30);
		rejectEverything.setBounds(100,350,150,30);
		
		AcceptPlayer1.setEnabled(false);
		AcceptPlayer2.setEnabled(false);
		AcceptPlayer3.setEnabled(false);
		
		AcceptPlayer1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					tc.tradeCards(otherplayerid1);
					tc.close();
			}
			
		});
		AcceptPlayer2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tc.tradeCards(otherplayerid2);
				tc.close();
				
			}
			
		});
		AcceptPlayer3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tc.tradeCards(otherplayerid3);
				tc.close();
				
			}
			
		});
		rejectEverything.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tc.deleteOffers(playerid, otherplayerid1,otherplayerid2,otherplayerid3);
				tc.close();
				
			}
			
		});
		
		
		add(AcceptPlayer1);
		add(AcceptPlayer2);
		add(AcceptPlayer3);
		add(rejectEverything);
		
		add(otherPlayer1);
		add(otherPlayer2);
		add(otherPlayer3);
		
		setPreferredSize(new Dimension(800,600));
		setVisible(true);
		revalidate();
		repaint();
	}
	
	public void setResponse1()
	{
		getTradeResponses(otherplayerid1);
		Object[][] responseData1 ={{" ","Baksteen","Wol" ,"Erts", "Graan" ,"Hout"},
				{"Geeft", new Integer(player1counterbid.get(1)),new Integer(player1counterbid.get(2)),
			new Integer(player1counterbid.get(3)),new Integer(player1counterbid.get(4)),new Integer(player1counterbid.get(5)),
		},
		{"Vraagt",new Integer(player1counterbid.get(6)),new Integer(player1counterbid.get(7)),new Integer(player1counterbid.get(8)),
		new Integer(player1counterbid.get(9)),new Integer(player1counterbid.get(10)),}};
		table1 = new JTable(responseData1,columnames);
		table1.setBounds(350,110,450,50);
		table1.setEnabled(false);
		add(table1);
		
		response1 = new JTextField();
		response1.setBounds(270, 112,50,30);
		response1.setEditable(false);
		getResponses(otherplayerid1);
		add(response1);
		this.repaint();
	}
	
	public void setResponse2()
	{
		getTradeResponses(otherplayerid2);
		Object[][] responseData2 ={{" ","Baksteen","Wol" ,"Erts", "Graan" ,"Hout"},
				{"Geeft", new Integer(player2counterbid.get(1)),new Integer(player2counterbid.get(2)),
			new Integer(player2counterbid.get(3)),new Integer(player2counterbid.get(4)),new Integer(player2counterbid.get(5)),
		},
		{"Vraagt",new Integer(player2counterbid.get(6)),new Integer(player2counterbid.get(7)),new Integer(player2counterbid.get(8)),
		new Integer(player2counterbid.get(9)),new Integer(player2counterbid.get(10)),}};
		table2 = new JTable(responseData2,columnames);
		table2.setBounds(350,180,450,50);
		table2.setEnabled(false);
		add(table2);
		
		response2 = new JTextField();
		response2.setBounds(270, 187,50,30);
		response2.setEditable(false);
		getResponses(otherplayerid2);
		add(response2);
		this.repaint();
	}
	
	public void setResponse3()
	{
		getTradeResponses(otherplayerid3);
		Object[][] responseData3 ={{" ","Baksteen","Wol" ,"Erts", "Graan" ,"Hout"},
				{"Geeft", new Integer(player3counterbid.get(1)),new Integer(player3counterbid.get(2)),
			new Integer(player3counterbid.get(3)),new Integer(player3counterbid.get(4)),new Integer(player3counterbid.get(5)),
		},
		{"Vraagt",new Integer(player3counterbid.get(6)),new Integer(player3counterbid.get(7)),new Integer(player3counterbid.get(8)),
		new Integer(player3counterbid.get(9)),new Integer(player3counterbid.get(10)),}};
		table3 = new JTable(responseData3,columnames);
		table3.setBounds(350,250,450,50);
		table3.setEnabled(false);
		add(table3);
		
		response3 = new JTextField();
		response3.setBounds(270, 262,50,30);
		response3.setEditable(false);
		getResponses(otherplayerid3);
		add(response3);
		this.repaint();
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
					if(tc.hasCards(player1counterbid) == true) {
					response1.setBackground(Color.GREEN);
					AcceptPlayer1.setEnabled(true);
					}
				}
				else if(response == false){
					response1.setBackground(Color.RED);
				}else {
					response1.setBackground(Color.RED);
				}
			}
			else if(playerid == otherplayerid2) {
				if(response== true) {
					if(tc.hasCards(player2counterbid) == true) {
					response2.setBackground(Color.GREEN);
					AcceptPlayer2.setEnabled(true);
				}
				}
				else if(response == false){
					response2.setBackground(Color.RED);
				}else {
					response2.setBackground(Color.RED);
				}
			}
			else if(playerid == otherplayerid3) {
				if(response== true) {
					if(tc.hasCards(player3counterbid) == true) {
					response3.setBackground(Color.GREEN);
					AcceptPlayer3.setEnabled(true);
				}
				}
				else if(response == false){
					response3.setBackground(Color.RED);
				}else {
					response3.setBackground(Color.RED);
				}
			}
		}
	
	public void getTradeResponses(int playerid) {
		if(playerid == otherplayerid1) {
			if(tc.getTradeResponses(playerid).size()!= 0) {
			player1counterbid =tc.getTradeResponses(playerid);
			}else {
				for(int i =0; i<=9; i++) {
				player1counterbid.add(0);
				}
			}
		}
		else if(playerid == otherplayerid2) {
			if(tc.getTradeResponses(playerid).size()!= 0) {
			player2counterbid =tc.getTradeResponses(playerid);
			}else {
				for(int i =0; i<=9; i++) {
				player2counterbid.add(0);
				}
			}
		}
		else if(playerid == otherplayerid3) {
			if(tc.getTradeResponses(playerid).size()!= 0) {
				player3counterbid =tc.getTradeResponses(playerid);
				}else {
					for(int i =0; i<=9; i++) {
					player3counterbid.add(0);
					}
				}
		}
	}
	}
	

