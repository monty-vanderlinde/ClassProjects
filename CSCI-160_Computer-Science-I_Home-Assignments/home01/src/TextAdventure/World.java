package TextAdventure;

/**
 *
 * @author Mon
 */
public class World
{
    private Room startingRoom;
    private Room endingRoom;
    
    public World(Room startingRoom, Room endingRoom)
    {
        this.startingRoom = startingRoom;
        this.endingRoom = endingRoom;
    }
    
    public Room getStartingRoom()
    {
        return startingRoom;
    }
    
    public Room getEndingRoom()
    {
        return endingRoom;
    }
}
