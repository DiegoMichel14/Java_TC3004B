package model;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int NumberCopies;
    
    public Book(String title, String author, String ISBN, int NumberCopies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.NumberCopies = NumberCopies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getNumberCopies() {
        return NumberCopies;
    }

    public void borrowBook() {
        if (NumberCopies > 0) {
            NumberCopies--;
        }
    }

    public void returnBook() {
        NumberCopies++;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + ISBN + ") - Copies: " + NumberCopies;
    }
}