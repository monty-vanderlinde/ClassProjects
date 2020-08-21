package Queue;

/**
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @author (modified by) Monty Vanderlinde
 * 
 * @version 05 October 2017
 * 
 * A queue that implements an array as the storage structure;
 * 
 * @param <T> A generic object to add to the singly linked list.
 * 
 */
public class ArrayQueue<T> implements Queue<T>
{
    private T[] data;
    private int frontIndex = 0;
    private int size = 0;
    
    public ArrayQueue()
    {
        this(1000);
    }
    
    public ArrayQueue(int capacity)
    {
        this.data = (T[]) new Object[capacity];
    }
    
    @Override
    public int size()
    {
        return this.size;
    }
    
    @Override
    public boolean isEmpty()
    {
        return (this.size == 0);
    }
    
    @Override
    public void enqueue(T element) throws IllegalStateException
    {
        if(this.size == this.data.length)
            throw new IllegalStateException("Queue is full");
        
        int avail = (this.frontIndex + this.size) % this.data.length;
        
        this.data[avail] = element;
        this.size++;
    }
    
    @Override
    public T first()
    {
        if(this.isEmpty())
            return null;
        
        return this.data[this.frontIndex];
    }
    
    @Override
    public T dequeue()
    {
        if(this.isEmpty())
            return null;
        
        T answer = this.data[this.frontIndex];
        
        data[this.frontIndex] = null;
        
        this.frontIndex = (this.frontIndex + 1) % this.data.length;
        
        this.size--;
        
        return answer;
    }
}