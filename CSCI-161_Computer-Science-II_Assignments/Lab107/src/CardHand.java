/**
 *
 * @author Monty Vanderlinde
 * @version 15 October 2017
 * 
 * A class that represents the concept of a hand of cards.
 * 
 */
public class CardHand
{
    private LinkedPositionalList<Card> hand;
    private Position<Card> firstSpade;
    private Position<Card> firstHeart;
    private Position<Card> firstClub;
    private Position<Card> firstDiamond;
    
    /**
     * Default Constructor:<BR>
     * Creates a new hand of cards with an empty LinkedPositionalList as a hand.  
     * The firstSpade, firstHeart, firstClub, and firstDiamond are set to null.
     */
    public CardHand()
    {
        this.hand = new LinkedPositionalList<>();
        this.firstSpade = null;
        this.firstHeart = null;
        this.firstClub = null;
        this.firstDiamond = null;
    }
    
    /**
     * Mutator Method:<BR>
     * Adds <B>newCard</B> to the hand of cards.  The card will be added in front 
     * of other cards of the same suit.  If that suit has not be added yet, then 
     * the card will be added to the end of the list.
     * @param newCard A new card to add to the hand.
     */
    public void addCard(Card newCard)
    {
        int suit = newCard.getSuit();
        
        //according to suit
        //if card is the first of its suit, add it to the back of the hand and set it to the appropriate firstSuit value
        //otherwise add card in front of the other cards of its suit and set it to the appropriate firstSuit value
        switch (suit)
        {
            case 0:
                if(this.firstSpade == null)
                    this.firstSpade = this.hand.addLast(newCard);
                else
                    this.firstSpade = this.hand.addBefore(this.firstSpade, newCard);
                break;
            case 1:
                if(this.firstHeart == null)
                    this.firstHeart = this.hand.addLast(newCard);
                else
                    this.firstHeart = this.hand.addBefore(this.firstHeart, newCard);
                break;
            case 2:
                if(this.firstClub == null)
                    this.firstClub = this.hand.addLast(newCard);
                else
                    this.firstClub = this.hand.addBefore(this.firstClub, newCard);
                break;
            case 3:
                if(this.firstDiamond == null)
                    this.firstDiamond = this.hand.addLast(newCard);
                else
                    this.firstDiamond = this.hand.addBefore(this.firstDiamond, newCard);
                break;
        }
    }
    
    /**
     * Iterator Constructor:<BR>
     * Constructs and returns a new iterator of the cardHand.
     * @return A new iterator of the cardHand.
     */
    public Iterator<Card> iterator()
    {
        return this.hand.elementIterator();
    }
    
    /**
     * Iterator Constructor:<BR>
     * Constructs and returns a new iterator of the cardHand, but only of the specified suit.<BR>
     * 0 = <B>♠</B>, 1 = <B>♥</B>, 2 = <B>♣</B>, 3 = <B>♦</B>
     * @param suit The suit of the card to get an iterator of. (0 = <B>♠</B>, 1 = <B>♥</B>, 2 = <B>♣</B>, 3 = <B>♦</B>)
     * @return An iterator of the appropriate suit of cards.
     */
    public Iterator<Card> suitIterator(int suit)
    {
        //new list of cards of specified suit
        LinkedPositionalList<Card> suitList = new LinkedPositionalList<>();
        
        //iterator of the entire hand
        Iterator<Card> iterate = this.hand.elementIterator();
        
        
        boolean flag = false;
        while(iterate.hasNext())
        {
            //only run once first card of specified suit is found
            if(flag)
            {
                //get next card
                Card next = iterate.next();
                
                //if card is not of specified suit, break while loop
                if(next.getSuit() != suit)
                    break;
                
                //add next card to suitList and return to top of loop
                suitList.addLast(next);
                continue;
            }
            
            //get next card
            Card next = iterate.next();
            
            //if card is of the specified suit
            if(next.getSuit() == suit)
            {
                //add card to suitList and set flag to true
                suitList.addFirst(next);
                flag = true;
            }
        }
        
        //return iterator of list of specified suit
        return suitList.elementIterator();
    }
}