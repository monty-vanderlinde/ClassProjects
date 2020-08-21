package BookSearchEngine;

import BookStore.Book;
import BookStore.BookStore;
import java.text.DecimalFormat;
import java.util.Scanner;

public class BookSearchEngine
{

    private static BookStore bs = new BookStore();
    private static Scanner scan = new Scanner(System.in);
    private static DecimalFormat dollarFormat = new DecimalFormat("$#,##0.00");
    
    public static void main(String[] args)
    {

        int option = 0;
        System.out.println("Welcome to the " + bs.getName() + "Bookstore.");

        while (option != 12)
        {
            //make a menu selection
            System.out.println("Please make a menu selection:");
            System.out.println("1 - List Books.");
            System.out.println("2 - List Books Alphabetically");
            System.out.println("3 - Lookup Author of Book.");
            System.out.println("4 - Lookup Price of Book.");
            System.out.println("5 - Search By Author.");
            System.out.println("6 - Search By Cost.");
            System.out.println("7 - Search By Book title.");
            System.out.println("8 - Search for Hardcover Books.");
            System.out.println("9 - Search for Softcover Books.");
            System.out.println("10 - Search for Books by ISBN.");
            System.out.println("11 - Find Cheapest Book.");
            System.out.println("12 - Quit.");
            
            //type safe int between 1 and 12 inclusive.  will reprompt for a number until an int is given
            option = ScanHelper.promptScanNextInt(1, 12);
            
            //selected according to menu above
            switch(option)
            {
                //print out whole BookStore as a list of books
                case 1:
                    System.out.println(bs.toString());
                    break;
                    
                //gets a sorted list and prints it out
                case 2:
                    bs.getSortedBookList().displayList();
                    System.out.println();
                    break;
                    
                //looks up the author or prints out a message that it was not found.  not case sensitive
                case 3:
                    System.out.println("Please enter a Book Title.");
                    String title1 = scan.nextLine();
                    System.out.println("The Author for " + title1 + " was " + bs.lookUpAuthor(title1) + ".\n");
                    break;
                    
                //looks up the price of the book.  if there is not book, then warning message is displayed.
                //otherwise, the formatted price is displayed.  not case sensitive
                case 4:
                    System.out.println("Please enter a Book Title.");
                    String title2 = scan.nextLine();
                    System.out.print("The price for " + title2 + " was ");
                    if(bs.lookUpPrice(title2) == Double.NaN)
                        System.out.println("Not Found.  Please make sure that this book exists.\n");
                    else
                        System.out.println(dollarFormat.format(bs.lookUpPrice(title2)) + ".\n");
                    break;
                    
                //looks for any matching authors and lists all of their books.  not case sensitive
                case 5:
                    System.out.println("Please enter an Author.");
                    String author = scan.nextLine();
                    System.out.println("List of books authored by " + author + ":");
                    bs.searchForAuthor(author).displayList();
                    System.out.println();
                    break;
                    
                //displays a list of all books below a selected price.
                //scan is type safe and will continue to prompt until an appropriate value is recieved
                case 6:
                    double price = ScanHelper.promptScanNextDouble("Please enter a maximum price.", 0.0);
                    System.out.println("List of books less than " + dollarFormat.format(price) + ".");
                    bs.searchForPrice(price).displayList();
                    System.out.println();
                    break;
                    
                //Lists all of the books whose titles contain the recieved title or keyword
                case 7:
                    System.out.println("Please enter a book title or keyword to look for.");
                    String title3 = scan.nextLine();
                    System.out.println("List of books containing \"" + title3 + "\":");
                    bs.searchForTitle(title3).displayList();
                    System.out.println();
                    break;
                    
                //Lists all books with isHardcover = true
                case 8:
                    System.out.println("List of hardcover books:");
                    bs.searchHardcover().displayList();
                    System.out.println();
                    break;
                    
                //Lists all books with isHardcover = false
                case 9:
                    System.out.println("List of softcover books:");
                    bs.searchSoftcover().displayList();
                    System.out.println();
                    break;
                    
                //Prompts user and requires a long that is 10 or 13 digits long.  will reprompt until a safe value is recieved
                //if we have a book with that ISBN the book is printed out.  otherwise, the user is notified that we do not have it.
                case 10:
                    long iSBN = ScanHelper.promptScanNextLong("Please enter the ISBN of your book.", 1000000000L, 9999999999L, 1000000000000L, 9999999999999L);
                    Book b = bs.searchISBN(iSBN);
                    if(b == null)
                    {
                        System.out.println("We do not have any books with that ISBN.\n");
                    }
                    else
                    {
                        System.out.println("Here is the book:\n" + b.toString() + "\n");
                    }
                    break;
                    
                //Prints out the book with the lowest price
                case 11:
                    System.out.println("The cheapest book that we sell is:");
                    System.out.println(bs.getLowestPrice().toString() + "\n");
                    break;
                    
                //while statement will end and program will close
                case 12:
                    System.out.println("Thankyou for using our program.");
                    break;
            }
        }
    }
    
    private static class ScanHelper
    {
        //Prompts user to enter an int between, and including, the min and max values
        //Returns type safe int value
        private static int promptScanNextInt(int min, int max)
        {
            boolean flag = true;
            int scannedInt = 0;
            
            System.out.println("Please enter a number (" + min + " - " + max + ")");
            
            while(flag)
            {
                while(!scan.hasNextInt())
                {
                    System.out.println("Please enter a number (" + min + " - " + max + ")");
                    scan.nextLine();
                }
                
                scannedInt = scan.nextInt();
                scan.nextLine();
                
                if(scannedInt <= max && scannedInt >= min)
                {
                    flag = false;
                }
                else
                {
                    System.out.println("Please enter a number (" + min + " - " + max + ")");
                }
            }
            return scannedInt;
        }
        
        //Displays promptText
        //Returns type safe double value
        private static double promptScanNextDouble(String promptText, double min)
        {
            System.out.println(promptText);
            boolean flag = true;
            double scannedDouble = 0.0;
            
            while(flag)
            {
                while(!scan.hasNextDouble())
                {
                    System.out.println("Please enter a number.");
                    scan.nextLine();
                }
                
                scannedDouble = scan.nextDouble();
                scan.nextLine();
                
                if(scannedDouble > min)
                {
                    flag = false;
                }
                else
                {
                    System.out.println("Please enter a number greater than " + min + ".");
                }
            }
            return scannedDouble;
        }
        
        //displays prompt text
        //returns type safe double that is either between min1 and max1 or min2 and max2
        private static long promptScanNextLong(String promptText, long min1, long max1, long min2, long max2)
        {
            System.out.println(promptText);
            boolean flag = true;
            long scannedLong = 0L;
            
            while(flag)
            {
                while(!scan.hasNextLong())
                {
                    System.out.println("Please enter a number.");
                    scan.nextLine();
                }
                
                scannedLong = scan.nextLong();
                scan.nextLine();
                
                if((scannedLong > min1 && scannedLong < max1) || (scannedLong > min2 && scannedLong < max2))
                {
                    flag = false;
                }
                else
                {
                    System.out.println("Please enter a number that is either 10 or 13 digits long.");
                }
            }
            return scannedLong;
        }
    }
}
