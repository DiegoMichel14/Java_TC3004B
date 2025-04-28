public class Book {
    private String title;
    private String author;
    private int year;

    /**
     * Constructor de Book
     * @param title  título del libro
     * @param author autor del libro
     * @param year   año de publicación
     */
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Obtiene el título del libro
    public String getTitle() {
        return title;
    }

    // Modifica el título del libro
    public void setTitle(String title) {
        this.title = title;
    }

    // Obtiene el autor del libro
    public String getAuthor() {
        return author;
    }

    // Modifica el autor del libro
    public void setAuthor(String author) {
        this.author = author;
    }

    // Obtiene el año de publicación
    public int getYear() {
        return year;
    }

    // Modifica el año de publicación
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Representación en texto del libro.
     * Formato: "Título — Autor (Año)"
     */
    @Override
    public String toString() {
        return String.format("%s - %s (%d)", title, author, year);
    }
}
