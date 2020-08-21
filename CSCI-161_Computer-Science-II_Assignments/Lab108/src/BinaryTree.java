/**
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @author (modified by) Monty Vanderlinde
 * 
 * @version 15 October 2017
 * 
 * An interface for creating an binary tree of general objects.
 * 
 * @param <T> A general object to store in the binary tree.
 * 
 */
public interface BinaryTree<T> extends Tree<T>
{
    public Position<T> left(Position<T> p) throws IllegalArgumentException;
    
    public Position<T> right(Position<T> p) throws IllegalArgumentException;
    
    public Position<T> sibling(Position<T> p) throws IllegalArgumentException;
}