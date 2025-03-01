package model;

import java.util.ArrayList;
import java.util.List;

public class Patrons {
    private String name;
    private int id;
    private String email;
    private String phoneNumber;
    private List<Book> borrowedBooks = new ArrayList<Book>();

    public Patrons(String name, int id, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}
