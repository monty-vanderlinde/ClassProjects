
import java.text.DecimalFormat;

/**
 *
 * @author Monty Vanderlinde
 * @version 22 November 2017
 * 
 * A client for testing all of the sort methods in the Sort class.
 * 
 */
public class Client
{
    public static void main(String[] args)
    {
        //create a decimal format
        DecimalFormat df = new DecimalFormat("#,##0");
        
        
        //create four arrays of students:  one with 1,000,000, one with 100,000, and a copy verson of both
        Student[] large = new Student[1000000], largeCopy = new Student[1000000];
        Student[] small = new Student[100000], smallCopy = new Student[100000];
        
        //for recording times
        long startTime, totalTime;
        
        //Comparators
        FirstNameComparator fnc = new FirstNameComparator();
        LastNameComparator lnc = new LastNameComparator();
        IDComparator idc = new IDComparator();
        StandingComparator sc = new StandingComparator();
        GPAComparator gpac = new GPAComparator();
        
        //fill the larger one with new students
        for(int i = 0; i < large.length; i++)
            large[i] = new Student();
        
        //fill the smaller one with the first 100,000 students from the larger one
        for(int i = 0; i < small.length; i++)
            small[i] = large[i];
        
        //print top of columns
        System.out.println("+--------------+--------------+--------------+");
        System.out.println("|    Sorts     |       N      |     Time     |");
        System.out.println("+--------------+--------------+--------------+");
        
        //merge sort
        //fill the large copy with all of the same students as the original
        for(int i = 0; i < large.length; i++)
            largeCopy[i] = large[i];
        
        //set comparators to proper order
        idc.setIsReversed(false);
        
        //get the start time
        startTime = System.currentTimeMillis();
        
        //sort the copy array on id, ascending
        Sort.mergeSort(largeCopy, idc);
        
        //get the total time
        totalTime = System.currentTimeMillis() - startTime;
        
        //print out the formatted times and numbers
        System.out.format("|  %-12s|%12s  |%7s msec  |%n", "Merge", df.format(largeCopy.length), df.format(totalTime));
        System.out.println("+--------------+--------------+--------------+");
        
        //quick sort
        //fill the large copy with all of the same students as the original
        for(int i = 0; i < large.length; i++)
            largeCopy[i] = large[i];
        
        //set comparators to proper order
        gpac.setIsReversed(true);
        
        //get the start time
        startTime = System.currentTimeMillis();
        
        //sort the copy array on gpa, ascending
        Sort.quickSort(largeCopy, gpac);
        
        //get the total time
        totalTime = System.currentTimeMillis() - startTime;
        
        //print out the formatted times and numbers
        System.out.format("|  %-12s|%12s  |%7s msec  |%n", "Quick", df.format(largeCopy.length), df.format(totalTime));
        System.out.println("+--------------+--------------+--------------+");
        
        //simple bubble sort
        //fill the small copy with all of the same students as the original
        for(int i = 0; i < small.length; i++)
            smallCopy[i] = small[i];
        
        //set comparators to proper order
        idc.setIsReversed(true);
        
        //get the start time
        startTime = System.currentTimeMillis();
        
        //sort the copy array on id, descending
        Sort.simpleBubbleSort(smallCopy, idc);
        
        //get the total time
        totalTime = System.currentTimeMillis() - startTime;
        
        //print out the formatted times and numbers
        System.out.format("|  %-12s|%12s  |%7s msec  |%n", "Bubble", df.format(smallCopy.length), df.format(totalTime));
        System.out.println("+--------------+--------------+--------------+");
        
        //insertion sort
        //fill the small copy with all of the same students as the original
        for(int i = 0; i < small.length; i++)
            smallCopy[i] = small[i];
        
        //set comparators to proper order
        gpac.setIsReversed(false);
        
        //get the start time
        startTime = System.currentTimeMillis();
        
        //sort the copy array on gpa, descending
        Sort.insertionSort(smallCopy, gpac);
        
        //get the total time
        totalTime = System.currentTimeMillis() - startTime;
        
        //print out the formatted times and numbers
        System.out.format("|  %-12s|%12s  |%7s msec  |%n", "Insertion", df.format(smallCopy.length), df.format(totalTime));
        System.out.println("+--------------+--------------+--------------+");
        
        //selection sort
        //fill the small copy with all of the same students as the original
        for(int i = 0; i < small.length; i++)
            smallCopy[i] = small[i];
        
        //set comparators to proper order
        sc.setIsReversed(false);
        
        //get the start time
        startTime = System.currentTimeMillis();
        
        //sort the copy array on standing, descending from senior to freshman
        Sort.selectionSort(smallCopy, sc);
        
        //get the total time
        totalTime = System.currentTimeMillis() - startTime;
        
        //print out the formatted times and numbers
        System.out.format("|  %-12s|%12s  |%7s msec  |%n", "Selection", df.format(smallCopy.length), df.format(totalTime));
        System.out.println("+--------------+--------------+--------------+");
        
        //radix sort
        //fill the large copy with all of the same students as the original
        for(int i = 0; i < large.length; i++)
            largeCopy[i] = large[i];
        
        //set comparators to proper order
        fnc.setIsReversed(false);
        lnc.setIsReversed(false);
        idc.setIsReversed(true);
        sc.setIsReversed(false);
        gpac.setIsReversed(true);
        
        //get the start time
        startTime = System.currentTimeMillis();
        
        //sort the copy array on:
        //standing, descending order from senior to freshman
        //gpa, descending numberical order
        //last name, ascending alphabetical order
        //first name, ascending alphabetical order
        //id, ascending numerical order
        Sort.radixSort(largeCopy, sc, gpac, lnc, fnc, idc);
        
        //get the total time
        totalTime = System.currentTimeMillis() - startTime;
        
        //print out the formatted times and numbers
        System.out.format("|  %-12s|%12s  |%7s msec  |%n", "Radix", df.format(largeCopy.length), df.format(totalTime));
        System.out.println("+--------------+--------------+--------------+");
    }
}