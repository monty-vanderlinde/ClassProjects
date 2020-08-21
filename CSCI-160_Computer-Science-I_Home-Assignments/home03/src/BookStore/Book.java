package BookStore;

import java.text.DecimalFormat;

public class Book
{
    private String title;
    private String auther;
    private double price;
    private boolean isHardcover;
    private long iSBN;
    private final static DecimalFormat dollarFormat = new DecimalFormat("$#,##0.00");
    
    public Book( )
    {
        title = "unknown";
        auther = "unknown";
        price  = 0.0;
        isHardcover = false;
        iSBN = 1000000000L;
    }
    
    public Book( String newTitle, String newAuther, double newPrice, boolean isHardcover, long newISBN)
    {
        title = newTitle;
        auther = newAuther;
        price  = newPrice;
        this.isHardcover = isHardcover;
        
        //ISBN must be 10 or 13 digits long
        if((newISBN > 999999999L && newISBN < 10000000000L) || (newISBN > 999999999999L && newISBN < 10000000000000L))
            iSBN = newISBN;
        else
            iSBN = 1000000000L;
    }
    
    public String getTitle( )
    {
        return title;
    }
    
    public String getAuthor( )
    {
        return auther;
    }
    
    public double getPrice( )
    {
        return price;
    }
    
    public boolean getIsHardcover()
    {
        return isHardcover;
    }
    
    public long getISBN()
    {
        return iSBN;
    }
    
    //The toString formatting is used later in the program
    @Override
    public String toString( )
    {
        return ("Title:  " + title + "\t" + "Auther:  " + auther + "\t" + "Price:  " + dollarFormat.format(price) + "\t" + "Is Hardcover:  " + isHardcover + "\t" + "ISBN:  " + iSBN);
    }
    
    public boolean equals(Book book)
    {
        if(this == null && book == null)
            return true;
        else if(this == null ^ book == null)
            return false;
        else if(book.getTitle() == title && book.getAuthor() == auther && Math.abs(book.getPrice() - price) < 0.001 && book.getIsHardcover() == isHardcover && book.getISBN() == iSBN)
            return true;
        else
            return false;
    }
}