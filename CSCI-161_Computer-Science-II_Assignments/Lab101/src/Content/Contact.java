package Content;

/**
 *
 * @author Monty Vanderlinde
 * @version 26 August 2017
 * 
 * Name, Address, and Phone Numbers for a contact list.
 * 
 */
public class Contact
{
    private String name;
    private String address;
    private long phoneNumber;
    private static int numberOfContacts = 0;
    
    /**
     * Default Constructor:<BR>
     * Is private to guarantee that it is not used and that an instance must be<BR>
     * initialized with all data included.
     */
    private Contact(){}
    
    /**
     * Overloaded Constructor:<BR>
     * Creates a new Contact with a name, address, and phone number.  The phone<BR>
     * number cannot be more than 18 digits long, or it will automatically be set<BR>
     * to 0.
     * @param name The name of the contact.  (String)
     * @param address The home or office address of the contact.  (String)
     * @param phoneNumber The phone number of the contact.  (Long)
     */
    public Contact(String name, String address, long phoneNumber)
    {
        Contact.setNumberOfContacts(Contact.getNumberOfContacts() + 1);
        
        this.setName(name);
        
        this.setAddress(address);
        
        this.setPhoneNumber(phoneNumber);
    }
    
    /**
     * Accessor method:<BR>
     * Returns a string of the name of the contact.
     * @return The name of the contact in a string.
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Accessor method:<BR>
     * Returns a string of the address of the contact.
     * @return The address of the contact in a string.
     */
    public String getAddress()
    {
        return this.address;
    }
    
    /**
     * Accessor method:<BR>
     * Returns a long of the phone number of the contact.
     * @return The phone number of the contact in a long.
     */
    public long getPhoneNumber()
    {
        return this.phoneNumber;
    }
    
    /**
     * Accessor method:<BR>
     * Returns an int of the number of contacts, including subclasses, that<BR>
     * have been created.
     * @return The number of contacts that have been created in an int.
     */
    public static int getNumberOfContacts()
    {
        return Contact.numberOfContacts;
    }
    
    /**
     * Mutator method:<BR>
     * Sets a new name for the contact.
     * @param name The new name of the contact as a string.
     */
    public void setName(String name)
    {
        if(name != null)
            this.name = name;
        else
            this.name = "Unknown";
    }
    
    /**
     * Mutator method:<BR>
     * Sets a new address for the contact.
     * @param address The new address of the contact as a string.
     */
    public void setAddress(String address)
    {
        if(address != null)
            this.address = address;
        else
            this.address = "Unknown";
    }
    
    /**
     * Mutator method:<BR>
     * Sets a new phone number for the contact.
     * @param phoneNumber The new phone number of the contact as a long.
     */
    public void setPhoneNumber(long phoneNumber)
    {
        if(phoneNumber > 0 && phoneNumber < 1000000000000000000L)
            this.phoneNumber = phoneNumber;
        else
        {
            this.phoneNumber = 0L;
            System.out.println("Phone numbers cannot be negative or more than 18 digits.  Number set to 0.");
        }
        //I considered restricting the length of the phone numbers,
        //but some international numbers can be of varrying length.
        //However, a long appears to have enough digits.
    }
    
    /**
     * Mutator method:<BR>
     * Sets an int of the number of contacts, including subclasses, that have<BR>
     * been created.  Is private so as not to be used outside of this class.
     * @param numberOfContacts The number of contacts that have been created in an int.
     */
    private static void setNumberOfContacts(int numberOfContacts)
    {
        Contact.numberOfContacts = numberOfContacts;
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
        return getClass().getName() + ":\nName:  " + this.name
                + "\nAddress:  " + this.address + "\nPhone Number:  "
                + this.phoneNumber;
    }
    
    /**
     * equals method:<BR>
     * Checks and returns the equality of two instances of the Contact class.
     * @param o Another contact to compare to.
     * @return A boolean; true if this object has all the same parameters as <B>o</B>.
     */
    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof Contact))
            return false;
        
        Contact c = (Contact) o;
        
        return c.name.equals(this.name)
                && c.address.equals(this.address)
                && c.phoneNumber == this.phoneNumber;
    }
}