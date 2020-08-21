
import java.util.Scanner;

/**
 *
 * @author Monty Vanderlinde
 * @version 14 September 2017
 * 
 * A client class for testing the ArrayBag and LinkedBag classes.
 * 
 */
public class Client
{
    public static void main(String[] args)
    {
        //ArrayBag section starts here
        ArrayBag<Player> footballTeam = new ArrayBag<>(2);
        Scanner scan = new Scanner(System.in);
        
        String name, position;
        byte jerseyNumber;
        
        for(int i = 0; i < 6; i++)
        {
            System.out.println("Please enter a player's name:");
            name = scan.nextLine();
            
            System.out.println("Please enter the position played by that player:");
            position = scan.nextLine();
            
            //method is from private class below
            jerseyNumber = SafeScanByte.safeByteScanMinMax("Please enter a number between 0 and 99.",
                    "This was either not a number or the number was not between 0 and 99.  Please enter another number.",
                    (byte) 0, (byte) 99);
            
            footballTeam.add(new Player(name, position, jerseyNumber));
        }
        
        footballTeam.remove();
        
        Player madeUpPlayer = new Player("Tim", "Quarterback", (byte) 55);
        
        footballTeam.add(madeUpPlayer);
        
        System.out.println("The size of the footballTeam ArrayBag is:  " + footballTeam.getCurrentSize());
        
        footballTeam.remove(madeUpPlayer);
        
        System.out.println("The size of the footballTeam ArrayBag is:  " + footballTeam.getCurrentSize());
        
        ArrayBag<String> courses1 = new ArrayBag<>(6);
        
        courses1.add("CSCI 161");
        courses1.add("PHIL 101");
        courses1.add("CHEM 150");
        courses1.add("CHEM 160");
        courses1.add("PHYS 252L");
        courses1.add("CSCI 493");
        
        courses1.remove();
        
        for(int i = 0; i < 5; i++)
        {
            System.out.println(courses1.get(i));
        }
        
        //LinkedBag section starts here
        LinkedBag<Player> basketballTeam = new LinkedBag<>();
        
        for(int i = 0; i < 6; i++)
        {
            System.out.println("Please enter a player's name:");
            name = scan.nextLine();
            
            System.out.println("Please enter the position played by that player:");
            position = scan.nextLine();
            
            jerseyNumber = SafeScanByte.safeByteScanMinMax("Please enter a number between 0 and 99.",
                    "This was either not a number or the number was not between 0 and 99.  Please enter another number.",
                    (byte) 0, (byte) 99);
            
            basketballTeam.add(new Player(name, position, jerseyNumber));
        }
        
        basketballTeam.remove();
        
        basketballTeam.add(madeUpPlayer);
        
        System.out.println("The size of the basketballTeam LinkedBag is:  " + basketballTeam.getCurrentSize());
        
        basketballTeam.remove(madeUpPlayer);
        
        System.out.println("The size of the basketballTeam LinkedBag is:  " + basketballTeam.getCurrentSize());
        
        LinkedBag<String> courses2 = new LinkedBag<>();
        
        courses2.add("CSCI 161");
        courses2.add("PHIL 101");
        courses2.add("CHEM 150");
        courses2.add("CHEM 160");
        courses2.add("PHYS 252L");
        courses2.add("CSCI 493");
        
        courses2.remove();
        
        for(int i = 0; i < 5; i++)
        {
            System.out.println(courses2.get(i));
        }
    }
    
    /**
     * A private inner class with a single method meant to help with type safe casting of bytes.
     * Also limited to a min and max value inclusively.
     */
    private static class SafeScanByte
    {
        private static final Scanner SCAN = new Scanner(System.in);
        
        /**
         * Static Mutator Method:<BR>
         * Safely scans for a byte variable between and including the <B>min</B> 
         * and the <B>max</B> values supplied.  Displays the <B>displayText</B> 
         * once to prompt the user and displays <B>failText</B> whenever the 
         * entered value is either not a byte or not between the <B>min</B> and 
         * the <B>max</B> value.
         * @param displayText The text displayed to prompt the user.
         * @param failText The text displayed when the user fails to enter a proper value.
         * @param min The minimum value that can be returned, inclusive.
         * @param max The maximum value that can be returned, inclusive.
         * @return The number that the user has entered. (byte)
         */
        public static byte safeByteScanMinMax(String displayText, String failText, byte min, byte max)
        {
            System.out.println(displayText);
            
            byte b = 0;
            boolean flag = true;
            
            while(flag)
            {
                while(!SCAN.hasNextByte())
                {
                    System.out.println(failText);
                    SCAN.nextLine();
                }
                
                b = SCAN.nextByte();
                SCAN.nextLine();
                
                if(b >= min && b <= max)
                    flag = false;
                else
                    System.out.println(failText);
            }
            return b;
        }
    }
}