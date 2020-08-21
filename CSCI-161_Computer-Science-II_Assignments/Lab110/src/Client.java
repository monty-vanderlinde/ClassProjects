
import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 * @author Monty Vanderlinde
 * @version 03 November 2017
 * 
 * A client for testing the run times of four different sorting programs.
 * 
 */
public class Client
{
    public static void main(String[] args)
    {
        //the smallest number of elements to sort
        int minNumberOfItemsToSort = 10;
        
        //the number of sorted elements to print out.  Must be less than minNumberOfItemsToSort.
        int numberOfIntsPrinted = 5;
        
        //the largest number of elements to sort
        int maxNumberOfItemsToSort = 100000;
        
        //the multiplier by which the number of items to sort is increased
        int multiplier = 10;
        
        //used for recording and calculating program run times.
        long miliStart, miliEnd, miliTotal;
        
        //used for generating random numbers
        Random rand = new Random();
        
        //used for formatting the number output
        DecimalFormat d = new DecimalFormat("###,##0");
        
        
        //selection sort
        
        //for all the different lengths of arrays to sort
        for (int i = minNumberOfItemsToSort; i < (maxNumberOfItemsToSort + 1); i *= multiplier)
        {
            //create array of specified length
            int[] t = new int[i];
            
            //fill array with random ints
            for (int j = 0; j < i; j++)
            {
                //add number between 0 (inclusive) and i (exclusive)
                t[j] = rand.nextInt(maxNumberOfItemsToSort);
            }
            
            //formatted output
            System.out.format("%-22s%s%7s", "Selection Sort:", "N = ", d.format(i));
            
            //start time
            miliStart = System.currentTimeMillis();
            
            //sort the array
            SortingAlgorithms.selectionSort(t);
            
            //end time
            miliEnd = System.currentTimeMillis();
            
            //change in time
            miliTotal = miliEnd - miliStart;
            
            //formatted output
            System.out.format("%s%12s%s", ";  Time = ", d.format(miliTotal) + " msec", ";  Head = ");
            
            //output specified number of sorted elements.
            for(int j = 0; j < numberOfIntsPrinted; j++)
                System.out.format("%8s", d.format(t[j]));
            
            //print new line
            System.out.println();
        }
        
        
        //insertion sort
        
        //for all the different lengths of arrays to sort
        for (int i = minNumberOfItemsToSort; i < (maxNumberOfItemsToSort + 1); i *= multiplier)
        {
            //create array of specified length
            int[] t = new int[i];
            
            //fill array with random ints
            for (int j = 0; j < i; j++)
            {
                //add number between 0 (inclusive) and i (exclusive)
                t[j] = rand.nextInt(maxNumberOfItemsToSort);
            }
            
            //formatted output
            System.out.format("%-22s%s%7s", "Insertion Sort:", "N = ", d.format(i));
            
            //start time
            miliStart = System.currentTimeMillis();
            
            //sort the array
            SortingAlgorithms.insertionSort(t);
            
            //end time
            miliEnd = System.currentTimeMillis();
            
            //change in time
            miliTotal = miliEnd - miliStart;
            
            //formatted output
            System.out.format("%s%12s%s", ";  Time = ", d.format(miliTotal) + " msec", ";  Head = ");
            
            //output specified number of sorted elements.
            for(int j = 0; j < numberOfIntsPrinted; j++)
                System.out.format("%8s", d.format(t[j]));
            
            //print new line
            System.out.println();
        }
        
        
        //simple bubble sort
        
        //for all the different lengths of arrays to sort
        for (int i = minNumberOfItemsToSort; i < (maxNumberOfItemsToSort + 1); i *= multiplier)
        {
            //create array of specified length
            int[] t = new int[i];
            
            //fill array with random ints
            for (int j = 0; j < i; j++)
            {
                //add number between 0 (inclusive) and i (exclusive)
                t[j] = rand.nextInt(maxNumberOfItemsToSort);
            }
            
            //formatted output
            System.out.format("%-22s%s%7s", "Simple Bubble Sort:", "N = ", d.format(i));
            
            //start time
            miliStart = System.currentTimeMillis();
            
            //sort the array
            SortingAlgorithms.simpleBubbleSort(t);
            
            //end time
            miliEnd = System.currentTimeMillis();
            
            //change in time
            miliTotal = miliEnd - miliStart;
            
            //formatted output
            System.out.format("%s%12s%s", ";  Time = ", d.format(miliTotal) + " msec", ";  Head = ");
            
            //output specified number of sorted elements.
            for(int j = 0; j < numberOfIntsPrinted; j++)
                System.out.format("%8s", d.format(t[j]));
            
            //print new line
            System.out.println();
        }
        
        
        //enhanced bubble sort
        
        //for all the different lengths of arrays to sort
        for (int i = minNumberOfItemsToSort; i < (maxNumberOfItemsToSort + 1); i *= multiplier)
        {
            //create array of specified length
            int[] t = new int[i];
            
            //fill array with random ints
            for (int j = 0; j < i; j++)
            {
                //add number between 0 (inclusive) and i (exclusive)
                t[j] = rand.nextInt(maxNumberOfItemsToSort);
            }
            
            //formatted output
            System.out.format("%-22s%s%7s", "Enhanced Bubble Sort:", "N = ", d.format(i));
            
            //start time
            miliStart = System.currentTimeMillis();
            
            //sort the array
            SortingAlgorithms.enhancedBubbleSort(t);
            
            //end time
            miliEnd = System.currentTimeMillis();
            
            //change in time
            miliTotal = miliEnd - miliStart;
            
            //formatted output
            System.out.format("%s%12s%s", ";  Time = ", d.format(miliTotal) + " msec", ";  Head = ");
            
            //output specified number of sorted elements.
            for(int j = 0; j < numberOfIntsPrinted; j++)
                System.out.format("%8s", d.format(t[j]));
            
            //print new line
            System.out.println();
        }
    }
}