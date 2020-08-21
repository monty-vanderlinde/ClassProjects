
import java.util.Arrays;

/**
 *
 * @author Monty Vanderlinde
 * @version 22 November 2017
 * 
 * A class for encapsulating multiple different sorting algorithms.
 * 
 */
public class Sort
{
    /**
     * Private Default Constructor to make sure that it is never used.
     */
    private Sort(){}
    
    /**
     * A static method for sorting an array of general objects using a selection sort algorithm.
     * Out of the book.
     * @param <T> A general object.
     * @param array An array of general objects to be sorted.
     * @param comp A comparator of the general objects in the array.
     */
    public static <T> void selectionSort(T[] array, Comparator<T> comp)
    {
        T temp; // temporary location for swap
        int max;  // index of maximum value in subarray
        
        for(int i = 0; i < array.length; i++)
        {
            // find index of largest value in subarray
            max = Sort.indexOfLargestElement(array, comp, array.length - i);
            
            // swap array[max] and array[array.length - i - 1]
            temp = array[max];
            array[max] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
    
    /**
     * Finds index of largest element.
     * Out of the book.
     * @param <T> A general object.
     * @param array The array to search.
     * @param comp A comparator of the general objects in the array.
     * @param size The size of the subarray.
     * @return The index of the largest element in the subarray.
     */
    private static <T> int indexOfLargestElement(T[] array, Comparator<T> comp, int size)
    {
        int index = 0;
        
        for(int i = 1; i < size; i++)
        {
            if(comp.compare(array[i], array[index]) > 0)
                index = i;
        }
        
        return index;
    }
    
    /**
     * Insertion Sort Anderson, Franceschi Java Illuminated, Chapter 8
     * Method was supplied, not written.
     * @param <T> A general object.
     * @param array An array of general objects to be sorted.
     * @param comp A comparator of the general object in the array.
     */
    public static <T> void insertionSort(T[] array, Comparator<T> comp)
    {
        int j;
        T temp;
        
        for(int i = 1; i < array.length; i++)
        {
            j = i;
            temp = array[i];
            
            while((j != 0) && (comp.compare(array[j - 1], temp) > 0))
            {
                array[j] = array[j - 1];
                j--;
            }
            
            array[j] = temp;
        }
    }
    
    /**
     * A static method for sorting an array of general objects using a simple 
     * bubble sort algorithm.  Will not check if it can stop early.
     * Out of the book.
     * @param <T> A general object.
     * @param array An array of general objects to be sorted.
     * @param comp A comparator of the general objects in the array.
     */
    public static <T> void simpleBubbleSort(T[] array, Comparator<T> comp)
    {
        //nubmer of passes needed through the array
        int length = array.length;
        
        //pass through the array for the number of elements in the array
        for(int i = 0; i < length; i++)
        {
            //perform checks on entire array.  Does not limit the checks.
            for(int j = 0; j < length - 1; j++)
            {
                //if the current element is greater than the next element
                if( comp.compare( array[j], array[j+1] ) > 0 )
                {
                    //switch the elements
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    
    /**
     * A static method for sorting an array of general objects using a merge sort algorithm.
     * Out of the book.
     * @param <T> A general object.
     * @param array An array of general objects to be sorted.
     * @param comp A comparator of the general objects in the array.
     */
    public static <T> void mergeSort(T[] array, Comparator<T> comp)
    {
        int n = array.length;
        
        if(n < 2)
            return;
        
        int mid = n / 2;
        
        T[] s1 = Arrays.copyOfRange(array, 0, mid);
        T[] s2 = Arrays.copyOfRange(array, mid, n);
        
        Sort.mergeSort(s1, comp);
        Sort.mergeSort(s2, comp);
        
        Sort.merge(s1, s2, array, comp);
    }
    
    /**
     * A static method for sorting and merging an array of general objects.
     * Out of the book.
     * @param <T> A general object.
     * @param s1 The array to be merged to the first half.
     * @param s2 The array to be merged to the second half.
     * @param array An array of general objects to be sorted.
     * @param comp A comparator of the general objects in the array.
     */
    private static <T> void merge(T[] s1, T[] s2, T[] array, Comparator<T> comp)
    {
        int i = 0, j = 0;
        
        while((i + j) < array.length)
        {
            if((j == s2.length) || ((i < s1.length) && (comp.compare(s1[i], s2[j]) < 0)))
                array[i + j] = s1[i++];
            else
                array[i + j] = s2[j++];
        }
    }
    
    /**
     * A static method for sorting an array of general objects using a quick sort algorithm.
     * Modified to work with arrays.
     * @param <T> A general object.
     * @param array An array of general objects to be sorted.
     * @param comp A comparator of the general objects in the array.
     */
    public static <T> void quickSort(T[] array, Comparator<T> comp)
    {
        int n = array.length;
        
        if(n < 2)
            return;
        
        //first value is pivot
        T pivot = array[0];
        
        LinkedQueue<T> smaller = new LinkedQueue<>();
        LinkedQueue<T> equal = new LinkedQueue<>();
        LinkedQueue<T> greater = new LinkedQueue<>();
        
        int c;
        
        //compare pivot to other elements in the array
        for(int i = 0; i <  n; i++)
        {
            c = comp.compare(array[i], pivot);
            
            if(c < 0)
                smaller.enqueue(array[i]);
            else if(c == 0)
                equal.enqueue(array[i]);
            else
                greater.enqueue(array[i]);
        }
        
        //call queue version of quick sort
        Sort.quickSort(smaller, comp);
        Sort.quickSort(greater, comp);
        
        //index
        int i = 0;
        
        //replace indexes with contents of smaller
        while(!smaller.isEmpty())
            array[i++] = smaller.dequeue();
        
        //replace indexes with contents of equal
        while(!equal.isEmpty())
            array[i++] = equal.dequeue();
        
        //replace indexes with contents of greater
        while(!greater.isEmpty())
            array[i++] = greater.dequeue();
    }
    
    /**
     * A static method for sorting a queue of general objects using a quick sort algorithm.
     * Out of the book.
     * @param <T> A general object.
     * @param queue A queue of general objects to be sorted.
     * @param comp A comparator of the general objects in the array.
     */
    public static <T> void quickSort(Queue<T> queue, Comparator<T> comp)
    {
        int n = queue.size();
        
        if(n < 2)
            return;
        
        T pivot = queue.first();
        
        LinkedQueue<T> smaller = new LinkedQueue<>();
        LinkedQueue<T> equal = new LinkedQueue<>();
        LinkedQueue<T> greater = new LinkedQueue<>();
        
        int c;
        
        for(int i = 0; i <  n; i++)
        {
            T element = queue.dequeue();
            
            c = comp.compare(element, pivot);
            
            if(c < 0)
                smaller.enqueue(element);
            else if(c == 0)
                equal.enqueue(element);
            else
                greater.enqueue(element);
        }
        
        Sort.quickSort(smaller, comp);
        Sort.quickSort(greater, comp);
        
        while(!smaller.isEmpty())
            queue.enqueue(smaller.dequeue());
        
        while(!equal.isEmpty())
            queue.enqueue(equal.dequeue());
        
        while(!greater.isEmpty())
            queue.enqueue(greater.dequeue());
    }
    
    /**
     * A static method for sorting an array of general objects using a radix sort algorithm.
     * @param <T> A general object.
     * @param array An array of general objects to be sorted.
     * @param comp1 A comparator of the general objects in the array.
     */
    public static <T> void radixSort(T[] array, Comparator<T> comp1)
    {
        //use the merge sort, because I could not remember, nor could I find any slides on blackboard to explain:
        //"[implement] as described in lecture, not as described in the textbook"
        Sort.mergeSort(array, comp1);
    }
    /**
     * A static method for sorting an array of general objects using a radix sort algorithm.
     * @param <T> A general object.
     * @param array An array of general objects to be sorted.
     * @param comp1 The most significant comparator of the general objects in the array.
     * @param comp2 The second most significant comparator of the general objects in the array.
     */
    public static <T> void radixSort(T[] array, Comparator<T> comp1, Comparator<T> comp2)
    {
        //sort by least significant comparator
        Sort.radixSort(array, comp2);
        
        //sort by the rest
        Sort.radixSort(array, comp1);
    }
    
    /**
     * A static method for sorting an array of general objects using a radix sort algorithm.
     * @param <T> A general object.
     * @param array An array of general objects to be sorted.
     * @param comp1 The most significant comparator of the general objects in the array.
     * @param comp2 The second most significant comparator of the general objects in the array.
     * @param comp3 The third most significant comparator of the general objects in the array.
     */
    public static <T> void radixSort(T[] array, Comparator<T> comp1, Comparator<T> comp2, Comparator<T> comp3)
    {
        //sort by least significant comparator
        Sort.radixSort(array, comp3);
        
        //sort by the rest
        Sort.radixSort(array, comp1, comp2);
    }
    
    /**
     * A static method for sorting an array of general objects using a radix sort algorithm.
     * @param <T> A general object.
     * @param array An array of general objects to be sorted.
     * @param comp1 The most significant comparator of the general objects in the array.
     * @param comp2 The second most significant comparator of the general objects in the array.
     * @param comp3 The third most significant comparator of the general objects in the array.
     * @param comp4 The fourth most significant comparator of the general objects in the array.
     */
    public static <T> void radixSort(T[] array, Comparator<T> comp1, Comparator<T> comp2, Comparator<T> comp3, Comparator<T> comp4)
    {
        //sort by least significant comparator
        Sort.radixSort(array, comp4);
        
        //sort by the rest
        Sort.radixSort(array, comp1, comp2, comp3);
    }
    
    /**
     * A static method for sorting an array of general objects using a radix sort algorithm.
     * @param <T> A general object.
     * @param array An array of general objects to be sorted.
     * @param comp1 The most significant comparator of the general objects in the array.
     * @param comp2 The second most significant comparator of the general objects in the array.
     * @param comp3 The third most significant comparator of the general objects in the array.
     * @param comp4 The fourth most significant comparator of the general objects in the array.
     * @param comp5 The fifth most significant comparator of the general objects in the array.
     */
    public static <T> void radixSort(T[] array, Comparator<T> comp1, Comparator<T> comp2, Comparator<T> comp3, Comparator<T> comp4, Comparator<T> comp5)
    {
        //sort by least significant comparator
        Sort.radixSort(array, comp5);
        
        //sort by the rest
        Sort.radixSort(array, comp1, comp2, comp3, comp4);
    }
}