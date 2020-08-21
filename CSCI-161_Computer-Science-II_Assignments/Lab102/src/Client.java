
import java.util.Random;

/**
 *
 * @author Monty Vanderlinde
 * @version 06 September 2017
 * 
 * A client for testing the scores class and its methods.
 * 
 */
public class Client
{
    public static void main(String[] args)
    {
        Scores myScores = new Scores(100);
        Random rand = new Random();
        for(int i = 0; i < 100; i++)
        {
            myScores.add(rand.nextInt(201) - 100);//nextInt(max - min + 1) + min
        }
        
        System.out.println(myScores.toString());
        
        myScores.add(86);
        
        System.out.println(myScores.getCurrentSize());
        
        myScores.remove();
        
        int seventyFive = myScores.get(75);
        
        System.out.println(myScores.getFrequencyOf(seventyFive));
        
        myScores.remove(seventyFive);
        
        System.out.println(myScores.getFrequencyOf(seventyFive));
        
        System.out.println(myScores.getFrequencyOf(86));
        
        System.out.println(myScores.contains(86));
        
        System.out.println(myScores.toString());
    }
}