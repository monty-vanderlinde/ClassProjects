/**
 *
 * @author Monty Vanderlinde
 * @version 22 November 2017
 * 
 * A comparator for Student first names.
 * 
 */
public class FirstNameComparator implements Comparator<Student>
{
    //will the comparator compare in the standard order or reverse order.
    private boolean isReversed;
    
    /**
     * The Default constructor that defaults to the standard order.
     */
    public FirstNameComparator()
    {
        this(false);
    }
    
    /**
     * The Overloaded constructor that can have the order specified.
     * @param isReversed Are the objects compared in reverse order.
     */
    public FirstNameComparator(boolean isReversed)
    {
        this.isReversed = isReversed;
    }
    
    /**
     * A method for comparing the first names of two student objects.
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
        String s1FirstName = s1.getFirstName(), s2FirstName = s2.getFirstName();
        
        //determine the shortest string and how long it is
        if(s1FirstName.length() == s2FirstName.length())
        {
            shortestLenght = s1FirstName.length();
        }
        else if(s1FirstName.length() < s2FirstName.length())
        {
            shortestLenght = s1FirstName.length();
            isFirstShortest = true;
        }
        else //s1.length() > s2.length()
        {
            shortestLenght = s2FirstName.length();
            isSecondShortest = true;
        }
        
        //for the length of the shortest name
        for(int i = 0; i < shortestLenght; i++)
        {
            //if the chars are equal, conintue to next run
            if(s1FirstName.charAt(i) == s2FirstName.charAt(i))
                continue;
            
            //'a' is considered greater than 'b' and so on
            if(s1FirstName.charAt(i) > s2FirstName.charAt(i))
                returnValue = 1;
            
            if(s1FirstName.charAt(i) < s2FirstName.charAt(i))
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