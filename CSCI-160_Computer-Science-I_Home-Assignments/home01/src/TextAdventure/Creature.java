package TextAdventure;

/**
 *
 * @author Mon
 */
public class Creature
{
    private String creatureName;
    private String creatureDescription;
    private String defeatedText;
    private Item itemToDestroy;
    
    public Creature(String name, String description, String defeatedText, Item itemToDestroy)
    {
        this.creatureName = name;
        this.creatureDescription = description;
        this.defeatedText = defeatedText;
        this.itemToDestroy = itemToDestroy;
    }
    
    public String getName()
    {
        return creatureName;
    }
    
    public String getDescription()
    {
        return creatureDescription;
    }
    
    public String getDefeatedText()
    {
        return defeatedText;
    }
    
    public Item getItemToDestroy()
    {
        return itemToDestroy;
    }
    
    public void setItemToDestroy(Item item)
    {
        itemToDestroy = item;
    }
}
