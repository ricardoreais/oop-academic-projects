/**
 * This class represents a Line Segment defined by two outermost points, one point a (let's say it's the start point) 
 * and another, point b (we can consider it the end point).
 *   
 * @author Andre Pedro
 * @author Ricardo Reais
 * @author Vasco Carvalho
 * @version 2.0
 * @since 20/10/2016
 * @see Point
 */
public class LineSegment 
{
	/**
	 * The outermost Point a can be considered the start and b the end point, both points connected form the 
	 * line segment.
	 */
	private Point a, b;
	
	/**
	 * The creation of a valid LineSegment implies that the start and end points must be different, or else we would
	 * only have one simple point.
	 * @param a LineSegment start point.
	 * @param b LineSegment end point.
	 */
	public LineSegment(Point a, Point b)
	{
		if(a.equals(b))
			throw new IllegalArgumentException("The points can not be the same");
		else
		{
			this.a = a;
			this.b = b;
		}
	}
	
	/**
	 * @return Outermost starting point of the Line Segment. 
	 */
	public Point getStart()
	{
		return a;
	}
	
	/**
	 * @return Outermost ending point of the Line Segment. 
	 */
	public Point getEnd()
	{
		return b;
	}
	
	/**
	 * @return Outermost largest x coordinate of the Line Segment. 
	 */
	public double getLargestX()
	{
		return Math.max(a.getX(), b.getX());
	}
	
	/**
	 * @return Outermost smallest x coordinate of the Line Segment. 
	 */
	public double getSmallestX()
	{
		return Math.min(a.getX(), b.getX());
	}
	
	/**
	 * @return Outermost largest x coordinate of the Line Segment. 
	 */
	public double getLargestY()
	{
		return Math.max(a.getY(), b.getY());
	}
	
	/**
	 * @return Outermost smallest x coordinate of the Line Segment. 
	 */
	public double getSmallestY()
	{
		return Math.min(a.getY(), b.getY());
	}
	
	/**
	 * Defines the outermost starting point.
	 * @param a New start point.
	 */
	public void setStart(Point a) 
	{ 
		if(!a.equals(this.b))
			this.a = a;
		else
			throw new IllegalArgumentException("The points can not be the same");
	}
	
	/**
	 * Defines the outermost ending point.
	 * @param b New end point.
	 */
	public void setEnd(Point b) 
	{ 
		if(!b.equals(this.a))
			this.b = b;
		else
			throw new IllegalArgumentException("The points can not be the same");
	}
	
	/**
	 * This mid point is obtained using the formula: Center = ((x1+x2)/2, (y1+y2)/2).
	 * @return Mid Point of the Line Segment. 
	 * @see Point
	 */
	public Point midPoint()
	{
		return new Point((getStart().getX() + getEnd().getX()) / 2, (getStart().getY() + getEnd().getY()) / 2);
	}
	
	/**
	 * Checks if the line segment is not horizontal and  is not vertical simultaneously.
	 * @return True if the line segment is diagonal, else false.
	 */
	public boolean isDiagonal()
	{
		return !isHorizontal() && !isVertical();
	}
	
	/**
	 * @return True if the line segment is horizontal, else false.
	 */
	public boolean isHorizontal()
	{
		return getStart().getY() == getEnd().getY();
	}
	
	/**
	 * @return True if the line segment is vertical, else false.
	 */
	public boolean isVertical()
	{
		return getStart().getX() == getEnd().getX();
	}
	
	/**
	 * @return Line Segment length. (Distance between starting and end points)
	 * @see Point#distanceTo(Point)
	 */
	public double length() 
	{
		return getStart().distanceTo(getEnd());
	}
	
	/**
	 * @return Line Segment slope. If the segment is vertical the value is infinity, by convenience it
	 * returns the maximum double value instead of infinity.
	 */
	public double slope()
	{
		if(!isVertical())
			return (getEnd().getY() - getStart().getY()) / (getEnd().getX() - getStart().getX());
		else
			return Double.MAX_VALUE;
	}
	
	/**
	 * The intercept of a line segment is the y value of the point where it's line crosses the y axis.
	 * @return Line Segment intercept. 
	 */
	public double intercept()
	{
		if(!isVertical())
			return (getEnd().getX() * getStart().getY() - getStart().getX() * getEnd().getY()) / (getEnd().getX() - getStart().getX());
		else
			return -Double.MAX_VALUE;
	}
	
	/**
	 *  We can calculate the distance of a point to a line if the point is located between 
	 *  the line segment outermost points, this is, it's x coordinate is bigger than the 
	 *  smallest x coordinate of the segment and it is also smaller than the largest x 
	 *  coordinate of the segment.
	 *  Else, we calculate the minimum distance between the point and the outermost points of
	 *  the segment.
	 * @param p Point to calculate the distance between.
	 * @return Line Segment distance to a point.
	 * @see Point#distanceTo(LineSegment)
	 */
	public double distanceTo(Point p)
	{
		return p.distanceTo(this);
	}
	
	/**
	 *  The algorithm used is a modified version of the algorithm to check the intersection 
	 *  between two line segments, as described on:
	 *  http://moderntone.blogspot.pt/2013/02/a-simple-algorithm-to-determine-whether.html
	 *  By: Tom.
	 *  
	 *  The modification is: When both segments are diagonal, the x value needs to be between
	 *  the maximum of the lowest x values, and the minimum of the largest x values of the segments.
	 *  Instead of: X needs to be between x1 and x2, as seen on the original algorithm
	 *  Another detail added is, when the segments are collinear, they don't intersect. Which
	 *  differs from the original algorithm.
	 *  
	 * @param ls Line segment to check the intersection.
	 * @return True if the segments intersect, else false.
	 * @see #slope()
	 * @see #intercept()
	 * @see #isVertical()
	 * @see #getSmallestX()
	 * @see #getLargestX()
	 * @see Point
	 */
	public boolean intersects(LineSegment ls)
	{
		boolean result = false;
		double x1 = getStart().getX(); double y1 = getStart().getY();
		double x2 = getEnd().getX(); double y2 = getEnd().getY();
		double x3 = ls.getStart().getX(); double y3 = ls.getStart().getY();
		double x4 = ls.getEnd().getX(); double y4 = ls.getEnd().getY();
		
		if (isVertical()) //sg1 is vertical
		{
			if ((x3 - x1)*(x4 - x1) > 0) result = false;
			else 
			{
				double fx = ls.slope() * x1 + ls.intercept();
				Point p = new Point(x1, fx);
				if (!p.belongsTo(this) || p.getY()==y1 || p.getY()==y2)
					result = false;
				else
					result = true;
			}
		}
		else if (ls.isVertical()) //sg2 is vertical
		 	result = ls.intersects(this);
		else //sg1 & sg2 both not vertical
		{
			if (slope() == ls.slope()) result = false; //Same slope, means they are parallel
			else 
			{
				double x = ((x4*y3-y4*x3)/(x4-x3) - (x2*y1-y2*x1)/(x2-x1))
				      /( (y2-y1)/(x2-x1) - (y4-y3)/(x4-x3));
				if ((Math.max(getSmallestX(), ls.getSmallestX()) < x && x < Math.min(getLargestX(), ls.getLargestX()))) 
					result = true;
				else 
					result = false;
			} 
		}
		return result;
	}

	/**
	 * Returns a string representation of the object. In general,
	 * the toString method returns a string that "textually represents" this object.
	 * @return Characteristics of the Line Segment.
	 */
	@Override
	public String toString()
	{
		return "Start Point: " + getStart() + "\nEnd Point: " + getEnd();
	}
}

