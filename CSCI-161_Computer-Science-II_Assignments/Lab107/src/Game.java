/**
 *
 * @author Monty Vanderlinde
 * @version 15 October 2017
 * 
 * A class that represents the concept of a card game.
 * 
 */
public class Game
{
    private int numberOfPlayers;
    private int maximumNumberOfCards;
    private Deck cardDeck;
    private CardHand[] hands;
    
    /**
     * Default Constructor:<BR>
     * A private default constructor to guarantee that it will never be used.
     */
    private Game(){}
    
    /**
     * Overloaded Constructor:<BR>
     * Creates a card game with a given number of players and maximum number of cards per person.  
     * If the number of cards times the number of players is more than 52, throws an IllegalArgumentException.
     * @param numberOfPlayers The number of players playing the card game;
     * @param maximumNumberOfCards The number of cards to deal to each player.  
     * If the number of cards times the number of players is more than 52, throws an IllegalArgumentException.
     */
    public Game(int numberOfPlayers, int maximumNumberOfCards)
    {
        this.numberOfPlayers = numberOfPlayers;
        
        //check to make sure that there are not too many players to deal cards to.
        this.maximumNumberOfCards = this.checkMaximumNumber(numberOfPlayers, maximumNumberOfCards);
        this.cardDeck = new Deck();
        
        //set size of hands array to the number of players
        this.hands = new CardHand[numberOfPlayers];
        
        //fill hands with new card hands
        for(int i = 0; i < numberOfPlayers; i++)
            this.hands[i] = new CardHand();
    }
    
    /**
     * Mutator method:<BR>
     * Checks if the number of cards times the number of players is more than 52.
     * @param numberOfPlayers The number of players playing the card game;
     * @param maximumNumberOfCards The number of cards to deal to each player.  
     * If the number of cards times the number of players is more than 52, throws an IllegalArgumentException.
     * @return The maximum number of cards, if the number of cards times the number of players is less or equal to 52.
     * @throws IllegalArgumentException Thrown if the number of cards times the number of players is more than 52.
     */
    private int checkMaximumNumber(int numberOfPlayers, int maximumNumberOfCards) throws IllegalArgumentException
    {
        if(numberOfPlayers * maximumNumberOfCards > 52)
            throw new IllegalArgumentException("There are not enough cards for all " + numberOfPlayers + " players to have " + maximumNumberOfCards + " cards.");
        else
            return maximumNumberOfCards;
    }
    
    /**
     * Mutator Method:<BR>
     * Deals a new card to the hand of each of the players in the game.  
     * If there are not enough cards left to deal, then throws an IllegalArgumentException.
     * @throws IllegalArgumentException If there are not enough cards left to deal.
     */
    public void getCard() throws IllegalArgumentException
    {
        //if there are enough cards left to deal to each player
        if(!(this.canDealCards()))
            throw new IllegalArgumentException("There are not enough cards left to deal.");
        
        //deal cards to each player
        for(int i = 0; i < this.hands.length; i++)
            this.hands[i].addCard(this.cardDeck.card());
    }
    
    /**
     * Accessor Method:<BR>
     * Checks if there are enough cards left to deal to each of the players.
     * @return True if there are enough cards left to deal to each of the players.  Otherwise, false.
     */
    public boolean canDealCards()
    {
        return (this.cardDeck.cardsLeft() >= this.hands.length);
    }
    
    /**
     * Print Method:<BR>
     * Prints out the formatted hands of each of the players in the game.
     */
    public void printHands()
    {
        //for all players in the game
        for(int i = 0; i < this.hands.length; i++)
        {
            //print player number
            System.out.print("\tPlayer " + (i + 1) + ":");
            
            //create iterator of that hand
            Iterator<Card> playerIterator = this.hands[i].iterator();
            
            //while that player has more cards left, print all cards in proper format
            while(playerIterator.hasNext())
                System.out.print("\t" + playerIterator.next().cardString());
            
            System.out.println();
        }
    }
}