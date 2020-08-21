/**
 *
 * @author Monty Vanderlinde
 * @version 27 October 2017
 * 
 * A class for hashing a string with the cyclic shift hash code.
 * 
 */
public class CyclicShift
{
    /**
     * The cyclic shift program from the book.
     * @param s The string to get the hash code of.
     * @return The cyclic shift hash code of <B>s</B>.
     */
    public static int getCyclicShift(String s)
    {
        int h = 0, j = s.length();
        
        for(int i = 0; i < j; i++)
        {
            h = (h << 5) | (h >>> 27);
            h += (int) s.charAt(i);
        }
        
        return h;
    }
    
    /**
     * The verbose version of the cyclic shift program from the book.
     * @param s The string to get the hash code of.
     * @return A string of the verbose cyclic shift hash code of <B>s</B>.
     */
    public static String getVerboseCyclicShift(String s)
    {
        String temp = "Creating cyclic shift hashCode for \"" + s + "\":\n\n";
        
        int t1, t2, h = 0, j = s.length();
        
        //for all the characters in s, print out the cyclic shift hashCode process
        for(int i = 0; i < j; i++)
        {
            temp += "Pass " + i + ":\n\n";
            
            temp += "Starting hashCode:\t\t\t" + intToBinaryString(h) + "\n\n";
            
            t1 = h << 5;
            
            temp += "hashCode << 5:\t\t\t\t" + intToBinaryString(t1) + "\n";
            
            t2 = h >>> 27;
            
            temp += "hashCode >>> 27:\t\t\t" + intToBinaryString(t2) + "\n";
            
            h = t1 | t2;
            
            temp += "hashCode << 5 | hashCode >>> 27:\t" + intToBinaryString(h) + "\n\n";
            
            char c = s.charAt(i);
            
            temp +="Adding character " + c + ":\t\t\t" + intToBinaryString((int) c) + "\n\n";
            
            h += (int) c;
            
            temp += "Final hashCode:\t\t\t\t" + intToBinaryString(h);
            
            if(i < (j - 1))
                temp += "\n\n\n";
        }
        
        temp += "\n\nComplete hashCode for \"" + s + "\":\t\t" + intToBinaryString(h);
        
        return temp;
    }
    
    /**
     * Mutator Method:<BR>
     * Returns a string of the 32 bit version of the int, <B>n</B>.
     * @param n The number to get the 32 bit version of.
     * @return The string version of the 32 bit version of <B>n</B>.
     */
    public static String intToBinaryString(int n)
    {
        //toBinaryString prints out all the digits of negative numbers
        if(n < 0)
            return Integer.toBinaryString(n);
        //toBinaryString does not necessarily print out all the digits of positive numbers
        else
        {
            //get a string of the bit version of n, but does not have leading zeros
            String s = Integer.toBinaryString(n);
            
            //number of zeros that need to be added
            int j = 32 - s.length();
            
            //add the appropriate number of zeros to the front
            for(int i = 0; i < j; i++)
                s = "0" + s;
            
            return s;
        }
    }
}