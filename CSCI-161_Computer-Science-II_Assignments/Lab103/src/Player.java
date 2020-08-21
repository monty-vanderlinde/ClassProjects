/**
 *
 * @author Monty Vanderlinde
 * @version 14 September 2017
 * 
 * A class that contains the name, position, and jersey number of football players.
 * 
 */
public class Player
{
    private String name;
    private String positionPlayed;
    private byte jerseyNumber;
    
    /**
     * Default Constructor:<BR>
     * A default constructor that is private to insure that it is never used.
     */
    private Player(){}
    
    /**
     * Overloaded Constructor:<BR>
     * Creates a Player object with a name, position, and jersey number.
     * @param name The name of the player. (String)
     * @param positionPlayed The position played by the player. (String)
     * @param jerseyNumber The jersey number of the player. (byte)
     */
    public Player(String name, String positionPlayed, byte jerseyNumber)
    {
        this.name = name;
        this.positionPlayed = positionPlayed;
        this.jerseyNumber = jerseyNumber;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns the name of the player as a string.
     * @return The name of the player.
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns the position played by the player as a string.
     * @return The position played by the player.
     */
    public String getPositionPlayed()
    {
        return this.positionPlayed;
    }
    
    /**
     * Accessor Method:<BR>
     * Returns the jersey number of the player as a byte.
     * @return The jersey number of the player.
     */
    public byte getJerseyNumber()
    {
        return this.jerseyNumber;
    }
    
    /**
     * Mutator Method:<BR>
     * Sets a new name for the player.
     * @param name The new name of the player. (String)
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Mutator Method:<BR>
     * Sets a new position for the player.
     * @param positionPlayed The new position of the player. (String)
     */
    public void setPositionPlayed(String positionPlayed)
    {
        this.positionPlayed = positionPlayed;
    }
    
    /**
     * Mutator Method:<BR>
     * Sets a new jersey number for the player.
     * @param jerseyNumber The new jersey number of the player. (String)
     */
    public void setJerseyNumber(byte jerseyNumber)
    {
        this.jerseyNumber = jerseyNumber;
    }
    
    /**
     * toString Method:<BR>
     * Returns a string with the class name and all of the field values
     * concatenated together.
     * @return A string with the class name and field values for all fields. (String)
     */
    @Override
    public String toString()
    {
        return getClass().getName() + ":\nName:  " + this.name +
                "\nPosition Played:  " + this.positionPlayed +
                "\nJersey Number:  " + this.jerseyNumber;
    }
    
    /**
     * equals Method:<BR>
     * Checks and returns the equality of two instances of the Player class.
     * @param o Another Player to compare to.
     * @return Does this object have all the same parameters as <B>o</B>? (Boolean)
     */
    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof Player))
            return false;
        
        Player p = (Player) o;
        
        return (p.name.equalsIgnoreCase(this.name) && p.positionPlayed.equalsIgnoreCase(this.positionPlayed) && p.jerseyNumber == this.jerseyNumber);
    }
}