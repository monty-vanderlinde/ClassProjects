
import java.util.NoSuchElementException;

/**
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @author (modified by) Monty Vanderlinde
 * 
 * @version 15 October 2017
 * 
 * An interface for an iterator of general objects in a sequence.
 * 
 * @param <T> A generic object to iterate through in a sequence.
 * 
 */
public interface Iterator<T>
{
    public boolean hasNext();
    
    public T next() throws NoSuchElementException;
    
    public void remove() throws IllegalStateException;
}