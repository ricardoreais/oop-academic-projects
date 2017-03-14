import java.util.LinkedList;

/** 
 * The Algorithm class represents a class that will solve an algorithm in the minimum number of steps (God's algorithm).
 * 
 * @author Andre Pedro
 * @author Ricardo Reais
 * @author Vasco Carvalho
 * @see Solvable
 * @see TCube
 * @version 2.0
 * @since 10/12/2016
 */
public class Algorithm 
{
	/**
	 * The successors list contains, every possible next configuration.
	 */
	LinkedList<Solvable> successors = new LinkedList <Solvable>();
	
	/**
	 * The seen successors list contains, every configuration already seen by the algorithm.
	 */
	LinkedList<Solvable> seenSuccessors = new LinkedList <Solvable>(); 
	
	/**
	 * The constructor adds the given configuration to the list of successors.
	 * @param p Given problem to solve using the algorithm.
	 * @see #setAlgorithm(Solvable)
	 */
	public Algorithm(Solvable p)
	{
		setAlgorithm(p);
	}
	
	/**
	 * Adds the given configuration to the list of successors.
	 * @param p Given problem to solve using the algorithm.
	 */
	public void setAlgorithm(Solvable p)
	{
		successors.add(p);
	}
	
	/**
	 * Finds the minimum number of steps to achieve a desired solution, using a god's algorithm.
	 * @see Solvable#isSolved()
	 * @return Minimum number of steps required to achieve the desired solution (i.e. God's number). Returning -1 means solution not found.
	 */
	public int getMinSteps()
	{
		Solvable p;
		int result = -1;
		
		while(true)
		{
		    if (successors.isEmpty())
		    {
		    	result = -1;
		    	break;
		    }    	
		    
		    p = successors.getFirst();		    
		    successors.remove(p);
		    
		    if(!seenSuccessors.isEmpty() && seenSuccessors.contains(p))
		    	continue;
		    
		    seenSuccessors.add(p);
			
			
			if (p.isSolved())
			{
				result = p.getStep();
				break;
			}
			else
				successors.addAll(p.getSuccessors());
		}
		return result;
	}
}
