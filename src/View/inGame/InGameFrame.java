package View.inGame;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controller.BoardController;
import Controller.ChatController;
import Controller.DieController;
import Controller.IngameController;
import Controller.PlayerController;
import View.setupGame.DrawingPanel;

@SuppressWarnings("serial")
public class InGameFrame extends JFrame{
// making intance variables
	private IngameView pane;
	private BoardController bc;
	
	public InGameFrame(BoardController bc, int gameID,DrawingPanel inGameBoard, int playerID, IngameController inGameController, PlayerController pc, ChatController chatController, DieController dieController) {
//initialize contentpane 
		pane = new IngameView(bc, gameID,inGameBoard, playerID, inGameController, pc, chatController, dieController);
		this.bc = bc;
// create the frame		
		setTitle("Catan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		createMenuBar();
		setContentPane(pane);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public void createMenuBar() {

		JMenuBar lobbyMenuBar = new JMenuBar();
		JMenu lobbyMenu = new JMenu("Spel Opties");
		JMenuItem logOut = new JMenuItem("Lobby");

		lobbyMenuBar.add(lobbyMenu);
		lobbyMenu.add(logOut);

		logOut.addActionListener(e -> {
		dispose();
		bc.openLobby();
		});

		setJMenuBar(lobbyMenuBar);
	}

	public void update() {
		pane.update();
	}

	public void nextTurnButtonUpdate() {
		pane.nextTurnButtonUpdate();
	}
}
