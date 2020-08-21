/**
 *
 * @author Monty Vanderlinde
 * @version 15 October 2017
 * 
 * A class that represents the concept of a playing card.
 * 
 */
public class Card
{
    private static final String[] SUIT = {"♠","♥","♣","♦"};
    private static final String[] VALUE = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    
    //index number of SUIT array
    private int suitNumber;
    
    //index number of VALUE array
    private int valueNumber;
    
    /**
     * Default Constructor:<BR>
     * A private default constructor to guarantee that it is never used.
     */
    private Card(){}
    
    /**
     * Overloaded Constructor:<BR>
     * Creates a card object with a specified <B>suit</B> and <B>value</B>.
     * @param suit The suit of the card. (0 = <B>♠</B>, 1 = <B>♥</B>, 2 = <B>♣</B>, 3 = <B>♦</B>)
     * @param value The value of the card. (0 = <B>A</B>, 1 = <B>2</B>, 2 = <B>3</B>, 3 = <B>4</B>, 4 = <B>5</B>, 5 = <B>6</B>, 6 = <B>7</B>, 7 = <B>8</B>, 8 = <B>9</B>, 9 = <B>10</B>, 10 = <B>J</B>, 11 = <B>Q</B>, 12 = <B>K</B>)
     */
    public Card(int suit, int value)
    {
        this.setSuit(suit);
        
        this.setValue(value);
    }
    
    /**
     * Mutator Method:<BR>
     * Set the suitNumber of the card.  Is private to guarantee that the suit cannot be changed, because that would be cheating.
     * @param i The suit of the card. (0 = <B>♠</B>, 1 = <B>♥</B>, 2 = <B>♣</B>, 3 = <B>♦</B>)
     */
    private void setSuit(int i)
    {
        if(i < 0)
            throw new ArrayIndexOutOfBoundsException("Card cannot be set with a suit number below 0.");
        
        if(i > 3)
            throw new ArrayIndexOutOfBoundsException("Card cannot be set with a suit number above 3.");
        
        this.suitNumber = i;
    }
    
    /**
     * Mutator Method:<BR>
     * Set the valueNumber of the card.  Is private to guarantee that the value cannot be changed, because that would be cheating.
     * @param i The value of the card. (0 = <B>A</B>, 1 = <B>2</B>, 2 = <B>3</B>, 3 = <B>4</B>, 4 = <B>5</B>, 5 = <B>6</B>, 6 = <B>7</B>, 7 = <B>8</B>, 8 = <B>9</B>, 9 = <B>10</B>, 10 = <B>J</B>, 11 = <B>Q</B>, 12 = <B>K</B>)
     */
    private void setValue(int i)
    {
        if(i < 0)
            throw new ArrayIndexOutOfBoundsException("Card cannot be set with a value number below 0.");
        
        if(i > 12)
            throw new ArrayIndexOutOfBoundsException("Card cannot be set with a value number above 12.");
        
        this.valueNumber = i;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns the suitNumber of the card.
     * @return The suit of the card. (0 = <B>♠</B>, 1 = <B>♥</B>, 2 = <B>♣</B>, 3 = <B>♦</B>)
     */
    public int getSuit()
    {
        return this.suitNumber;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns the valueNumber of the card.
     * @return The value of the card. (0 = <B>A</B>, 1 = <B>2</B>, 2 = <B>3</B>, 3 = <B>4</B>, 4 = <B>5</B>, 5 = <B>6</B>, 6 = <B>7</B>, 7 = <B>8</B>, 8 = <B>9</B>, 9 = <B>10</B>, 10 = <B>J</B>, 11 = <B>Q</B>, 12 = <B>K</B>)
     */
    public int getValue()
    {
        return this.valueNumber;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns a string representation of the card that is colored and does not have the class name.
     * @return A colored representation of the card.
     */
    public String cardString()
    {
        if(this.suitNumber == 1 || this.suitNumber == 3)//if it is a heart or a diamond, then return the suit and card value, but colored red.
            return "\033[31m" + Card.SUIT[this.suitNumber] + Card.VALUE[this.valueNumber] + "\033[0m";
        else//if it is a spade or a club, then return the suit and card value in standard black color.
            return Card.SUIT[this.suitNumber] + Card.VALUE[this.valueNumber];
    }
    
    /**
     * toString Method:<BR>
     * Returns a string representation of this card.
     * @return A representation of this Card as a string. (String)
     */
    @Override
    public String toString()
    {
        return getClass().getName() + ": " + Card.SUIT[this.suitNumber] + Card.VALUE[this.valueNumber];
    }
    
    /**
     * equals Method:<BR>
     * Returns the equality of this card and Object <B>o</B>.
     * @param o An object to compare to for equality.
     * @return A boolean representing the equality of this Card and Object <B>o</B>.
     */
    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof Card))
            return false;
        
        Card c = (Card) o;
        
        return (c.suitNumber == this.suitNumber) && (c.valueNumber == this.valueNumber);
    }
}