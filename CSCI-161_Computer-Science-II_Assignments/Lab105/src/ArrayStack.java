/**
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @author (modified by) Monty Vanderlinde
 * 
 * @version 05 October 2017
 * 
 * A stack that implements an array as the storage structure;
 * 
 * @param <T> A generic object to add to the singly linked list.
 * 
 */
public class ArrayStack<T> implements Stack<T>
{
    private T[] data;
    private int topIndex = -1;
    
    public ArrayStack()
    {
        this(1000);
    }
    
    public ArrayStack(int capacity)
    {
        this.data = (T[]) new Object[capacity];
    }
    
    @Override
    public int size()
    {
        return (topIndex + 1);
    }
    
    @Override
    public boolean isEmpty()
    {
        return (topIndex == -1);
    }
    
    @Override
    public void push(T element) throws IllegalStateException
    {
        if(this.size() == this.data.length)
            throw new IllegalStateException("Stack is full");
        
        this.data[++topIndex] = element;
    }
    
    @Override
    public T top()
    {
        if(this.isEmpty())
            return null;
        
        return data[topIndex];
    }
    
    @Override
    public T pop()
    {
        if(this.isEmpty())
            return null;
        
        T answer = this.data[this.topIndex];
        
        this.data[this.topIndex--] = null;
        
        return answer;
    }
}