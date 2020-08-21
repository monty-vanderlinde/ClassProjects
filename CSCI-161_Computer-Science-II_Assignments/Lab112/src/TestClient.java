
import java.text.DecimalFormat;

/**
 *
 * @author Monty Vanderlinde
 * @version 22 November 2017
 * 
 * A test client for testing the sorting and comparators.
 * 
 */
public class TestClient
{
    public static void main(String[] args)
    {
        //create an array of 1,000 students
        Student[] s = new Student[1000];
        
        //for formatting the output
        DecimalFormat df1 = new DecimalFormat("0.00");
        DecimalFormat df2 = new DecimalFormat("0000000");
        
        //Comparators
        FirstNameComparator fnc = new FirstNameComparator();
        LastNameComparator lnc = new LastNameComparator();
        IDComparator idc = new IDComparator();
        StandingComparator sc = new StandingComparator();
        GPAComparator gpac = new GPAComparator();
        
        //set comparators to proper order
        fnc.setIsReversed(false);
        lnc.setIsReversed(false);
        idc.setIsReversed(true);
        sc.setIsReversed(false);
        gpac.setIsReversed(true);
        
        //fill array with new students
        for(int i = 0; i < s.length; i++)
            s[i] = new Student();
        
        //sort the array according to the specifications of this assignment
        Sort.radixSort(s, sc, gpac, lnc, fnc, idc);
        
        //format and print out the sorted students to check that it works
        for(int i = 0; i < s.length; i++)
            System.out.format("%-9s %-4s %-15s %-10s %-7s%n", s[i].getStanding(), df1.format(s[i].getGPA()), s[i].getLastName(), s[i].getFirstName(), df2.format(s[i].getID()));
    }
}