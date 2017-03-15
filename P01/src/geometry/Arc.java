package geometry;

/**
 * This class represents a circular arc (curve that is a segment of a circle) 
 * defined by three points, the center, the start and the end.
 *   
 * @author Andre Pedro
 * @author Ricardo Reais
 * @author Vasco Carvalho
 * @version 1.1
 * @since 19/10/2016
 * @see geometry.Point
 */
public class Arc 
{
	/**
	 * The defining points of the Arc.
	 */
	private Point center, start, end;
	
	/**
	 * The radius is computed using the distance between the start point and the center. as we see in the constructor,
	 * or between the end point and the center.
	 * @see geometry.Point#dist(Point)
	 */
	private double radius;
	
	/**
	 * Initializes the Arc with three points and a radius, this radius is a characteristic of the arc
	 * used to compute the Arc length.
	 * @param center Center point of the Arc's defining circumference.
	 * @param start Starting point of the Arc.
	 * @param end Ending point of the Arc.
	 */
	public Arc(Point center, Point start, Point end)
	{		
		radius = start.dist(center);
		assert radius == end.dist(center); //make sure the distances are the same
		this.center = center;
		this.start = start;
		this.end = end;
	}

	/**
	 * Calculates the clockwise angle that the Arc forms between the two segments, the line segment from the center 
	 * to the start point and from the center to the end point.
	 * @return Angle formed between Arc's segments.
	 */
	public double getAngle()
	{
		double angle1 = Math.atan2(start.getY() - center.getY(), start.getX() - center.getX());
		double angle2 = Math.atan2(end.getY() - center.getY(), end.getX() - center.getX());
		double result = angle1-angle2;
		
		if(result < 0)
			result += 2*Math.PI;
		return result;
	}
	
	/**
	 * Calculates the counterclockwise angle that the Arc forms between the two segments, the line segment from the center 
	 * to the start point and from the center to the end point.
	 * @return Angle formed between Arc's segments.
	 * @see #getAngle()
	 */
	public double getAngleCcw()
	{
		return (2*Math.PI) - getAngle(); //to make it counter clockwise, just subtract the clockwise value from 2PI (Full circumference)
	}
	
	/**
	 * Computes the length of the Arc using the simple equation Theta * radius.
	 * @param clockwise True if we want the clockwise length of an Arc, or false for the counterclockwise length.
	 * @return Length of the Arc.
	 * @see #getAngle()
	 * @see #getAngleCcw()
	 */
	public double length(boolean clockwise)
	{
		if(clockwise)
			return getAngle() * radius;
		else
			return getAngleCcw() * radius;
	}
	
	/**
	 * @return Arc's center point.
	 */
	public Point getCenter()
	{
		return center;
	}
	
	/**
	 * @return Arc's start point.
	 */
	public Point getStart()
	{
		return start;
	}
	
	/**
	 * @return Arc's end point.
	 */
	public Point getEnd()
	{
		return end;
	}
	
	/**
	 * @return Arc's radius.
	 * @see #Arc(Point, Point, Point)
	 */
	public double getRadius()
	{
		return radius;
	}
	
	/**
	 * Returns a string representation of the object. In general,
	 * the toString method returns a string that "textually represents" this object.
	 * @return Characteristics of the Arc.
	 */
	@Override
	public String toString()
	{
		return "Arc center: " + center + "\nArc start: " + start + "\nArc end: " + end + "\nArc clockwise angle: "
				+ getAngle() + "\nArc counterclockwise angle: " + getAngleCcw();
	}
}
