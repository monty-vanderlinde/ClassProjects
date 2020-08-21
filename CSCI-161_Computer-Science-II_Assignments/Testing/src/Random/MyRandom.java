package Random;

import java.util.Random;

/**
 *
 * @author Monty Vanderlinde
 */
public class MyRandom
{
    private static final Random RAND =  new Random();
    
    public static int inclusiveRandom(int min, int max)
    {
        return MyRandom.RAND.nextInt(max - min + 1) + min;
    }
    
    public static int exclusiveRandom(int min, int max)
    {
        return MyRandom.RAND.nextInt(max - min - 1) + min + 1;
    }
}
