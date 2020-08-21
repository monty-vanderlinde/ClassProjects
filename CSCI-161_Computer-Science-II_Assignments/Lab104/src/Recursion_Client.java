
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Monty Vanderlinde
 * @version 23 September 2017
 * 
 * A client for testing recursive methods from the Recursion class.
 * 
 */
public class Recursion_Client
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int i = 0;
        
        //continue until program is exited.
        //can be exited by pressing "x", "close", or entering 2 when prompted to leave.
        while(true)
        {
            //prompt user and return answer.
            i = displayOptionPane("Please select a method to test:\n"
                    + "1) getHarmonic\n2) isabelsTechnique\n3) find\n\n"
                    + "Please enter only a number", 1, 3);
            
            String s;
            
            //proceed according to the answer returned by the user.
            switch(i)
            {
                case 1:
                    //display method name.
                    System.out.println("getHarmonic:\n");
                    
                    //get number to find harmonic value of.
                    int h = displayOptionPane("Please enter a number to calculate "
                            + "the harmonic value of.\nWarning:  Large values "
                            + "may cause a stack overflow error.", 1, 2147483647);
                    try
                    {
                        //print returned value.
                        System.out.println(h + "\n");
                        
                        //print harmonic of returned value.
                        System.out.println(Recursion.getHarmonic(h) + "\n");
                    }
                    //catch any Stack Overflow Errors
                    catch(StackOverflowError soe)
                    {
                        System.out.println("Caused a stack overflow.\n");
                    }
                    break;
                case 2:
                    //get pathname as a string.
                    s = JOptionPane.showInputDialog(null, "Please enter "
                            + "the pathname of a file.  The file should contain"
                            + " int values separated with spaces.\n"
                            + "e.g.  isabelsData\\data.txt  (use to test)");
                    
                    //end program if returns null.
                    if(s == null)
                    {
                        JOptionPane.showMessageDialog(null, "Goodbye!");
                        System.exit(0);
                    }
                    
                    //try pathname.
                    try
                    {
                        //print method name.
                        System.out.println("isabelsTechnique:\n");
                        
                        //print given pathname.
                        System.out.println(s + "\n");
                        
                        //try to add all values at pathname.
                        int temp = Recursion.isabelsTechnique(s);
                        
                        //get file scanner to display int values.
                        Scanner file = new Scanner(new File(s));
                        
                        //display int values.
                        while(file.hasNext())
                            System.out.println(file.nextInt());
                        
                        //display summation of numbers in file.
                        System.out.println("\n" + temp + "\n");
                    }
                    //catch any potential exceptions and display error message.
                    catch(FileNotFoundException fnfe)
                    {
                        System.out.println("FileNotFoundException");
                        JOptionPane.showMessageDialog(null, "File could not be"
                                + " found at the specified address.\n");
                    }
                    catch(InputMismatchException ime)
                    {
                        System.out.println("InputMismatchException");
                        JOptionPane.showMessageDialog(null, "One of the items "
                                + "in the file could not be read as an int.\n");
                    }
                    catch(ArithmeticException ae)
                    {
                        System.out.println("ArithmeticException");
                        JOptionPane.showMessageDialog(null, "The ints in the "
                                + "selected file added up to a value too big or"
                                + " small to be an int.\n");
                    }
                    catch(RuntimeException re)
                    {
                        System.out.println("IsabelsException");
                        JOptionPane.showMessageDialog(null, "There were either "
                                + "more than 1,073,741,824 ints, or the number "
                                + "of ints was not a power of 2.\n");
                    }
                    break;
                case 3:
                    //get pathname as a string.
                    s = JOptionPane.showInputDialog(null, "Please enter "
                            + "the pathname of a file to have the files and "
                            + "directories counted.\ne.g.C:\\data.txt");
                    
                    //end program if returns null.
                    if(s == null)
                    {
                        JOptionPane.showMessageDialog(null, "Goodbye!");
                        System.exit(0);
                    }
                    
                    //try pathname.
                    try
                    {
                        //print method name.
                        System.out.println("find:\n");
                        
                        //print given pathname.
                        System.out.println(s + "\n");
                        
                        //try to get String array from file pathname.
                        String[] temp = Recursion.find(s);
                        
                        //print out String array.
                        for(int j = 0; j < temp.length; j++)
                            System.out.println(temp[j]);
                    }
                    //catch exception if no file exists at pathname.
                    catch(FileNotFoundException fnfe)
                    {
                        System.out.println("FileNotFoundException");
                        JOptionPane.showMessageDialog(null, "File could not be"
                                + " found at the specified address.\n");
                    }
                    break;
            }
            
            //check if they want to leave.
            i = displayOptionPane("Would you like to test another method?\n"
                    + "1) Yes\n2) No\nPlease enter a number only.", 1, 2);
            
            //choose selected value.
            switch(i)
            {
                case 1:
                    //do nothing (continue back around).
                    break;
                case 2:
                    //exit the program.
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    System.exit(0);
                    break;
            }
        }
        
    }
    /**
     * Static Method:<BR>
     * Private method for displaying the JOptionPane and only returning an int 
     * in a specified range.
     * @param s A string message to display.
     * @param min An int value that is the minimum value to be returned.
     * @param max An int value that is the maximum value to be returned.
     * @return A type safe int value that is between <B>min</B> and <B>max</B>.
     */
    private static int displayOptionPane(String s, int min, int max)
    {
        int i;
        //continue perpetually until an acceptable answer or null is returned.
        while(true)
        {
            //prompt user with given string and save returned value.
            String temp = JOptionPane.showInputDialog(null, s);
            
            //exit program if window is closed or press "cancel".
            if(temp == null)
            {
                JOptionPane.showMessageDialog(null, "Goodbye!");
                System.exit(0);
            }
            
            //try to parse "temp" as an int
            try
            {
                i = Integer.parseInt(temp);
                //if int is an acceptable value, return that value.
                if(i >= min && i <= max)
                    return i;
                //display error message if "i" is not an acceptable value.
                else
                    JOptionPane.showMessageDialog(null, "The value entered was"
                            + " not one of the optional numbers.");
            }
            //display error message if "temp" cannot be converted to an int.
            catch(NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(null, "The value entered was not"
                        + " one of the optional numbers.");
            }
        }
    }
}