/**
 *
 * @author Monty Vanderlinde
 * @version 14 September 2017
 * @param <T> A generic object to be stored in the bag.
 * 
 * A generic bag interface for storing objects.
 * 
 */
public interface Bag<T>
{
    /**
     * Accessor Method:<BR>
     * Returns the current size of the bag array.
     * @return The current size of the bag array. (int) 
     */
    public int getCurrentSize();
    
    /**
     * Accessor Method:<BR>
     * Returns true if the bag array is empty, and false if it is not.
     * @return Is the bag array empty? (boolean) 
     */
    public boolean isEmpty();
    
    /**
     * Accessor Method:<BR>
     * Returns true if the bag array is full, and false if it is not.
     * @return Is the bag array full? (boolean)
     */
    public boolean isFull();
    
    /**
     * Mutator Method:<BR>
     * Adds a new generic object to the end of the array and returns true if
     * successful.
     * @param item The item to add to the end of the array.
     * @return Returns true if the item was successfully added to the bag. (boolean)
     */
    public boolean add(T item);
    
    /**
     * Mutator Method:<BR>
     * Removes a random item from the bag array and returns that item.
     * @return The item removed from the bag.
     */
    public T remove();
    
    /**
     * Mutator Method:<BR>
     * Removes a specific item from the bag array and returns ture if successful.
     * @param item The item removed from the bag.
     * @return Returns true if the item was successfully added to the bag. (boolean)
     */
    public boolean remove(T item);
    
    /**
     * Mutator Method:<BR>
     * Removes all of the items from the bag array, making it empty.
     */
    public void clear();
    
    /**
     * Accessor Method:<BR>
     * Returns the number of occurrences of of <B>item</B> in the bag array.
     * @param item The item to find the occurrences of in the bag array.
     * @return The number of occurrences of of <B>item</B> in the bag array. (int)
     */
    public int getFrequencyOf(T item);
    
    /**
     * Accessor Method:<BR>
     * Returns true if <B>item</B> occurs in the bag array at least once, or
     * false if not.
     * @param item The item to check if the bag array contains.
     * @return Is <B>item</B> contained in the bag array? (boolean)
     */
    public boolean contains(T item);
    
    /**
     * toString Method:<BR>
     * Returns a string with the class name and all of the field values
     * concatenated together.
     * @return A string with the class name and field values for all fields. (String)
     */
    @Override
    public String toString();
    
    /**
     * equals method:<BR>
     * Checks and returns the equality of two instances of the Bag class.
     * @param o Another Bag to compare to.
     * @return Does this object have all the same parameters as <B>o</B>? (Boolean)
     */
    @Override
    public boolean equals(Object o);
}