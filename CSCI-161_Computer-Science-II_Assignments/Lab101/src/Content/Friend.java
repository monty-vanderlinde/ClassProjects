package Content;

import java.util.Scanner;

/**
 *
 * @author Monty Vanderlinde
 * @version 26 August 2017
 * 
 * A standard contact for friends with birthday and favorite movie.
 * 
 */
public class Friend extends Contact
{
    private String birthday;
    private String favoriteMovie;
    private static int numberOfFrinedContacts = 0;
    private static Scanner scan;
    
    /**
     * Default Constructor:<BR>
     * Is private to guarantee that it is not used and that an instance must be<BR>
     * initialized with all data included.
     */
    private Friend()
    {
        super("", "", 0L);
    }
    
    /**
     * Overloaded Constructor:<BR>
     * Creates a new Contact with a name, address, phone number, birthday, and<BR>
     * favorite movie.  The phone number cannot be more than 18 digits long, or<BR>
     * it will automatically be set to 0.  The birthday must be in the format<BR>
     * mm/dd/yyyy, or it will automatically be set to 01/01/1970.  The same will<BR>
     * happen if the birthday is set before 1900 or after 2017.
     * @param name The name of the contact.  (String)
     * @param address The home address of the contact.  (String)
     * @param phoneNumber The phone number of the contact.  (Long)
     * @param birthday The birthday of the contact mm/dd/yyyy.  (String)
     * @param favoriteMovie The favorite movie of the contact.  (String)
     */
    public Friend(String name, String address, long phoneNumber, String birthday, String favoriteMovie)
    {
        super(name, address, phoneNumber);
        
        Friend.setNumberOfFriendContacts(Friend.getNumberOfFriendContacts() + 1);
        
        this.setBirthday(birthday);
        
        this.setFavoriteMovie(favoriteMovie);
    }
    
    /**
     * Accessor method:<BR>
     * Returns a string of the birthday of the friend in the form mm/dd/yyyy.
     * @return The birthday of the friend in the form mm/dd/yyyy in a string.
     */
    public String getBirthday()
    {
        return this.birthday;
    }
    
    /**
     * Accessor method:<BR>
     * Returns a string of the favorite movie of the friend.
     * @return The favorite movie of the friend in a string.
     */
    public String getFavoriteMovie()
    {
        return this.favoriteMovie;
    }
    
    /**
     * Accessor method:<BR>
     * Returns an int of the number of friend contacts that have been created.
     * @return The number of friend contacts that have been created in an int.
     */
    public static int getNumberOfFriendContacts()
    {
        return Friend.numberOfFrinedContacts;
    }
    
    /**
     * Mutator method:<BR>
     * Sets a new birthday for the friend in the form mm/dd/yyyy.  If the<BR>
     * birthday is not in that form or if the birthday is set before 1900 or<BR>
     * after 2017, then the birthday will be set to 01/01/1970 as default.
     * @param birthday The new birthday of the friend in the form mm/dd/yyyy<BR>
     * as a string.
     */
    public void setBirthday(String birthday)
    {
        Friend.scan = new Scanner(birthday);
        Friend.scan.useDelimiter("/");
        boolean flag = true;
        int i = 1;
        int temp;
        while(Friend.scan.hasNext() && flag)
        {
            if(Friend.scan.hasNextInt())
            {
                temp = Friend.scan.nextInt();
                switch (i)
                {
                    case 1:
                        if(temp > 12 || temp < 1)
                            flag = false;
                        break;
                    case 2:
                        if(temp > 31 || temp < 1)
                            flag = false;
                        break;
                    case 3:
                        if(temp > 2017 || temp < 1900)
                            flag = false;
                        break;
                    default:
                        flag = false;
                }
                i++;
            }
            else
                flag = false;
        }
        
        if(flag)
            this.birthday = birthday;
        else
        {
            this.birthday = "01/01/1970";
            System.out.println("Birthday was not formatted correctly."
                    + "  Birthday was set to 01/01/1970");
        }
    }
    
    /**
     * Mutator method:<BR>
     * Sets a new favorite movie for the friend.
     * @param favoriteMovie The new favorite move of the friend as a string.
     */
    public void setFavoriteMovie(String favoriteMovie)
    {
        this.favoriteMovie = favoriteMovie;
    }
    
    /**
     * Mutator method:<BR>
     * Sets an int of the number of friends, including subclasses, that have<BR>
     * been created.  Is private so as not to be used outside of this class.
     * @param numberOfFriendContacts The number of contacts that have been created in an int.
     */
    private static void setNumberOfFriendContacts(int numberOfFriendContacts)
    {
        Friend.numberOfFrinedContacts = numberOfFriendContacts;
    }
    
    /**
     * toString method:<BR>
     * Returns a string with the class name and all of the field values<BR>
     * concatenated together.
     * @return A string with the class name and field values for all fields.
     */
    @Override
    public String toString()
    {
        return super.toString() + "\nBirthday:  " + this.birthday
                + "\nFavorite Movie:  " + this.favoriteMovie;
    }
    
    /**
     * equals method:<BR>
     * Checks and returns the equality of two instances of the Friend class.
     * @param o Another friend to compare to.
     * @return A boolean; true if this object has all the same parameters as <B>o</B>.
     */
    @Override
    public boolean equals(Object o)
    {
        if(!super.equals(o) || !(o instanceof Friend))
            return false;
        
        Friend f = (Friend) o;
        
        return f.birthday.equals(this.birthday) && f.favoriteMovie.equals(this.favoriteMovie);
    }
}