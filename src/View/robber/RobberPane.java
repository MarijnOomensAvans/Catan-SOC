package View.robber;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.BoardController;
import Controller.RobberController;
import DAL.RobberDAL;
import View.inGame.InGameFrame;

@SuppressWarnings("serial")
public class RobberPane extends JPanel {
	
	private RobberDAL rd;
	
	private JButton otherPlayer1;
	private JButton otherPlayer2;
	private JButton otherPlayer3;
	
	private int otherPlayerid1;
	private int otherPlayerid2;
	private int otherPlayerid3;
	
	public RobberPane(int gameID, RobberDAL rd, int playerID, RobberController robberController, int x, int y, BoardController bc) {
		this.rd = rd;
		this.setPreferredSize(new Dimension(300,100));
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ids = rd.getOtherPlayerid(gameID,playerID);
		
		int otherPlayer0Count = 0;
		int otherPlayer1Count = 0;
		int otherPlayer2Count = 0;
		
		for(int i=0; i< ids.size();i++) {
			if (bc.getBuildingplayer(x + 1, y, ids.get(i)) != 0) {
				
				if(i == 0 && otherPlayer0Count < 2) {
					otherPlayer1 = new JButton(rd.getOtherPlayerName(ids.get(i)));
					otherPlayerid1 = ids.get(i);
					otherPlayer0Count++;
				}else if(i ==1 && otherPlayer1Count < 2) {
					otherPlayer2 = new JButton(rd.getOtherPlayerName(ids.get(i)));
					otherPlayerid2 = ids.get(i);
					otherPlayer1Count++;
				}else if(i == 2 && otherPlayer2Count < 2) {
					otherPlayer3 = new JButton(rd.getOtherPlayerName(ids.get(i)));
					otherPlayerid3 = ids.get(i);
					otherPlayer2Count++;
			}
			}
			if (bc.getBuildingplayer(x + 1, y + 1, ids.get(i)) != 0) {
				
				if(i == 0 && otherPlayer0Count < 2) {
					otherPlayer1 = new JButton(rd.getOtherPlayerName(ids.get(i)));
					otherPlayerid1 = ids.get(i);
					otherPlayer0Count++;
				}else if(i ==1 && otherPlayer1Count < 2) {
					otherPlayer2 = new JButton(rd.getOtherPlayerName(ids.get(i)));
					otherPlayerid2 = ids.get(i);
					otherPlayer1Count++;
				}else if(i == 2 && otherPlayer2Count < 2) {
					otherPlayer3 = new JButton(rd.getOtherPlayerName(ids.get(i)));
					otherPlayerid3 = ids.get(i);
					otherPlayer2Count++;
			}
			}
			if (bc.getBuildingplayer(x, y + 1, ids.get(i)) != 0) {
				
				if(i == 0 && otherPlayer0Count < 2) {
					otherPlayer1 = new JButton(rd.getOtherPlayerName(ids.get(i)));
					otherPlayerid1 = ids.get(i);
					otherPlayer0Count++;
				}else if(i ==1 && otherPlayer1Count < 2) {
					otherPlayer2 = new JButton(rd.getOtherPlayerName(ids.get(i)));
					otherPlayerid2 = ids.get(i);
					otherPlayer1Count++;
				}else if(i == 2 && otherPlayer2Count < 2) {
					otherPlayer3 = new JButton(rd.getOtherPlayerName(ids.get(i)));
					otherPlayerid3 = ids.get(i);
					otherPlayer2Count++;
			}
			}
			if (bc.getBuildingplayer(x - 1, y, ids.get(i)) != 0) {
				
				if(i == 0 && otherPlayer0Count < 2) {
					otherPlayer1 = new JButton(rd.getOtherPlayerName(ids.get(i)));
					otherPlayerid1 = ids.get(i);
					otherPlayer0Count++;
				}else if(i ==1 && otherPlayer1Count < 2) {
					otherPlayer2 = new JButton(rd.getOtherPlayerName(ids.get(i)));
					otherPlayerid2 = ids.get(i);
					otherPlayer1Count++;
				}else if(i == 2 && otherPlayer2Count < 2) {
					otherPlayer3 = new JButton(rd.getOtherPlayerName(ids.get(i)));
					otherPlayerid3 = ids.get(i);
					otherPlayer2Count++;
			}
			}
			if (bc.getBuildingplayer(x - 1, y - 1, ids.get(i)) != 0) {
				
				if(i == 0 && otherPlayer0Count < 2) {
					otherPlayer1 = new JButton(rd.getOtherPlayerName(ids.get(i)));
					otherPlayerid1 = ids.get(i);
					otherPlayer0Count++;
				}else if(i ==1 && otherPlayer1Count < 2) {
					otherPlayer2 = new JButton(rd.getOtherPlayerName(ids.get(i)));
					otherPlayerid2 = ids.get(i);
					otherPlayer1Count++;
				}else if(i == 2 && otherPlayer2Count < 2) {
					otherPlayer3 = new JButton(rd.getOtherPlayerName(ids.get(i)));
					otherPlayerid3 = ids.get(i);
					otherPlayer2Count++;
			}
			}
			if (bc.getBuildingplayer(x, y - 1, ids.get(i)) != 0) {
				
				if(i == 0 && otherPlayer0Count < 2) {
					otherPlayer1 = new JButton(rd.getOtherPlayerName(ids.get(i)));
					otherPlayerid1 = ids.get(i);
					otherPlayer0Count++;
				}else if(i ==1 && otherPlayer1Count < 2) {
					otherPlayer2 = new JButton(rd.getOtherPlayerName(ids.get(i)));
					otherPlayerid2 = ids.get(i);
					otherPlayer1Count++;
				}else if(i == 2 && otherPlayer2Count < 2) {
					otherPlayer3 = new JButton(rd.getOtherPlayerName(ids.get(i)));
					otherPlayerid3 = ids.get(i);
					otherPlayer2Count++;
			}
			}
			
			}
		if(otherPlayer0Count > 0) {
		otherPlayer1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				rd.pickRandomCard(playerID, otherPlayerid1);
				robberController.getInGameController().setHasMovedRobber(true);
				System.out.println("HasMovedRobber set to " + robberController.getInGameController().hasMovedRobber());
				robberController.close();
			}
			
		});
		}
		if(otherPlayer1Count > 0) {
		otherPlayer2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				rd.pickRandomCard(playerID, otherPlayerid2);
				robberController.getInGameController().setHasMovedRobber(true);;
				System.out.println("HasMovedRobber set to " + robberController.getInGameController().hasMovedRobber());
				robberController.close();
			}
			
		});
		}
		if(otherPlayer2Count > 0) {
		otherPlayer3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				rd.pickRandomCard(playerID, otherPlayerid3);
				robberController.getInGameController().activateEndTurnButton();
				robberController.close();
			}
			
		});
		}
		
		if(otherPlayer0Count > 0) {
		add(otherPlayer1);
		}
		if(otherPlayer1Count > 0) {
		add(otherPlayer2);
		}
		if(otherPlayer2Count > 0) {
		add(otherPlayer3);
		}
	}

}
