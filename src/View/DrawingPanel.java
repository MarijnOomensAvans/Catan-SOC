package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

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
	private Color lightBlue = new Color(0, 191, 255);
	
	private int firstRowX = 164;
	
	private String [] types = {"Standaard", "Random", "Custom"};

	public DrawingPanel() {
	
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
		
		
		this.setPreferredSize(new Dimension(500, 500));
		this.addMouseMotionListener(new Hover());
		setBackground(lightBlue);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		int w2 = getWidth() / 2;
		int h2 = getHeight() / 2;
		g2d.rotate(-Math.PI / 2, w2, h2);
		g2d.setColor(hexagonColor);
		g2d.drawPolygon(hexagon1.getHexagon());
		g2d.fillPolygon(hexagon1.getHexagon());
		g2d.drawPolygon(hexagon2.getHexagon());
		g2d.drawPolygon(hexagon3.getHexagon());
		g2d.drawPolygon(hexagon4.getHexagon());
		g2d.drawPolygon(hexagon5.getHexagon());
		g2d.drawPolygon(hexagon6.getHexagon());
		g2d.drawPolygon(hexagon7.getHexagon());
		g2d.drawPolygon(hexagon8.getHexagon());
		g2d.drawPolygon(hexagon9.getHexagon());
		g2d.drawPolygon(hexagon10.getHexagon());
		g2d.drawPolygon(hexagon11.getHexagon());
		g2d.drawPolygon(hexagon12.getHexagon());
		g2d.drawPolygon(hexagon13.getHexagon());
		g2d.drawPolygon(hexagon14.getHexagon());
		g2d.drawPolygon(hexagon15.getHexagon());
		g2d.drawPolygon(hexagon16.getHexagon());
		g2d.drawPolygon(hexagon17.getHexagon());
		g2d.drawPolygon(hexagon18.getHexagon());
		g2d.drawPolygon(hexagon19.getHexagon());
	}
	

    
    public class Hover extends MouseAdapter{
		
    	@Override
		public void mouseMoved(MouseEvent e) {
    		System.out.println(hexagon1.getHexagon().contains(e.getY(), e.getX()));
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
    }
}
