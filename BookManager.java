import java.util.List;

public interface BookManager {
    void addBook(Book book);  // Métodos para obtener, sortear y agregar un objeto libro
    List<Book> getBooks();
    List<Book> findBooksByAuthor(String author);
    List<Book> sortBooksByTitle();
    List<Book> sortBooksByYearAsc();
    List<Book> sortBooksByYearDesc();

    // Filtra los libros publicados antes de un año dado
    List<Book> findBooksPublishedBefore(int year);

    // Filtra los libros cuyo título contiene una subcadena (case-insensitive)
    List<Book> findBooksByTitleContaining(String substring);

    default void printAllBooks() {
        getBooks().forEach(System.out::println);
    }
}