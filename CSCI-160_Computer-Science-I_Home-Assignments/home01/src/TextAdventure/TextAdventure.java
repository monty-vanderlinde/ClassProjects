package TextAdventure;

/**
 *
 * @author Mon
 */
public class TextAdventure
{
    public static void main(String[] args)
    {
        String tempString1;
        String tempString2;
        
        //Names mean roomExiting_Exit_DirectionExiting
        tempString1 = "You open the large door and walk into the main room.  The door slam shut behind you.";
        Exit northExitSouth = new Exit("Exit to Main Room", "A large oaken door leading to the main room.", tempString1, null);
        tempString1 = "You open the large door and walk into the east hallway.  The door slam shut behind you.";
        Exit eastExitWest = new Exit("Exit to East Hallway", "A large oaken door leading to the east hallway.", tempString1, null);
        tempString1 = "You open the large hatch and climb into the east dungeon.  The door slam shut behind you.";
        Exit eastExitDown = new Exit("Exit to East Dungeon", "A large hidden hatch leading to the east dungeon.", tempString1, null);
        tempString1 = "You open the large door and walk into the south room.  The door slam shut behind you.";
        Exit outExitNorth = new Exit("Exit to South Room", "A large stone door leading to the south room.", tempString1, null);
        tempString1 = "You open the large door and walk into the west hallway.  The door slam shut behind you.";
        Exit westExitEast = new Exit("Exit to West Hallway", "A large oaken door leading to the west hallway.", tempString1, null);
        tempString1 = "You open the large door and walk into the north room.  The door slam shut behind you.";
        Exit mainExitNorth = new Exit("Exit to North Room", "A large oaken door leading to the north room.", tempString1, null);
        tempString1 = "You open the large door and walk into the east hallway.  The door slam shut behind you.";
        Exit mainExitEast = new Exit("Exit to East Hallway", "A large oaken door leading to the east hallway.", tempString1, null);
        tempString1 = "You open the large door and walk into the south room.  The door slam shut behind you.";
        Exit mainExitSouth = new Exit("Exit to South Room", "A large oaken door leading to the south room.", tempString1, null);
        tempString1 = "You open the large door and walk into the west hallway.  The door slam shut behind you.";
        Exit mainExitWest = new Exit("Exit to West Hallway", "A large oaken door leading to the west hallway.", tempString1, null);
        tempString1 = "You open the large hatch and climb into the main dungeon.  The door slam shut behind you.";
        Exit mainExitDown = new Exit("Exit to Main Dungeon", "A large hidden hatch leading to the main dungeon.", tempString1, null);
        tempString1 = "You open the large door and walk into the east room.  The door slam shut behind you.";
        Exit eastHallExitEast = new Exit("Exit to East Room", "A large oaken door leading to the east room.", tempString1, null);
        tempString1 = "You open the large door and walk into the main room.  The door slam shut behind you.";
        Exit eastHallExitWest = new Exit("Exit to Main Room", "A large oaken door leading to the main room.", tempString1, null);
        tempString1 = "You open the large door and walk into the main room.  The door slam shut behind you.";
        Exit southExitNorth = new Exit("Exit to Main Room", "A large oaken door leading to the main room.", tempString1, null);
        tempString1 = "You open the large door and walk outside.  The door slam shut behind you.";
        Exit southExitSouth = new Exit("Exit to Outside", "A large stone door leading outside.", tempString1, null);
        tempString1 = "You open the large door and walk into the main room.  The door slam shut behind you.";
        Exit westHallExitEast = new Exit("Exit to Main Room", "A large oaken door leading to the main room.", tempString1, null);
        tempString1 = "You open the large door and walk into the west room.  The door slam shut behind you.";
        Exit westHallExitWest = new Exit("Exit to West Room", "A large oaken door leading to the west room.", tempString1, null);
        tempString1 = "You open the large door and walk into the dungeon passage.  The door slam shut behind you.";
        tempString2 = "A large rusty metal door leading to the dungeon passage.";
        Exit eastDungeonExitWest = new Exit("Exit to Dungeon Passage", tempString2, tempString1, null);
        tempString1 = "You open the large hatch and climb into the east room.  The door slam shut behind you.";
        tempString2 = "A large rusty hatch leading to the east room.";
        Exit eastDungeonExitUp = new Exit("Exit to East Room", tempString2, tempString1, null);
        tempString1 = "You open the large door and walk into the east dungeon.  The door slam shut behind you.";
        tempString2 = "A large rusty metal door leading to the east dungeon.";
        Exit dungeonPassageExitEast = new Exit("Exit to East Dungeon", tempString2, tempString1, null);
        tempString1 = "You open the large door and walk into the main dungeon.  The door slam shut behind you.";
        tempString2 = "A large rusty metal door leading to the main dungeon.";
        Exit dungeonPassageExitWest = new Exit("Exit to Main Dungeon", tempString2, tempString1, null);
        tempString1 = "You open the large door and walk into the dungeon passage.  The door slam shut behind you.";
        tempString2 = "A large rusty metal door leading to the dungeon passage.";
        Exit mainDungeonExitEast = new Exit("Exit to Dungeon Passage", tempString2, tempString1, null);
        tempString1 = "You open the large hatch and climb into the main room.  The door slam shut behind you.";
        tempString2 = "A large rusty hatch leading to the main room.  There appears to be a key hole near the handle.";
        Exit mainDungeonExitUp = new Exit("Exit to Main Room", tempString2, tempString1, null);
        
        //Create Rooms and Add Additional Exits
        tempString1 = "You find yourself in a large room with barred windows covering three walls.  There are several pieces\n"
                + "of dust covered funiture strewn about the room.  Leaning in one of the corners of the room is what\n"
                + "appears to be a long iron sword.  It is dark outside, and the only thing that you can see is a wall of\n"
                + "pine trees.  The only way out appears to be the way that you came from.";
        Room northRoom = new Room("North Room", tempString1, northExitSouth);
        
        tempString1 = "You find yourself in what appears to be a an office room.  There are book shelves on both sides of the\n"
                + "room and a large desk at the back wall.  There is a book and a letter both sitting in the middle of the\n"
                + "desk.  The letter reads \"I have hired one of the local carpenters to board up the entrance to the east\n"
                + "dungeon.  That place gives me the creeps.  He tells me that it will be at least a month until he can\n"
                + "make the trip out here.  In the meantime, I have covered the entrance with a rug to try to forget about\n"
                + "it.  I hope that he arrives soon.\"  In the middle of the room is a large, bear-skin rug.  The only way\n"
                + "out appears to be the way that you came from.";
        Room eastRoom = new Room("East Room", tempString1, eastExitWest);
        eastRoom.setSecretExit(eastExitDown);
        
        tempString1 = "You have finally made it out of that terrible house.  It is time for you to start your journey home.";
        Room outside = new Room("Outside", tempString1, outExitNorth);
        
        tempString1 = "You are standing in an old bedroom.  All of the furniture is covered in dust.  There is only one exit:\n"
                + "a door to the east.";
        Room westRoom = new Room("West Room", tempString1, westExitEast);
        
        tempString1 = "You find yourself in a large, square room with doors on all sides.  The room is surprisingly bare with\n"
                + "only a few paintings on the walls, a large bear-skin rug in the middle of the floor, and an animated marble\n"
                + "statue in the south east corner.  It looks like it is blocking the south and east doors.";
        Room mainRoom = new Room("Main Room", tempString1, mainExitNorth);
        mainRoom.setExit2(mainExitEast);
        mainRoom.setExit3(mainExitSouth);
        mainRoom.setExit4(mainExitWest);
        mainRoom.setSecretExit(mainExitDown);
        
        tempString1 = "You find yourself in a long narrow hallway with one door on each end and more barred windows on the\n"
                + "walls.  You still can't see anything but pine trees outside.  Suddenly, you hear a crash behind you.\n"
                + "You turn around to find that a wolf has jumped through a hole in the ceiling and is now standing between\n"
                + "you and the western door.  You don't think that you should go over there.";
        Room eastHallway = new Room("East Hallway", tempString1, eastHallExitEast);
        eastHallway.setExit2(eastHallExitWest);
        
        tempString1 = "You find yourself in a large foyer area filled with several pieces of old dusty funiture and a few dead\n"
                + "plants.  There is a door heading north and a large entrance door to the south.  However, another animated\n"
                + "statue blocks the exit.  This one looks a lot bigger.";
        Room southRoom = new Room("South Room", tempString1, southExitNorth);
        southRoom.setExit2(southExitSouth);
        
        tempString1 = "You find yourself in a long narrow hallway with one door on each end.  The walls are covered with\n"
                + "paintings.";
        Room westHallway = new Room("West Hallway", tempString1, westHallExitEast);
        westHallway.setExit2(westHallExitWest);
        
        tempString1 = "You find yourself in a dark and damp dungeon room with dirt floors and crude stone walls.  There is an\n"
                + "unlit torch in the corner which you promptly light to carry with you.  There is a hatch in the ceiling and\n"
                + "a door leading to the west.  There also appears to be a small object on the ground in the dirt.";
        Room eastDungeon = new Room("East Dungeon", tempString1, eastDungeonExitWest);
        eastDungeon.setExit2(eastDungeonExitUp);
        
        tempString1 = "You find yourself in a narrow dungeon passage.  On either end of the passage is a large, rusty iron\n"
                + "door.  In the middle of the passage is what appears to be a large pool of black slime.  Upon further\n"
                + "inspection, the slime appears to be a living creature of some sort.  It is blocking your path to the\n"
                + "western door.";
        Room dungeonPassage = new Room("Dungeon Passage", tempString1, dungeonPassageExitEast);
        dungeonPassage.setExit2(dungeonPassageExitWest);
        
        tempString1 = "You find yourself in another large dungeon room.  This room is almost identical to the last, with one\n"
                + "major exception.  Leaning in the corner of the room is another long iron sword.  There is a trap door on\n"
                + "the ceiling and a door leading to the east.";
        Room mainDungeon = new Room("Main Dungeon", tempString1, mainDungeonExitEast);
        mainDungeon.setExit2(mainDungeonExitUp);
        
        
        //Set Destinations to Exits
        northExitSouth.setDestination(mainRoom);
        eastExitWest.setDestination(eastHallway);
        eastExitDown.setDestination(eastDungeon);
        outExitNorth.setDestination(southRoom);
        westExitEast.setDestination(westHallway);
        mainExitNorth.setDestination(northRoom);
        mainExitEast.setDestination(eastHallway);
        mainExitSouth.setDestination(southRoom);
        mainExitWest.setDestination(westHallway);
        mainExitDown.setDestination(mainDungeon);
        eastHallExitEast.setDestination(eastRoom);
        eastHallExitWest.setDestination(mainRoom);
        southExitNorth.setDestination(mainRoom);
        southExitSouth.setDestination(outside);
        westHallExitEast.setDestination(mainRoom);
        westHallExitWest.setDestination(westRoom);
        eastDungeonExitWest.setDestination(dungeonPassage);
        eastDungeonExitUp.setDestination(eastRoom);
        dungeonPassageExitEast.setDestination(eastDungeon);
        dungeonPassageExitWest.setDestination(mainDungeon);
        mainDungeonExitEast.setDestination(dungeonPassage);
        mainDungeonExitUp.setDestination(mainRoom);
        
        //Create Items
        Item sword = new Item("Sword", "A long iron sword.");
        Item enchantedSword = new Item("Enchanted Sword", "A long iron sword with runes written down the blade and a glowing\n"
                + "red gem for a pommel.");
        Item book = new Item("How to Dispell Dungeon Beasts 101", "It looks like a book on how to dispell dungeon beasts.\n"
                + "What a surprise!");
        Item key = new Item("Key", "A small rusty key.  You wonder what it is for.");
        
        //Create Creatures
        tempString1 = "A large, snarling wolf.  It doesn't look too happy.  Perhaps you should look for another way around.";
        tempString2 = "Congradulations on breaking the game!  You weren't supposed to be able to kill the wolf.";
        Creature wolf = new Creature("Wolf", tempString1, tempString2, null);
        tempString1 = "An animated marble statue of a small knight.";
        tempString2 = "The statue shatters to pieces under the blow of your sword.  Your sword shatters as well.";
        Creature smallStatue =  new Creature("Small Statue", tempString1, tempString2, sword);
        tempString1 = "A living pool of black slime blocking the center of the passage.";
        tempString2 = "You dispell the slime monster and it evaporates into nothing.  Your book mysteriously dissapears as\n"
                + "well.";
        Creature dungeonMonster = new Creature("Dungeon Slime Monster", tempString1, tempString2, book);
        tempString1 = "A large, animated marble statue of a knight with glowing red eyes.  He looks tougher than the last one.";
        tempString2 = "You stab the large statue in the chest.  The statue glows brightly and then explodes, destroying the\n"
                + "sword with it.";
        Creature guardianStatue = new Creature("Gaurdian Statue", tempString1, tempString2, enchantedSword);
        
        //Set Creatures to Rooms
        mainRoom.setCreature(smallStatue);
        dungeonPassage.setCreature(dungeonMonster);
        southRoom.setCreature(guardianStatue);
        eastHallway.setCreature(wolf);
        
        
        //Set Creatures to Block
        mainExitEast.setCreatureBlocks(true);
        mainExitSouth.setCreatureBlocks(true);
        eastHallExitWest.setCreatureBlocks(true);
        dungeonPassageExitWest.setCreatureBlocks(true);
        southExitSouth.setCreatureBlocks(true);
        
        //Set Items to Rooms
        eastDungeon.setItem(key);
        northRoom.setItem(sword);
        eastRoom.setItem(book);
        mainDungeon.setItem(enchantedSword);

        //Set Exit Required Items
        mainDungeonExitUp.setRequiredItem(key);
        mainExitDown.setRequiredItem(key);
        
        
        World world = new World(westRoom, outside);
        
        Player player = new Player("Jim", "A brave adventurer");
        
        Game textAdventure = new Game(world, player);
        
        tempString1 = "You awake to find yourself laying on an old dusty bed in a room that you do not recognize.  You can't\n"
                + "remember how you got here.";
        textAdventure.setStartText(tempString1);
        
        textAdventure.start();
    }
}
