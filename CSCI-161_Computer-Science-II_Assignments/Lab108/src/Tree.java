
import java.util.Iterator;

/**
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @author (modified by) Monty Vanderlinde
 * 
 * @version 15 October 2017
 * 
 * An interface for creating an tree of general objects.
 * 
 * @param <T> A general object to store in the tree.
 * 
 */
public interface Tree<T> extends Iterable<T>
{
    public Position<T> root();
    
    public Position<T> parent(Position<T> p) throws IllegalArgumentException;
    
    public Iterable<Position<T>> children(Position<T> p) throws IllegalArgumentException;
    
    public int numChildren(Position<T> p) throws IllegalArgumentException;
    
    public boolean isInternal(Position<T> p) throws IllegalArgumentException;
    
    public boolean isExternal(Position<T> p) throws IllegalArgumentException;
    
    public boolean isRoot(Position<T> p) throws IllegalArgumentException;
    
    public int size();
    
    public boolean isEmpty();
    
    /**
     * Iterator Method:<BR>
     * Returns an iterator of the elements of the tree. 
     * The iterator will be pre-order, in-order, post-order, or breadth-first for an <B>n</B> value of 1, 2, 3, or 4 respectively.
     * @param n Sets the iterator to be pre-order, in-order, post-order, or breadth-first for a value of 1, 2, 3, or 4 respectively.
     * @return An iterator for the elements of the tree in the specified order.
     */
    public Iterator<T> iterator(int n);
    
    /**
     * Iterator Method:<BR>
     * Returns an iterator of the positions of the tree.
     * The iterator will be pre-order, in-order, post-order, or breadth-first for an <B>n</B> value of 1, 2, 3, or 4 respectively.
     * @param n Sets the iterator to be pre-order, in-order, post-order, or breadth-first for a value of 1, 2, 3, or 4 respectively.
     * @return An iterator for the positions of the tree in the specified order.
     * @throws IllegalArgumentException If n is not a 1, 2, 3, or 4.
     */
    public Iterable<Position<T>> positions(int n) throws IllegalArgumentException;
}