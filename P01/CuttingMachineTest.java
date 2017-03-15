import static org.junit.Assert.*;
import org.junit.Test;

public class CuttingMachineTest 
{
	@Test (timeout=3000)
	public void testLineSegment()
	{
		Point p = new Point(0, 0);
		Point q = new Point(2, 0);
		LineSegment ls1 = new LineSegment(p, q);
		assertTrue(ls1.isHorizontal());
		assertFalse(ls1.isDiagonal());
		assertFalse(ls1.isVertical());
		assertEquals(2.0, ls1.length(), 0.000001);
		
		q.setX(0); q.setY(2);
		assertEquals(q.getX(), 0);
		LineSegment ls2 = new LineSegment(p, q);
		assertTrue(ls2.isVertical());
		assertFalse(ls2.isDiagonal());
		assertFalse(ls2.isHorizontal());
	}
	
	@Test (timeout=3000)
	public void testArcAngle()
	{
		Point p = new Point(0, 2);
		Point q = new Point(2, 0);
		Point c = new Point(0, 0);
		
		Arc a1 = new Arc(c, p, q);
		assertEquals(Math.PI/2, a1.getAngle(), 0.000001); //Testing clockwise
		assertEquals((3*Math.PI) / 2, a1.getAngleCcw(), 0.000001); //Testing counterclockwise
		
		q.setX(0); q.setY(-2);
		Arc a2 = new Arc(c, p, q);
		assertEquals(Math.PI, a2.getAngle(), 0.000001); //Testing clockwise
		assertEquals(Math.PI, a2.getAngleCcw(), 0.000001); //Testing counterclockwise

		q.setX(-2); q.setY(0);
		Arc a3 = new Arc(c, p, q);
		assertEquals((3*Math.PI) / 2, a3.getAngle(), 0.000001); //Testing clockwise
		assertEquals(Math.PI/2, a3.getAngleCcw(), 0.000001); //Testing counterclockwise
	}

	@Test (timeout=3000)
	public void testArcLength()
	{
		Point p = new Point(0, 2);
		Point q = new Point(2, 0);
		Point c = new Point(0, 0);
		
		Arc a1 = new Arc(c, p, q);
		double expectedLength = (Math.PI/2) * a1.getRadius();
		double expectedCcwLength = ((3*Math.PI) / 2) * a1.getRadius(); //counterclockwise length
		assertEquals(expectedLength, a1.length(true), 0.000001); //Testing clockwise
		assertEquals(expectedCcwLength, a1.length(false), 0.000001); //Testing counterclockwise
	}
}
