package Model.board;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author Ger Saris
 * @version 1.0
 * @date 12-03-2017
 * 
 */

public class ClickPoints
{

	private HashMap<Point, String> points;
	private ArrayList<Integer> xvalues;
	private ArrayList<Integer> yvalues;


	// constructor

	public ClickPoints()
	{
		points = new HashMap<Point, String>();
		xvalues = new ArrayList<Integer>();
		yvalues = new ArrayList<Integer>();
	}


	public String getKey(int clickX, int clickY)
	{
		String ret = "?";

		int foundX = 0;
		int foundY = 0;

		Collections.sort(xvalues);
		Collections.sort(yvalues);

		int lower;
		int higher;
		int i = 0;

		// find nearest X
		lower = -1000;
		higher = +1000;
		for (Integer o : xvalues)
		{
			i = o.intValue();

			if (i <= clickX && i > lower)
			{
				lower = i;
			}

			if (i >= clickX && i < higher)
			{
				higher = i;
			}
		}

		if ((clickX - lower) < (higher - clickX))
		{
			foundX = lower;
		}
		else
		{
			foundX = higher;
		}

		// find nearest Y
		lower = -1000;
		higher = +1000;
		for (Integer o : yvalues)
		{
			i = o.intValue();

			if (i <= clickY && i > lower)
			{
				lower = i;
			}

			if (i >= clickY && i < higher)
			{
				higher = i;
			}
		}

		if ((clickY - lower) < (higher - clickY))
		{
			foundY = lower;
		}
		else
		{
			foundY = higher;
		}
		
		//lookup nearest point based on nearest foundX, foundY
		Point lookup = new Point(foundX, foundY);
		ret = points.get(lookup);
		return ret;
	}


	public void addPoint(int x, int y, String key)
	{
		Point newpoint = new Point(x, y);
		if (!points.containsKey(newpoint))
		{
			points.put(newpoint, key);
			xvalues.add(x);
			yvalues.add(y);
			showPOint(newpoint);
		}
	}
	
	
	// Debug method
	public void showPOint(Point point) {
		System.out.println(points.get(point));
	}


}
