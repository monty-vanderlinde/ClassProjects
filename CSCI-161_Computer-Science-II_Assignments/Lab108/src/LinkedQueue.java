/**
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @author (modified by) Monty Vanderlinde
 * 
 * @version 05 October 2017
 * 
 * A queue that implements a singly linked list as the storage structure;
 * 
 * @param <T> A generic object to add to the singly linked list.
 * 
 */
public class LinkedQueue<T> implements Queue<T>
{
    private SinglyLinkedList<T> list = new SinglyLinkedList<>();
    
    public LinkedQueue(){}
    
    @Override
    public int size()
    {
        return this.list.size();
    }
    
    @Override
    public boolean isEmpty()
    {
        return this.list.isEmpty();
    }
    
    @Override
    public void enqueue(T element)
    {
        this.list.addLast(element);
    }
    
    @Override
    public T first()
    {
        return this.list.first();
    }
    
    @Override
    public T dequeue()
    {
        return this.list.removeFirst();
    }
}