import geometry.Arc;
import geometry.LineSegment;
import geometry.Point;

/**
 * This class represents a cutting machine, that can compute the length of a cut, given a set of
 * points according to the desired sequence of the cut.
 *  
 * The machine cuts using a specific algorithm, it begins with a horizontal or vertical cut,
 * but for changing directions it must make an arc shaped cut, if we have enough points,
 * it does another line segment cut, then another arc shaped cut, and so on...
 * 
 * @author Andre Pedro
 * @author Ricardo Reais
 * @author Vasco Carvalho
 * @version 1.2
 * @since 21/10/2016
 * @see geometry.Point
 * @see geometry.LineSegment
 * @see geometry.Arc
 */
public class CuttingMachine 
{
	/**
	 * The Points that define the Machine trajectory.
	 */
	private Point[] p;
	
	/**
	 * Initializes a cutting machine defined by an array of points. In this constructor,
	 * and according to the given problem, we need to make sure the number of points is bigger than 2
	 * and the first two points need to be a valid line segment.
	 * @param p The array of points that define the Machine trajectory.
	 */
	public CuttingMachine(Point[] p)
	{
		assert p.length > 2;
		assert !p[0].equal(p[1]);
		this.p = p;
	}
	
	/**
	 * @return The set of points which define the machine trajectory.
	 */
	public Point[] getPoints()
	{
		return p;
	}
	
	/**
	 * arcLenght is an implementation of the method length in the class Arc, using the Line Segment before 
	 * the Arc, in order to understand if we want to calculate the Arc length clockwise or counterclockwise.
	 * 
	 * @param ls Line Segment before the Arc we want to calculate.
	 * @param a The Arc we want to calculate the length.
	 * @param i Iteration number of the machine.
	 * @return Arc length, given the position and direction of the segment previous to that arc.
	 * @see geometry.Arc#length(boolean)
	 * @see geometry.LineSegment
	 */
	private double arcLength(LineSegment ls, Arc a, int i)
	{
		//CLOCKWISE
		if((ls.isHorizontal() && ls.getStart().isAbove(p[i+2]) && ls.getStart().isOnLeft(p[i+2]))
		|| (ls.isHorizontal() && ls.getStart().isBelow(p[i+2]) && ls.getStart().isOnRight(p[i+2]))
		|| (ls.isVertical() && ls.getStart().isAbove(p[i+2]) && ls.getStart().isOnRight(p[i+2]))
		|| (ls.isVertical() && ls.getStart().isBelow(p[i+2]) && ls.getStart().isOnLeft(p[i+2])))
			return a.length(true);
		//COUNTERCLOCKWISE
		else
			return a.length(false);
	}
	
	/**
	 * Given the machine set of points, divides the points into line segments and into arcs.
	 * Calculating the length of the line segments using the method length present in the class LineSegment
	 * and also the arc length using the implementation of arcLength present in this class. 
	 * @return Total length of the machine cut.
	 * @see geometry.Arc#length(boolean)
	 * @see #arcLength(LineSegment, Arc, int)
	 */
	public double cutLength()
	{
		LineSegment ls; //the current segment
		Arc a;
		double result = 0.0;
		
		for(int i = 0; i < p.length-1; i+=3)
		{
			ls = new LineSegment(p[i], p[i+1]);
			result += ls.length();
			if(i+3 <= p.length)
			{
				a = new Arc(p[i+2], p[i+1], p[i+3]);
				result += arcLength(ls, a, i);
			}
		}
		return result;
	}
	
	/**
	 * Returns a string representation of the object. In general,
	 * the toString method returns a string that "textually represents" this object.
	 * @return Characteristics of the Machine.
	 */
	@Override
	public String toString()
	{
		return "Trajectory length: " + cutLength();
	}
}
