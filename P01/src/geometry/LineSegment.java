package geometry;

/**
 * This class represents a Line Segment defined by two outermost points, one point a (let's say it's the start point) 
 * and another, point b (we can consider it the end point).
 *   
 * @author Andre Pedro
 * @author Ricardo Reais
 * @author Vasco Carvalho
 * @version 1.0
 * @since 16/10/2016
 * @see geometry.Point
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
		if(a.equal(b))
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
	 * Defines the outermost starting point.
	 * @param a New start point.
	 */
	public void setStart(Point a) 
	{ 
		if(!a.equal(this.b))
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
		if(!b.equal(this.a))
			this.b = b;
		else
			throw new IllegalArgumentException("The points can not be the same");
	}
	
	/**
	 * @return Mid Point of the Line Segment. 
	 */
	public Point midPoint()
	{
		return new Point((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2); //Formula used: Center Point = ((x1+x2)/2, (y1+y2)/2 )
	}
	
	/**
	 * @return True if the line segment is diagonal, else false.
	 * @see #isHorizontal()
	 * @see #isVertical()
	 */
	public boolean isDiagonal()
	{
		return a.getX() != b.getX() && a.getY() != b.getY();
	}
	
	/**
	 * @return True if the line segment is horizontal, else false.
	 * @see #isDiagonal()
	 * @see #isVertical()
	 */
	public boolean isHorizontal()
	{
		return a.getY() == b.getY();
	}
	
	/**
	 * @return True if the line segment is vertical, else false.
	 * @see #isDiagonal()
	 * @see #isHorizontal()
	 */
	public boolean isVertical()
	{
		return a.getX() == b.getX();
	}
	
	/**
	 * @return Line Segment length. (Distance between starting and end points)
	 * @see geometry.Point#dist(Point)
	 */
	public double length() 
	{
		return a.dist(b);
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
