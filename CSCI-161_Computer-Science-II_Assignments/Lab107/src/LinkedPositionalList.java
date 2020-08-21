
import java.util.NoSuchElementException;

/**
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @author (modified by) Monty Vanderlinde
 * 
 * @version 15 October 2017
 * 
 * A class for a linked list of positions of general objects.
 * 
 * @param <T> A generic object located in the linked positional list.
 * 
 */
public class LinkedPositionalList<T> implements PositionalList<T>
{
    private static class Node<T> implements Position<T>
    {
        private T element;
        private Node<T> next;
        private Node<T> previous;
        
        public Node(T element, Node<T> previous, Node<T> next)
        {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }
        
        @Override
        public T getElement() throws IllegalStateException
        {
            if(this.next == null)
                throw new IllegalStateException("Position no longer valid.");
            
            return this.element;
        }
        
        public Node<T> getPrev()
        {
            return this.previous;
        }
        
        public Node<T> getNext()
        {
            return this.next;
        }
        
        public void setElement(T element)
        {
            this.element = element;
        }
        
        public void setPrevious(Node<T> previous)
        {
            this.previous = previous;
        }
        
        public void setNext(Node<T> next)
        {
            this.next = next;
        }
    }
    
    private class PositionIterator implements Iterator<Position<T>>
    {
        private Position<T> cursor;
        private Position<T> recent;
        
        public PositionIterator()
        {
            cursor = LinkedPositionalList.this.first();
            recent = null;
        }
        
        @Override
        public boolean hasNext()
        {
            return (this.cursor != null);
        }
        
        @Override
        public Position<T> next() throws NoSuchElementException
        {
            if(this.cursor == null)
                throw new NoSuchElementException("Nothing left.");
            
            this.recent = this.cursor;
            this.cursor = LinkedPositionalList.this.after(this.cursor);
            
            return this.recent;
        }
        
        @Override
        public void remove() throws IllegalStateException
        {
            if(this.recent == null)
                throw new IllegalStateException("Nothing to remove.");
            
            LinkedPositionalList.this.remove(this.recent);
            
            this.recent = null;
        }
    }
    
    private class PositionIterable implements Iterable<Position<T>>
    {
        public PositionIterable(){}
        
        @Override
        public Iterator<Position<T>> iterator()
        {
            return new PositionIterator();
        }
    }
    
    public Iterable<Position<T>> positionsIterable()
    {
        return new PositionIterable();
    }
    
    private class ElementIterator implements Iterator<T>
    {
        Iterator<Position<T>> positionIterator;
        
        public ElementIterator()
        {
            this.positionIterator = new PositionIterator();
        }
        
        @Override
        public boolean hasNext()
        {
            return this.positionIterator.hasNext();
        }
        
        @Override
        public T next()
        {
            return this.positionIterator.next().getElement();
        }
        
        @Override
        public void remove()
        {
            this.positionIterator.remove();
        }
    }
    
    public Iterator<T> elementIterator()
    {
        return new ElementIterator();
    }
    
    private Node<T> header;
    private Node<T> trailer;
    private int size;
    
    public LinkedPositionalList()
    {
        this.header = new Node<>(null, null, null);
        this.trailer = new Node<>(null, this.header, null);
        this.header.setNext(this.trailer);
        this.size = 0;
    }
    
    private Node<T> validate(Position<T> position) throws IllegalArgumentException
    {
        if(!(position instanceof Node))
            throw new IllegalArgumentException("Invalid position.");
        
        Node<T> node = (Node<T>) position;
        
        if(node.getNext() == null)
            throw new IllegalArgumentException("Position is no longer in the list.");
        
        return node;
    }
    
    private Position<T> position(Node<T> node)
    {
        if(node == this.header || node == this.trailer)
            return null;
        
        return node;
    }
    
    @Override
    public int size()
    {
        return this.size;
    }
    
    @Override
    public boolean isEmpty()
    {
        return (this.size == 0);
    }
    
    @Override
    public Position<T> first()
    {
        return this.position(this.header.getNext());
    }
    
    @Override
    public Position<T> last()
    {
        return this.position(this.trailer.getPrev());
    }
    
    @Override
    public Position<T> before(Position<T> position) throws IllegalArgumentException
    {
        Node<T> node = this.validate(position);
        
        return this.position(node.getPrev());
    }
    
    @Override
    public Position<T> after(Position<T> position) throws IllegalArgumentException
    {
        Node<T> node = this.validate(position);
        
        return this.position(node.getNext());
    }
    
    private Position<T> addBetween(T element, Node<T> predecessor, Node<T> successor)
    {
        Node<T> newest = new Node<>(element, predecessor, successor);
        
        predecessor.setNext(newest);
        successor.setPrevious(newest);
        
        this.size++;
        
        return newest;
    }
    
    @Override
    public Position<T> addFirst(T element)
    {
        return this.addBetween(element, this.header, this.header.getNext());
    }
    
    @Override
    public Position<T> addLast(T element)
    {
        return this.addBetween(element, this.trailer.getPrev(), this.trailer);
    }
    
    @Override
    public Position<T> addBefore(Position<T> position, T element) throws IllegalArgumentException
    {
        Node<T> node = this.validate(position);
        
        return this.addBetween(element, node.getPrev(), node);
    }
    
    @Override
    public Position<T> addAfter(Position<T> position, T element) throws IllegalArgumentException
    {
        Node<T> node = this.validate(position);
        
        return this.addBetween(element, node, node.getNext());
    }
    
    @Override
    public T set(Position<T> position, T element) throws IllegalArgumentException
    {
        Node<T> node = this.validate(position);
        
        T answer = node.getElement();
        
        node.setElement(element);
        
        return answer;
    }
    
    @Override
    public T remove(Position<T> position) throws IllegalArgumentException
    {
        Node<T> node = this.validate(position);
        
        Node<T> predecessor = node.getPrev();
        Node<T> successor = node.getNext();
        
        predecessor.setNext(successor);
        successor.setPrevious(predecessor);
        
        this.size--;
        
        T answer = node.getElement();
        
        node.setElement(null);
        node.setNext(null);
        node.setPrevious(null);
        
        return answer;
    }
}