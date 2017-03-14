import java.util.*;
/**
 * Given a itinerary and the obstacles between the start and the end of the itinerary.
 * The objective is to count the number of obstacles that intersect the itinerary.
 * The solver is used to solve the specific problem, we receive some geometric figures
 * and a line segment, we count the number of given figures that intersect the line segment.
 * 
 * @author Andre Pedro
 * @author Ricardo Reais
 * @author Vasco Carvalho
 * @version 1.0
 * @since 04/11/2016
 * @see Point
 * @see LineSegment
 * @see Circle
 * @see Triangle
 * @see Rectangle
 * @see Solver
 * @see GeometricFigure
 */
public class Solver 
{
	/**
	 * Line segment representing the itinerary. 
	 */
	private LineSegment itinerary;
	
	/**
	 * List of figures that obstacles, or not, the itinerary. 
	 */
	private List<GeometricFigure> obstacles;
	
	
	public Solver(List <GeometricFigure> figureList, LineSegment ls)
	{
		this.obstacles = figureList;
		this.itinerary = ls;
	}
	
	/**
	 * @return List with the obstacles within the start and end of the itinerary.
	 */
	private List<GeometricFigure> getObstacles()
	{
		return obstacles;
	}
	
	/**
	 * @return Line segment defining the itinerary.
	 */
	private LineSegment getItinerary()
	{
		return itinerary;
	}
	
	/**
	 * @return Number of intersections with obstacles from the beginning until 
	 * the end of the itinerary.
	 */
	public int intersections()
	{
		int result = 0;
		for (GeometricFigure gf : getObstacles())
			if (gf.intersects(getItinerary()))
				result++;
		return result;
	}
}
