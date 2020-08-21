/**
 *
 * @author Monty Vanderlinde
 * @version 22 November 2017
 * 
 * A comparator for Student standings.
 * 
 */
public class StandingComparator implements Comparator<Student>
{
    //will the comparator compare in the standard order or reverse order.
    private boolean isReversed;
    
    /**
     * The Default constructor that defaults to the standard order.
     */
    public StandingComparator()
    {
        this(false);
    }
    
    /**
     * The Overloaded constructor that can have the order specified.
     * @param isReversed Are the objects compared in reverse order.
     */
    public StandingComparator(boolean isReversed)
    {
        this.isReversed = isReversed;
    }
    
    /**
     * A method for comparing the standings of two student objects.
     * Returns 1 if t1 is greater than t2, 0 if t1 equals t2, or -1 if t1 is less than t2.
     * @param s1 The first student object to compare.
     * @param s2 The second student object to compare.
     * @return Returns 1 if t1 is greater than t2, 0 if t1 equals t2, or -1 if t1 is less than t2.
     */
    @Override
    public int compare(Student s1, Student s2)
    {
        //initialize to make compiler happy.  Also, should never be -2 at the end
        int returnValue = -2;
        
        //seniors are greater than juniors, etc.
        switch(s1.getStanding())
        {
            case "freshman":
                switch(s2.getStanding())
                {
                    case "freshman":
                        returnValue = 0;
                        break;
                    case "sophomore":
                        returnValue = 1;
                        break;
                    case "junior":
                        returnValue = 1;
                        break;
                    case "senior":
                        returnValue = 1;
                        break;
                }
                break;
            case "sophomore":
                switch(s2.getStanding())
                {
                    case "freshman":
                        returnValue = -1;
                        break;
                    case "sophomore":
                        returnValue = 0;
                        break;
                    case "junior":
                        returnValue = 1;
                        break;
                    case "senior":
                        returnValue = 1;
                        break;
                }
                break;
            case "junior":
                switch(s2.getStanding())
                {
                    case "freshman":
                        returnValue = -1;
                        break;
                    case "sophomore":
                        returnValue = -1;
                        break;
                    case "junior":
                        returnValue = 0;
                        break;
                    case "senior":
                        returnValue = 1;
                        break;
                }
                break;
            case "senior":
                switch(s2.getStanding())
                {
                    case "freshman":
                        returnValue = -1;
                        break;
                    case "sophomore":
                        returnValue = -1;
                        break;
                    case "junior":
                        returnValue = -1;
                        break;
                    case "senior":
                        returnValue = 0;
                        break;
                }
                break;
        }
        
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