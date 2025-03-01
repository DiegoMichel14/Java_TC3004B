package model;

import java.util.ArrayList;
import java.util.List;

public class Librarian {
    
    private List<Book> books = new ArrayList<>();
    private List<Patrons> patrons = new ArrayList<>();

    public void addBook(Book book) { 
        books.add(book); 
    }
    public void removeBook(String isbn) { 
        books.removeIf(b -> b.getISBN().equals(isbn)); 
    }
    public void displayBooks() { 
        books.forEach(System.out::println); 
    }
    
    public void registerPatron(Patrons patron) { 
        patrons.add(patron); 
    }
    public void displayPatrons() {
        patrons.forEach(System.out::println); 
    }
    
    public void borrowBook(String isbn) {
        for (Book book : books) {
            if (book.getISBN().equals(isbn) && book.getNumberCopies() > 0) {
                book.borrowBook();
                System.out.println("Book borrowed successfully!");
                return;
            }
        }
        System.out.println("Book unavailable!");
    }
    
    public void returnBook(String isbn) {
        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                book.returnBook();
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Invalid ISBN!");
    }


}
