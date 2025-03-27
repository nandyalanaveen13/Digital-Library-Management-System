package models;

public class Book {
    private final String bookId;
    private final String title;
    private final String author;
    private final String genre;
    private boolean isAvailable;

    /**
     * Constructs a new Book.
     * @param bookId Unique identifier for the book.
     * @param title Title of the book.
     * @param author Author of the book.
     * @param genre Genre of the book.
     * @param isAvailable Availability status of the book.
     */
    public Book(String bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }

    // Getter methods
    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setter method to update availability status
    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // Display book details
    public void displayBookInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Genre: " + genre);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        // Test the Book class
        Book book = new Book("10", "Java Basics", "Naveen", "Programming", true);

        // Display book information
        book.displayBookInfo();

        // Check availability
        System.out.println("Is Available? " + book.isAvailable());

        // Print book ID (to remove IntelliJ warning)
        System.out.println("Book ID: " + book.getBookId());

        // Update availability
        book.setAvailability(false);
        System.out.println("Updated Availability: " + book.isAvailable());
    }
}
