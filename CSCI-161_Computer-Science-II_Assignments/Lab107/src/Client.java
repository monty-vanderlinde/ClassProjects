/**
 *
 * @author Monty Vanderlinde
 * @version 15 October 2017
 * 
 * A main class for testing the Card, CardHand, Deck, and Game classes.
 * 
 */
public class Client
{
    public static void main(String[] args)
    {
        //create a card game 
        Game cardGame = new Game(4, 13);
        
        //for all the 13 rounds of adding cards
        for(int i = 0; i < 13; i++)
        {
            //if there are cards left to deal, then deal cards
            if(cardGame.canDealCards())
                cardGame.getCard();
            
            //print card # header
            System.out.println("Card " + (i + 1) + ":");
            
            //prints out all the cards in each player's hand
            cardGame.printHands();
            
            System.out.println();
        }
    }
}