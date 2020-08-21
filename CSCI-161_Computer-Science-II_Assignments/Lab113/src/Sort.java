
import java.util.Arrays;

/**
 *
 * @author Monty Vanderlinde
 * @version 23 November 2017
 * 
 * A class for encapsulating the merge sort method.
 * 
 */
public class Sort
{
    /**
     * A static method for sorting an array of ints using a merge sort algorithm.
     * Out of the book and modified for just ints.
     * @param array An array of ints to be sorted.
     */
    public static void mergeSort(int[] array)
    {
        int n = array.length;
        
        if(n < 2)
            return;
        
        int mid = n / 2;
        
        int[] s1 = Arrays.copyOfRange(array, 0, mid);
        int[] s2 = Arrays.copyOfRange(array, mid, n);
        
        Sort.mergeSort(s1);
        Sort.mergeSort(s2);
        
        Sort.merge(s1, s2, array);
    }
    
    /**
     * A static method for sorting and merging an array of ints.
     * Out of the book and modified for just ints.
     * @param s1 The array to be merged to the first half.
     * @param s2 The array to be merged to the second half.
     * @param array An array of ints to be sorted.
     */
    private static void merge(int[] s1, int[] s2, int[] array)
    {
        int i = 0, j = 0;
        
        while((i + j) < array.length)
        {
            if((j == s2.length) || ((i < s1.length) && (s1[i] < s2[j])))
                array[i + j] = s1[i++];
            else
                array[i + j] = s2[j++];
        }
    }
}