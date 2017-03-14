/**
 * This class represents a two dimensional rectangle defined by two point, they represent
 * (x min, y min) and (x max, y max), respectively, representing the coordinates of rectangle's
 * diagonal.
 * 
 * @author Andre Pedro
 * @author Ricardo Reais
 * @author Vasco Carvalho
 * @version 1.0
 * @since 13/11/2016
 * @see GeometricFigure
 * @see Point
 * @see LineSegment
 */
public class Rectangle extends GeometricFigure 
{
	/**
	 * The Point a can be considered the start and b the end point, both points connected form the 
	 * line segment that represents the diagonal of the rectangle.
	 */
	private Point a, b;
	
	/**
	 * The creation of a valid rectangle implies that the start and end points of the diagonal
	 * must be different, or else we would only have one simple point.
	 * @param a Rectangle diagonal start point.
	 * @param b Rectangle diagonal end point.
	 */
	public Rectangle(Point a, Point b)
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
	 * @return Outermost starting point of the rectangle's diagonal. 
	 */
	public Point getStart()
	{
		return a;
	}
	
	/**
	 * @return Outermost ending point of the rectangle's diagonal. 
	 */
	public Point getEnd()
	{
		return b;
	}
	
	/**
	 * Defines the outermost starting point of the rectangle's diagonal.
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
	 * Defines the outermost ending point of the rectangle's diagonal.
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
	 * Computes the distance between the two opposite vertices of the rectangle.
	 * @return Length of the rectangle diagonal.
	 */
	public double diagonalLength()
	{
		return getStart().distanceTo(getEnd());
	}
	
	/**
	 * Computes the height of the rectangle.
	 * @return Height of the rectangle.
	 */
	public double height()
	{
		return Math.abs(getStart().getY() - getEnd().getY());
	}
	
	/**
	 * Computes the length of the rectangle.
	 * @return Length of the rectangle.
	 */
	public double length()
	{
		return Math.abs(getStart().getX() - getEnd().getX());
	}
	
	/**
	 * Computes the area of the rectangle using: height * length.
	 * @return Area of the rectangle.
	 */
	@Override
	protected double area()
	{
		return height()*length();
	}
	
	/**
	 * Computes the perimeter of the rectangle using: 2*height + 2*length.
	 * @return Perimeter of the rectangle.
	 */
	@Override
	protected double perimeter()
	{
		return 2*height() + 2*length();
	}
	
	/**
	 * Checks if a rectangle intersects a line segment, using the intersection between two line
	 * segments in all of the rectangle's edges.
	 * @param ls Line segment to check the intersection.
	 * @return True if the rectangle and the segment intersect, else false.
	 * @see LineSegment#intersects(LineSegment)
	 */
	@Override
	protected boolean intersects(LineSegment ls)
	{
		Point c = new Point(getStart().getX(), getEnd().getY());
		Point d = new Point(getEnd().getX(), getStart().getY());
		LineSegment ac = new LineSegment (getStart(), c);
		LineSegment ad = new LineSegment (getStart(), d);
		LineSegment bc = new LineSegment (getEnd(), c);
		LineSegment bd = new LineSegment (getEnd(), d);
			
		if((getStart().belongsTo(ls) && getEnd().belongsTo(ls)) || (c.belongsTo(ls) && d.belongsTo(ls)))
			return true;
		else 
			return ac.intersects(ls) || ad.intersects(ls) || bc.intersects(ls) || bd.intersects(ls);
	}
	
	/**
	 * Returns a string representation of the object. In general,
	 * the toString method returns a string that "textually represents" this object.
	 * @return Characteristics of the Rectangle.
	 */
	@Override
	public String toString()
	{
		return "Diagonal start Point: " + getStart() + "\nDiagonal end Point: " + getEnd();
	}
}
