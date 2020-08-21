
import Queue.ArrayQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Monty Vanderlinde
 * @version 23 November 2017
 * 
 * A client for testing the externalMergeSort method in the Sort class.
 * 
 */
public class Client
{
    //private field so that it can be used in entire client class
    private static final DecimalFormat DF = new DecimalFormat("#,###");
    
    //the main method
    public static void main(String[] args)
    {
        //number of elements to sort
        int N = 1000000;
        
        //number of pieces to break the file into
        int pieces = 10;
        
        //do you want the files to be deleted at the end of the program leaving just the system output?
        boolean deleteUnsortedFilesWhenDone = false, deleteSortedFilesWhenDone = false, deleteFilePiecesWhenDone = false;
        
        //file path of the directory containing the files
        String directory = "C:\\data";
        
        //for keeping track of times
        long startTimeShort, totalTimeShort, startTimeLong, totalTimeLong;
        
        //for creating pseudorandom numbers
        Random rand = new Random();
        
        //N must be between 100 and 1,000,000,000 inclusive
        if((N > 1000000000) || (N < 100))
        {
            System.err.println("N must be between 100 and 1,000,000,000 inclusive!");
            System.exit(0);
        }
        
        //the file must be split into at least 5 pieces
        if(pieces < 5)
        {
            System.err.println("The file must be split into at least 5 pieces!");
            System.exit(0);
        }
        
        //the number of pieces that the main file is broken in to must be less than the square root of the total number of values to sort
        if((pieces * pieces) > N)
        {
            System.err.println("The number of pieces that the main file is broken in to must be less than the square root of the total number of values to sort.");
            System.exit(0);
        }
        
        //create new Files
        File unsortedFile = new File(directory + "\\data.txt");
        File sortedFile = new File(directory + "\\sortedData.txt");
        
        //the files holding each of the pieces of the main file
        File[] files = new File[pieces];
        
        for(int i = 0; i < pieces; i++)
        {
            String path = directory + "\\piece" + (i + 1) + ".txt";
            files[i] = new File(path);
        }
        
        //create new directory file
        File directoryFile = new File(directory);
        
        //create new PrintWriter
        PrintWriter writer = null;
        
        //make any necessary directories
        directoryFile.mkdirs();

        //try to create the files
        try
        {
            unsortedFile.createNewFile();
            sortedFile.createNewFile();
            
            for(int i = 0; i < pieces; i++)
                files[i].createNewFile();
            
            writer = new PrintWriter(unsortedFile);
        }
        //catch exceptions
        catch(FileNotFoundException fnfe)
        {
            System.err.println("Error, file not found!");
        }
        catch(IOException ioe)
        {
            System.err.println("Error, ioexception!");
        }
        
        //exit if the writer was not initialized
        if(writer == null)
        {
            System.err.println("Writer not fount!");
            System.exit(0);
        }
        
        //start the clock
        startTimeShort = System.currentTimeMillis();
        
        //fill file with random ints from MIN_VALUE to MAX_VALUE
        for(int i = 0; i < N; i++)
            writer.println(rand.nextInt());
        
        //stop the clock
        totalTimeShort = System.currentTimeMillis() - startTimeShort;
        
        //print the time it took to sort the entire file
        System.out.println("Total time to generate the file with " + Client.DF.format(N) + " items:  " + Client.DF.format(totalTimeShort) + " msec");
        
        //close the writer
        writer.close();
        
        //start the clock
        startTimeLong = System.currentTimeMillis();
        
        try
        {
            //sort the large file with external merge sort
            ExternalMergeSort.sort(unsortedFile, sortedFile, files, N);
        }
        catch(FileNotFoundException fnfe)
        {
            //this should never be thrown, as the files have already been checked
        }
        
        //end the clock
        totalTimeLong = System.currentTimeMillis() - startTimeLong;
        
        //print the time it took to sort the entire file
        System.out.println("Total time to sort the file with " + Client.DF.format(N) + " items:  " + Client.DF.format(totalTimeLong) + " msec");
        
        //scanners to print out first 20 items in file.  Initialized to appease the compiler
        Scanner unsortedScan = new Scanner(""), sortedScan = new Scanner("");
        
        //create the scanners
        try
        {
            unsortedScan = new Scanner(unsortedFile);
            sortedScan = new Scanner(sortedFile);
        }
        catch(FileNotFoundException fnfe)
        {
            //this should never be thrown, as the files have already been checked
        }
        
        //print out first 20 unsorted items.
        System.out.print("First 20 Unsorted:  ");
        for(int i = 0; i < 20; i++)
        {
            System.out.format("%16s", Client.DF.format(unsortedScan.nextInt()));
        }
        System.out.println();
        
        //print out first 20 sorted items.
        System.out.print("First 20 Sorted:    ");
        for(int i = 0; i < 20; i++)
        {
            System.out.format("%16s", Client.DF.format(sortedScan.nextInt()));
        }
        System.out.println();
        
        //close scanners
        unsortedScan.close();
        sortedScan.close();
        
        //delete unsorted file if selected
        if(deleteUnsortedFilesWhenDone)
            unsortedFile.delete();
        
        //delete sorted file if selected
        if(deleteSortedFilesWhenDone)
            sortedFile.delete();
        
        //delete file pieces if selected
        if(deleteUnsortedFilesWhenDone)
        {
            for(int i = 0; i < files.length; i++)
                files[i].delete();
        }
    }
    
