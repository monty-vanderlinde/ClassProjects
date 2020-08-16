package NimGamePackage;

import java.util.Random;

/**
 *
 * @author vanderlinde.monty
 */
public class InclusiveRandom
{
    private static Random rand = new Random();
    
    public static int getRand(int min, int max)
    {
        return rand.nextInt(max - min +  1) + min;
    }
}
