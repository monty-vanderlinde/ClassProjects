/**
 *
 * @author Monty Vanderlinde
 * @version 05 October 2017
 * 
 * A client for testing the ArrayStack, LinkedStack, ArrayQueue, and LinkedQueue methods.
 * 
 */
public class Client
{
    public static void main(String[] args)
    {
        //try setting to 2.  Results are more interesting.
        int nMultiplier = 10;
        
        //current system time;
        long millis;
        //totals[0][x] are for the array total times
        //totals[1][x] are for the singly linked list total times
        long[][] totals = new long[2][40 / nMultiplier];
        
        //number of cycles that have passed in the respective while loop
        int arrayCycle = 0;
        int listCycle = 0;
        
        int n;
        
        ArrayQueue aq;
        ArrayStack as;
        
        LinkedQueue lq;
        LinkedStack ls;
        
        try
        {
            arrayCycle = 0;
            n = 1000000;
            
            while(true)
            {
                millis = System.currentTimeMillis();
                
                aq = new ArrayQueue(n);
                as = new ArrayStack(n);
                
                //load queue
                for(int i = 0; i < n; i++)
                    aq.enqueue(2147483647);
                
                //dequeue and push onto stack
                for(int i = 0; i < n; i++)
                    as.push(aq.dequeue());
                
                //pop stack and enqueue
                for(int i = 0; i < n; i++)
                    aq.enqueue(as.pop());
                
                //total time recorded
                totals[0][arrayCycle] = System.currentTimeMillis() - millis;
                
                //check if it will take more than 10 minutes on next run
                if(arrayCycle > 0)
                {
                    //experimentally calculated that each factor of 10 will increase the time by 26
                    //however, there is a bit of variability, so I chose 20 to guarantee
                    //that you will not be sitting around for more than 10 minutes
                    double multiplier = 20.0;
                    if(multiplier * (double) totals[0][arrayCycle] > 600000.0)
                    {
                        System.out.println("The next run would take more than ten minutes.");
                        break;
                    }
                }
                
                //increase cycle number
                arrayCycle++;
                
                //check to prevent int overflow error
                if(n >= 1000000000)
                    throw new ArithmeticException("Cannot test 10,000,000,000 items"
                            + " since an int cannot be greater than 2,147,483,647.");
                
                //increase n
                n = nMultiplier * n;
            }
        }
        //catch all exceptions
        catch(IllegalStateException ise)
        {
            System.out.println(ise.getMessage());
            System.out.println("IllegalStateException was thrown.  This should not happen.");
        }
        catch(IndexOutOfBoundsException ioobe)
        {
            System.out.println(ioobe.getMessage());
            System.out.println("IndexOutOfBoundsException was thrown.  This should not happen.");
        }
        catch(StackOverflowError soe)
        {
            System.out.println(soe.getMessage());
            System.out.println("StackOverflowError was thrown.  This should not happen.");
        }
        catch(ArithmeticException ae)
        {
            System.out.println(ae.getMessage());
            System.out.println(ae.getMessage());
        }
        catch(OutOfMemoryError oome)
        {
            System.out.println("Ran out of memory.");
            
            //clear memory
            aq = null;
            as = null;
        }
        
        try
        {
            listCycle = 0;
            n = 1000000;
            
            while(true)
            {
                millis = System.currentTimeMillis();
                
                lq = new LinkedQueue();
                ls = new LinkedStack();
                
                //load queue
                for(int i = 0; i < n; i++)
                    lq.enqueue(2147483647);
                
                //dequeue and push onto stack
                for(int i = 0; i < n; i++)
                    ls.push(lq.dequeue());
                
                //pop stack and equeue
                for(int i = 0; i < n; i++)
                    lq.enqueue(ls.pop());
                
                //total time recorded
                totals[1][listCycle] = System.currentTimeMillis() - millis;
                
                //check if it will take more than 10 minutes on next run
                if(listCycle > 0)
                {
                    //experimentally calculated that each factor of 10 will increase the time by 25
                    //however, there is a bit of variability, so I chose 20 to guarantee
                    //that you will not be sitting around for more than 10 minutes
                    double multiplier = 20.0;
                    if(multiplier * (double) totals[0][listCycle] > 600000.0)
                    {
                        System.out.println("The next run would take more than ten minutes.");
                        break;
                    }
                }
                
                //increase cycle number
                listCycle++;
                
                //check to prevent int overflow error
                if(n >= 1000000000)
                    throw new ArithmeticException("Cannot test 10,000,000,000 items"
                            + " since an int cannot be greater than 2,147,483,647.");
                
                //increase n
                n = nMultiplier * n;
            }
        }
        //catch all exceptions
        catch(IllegalStateException ise)
        {
            System.out.println(ise.getMessage());
            System.out.println("IllegalStateException was thrown.  This should not happen.");
        }
        catch(IndexOutOfBoundsException ioobe)
        {
            System.out.println(ioobe.getMessage());
            System.out.println("IndexOutOfBoundsException was thrown.  This should not happen.");
        }
        catch(StackOverflowError soe)
        {
            System.out.println(soe.getMessage());
            System.out.println("StackOverflowError was thrown.  This should not happen.");
        }
        catch(ArithmeticException ae)
        {
            System.out.println(ae.getMessage());
            System.out.println(ae.getMessage());
        }
        catch(OutOfMemoryError oome)
        {
            System.out.println("Ran out of memory.");
            
            //clear memory
            lq = null;
            ls = null;
        }
        
        //reset n
        n = 1000000;
        
        //calculate the maximum number of either cycle runs
        int mostRuns;
        if(arrayCycle > listCycle)
            mostRuns = arrayCycle;
        else if(arrayCycle < listCycle)
            mostRuns = listCycle;
        else
            mostRuns = listCycle;
        
        //print header
        System.out.format("%15s", "N");
        System.out.format("%15s", "Array");
        System.out.format("%15s%n", "List");
        
        //print data
        for(int i = 0; i < mostRuns; i++)
        {
            System.out.format("%,15d", n);
            
            if(arrayCycle < i)
                System.out.format("%15s", "Out of Memory");
            else
                System.out.format("%,15d", totals[0][i]);
            
            if(listCycle < i)
                System.out.format("%15s%n", "Out of Memory");
            else
                System.out.format("%,15d%n", totals[1][i]);
            
            //increase n
            n *= nMultiplier;
        }
    }
}