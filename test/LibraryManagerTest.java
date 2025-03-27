
import org.junit.jupiter.api.Test;
import services.LibraryManager;
import static org.junit.jupiter.api.Assertions.*;
public class LibraryManagerTest {
    @Test
    void testAddBook() {
        LibraryManager library = new LibraryManager();
        library.addBook("101", "Java Programming", "John Doe", "Education", true);
        assertTrue(library.findBookById("101").isPresent());
    }

    @Test
    void testDeleteBook() {
        LibraryManager library = new LibraryManager();
        library.addBook("102", "Python Basics", "Jane Doe", "Education", true);
        library.deleteBook("102");
        assertFalse(library.findBookById("102").isPresent());
    }
}
