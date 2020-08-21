package Queue;

/**
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * 
 * @version 05 October 2017
 * 
 * An interface for a queue of general objects.
 * 
 * @param <T> A generic object to add to the singly linked list.
 * 
 */
public interface Queue<T>
{
    public int size();
    
    public boolean isEmpty();
    
    public void enqueue(T element);
    
    public T first();
    
    public T dequeue();
}