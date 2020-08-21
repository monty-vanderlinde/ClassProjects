
import java.util.Random;

/**
 *
 * @author Monty Vanderlinde
 * @version 14 September 2017
 * 
 * An array of generic objects that can be created, accessed, and modified with
 * methods.  Implements the Bag interface.
 * @param <T> A generic object to be stored in ArrayBag
 * 
 */
public class ArrayBag<T> implements Bag<T>
{
    private T[] list;
    private int count;
    private static final Random RAND = new Random();
    
    /**
     * Default Constructor:<BR>
     * Creates a generic array with an initial capacity of 50.
     */
    public ArrayBag()
    {
        this.list = (T[]) new Object[50];
        this.count = 0;
    }
    /**
     * Overloaded Constructor:<BR>
     * Creates a generic array with an initial capacity of <B>capacity</B>.
     * @param capacity The initial capacity of the array.
     */
    public ArrayBag(int capacity)
    {
        this.list = (T[]) new Object[capacity];
        this.count = 0;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns the current size of the bag array.
     * @return The current size of the bag array. (int) 
     */
    @Override
    public int getCurrentSize()
    {
        return this.count;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns true if the bag array is empty, and false if it is not.
     * @return Is the bag array empty? (boolean) 
     */
    @Override
    public boolean isEmpty()
    {
        return this.count == 0;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns true if the bag array is full, and false if it is not.
     * @return Is the bag array full? (boolean)
     */
    @Override
    public boolean isFull()
    {
        return this.count == this.list.length;
    }
    
    /**
     * Mutator Method:<BR>
     * Adds a new generic object to the end of the array and returns true if
     * successful.
     * @param item The item to add to the end of the array.
     * @return Returns true if the item was successfully added to the bag. (boolean)
     */
    @Override
    public boolean add(T item)
    {
        if(isFull())
        {
            T[] temp = (T[]) new Object[2 * this.list.length];
            for(int i = 0; i < this.count; i++)
                temp[i] = this.list[i];
            
            this.list = temp;
        }
        
        this.list[this.count++] = item;
        
        return true;//I cannot see any scenarios where I would not be able to add a new item.
    }
    
    /**
     * Mutator Method:<BR>
     * Removes a random item from the bag array and returns that item.
     * @return The item removed from the bag.
     */
    @Override
    public T remove()
    {
        T temp = this.list[RAND.nextInt(this.count)];
        
        this.remove(temp);
        
        return temp;
    }
    
    /**
     * Mutator Method:<BR>
     * Removes a specific item from the bag array and returns ture if successful.
     * @param item The item removed from the bag.
     * @return Returns true if the item was successfully removed from the bag. (boolean)
     */
    @Override
    public boolean remove(T item)
    {
        if(isEmpty())
            return false;
        
        int index = -1;
        for(int i = 0; i < this.count; i++)
        {
            if(this.list[i].equals(item))
            {
                index = i;
                break;
            }
        }
        
        if(index == -1)
            return false;
        
        for(int i = index; i < (this.count - 1); i++)
        {
            this.list[i] = this.list[i + 1];
        }
        
        this.count--;
        
        return true;
    }
    
    /**
     * Mutator Method:<BR>
     * Removes all of the items from the bag array, making it empty.
     */
    @Override
    public void clear()
    {
        this.count = 0;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns the number of occurrences of of <B>item</B> in the bag array.
     * @param item The item to find the occurrences of in the bag array.
     * @return The number of occurrences of of <B>item</B> in the bag array. (int)
     */
    @Override
    public int getFrequencyOf(T item)
    {
        int frequency = 0;
        for(int i = 0; i < this.count; i++)
        {
            if(this.list[i].equals(item))
                frequency++;
        }
        
        return frequency;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns true if <B>item</B> occurs in the bag array at least once, or
     * false if not.
     * @param item The item to check if the bag array contains.
     * @return Is <B>item</B> contained in the bag array? (boolean)
     */
    @Override
    public boolean contains(T item)
    {
        for(int i = 0; i < this.count; i++)
        {
            if(this.list[i].equals(item))
                return true;
        }
        
        return false;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns the item at the specified index position.
     * @param index The index of the item to be returned.
     * @return The item at the specified index.
     * @throws ArrayIndexOutOfBoundsException Exception is thrown if the <B>index</B> is negative or greater than or equal to the array size.
     */
    public T get(int index) throws ArrayIndexOutOfBoundsException
    {
        if(index < 0 || index >= this.count)
        {
            throw new ArrayIndexOutOfBoundsException("The index supplied to the"
                    + " \"get\" method of the ArrayBag class is out of bounds.");
        }
        
        return this.list[index];
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
        String s = getClass().getName() + ";  Count:  " + this.count + ";";
        for(int i = 0; i < this.count; i++)
        {
            s += ("  Index " + i + ":  " + this.list[i].toString() + ";");
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
        if(!(o instanceof ArrayBag))
            return false;
        
        ArrayBag a = (ArrayBag)o;
        
        if(a.getCurrentSize() != this.getCurrentSize())
            return false;
        
        for(int i = 0; i < a.getCurrentSize(); i++)
        {
            if(!(a.get(i).equals(this.get(i))))
                return false;
        }
        
        return true;
    }
}