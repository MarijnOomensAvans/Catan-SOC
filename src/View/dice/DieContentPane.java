package View.dice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.DieController;

public class DieContentPane extends JPanel implements ActionListener {
	private DieController con;
	private JButton throwDiceButton;
	private String myFile = null;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private String six;
	private BufferedImage myBufferedImage1 = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
	private BufferedImage myBufferedImage2 = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);

	public DieContentPane(DieController controller, JButton throwDiceButton) {
		this.throwDiceButton = throwDiceButton;
		initFiles();
		this.setLayout(null);
		this.setPreferredSize(new Dimension(400, 300));
		con = controller;
		throwDiceButton.addActionListener(this);
		throwDiceButton.setBounds(150, 75, 100, 100);

	}

	public void initFiles() {
		one = "one.png";
		two = "two.png";
		three = "three.png";
		four = "four.png";
		five = "five.png";
		six = "six.png";
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int i[] = con.rollDice();

		for (int itt = 1; itt < 3; itt++) {
			switch (i[itt - 1]) {
			case 1:
				setDie(one, itt);
				break;
			case 2:
				setDie(two, itt);
				break;
			case 3:
				setDie(three, itt);
				break;
			case 4:
				setDie(four, itt);
				break;
			case 5:
				setDie(five, itt);
				break;
			case 6:
				setDie(six, itt);
				break;
			}

		}
		throwDiceButton.setEnabled(true);
		con.throwDice();
		repaint();
	}

	public void setDie(String one2, int img) {
		myFile = one2;
		if (myFile != null) {
			try {
				if (img == 1) {
					myBufferedImage1 = ImageIO.read(ClassLoader.getSystemResourceAsStream(myFile));
				} else if (img == 2) {
					myBufferedImage2 = ImageIO.read(ClassLoader.getSystemResourceAsStream(myFile));
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		this.repaint();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(myBufferedImage1, 0, 0, 100, 100, null);
		g.drawImage(myBufferedImage2, 0, 100, 100, 100, null);
	}

	public void update() {
		
		int[] values = con.getCurrentValues();
		String[] fileName = new String[2];
		switch (values[0]) {
		case (1):
			setDie(one, 1);
			break;
		case (2):
			setDie(two, 1);
			break;
		case (3):
			setDie(three, 1);
			break;
		case (4):
			setDie(four, 1);
			break;
		case (5):
			setDie(five, 1);
			break;
		case (6):
			setDie(six, 1);
			break;
		}
		
		switch (values[1]) {
		case (1):
			setDie(one, 2);
			break;
		case (2):
			setDie(two, 2);
			break;
		case (3):
			setDie(three, 2);
			break;
		case (4):
			setDie(four, 2);
			break;
		case (5):
			setDie(five, 2);
			break;
		case (6):
			setDie(six, 2);
			break;
		}
	}
	
	public void enableButton() {
		throwDiceButton.setEnabled(true);
	}
}
