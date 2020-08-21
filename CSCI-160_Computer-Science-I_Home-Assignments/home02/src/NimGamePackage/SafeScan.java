package NimGamePackage;

import java.util.Scanner;

/**
 *
 * @author vanderlinde.monty
 */
public class SafeScan
{
    private static Scanner scan = new Scanner(System.in);
    
    public static int promptScanNextInt(int min, int max)
    {
        boolean flag = true;
        int scannedInt = 0;
        
        System.out.println("Please enter a number (" + min + " - " + max + ")");
        
        while(flag)
        {
            while(!scan.hasNextInt())
            {
                System.out.println("Please enter a number (" + min + " - " + max + ")");
                scan.nextLine();
            }
            
            scannedInt = scan.nextInt();
            scan.nextLine();
            
            if(scannedInt <= max && scannedInt >= min)
            {
                flag = false;
            }
            else
            {
                System.out.println("Please enter a number (" + min + " - " + max + ")");
            }
        }
        return scannedInt;
    }
}
