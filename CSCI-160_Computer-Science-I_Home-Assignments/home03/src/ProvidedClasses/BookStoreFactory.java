package ProvidedClasses;

import BookStore.Book;
import BookStore.BookList;
import BookStore.BookStore;


public class BookStoreFactory 
{
    private BookStoreFactory()
    {
        
    }
    
    public static BookStore getBookStoreInstance()
    {
        BookStore store = new BookStore("The Shop Around The Corner", getBookCollectionInstance());
        
        return store; 
    }
    
    public static BookList getBookCollectionInstance()
    {
        BookList list = new BookList();
        
        list.add(new Book("Don Quixote", "Miguel de Cervantes", 27.99, true, 9788899447687L));
        list.add(new Book("Catch-22", "Joseph Heller", 19.95, false, 9780099529118L));
        list.add(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 17.85, false, 9780517693117L)); 
        list.add(new Book("Anna Karenina", "Leo Tolstoy", 27.99, true, 9788617048806L));
        list.add(new Book("The Catcher in the Rye", "J. D. Salinger", 14.99, false, 9781439576649L));
        list.add(new Book("Pride and Prejudice", "Jane Austen", 19.95, false, 9788020014085L));
        list.add(new Book("A Tale of Two Cities", "Charles Dickens", 9.95, true, 9781534968998L));
        list.add(new Book("I, Robot", "Issac Asimov", 9.95, true, 9780007491513L));
        list.add(new Book("Oliver Twist", "Charles Dickens", 13.99, true, 9788702015775L));
        list.add(new Book("A Study in Scarlet", "Arthur Conan Doyle", 8.95, false, 9783526522362L));
        list.add(new Book("The Count of Monte Cristo", "Alexandre Dumas", 22.95, false, 9788673881126L));
        list.add(new Book("The Moon is a Harsh Mistress", "Robert Heinlein", 9.95, false, 9780425075715L)); 
        list.add(new Book("The Hobbit", "J. R. R. Tolkein", 14.99, false, 9780582186552L));
        list.add(new Book("A Pocket Full of Rye", "Agatha Christie", 14.99, true, 9780671702663L));
        list.add(new Book("Ringworld", "Larry Niven", 19.95, false, 9780345260093L));
        list.add(new Book("Harry Potter and the Goblet of Fire", "J. K. Rowling", 27.99, true, 9780747549710L));
        list.add(new Book("A Wrinkle in Time", "Madeleine L'Engle", 14.95, true, 9780439572897L)); 
        list.add(new Book("War and Peace", "Leo Tolstoy", 27.99, false, 9785040000531L));
        list.add(new Book("Dragonflight", "Anne McCaffrey", 17.95, false, 9788677100131L)); 
        list.add(new Book("Treasure Island", "Robert Louis Stevenson", 7.95, true, 9783958551114L)); 
        list.add(new Book("Flowers for Algernon", "Daniel Keyes", 13.95, false, 9780575400207L)); 
        
        return list;    
    }
    
}
