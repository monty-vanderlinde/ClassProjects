
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Monty Vanderlinde
 * @version 23 September 2017
 * 
 * A class with recursive methods for Isabel’s technique, finding harmonic
 * numbers, and finding all files within a file path.
 * 
 */
public class Recursion
{
    /**
     * Default Constructor:<BR>
     * A private constructor to guarantee that clients cannot make an instance
     * of this class.
     */
    private Recursion(){}
    
    /**
     * Static Method:<BR>
     * Returns nth Harmonic number as a double, where n is <B>number</B>.
     * @param number Equal to n, where the nth Harmonic will be returned.
     * @return The nth harmonic number, where n is <B>number</B>. (double)
     * @throws IllegalArgumentException If <B>number</B> is less than 1.
     */
    public static double getHarmonic(int number) throws IllegalArgumentException
    {
        if(number < 1)
            throw new IllegalArgumentException("\"getHarmonic\" method cannot"
                    + " be called with a negative or zero value.");
        
        if(number == 1)
            return 1.0d;
        
        //only allow int values to guarantee whole numbers.
        //manual cast to a double.
        return (1.0d / ((double)number)) + getHarmonic(number - 1);
    }
    
    /**
     * Static Method:<BR>
     * Returns an array of strings containing all of the files and directories
     * within the directory at <B>path</B>, including the directory itself.  If
     * <B>path</B> leads to a non directory file, then only the file is
     * returned.  All elements will be formatted with tabs to signify position.
     * @param path The path of the directory, or file, to have converted.
     * @return An array of strings containing all of the contents of a
     * directory, or file. (String[])
     * @throws FileNotFoundException If <B>path</B> does not lead to a
     * directory or file.
     * @throws RuntimeException If a directory contains something that is not
     * considered to be neither a file, nor a directory.  Should not occur.
     */
    public static String[] find(String path) throws FileNotFoundException
    {
        File f = new File(path);
        
        //check file path
        if(!(f.exists()))
            throw new FileNotFoundException("String passed to \"find\" method "
                    + "is not a real pathname.");
        
        //number of files contained within the directory, plus the directory itself. (+1)
        int numberOfTotalFiles = Recursion.getNumberFilAndDir(f) + 1;
        int numberOfAddedFiles = 0;
        //string for each file and directory, including initial directory.
        String[] fileStringList = new String[numberOfTotalFiles];
        //add colon (:) to end of directory name.
        fileStringList[numberOfAddedFiles++] = f.getName() + ":\n";
        File[] fileList = f.listFiles();
        
        //while there are more files left to scan
        while(numberOfAddedFiles < numberOfTotalFiles)
        {
            //for all files within current directory
            for(int i = 0; i < fileList.length; i++)
            {
                //if is a file, add file to the next open position in fileStringArray.
                if(fileList[i].isFile())
                {
                    //add tab to front of file name.
                    fileStringList[numberOfAddedFiles++] = "\t" + fileList[i].getName();
                }
                //if is directory, use recursion to add directory and all contents in order.
                else if(fileList[i].isDirectory())
                {
                    //includes directory and its contents.
                    String[] tempFileStringList = Recursion.find(fileList[i].getPath());
                    
                    //add tab to front of directory name.
                    fileStringList[numberOfAddedFiles++] = "\t" + tempFileStringList[0];
                    
                    //add two tabs to front of directory contents.
                    for(int j = 1; j < tempFileStringList.length; j++)
                        fileStringList[numberOfAddedFiles++] = "\t\t" + tempFileStringList[j];
                }
                else
                    throw new RuntimeException("Should not be able to reach this point.");
            }
        }
        
        //return full file list.
        return fileStringList;
    }
    
    /**
     * Static Method:<BR>
     * Returns the number of files and directories contained within a directory,
     * excluding the directory itself.  Returns 0 if is not a directory.
     * @param f The directory which will have its contents counted.
     * @return The number of files and directories within the directory
     * <B>f</B>.  Returns 0 if <B>f</B> is not a directory.
     */
    private static int getNumberFilAndDir(File f)
    {
        //only counts contents of directories, not the directory itself.
        if(f.isFile())
            return 0;
        
        //list with length equal to the number of files and directories contained.
        File[] fileList = f.listFiles();
        int number = fileList.length;
        
        //if file is a directory, return number of files and directories contained.
        //if file is a file, returns zero.
        for(int i = 0; i < fileList.length; i++)
        {
            number += getNumberFilAndDir(fileList[i]);
        }
        
        return number;
    }
    
