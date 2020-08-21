/**
 *
 * @author Monty Vanderlinde
 * @version 27 October 2017
 * 
 * A client for testing the cyclic shift hash code.
 * 
 */
public class Client
{
    public static void main(String[] args)
    {
        System.out.println("Cyclic shift hash code results:\n");
        
        //print out the hash codes of the three words after the cyclic shift hash program
        System.out.println("\tPOTS:  " + CyclicShift.intToBinaryString(CyclicShift.getCyclicShift("POTS")));
        System.out.println("\tSTOP:  " + CyclicShift.intToBinaryString(CyclicShift.getCyclicShift("STOP")));
        System.out.println("\tTOPS:  " + CyclicShift.intToBinaryString(CyclicShift.getCyclicShift("TOPS")));
        
        System.out.println("\n\nCyclic shift hash code verbose results:\n");
        
        //print out the verbose version of the cyclic shift hash program for each of the three words
        System.out.println(CyclicShift.getVerboseCyclicShift("POTS") + "\n\n");
        System.out.println(CyclicShift.getVerboseCyclicShift("STOP") + "\n\n");
        System.out.println(CyclicShift.getVerboseCyclicShift("TOPS"));
    }
}