
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
 * An abstract class for creating an tree of general objects.
 * 
 * @param <T> A general object to store in the tree.
 * 
 */
public abstract class AbstractTree<T> implements Tree<T>
{
    private class ElementIterator implements Iterator<T>
    {
        private Iterator<Position<T>> posIterator;
        
        /**
         * Overloaded Constructor:<BR>
         * Constructs an element iterator that iterates in the specified order.
         * @param n Sets the iterator to be pre-order, in-order, post-order, or breadth-first for a value of 1, 2, 3, or 4 respectively.
         */
        public ElementIterator(int n)
        {
            this.posIterator = AbstractTree.this.positions(n).iterator();
        }
        
        @Override
        public boolean hasNext()
        {
            return this.posIterator.hasNext();
        }
        
        @Override
        public T next()
        {
            return this.posIterator.next().getElement();
        }
        
        @Override
        public void remove()
        {
            this.posIterator.remove();
        }
    }
    
    @Override
    public abstract Position<T> root();
    
    @Override
    public abstract Position<T> parent(Position<T> p) throws IllegalArgumentException;
    
    @Override
    public abstract Iterable<Position<T>> children(Position<T> p) throws IllegalArgumentException;
    
    @Override
    public abstract int numChildren(Position<T> p) throws IllegalArgumentException;
    
    @Override
    public boolean isInternal(Position<T> p) throws IllegalArgumentException
    {
        return this.numChildren(p) > 0;
    }
    
    @Override
    public boolean isExternal(Position<T> p) throws IllegalArgumentException
    {
        return this.numChildren(p) == 0;
    }
    
    @Override
    public boolean isRoot(Position<T> p) throws IllegalArgumentException
    {
        return this.root() == p;
    }
    
    @Override
    public abstract int size();
    
    @Override
    public boolean isEmpty()
    {
        return this.size() == 0;
    }
    
    @Override
    public Iterator<T> iterator()
    {
        return new ElementIterator(1);  //default iterator of AbstractTree is preorder
    }
    
    /**
     * 
     * @param n
     * @return 
     */
    @Override
    public Iterator<T> iterator(int n)
    {
        return new ElementIterator(n);
    }
    
    @Override
    public Iterable<Position<T>> positions(int n) throws IllegalArgumentException
    {
        if(n > 4 || n < 1)
            throw new IllegalArgumentException("n can only be a 1, 2, 3, or 4.");
        
        switch (n)
        {
            case 1:
                return this.preorder();
            case 2:
                return this.inorder();
            case 3:
                return this.postorder();
            default:
                return this.breadthFirst();
        }
    }
    
    public Iterable<Position<T>> preorder()
    {
        List<Position<T>> snapshot = new ArrayList<>();
        
        if(!(this.isEmpty()))
            this.preorderSubtree(this.root(), snapshot);
        
        return snapshot;
    }
    
    public abstract Iterable<Position<T>> inorder();
    
    public Iterable<Position<T>> postorder()
    {
        List<Position<T>> snapshot = new ArrayList<>();
        
        if(!(this.isEmpty()))
            this.postorderSubtree(this.root(), snapshot);
        
        return snapshot;
    }
    
    public Iterable<Position<T>> breadthFirst()
    {
        List<Position<T>> snapshot = new ArrayList<>();
        
        if(!(this.isEmpty()))
        {
            LinkedQueue<Position<T>> fringe = new LinkedQueue();
            
            fringe.enqueue(this.root());
            
            while(!(fringe.isEmpty()))
            {
                Position<T> p = fringe.dequeue();
                
                snapshot.add(p);
                
                for(Position<T> c : this.children(p))
                    fringe.enqueue(c);
            }
        }
        
        return snapshot;
    }
    
    private void preorderSubtree(Position<T> p, List<Position<T>> snapshot)
    {
        snapshot.add(p);
        
        for(Position<T> c : this.children(p))
            this.preorderSubtree(c, snapshot);
    }
    
    private void postorderSubtree(Position<T> p, List<Position<T>> snapshot)
    {
        for(Position<T> c : this.children(p))
            this.postorderSubtree(c, snapshot);
        
        snapshot.add(p);
    }
    
    public int depth(Position<T> p)
    {
        if(this.isRoot(p))
            return 0;
        else
            return 1 + this.depth(this.parent(p));
    }
    
    public int height(Position<T> p)
    {
        int h = 0;
        
        for(Position<T> c : this.children(p))
            h = Math.max(h, 1 + this.height(c));
        
        return h;
    }
}