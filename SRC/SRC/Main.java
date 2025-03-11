import model.Book;
import model.Patrons;
import model.Librarian;
import model.Bookshelf;
import java.util.Scanner;  // Usado para leer la entrada del usuario

public class Main { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Librarian librarian = new Librarian();
        Bookshelf bookshelf = new Bookshelf();
        
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Register Patron");
            System.out.println("5. Display Patrons");
            System.out.println("6. Borrow Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");
            System.out.println("10. Edit Patron");
            System.out.println("11. Search Book by Title");
            System.out.println("12. Search Patron by Name");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();  // nextInt lee el caracter de entrada y lo convierte en un int
            scanner.nextLine();  // nextLine lee hasta el final de la línea
            
            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter number of copies: ");
                    int copies = scanner.nextInt();
                    librarian.addBook(new Book(title, author, isbn, copies));
                    break;
                case 2:
                    System.out.print("Enter ISBN of book to remove: ");
                    isbn = scanner.nextLine();
                    librarian.removeBook(isbn);
                    break;
                case 3:
                    librarian.displayBooks();
                    break;
                case 4:
                    System.out.print("Enter patron name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter patron ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter patron email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter patron phone number: ");
                    String phone = scanner.nextLine();
                    librarian.registerPatron(new Patrons(name, id, email, phone));
                    break;
                case 5:
                    librarian.displayPatrons();
                    break;
                case 6:
                    System.out.print("Enter ISBN to borrow: ");
                    isbn = scanner.nextLine();
                    librarian.borrowBook(isbn);
                    break;
                case 7:
                    System.out.print("Enter ISBN to return: ");
                    isbn = scanner.nextLine();
                    librarian.returnBook(isbn);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
                case 9:
                    System.out.println("Enter ISBN of the book to edit: ");
                    isbn = scanner.nextLine();
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter new number of copies: ");
                    int newCopies = scanner.nextInt();
                    librarian.editBook(isbn, newTitle, newAuthor, newCopies);
                    break;
                case 10:
                    System.out.print("Enter Patron ID to edit: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    librarian.editPatron(id, newName, newEmail, newPhoneNumber);
                    break;
                case 11:
                    System.out.print("Enter book title to search: ");
                    String bookTitle = scanner.nextLine();
                    librarian.searchBookByTitle(bookTitle);
                    break;
                case 12:
                    System.out.print("Enter patron name to search: ");
                    String patronName = scanner.nextLine();
                    librarian.searchPatronByName(patronName);
            }
        }
    }
}