import java.util.List;

/**
 * The interface Solvable, should be implemented by a class that is solvable, has multiple
 * configurations and steps.
 * 
 * @author Andre Pedro
 * @author Ricardo Reais
 * @author Vasco Carvalho
 * @version 1.0
 * @since 10/12/2016
 */
public interface Solvable
{
	public List <Solvable> getSuccessors();
	boolean isSolved();
	int getStep();
}