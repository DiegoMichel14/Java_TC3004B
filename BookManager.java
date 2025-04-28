import java.util.List;

public interface BookManager {
    /**
     * Añade un libro a la colección.
     * @param book libro a añadir
     */
    void addBook(Book book);

    /**
     * Devuelve la lista de libros actuales.
     * @return lista de libros
     */
    List<Book> getBooks();

    /**
     * Busca libros por autor.
     * @param author nombre del autor
     * @return lista de libros escritos por ese autor
     */
    List<Book> findBooksByAuthor(String author);

    /**
     * Ordena los libros por título y devuelve la lista ordenada.
     * @return lista de libros ordenada por título
     */
    List<Book> sortBooksByTitle();

    /**
     * Método por defecto que imprime todos los libros en consola.
     */
    default void printAllBooks() {
        // Recorre la lista de libros y los imprime usando su toString()
        getBooks().forEach(System.out::println);
    }
}