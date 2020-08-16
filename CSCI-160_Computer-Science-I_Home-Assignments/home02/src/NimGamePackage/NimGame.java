package NimGamePackage;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author vanderlinde.monty
 */
public class NimGame
{
    private Player player1;
    private Player player2;
    private Pile pile;
    private boolean isPlayer1Turn;
    
    private NimGame(Player player1, Player player2, Pile pile)
    {
        this.player1 = player1;
        this.player2 = player2;
        this.pile = pile;
    }
    
    public static NimGame setupGame()
    {
        Player player1 = new Player("");
        Player player2 = new Player("");
        Pile pile = new Pile(0);
        Scanner scan = new Scanner(System.in);
        
        System.out.println("What type of a game would you like to play?\n"
                + "\t1.  Human vs. Human\n"
                + "\t2.  Human vs. Computer\n"
                + "\t3.  Computer vs. Computer\n");
        int gameChoice = SafeScan.promptScanNextInt(1, 3);
        
        if(gameChoice == 1)
        {
            System.out.println("Please enter the name of Player 1:  ");
            player1 = new Player(scan.nextLine());
            
            System.out.println("Please enter the name of Player 2:  ");
            player2 = new Player(scan.nextLine());
        }
        else if(gameChoice == 2)
        {
            System.out.println("Please enter the name of Player 1:  ");
            player1 = new Player(scan.nextLine());
            
            System.out.println("Please select one of the following computer AIs for Player 2:\n"
                    + "\t1.  Dull Dan (Very Easy)\n"
                    + "\t2.  Average Amy (Easy)\n"
                    + "\t3.  Smart Sally (Medium)\n"
                    + "\t4.  Brilliant Ben (Hard)\n");
            int characterChoice = SafeScan.promptScanNextInt(1, 4);
            switch (characterChoice)
            {
                case 1:
                    player2 = Player.getTerribleAIPlayerInstance();
                    break;
                case 2:
                    player2 = Player.getBadAIPlayerInstance();
                    break;
                case 3:
                    player2 = Player.getGoodAIPlayerInstance();
                    break;
                case 4:
                    player2 = Player.getExcellentAIPlayerInstance();
                    break;
            }
        }
        else
        {
            System.out.println("Please select one of the following computer AIs for Player 1:\n"
                    + "\t1.  Dull Dan (Very Easy)\n"
                    + "\t2.  Average Amy (Easy)\n"
                    + "\t3.  Smart Sally (Medium)\n"
                    + "\t4.  Brilliant Ben (Hard)\n");
            int characterChoice = SafeScan.promptScanNextInt(1, 4);
            switch (characterChoice)
            {
                case 1:
                    player1 = Player.getTerribleAIPlayerInstance();
                    break;
                case 2:
                    player1 = Player.getBadAIPlayerInstance();
                    break;
                case 3:
                    player1 = Player.getGoodAIPlayerInstance();
                    break;
                case 4:
                    player1 = Player.getExcellentAIPlayerInstance();
                    break;
            }
            
            System.out.println("Please select one of the following computer AIs for Player 2:\n"
                    + "\t1.  Dull Dan (Very Easy)\n"
                    + "\t2.  Average Amy (Easy)\n"
                    + "\t3.  Smart Sally (Medium)\n"
                    + "\t4.  Brilliant Ben (Hard)\n");
            characterChoice = SafeScan.promptScanNextInt(1, 4);
            switch (characterChoice)
            {
                case 1:
                    player2 = Player.getTerribleAIPlayerInstance();
                    break;
                case 2:
                    player2 = Player.getBadAIPlayerInstance();
                    break;
                case 3:
                    player2 = Player.getGoodAIPlayerInstance();
                    break;
                case 4:
                    player2 = Player.getExcellentAIPlayerInstance();
                    break;
            }
        }
        
        System.out.println("How many marbles would you like to play with?\n"
                + "\t1.  21 (traditional)\n"
                + "\t2.  Random (17 - 100)\n"
                + "\t3.  Custom (17 - 100)\n");
        int marblesChoice = SafeScan.promptScanNextInt(1, 3);
        
        switch(marblesChoice)
        {
            case 1:
                pile = new Pile(21);
                break;
            case 2:
                pile = new Pile(InclusiveRandom.getRand(17, 100));
                break;
            case 3:
                pile = new Pile(SafeScan.promptScanNextInt(17, 100));
                break;
        }
        
        return new NimGame(player1, player2, pile);
    }
    
    public void start()
    {
        Random rand = new Random();
        isPlayer1Turn = rand.nextBoolean();
        
        while(pile.getSize() > 0)
        {
            nextPlayer();
            displayTurnInformation();
            takeTurn();
        }
        
        if(isPlayer1Turn)
            System.out.println(player1.getName() + " (Player 1) has won the game!\n");
        else
            System.out.println(player2.getName() + " (Player 2) has won the game!\n");
    }
    
    public void displayTurnInformation()
    {
        if(isPlayer1Turn)
            System.out.println("It is now " + player1.getName() + "'s turn.\n");
        else
            System.out.println("It is now " + player2.getName() + "'s turn.\n");
        
        pile.printPile();
        
        System.out.println("There are " + pile.getSize() + " marble(s) left in the pile.\n");
    }
    
    public void takeTurn()
    {
        boolean isComputer;
        int removeAmount;
        
        if(isPlayer1Turn)
            isComputer = player1.isComputerControlled();
        else
            isComputer = player2.isComputerControlled();
        
        if(isComputer)
        {
            if(isPlayer1Turn)
            {
                removeAmount = player1.takeComputerTurn(pile.getSize());
                System.out.println(player1.getName() + " removed " + removeAmount + " marbles from the pile.\n");
            }
            else
            {
                removeAmount = player2.takeComputerTurn(pile.getSize());
                System.out.println(player2.getName() + " removed " + removeAmount + " marbles from the pile.\n");
            }
        } 
        else
        {
            System.out.println("How many marbles would you like to remove from the pile?\n");
            removeAmount = SafeScan.promptScanNextInt(1, 3);
            
            if(isPlayer1Turn)
                System.out.println(player1.getName() + " removed " + removeAmount + " marbles from the pile.\n");
            else
                System.out.println(player2.getName() + " removed " + removeAmount + " marbles from the pile.\n");
        }
        
        pile.remove(removeAmount);
    }
    
    public void nextPlayer()
    {
        if(isPlayer1Turn)
            isPlayer1Turn = false;
        else
            isPlayer1Turn = true;
    }
    
    public static void main(String[] args)
    {
        int test = 1;
        
        while(test == 1)
        {
            NimGame newGame = NimGame.setupGame();
            newGame.start();
            
            System.out.println("Would you like to play again?\n"
                + "\t1.  Yes\n"
                + "\t2.  No\n");
            test = SafeScan.promptScanNextInt(1, 2);
        }
        
        System.out.println("Thank you for playing!");
    }
}
