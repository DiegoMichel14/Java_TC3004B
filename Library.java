import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library implements BookManager {
    // Lista interna donde guardamos los libros
    private List<Book> books;

    /**
     * Constructor: inicializa la lista vacía.
     */
    public Library() {
        this.books = new ArrayList<>();
    }

    /**
     * Añade un libro a la colección.
     * @param book libro a añadir
     */
    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Devuelve todos los libros almacenados.
     * @return lista de libros
     */
    @Override
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Busca libros que su autor coincide.
     * @param author nombre del autor a buscar
     * @return lista de libros de ese autor
     */
    @Override
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                    // Lambda para filtrar por autor
                    .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                    .collect(Collectors.toList());
    }

    /**
     * Ordena los libros por título alfabéticamente y devuelve la lista ordenada.
     * @return lista de libros ordenada por título
     */
    @Override
    public List<Book> sortBooksByTitle() {
        return books.stream()
                    .sorted((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()))  // ← Lambda
                    .collect(Collectors.toList());
    }

    // El método por defecto printAllBooks() ya viene en la interfaz BookManager
}