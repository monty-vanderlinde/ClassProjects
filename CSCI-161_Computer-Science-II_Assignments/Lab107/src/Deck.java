
import java.util.Random;

/**
 *
 * @author Monty Vanderlinde
 * @version 15 October 2017
 * 
 * A class that represents the concept of a deck of cards.
 * 
 */
public class Deck
{
    private static final Random RAND = new Random();
    private LinkedStack<Card> deck;
    
    /**
     * Default Constructor:<BR>
     * Creates a new deck of all 52 cards, as a stack, and fills the stack in a random order.
     */
    public Deck()
    {
        this.deck = new LinkedStack<>();
        
        this.populate();
    }
    
    /**
     * Mutator Method:<BR>
     * Fills the stack with all 52 cards in a random order.
     */
    private void populate()
    {
        
        //create an array of 52 cards
        Card[] c = new Card[52];
        
        //fill array with all possible cards
        for(int i = 0; i < 4; i ++)
        {
            for(int j = 0; j < 13; j++)
            {
                c[(13 * i) + j] = new Card(i, j);
            }
        }
        
        //move random card from array to deck stack
        for(int i = 0; i < 52; i++)
        {
            int j;
            
            //get random array index from currently accessible part of array
            if(i != 51)
                j = RAND.nextInt(51 - i);
            else
                j = 0;
            
            //get random card
            Card temp = c[j];
            
            //replace last card in currently accessible part of array with the random card
            c[j] = c[51 - i];
            c[51 - i] = temp;
            
            //push random card onto deck stack
            this.deck.push(temp);
        }
    }
    
    /**
     * Accessor Method:<BR>
     * Pops a card off the deck stack.
     * @return A card from the stack.
     */
    public Card card()
    {
        return this.deck.pop();
    }
    
    /**
     * Accessor Method:<BR>
     * Returns the number of cards left in the deck stack.
     * @return The number of cards left in the deck stack.
     */
    public int cardsLeft()
    {
        return this.deck.size();
    }
    
    /**
     * Accessor Method:<BR>
     * Returns true if the deck stack is empty.  Otherwise, false.
     * @return True if the deck stack is empty.  Otherwise, false.
     */
    public boolean isEmpty()
    {
        return (this.deck.size() == 0);
    }
}