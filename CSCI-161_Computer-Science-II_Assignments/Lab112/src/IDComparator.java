/**
 *
 * @author Monty Vanderlinde
 * @version 22 November 2017
 * 
 * A comparator for Student IDs.
 * 
 */
public class IDComparator implements Comparator<Student>
{
    //will the comparator compare in the standard order or reverse order.
    private boolean isReversed;
    
    /**
     * The Default constructor that defaults to the standard order.
     */
    public IDComparator()
    {
        this(false);
    }
    
    /**
     * The Overloaded constructor that can have the order specified.
     * @param isReversed Are the objects compared in reverse order.
     */
    public IDComparator(boolean isReversed)
    {
        this.isReversed = isReversed;
    }
    
    /**
     * A method for comparing the IDs of two student objects.
     * Returns 1 if t1 is greater than t2, 0 if t1 equals t2, or -1 if t1 is less than t2.
     * @param s1 The first student object to compare.
     * @param s2 The second student object to compare.
     * @return Returns 1 if t1 is greater than t2, 0 if t1 equals t2, or -1 if t1 is less than t2.
     */
    @Override
    public int compare(Student s1, Student s2)
    {
        int returnValue;
        
        if(s1.getID() < s2.getID())  //1 if s2 is greater
            returnValue = 1;
        else if(s1.getID() > s2.getID())  //-1 if s1 is greater
            returnValue = -1;
        else  //0 if they are equal
            returnValue = 0;
        
        //change the order if it is reversed
        if(this.isReversed)
            returnValue *= -1;
        
        return returnValue;
    }
    
    /**
     * Accessor method to access if this comparator is currently reversed.
     * @return Is this comparator currently reversed?
     */
    public boolean getIsReversed()
    {
        return this.isReversed;
    }
    
    /**
     * Mutator to set whether this comparator is currently reversed.
     * @param isReversed Is this comparator reversed?
     */
    public void setIsReversed(boolean isReversed)
    {
        this.isReversed = isReversed;
    }
}