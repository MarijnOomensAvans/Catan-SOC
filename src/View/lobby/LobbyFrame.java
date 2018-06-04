package View.lobby;

import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controller.BoardController;
import Controller.ChatController;
import Controller.LobbyController;
import View.chat.Chatoutputgui;

@SuppressWarnings("serial")
public class LobbyFrame extends JFrame {
	private LobbyContentPane pane;
	private LobbyController controller;

	private JMenuBar lobbyMenuBar;
	private JMenu lobbyMenu;
	private JMenuItem logOut;

	public LobbyFrame(LobbyController controller, BoardController bc, ChatController cc, Chatoutputgui cog, int i) {
		this.controller = controller;
		pane = new LobbyContentPane(controller, bc, cc, 1, cog);
		setTitle("Lobby");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		makeMenuBar();
		setContentPane(pane);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void makeMenuBar() {

		lobbyMenuBar = new JMenuBar();
		lobbyMenu = new JMenu("Account");
		logOut = new JMenuItem("Uitloggen");

		lobbyMenuBar.add(lobbyMenu);
		lobbyMenu.add(logOut);

		logOut.addActionListener(e -> {
			dispose();
			controller.startLogin();
		});

		setJMenuBar(lobbyMenuBar);

	}

	public LobbyPanel getPanel() {
		return pane.getPanel();
	}

}