package View.setupGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Controller.BoardController;
import Model.board.ClickPoints;
import Model.board.Location;
import Model.board.Tile;
import View.board.BoardColours;
import View.board.Hexagon;
import View.board.Robber;

@SuppressWarnings("serial")
public class DrawingPanel extends JPanel {

	private ClickPoints clickpoints;

	private String hlPoint;

	private ArrayList<Location> keys;
	private ArrayList<Tile> keystiles;

	private Robber robber;
	private boolean mayBuild = false;
	private boolean mayMoveRobber = true;

	// making 19 rooms for hexagons
	private Hexagon hexagon1;
	private Hexagon hexagon2;
	private Hexagon hexagon3;
	private Hexagon hexagon4;
	private Hexagon hexagon5;
	private Hexagon hexagon6;
	private Hexagon hexagon7;
	private Hexagon hexagon8;
	private Hexagon hexagon9;
	private Hexagon hexagon10;
	private Hexagon hexagon11;
	private Hexagon hexagon12;
	private Hexagon hexagon13;
	private Hexagon hexagon14;
	private Hexagon hexagon15;
	private Hexagon hexagon16;
	private Hexagon hexagon17;
	private Hexagon hexagon18;
	private Hexagon hexagon19;
	// making room for an gameId
	private int idspel;
	// making room for a board controller
	private BoardController bc;
	// making room for an arraylist
	private ArrayList<Hexagon> hexagons;

