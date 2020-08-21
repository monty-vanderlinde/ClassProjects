package BookStore;

import java.util.Scanner;

public class BookStore
{

    private String name;
    private BookList library;

    public BookStore()
    {
        name = "Java Store";
        library = new BookList();
        library.add(new Book("Java Servlets", "Brown", 75.99, false, 9718637815L));
        library.add(new Book("Advanced HTML", "Green", 56.99, true, 9716588420L));
        library.add(new Book("Advanced Java", "Green", 65.99, false, 9103618489L));
        library.add(new Book("Intro to Flash", "James", 34.49, false, 9415873097852L));
        library.add(new Book("Intro to HTML", "James", 29.49, false, 9810057820397L));
        library.add(new Book("Intro to Java", "James", 56.99, true, 9563478103957L));
    }
    
    public BookStore(String name, BookList bookList)
    {
        this.name = name;
        library = bookList;
    }

    public String getName()
    {
        return name;
    }
    
    //prints out a list of all of the books, one book per line
    @Override
    public String toString()
    {
        String result = "";
        for (Book tempBook : library)
        {
            result += tempBook.toString() + "\n";
        }
        return result;
    }
    
    //returns author of a book that is searched.  is not case sensitive.  must be the whole title
    public String lookUpAuthor(String searchBook)
    {
        if(searchBook != null)
        {
            for(Book currentBook : library)
            {
                if (searchBook.toLowerCase().equals(currentBook.getTitle().toLowerCase()))
                {
                    return currentBook.getAuthor();
                }
            }
        }
        return "Not Found.  Please make sure that this book exists";
    }
    
    //returns the price of a book that is searched.  is not case sensitive.  must be the whole title
    public double lookUpPrice(String searchBook)
    {
        if(searchBook != null)
        {
            for(Book currentBook : library)
            {
                if (searchBook.toLowerCase().equals(currentBook.getTitle().toLowerCase()))
                {
                    return currentBook.getPrice();
                }
            }
        }
        return Double.NaN;
    }
    
    //searches for books that contain the searchString in the title.  returns a booklist of applicable books
    public BookList searchForTitle(String searchString)
    {
        BookList searchResult = new BookList();
        if(searchString != null)
        {
            for (Book currentBook : library)
            {
                if (currentBook.getTitle().toLowerCase().contains(searchString.toLowerCase()))
                {
                    searchResult.add(currentBook);
                }
            }
        }
        return searchResult;
    }
    //searches for books whose author's name is or contains searchString.  returns a booklist of applicable books
    public BookList searchForAuthor(String searchString)
    {
        BookList searchResult = new BookList();
        if(searchString != null)
        {
            for (Book currentBook : library)
            {
                if (currentBook.getAuthor().toLowerCase().contains(searchString.toLowerCase()))
                {
                    searchResult.add(currentBook);
                }
            }
        }
        return searchResult;
    }
    
    //searches for books that are less than or equal to the max price.  returns a booklist of applicable books
    public BookList searchForPrice(double max)
    {
        BookList searchResult = new BookList();
        if(max > 0.0)
        {
            for (Book currentBook : library)
            {
                if (currentBook.getPrice() <= max)
                {
                    searchResult.add(currentBook);
                }
            }
        }
        return searchResult;
    }
    
    //searches for all books where isHardcover is true.  returns a booklist of applicable books
    public BookList searchHardcover()
    {
        BookList searchResult = new BookList();
        for (Book currentBook : library)
        {
            if (currentBook.getIsHardcover() == true)
            {
                searchResult.add(currentBook);
            }
        }
        return searchResult;
    }
    
    //searches for all books where isHardcover is false.  returns a booklist of applicable books
    public BookList searchSoftcover()
    {
        BookList searchResult = new BookList();
        for (Book currentBook : library)
        {
            if (currentBook.getIsHardcover() == false)
            {
                searchResult.add(currentBook);
            }
        }
        return searchResult;
    }
    
    //returns a copy of a book with the given isbn.  if that books is not in the BookStore, then null is returned
    public Book searchISBN(long iSBN)
    {
        if((iSBN > 999999999L && iSBN < 10000000000L) || (iSBN > 999999999999L && iSBN < 10000000000000L))
        {
            for(Book currentBook : library)
            {
                if(currentBook.getISBN() == iSBN)
                {
                    return new Book(currentBook.getTitle(), currentBook.getAuthor(), currentBook.getPrice(), currentBook.getIsHardcover(), currentBook.getISBN());
                }
            }
        }
        return null;
    }
    
    // returns a copy of the cheapest book in the store
    public Book getLowestPrice()
    {
        if(library.getSize() == 0)
            return null;
        Book lowestPriceBook = library.getBook(0);
        for(int i = 1; i < library.getSize(); i++)
        {
            if(lowestPriceBook.getPrice() > library.getBook(i).getPrice())
            {
                lowestPriceBook = library.getBook(i);
            }
        }
        
        return new Book(lowestPriceBook.getTitle(), lowestPriceBook.getAuthor(), lowestPriceBook.getPrice(), lowestPriceBook.getIsHardcover(), lowestPriceBook.getISBN());
    }
    
    //returns a copy of the entire booklist that has been sorted alphabetically
    public BookList getSortedBookList()
    {
        BookList temp = library;
        temp.sortList();
        return temp;
    }
}
