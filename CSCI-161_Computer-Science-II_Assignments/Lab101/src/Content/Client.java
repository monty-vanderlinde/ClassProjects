package Content;

import java.util.Scanner;

/**
 *
 * @author Monty Vanderlinde
 * @version 26 August 2017
 * 
 * A client for creating an address book and testing methods.
 * 
 */
public class Client
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        Contact[] addressBook = new Contact[10];
        
        System.out.println("Let's create ten contacts for your contact list."
                + "\nTen will be friends and ten will be business associates.");
        
        for(int i = 0; i < 10; i++)
        {
            String name, address, string3, string4;
            long phoneNumber = 0L;
            if(i < 5)
            {
                System.out.println("Please enter the name of a friend.");
                name = scan.nextLine();
                
                System.out.println("Please enter the address of the friend.");
                address = scan.nextLine();
                
                System.out.println("Please enter the phone number of the friend without any symbols or spaces.");
                boolean flag = true;
                while(flag)
                {
                    while(!scan.hasNextLong())
                    {
                        System.out.println("What was entered does not register as a number."
                                + "\nPlease enter the phone number again."
                                + "\nRemember, no spaces or dashes.");
                        scan.nextLine();
                    }
                    
                    phoneNumber = scan.nextLong();
                    scan.nextLine();
                    
                    if(phoneNumber <= 1000000000000000000L && phoneNumber >= 0L)
                        flag = false;
                    else
                        System.out.println("The phone number cannot be negative "
                                + "or more than 18 digits long."
                                + "\nPlease enter a different phone number.");
                }
                
                System.out.println("Please enter the birthday of the friend in the form mm/dd/yyyy."
                        + "\nThe year cannot be before 1900 or after 2017");
                string3 = scan.nextLine();
                
                System.out.println("Please enter the favorite movie of the friend.");
                string4 = scan.nextLine();
                
                addressBook[i] = new Friend(name, address, phoneNumber, string3, string4);
            }
            else
            {
                System.out.println("Please enter the name of a business associate.");
                name = scan.nextLine();
                
                System.out.println("Please enter the address of the business associate.");
                address = scan.nextLine();
                
                System.out.println("Please enter the phone number of the business associate without any symbols or spaces.");
                boolean flag = true;
                while(flag)
                {
                    while(!scan.hasNextLong())
                    {
                        System.out.println("What was entered does not register as a number."
                                + "\nPlease enter the phone number again."
                                + "\nRemember, no spaces or dashes.");
                        scan.nextLine();
                    }
                    
                    phoneNumber = scan.nextLong();
                    scan.nextLine();
                    
                    if(phoneNumber <= 1000000000000000000L && phoneNumber >= 0L)
                        flag = false;
                    else
                        System.out.println("The phone number cannot be negative "
                                + "or more than 18 digits long."
                                + "\nPlease enter a different phone number.");
                }
                
                System.out.println("Please enter the business name of where the business associate works.");
                string3 = scan.nextLine();
                
                System.out.println("Please enter the title of the business associate.");
                string4 = scan.nextLine();
                
                addressBook[i] = new Business(name, address, phoneNumber, string3, string4);
            }
        }
        System.out.println();
        
        scan.close();
        
        System.out.println("The number of friend objects that have been created is " + Friend.getNumberOfFriendContacts());
        System.out.println();
        
        System.out.println("The number of business objects that have been created is " + Business.getNumberOfBusinessContacts());
        System.out.println();
        
        System.out.println("The number of contact objects that have been created is " + Contact.getNumberOfContacts());
        System.out.println();
        
        for(int i = 0; i < 10; i++)
        {
            System.out.println(addressBook[i].toString() + "\n");
        }
        
        System.out.println("First equal to second:  " + addressBook[0].equals(addressBook[1])
                + "\nThird equal to fourth:  " + addressBook[2].equals(addressBook[3])
                + "\nSixth equal to seventh:  " + addressBook[5].equals(addressBook[6])
                + "\nEighth equal to ninth:  " + addressBook[7].equals(addressBook[8])
                + "\nFifth equal to tenth:  " + addressBook[4].equals(addressBook[9]));
        
        System.out.println(addressBook[0].getName());
        System.out.println("Name set to \"John\"");
        addressBook[0].setName("John");
        System.out.println(addressBook[0].getName());
        System.out.println();
        
        System.out.println(addressBook[1].getAddress());
        System.out.println("Address set to \"4545 87th Ave.\"");
        addressBook[1].setAddress("4545 87th Ave.");
        System.out.println(addressBook[1].getAddress());
        System.out.println();
        
        System.out.println(addressBook[2].getPhoneNumber());
        System.out.println("Phone number set to 18002727272");
        addressBook[2].setPhoneNumber(18002727272L);
        System.out.println(addressBook[2].getPhoneNumber());
        System.out.println();
        
        Friend f1 = (Friend) addressBook[3];
        System.out.println(f1.getBirthday());
        System.out.println("Birthday set to \"04/30/1988\"");
        f1.setBirthday("04/30/1988");
        System.out.println(f1.getBirthday());
        addressBook[3] = f1;
        System.out.println();
        
        Friend f2 = (Friend) addressBook[4];
        System.out.println(f2.getFavoriteMovie());
        System.out.println("Favorite movie set to \"National Treasure\"");
        f2.setFavoriteMovie("National Treasure");
        System.out.println(f2.getFavoriteMovie());
        addressBook[4] = f2;
        System.out.println();
        
        System.out.println(addressBook[5].getName());
        System.out.println("Name set to \"John\"");
        addressBook[5].setName("John");
        System.out.println(addressBook[5].getName());
        System.out.println();
        
        System.out.println(addressBook[6].getAddress());
        System.out.println("Address set to \"4545 87th Ave.\"");
        addressBook[6].setAddress("4545 87th Ave.");
        System.out.println(addressBook[6].getAddress());
        System.out.println();
        
        System.out.println(addressBook[7].getPhoneNumber());
        System.out.println("Phone number set to 18002727272");
        addressBook[7].setPhoneNumber(18002727272L);
        System.out.println(addressBook[7].getPhoneNumber());
        System.out.println();
        
        Business b1 = (Business) addressBook[8];
        System.out.println(b1.getBusinessName());
        System.out.println("Business name set to \"FoodCo\"");
        b1.setBusinessName("FoodCo");
        System.out.println(b1.getBusinessName());
        addressBook[3] = b1;
        System.out.println();
        
        Business b2 = (Business) addressBook[9];
        System.out.println(b2.getTitle());
        System.out.println("Title set to \"Janitor\"");
        b2.setTitle("Janitor");
        System.out.println(b2.getTitle());
        addressBook[4] = b2;
        System.out.println();
        
        for(int i = 0; i < 10; i++)
        {
            System.out.println(addressBook[i].toString() + "\n");
        }
    }
    
}