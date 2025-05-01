import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


// Implementación de BookManager que gestiona una colección de libros usando lambda
public class Library implements BookManager {
    // Lista donde se almacenan los libros
    private List<Book> books;

    
    // Constructor que inicializa la lista vacía de libros.
  
    public Library() {
        this.books = new ArrayList<>();
    }

    // Utilizamos los métodos de agregar, obtener, etc . . .

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    
     //Busca libros por autor, ignorando mayúsculas/minúsculas.
    @Override
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                    .filter(b -> b.getAuthor().equalsIgnoreCase(author)) // filtra por autor
                    .collect(Collectors.toList());
    }

    
    // Ordena los libros por título alfabéticamente.
    @Override
    public List<Book> sortBooksByTitle() {
        return books.stream()
                    .sorted((b1, b2) -> b1.getTitle().compareTo(b2.getTitle())) // comparación de títulos
                    .collect(Collectors.toList());
    }

    
    //Ordena los libros por año de publicación (ascendente).
    @Override
    public List<Book> sortBooksByYearAsc() {
        return books.stream()
                    .sorted((b1, b2) -> Integer.compare(b1.getYear(), b2.getYear())) // año ascendente
                    .collect(Collectors.toList());
    }

    
    // Ordena los libros por año de publicación (descendente).
    @Override
    public List<Book> sortBooksByYearDesc() {
        return books.stream()
                    .sorted((b1, b2) -> Integer.compare(b2.getYear(), b1.getYear())) // año descendente
                    .collect(Collectors.toList());
    }

        
    // Filtra los libros publicados antes de un año dado.
    @Override
    public List<Book> findBooksPublishedBefore(int year) {
        return books.stream()
                    .filter(b -> b.getYear() < year) // sólo los años menores a year
                    .collect(Collectors.toList());
    }

    
    // Filtra los libros cuyo título contiene una subcadena (case-insensitive).
    @Override
    public List<Book> findBooksByTitleContaining(String substring) {
        return books.stream()
                    .filter(b -> b.getTitle()
                                  .toLowerCase()
                                  .contains(substring.toLowerCase())) // busca coincidencias
                    .collect(Collectors.toList());
    }
}