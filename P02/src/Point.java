/**
 * This class represents a Point defined by two axis coordinates (two dimensional point), x and y.
 *   
 * @author Andre Pedro
 * @author Ricardo Reais
 * @author Vasco Carvalho
 * @version 2.0
 * @since 16/10/2016
 * @see LineSegment
 */
class Point 
{
	/**
	 * The axis coordinates x and y. 
	 */
	private double _x_, _y_;
	
	/**
	 * To initialize a new Point we must have two coordinates
	 * @param x Coordinate of the x axis.
	 * @param y Coordinate of the y axis.
	 */
	public Point(double x, double y) 
	{ 
		setX(x); 
		setY(y); 
	}
	
	/**
	 * @return The coordinate x.
	 */
	public double getX() 
	{ 
		return _x_; 
	}
	
	/**
	 * @return The coordinate y.
	 */
	public double getY() 
	{ 
		return _y_;
	}
	
	/**
	 * Defines the coordinate x.
	 * @param x New x coordinate.
	 */
	public void setX(double x) 
	{ 
		_x_ = x; 
	}
	
	/**
	 * Defines the coordinate y.
	 * @param y New y coordinate.
	 */
	public void setY(double y) 
	{ 
		_y_ = y; 
	}
	
	/**
	 * Given a point, computes the distance between the current point and the given point.
	 * @param p Point given to calculate the distance.
	 * @return Distance between the two points.
	 */
	public double distanceTo(Point p) 
	{
		double dx = getX() - p.getX();
		double dy = getY() - p.getY();
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	/**
	 *  We can calculate the distance of a point to a line if the point is located between 
	 *  the line segment outermost points, this is, it's x coordinate is bigger than the 
	 *  smallest x coordinate of the segment and it is also smaller than the largest x 
	 *  coordinate of the segment.
	 *  Else, we calculate the minimum distance between the point and the outermost points of
	 *  the segment.
	 * @param ls Line segment to calculate the distance between.
	 * @return Point distance to a Line segment.
	 * @see #distanceTo(Point)
	 * @see LineSegment
	 */
	public double distanceTo(LineSegment ls)
	{
		double px = getX(); double py = getY();
		double x1 = ls.getStart().getX(); double y1 = ls.getStart().getY();
		double x2 = ls.getEnd().getX(); double y2 = ls.getEnd().getY();
		double dist = (Math.abs((x2-x1)*(y1-py) - (x1-px)*(y2-y1)) / 
				   	  (Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2))));
		
		if((!ls.isVertical() && ls.getSmallestX() < getX() && getX() < ls.getLargestX()) || 
		  (ls.isVertical() && ls.getSmallestY() < getY() && getY() < ls.getLargestY()))
			return dist;
		else
			return Math.min(distanceTo(ls.getStart()), distanceTo(ls.getEnd()));
	}
	
	/**
	 * Given a point, checks if the points are the same point with a precision of 0.0001.
	 * @param p Point used for comparison.
	 * @return True if the Points are equal, else false.
	 */
	public boolean equals(Point p)
	{
		double precision = 0.0001; //Error margin/precision
		return Math.abs(this.getX() - p.getX()) < precision && Math.abs(this.getY() - p.getY()) < precision;
	}
	
	/**
	 * Given a point, checks if the current Point is on his left side.
	 * @param p Point used for comparison.
	 * @return True if the Point is on his left, else false.
	 */
	public boolean isOnLeft(Point p)
	{
		return getX() < p.getX();
	}
	
	/**
	 * Given a point, checks if the current Point is on his right side.
	 * @param p Point used for comparison.
	 * @return True if the Point is on his right, else false.
	 */
	public boolean isOnRight(Point p)
	{
		return getX() > p.getX();
	}
	
	/**
	 * Given a point, checks if the current Point is above it.
	 * @param p Point used for comparison.
	 * @return True if the Point is above it, else false.
	 */
	public boolean isAbove(Point p)
	{
		return getY() > p.getY();
	}
	
	/**
	 * Given a point, checks if the current Point is below it.
	 * @param p Point used for comparison.
	 * @return True if the Point is below it, else false.
	 */
	public boolean isBelow(Point p)
	{
		return getY() < p.getY();
	}
	
	/**
	 * Given a line segment, checks if the point belongs to it. (Is part of the segment?)
	 * We check the distance between the point and the segment and if the distance is lower than
	 * 0.0001, it's considered that the point is in fact in the line segment.
	 * @param ls Line segment used for analysis.
	 * @return True if the Point belongs to the segment, else false.
	 * @see #distanceTo(LineSegment)
	 */
	public boolean belongsTo(LineSegment ls)
	{
		double precision = 0.0001;
		return distanceTo(ls) < precision;
	}
	
	/**
	 * Returns a string representation of the object. In general,
	 * the toString method returns a string that "textually represents" this object.
	 * @return Characteristics of the Point.
	 */
	@Override
	public String toString()
	{
		return "Point = (" + getX() + ", " + getY() + ")";
	}
}

