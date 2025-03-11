package model;

import java.util.ArrayList;
import java.util.List;

public class Patrons {
    private String name;
    private int id;
    private String email; 
    private String phoneNumber;
    private List<Book> borrowedBooks = new ArrayList<Book>();

    public Patrons(String name, int id, String email, String phoneNumber) {  // Constructor de patrons
        this.name = name;
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {  // Métodos correspondientes de la clase
        return name;
    }

    public int getId(){
        return id;
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

    public void setName(String name){
        this.name = name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public String toString(){
        return "Name: " + name + ", ID: " + id + ", Email: " + email + ", Phone: " + phoneNumber + ", Borrowed Books: " + borrowedBooks;
    }

}