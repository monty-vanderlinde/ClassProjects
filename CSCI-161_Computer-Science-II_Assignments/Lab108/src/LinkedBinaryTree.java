/**
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @author (modified by) Monty Vanderlinde
 * 
 * @version 20 October 2017
 * 
 * A class for creating a linked binary tree of general objects;
 * 
 * @param <T> A generic object to add to the linked binary tree.
 * 
 */
public class LinkedBinaryTree<T> extends AbstractBinaryTree<T>
{
    private static class Node<T> implements Position<T>
    {
        private T element;
        private Node<T> parent;
        private Node<T> left;
        private Node<T> right;
        
        public Node(T element, Node<T> above, Node<T> leftChild, Node<T> rightChild)
        {
            this.element = element;
            this.parent = above;
            this.left = leftChild;
            this.right = rightChild;
        }
        
        @Override
        public T getElement() throws IllegalStateException
        {
            return this.element;
        }
        
        public Node<T> getParent()
        {
            return this.parent;
        }
        
        public Node<T> getLeft()
        {
            return this.left;
        }
        
        public Node<T> getRight()
        {
            return this.right;
        }
        
        public void setElement(T element)
        {
            this.element = element;
        }
        
        public void setParent(Node<T> parent)
        {
            this.parent = parent;
        }
        
        public void setLeft(Node<T> leftChild)
        {
            this.left = leftChild;
        }
        
        public void setRight(Node<T> rightChild)
        {
            this.right = rightChild;
        }
    }
    
    private Node<T> createNode(T element, Node<T> parent, Node<T> left, Node<T> right)
    {
        return new Node<>(element, parent, left, right);
    }
    
    private Node<T> root;
    private int size;
    
    public LinkedBinaryTree()
    {
        this.root = null;
        this.size = 0;
    }
    
    private Node<T> validate(Position<T> p) throws IllegalArgumentException
    {
        if(!(p instanceof Node))
            throw new IllegalArgumentException("Not valid Position type.");
        
        Node<T> node = (Node<T>) p;
        
        if(node.getParent() == node)
            throw new IllegalArgumentException("p is no longer in the tree.");
        
        return node;
    }
    
    @Override
    public int size()
    {
        return this.size;
    }
    
    @Override
    public Position<T> root()
    {
        return this.root;
    }
    
    @Override
    public Position<T> parent(Position<T> p) throws IllegalArgumentException
    {
        Node node = this.validate(p);
        return node.getParent();
    }
    
    @Override
    public Position<T> left(Position<T> p) throws IllegalArgumentException
    {
        Node node = this.validate(p);
        return node.getLeft();
    }
    
    @Override
    public Position<T> right(Position<T> p) throws IllegalArgumentException
    {
        Node node = this.validate(p);
        return node.getRight();
    }
    
    public Position<T> addRoot(T element) throws IllegalArgumentException
    {
        if(!(this.isEmpty()))
            throw new IllegalArgumentException("Tree is not empty.");
        
        this.root = this.createNode(element, null, null, null);
        this.size = 1;
        
        return this.root;
    }
    
    public Position<T> addLeft(Position<T> p, T element) throws IllegalArgumentException
    {
        Node<T> parent = this.validate(p);
        
        if(parent.getLeft() != null)
            throw new IllegalArgumentException("p already has a left child.");
        
        Node<T> leftChild = this.createNode(element, parent, null, null);
        
        parent.setLeft(leftChild);
        
        this.size++;
        
        return leftChild;
    }
    
    public Position<T> addRight(Position<T> p, T element) throws IllegalArgumentException
    {
        Node<T> parent = this.validate(p);
        
        if(parent.getRight() != null)
            throw new IllegalArgumentException("p already has a right child.");
        
        Node<T> rightChild = this.createNode(element, parent, null, null);
        
        parent.setRight(rightChild);
        
        this.size++;
        
        return rightChild;
    }
    
    public T set(Position<T> p, T element) throws IllegalArgumentException
    {
        Node<T> node = this.validate(p);
        
        T temp = node.getElement();
        
        node.setElement(element);
        
        return temp;
    }
    
    public void attach(Position<T> p, LinkedBinaryTree<T> leftTree, LinkedBinaryTree<T> rightTree) throws IllegalArgumentException
    {
        Node<T> node = this.validate(p);
        
        if(this.isInternal(p))
            throw new IllegalArgumentException("p must be a leaf.");
        
        this.size += (leftTree.size + rightTree.size);
        
        if(!(leftTree.isEmpty()))
        {
            leftTree.root.setParent(node);
            node.setLeft(leftTree.root);
            leftTree.root = null;
            leftTree.size = 0;
        }
        
        if(!(rightTree.isEmpty()))
        {
            rightTree.root.setParent(node);
            node.setRight(rightTree.root);
            rightTree.root = null;
            rightTree.size = 0;
        }
    }
    
    public T remove(Position<T> p) throws IllegalArgumentException
    {
        Node<T> node = this.validate(p);
        
        if(this.numChildren(p) == 2)
            throw new IllegalArgumentException("p has two children.");
        
        Node<T> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        
        if(child != null)
            child.setParent(node.getParent());
        
        if(node == this.root)
            this.root = child;
        else
        {
            Node<T> parent = node.getParent();
            
            if(node == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
        
        this.size--;
        
        T temp = node.getElement();
        
        node.setElement(null);
        node.setParent(node);
        node.setLeft(null);
        node.setRight(null);
        
        return temp;
    }
    
    public String eulerTourBinary(Position<T> p)
    {
        String s = "(";
        
        if(this.left(p) != null)
            s += eulerTourBinary(this.left(p));
        
        s += p.getElement();
        
        if(this.right(p) != null)
            s += eulerTourBinary(this.right(p));
        
        s += ")";
        
        return s;
    }
}