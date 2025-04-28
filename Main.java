public class Main {
    public static void main(String[] args) {
        // Creamos la biblioteca
        Library library = new Library();

        // Añadimos libros 
        library.addBook(new Book("Mi autobiografía", "Diego Michel Castro", 2025));
        library.addBook(new Book("El Señor de los Anillos", "J.R.R. Tolkien", 1954));
        library.addBook(new Book("Don Quijote de la Mancha", "Miguel de Cervantes", 1605));
        library.addBook(new Book("Percy Jackson", "Rick Riordan", 2005));
        library.addBook(new Book("El Código Da Vinci", "Dan Brown", 2003));

        // Mostramos todos los libros sin orden
        System.out.println("=== Todos los libros ===");
        library.getBooks().forEach(System.out::println);

        // Buscamos libros por autor
        System.out.println("\n=== Libros de 'Dan Brown' ===");
        library.findBooksByAuthor("Dan Brown")
               .forEach(System.out::println);

        // Mostramos libros ordenados por título
        System.out.println("\n=== Libros ordenados por título ===");
        library.sortBooksByTitle()
               .forEach(System.out::println);

        // Usamos el método por defecto de la interfaz
        System.out.println("\n=== Usando printAllBooks() ===");
        library.printAllBooks();
    }
}