/**
 * This class represents a two dimensional triangle defined by three point, they represent
 * the triangle's vertices.
 * 
 * @author Andre Pedro
 * @author Ricardo Reais
 * @author Vasco Carvalho
 * @version 1.0
 * @since 13/11/2016
 * @see GeometricFigure
 * @see Point
 */
public class Triangle extends GeometricFigure 
{
	/**
	 * The triangle vertices.
	 */
	private Point a, b, c;
	
	/**
	 * The creation of a valid triangle implies that the vertices of the triangle must be
	 * different points, or else, we would have a line segment or a single point.
	 * @param a Triangle first vertice.
	 * @param b Triangle second vertice.
	 * @param c Triangle third vertice.
	 */
	public Triangle (Point a, Point b, Point c)
	{
		if(a.equals(b) || a.equals(c) || b.equals(c))
			throw new IllegalArgumentException("The points can not be the same");
		else
		{
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	/**
	 * @return Triangle's vertice A. 
	 */
	public Point getVerticeA()
	{
		return a;
	}
	
	/**
	 * @return Triangle's vertice B.  
	 */
	public Point getVerticeB()
	{
		return b;
	}
	
	/**
	 * @return Triangle's vertice C.  
	 */
	public Point getVerticeC()
	{
		return c;
	}
	
	/**
	 * Defines Triangle's vertice A.
	 * @param a New vertice point.
	 */
	public void setVerticeA(Point a) 
	{ 
		if(!a.equals(b) && !a.equals(c))
			this.a = a;
		else
			throw new IllegalArgumentException("The vertice already exists");
	}
	
	/**
	 * Defines Triangle's vertice B.
	 * @param b New vertice point.
	 */
	public void setVerticeB(Point b) 
	{ 
		if(!b.equals(a) && !b.equals(c))
			this.b = b;
		else
			throw new IllegalArgumentException("The vertice already exists");
	}
	
	/**
	 * Defines Triangle's vertice C.
	 * @param c New vertice point.
	 */
	public void setVerticeC(Point c) 
	{ 
		if(!c.equals(a) && !c.equals(b))
			this.c = c;
		else
			throw new IllegalArgumentException("The vertice already exists");
	}
	
	/**
	 * Computes the area of the triangle using: |(Ax(By-Cy) + Bx(Cy-Ay) + Cx(Ay-By)) / 2|.
	 * @return Area of the triangle.
	 */
	@Override
	protected double area() 
	{
		return Math.abs((getVerticeA().getX() * (getVerticeB().getY() - getVerticeC().getY()) 
		+ getVerticeB().getX() * (getVerticeC().getY() - getVerticeA().getY())
		+ getVerticeC().getX() * (getVerticeA().getY() - getVerticeB().getY())) / 2);
	}

	/**
	 * Computes the perimeter of the triangle using: AB + AC + BC.
	 * @return Perimeter of the triangle.
	 */
	@Override
	protected double perimeter() 
	{
		return getVerticeA().distanceTo(getVerticeB()) + getVerticeA().distanceTo(getVerticeC()) + getVerticeB().distanceTo(getVerticeC());
	}

	/**
	 * Checks if a triangle intersects a line segment, using the intersection between two line
	 * segments in all of the triangle's edges.
	 * @param ls Line segment to check the intersection.
	 * @return True if the triangle and the segment intersect, else false.
	 * @see LineSegment#intersects(LineSegment)
	 */
	@Override
	protected boolean intersects(LineSegment ls)
	{
		LineSegment ab = new LineSegment (getVerticeA(), getVerticeB());
		LineSegment ac = new LineSegment (getVerticeA(), getVerticeB());
		LineSegment bc = new LineSegment (getVerticeB(), getVerticeC());
		
		return ab.intersects(ls) || ac.intersects(ls) || bc.intersects(ls);
	}
	
	/**
	 * Returns a string representation of the object. In general,
	 * the toString method returns a string that "textually represents" this object.
	 * @return Characteristics of the Triangle.
	 */
	@Override
	public String toString()
	{
		return "Point A: " + getVerticeA() + "\nPoint B: " + getVerticeB() + "\nPoint C:" + getVerticeB();
	}
}