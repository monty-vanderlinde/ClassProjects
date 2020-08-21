
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Monty Vanderlinde
 * @version 25 October 2017
 * 
 * A client class for testing the ShuntingYardMath class.
 * 
 */
public class Client
{
    public static void main(String[] args) throws FileNotFoundException
    {
        //defaults to a data.txt file located in the project folder
        Scanner fileScan = new Scanner(new File("data.txt"));
        
        try
        {
            //String path = JOptionPane.showInternalInputDialog(null, "Please enter the full pathname of a file to read.");
            
            String path = "C:\\Users\\vanderlinde.monty\\Documents\\NetBeansProjects\\Lab108\\data.txt";
            
            fileScan = new Scanner(new File(path));
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println("FileNotFoundException was thrown.");
        }
        
        //singly linked list of all the lines in the file
        SinglyLinkedList<String> linesList = new SinglyLinkedList<>();
        
        //add all the lines in the file to listLines, kept in same order
        while(fileScan.hasNextLine())
        {
            linesList.addLast(fileScan.nextLine());
        }
        
        //close the file
        fileScan.close();
        
        int size = linesList.size();
        
        //for all the lines in the linesList
        for(int i = 0; i < size; i++)
        {
            //get the next line in the linesList
            String line = linesList.removeFirst();
            
            //print out the line
            System.out.println("Mathematical Expression:  " + line);
            
            //get the elements in postfix order in a linked queue
            LinkedQueue<String> treeElements = ShuntingYardMath.getPostfix(line);
            
            //if the mathematical expression was not formatted properly, then print message
            if(treeElements == null)
            {
                System.out.println("The mathematical expression is not properly formatted.");
            }
            //else, continue manipulating data
            else
            {
                LinkedQueue<String> temp = new LinkedQueue<>();
                
                System.out.print("Postfix Notation:  ");
                
                //print out the postfix notation and 
                while(!(treeElements.isEmpty()))
                {
                    String treeElement = treeElements.dequeue();
                    System.out.print(treeElement);
                    temp.enqueue(treeElement);
                }
                System.out.println();
                
                //create the expression tree
                LinkedBinaryTree<String> expressionTree = ShuntingYardMath.getExpressionTree(temp);
                
                //evaluate the expression tree and print out
                System.out.println("The expression equates to:  " + ShuntingYardMath.evaluateExpressionTree(expressionTree));
                
                //print prefix
                Iterator<String> prefixIter = expressionTree.iterator(1);
                System.out.print("Prefix Iteration:  ");
                boolean flag = false;
                while(prefixIter.hasNext())
                {
                    if(flag)
                    {
                        System.out.print(", ");
                        flag = true;
                    }
                    
                    System.out.print(prefixIter.next());
                }
                System.out.println();
                
                //print inorder
                Iterator<String> inorderIter = expressionTree.iterator(2);
                System.out.print("Inorder Iteration:  ");
                flag = false;
                while(inorderIter.hasNext())
                {
                    if(flag)
                    {
                        System.out.print(", ");
                        flag = true;
                    }
                    
                    System.out.print(inorderIter.next());
                }
                System.out.println();
                
                //print postfix
                Iterator<String> postfixIter = expressionTree.iterator(3);
                System.out.print("Postfix Iteration:  ");
                flag = false;
                while(postfixIter.hasNext())
                {
                    if(flag)
                    {
                        System.out.print(", ");
                        flag = true;
                    }
                    
                    System.out.print(postfixIter.next());
                }
                System.out.println();
                
                //print euler's tour
                System.out.println("Euler's Tour:  " + expressionTree.eulerTourBinary(expressionTree.root()));
            }
            
            //print out two lines between the end of one mathematical expression and the next.
            System.out.println();
        }
        
        System.out.println("That's all!");
    }
    
