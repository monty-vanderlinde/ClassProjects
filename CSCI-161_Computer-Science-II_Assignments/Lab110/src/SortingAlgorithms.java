/**
 *
 * @author Monty Vanderlinde
 * @author Anderson & Franceschi (Java Illuminated)
 * @version 03 November 2017
 * 
 * A class with four methods for different array sorting algorithms.
 * 
 */
public class SortingAlgorithms
{
    /**
     * A private constructor to ensure that it is not used
     */
    private SortingAlgorithms(){}
    
    /**
     * A static method for sorting an array of ints using a selection sort algorithm.
     * Method was supplied, not written.
     * @param array An array of ints to be sorted.
     */
    public static void selectionSort(int[] array)
    {
        int temp; // temporary location for swap
        int max;  // index of maximum value in subarray
        
        for (int i = 0; i < array.length; i++)
        {
            // find index of largest value in subarray
            max = indexOfLargestElement(array, array.length - i);
            
            // swap array[max] and array[array.length - i - 1]
            temp = array[max];
            array[max] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    /**
     * Finds index of largest element.
     * Method was supplied, not written.
     * @param size the size of the subarray
     * @param array the array to search
     * @ return the index of the largest element in the subarray
     */
    private static int indexOfLargestElement(int[] array, int size)
    {
        int index = 0;
        
        for (int i = 1; i < size; i++)
        {
            if (array[i] > array[index])
                index = i;
        }
        
        return index;
    }
    
    /**
     * Insertion Sort Anderson, Franceschi Java Illuminated, Chapter 8
     * Method was supplied, not written.
     * @param array array to sort
     */
    public static void insertionSort(int[] array)
    {
        int j, temp;
        
        for (int i = 1; i < array.length; i++)
        {
            j = i;
            temp = array[i];
            
            while (j != 0 && array[j - 1] > temp)
            {
                array[j] = array[j - 1];
                j--;
            }
            
            array[j] = temp;
        }
    }
    
    /**
     * A static method for sorting an array of ints using a simple bubble sort algorithm. 
     * Will not check if it can stop early.
     * @param array An array of ints to be sorted.
     */
    public static void simpleBubbleSort(int[] array)
    {
        //nubmer of passes needed through the array
        int length = array.length - 1;
        
        //pass through the array one time less than the number of elements in the array
        for(int i = 0; i < length; i++)
        {
            //perform checks on entire array.  Does not limit the checks.
            for(int j = 0; j < length; j++)
            {
                //if the current element is greater than the next element
                if(array[j] > array[j + 1])
                {
                    //switch the elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
    /**
     * A static method for sorting an array of ints using an enhanced bubble sort algorithm. 
     * Will check if it can stop early.
     * @param array An array of ints to be sorted.
     */
    public static void enhancedBubbleSort(int[] array)
    {
        //number of passes needed through the array
        int length1 = array.length - 1;
        
        //the number of comparisions needed per a specific pass
        int length2;
        
        //pass through the array one time less than the number of elements in the array
        for(int i = 0; i < length1; i++)
        {
            //the number of comparisons needed decreases by one each time
            length2 = length1 - i;
            
            //perform checks on part of array that has not been sorted.  Limits the checks.
            for(int j = 0; j < length2; j++)
            {
                //if the current element is greater than the next element
                if(array[j] > array[j + 1])
                {
                    //switch the elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}