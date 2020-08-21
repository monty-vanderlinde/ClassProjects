/**
 *
 * @author Monty Vanderlinde
 * @version 22 November 2017
 * 
 * A comparator for Student last names.
 * 
 */
public class LastNameComparator implements Comparator<Student>
{
    //will the comparator compare in the standard order or reverse order.
    private boolean isReversed;
    
    /**
     * The Default constructor that defaults to the standard order.
     */
    public LastNameComparator()
    {
        this(false);
    }
    
    /**
     * The Overloaded constructor that can have the order specified.
     * @param isReversed Are the objects compared in reverse order.
     */
    public LastNameComparator(boolean isReversed)
    {
        this.isReversed = isReversed;
    }
    
    /**
     * A method for comparing the last names of two student objects.
     * Returns 1 if t1 is greater than t2, 0 if t1 equals t2, or -1 if t1 is less than t2.
     * @param s1 The first student object to compare.
     * @param s2 The second student object to compare.
     * @return Returns 1 if t1 is greater than t2, 0 if t1 equals t2, or -1 if t1 is less than t2.
     */
    @Override
    public int compare(Student s1, Student s2)
    {
        boolean isFirstShortest = false, isSecondShortest = false;
        int shortestLenght, returnValue = 0;
        String s1LastName = s1.getLastName(), s2LastName = s2.getLastName();
        
        //determine the shortest string and how long it is
        if(s1LastName.length() == s2LastName.length())
        {
            shortestLenght = s1LastName.length();
        }
        else if(s1LastName.length() < s2LastName.length())
        {
            shortestLenght = s1LastName.length();
            isFirstShortest = true;
        }
        else //s1.length() > s2.length()
        {
            shortestLenght = s2LastName.length();
            isSecondShortest = true;
        }
        
        //for the length of the shortest name
        for(int i = 0; i < shortestLenght; i++)
        {
            if(s1LastName.charAt(i) == s2LastName.charAt(i))
                continue;
            
            //I want 'a' to be considered greater than 'b' and so on
            if(s1LastName.charAt(i) > s2LastName.charAt(i))
                returnValue = 1;
            
            if(s1LastName.charAt(i) < s2LastName.charAt(i))
                returnValue = -1;
            
            break;
        }
        
        //if they are not the same length, then the shorter one is considered greater
        if(returnValue == 0)
        {
            //spaces will be considered greater than letters
            if(isFirstShortest)
                returnValue = -1;
            
            if(isSecondShortest)
                returnValue = 1;
        }
        
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