    /**
     * A private class for working with the Shunting Yard algorithm
     */
    private static class ShuntingYardMath
    {
        /**
         * Converts a mathematical expression, in the form of a string, into postfix notation, in the
         * form of a LinkedQueue.  Returns null if the mathematical expression is not formatted correctly.
         * @param line The mathematical expression in the form of a string.
         * @return A linked queue of the mathematical expression in postfix notation.
         * Null if the mathematical expression is not formatted correctly.
         */
        public static LinkedQueue<String> getPostfix(String line)
        {
            Scanner scan = new Scanner(line);
            LinkedQueue<String> postfixQueue = new LinkedQueue<>();
            LinkedStack<String> shuntStack = new LinkedStack<>();
            
            //true if the last item scanned in was a number
            //makes sure that two numbers cannot be added right next to eachother
            boolean wasLastPassANumber = false;
            
            //true if the last item scanned in was an operator
            //makes sure that two operators cannot be added right next to eachother
            boolean wasLastPassAnOperator = false;
            
            //while there are more elements in the original queue
            while(scan.hasNext())
            {
                //if the next token is an int, enqueue it.
                if(scan.hasNextInt())
                {
                    wasLastPassAnOperator = false;
                    
                    if(wasLastPassANumber)
                        return null;
                    
                    postfixQueue.enqueue(scan.next());
                    
                    wasLastPassANumber = true;
                }
                //else, check what it is
                else
                {
                    wasLastPassANumber = false;
                    
                    String s = scan.next();
                    
                    //if s is a +, -, *, /, (, [, or {, then push it on the stack
                    //if s is a ), ], or }, then pop off the stack into the queue until
                    //its counterpart is found, a different bracket is hit, or the end is hit
                    //if s is none of those, then return null
                    switch(s)
                    {
                        case "+":
                        case "-":
                            while(!(shuntStack.isEmpty()))
                            {
                                if(!(shuntStack.top().equals("(")) && !(shuntStack.top().equals("[")) && !(shuntStack.top().equals("{")))
                                    postfixQueue.enqueue(shuntStack.pop());
                                else
                                    break;
                            }
                        case "*":
                        case "/":
                            if(!(shuntStack.isEmpty()) && (s.equals("*") || s.equals("/")))
                            {
                                if(shuntStack.top().equals("*") || shuntStack.top().equals("/"))
                                    postfixQueue.enqueue(shuntStack.pop());
                            }
                            //if the last scanned item was also an operator, return null
                            if(wasLastPassAnOperator)
                                return null;
                            
                            wasLastPassAnOperator = true;
                        case "(":
                        case "[":
                        case "{":
                            shuntStack.push(s);
                            break;
                        case ")":
                            while(true)
                            {
                                String s2 = shuntStack.pop();
                                
                                //if a bracket pair is found, break (both brackets have already been removed)
                                if(s2.equals("("))
                                    break;
                                //if a wrong bracket is found, then return null, because the equation was bad
                                else if(s2.equals("[") || s2.equals("{"))
                                    return null;
                                //any numbers just get enqueued
                                else
                                    postfixQueue.enqueue(s2);
                                
                                //if there is nothing left in the stack, then return null, because the equation was bad
                                if(shuntStack.isEmpty())
                                    return null;
                            }
                            break;
                        case "]":
                            while(true)
                            {
                                String s2 = shuntStack.pop();
                                
                                //if a bracket pair is found, break (both brackets have already been removed)
                                if(s2.equals("["))
                                    break;
                                //if a wrong bracket is found, then return null, because the equation was bad
                                else if(s2.equals("(") || s2.equals("{"))
                                    return null;
                                //any numbers just get enqueued
                                else
                                    postfixQueue.enqueue(s2);
                                
                                //if there is nothing left in the stack, then return null, because the equation was bad
                                if(shuntStack.isEmpty())
                                    return null;
                            }
                            break;
                        case "}":
                            while(true)
                            {
                                String s2 = shuntStack.pop();
                                
                                //if a bracket pair is found, break (both brackets have already been removed)
                                if(s2.equals("{"))
                                    break;
                                //if a wrong bracket is found, then return null, because the equation was bad
                                else if(s2.equals("(") || s2.equals("["))
                                    return null;
                                //any numbers just get enqueued
                                else
                                    postfixQueue.enqueue(s2);
                                
                                //if there is nothing left in the stack, then return null, because the equation was bad
                                if(shuntStack.isEmpty())
                                    return null;
                            }
                            break;
                        default:
                            return null;
                    }
                }
                    
            }
            
            //add anything left in the stack to the queue
            while(!(shuntStack.isEmpty()))
            {
                String s = shuntStack.pop();
                
                //if one of the items left in the stack is an open bracket, then return null.
                //else, enqueue it
                switch(s)
                {
                    case "(":
                    case "[":
                    case "{":
                        return null;
                    default:
                        postfixQueue.enqueue(s);
                }
            }
            
            //if the last item was an operator, return null
            if(wasLastPassAnOperator)
                return null;
            
            return postfixQueue;
        }
        
        public static LinkedBinaryTree<String> getExpressionTree(LinkedQueue<String> postfixQueue)
        {
            LinkedStack<LinkedBinaryTree<String>> expressionstack = new LinkedStack<>();
            
            while(!(postfixQueue.isEmpty()))
            {
                String s = postfixQueue.dequeue();
                
                switch(s)
                {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        //create new single node tree
                        LinkedBinaryTree<String> temp1 = new LinkedBinaryTree<>();
                        temp1.addRoot(s);
                        
                        //pop off the right and the left tree
                        LinkedBinaryTree<String> right = expressionstack.pop();
                        LinkedBinaryTree<String> left = expressionstack.pop();
                        
                        temp1.attach(temp1.root(), left, right);
                        
                        expressionstack.push(temp1);
                        break;
                    default:
                        //create new single node tree and add it to the expression stack
                        LinkedBinaryTree<String> temp2 = new LinkedBinaryTree<>();
                        temp2.addRoot(s);
                        expressionstack.push(temp2);
                }
            }
            
            return expressionstack.pop();
        }
        
        public static int evaluateExpressionTree(LinkedBinaryTree<String> expressionTree)
        {
            return evaluateExpressionTreeRecursive(expressionTree, expressionTree.root());
        }
        
        private static int evaluateExpressionTreeRecursive(LinkedBinaryTree<String> expressionTree, Position<String> p)
        {
            String s = p.getElement();
            
            switch(s)
            {
                case "+":
                    int a = evaluateExpressionTreeRecursive(expressionTree, expressionTree.left(p));
                    int b = evaluateExpressionTreeRecursive(expressionTree, expressionTree.right(p));
                    return a + b;
                case "-":
                    int c = evaluateExpressionTreeRecursive(expressionTree, expressionTree.left(p));
                    int d = evaluateExpressionTreeRecursive(expressionTree, expressionTree.right(p));
                    return c - d;
                case "*":
                    int e = evaluateExpressionTreeRecursive(expressionTree, expressionTree.left(p));
                    int f = evaluateExpressionTreeRecursive(expressionTree, expressionTree.right(p));
                    return e * f;
                case "/":
                    int g = evaluateExpressionTreeRecursive(expressionTree, expressionTree.left(p));
                    int h = evaluateExpressionTreeRecursive(expressionTree, expressionTree.right(p));
                    return g / h;
                default:
                    return Integer.parseInt(s);
            }
        }
    }
}