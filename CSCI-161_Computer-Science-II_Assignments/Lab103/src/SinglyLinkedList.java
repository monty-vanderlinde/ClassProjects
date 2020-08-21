/**
 *
 * @author Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser (modified by Monty Vanderlinde)
 * @version 14 September 2017
 * 
 * A singly linked list of general objects.
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
    
    public T getFirst()
    {
        if(isEmpty())
            return null;
        
        return this.head.getElement();
    }
    
    public T getLast()
    {
        if(this.size == 0)
            return null;
        
        return this.tail.getElement();
    }
    
    public void addFirst(T element)
    {
        Node<T> newest = new Node(element, this.head);
        
        if(this.size == 0)
            this.tail = newest;
        
        this.head = newest;
        
        size++;
    }
    
    public void addLast(T element)
    {
        Node<T> newest = new Node(element, null);
        
        if(this.size == 0)
            this.head = newest;
        else
            this.tail.setNext(newest);
        
        this.tail = newest;
        
        size++;
    }
    
    /**
     * Mutator Method:<BR>
     * Removes the node at the specified index position and returns the element
     * at that node.  The index starts at 0 and goes to the size of the list
     * minus one, just like an array.
     * @param index The position of the node to be removed.
     * @return The element at the node that was removed.
     */
    public T remove(int index)//works just like an array index
    {
        if(isEmpty())//empty list
            return null;
        
        if(index < 0 || index >= this.size)//out of bournds index
            return null;
        
        T temp;
        
        if(this.size == 1)//single element list
        {
            temp = this.head.getElement();
            
            this.head = null;
            this.tail = null;
        }
        else if(index == 0)//removing head
        {
            temp = this.head.getElement();
            
            this.head = this.head.getNext();
        }
        else if(index == (this.size - 1))//removing tail
        {
            temp = this.tail.getElement();
            
            Node<T> n = this.head;
            
            while(!(n.getNext() == this.tail))//checking if they reference the same object, so the equality operator should work.
                n = n.getNext();
            
            this.tail = n;
            n.setNext(null);
        }
        else//all middle nodes
        {
            Node<T> n = this.head;
            
            for(int i = 1; i < index; i++)//n wil be the node before the node being removed when the for loop is done.
                n = n.getNext();
            
            temp = n.getNext().getElement();
            
            n.setNext(n.getNext().getNext());
        }
        
        this.size--;
        
        return temp;
    }
    /**
     * Accessor Method:<BR>
     * Returns the element at the specified index position.
     * @param index The index of the object to be returned.
     * @return The object at the specified index position.
     */
    public T get(int index)
    {
        Node<T> n = this.head;
        
        if(index >= this.size || index < 0)
            return null;
        
        for(int i = 0; i < index; i++)
        {
            n = n.getNext();
        }
        
        return n.getElement();
    }
}