package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class DrawingPanel extends JPanel {

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

	private Color hexagonColor = Color.WHITE;
	
	
	private int firstRowX = 164;
	
	private Color color = Color.white;
	private Color lightBlue = new Color(0, 191, 255);
	private Color grey = Color.LIGHT_GRAY;
	private Color lightGreen = new Color(34 , 246, 84);
	private Color brown = new Color(153, 76 ,0);
	private Color green = Color.GREEN;
	private Color yellow = Color.YELLOW;
	private Color sandColor = new Color(255, 204, 153);
	
	private String [] types = {"Standaard", "Random", "Custom"};
	
	private ArrayList<Hexagon> hexagons;

	public DrawingPanel() {
		hexagons = new ArrayList<>();
		
		hexagon6 = new Hexagon(new Point(400, 164), 50);
		hexagon11 = new Hexagon(new Point(400, 250), 50);
		hexagon16 = new Hexagon(new Point(400, 336), 50);
		
		hexagon3 = new Hexagon(new Point(325, 121), 50);
		hexagon8 = new Hexagon(new Point(325, 207), 50);
		hexagon13 = new Hexagon(new Point(325, 293), 50);
		hexagon18 = new Hexagon(new Point(325, 379), 50);
		
		hexagon1 = new Hexagon(new Point(250, 78), 50);
		hexagon5 = new Hexagon(new Point(250, 164), 50);
		hexagon10 = new Hexagon(new Point(250, 250), 50);
		hexagon15 = new Hexagon(new Point(250, 336), 50);
		hexagon19 = new Hexagon(new Point(250, 422), 50);
		
		hexagon2 = new Hexagon(new Point(175, 121), 50);
		hexagon7 = new Hexagon(new Point(175, 207), 50);
		hexagon12 = new Hexagon(new Point(175, 293), 50);
		hexagon17 = new Hexagon(new Point(175, 379), 50);
		
		hexagon4 = new Hexagon(new Point(100, 164), 50);
		hexagon9 = new Hexagon(new Point(100, 250), 50);
		hexagon14 = new Hexagon(new Point(100, 336), 50);
		
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
		
		
		this.setPreferredSize(new Dimension(500, 500));
		setBackground(lightBlue);
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		int w2 = getWidth() / 2;
		int h2 = getHeight() / 2;
		g2d.rotate(-Math.PI / 2, w2, h2);
		g2d.setColor(hexagonColor);
		
		for(int i =0; i < hexagons.size(); i++) {
			g2d.drawPolygon(hexagons.get(i).getHexagon());
		}
		
		g2d.setColor(color);

	}
	
	public void makeNormalBord(Graphics2D g2d) {
		
	}
	
	public void getColor(char resourcetype) {
		if(resourcetype == 'B') {
			setColor(brown);
		}else if(resourcetype == 'E') {
			setColor(grey);
		}else if(resourcetype == 'H') {
			setColor(green);
		}else if(resourcetype == 'G') {
			setColor(yellow);
		}else if(resourcetype == 'W') {
			setColor(lightGreen);
		}else {
			setColor(sandColor);
		}
	}
}
