package NimGamePackage;

/**
 *
 * @author monty.vanderlinde
 */
public class Pile
{
    private int size;
    
    public Pile(int size)
    {
        this.size = size;
    }
    
    public int getSize()
    {
        return size;
    }
    
    public void remove(int count)
    {
        size -= count;
    }
    
    public void printPile()
    {
        //print lines of 10 marbles
        for(int i = 0; i < size / 10;  i++)
        {
            System.out.println("0000000000");
        }
        
        //print excess individual marbles
        if(size % 10 != 0)
        {
            for(int i = 0; i < size % 10;  i++)
            {
                System.out.print("0");
            }
            System.out.print("\n\n");
        }
    }
}