	public DrawingPanel(BoardController bc, int idspel) {
		robber = new Robber();
		this.setLayout(null);
		robber = new Robber();
		this.idspel = idspel;
		this.bc = bc;
		// initialize arraylist
		hexagons = new ArrayList<>();
		// initialize hexagons with points
		hexagon6 = new Hexagon(new Point(200, 70), 50);
		hexagon11 = new Hexagon(new Point(300, 70), 50);
		hexagon16 = new Hexagon(new Point(400, 70), 50);

		hexagon3 = new Hexagon(new Point(150, 160), 50);
		hexagon8 = new Hexagon(new Point(250, 160), 50);
		hexagon13 = new Hexagon(new Point(350, 160), 50);
		hexagon18 = new Hexagon(new Point(450, 160), 50);

		hexagon1 = new Hexagon(new Point(100, 250), 50);
		hexagon5 = new Hexagon(new Point(200, 250), 50);
		hexagon10 = new Hexagon(new Point(300, 250), 50);
		hexagon15 = new Hexagon(new Point(400, 250), 50);
		hexagon19 = new Hexagon(new Point(500, 250), 50);

		hexagon2 = new Hexagon(new Point(150, 340), 50);
		hexagon7 = new Hexagon(new Point(250, 340), 50);
		hexagon12 = new Hexagon(new Point(350, 340), 50);
		hexagon17 = new Hexagon(new Point(450, 340), 50);

		hexagon4 = new Hexagon(new Point(200, 430), 50);
		hexagon9 = new Hexagon(new Point(300, 430), 50);
		hexagon14 = new Hexagon(new Point(400, 430), 50);
		// adding hexagons
		hexagons.add(hexagon1);
		hexagons.add(hexagon2);
		hexagons.add(hexagon3);
		hexagons.add(hexagon4);
		hexagons.add(hexagon5);
		hexagons.add(hexagon6);
		hexagons.add(hexagon7);
		hexagons.add(hexagon8);
		hexagons.add(hexagon9);
		hexagons.add(hexagon10);
		hexagons.add(hexagon11);
		hexagons.add(hexagon12);
		hexagons.add(hexagon13);
		hexagons.add(hexagon14);
		hexagons.add(hexagon15);
		hexagons.add(hexagon16);
		hexagons.add(hexagon17);
		hexagons.add(hexagon18);
		hexagons.add(hexagon19);
		robber.setBounds(bc.getRobberXPosition(idspel) - 45, bc.getRobberYPosition(idspel) - 30, 25, 60);
		this.add(robber);

		setPreferredSize(new Dimension(600, 600));

		// set background
		setBackground(BoardColours.SEA.getRGB());
		createKlikpunten();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (mayBuild == true) {
					String test = convertXYfromScreenToKey(e.getX(), e.getY());
					hlPoint = test;
					System.out.println(hlPoint);
					repaint();
				}
				if (mayMoveRobber == true) {
					String returnString = tileConvertXYfromScreenToKey(e.getX(), e.getY());
					// System.out.println(returnString);
					if (returnString != null) {
						String positions[] = returnString.split(",");
						int x = Integer.parseInt(positions[0]);
						int y = Integer.parseInt(positions[1]);
						bc.setRobberTile(idspel, x, y);
						robber.setBounds(bc.getRobberXPosition(idspel) - 45, bc.getRobberYPosition(idspel) - 30, 25,
								60);
						mayMoveRobber = false;
					}
				}
			}

		});
	}

	// drawing the hexagons
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		for (int i = 0; i < hexagons.size(); i++) {
			g2d.drawPolygon(hexagons.get(i).getHexagon());
			Color color = bc.getColour(i, idspel);
			g2d.setColor(color);
			g2d.fillPolygon(hexagons.get(i).getHexagon());

		}
		g2d.setColor(BoardColours.CHITS.getRGB());
		for (int i = 0; i < hexagons.size(); i++) {
			ImageIcon img = bc.getImage(i, idspel);
			img.paintIcon(this, g, hexagons.get(i).getCenter().x - 15, hexagons.get(i).getCenter().y - 15);
			drawPoints(g);
			updateHighlight(g);
		}
	}

	private void createKlikpunten()

	{

		clickpoints = new ClickPoints();
		keys = bc.getLocatieKeys();
		keystiles = bc.getLocationTileKeys();

		for (int i = 0; i < 54; i++)

		{
			String key = "" + keys.get(i).getX() + "," + keys.get(i).getY();
			clickpoints.addPoint(convertXfromKeyToScreenX(i), convertYfromKeyToScreenY(i), key, i);

		}
		for (int x = 0; x < 19; x++) {
			String keytile = "" + keystiles.get(x).getX() + "," + keystiles.get(x).getY();
			clickpoints.addTilePoint(tileConvertXfromKeyToScreenX(x), tileConvertYfromKeyToScreenY(x), keytile, x);
		}

	}

	private int tileConvertYfromKeyToScreenY(int x) {

		int keyX = keystiles.get(x).getX();
		int keyY = keystiles.get(x).getY();

		return 10 + (((2 * (12 - keyY)) - (10 - keyX)) * 30);

	}

	private int tileConvertXfromKeyToScreenX(int x) {

		int keyX = keystiles.get(x).getX();

		return 50 + ((keyX - 1) * (99 / 2)) + keyX - 2;

	}

	private int convertXfromKeyToScreenX(int i)

	{

		int keyX = keys.get(i).getX();

		return 50 + ((keyX - 1) * (99 / 2)) + keyX - 2;

	}

	private int convertYfromKeyToScreenY(int i)

	{

		int keyX = keys.get(i).getX();
		int keyY = keys.get(i).getY();

		return 10 + (((2 * (12 - keyY)) - (10 - keyX)) * 30);

	}

	private String convertXYfromScreenToKey(int x, int y)

	{

		return clickpoints.getKey(x, y);

	}

	private String tileConvertXYfromScreenToKey(int x, int y) {
		return clickpoints.getKeyTiles(x, y);
	}

	private void drawPoints(Graphics g) {
		Set<Point> points = clickpoints.getPoints();
		for (Point p : points) {
			g.fillOval(p.x - 5, p.y - 5, 10, 10);
		}
	}

	private void updateHighlight(Graphics g) {
		if (hlPoint != null) {
			Point lookup = clickpoints.getSelectedPoint();
			g.setColor(Color.WHITE);
			g.fillOval(lookup.x - 5, lookup.y - 5, 10, 10);
			g.setColor(BoardColours.CHITS.getRGB());
		}
	}

	public void setBuild(boolean mayBuild) {
		this.mayBuild = mayBuild;
	}

}
