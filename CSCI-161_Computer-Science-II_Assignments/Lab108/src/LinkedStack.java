/**
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @author (modified by) Monty Vanderlinde
 * 
 * @version 05 October 2017
 * 
 * A stack that implements a singly linked list as the storage structure;
 * 
 * @param <T> A generic object to add to the singly linked list.
 * 
 */
public class LinkedStack<T> implements Stack<T>
{
    private SinglyLinkedList<T> list = new SinglyLinkedList<>();
    
    public LinkedStack(){}
    
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
    public void push(T element)
    {
        this.list.addFirst(element);
    }
    
    @Override
    public T top()
    {
        return this.list.first();
    }
    
    @Override
    public T pop()
    {
        return this.list.removeFirst();
    }
}