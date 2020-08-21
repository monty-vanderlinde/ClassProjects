package NimGamePackage;

/**
 *
 * @author monty.vanderlinde
 */
public class Player
{
    private String name;
    private boolean isAComputer;
    private int idealMoveProbability;
    
    public Player(String name)
    {
        this.name = name;
        isAComputer = false;
    }
    
    private Player(String name, int idealMoveProbability)
    {
        this.name = name;
        this.idealMoveProbability = idealMoveProbability;
        isAComputer = true;
    }
    
    public String getName()
    {
        return name;
    }
    
    public boolean isComputerControlled()
    {
        return isAComputer;
    }
    
    public int takeComputerTurn(int pileSize)
    {
        if(InclusiveRandom.getRand(1, 100) <= idealMoveProbability && pileSize % 4 != 0)
            return pileSize % 4;
        
        return InclusiveRandom.getRand(1, 3);
    }
    
    public static Player getTerribleAIPlayerInstance()
    {
        Player player = new Player("Dull Dan", 0);
        return player;
    }
    
    public static Player getBadAIPlayerInstance()
    {
        Player player = new Player("Average Amy", 33);
        return player;
    }
    
    public static Player getGoodAIPlayerInstance()
    {
        Player player = new Player("Smart Sally", 67);
        return player;
    }
    
    public static Player getExcellentAIPlayerInstance()
    {
        Player player = new Player("Brilliant Ben", 100);
        return player;
    }
}
