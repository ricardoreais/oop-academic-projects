import java.text.DecimalFormat;
import java.util.Scanner;

import geometry.Point;

/**
 * The Client implements a method to be interacted. The objective is to calculate the total length of
 * the CuttingMachine's trajectory given a set of points. 
 * 
 * @author Andre Pedro
 * @author Ricardo Reais
 * @author Vasco Carvalho
 * @version 1.0
 * @since 21/10/2016
 * @see geometry.Point
 * @see geometry.LineSegment
 * @see geometry.Arc
 * @see Class CuttingMachine
 */
public class Client 
{
	/**
	 * First receives the number of points the trajectory will have, then it receives a set of points given
	 * in cutting order, by the user. And finally it will print the total length of the cut using decimal format.	
	 * @param args Not specified.  
	 */
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Point[] p = new Point[n];
		for(int i = 0; i < n; i++)
			p[i] = new Point(sc.nextInt(), sc.nextInt());
		sc.close();

		CuttingMachine cm = new CuttingMachine(p);
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println(df.format(cm.cutLength()));
	}
}