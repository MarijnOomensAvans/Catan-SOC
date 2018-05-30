//package Model.board;
//
//import java.util.Set;
//
//public class createClickpoints {
//	
//    private void createClickpoints()
//
//    {
//
//          clickpoints = new ClickPoints();
//
//          Set<String> keys = board.getLocatieKeys();
//
//          for (String key : keys)
//
//          {
//
//                clickpoints.addPoint(convertXfromKeyToScreenX(key), convertYfromKeyToScreenY(key), key);
//
//          }
//
//    }
//
//
//
//    private int convertXfromKeyToScreenX(String key)
//
//    {
//
//          String[] c = key.split(",");
//
//          int keyX = Integer.parseInt(c[0]);
//
//          return panelXmargin + ((keyX - 1) * (hexagonWidth / 2)) + keyX - 2;
//
//    }
//
//
//
//    private int convertYfromKeyToScreenY(String key)
//
//    {
//
//          String[] c = key.split(",");
//
//          int keyX = Integer.parseInt(c[0]);
//
//          int keyY = Integer.parseInt(c[1]);
//
//          return panelYmargin + (((2 * (12 - keyY)) - (10 - keyX)) * hexagonYdistance);
//
//    }
//
//
//
//    private String convertXYfromScreenToKey(int x, int y)
//
//    {
//
//          return clickpoints.getKey(x, y);
//
//    }
//}
