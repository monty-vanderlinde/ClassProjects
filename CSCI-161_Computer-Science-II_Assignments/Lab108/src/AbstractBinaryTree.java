
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @author (modified by) Monty Vanderlinde
 * 
 * @version 15 October 2017
 * 
 * An abstract class for creating an binary tree of general objects.
 * 
 * @param <T> A general object to store in the binary tree.
 * 
 */
public abstract class AbstractBinaryTree<T> extends AbstractTree<T> implements BinaryTree<T>
{
    @Override
    public abstract Position<T> left(Position<T> p) throws IllegalArgumentException;
    
    @Override
    public abstract Position<T> right(Position<T> p) throws IllegalArgumentException;
    
    @Override
    public Position<T> sibling(Position<T> p) throws IllegalArgumentException
    {
        Position<T> parent = this.parent(p);
        
        if(parent == null)
            return null;
        
        if(p == this.left(parent))
            return this.right(parent);
        else
            return this.left(parent);
    }
    
    @Override
    public abstract Position<T> root();
    
    @Override
    public abstract Position<T> parent(Position<T> p) throws IllegalArgumentException;
    
    @Override
    public Iterable<Position<T>> children(Position<T> p) throws IllegalArgumentException
    {
        List<Position<T>> snapshot = new ArrayList<>(2);
        
        if(this.left(p) != null)
            snapshot.add(this.left(p));
        
        if(this.right(p) != null)
            snapshot.add(this.right(p));
        
        return snapshot;
    }
    
    @Override
    public int numChildren(Position<T> p) throws IllegalArgumentException
    {
        int count = 0;
        
        if(this.left(p) != null)
            count++;
        
        if(this.right(p) != null)
            count++;
        
        return count;
    }
    
    @Override
    public abstract int size();
    
    @Override
    public Iterator<T> iterator()
    {
        return this.iterator(2);  //default iterator of AbstractTree is inorder
    }
    
    @Override
    public Iterable<Position<T>> inorder()
    {
        List<Position<T>> snapshot = new ArrayList<>();
        
        if(!(this.isEmpty()))
            this.inorderSubtree(this.root(), snapshot);
        
        return snapshot;
    }
    
    private void inorderSubtree(Position<T> p, List<Position<T>> snapshot)
    {
        if(this.left(p) != null)
            this.inorderSubtree(this.left(p), snapshot);
        
        snapshot.add(p);
        
        if(this.right(p) != null)
            this.inorderSubtree(this.right(p), snapshot);
    }
}