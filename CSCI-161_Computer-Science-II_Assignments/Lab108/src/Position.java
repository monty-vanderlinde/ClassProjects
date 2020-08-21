/**
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @author (modified by) Monty Vanderlinde
 * 
 * @version 15 October 2017
 * 
 * An interface for a position of a general object.
 * 
 * @param <T> A generic object located at the position.
 * 
 */
public interface Position<T>
{
    public T getElement() throws IllegalStateException;
}