package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import Controller.BoardController;
import Controller.LobbyController;

@SuppressWarnings("serial")
public class SetupChangePanel extends JPanel implements ActionListener {

	private LobbyController lc;
	private BoardController bc;

	private final int WIDTH = 200;
	private final int HEIGHT = 500;

	private String[] types = { "Standaard", "Random" };
	@SuppressWarnings("rawtypes")
	private JComboBox boardTypes;

	private JButton returnButton;
	private JButton InviteButton;

	private SetupGamePane sp;

	private int idspel;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SetupChangePanel(LobbyController lc, BoardController bc, JButton inviteButton, int idspel,
			SetupGamePane setupGamePane) {
		this.sp = setupGamePane;
		this.lc = lc;
		this.idspel = idspel;
		this.bc = bc;
		this.InviteButton = inviteButton;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());

		InviteButton.setBackground(Color.YELLOW);

		returnButton = new JButton("Return");

		boardTypes = new JComboBox(types);

		add(boardTypes, BorderLayout.NORTH);
		add(returnButton, BorderLayout.SOUTH);
		add(InviteButton, BorderLayout.SOUTH);

		boardTypes.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String input = (String) boardTypes.getSelectedItem();
		if (input == "Standaard") {
			bc.removeResource(lc.getGameID());
			bc.setBoardType(lc.getGameID(), 1);
			bc.finishBoard(idspel);
			sp.remake();
		} else if (input == "Random") {
			bc.removeResource(lc.getGameID());
			bc.setBoardType(lc.getGameID(), 2);
			bc.finishBoard(idspel);
			sp.remake();
		}

	}
}
