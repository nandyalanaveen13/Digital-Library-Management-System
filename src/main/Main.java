package main;
import services.LibraryManager;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Book  2. View Books  3. Search by ID  4. Search by Title");
            System.out.println("5. Update Book  6. Delete Book  7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Book ID: "); String id = scanner.nextLine();
                        System.out.print("Title: "); String title = scanner.nextLine();
                        System.out.print("Author: "); String author = scanner.nextLine();
                        System.out.print("Genre: "); String genre = scanner.nextLine();
                        System.out.print("Available (true/false): "); boolean available = scanner.nextBoolean();
                        library.addBook(id, title, author, genre, available);
                    }
                    case 2 -> library.viewAllBooks();
                    case 3 -> {
                        System.out.print("Enter Book ID: ");
                        library.findBookById(scanner.nextLine()).ifPresent(System.out::println);
                    }
                    case 4 -> {
                        System.out.print("Enter Title: ");
                        library.findBookByTitle(scanner.nextLine()).ifPresent(System.out::println);
                    }
                    case 5 -> {
                        System.out.print("Enter Book ID to update: ");
                        String id = scanner.nextLine();
                        System.out.print("New Title (or Enter to skip): ");
                        String title = scanner.nextLine();
                        System.out.print("New Author (or Enter to skip): ");
                        String author = scanner.nextLine();
                        System.out.print("Available (true/false): ");
                        boolean available = scanner.nextBoolean();
                        library.updateBook(id, title, author, available);
                    }
                    case 6 -> {
                        System.out.print("Enter Book ID to delete: ");
                        library.deleteBook(scanner.nextLine());
                    }
                    case 7 -> { scanner.close(); return; }
                    default -> System.out.println("Invalid option. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
