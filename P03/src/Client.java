import java.util.Scanner;

/** The Client implements a method to be interacted. The objective is to calculate at any given configuration 
 * the minimum number of steps needed to complete a 3x3x1 rubick's cube (floppy cube), using 
 * a God's algorithm. 
 * 
 * @author Andre Pedro
 * @author Ricardo Reais
 * @author Vasco Carvalho
 * @see TCube
 * @see Solvable
 * @see Algorithm
 * @version 1.0
 * @since 10/12/2016
 */
public class Client
{
	/**
	 * This client receives 5 rows. The first row has 3 characters. The second, third and fourth
	 * rows have 8 characters. The fifth row also has 3 characters.
	 * These rows, specify the cube configuration.
	 * The given characters represent the color (ex: O for orange, G for green, etc...) 
	 * The solved configuration can be:
	 * GGG
	 * WWWOYYYR
	 * WWWOYYYR
	 * WWWOYYYR
	 * BBB
	 * 
	 * @param args Not specified.  
	 */
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next() + "00000" + sc.next() + sc.next() + sc.next() + sc.next() + "00000";
		sc.close();
		
		TCube tc = new TCube(s);
		Algorithm a = new Algorithm(tc);
		System.out.println(a.getMinSteps());
	}
}
