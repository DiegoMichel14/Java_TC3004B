package model;
import java.util.ArrayList;
import java.util.List;

public class Book {   // Clase libro con 4 atributos privados
    private String title; 
    private String author;
    private String ISBN;
    private int NumberCopies; 
    
    public Book(String title, String author, String ISBN, int NumberCopies) {  // Constructor libro
        this.title = title;   
        this.author = author;
        this.ISBN = ISBN;
        this.NumberCopies = NumberCopies;
    }   // El constructor asigna los parámetros dados a los atributos del objeto

    public String getTitle() {  // Métodos para regresar los atributos
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

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setNumberCopies(int NumberCopies){
        this.NumberCopies = NumberCopies;
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