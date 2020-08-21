/**
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @author (modified by) Monty Vanderlinde
 * 
 * @version 15 October 2017
 * 
 * An interface for a list of positions of general objects.
 * 
 * @param <T> A generic object located in the positional list.
 * 
 */
public interface PositionalList<T>
{
    public int size();
    
    public boolean isEmpty();
    
    public Position<T> first();
    
    public Position<T> last();
    
    public Position<T> before(Position<T> p) throws IllegalArgumentException;
    
    public Position<T> after(Position<T> p) throws IllegalArgumentException;
    
    public Position<T> addFirst(T e);
    
    public Position<T> addLast(T e);
    
    public Position<T> addBefore(Position<T> p, T e) throws IllegalArgumentException;
    
    public Position<T> addAfter(Position<T> p, T e) throws IllegalArgumentException;
    
    public T set(Position<T> p, T e) throws IllegalArgumentException;
    
    public T remove(Position<T> p) throws IllegalArgumentException;
}