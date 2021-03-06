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
import Controller.IngameController;
import Controller.PlayerController;
import Controller.RobberController;
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
	private boolean mayMoveRobber = false;
	private boolean devCardBuild = false;
	private String buildingType;
	private int buildCounter;

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
	private PlayerController pc;
	private IngameController inGameController;
	@SuppressWarnings("unused")
	private Graphics2D g2d;
	private Graphics g;

	private boolean setup;

	// All images of player pieces
	// Cities
	ImageIcon city_Blue = new ImageIcon(ClassLoader.getSystemResource("city_Blue.png"));
	ImageIcon city_Orange = new ImageIcon(ClassLoader.getSystemResource("city_Orange.png"));
	ImageIcon city_Red = new ImageIcon(ClassLoader.getSystemResource("city_Red.png"));
	ImageIcon city_White = new ImageIcon(ClassLoader.getSystemResource("city_White.png"));

	// Villages
	ImageIcon village_Blue = new ImageIcon(ClassLoader.getSystemResource("village_Blue.png"));
	ImageIcon village_Orange = new ImageIcon(ClassLoader.getSystemResource("village_Orange.png"));
	ImageIcon village_Red = new ImageIcon(ClassLoader.getSystemResource("village_Red.png"));
	ImageIcon village_White = new ImageIcon(ClassLoader.getSystemResource("village_White.png"));

	// Streets
	ImageIcon street_Blue = new ImageIcon(ClassLoader.getSystemResource("street_Blue.png"));
	ImageIcon street_Orange = new ImageIcon(ClassLoader.getSystemResource("street_Orange.png"));
	ImageIcon street_Red = new ImageIcon(ClassLoader.getSystemResource("street_Red.png"));
	ImageIcon street_White = new ImageIcon(ClassLoader.getSystemResource("street_White.png"));

	boolean paint = true;

	public DrawingPanel(BoardController bc, int gameID, RobberController rb) {
		this.setup = false;
		robber = new Robber();
		this.setLayout(null);
		robber = new Robber();
		this.idspel = gameID;
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
		robber.setBounds(bc.getRobberXPosition(gameID) - 45, bc.getRobberYPosition(gameID) - 30, 25, 60);
		this.add(robber);

		setPreferredSize(new Dimension(600, 600));

		// set background
		setBackground(BoardColours.SEA.getRGB());
		createKlikpunten();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				/*
				 * if (inGameController != null) { inGameController.shouldRefresh(gameID); }
				 * DISABLED, NOW PLACED TO BOTTOM
				 */

				if (mayBuild == true && !buildingType.equals("DevCard")) {
					String test = convertXYfromScreenToKey(e.getX(), e.getY());
					if (test != null) {
						if (hlPoint == test && !buildingType.equals("Street")) {
							if (buildingType.equals("Village")) {
								if (pc.emptySpace(buildingType, hlPoint)) {
									if (pc.buildObject(buildingType, hlPoint)) {
										removeMaterialCards(buildingType);
									}
									// Log here
									mayBuild = false;
									hlPoint = null;
									repaint();
								}
							} else {
								// If building type is City it will go here
								if (pc.emptySpaceCity(buildingType, hlPoint)) {
									if (pc.buildObject(buildingType, hlPoint)) {
										removeMaterialCards(buildingType);
									}
									// Log here
									mayBuild = false;
									hlPoint = null;
									repaint();
								}
							}
						} else if (hlPoint == null || !buildingType.equals("Street")) {
							// Log here
							hlPoint = test;
							repaint();
						}
						if (test != hlPoint && buildingType.equals("Street")) {
							if (pc.emptySpace(buildingType, hlPoint)) {
								String[] hlarray = hlPoint.split(",");
								String[] clarray = test.split(",");
								int x1 = Integer.parseInt(hlarray[0]);
								int y1 = Integer.parseInt(hlarray[1]);
								int x2 = Integer.parseInt(clarray[0]);
								int y2 = Integer.parseInt(clarray[1]);
								if (x1 == (x2 + 1) && y1 == (y2 + 1) || x1 == (x2 + 1) && y1 == y2
										|| x1 == x2 && y1 == (y2 - 1) || x1 == (x2 - 1) && y1 == y2
										|| x1 == x2 && y1 == (y2 + 1) || x1 == (x2 - 1) && y1 == (y2 - 1)) {
									if (pc.checkVillage(test, hlPoint)) {
										if (pc.buildStreet(x1, x2, y1, y2)) {
											removeMaterialCards(buildingType);
										}
										// Log here
										if (devCardBuild == false) {
											mayBuild = false;
										} else {
											devCardBuild = false;
										}
										hlPoint = null;
										repaint();
									} else {
										// Log here
										mayBuild = false;
										hlPoint = null;
										repaint();
									}
								} else {
									// Log here
									mayBuild = false;
									hlPoint = null;
									repaint();
								}
							}
						}
					} else {
						// Log here
						mayBuild = false;
						hlPoint = null;
						repaint();
					}
				} else if (mayBuild == true && buildingType.equals("DevCard")) {
					removeMaterialCards(buildingType);
					mayBuild = false;
				}
				if (mayMoveRobber == true) {
					inGameController.disableBuildButton(false);
					inGameController.setHasMovedRobber(false);
					String returnString = tileConvertXYfromScreenToKey(e.getX(), e.getY());
					if (returnString != null) {
						String positions[] = returnString.split(",");
						int x = Integer.parseInt(positions[0]);
						int y = Integer.parseInt(positions[1]);
						if (!inGameController.robberHasPosition(x, y, gameID)) {
							bc.setRobberTile(gameID, x, y);
							robber.setBounds(bc.getRobberXPosition(gameID) - 45, bc.getRobberYPosition(gameID) - 30, 25,
									60);
							rb.choose(gameID, x, y);
							inGameController.disableBuildButton(true);
							mayMoveRobber = false;
						}
					}
				}
				if (inGameController != null) {
					inGameController.shouldRefresh(gameID);
				}
			}
		});
	}

	// drawing the hexagons
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		this.g2d = g2d;
		this.g = g;
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
			if (paint) {
				// paintBuildings(g);
				paint = false;
			}
		}
		if (setup == true) {
			paintBuildings();
		}
		robber.setBounds(bc.getRobberXPosition(idspel) - 45, bc.getRobberYPosition(idspel) - 30, 25, 60);

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

	public void setBuild(boolean mayBuild, String buildingType) {
		this.mayBuild = mayBuild;
		this.buildingType = buildingType;
	}

	public void setPlayerController(PlayerController pc) {
		this.pc = pc;
	}

	public void setMayMoveRobber(boolean b) {
		mayMoveRobber = b;
	}

	public void paintBuildings() {
		buildCounter = 0;
		if (pc.getAllBuildings() != null) {
			String[] buildings = pc.getAllBuildings().split(",");
			for (int x = 0; x < 4; x++) {
				for (int y = 0; y < pc.getBuildCount(x); y++) {
					if (buildings.length > buildCounter) {
						if (!buildings[buildCounter].equals("") || buildings[buildCounter] != null) {
							String[] buildSplit = buildings[buildCounter].split("");
							int xCoord1 = pc.getCoordX(buildings[buildCounter], x);
							int xCoord2 = pc.getCoordXStreet(buildings[buildCounter], x);
							int yCoord1 = pc.getCoordY(buildings[buildCounter], x);
							int yCoord2 = pc.getCoordYStreet(buildings[buildCounter], x);
							int xCoord = (((buildingConvertXfromKeyToScreenX(xCoord1))
									+ (buildingConvertXfromKeyToScreenX(xCoord2))) / 2);
							int yCoord = (buildingConvertYfromKeyToScreenY(((xCoord1 + xCoord2) / 2), yCoord1)
									+ buildingConvertYfromKeyToScreenY(((xCoord1 + xCoord2) / 2), yCoord2)) / 2;
							switch (buildSplit[0]) {
							case "d":
								switch (x) {
								case 0:
									village_Red.paintIcon(this, g, buildingConvertXfromKeyToScreenX(xCoord1) - 17,
											buildingConvertYfromKeyToScreenY(xCoord1, yCoord1) - 20);
									buildCounter++;
									break;
								case 1:
									village_White.paintIcon(this, g, buildingConvertXfromKeyToScreenX(xCoord1) - 17,
											buildingConvertYfromKeyToScreenY(xCoord1, yCoord1) - 20);
									buildCounter++;
									break;
								case 2:
									village_Blue.paintIcon(this, g, buildingConvertXfromKeyToScreenX(xCoord1) - 17,
											buildingConvertYfromKeyToScreenY(xCoord1, yCoord1) - 20);
									buildCounter++;
									break;
								case 3:
									village_Orange.paintIcon(this, g, buildingConvertXfromKeyToScreenX(xCoord1) - 17,
											buildingConvertYfromKeyToScreenY(xCoord1, yCoord1) - 20);
									buildCounter++;
									break;
								}
								break;
							case "r":
								switch (x) {
								case 0:
									street_Red.paintIcon(this, g, xCoord - 17, yCoord - 5);
									buildCounter++;
									break;
								case 1:
									street_White.paintIcon(this, g, xCoord - 17, yCoord - 5);
									buildCounter++;
									break;
								case 2:
									street_Blue.paintIcon(this, g, xCoord - 17, yCoord - 5);
									buildCounter++;
									break;
								case 3:
									street_Orange.paintIcon(this, g, xCoord - 17, yCoord - 5);
									buildCounter++;
									break;
								}
								break;
							case "c":
								switch (x) {
								case 0:
									city_Red.paintIcon(this, g, buildingConvertXfromKeyToScreenX(xCoord1) - 17,
											buildingConvertYfromKeyToScreenY(xCoord1, yCoord1) - 20);
									buildCounter++;
									break;
								case 1:
									city_White.paintIcon(this, g, buildingConvertXfromKeyToScreenX(xCoord1) - 17,
											buildingConvertYfromKeyToScreenY(xCoord1, yCoord1) - 20);
									buildCounter++;
									break;
								case 2:
									city_Blue.paintIcon(this, g, buildingConvertXfromKeyToScreenX(xCoord1) - 17,
											buildingConvertYfromKeyToScreenY(xCoord1, yCoord1) - 20);
									buildCounter++;
									break;
								case 3:
									city_Orange.paintIcon(this, g, buildingConvertXfromKeyToScreenX(xCoord1) - 17,
											buildingConvertYfromKeyToScreenY(xCoord1, yCoord1) - 20);
									buildCounter++;
									break;
								}
								break;
							}
						}
					}
				}
			}
		}
	}

	private int buildingConvertXfromKeyToScreenX(int x)

	{

		return 50 + ((x - 1) * (99 / 2)) + x - 2;

	}

	private int buildingConvertYfromKeyToScreenY(int x, int y)

	{

		return 10 + (((2 * (12 - y)) - (10 - x)) * 30);

	}

	public void setBuildDev(boolean b, String string) {
		this.mayBuild = b;
		this.buildingType = string;
		this.devCardBuild = true;
	}

	public void setIngameController(IngameController ingameController) {
		this.inGameController = ingameController;
	}

	public void removeMaterialCards(String buildingType) {
		if (pc.getRound()) {
			switch (buildingType) {
			case "Village":
				pc.getPlayer().removeMatCard("H");
				pc.getPlayer().removeMatCard("W");
				pc.getPlayer().removeMatCard("B");
				pc.getPlayer().removeMatCard("G");
				break;
			case "City":
				pc.getPlayer().removeMatCard("E");
				pc.getPlayer().removeMatCard("E");
				pc.getPlayer().removeMatCard("E");
				pc.getPlayer().removeMatCard("G");
				pc.getPlayer().removeMatCard("G");
				break;
			case "Street":
				pc.getPlayer().removeMatCard("H");
				pc.getPlayer().removeMatCard("B");
				break;
			case "DevCard":
				pc.getPlayer().removeMatCard("E");
				pc.getPlayer().removeMatCard("W");
				pc.getPlayer().removeMatCard("G");
				break;
			}
		}
	}

	public void setSetUp(boolean b) {
		setup = b;

	}

	public void setSetup(boolean b) {
		this.setup = b;

	}

}
