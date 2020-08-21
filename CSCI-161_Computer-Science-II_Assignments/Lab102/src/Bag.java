/**
 * 
 * @author Monty Vanderlinde
 * @version 06 September 2017
 * 
 * A basic interface outline with methods for the Score class.
 * 
 */
public abstract interface Bag
{
    /**
     * Accessor Method:<BR>
     * Returns the current size of the bag array.
     * @return The current size of the bag array. (int)
     */
    public abstract int getCurrentSize();
    
    /**
     * Accessor Method:<BR>
     * Returns true if the bag array is empty, and false if it is not.
     * @return Is the bag array empty? (boolean)
     */
    public abstract boolean isEmpty();
    
    /**
     * Mutator Method:<BR>
     * Adds a new whole number to the end of the array.
     * @param num The number to add to the end of the array.
     */
    public abstract void add(int num);
    
    /**
     * Mutator Method:<BR>
     * Removes the first instance of the number <B>num</B> in the bag array.
     * @param num The number to be removed from the bag array.
     */
    public abstract void remove(int num);
    
    /**
     * Mutator Method:<BR>
     * Removes a random number from the bag array.
     */
    public abstract void remove();
    
    /**
     * Mutator Method:<BR>
     * Removes all of the numbers from the bag array, making it empty.
     */
    public abstract void clear();
    
    /**
     * Accessor Method:<BR>
     * Returns the number of occurrences of of <B>num</B> in the bag array.
     * @param num The number to find the occurrences of in the bag array.
     * @return The number of occurrences of of <B>num</B> in the bag array. (int)
     */
    public abstract int getFrequencyOf(int num);
    
    /**
     * Accessor Method:<BR>
     * Returns true if <B>num</B> occurs in the bag array at least once, or false if not.
     * @param num The number to check if the bag array contains.
     * @return Is <B>num</B> contained in the bag array? (boolean)
     */
    public abstract boolean contains(int num);
    
    /**
     * toString Method:<BR>
     * Returns a string with the class name and all of the field values<BR>
     * concatenated together.
     * @return A string with the class name and field values for all fields. (String)
     */
    @Override
    public abstract String toString();
    
    /**
     * equals method:<BR>
     * Checks and returns the equality of two instances of the Bag class.
     * @param o Another Bag to compare to.
     * @return Does this object have all the same parameters as <B>o</B>. (Boolean)
     */
    @Override
    public abstract boolean equals(Object o);
}