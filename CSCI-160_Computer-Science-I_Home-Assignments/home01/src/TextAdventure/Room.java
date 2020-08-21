package TextAdventure;

/**
 *
 * @author Mon
 */
public class Room
{
    private String roomName;
    private String roomDescription;
    private Exit exit1;
    private Exit exit2;
    private Exit exit3;
    private Exit exit4;
    private Exit secretExit;
    private Item roomItem;
    private Creature roomCreature;
    
    public Room()
    {
        
    }
    
    public Room(String roomName, String roomDescription, Exit exit1)
    {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.exit1 = exit1;
    }
    
    public String getName()
    {
        return roomName;
    }
    
    public String getDescription()
    {
        return roomDescription;
    }
    
    public Exit getExit1()
    {
        return exit1;
    }
    
    public Exit getExit2()
    {
        return exit2;
    }
    
    public Exit getExit3()
    {
        return exit3;
    }
    
    public Exit getExit4()
    {
        return exit4;
    }
    
    public Exit getSecretExit()
    {
        return secretExit;
    }
    
    public Item getItem()
    {
        return roomItem;
    }
    
    public Creature getCreature()
    {
        return roomCreature;
    }
    
    public void setName(String newName)
    {
        roomName = newName;
    }
    
    public void setDescription(String newDescription)
    {
        roomDescription = newDescription;
    }
    
    public void setExit1(Exit exit)
    {
        exit1 = exit;
    }
    
    public void setExit2(Exit exit)
    {
        exit2 = exit;
    }
    
    public void setExit3(Exit exit)
    {
        exit3 = exit;
    }
    
    public void setExit4(Exit exit)
    {
        exit4 = exit;
    }
    
    public void setSecretExit(Exit exit)
    {
        secretExit = exit;
    }
    
    public void setItem(Item item)
    {
        roomItem = item;
    }
    
    public void setCreature(Creature creature)
    {
        roomCreature = creature;
    }
}
