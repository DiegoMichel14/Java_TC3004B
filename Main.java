import java.util.List;
import java.util.Scanner;


// Menú de la biblioteca.
// Permite agregar libros, buscar por autor, ordenar y salir.

public class Main {
    public static void main(String[] args) {
        Library library = new Library();       // Colección de libros
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Bucle principal del menú
        while (!exit) {
            System.out.println("\n=== Menú de Biblioteca ===");
            System.out.println("1. Agregar nuevo libro");
            System.out.println("2. Encontrar libros por autor");
            System.out.println("3. Ordenar libros");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":  // Añadimos un libro nuevo
                    // Elegir tipo de libro de libro a añadir
                    System.out.print("¿Es un EBook? (s/n): ");
                    String tipo = scanner.nextLine().trim().toLowerCase();
                    System.out.print("Título: ");
                    String title = scanner.nextLine();
                    System.out.print("Autor: ");
                    String author = scanner.nextLine();
                    System.out.print("Año de publicación: ");
                    int year = Integer.parseInt(scanner.nextLine());

                    if (tipo.equals("s") || tipo.equals("si")) {
                        // Datos adicionales para EBook
                        System.out.print("Tamaño de archivo (MB): ");
                        double size = Double.parseDouble(scanner.nextLine());
                        library.addBook(new EBook(title, author, year, size));
                        System.out.println("EBook agregado.");
                    } else {
                        library.addBook(new Book(title, author, year));
                        System.out.println("Libro físico.");
                    }
                    break;

                case "2":
                    // Buscamos libros por autor
                    System.out.print("Autor a buscar: ");
                    String searchAuthor = scanner.nextLine();
                    List<Book> results = library.findBooksByAuthor(searchAuthor);
                    if (results.isEmpty()) {
                        System.out.println("No se encontraron libros de ese autor.");
                    } else {
                        System.out.println("Libros encontrados:");
                        results.forEach(System.out::println);
                    }
                    break;

                case "3":
                    // Sub-menú de ordenamiento por título o años
                    System.out.println("\n-- Submenú de Ordenamiento --");
                    System.out.println("a. Por título");
                    System.out.println("b. Por año ascendente");
                    System.out.println("c. Por año descendente");
                    System.out.print("Selecciona una opción: ");
                    String sortOption = scanner.nextLine().toLowerCase();

                    List<Book> sorted;
                    switch (sortOption) {
                        case "a":
                            sorted = library.sortBooksByTitle();
                            System.out.println("Libros ordenados por título:");
                            break;
                        case "b":
                            sorted = library.sortBooksByYearAsc();
                            System.out.println("Libros ordenados por año ascendente:");
                            break;
                        case "c":
                            sorted = library.sortBooksByYearDesc();
                            System.out.println("Libros ordenados por año descendente:");
                            break;
                        default:
                            System.out.println("Opción de ordenamiento inválida.");
                            continue;
                    }
                    sorted.forEach(System.out::println);
                    break;

                case "4":
                    // 4) Salir del programa
                    exit = true;
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    // Opción no reconocida
                    System.out.println("Opción inválida, intenta de nuevo.");
            }
        }

        scanner.close();
    }
}