package View;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hexagon extends JLabel implements MouseListener{
	  private final int radius;

      private final Point center;

      private final Polygon hexagon;

      public Hexagon(Point center, int radius) {
          this.center = center;
          this.radius = radius;
          this.hexagon = createHexagon();
         addMouseListener(this);
      }

      private Polygon createHexagon() {
          Polygon polygon = new Polygon();

          for (int i = 0; i < 6; i++) {
              int xval = (int) (center.x + radius
                      * Math.cos(i * 2 * Math.PI / 6D));
              int yval = (int) (center.y + radius
                      * Math.sin(i * 2 * Math.PI / 6D));
              polygon.addPoint(xval, yval);
              
              
          }

          return polygon;
      }

      public int getRadius() {
          return radius;
      }

      public Point getCenter() {
          return center;
      }

      public Polygon getHexagon() {
          return hexagon;
      }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Juraj you did it");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

  }
