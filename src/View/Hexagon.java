package View;

import java.awt.Point;
import java.awt.Polygon;

public class Hexagon {
// making instance variable
	  private final int radius;

      private final Point center;

      private final Polygon hexagon;

      public Hexagon(Point center, int radius) {
// initialize everything
          this.center = center;
          this.radius = radius;
          this.hexagon = createHexagon();

      }
// create a hexagon
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
// get teh radius back
      public int getRadius() {
          return radius;
      }
//  get center back
      public Point getCenter() {
          return center;
      }
// get the hexagon back
      public Polygon getHexagon() {
          return hexagon;
      }
  }
