package model;

import java.util.ArrayList;
import java.util.List;

public class Librarian {   // Clase librarian con atributos y métodos correspondientes
    
    private List<Book> books = new ArrayList<>();
    private List<Patrons> patrons = new ArrayList<>();

    public void addBook(Book book) { 
        books.add(book); 
    }

    public void editBook(String isbn, String newTitle, String newAuthor, int newNumberCopies){
        for (Book book : books){
            if (book.getISBN().equals(isbn)){
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                book.setNumberCopies(newNumberCopies);
                System.out.println("Book details updated successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void removeBook(String isbn) {  // Para eliminar un libro usamos un ciclo for inverso
        for (int i = books.size() - 1; i >= 0; i--) {  // De esa forma los índices previos al eliminado no se ven afectados
            if (books.get(i).getISBN().equals(isbn)) {
                books.remove(i);
            }
        }
    }

    public void displayBooks() { 
        books.forEach(System.out::println); 
    }
    
    public void registerPatron(Patrons patron) { 
        patrons.add(patron); 
    }

    public void editPatron(int id, String newName, String newEmail, String newPhoneNumber){
        for (Patrons patron : patrons){
            if (patron.getId() == id){
                patron.setName(newName);
                patron.setEmail(newEmail);
                patron.setPhoneNumber(newPhoneNumber);
                System.out.println("Patron details update successfully");
                return;
            }
        }
        System.out.println("Patron not found!");
    }

    public void displayPatrons() {
        patrons.forEach(System.out::println); 
    }
    
    public void borrowBook(String isbn) {
        for (Book book : books) {  // Recorremos cada objeto de tipo book dentro de la lista books
            if (book.getISBN().equals(isbn) && book.getNumberCopies() > 0) {
                book.borrowBook();  // Método de la clase book
                System.out.println("Book borrowed successfully!");
                return;
            }
        }
        System.out.println("Book unavailable!");
    }

    public void searchBookByTitle(String title){
        for (Book book : books){
            if (book.getTitle().equalsIgnoreCase(title)){
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void searchPatronByName(String name){
        for (Patrons patron : patrons){
            if (patron.getName().equalsIgnoreCase(name)){
                System.out.println(patron);
                return;
            }
        }
        System.out.println("Patron not found!");
    }

    public void returnBook(String isbn) {
        for (Book book : books) {  // Recorremos cada objeto de tipo book dentro de la lista books
            if (book.getISBN().equals(isbn)) {
                book.returnBook();  // Método de la clase book
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Invalid ISBN!");
    }
}