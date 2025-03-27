package models;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    /**
     * Constructs a new Book with validation.
     * @param bookId Unique identifier for the book.
     * @param title  Title of the book.
     * @param author Author of the book.
     * @param genre  Genre of the book.
     * @param isAvailable Availability status of the book.
     */
    public Book(String bookId, String title, String author, String genre, boolean isAvailable) {
        if (bookId == null || bookId.isEmpty()) throw new IllegalArgumentException("Book ID cannot be empty.");
        if (title == null || title.isEmpty()) throw new IllegalArgumentException("Title cannot be empty.");
        if (author == null || author.isEmpty()) throw new IllegalArgumentException("Author cannot be empty.");

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }

    // Getters & Setters
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean available) { this.isAvailable = available; }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %s",
                bookId, title, author, genre, (isAvailable ? "Available" : "Checked Out"));
    }
}
