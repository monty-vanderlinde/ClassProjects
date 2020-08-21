
import java.util.Random;

/**
 *
 * @author Monty Vanderlinde
 * @version 14 September 2017
 * 
 * A linked list of generic objects that can be created, accessed, and modified
 * with methods.  Implements the Bag interface.
 * @param <T> A generic object to be stored in LinkedBag
 * 
 */
public class LinkedBag<T> implements Bag<T>
{
    private SinglyLinkedList<T> list;
    private int count;
    private final static Random RAND = new Random();
    
    /**
     * Default Constructor:<BR>
     * Creates a new LinkedBag with an empty singly linked list.
     */
    public LinkedBag()
    {
        this.list = new SinglyLinkedList<>();
        this.count = 0;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns the current size of the bag list.
     * @return The current size of the bag list. (int) 
     */
    @Override
    public int getCurrentSize()
    {
        return this.count;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns true if the bag list is empty, and false if it is not.
     * @return Is the bag list empty? (boolean) 
     */
    @Override
    public boolean isEmpty()
    {
        return (this.count == 0);
    }
    
    /**
     * Accessor Method:<BR>
     * Returns false, since a linked list (theoretically) does not have a
     * maximum capacity.
     * @return Is the bag list full? (boolean)
     */
    @Override
    public boolean isFull()
    {
        return false;
    }
    
    /**
     * Mutator Method:<BR>
     * Adds a new generic object to the end of the list and returns true if
     * successful.
     * @param item The item to add to the end of the list.
     * @return Returns true if the item was successfully added to the bag. (boolean)
     */
    @Override
    public boolean add(T item)
    {
        this.list.addLast(item);
        this.count++;
        return true;//should work for any object reference, including null, passed to the method
    }
    
    /**
     * Mutator Method:<BR>
     * Removes a random item from the bag list and returns that item.
     * @return The item removed from the bag.
     */
    @Override
    public T remove()
    {
        this.count--;
        return this.list.remove(RAND.nextInt(this.list.size()));
    }
    
    /**
     * Mutator Method:<BR>
     * Removes a specific item from the bag list and returns ture if successful.
     * @param item The item removed from the bag.
     * @return Returns true if the item was successfully removed from the bag. (boolean)
     */
    @Override
    public boolean remove(T item)
    {
        for(int i = 0; i < this.list.size(); i++)
        {
            if(this.list.get(i).equals(item))
            {
                this.list.remove(i);
                this.count--;
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Mutator Method:<BR>
     * Removes all of the items from the bag list, making it empty.
     */
    @Override
    public void clear()
    {
        while(!(this.list.isEmpty()))
        {
            this.list.remove(0);
        }
        
        this.count = 0;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns the number of occurrences of of <B>item</B> in the bag list.
     * @param item The item to find the occurrences of in the bag list.
     * @return The number of occurrences of of <B>item</B> in the bag list. (int)
     */
    @Override
    public int getFrequencyOf(T item)
    {
        int frequency = 0;
        
        for(int i = 0; i < this.list.size(); i++)
        {
            if(this.list.get(i).equals(item))
                frequency++;
        }
        
        return frequency;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns true if <B>item</B> occurs in the bag list at least once, or
     * false if not.
     * @param item The item to check if the bag list contains.
     * @return Is <B>item</B> contained in the bag list? (boolean)
     */
    @Override
    public boolean contains(T item)
    {
        for(int i = 0; i < this.list.size(); i++)
        {
            if(this.list.get(i).equals(item))
                return true;
        }
        
        return false;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns the item at the specified index position.
     * @param index The index of the item to be returned.
     * @return The item at the specified index.
     * @throws IndexOutOfBoundsException Exception is thrown if the <B>index</B> is negative or greater than or equal to the list size.
     */
    public T get(int index) throws IndexOutOfBoundsException
    {
        if(index < 0 || index >= this.count)
        {
            throw new IndexOutOfBoundsException("The index supplied to the"
                    + " \"get\" method of the LinkedBag class is out of bounds.");
        }
        
        return this.list.get(index);
    }
    
    /**
     * toString Method:<BR>
     * Returns a string with the class name and all of the field values
     * concatenated together.
     * @return A string with the class name and field values for all fields. (String)
     */
    @Override
    public String toString()
    {
        String s = getClass().getName() + ":\nCount:  " + this.count + "\n";
        for(int i = 0; i < this.count; i++)
        {
            s += ("\nIndex " + i + ":\n" + this.list.get(i).toString() + "\n");
        }
        return s;
    }
    
    /**
     * equals method:<BR>
     * Checks and returns the equality of two instances of the Bag class.
     * @param o Another Bag to compare to.
     * @return Does this object have all the same parameters as <B>o</B>? (Boolean)
     */
    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof LinkedBag))
            return false;
        
        LinkedBag l = (LinkedBag) o;
        
        if(this.count != l.count)
            return false;
        
        for(int i = 0; i < this.count; i++)
        {
            if(!(this.list.get(i).equals(l.list.get(i))))
                return false;
        }
        
        return true;
    }
}