    /**
     * Static Method:<BR>
     * Method for implementing Isabel's method for adding all the int values in
     * a specified text file.  Throws exceptions if the int values add up to
     * above 2,147,483,647 or below -2,147,483,648, there are not a power of two
     * number of ints, there are more than 1,073,741,824 ints, the file does not
     * contain ints, or the file cannot be found.
     * @param pathname The pathname of the file with the ints to be summed.
     * @return The sum of all the ints in the specified file. (int)
     * @throws FileNotFoundException If the file cannot be found at
     * <B>pathname</B>.
     * @throws InputMismatchException If the file contains anything that cannot
     * be cast as an int.
     * @throws ArithmeticException If the ints in the file add up to above
     * 2,147,483,647 or below -2,147,483,648.
     * @throws IsabelsException If the number of ints is not a power of two or
     * there are more than 1,073,741,824 ints in the file.
     */
    public static int isabelsTechnique(String pathname) throws FileNotFoundException
    {
        //total summation to be returned.
        int total;
        
        try
        {
            //try file pathname
            Scanner file = new Scanner(new File(pathname));
            
            //start with single length int array.
            int[] data = new int[1];
            
            data[0] = file.nextInt();
            
            //if more needs to be added
            while(file.hasNext())
            {
                //largest power of 2 that can be represented as an int.
                if(data.length == 1073741824)
                    throw new IsabelsException("The \"isabelsTechnique\" method"
                            + " cannot be called on file with more than "
                            + "1,073,741,824 ints.");
                
                //double array length to keep array length a power of 2.
                int[] newData = new int[data.length * 2];
                
                //copy data array to newData array.
                for(int i = 0; i < data.length; i++)
                    newData[i] = data[i];
                
                //start where left off when copying array over
                for(int i = data.length; i < newData.length; i++)
                {
                    if(file.hasNext())
                        newData[i] = file.nextInt();
                    //isabel's technique is for data sets that are a length of a power of 2.
                    else
                        throw new IsabelsException("The \"isabelsTechnique\" "
                                + "method must be called on a file with a "
                                + "number of ints equal to a power of two.");
                }
                
                //set data to new data array that is twice as long.
                data = newData;
                
                //remove the reference of newData to data.
                newData = null;
            }
            
            //adds up the int array and returns the total as an int.
            total = isabelsTechnique_Recursive(data);
            
            file.close();
        }
        //catch exceptions and throw them again with a message.
        catch(FileNotFoundException fnfe)
        {
            throw new FileNotFoundException("Pathname passed to "
                    + "\"isabelsTechnique\" not found.");
        }
        catch(InputMismatchException ime)
        {
            throw new InputMismatchException("Data in file passed to"
                    + " \"isabelsTechnique\" cannot be read as an int.");
        }
        
        return total;
    }
    
    /**
     * Static Method:<BR>
     * Recursive method that returns the sum of all the numbers in the supplied
     * integer array.  Assumes that <B>numbers</B> array has a length of a
     * power of 2.
     * @param numbers Array of ints to be added up.  Should have a length of a
     * power of 2.
     * @return The sum of all the ints in the <B>numbers</B> array. (int)
     * @throws ArithmeticException If the int values add up to above
     * 2,147,483,647 or below -2,147,483,648.
     */
    private static int isabelsTechnique_Recursive(int[] numbers)
    {
        //if an array of length = 1, returns the value at index 0.
        if(numbers.length == 1)
            return numbers[0];
        
        //create new array half as long.
        int[] n = new int[numbers.length / 2];
        
        for(int i = 0; i < n.length; i++)
        {
            //check if two index values will add up to a value that is too big or small.
            //proceed if value is acceptable
            long l = (long)numbers[2 * i] + (long)numbers[2 * i + 1];
            if(l < 2147483648L && l > -2147483649L)
                n[i] = numbers[2 * i] + numbers[2 * i + 1];
            //throw exception if value is not acceptable
            else
                throw new ArithmeticException("An int overflow occured in"
                        + " \"isabelsTechnique\" while adding values.");
        }
        
        //recursive call on new array that is half as long.
        return isabelsTechnique_Recursive(n);
    }
    
    /**
     * Private exception class used to specify problems when using 
     * isabelsTechnique method.
     */
    private static class IsabelsException extends RuntimeException
    {
        /**
         * Exception:<BR>
         * Private exception used to specify problems when using
         * isabelsTechnique method.
         * @param message Message to explain how isabelsTechnique method is
         * being misused
         */
        public IsabelsException(String message)
        {
            super(message);
        }
    }
}