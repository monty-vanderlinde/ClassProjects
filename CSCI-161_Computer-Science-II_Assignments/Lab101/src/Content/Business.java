package Content;

/**
 *
 * @author Monty Vanderlinde
 * @version 26 August 2017
 * 
 * A standard contact for business associates with business name and title.
 * 
 */
public class Business extends Contact
{
    private String businessName;
    private String title;
    private static int numberOfBusinessContacts = 0;
    
    /**
     * Default Constructor:<BR>
     * Is private to guarantee that it is not used and that an instance must be<BR>
     * initialized with all data included.
     */
    private Business()
    {
        super("", "", 0L);
    }
    
    /**
     * Overloaded Constructor:<BR>
     * Creates a new Contact with a name, address, phone number, business, and<BR>
     * title.  The phone number cannot be more than 18 digits long, or it will<BR>
     * automatically be set to 0.
     * @param name The name of the contact.  (String)
     * @param address The office address of the contact.  (String)
     * @param phoneNumber The phone number of the contact.  (Long)
     * @param businessName The name of this contact's business.  (String)
     * @param title The business title of this contact.  (String)
     */
    public Business(String name, String address, long phoneNumber, String businessName, String title)
    {
        super(name, address, phoneNumber);
        
        Business.setNumberOfBusinessContacts(Business.getNumberOfBusinessContacts() + 1);
        
        this.setBusinessName(businessName);
        
        this.setTitle(title);
    }
    
    /**
     * Accessor method:<BR>
     * Returns a string of the name of the Business of the business associate.
     * @return The name of the business of the business associate in a string.
     */
    public String getBusinessName()
    {
        return this.businessName;
    }
    
    /**
     * Accessor method:<BR>
     * Returns a string of the title of the business associate.
     * @return The title of the business associate in a string.
     */
    public String getTitle()
    {
        return this.title;
    }
    
    /**
     * Accessor method:<BR>
     * Returns an int of the number of business contacts that have been created.
     * @return The number of business contacts that have been created in an int.
     */
    public static int getNumberOfBusinessContacts()
    {
        return Business.numberOfBusinessContacts;
    }
    
    /**
     * Mutator method:<BR>
     * Sets a new business name for the business associate
     * @param businessName The new business name of the business associate as a<BR>
     * string.
     */
    public void setBusinessName(String businessName)
    {
        this.businessName = businessName;
    }
    
    /**
     * Mutator method:<BR>
     * Sets a new title for the business associate.
     * @param title The new title of the business associate as a string.
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * Mutator method:<BR>
     * Sets an int of the number of business contacts, including subclasses,<BR>
     * that have been created.  Is private so as not to be used outside of this<BR>
     * class.
     * @param numberOfBusinessContacts The number of business contacts that have been created in an int.
     */
    private static void setNumberOfBusinessContacts(int numberOfBusinessContacts)
    {
        Business.numberOfBusinessContacts = numberOfBusinessContacts;
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
        return super.toString() + "\nBusiness Name:  " + this.businessName
                + "\nTitle:  " + this.title;
    }
    
    /**
     * equals method:<BR>
     * Checks and returns the equality of two instances of the Business class.
     * @param o Another business to compare to.
     * @return A boolean; true if this object has all the same parameters as <B>o</B>.
     */
    @Override
    public boolean equals(Object o)
    {
        if(!super.equals(o) || !(o instanceof Business))
            return false;
        
        Business b = (Business) o;
        
        return b.businessName.equals(this.businessName) && b.title.equals(this.title);
    }
}