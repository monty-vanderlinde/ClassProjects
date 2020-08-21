/**
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @author (modified by) Monty Vanderlinde
 * 
 * @version 15 October 2017
 * 
 * An interface for creating an iterator of general objects.
 * 
 * @param <T> A general position to start the iterator at.
 * 
 */
public interface Iterable<T>
{
    public Iterator<T> iterator();
}