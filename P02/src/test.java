import static org.junit.Assert.*;

import org.junit.Test;

public class test {

	@Test
	public void distanceToPointSegment()
	{
		Point A = new Point(6,4);
		Point B = new Point(9,2);
		Point C = new Point(5,1);
		Point E = new Point(10, 5);
		Point D = new Point(2, 1);
		LineSegment DE = new LineSegment (D, E);
		assertTrue(DE.distanceTo(A) - 0.89442719099992 <=0.000000000000001);
		assertTrue(DE.distanceTo(B) - 2.23606797749979 <=0.000000000000001);
		assertTrue(DE.distanceTo(C) - 1.41421356237309 <=0.000000000000001);
	}	
	
	@Test
	public void Circle_intersects()
	{
		Point A = new Point (9,2);
		Point B = new Point (6,4);
		Point C = new Point (5,1);
		double rc = 2.23606797749979;
		double rd = 1;
		Circle c = new Circle (A,rc);
		Circle d = new Circle (B,rd);
		Circle e = new Circle (C,rd);
		Point D = new Point (2, 1);
		Point E = new Point (10, 5);
		LineSegment DE = new LineSegment (D, E);
		assertFalse(c.intersects(DE));
		assertTrue(d.intersects(DE));
		assertFalse(e.intersects(DE));
	}
	
	@Test
	public void Segment_Segment1()
	{
		Point A = new Point (2,1);
		Point B = new Point (10,5);
		Point D = new Point (5, 1);
		Point E = new Point (4, 3);
		Point F = new Point (8,4);
		Point G = new Point (10,2);
		Point H = new Point (1,2);
		Point I = new Point (6,5);
		Point J = new Point (3, 0);
		Point K = new Point (5,3);
		Point H1 = new Point (5,0);
		Point H2 = new Point (5, 6);
		Point T1 = new Point (9, 4);
		Point T2 = new Point (7, 5);
		LineSegment AB = new LineSegment (A, B);
		LineSegment DE = new LineSegment (D, E);
		LineSegment FG = new LineSegment (F, G);
		LineSegment HI = new LineSegment (H, I);
		LineSegment JK = new LineSegment (J, K);
		LineSegment H3 = new LineSegment (H1,H2);
		LineSegment T3 = new LineSegment (T1, T2);
		assertTrue(AB.intersects(DE));
		assertFalse(FG.intersects(AB));
		assertFalse(HI.intersects(AB));
		assertTrue(JK.intersects(AB));
		assertTrue(H3.intersects(AB));
		assertTrue(T3.intersects(AB));
	}
	
	@Test
	public void Rectangle_intersects()
	{
		Point A = new Point (2,1);
		Point B = new Point (10, 5);
		Point D = new Point (3, 0);
		Point E = new Point (5, 3);
		Point F = new Point (3, 4);
		Point G = new Point (5, 5);
		Point H = new Point (8, 3);
		Point I = new Point (10, 4);
		Rectangle s = new Rectangle (D,E);
		Rectangle s2 = new Rectangle (F,G);
		Rectangle s3 = new Rectangle (H,I);
		LineSegment AB = new LineSegment (A, B);
		assertTrue(s.intersects(AB));	
		assertFalse(s2.intersects(AB));
		assertFalse(s3.intersects(AB));
	}
	
	@Test
	public void slope()
	{
		Point A = new Point (2,1);
		Point B = new Point (10, 5);
		LineSegment AB = new LineSegment (A, B);
		Point D = new Point (5, 1);
		Point E = new Point (4, 3);
		LineSegment DE = new LineSegment (D, E);
		assertTrue(AB.slope() - 2 < 0.1);
		assertTrue(DE.slope() + 2 < 0.1);
		
	}
	
	@Test
	public void Triangle_intersects()
	{
		Point A = new Point (2,1);
		Point B = new Point (10,5);
		LineSegment AB = new LineSegment (A,B);
		Point D = new Point (5,1);
		Point E = new Point (4,1);
		Point F = new Point (4,2);
		Point G = new Point (5,4);
		Point H = new Point (6,5);
		Point I = new Point (4,5);
		Point J = new Point (9,4);
		Point K = new Point (7,5);
		Point L = new Point (9,6);
		Triangle t = new Triangle (D, E, F);
		Triangle t2 = new Triangle (G, H, I);
		Triangle t3 = new Triangle (J, K, L);
		assertFalse(t.intersects(AB));
		assertFalse(t2.intersects(AB));
		assertTrue(t3.intersects(AB));
		
	}
	
}