import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * The Client implements a method to be interacted. The objective is to calculate the number of geometric shapes
 * that intersect the initial given line segment.
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
public class Client 
{
	/**
	 * This client receives many rows, the first row has two integers presenting the coordinates of the
	 * starting point of the line segment, the second row has two integers presenting the coordinates of
	 * the ending point.
	 * The third line has an integer n representing the number of rectangles, the following n rows represent
	 * rectangles, each one being four integers, the points (Xmin, Ymin) and (Xmax, Ymax), repectively,
	 * representing the coordinates of rectangle's diagonal.
	 * The next line has an integer m representing the number of circles, the following m rows represent the
	 * circles, each one being represented by three integers, the point center coordinates and the circle radius
	 * The next line has an integer k representing the number of triangles, the following k rows represent the
	 * triangles, each one being represented by six integers, each pair of integers represents the triangle vertices.
	 * @param args Not specified.  
	 */
	public static void main(String[] args) 
	{
		
		Scanner sc = new Scanner(System.in);
		List <GeometricFigure> figureList = new ArrayList<GeometricFigure>();
		Point p1 = new Point(sc.nextInt(), sc.nextInt()); 
		Point p2 = new Point(sc.nextInt(), sc.nextInt());
		LineSegment ls = new LineSegment (p1, p2);
		//-----------------------------------------------//
		int n = sc.nextInt();
		for(int i = 0; i < n; i++)
			figureList.add(new Rectangle(new Point(sc.nextInt(), sc.nextInt()), new Point(sc.nextInt(), sc.nextInt())));
		//-----------------------------------------------//
		int m = sc.nextInt();
		for(int i = 0; i < m; i++)
			figureList.add(new Circle(new Point(sc.nextInt(), sc.nextInt()), sc.nextInt()));
		//-----------------------------------------------//
		int k = sc.nextInt();
		for(int i = 0; i < k; i++)
			figureList.add(new Triangle(new Point(sc.nextInt(), sc.nextInt()), new Point(sc.nextInt(), sc.nextInt()), new Point(sc.nextInt(), sc.nextInt())));
		//-----------------------------------------------//
		sc.close();
		Solver s = new Solver(figureList, ls);
		System.out.println(s.intersections());
	}
}