package model;

import java.util.ArrayList;
import java.util.List;
 
public class Bookshelf {  // Clase librero
    private List<Book> books = new ArrayList<>();
    
    public void addBook(Book book) {  // Métodos para regresar atributos
        books.add(book);
    }

    public void removeBook(String isbn) {  // Para eliminar un libro usamos un ciclo for inverso
        for(int i = books.size() - 1; i >= 0; i--) { // De esa forma los índices previos al eliminado no se ven afectados
            if (books.get(i).getISBN().equals(isbn)) {  // Comparamos el contenido con equals para cumplir la condición de borrar
                books.remove(i);
            }
        }
    }

    public void displayBooks() {
        books.forEach(System.out::println);
    }
}