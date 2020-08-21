
import java.text.DecimalFormat;

/**
 *
 * @author Monty Vanderlinde
 * @version 16 November 2017
 * 
 * A client for testing the TreeMap and AVLTreeMap classes.
 * 
 */
public class Client
{
    public static void main(String[] args)
    {
        //number of entries to add
        int N = 8800;
        
        //to format N in the output
        DecimalFormat format = new DecimalFormat("#,##0");
        
        //title
        System.out.println("====== TreeMap ======");
        
        //create normal tree map
        TreeMap t = new TreeMap();
        
        //output size and height before insertions
        System.out.println("Before any insertions:");
        System.out.println("Tree Map size = " + t.size());
        System.out.println("Tree Map height = " + t.tree.height(t.root()));
        
        //fill with integer objects at the same key as the integer
        for(int i = 0; i < N; i++)
            t.put(i, new Integer(i));
        
        //output size and height after insertions
        System.out.println("\nAfter " + format.format(N) + " insertions:");
        System.out.println("Tree Map size = " + t.size());
        System.out.println("Tree Map height = " + t.tree.height(t.root()));
        
        //spaces between sections
        System.out.println("\n");
        
        //title
        System.out.println("===== AVLTreeMap =====");
        
        //create AVL tree map
        AVLTreeMap a = new AVLTreeMap();
        
        //output size and height before insertions
        System.out.println("Before any insertions:");
        System.out.println("AVL Tree Map size = " + a.size());
        System.out.println("AVL Tree Map height = " + a.height(a.root()));
        
        //fill with integer objects at the same key as the integer
        for(int i = 0; i < N; i++)
        {
            a.put(i, new Integer(i));
        }
        
        //output size and height after insertions
        System.out.println("\nAfter " + format.format(N) + " insertions:");
        System.out.println("AVL Tree Map size = " + a.size());
        System.out.println("AVL Tree Map height = " + a.height(a.root()));
    }
}