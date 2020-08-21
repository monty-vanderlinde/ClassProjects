package SafeScan;

import java.util.Scanner;

/**
 *
 * @author Monty Vanderlinde
 * @version 26 August 2017
 * 
 * A class with methods for safely type-checking a scanned primitive variable.
 * 
 */
public class SafeScan
{
    private final static Scanner SCAN = new Scanner(System.in);
    
    private SafeScan(){}
    
    public static byte safeByteScan(String displayText, String failText)
    {
        System.out.println(displayText);
        
        byte b;
        
        while(!SCAN.hasNextByte())
        {
            System.out.println(failText);
            SCAN.nextLine();
        }
        
        b = SCAN.nextByte();
        SCAN.nextLine();
        
        return b;
    }
    
    public static byte safeByteScanMin(String displayText, String failText, byte min)
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
            
            if(b >= min)
                flag = false;
            else
                System.out.println(failText);
        }
        return b;
    }
    
    public static byte safeByteScanMax(String displayText, String failText, byte max)
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
            
            if(b <= max)
                flag = false;
            else
                System.out.println(failText);
        }
        return b;
    }
    
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
    
    public static short safeShortScan(String displayText, String failText)
    {
        System.out.println(displayText);
        
        short s;
        
        while(!SCAN.hasNextShort())
        {
            System.out.println(failText);
            SCAN.nextLine();
        }
        
        s = SCAN.nextShort();
        SCAN.nextLine();
        
        return s;
    }
    
    public static short safeShortScanMin(String displayText, String failText, short min)
    {
        System.out.println(displayText);
        
        short s = 0;
        boolean flag = true;
        
        while(flag)
        {
            while(!SCAN.hasNextShort())
            {
                System.out.println(failText);
                SCAN.nextLine();
            }
            
            s = SCAN.nextShort();
            SCAN.nextLine();
            
            if(s >= min)
                flag = false;
            else
                System.out.println(failText);
        }
        return s;
    }
    
    public static short safeShortScanMax(String displayText, String failText, short max)
    {
        System.out.println(displayText);
        
        short s = 0;
        boolean flag = true;
        
        while(flag)
        {
            while(!SCAN.hasNextShort())
            {
                System.out.println(failText);
                SCAN.nextLine();
            }
            
            s = SCAN.nextShort();
            SCAN.nextLine();
            
            if(s <= max)
                flag = false;
            else
                System.out.println(failText);
        }
        return s;
    }
    
    public static short safeShortScanMinMax(String displayText, String failText, short min, short max)
    {
        System.out.println(displayText);
        
        short s = 0;
        boolean flag = true;
        
        while(flag)
        {
            while(!SCAN.hasNextShort())
            {
                System.out.println(failText);
                SCAN.nextLine();
            }
            
            s = SCAN.nextShort();
            SCAN.nextLine();
            
            if(s >= min && s <= max)
                flag = false;
            else
                System.out.println(failText);
        }
        return s;
    }
    
    public static int safeIntScan(String displayText, String failText)
    {
        System.out.println(displayText);
        
        int i;
        
        while(!SCAN.hasNextInt())
        {
            System.out.println(failText);
            SCAN.nextLine();
        }
        
        i = SCAN.nextInt();
        SCAN.nextLine();
        
        return i;
    }
    
    public static int safeIntScanMin(String displayText, String failText, int min)
    {
        System.out.println(displayText);
        
        int i = 0;
        boolean flag = true;
        
        while(flag)
        {
            while(!SCAN.hasNextInt())
            {
                System.out.println(failText);
                SCAN.nextLine();
            }
            
            i = SCAN.nextInt();
            SCAN.nextLine();
            
            if(i >= min)
                flag = false;
            else
                System.out.println(failText);
        }
        return i;
    }
    
    public static int safeIntScanMax(String displayText, String failText, int max)
    {
        System.out.println(displayText);
        
        int i = 0;
        boolean flag = true;
        
        while(flag)
        {
            while(!SCAN.hasNextInt())
            {
                System.out.println(failText);
                SCAN.nextLine();
            }
            
            i = SCAN.nextInt();
            SCAN.nextLine();
            
            if(i <= max)
                flag = false;
            else
                System.out.println(failText);
        }
        return i;
    }
    
    public static int safeIntScanMinMax(String displayText, String failText, int min, int max)
    {
        System.out.println(displayText);
        
        int i = 0;
        boolean flag = true;
        
        while(flag)
        {
            while(!SCAN.hasNextInt())
            {
                System.out.println(failText);
                SCAN.nextLine();
            }
            
            i = SCAN.nextInt();
            SCAN.nextLine();
            
            if(i >= min && i <= max)
                flag = false;
            else
                System.out.println(failText);
        }
        return i;
    }
    
    public static long safeLongScan(String displayText, String failText)
    {
        System.out.println(displayText);
        
        long l;
        
        while(!SCAN.hasNextLong())
        {
            System.out.println(failText);
            SCAN.nextLine();
        }
        
        l = SCAN.nextLong();
        SCAN.nextLine();
        
        return l;
    }
    
    public static long safeLongScanMin(String displayText, String failText, long min)
    {
        System.out.println(displayText);
        
        long l = 0L;
        boolean flag = true;
        
        while(flag)
        {
            while(!SCAN.hasNextLong())
            {
                System.out.println(failText);
                SCAN.nextLine();
            }
            
            l = SCAN.nextLong();
            SCAN.nextLine();
            
            if(l >= min)
                flag = false;
            else
                System.out.println(failText);
        }
        return l;
    }
    
    public static long safeLongScanMax(String displayText, String failText, long max)
    {
        System.out.println(displayText);
        
        long l = 0L;
        boolean flag = true;
        
        while(flag)
        {
            while(!SCAN.hasNextLong())
            {
                System.out.println(failText);
                SCAN.nextLine();
            }
            
            l = SCAN.nextLong();
            SCAN.nextLine();
            
            if(l <= max)
                flag = false;
            else
                System.out.println(failText);
        }
        return l;
    }
    
    public static long safeLongScanMinMax(String displayText, String failText, long min, long max)
    {
        System.out.println(displayText);
        
        long l = 0L;
        boolean flag = true;
        
        while(flag)
        {
            while(!SCAN.hasNextLong())
            {
                System.out.println(failText);
                SCAN.nextLine();
            }
            
            l = SCAN.nextLong();
            SCAN.nextLine();
            
            if(l >= min && l <= max)
                flag = false;
            else
                System.out.println(failText);
        }
        return l;
    }
    
    public static float safeFloatScan(String displayText, String failText)
    {
        System.out.println(displayText);
        
        float f;
        
        while(!SCAN.hasNextFloat())
        {
            System.out.println(failText);
            SCAN.nextLine();
        }
        
        f = SCAN.nextFloat();
        SCAN.nextLine();
        
        return f;
    }
    
    public static float safeFloatScanMin(String displayText, String failText, float min)
    {
        System.out.println(displayText);
        
        float f = 0.0F;
        boolean flag = true;
        
        while(flag)
        {
            while(!SCAN.hasNextFloat())
            {
                System.out.println(failText);
                SCAN.nextLine();
            }
            
            f = SCAN.nextFloat();
            SCAN.nextLine();
            
            if(f >= min)
                flag = false;
            else
                System.out.println(failText);
        }
        return f;
    }
    
    public static float safeFloatScanMax(String displayText, String failText, float max)
    {
        System.out.println(displayText);
        
        float f = 0.0F;
        boolean flag = true;
        
        while(flag)
        {
            while(!SCAN.hasNextFloat())
            {
                System.out.println(failText);
                SCAN.nextLine();
            }
            
            f = SCAN.nextFloat();
            SCAN.nextLine();
            
            if(f <= max)
                flag = false;
            else
                System.out.println(failText);
        }
        return f;
    }
    
    public static float safeFloatScanMinMax(String displayText, String failText, float min, float max)
    {
        System.out.println(displayText);
        
        float f = 0.0F;
        boolean flag = true;
        
        while(flag)
        {
            while(!SCAN.hasNextFloat())
            {
                System.out.println(failText);
                SCAN.nextLine();
            }
            
            f = SCAN.nextFloat();
            SCAN.nextLine();
            
            if(f >= min && f <= max)
                flag = false;
            else
                System.out.println(failText);
        }
        return f;
    }
    
    public static double safeDoubleScan(String displayText, String failText)
    {
        System.out.println(displayText);
        
        double d;
        
        while(!SCAN.hasNextDouble())
        {
            System.out.println(failText);
            SCAN.nextLine();
        }
        
        d = SCAN.nextDouble();
        SCAN.nextLine();
        
        return d;
    }
    
    public static double safeDoubleScanMin(String displayText, String failText, double min)
    {
        System.out.println(displayText);
        
        double d = 0.0;
        boolean flag = true;
        
        while(flag)
        {
            while(!SCAN.hasNextDouble())
            {
                System.out.println(failText);
                SCAN.nextLine();
            }
            
            d = SCAN.nextDouble();
            SCAN.nextLine();
            
            if(d >= min)
                flag = false;
            else
                System.out.println(failText);
        }
        return d;
    }
    
    public static double safeDoubleScanMax(String displayText, String failText, double max)
    {
        System.out.println(displayText);
        
        double d = 0.0;
        boolean flag = true;
        
        while(flag)
        {
            while(!SCAN.hasNextDouble())
            {
                System.out.println(failText);
                SCAN.nextLine();
            }
            
            d = SCAN.nextDouble();
            SCAN.nextLine();
            
            if(d <= max)
                flag = false;
            else
                System.out.println(failText);
        }
        return d;
    }
    
    public static double safeDoubleScanMinMax(String displayText, String failText, double min, double max)
    {
        System.out.println(displayText);
        
        double d = 0.0;
        boolean flag = true;
        
        while(flag)
        {
            while(!SCAN.hasNextDouble())
            {
                System.out.println(failText);
                SCAN.nextLine();
            }
            
            d = SCAN.nextDouble();
            SCAN.nextLine();
            
            if(d >= min && d <= max)
                flag = false;
            else
                System.out.println(failText);
        }
        return d;
    }
}
