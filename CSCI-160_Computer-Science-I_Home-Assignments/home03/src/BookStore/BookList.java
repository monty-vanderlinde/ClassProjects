package BookStore;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookList implements Iterable<Book>
{

    private Book[] bookList;
    private int bookArraySize;

    //empty array
    public BookList()
    {
        bookArraySize = 0;
        bookList = new Book[bookArraySize];
    }
    
    //bookArraySize should always equal lenght of bookList array
    public BookList(Book[] newBookList)
    {
        bookArraySize = newBookList.length;
        bookList = new Book[bookArraySize];
        for(int i = 0; i < bookArraySize; i++)
        {
            bookList[i] = newBookList[i];
        }
    }

    public int getSize()
    {
        return bookArraySize;
    }
    
    //adds an empty spot at the end of the array and fills it with the new book
    public void add(Book book)
    {
        ensureCapcity();
        bookList[bookArraySize - 1] = book;
    }
    
    //creates new array with 1 less index.  moves any valuse over so that they fit
    //specified book is permanently removed
    public void remove(Book book)
    {
        if(bookArraySize != 0)
        {
            int index = -1;
            for (int i = 0; i < bookArraySize; i++)
            {
                if (bookList[i].equals(book))
                {
                    index = i;
                    break;
                }
            }
            
            if (index >= 0 && index < bookArraySize)
            {
                trimToSize(index);
            }
            else if(index != -1)
                System.out.println("Remove method index out of bounds.");
        }
    }
    
    //returns a copy of the book at the index
    public Book getBook(int index)
    {
        if (index >= 0 && index < bookArraySize)
        {
            return new Book(bookList[index].getTitle(), bookList[index].getAuthor(), bookList[index].getPrice(), bookList[index].getIsHardcover(), bookList[index].getISBN());
        }else
        {
            System.out.println("BookList index out of bounds.  Returned null.");
            return null;
        }
    }
    //removes the book at the index and moves the other books over.  returns an array that has one less index
    private void trimToSize(int index)
    {
        Book[] tempBookList = new Book[bookArraySize - 1]; 
        for(int j = 0; j < index; j++)
        {
            tempBookList[j] = bookList[j];
        }
        
        for (int i = index; i < bookList.length - 1; i++)
        {
            tempBookList[i] = bookList[i + 1];
        }
        bookArraySize--;
        bookList = tempBookList;
    }
    
    //adds an index to the end of the array.  returns new array
    private void ensureCapcity()
    {
        if (bookArraySize == bookList.length)
        {
            Book temp[] = new Book[bookList.length + 1];
            for (int i = 0; i < temp.length - 1; i++)
            {
                temp[i] = bookList[i];
            }
            bookList = temp;
            bookArraySize++;
        }else
        {
            System.out.println("Error occured:  bookArraySize is not the size of the array");
        }
    }
    
    //prints out the list of books to the consol
    public void displayList()
    {
        for (int i = 0; i < bookArraySize; i++)
        {
            System.out.println(bookList[i].toString());
        }
    }
    
    //sorts the given list alphabetically by title
    public void sortList()
    {
        for(int i = bookArraySize - 1; i > 0; i--)
        {
            for(int j = 0; j < i; j++)
            {
                if(bookList[j] == null)
                {
                    bookList[j] = bookList[j + 1];
                    bookList[j + 1] = null;
                }
                else if(bookList[j + 1] == null);
                else if(0 < bookList[j].getTitle().compareToIgnoreCase(bookList[j + 1].getTitle()))
                {
                    Book tempBook = bookList[j];
                    bookList[j] = bookList[j + 1];
                    bookList[j + 1] = tempBook;
                }
            }
        }
    }
    
    //overrides equals method.  Is safe to use if a null value may be given
    public boolean equals(BookList b)
    {
        if(this == null && b == null)
            return true;
        else if(this == null || b == null)
            return false;
        else if(bookArraySize != b.getSize())
            return false;
        else
        {
            for(int i = 0; i < bookArraySize; i++)
            {
                if(bookList[i] == null && b.getBook(i) == null);
                else if(bookList[i] == null || b.getBook(i) == null)
                    return false;
                else if(!(bookList[i].equals(b.getBook(i))))
                    return false;
            }
        }
        return true;
    }

    /**
     * Private inner class to allow the use of enhanced for loop with the
     * BookList class
     *
     * You should copy this code into your BookList class. Make sure that it is
     * not inside of other methods or it will not work correctly.
     *
     * You will also need to make sure that your BookList class implements the
     * Iterable interface and uses the Book type for the type parameter
     * (implements Iterable<Book>)
     *
     * When overriding the iterator() method that you need to implement, you can
     * return an instance of the BookIterator class by calling its constructor
     * method.
     */
    private class BookIterator implements Iterator<Book>
    {

        private int cursor;  // Index position for the current Book

        /**
         * Creates a new Iterator for this BookList
         */
        public BookIterator()
        {
            this.cursor = 0; // Set the cursor to the front of the array
        }

        @Override
        public boolean hasNext()
        {
            return this.cursor < bookArraySize; // Determine if the next index position is valid
        }

        @Override
        public Book next()
        {
            if (this.hasNext())
            {
                int current = cursor; // Save the current cursor position
                cursor++;             // Move the cursor over by one
                return bookList[current]; // Return the Book at the old cursor position
            }
            throw new NoSuchElementException(); // Attempted to get a non-exist Book
        }

    }

    @Override
    public Iterator<Book> iterator()
    {
        return new BookIterator();
    }
}
