/**
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @author (modified by) Monty Vanderlinde
 * 
 * @version 15 October 2017
 * 
 * An interface for a stack of general objects.
 * 
 * @param <T> A generic object to add to the singly linked list.
 * 
 */
public interface Stack<T>
{
    public int size();
    
    public boolean isEmpty();
    
    public void push(T element);
    
    public T top();
    
    public T pop();
}