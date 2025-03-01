package model;

import java.util.ArrayList;
import java.util.List;

public class Bookshelf {
    private List<Book> books = new ArrayList<>();
    
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String isbn) {
        books.removeIf(b -> b.getISBN().equals(isbn));
    }

    public void displayBooks() {
        books.forEach(System.out::println);
    }
}