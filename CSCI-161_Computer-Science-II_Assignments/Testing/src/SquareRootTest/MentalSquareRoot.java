package SquareRootTest;

/**
 *
 * @author Mon
 */
public class MentalSquareRoot
{
    private MentalSquareRoot(){}
    
    public static double testMentalSquareRoot(int square)
    {
        if(square < 1)
        {
            System.out.println("Does not work with negative numbers or 0.");
            return Double.NaN;
        }
        
        int i = 0;
        while(((i + 1) * (i + 1)) <= square)
        {
            if(((i + 1) * (i + 1)) == square)
            {
                return (double)(i + 1);
            }
            i++;
        }
        
        return i + ((double) ((square) - (i * i)) / (2 * i));
    }
    
    public static void printMentalAndActualRoots(int largestRoot)
    {
        double maximum = 0.0;
        String maximumPosition = "None";
        double minumum = 0.0;
        String minimumPosition = "None";
        double[] mental = new double[largestRoot];
        double[] actual = new double[largestRoot];
        double[] differenceMA = new double[largestRoot];
        
        for(int i = 0; i < largestRoot; i++)
        {
            mental[i] = MentalSquareRoot.testMentalSquareRoot((i + 1));
            actual[i] = Math.sqrt((i + 1));
            differenceMA[i] = mental[i] - actual[i];
            if(differenceMA[i] > maximum)
            {
                maximum = differenceMA[i];
                maximumPosition = String.valueOf((i + 1));
            }
            if(differenceMA[i] < minumum)
            {
                minumum = differenceMA[i];
                minimumPosition = String.valueOf((i + 1));
            }
        }
        
        for(int i = 0; i < largestRoot; i++)
        {
            System.out.println("Number:  " + (i + 1) + "\nMental:  " + mental[i] + "\nActual:  " + actual[i] + "\nDifference:  " + differenceMA[i] + "\n");
        }
        
        System.out.println("Maximum difference was found at:  " + maximumPosition + "\t\tMaximum:  " + maximum + "\nMinimum difference was found at:  " + minimumPosition + "\t\tMinimum:  " + minumum);
    }
}