    /**
     * A private class for implementing the external merge sort.
     */
    private static class ExternalMergeSort
    {
        /**
         * The external merge sort algorithm in a method.
         * @param unsorted The file of unsorted values.
         * @param sorted The file to fill with sorted values.
         * @param filePieces An array of files to fill with parts of the unsorted file.
         * @param numberOfElements The number of values in the unsorted file.
         * @throws FileNotFoundException Should not be thrown as the files have already been checked.
         */
        public static void sort(File unsorted, File sorted, File[] filePieces, int numberOfElements) throws FileNotFoundException
        {
            //the number of variables to sort per each file piece
            int variablesPerFile = numberOfElements / filePieces.length;
            
            //for keeping track of time
            long startTime, totalTime;
            
            //scanner of all unsorted variables
            Scanner unsortedFile = new Scanner(unsorted);
            
            //printwriter for the file pieces
            PrintWriter piece = null;
            
            //divide unsorted ints among file pieces and sort the file pieces
            for(int i = 0; i < filePieces.length; i++)
            {
                //if this is the last run, place all remaining ints in the last file
                if((i + 1) == filePieces.length)
                    variablesPerFile += numberOfElements % filePieces.length;
                
                //start the clock
                startTime = System.currentTimeMillis();
                
                //array of ints for first file piece
                int[] unsortedInts = new int[variablesPerFile];
                
                //fill unsortedInts from unsortedFile
                for(int j = 0; j < variablesPerFile; j++)
                {
                    unsortedInts[j] = unsortedFile.nextInt();
                }
                
                //sort the unsortedInts array
                Sort.mergeSort(unsortedInts);
                
                //create printwriter for file piece
                piece = new PrintWriter(filePieces[i]);
                
                //place sorted ints into file piece
                for(int j = 0; j < variablesPerFile; j++)
                    piece.println(unsortedInts[j]);
                
                //close the printwriter
                piece.close();
                
                //end clock
                totalTime = System.currentTimeMillis() - startTime;
                
                //print the time it took to sort the file piece
                System.out.println("Total time to sort piece" + (i + 1) + " with " + Client.DF.format(variablesPerFile) + " items:  " + Client.DF.format(totalTime) + " msec");
            }
            
            //close unsorted file
            unsortedFile.close();
            
            //merge the file pieces back together
            ExternalMergeSort.merge(filePieces, sorted, numberOfElements);
        }
        
        /**
         * Private method, for helping the external merge sort, that merges the file pieces into the sorted file.
         * @param sorted The file to fill with sorted values.
         * @param filePieces An array of files to fill with parts of the unsorted file.
         * @param numberOfElements The number of values in the unsorted file.
         * @throws FileNotFoundException Should not be thrown as the files have already been checked.
         */
        private static void merge(File[] filePieces, File sorted, int numberOfElements) throws FileNotFoundException
        {
            //printwriter for sorted file
            PrintWriter sortedFile = new PrintWriter(sorted);
            
            //scanners for all the file pieces
            Scanner[] scanFilePieces = new Scanner[filePieces.length];
            for(int i = 0; i < filePieces.length; i++)
                scanFilePieces[i] = new Scanner(filePieces[i]);
            
            //create queues to store first values from files to be sorted
            ArrayQueue<Integer>[] filesQueue = new ArrayQueue[filePieces.length];
            
            //number of elements to store in each queue (all queues will equal 1/10th the size of one file piece)
            int numFilePieceQueues = (numberOfElements / (10 * filePieces.length * filePieces.length));
            
            //fill queues with ints from files
            for(int i = 0; i < filesQueue.length; i++)
            {
                //create queue with capacity of the 
                filesQueue[i] = new ArrayQueue(numFilePieceQueues);
                
                //fill the queues with values from their respective files
                for(int j = 0; j < numFilePieceQueues; j++)
                {
                    filesQueue[i].enqueue(scanFilePieces[i].nextInt());
                }
            }
            
            //is each file piece empty
            boolean[] isFileEmpty = new boolean[filePieces.length];
            
            //are all file pieces empty
            boolean allFilesEmpty = false;
            
            //set to max value to guarantee that any int will be less than or equal to this
            int minValue = Integer.MAX_VALUE;
            
            //set index to unusable value
            int index = -1;
            
            int count = 0;
            
            while(!allFilesEmpty)
            {
                //find max value index
                for (int i = 0; i < filesQueue.length; i++)
                {
                    //if this file piece is empty, continue to the next one
                    if(isFileEmpty[i])
                        continue;
                    
                    //if the first value in this queue is smaller than or equal to the min value
                    if(filesQueue[i].first() <= minValue)
                    {
                        //then this is the new min value
                        minValue = filesQueue[i].first();
                        
                        //remember the index of this value
                        index = i;
                    }
                }
                
                //add that value to the sorted file
                sortedFile.println(filesQueue[index].dequeue());
                
                //if that file list is now empty, refill or set that file to empty
                if(filesQueue[index].isEmpty())
                {
                    if(scanFilePieces[index].hasNextInt())
                    {
                        for(int i = 0; (i < numFilePieceQueues) && (scanFilePieces[index].hasNextInt()); i++)
                        {
                            filesQueue[index].enqueue(scanFilePieces[index].nextInt());
                        }
                    }
                    else
                        isFileEmpty[index] = true;
                    
                    if(index == 0)
                        System.out.println((++count) + "/100");
                }
                
                //clear the minValue
                minValue = Integer.MAX_VALUE;
                
                //set to true
                allFilesEmpty = true;
                
                //check if all file pieces are empty.  allFilesEmpty will only be true if all file pieces are empty
                for(int i = 0; i < isFileEmpty.length; i++)
                {
                    //if any are not empty
                    if(!(isFileEmpty[i]))
                    {
                        //then it is not done
                        allFilesEmpty = false;
                        break;
                    }
                }
            }
            
            //close scanners
            for(int i = 0; i < filePieces.length; i++)
                scanFilePieces[i].close();
            
            //close sorted file printwriter
            sortedFile.close();
        }
    }
}