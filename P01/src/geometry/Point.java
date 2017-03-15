package geometry;

/**
 * This class represents a Point defined by two axis coordinates (two dimensional point), x and y.
 *   
 * @author Andre Pedro
 * @author Ricardo Reais
 * @author Vasco Carvalho
 * @version 1.1
 * @since 20/10/2016
 */
public class Point 
{
	/**
	 * The axis coordinates x and y. 
	 */
	private int _x_, _y_;
	
	/**
	 * To initialize a new Point we must have two coordinates
	 * @param x Coordinate of the x axis.
	 * @param y Coordinate of the y axis.
	 */
	public Point(int x, int y) 
	{ 
		setX(x); 
		setY(y); 
	}
	
	/**
	 * @return The coordinate x.
	 */
	public int getX() 
	{ 
		return _x_; 
	}
	
	/**
	 * @return The coordinate y.
	 */
	public int getY() 
	{ 
		return _y_;
	}
	
	/**
	 * Defines the coordinate x.
	 * @param x New x coordinate.
	 */
	public void setX(int x) 
	{ 
		_x_ = x; 
	}
	
	/**
	 * Defines the coordinate y.
	 * @param y New y coordinate.
	 */
	public void setY(int y) 
	{ 
		_y_ = y; 
	}
	
	/**
	 * Given a point, computes the distance between the current point and the given point.
	 * @param p Point given to calculate the distance.
	 * @return Distance between the two points.
	 */
	public double dist (Point p) 
	{
		int dx = getX() - p.getX();
		int dy = getY() - p.getY();
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	/**
	 * Given a point, checks if the points are the same point with a precision of 0.0001.
	 * @param p Point used for comparison.
	 * @return True if the Points are equal, else false.
	 */
	public boolean equal(Point p)
	{
		double precision = 0.0001; //Error margin/precision
		return Math.abs(this.getX() - p.getX()) < precision && Math.abs(this.getY() - p.getY()) < precision;
	}
	
	/**
	 * Given a point, checks if the current Point is on his left side.
	 * @param p Point used for comparison.
	 * @return True if the Point is on his left, else false.
	 * @see #isAbove(Point)
	 * @see #isBelow(Point)
	 * @see #isOnRight(Point)
	 */
	public boolean isOnLeft(Point p)
	{
		return getX() < p.getX();
	}
	
	/**
	 * Given a point, checks if the current Point is on his right side.
	 * @param p Point used for comparison.
	 * @return True if the Point is on his right, else false.
	 * @see #isAbove(Point)
	 * @see #isBelow(Point)
	 * @see #isOnLeft(Point)
	 */
	public boolean isOnRight(Point p)
	{
		return getX() > p.getX();
	}
	
	/**
	 * Given a point, checks if the current Point is above it.
	 * @param p Point used for comparison.
	 * @return True if the Point is above it, else false.
	 * @see #isBelow(Point)
	 * @see #isOnRight(Point)
	 * @see #isOnLeft(Point)
	 */
	public boolean isAbove(Point p)
	{
		return getY() > p.getY();
	}
	
	/**
	 * Given a point, checks if the current Point is below it.
	 * @param p Point used for comparison.
	 * @return True if the Point is below it, else false.
	 * @see #isAbove(Point)
	 * @see #isOnRight(Point)
	 * @see #isOnLeft(Point)
	 */
	public boolean isBelow(Point p)
	{
		return getY() < p.getY();
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