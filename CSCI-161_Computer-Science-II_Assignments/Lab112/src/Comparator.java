/**
 *
 * @author Monty Vanderlinde
 * @version 21 November 2017
 * 
 * An interface for encapsulating a comparator.
 * 
 * @param <T> A general object to compare.
 * 
 */
public interface Comparator<T>
{
    /**
     * A method for comparing two generic objects.
     * Returns 1 if t1 is greater than t2, 0 if t1 equals t2, or -1 if t1 is less than t2.
     * @param t1 The first generic object to compare.
     * @param t2 The second generic object to compare.
     * @return Returns 1 if t1 is greater than t2, 0 if t1 equals t2, or -1 if t1 is less than t2.
     */
    public int compare(T t1, T t2);
}