
import java.util.Random;

/**
 * 
 * @author Monty Vanderlinde
 * @version 06 September 201\
 * 
 * An array of scores that can be created, accessed, and modified with methods.<BR>
 * Implements the Bag interface.
 * 
 */
public class Scores implements Bag
{
    private int[] list;
    private int count;
    private static final Random RAND = new Random();
    
    /**
     * Constructor:<BR>
     * Creates a new scores object with an empty list that is 50 elements long.
     */
    public Scores()
    {
        this.list = new int[50];
        this.count = 0;
    }
    
    /**
     * Overloaded Constructor:<BR>
     * Creates a new scores object with an empty list that is arrayLenght elements long.
     * @param arrayLength The length of the new list.
     */
    public Scores(int arrayLength)
    {
        this.list = new int[arrayLength];
        this.count = 0;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns the current size of the scores array.
     * @return The current size of the scores array. (int)
     */
    @Override
    public int getCurrentSize()
    {
        return this.count;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns true if the scores array is empty, and false if it is not.
     * @return Is the scores array empty? (boolean)
     */
    @Override
    public boolean isEmpty()
    {
        return this.count == 0;
    }
    
    /**
     * Mutator Method:<BR>
     * Adds a new whole number to the end of the array.
     * @param num The number to add to the end of the array.
     */
    @Override
    public void add(int num)
    {
        if(this.count == this.list.length)
        {
            int[] temp = new int[2 * this.list.length];
            for(int i = 0; i < this.count; i++)
                temp[i] = this.list[i];
            
            this.list = temp;
            temp = null;
        }
        
        this.list[this.count++] = num;
    }
    
    /**
     * Mutator Method:<BR>
     * Removes the first instance of the number <B>num</B> in the scores array.
     * @param num The number to be removed from the scores array.
     */
    @Override
    public void remove(int num)
    {
        int index = -1;
        for(int i = 0; i < this.count; i++)
        {
            if(this.list[i] == num)
            {
                index = i;
                break;
            }
        }
        
        if(index == -1)
            return;
        
        for(int i = index; i < (this.count - 1); i++)
        {
            this.list[i] = this.list[i + 1];
        }
        
        this.count--;
    }
    
    /**
     * Mutator Method:<BR>
     * Removes a random number from the scores array.
     */
    @Override
    public void remove()
    {
        this.remove(this.list[RAND.nextInt(this.count)]);
    }
    
    /**
     * Mutator Method:<BR>
     * Removes all of the numbers from the scores array, making it empty.
     */
    @Override
    public void clear()
    {
        this.count = 0;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns the number of occurrences of of <B>num</B> in the scores array.
     * @param num The number to find the occurrences of in the scores array.
     * @return The number of occurrences of of <B>num</B> in the scores array. (int)
     */
    @Override
    public int getFrequencyOf(int num)
    {
        int frequency = 0;
        for(int i = 0; i < this.count; i++)
        {
            if(this.list[i] == num)
                frequency++;
        }
        
        return frequency;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns true if <B>num</B> occurs in the scores array at least once, or false if not.
     * @param num The number to check if the scores array contains.
     * @return Is <B>num</B> contained in the scores array? (boolean)
     */
    @Override
    public boolean contains(int num)
    {
        for(int i = 0; i < this.count; i++)
        {
            if(this.list[i] == num)
                return true;
        }
        
        return false;
    }
    
    public int get(int index) throws ArrayIndexOutOfBoundsException
    {
        if(index < 0 || index >= this.count)
        {
            throw new ArrayIndexOutOfBoundsException("The index supplied to the"
                    + " \"get\" method of the Scores class is out of bounds.");
        }
        
        return this.list[index];
    }
    
    /**
     * toString Method:<BR>
     * Returns a string with the class name and all of the field values<BR>
     * concatenated together.
     * @return A string with the class name and field values for all fields. (String)
     */
    @Override
    public String toString()
    {
        String s = getClass().getName() + ";  Count:  " + this.count + ";";
        for(int i = 0; i < this.count; i++)
        {
            s += ("  Index " + i + ":  " + this.list[i] + ";");
        }
        return s;
    }
    
    /**
     * equals method:<BR>
     * Checks and returns the equality of two instances of the scores class.
     * @param o Another scores to compare to.
     * @return Does this object have all the same parameters as <B>o</B>. (Boolean)
     */
    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof Scores))
            return false;
        
        Scores s = (Scores)o;
        
        if(s.getCurrentSize() != this.getCurrentSize())
            return false;
        
        for(int i = 0; i < s.getCurrentSize(); i++)
        {
            if(s.get(i) != this.get(i))
                return false;
        }
        
        return true;
    }
}