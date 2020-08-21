/**
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @author (modified by) Monty Vanderlinde
 * 
 * @version 05 October 2017
 * 
 * A singly linked list of general objects.
 * 
 * @param <T> A generic object to add to the singly linked list.
 * 
 */
public class SinglyLinkedList<T>
{
    private static class Node<T>
    {
        private T element;
        private Node<T> next;
        
        public Node(T element, Node<T> next)
        {
            this.element = element;
            this.next = next;
        }
        
        public T getElement()
        {
            return this.element;
        }
        
        public Node<T> getNext()
        {
            return this.next;
        }
        
        public void setNext(Node<T> next)
        {
            this.next = next;
        }
    }
    
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    public SinglyLinkedList()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public int size()
    {
        return this.size;
    }
    
    public boolean isEmpty()
    {
        return this.size == 0;
    }
    
    public T first()
    {
        if(this.isEmpty())
            return null;
        
        return this.head.getElement();
    }
    
    public T last()
    {
        if(this.isEmpty())
            return null;
        
        return this.tail.getElement();
    }
    
    public void addFirst(T element)
    {
        Node<T> newest = new Node(element, this.head);
        
        if(this.isEmpty())
            this.tail = newest;
        
        this.head = newest;
        
        this.size++;
    }
    
    public void addLast(T element)
    {
        Node<T> newest = new Node(element, null);
        
        if(this.isEmpty())
            this.head = newest;
        else
            this.tail.setNext(newest);
        
        this.tail = newest;
        
        size++;
    }
    
    public T removeFirst()
    {
        if(this.isEmpty())
            return null;
        
        T temp = this.head.getElement();
        
        if(this.size == 1)
        {
            this.head = null;
            this.tail = null;
        }
        else
        {
            this.head = this.head.getNext();
        }
        
        this.size--;
        
        return temp;
    }
    
    public T removeLast()
    {
        if(this.isEmpty())
            return null;
        
        T temp = this.tail.getElement();
        
        if(this.size == 1)
        {
            this.head = null;
            this.tail = null;
        }
        else
        {
            Node secondToLast = this.head;
            
            while(secondToLast.getNext() != this.tail)
                secondToLast = secondToLast.getNext();
            
            this.tail = secondToLast;
            
            this.tail.setNext(null);
            
            this.size--;
        }
        
        return temp;
    }
}