package View.board;

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
          int xval = center.x + radius;
          int yval = center.y - 30;
              polygon.addPoint(xval, yval);
              xval = center.x + radius;
              yval = center.y + 30;
              polygon.addPoint(xval, yval);
              xval = center.x;
              yval = center.y + (radius + 10);
              polygon.addPoint(xval, yval);
              xval = center.x - radius;
              yval = center.y + 30;
              polygon.addPoint(xval, yval);
              xval = center.x - radius;
              yval = center.y - 30;
              polygon.addPoint(xval, yval);
              xval = center.x;
              yval = center.y - (radius + 10);
              polygon.addPoint(xval,yval);
          return polygon;
      }
// get the radius back
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
