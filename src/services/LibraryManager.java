package services;
import models.Book;
import java.util.*;

public class LibraryManager {

    private Map<String, Book> books;

    public LibraryManager() {
        this.books = new HashMap<>();
    }

    /**
     * Adds a new book to the library.
     */
    public void addBook(String bookId, String title, String author, String genre, boolean isAvailable) {
        if (books.containsKey(bookId)) throw new IllegalArgumentException("Book ID must be unique.");
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        books.put(bookId, newBook);
        System.out.println("Book added successfully.");
    }

    /**
     * Displays all books in the library.
     */
    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            books.values().forEach(System.out::println);
        }
    }

    /**
     * Searches for a book by ID.
     */
    public Optional<Book> findBookById(String bookId) {
        return Optional.ofNullable(books.get(bookId));
    }

    /**
     * Searches for a book by Title.
     */
    public Optional<Book> findBookByTitle(String title) {
        return books.values().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }

    /**
     * Updates book details.
     */
    public void updateBook(String bookId, String newTitle, String newAuthor, boolean isAvailable) {
        if (!books.containsKey(bookId)) throw new IllegalArgumentException("Book not found.");
        Book book = books.get(bookId);
        books.put(bookId, new Book(bookId,
                newTitle.isEmpty() ? book.getTitle() : newTitle,
                newAuthor.isEmpty() ? book.getAuthor() : newAuthor,
                book.getGenre(), isAvailable));
        System.out.println("Book updated successfully.");
        System.out.println(book.getBookId());
        System.out.println(book.isAvailable());
        book.setAvailable(false);

    }

    /**
     * Deletes a book by ID.
     */
    public void deleteBook(String bookId) {
        if (books.remove(bookId) == null) {
            throw new IllegalArgumentException("Book not found.");
        }
        System.out.println("Book deleted successfully.");
    }
}
